/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec.transformation

import com.google.inject.Inject
import java.util.ArrayList
import java.util.Collection
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.sct.model.sexec.ExecutionChoice
import org.yakindu.sct.model.sexec.ExecutionEntry
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.ExecutionSynchronization
import org.yakindu.sct.model.sexec.Reaction
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sgraph.Choice
import org.yakindu.sct.model.sgraph.Effect
import org.yakindu.sct.model.sgraph.Entry
import org.yakindu.sct.model.sgraph.Pseudostate
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Synchronization
import org.yakindu.sct.model.sgraph.Transition
import org.yakindu.sct.model.sgraph.Trigger
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.stext.stext.AlwaysEvent
import org.yakindu.sct.model.stext.stext.DefaultTrigger
import org.yakindu.sct.model.stext.stext.LocalReaction
import org.yakindu.sct.model.stext.stext.ReactionEffect
import org.yakindu.sct.model.stext.stext.ReactionTrigger
import org.yakindu.sct.model.stext.stext.RegularEventSpec
import org.yakindu.sct.model.stext.stext.TimeEventSpec

class BehaviorMapping {

	@Inject extension StatechartExtensions sc
	@Inject extension StextExtensions stext
	@Inject extension SexecExtensions sexec
	@Inject extension SexecElementMapping factory
	@Inject extension SgraphExtensions sgraph
	@Inject extension TraceExtensions trace
	@Inject extension SequenceBuilder sb
	
	@Inject protected extension ExpressionBuilder exprBuilder


	def ExecutionFlow mapEntryActions(Statechart statechart, ExecutionFlow r){
		val seq = sexec.factory.createSequence
		seq.name = "entryAction"
		seq.comment = "Entry action for statechart '" + statechart.name + "'."
		
		for (tes : statechart.timeEventSpecs ) {
			val timeEvent = tes.createDerivedEvent
			val scheduleStep = timeEvent.newScheduleTimeEvent(tes.buildValueExpression)
			seq.steps.add(scheduleStep)
		}	
		
		statechart.entryReactions
			.map([lr | lr.mapEntryAction ])
			.forEach(e | if (e !== null) { seq.steps.add(e) })
		
		r.entryAction = seq
		
		val allStates = statechart.allRegularStates.filter(typeof(State))
		allStates.forEach( s | { s.create.entryAction = s.mapEntryAction()  } )
		return r
	}

	/** 
	 * The entry action sequence of a state consist all action that are specified with the 'entry' pseudo trigger within local reactions
	 * and all scheduling actions for time triggers.
	 */
	def Step mapEntryAction(State state) {
		val seq = sexec.factory.createSequence
		seq.name = "entryAction"
		seq.comment = "Entry action for state '" + state.name + "'."
		
		for (tes : state.timeEventSpecs ) {
			val timeEvent = tes.createDerivedEvent
			val scheduleStep = timeEvent.newScheduleTimeEvent(tes.buildValueExpression)
			seq.steps.add(scheduleStep)
		}	
		
		state.entryReactions
			.map([lr | lr.mapEntryAction ])
			.forEach(e | if (e !== null) { seq.steps.add(e) })
		
		if (seq.steps.size > 0) seq else null
	}	

	def Step mapEntryAction(LocalReaction it) {
		if (effect !== null) { 
			var effectSeq = (effect as ReactionEffect).mapEffect
			var guard =  trigger.buildGuard
			
			if ( guard !== null ) {			
				var ifStep = sexec.factory.createIf
				ifStep.check = sexec.factory.createCheck
				ifStep.check.condition = guard		
				ifStep.thenStep = effectSeq
				ifStep as Step	
			} else effectSeq
			
		} else null
	}
	
	def ExecutionFlow mapChoiceTransitions(Statechart statechart, ExecutionFlow r) {
		statechart.allChoices.forEach( choice | choice.mapChoiceTransition);		
		return r
	}

	def ExecutionChoice mapChoiceTransition(Choice choice) {
		val _choice = choice.create
		_choice.reactions.addAll( choice.outgoingTransitions.map(t | t.mapTransition) )
		return _choice
	}

	def ExecutionFlow mapSyncTransitions(Statechart statechart, ExecutionFlow r) {
		statechart.allSynchronizations.forEach( sync | sync.mapSyncTransition);		
		return r
	}

	def ExecutionSynchronization mapSyncTransition(Synchronization sync) {
		val _sync = sync.create
		val transitions = sync.outgoingTransitions
		val r = transitions.head.create
		_sync.reactions.add(r)
		
		// map multiple transitions to one reaction
		r.effect = transitions.mapToEffect(r)
		
		return _sync
	}

	def ExecutionFlow mapExitActions(Statechart statechart, ExecutionFlow r){
		val seq = sexec.factory.createSequence
		seq.name = "exitAction"
		seq.comment = "Exit action for state '" + statechart.name + "'."
		
		
		for (tes : statechart.timeEventSpecs ) {
			val timeEvent = tes.createDerivedEvent
			val unscheduleStep = timeEvent.newUnscheduleTimeEvent()
			seq.steps.add(unscheduleStep)
		}	
		
		statechart.exitReactions
			.map([lr | lr.mapExitAction()])
			.forEach(e | if (e !== null) { seq.steps.add(e) })
		
		r.exitAction = seq
		
		val allStates = statechart.allRegularStates.filter(typeof(State))
		allStates.forEach( s | { s.create.exitAction = s.mapExitAction() } )
		return r
	}

	/** 
	 * The exit action sequence of a state consist all action that are specified with the 'exit' pseudo trigger within local reactions
	 * and all unscheduling actions for time triggers.
	 */
	def Step mapExitAction(State state) {
		val seq = sexec.factory.createSequence
		seq.name = "exitAction"
		seq.comment = "Exit action for state '" + state.name + "'."
		
		
		for (tes : state.timeEventSpecs ) {
			val timeEvent = tes.createDerivedEvent
			val unscheduleStep = timeEvent.newUnscheduleTimeEvent()
			seq.steps.add(unscheduleStep)
		}	
		
		state.exitReactions
			.map([lr | lr.mapExitAction()])
			.forEach(e | if (e !== null) { seq.steps.add(e) })
		
		if (seq.steps.size > 0) seq else null
	}


	def Step mapExitAction(LocalReaction it) {
		if (effect !== null) { 
			var effectSeq = (effect as ReactionEffect).mapEffect
			var guard =  trigger.buildGuard
			
			if ( guard !== null ) {			
				var ifStep = sexec.factory.createIf
				ifStep.check = sexec.factory.createCheck
				ifStep.check.condition = guard		
				ifStep.thenStep = effectSeq
				ifStep as Step	
			} else effectSeq
			
		} else null
	}
	
		
	def dispatch Sequence mapEffect(Effect effect) {}
	
	def dispatch Sequence mapEffect(ReactionEffect effect) {
		if ( ! effect.actions.empty) {
			val sequence = sexec.factory.createSequence
			sequence.name = effect.reaction.id()
			sequence.steps.addAll( effect.actions.map( stmnt | stmnt.mapToExecution))
			return sequence	
		}	
	}
	
	def Execution mapToExecution(Expression stmnt) {
		val exec = sexec.factory.createExecution
		exec.statement = EcoreUtil::copy(stmnt)
		exec
	}
	
	def ExecutionFlow mapTransitions(Statechart statechart, ExecutionFlow r){
		var content = statechart.eAllContents
		val allStates = content.filter(typeof(State))
		allStates.forEach( s | s.mapStateTransition);
		return r
	}


	def ExecutionState mapStateTransition(State state) {
		val _state = state.create
		_state.reactions.addAll( state.outgoingTransitions.map(t | t.mapTransition))
		return _state
	}
	 
	def Reaction mapTransition(Transition t) {
		return mapTransition(t, t.source, t.target);
	}
	
	
	def dispatch Reaction mapTransition(Transition t, Vertex source, Vertex target) {
		val r = t.create 
		if (t.trigger !== null) r.check = mapToCheck(t.trigger)
		r.effect = mapToEffect(newArrayList(t), r)
		
		return r
	}
	
	def dispatch Reaction mapTransition(Transition t, Choice source, Vertex target) {
		val r = t.create 
		if (t.trigger !== null) {
			r.check = mapToCheck(t.trigger) 
		} else {
			r.check = sexecFactory.createCheck
			r.check.condition = true.expression
		}
		r.effect = mapToEffect(newArrayList(t), r)
		
		return r
	}
	

	
	/** Ignore transitions from pseudostates to synchronization nodes.
	 * 
	 * TODO: introduce validation
	 */
	def dispatch Reaction mapTransition(Transition t, Pseudostate source, Synchronization target) {
		return null
	}
	
	/** Transitions to synchronization points are part of joins and must be handled specifically.
	 *  
	 * TODO: check if code redundancy is produced. The behaviors could be associated with the synchronization. 
	 */
	def dispatch Reaction mapTransition(Transition t, State source, Synchronization target) {
		val r = t.create 
		
		// create a check for the reaction
		if (t.trigger !== null) r.check = mapToCheck(t.trigger)
		else {
			r.check = sexecFactory.createCheck
			r.check.name = target.create.name + "join_check"
		} 
		
		// build the condition
		var Expression condition = r.check.condition
		
		val joinTransitions = target.incomingTransitions
			.filter( jt | jt.source instanceof State)
			.sortBy( jt | (jt.source as State).create.stateVector.offset )
		
		for ( trans : joinTransitions.filter( trans | trans != t )) { 
			if (trans.source instanceof State) { 
				condition = condition.conjunct(stext.active(trans.source as State))
				if (trans.trigger !== null) condition = condition.conjunct(trans.trigger.buildCondition)			
			}
		}
		r.check.condition = condition	
		
		// map effects of all transitions as a compound effect
		r.effect = mapToEffect(joinTransitions, r)
		
		return r
	}
	
	def ExecutionFlow mapEntries(Statechart statechart, ExecutionFlow r) {
		r.nodes.addAll(statechart.eAllContents.filter(typeof(Entry)).map(e|e.create).toList)
		r
	}
	
	def Expression conjunct(Expression c1, Expression c2) {
		if (c1 !== null && c2 !== null ) stext.and(c1, c2)
		else if (c1 !== null) c1
		else c2
	}
	
	
	def Check mapToCheck(Trigger tr) { 
		val check = tr.createCheck
		check.condition = tr.buildCondition;
		return check
	 }
	  	
	def ExecutionFlow mapLocalReactions(Statechart statechart, ExecutionFlow r){
		r.reactions.addAll(statechart.localReactions
				.filter( typeof( LocalReaction ))
				// ignore all reaction that are just entry or exit actions
				.filter(lr | 
					(lr.trigger as ReactionTrigger).triggers.empty 
					|| ! (lr.trigger as ReactionTrigger).triggers.filter( t | 
						t instanceof RegularEventSpec 
						|| t instanceof TimeEventSpec 
						|| t instanceof AlwaysEvent
					).empty
				)
				.map(t | t.mapReaction)
		)
		
		var content = statechart.eAllContents
		val allStates = content.filter(State)
		allStates.forEach( s |s.mapStateLocalReactions);
		return r
	}

	def ExecutionState mapStateLocalReactions(State state) {
		val _state = state.create
		
		_state.reactions.addAll( 
			state.localReactions
				.filter( typeof( LocalReaction ))
				// ignore all reaction that are just entry or exit actions
				.filter(lr | 
					(lr.trigger as ReactionTrigger).triggers.empty 
					|| ! (lr.trigger as ReactionTrigger).triggers.filter( t | 
						t instanceof RegularEventSpec 
						|| t instanceof TimeEventSpec 
						|| t instanceof AlwaysEvent
					).toList.empty
				)
				.map(t | t.mapReaction)
		)
		return _state
	}
	 
	 
	def Reaction mapReaction(LocalReaction lr) {
		val r = lr.create 
		if (lr.trigger !== null) r.check = mapToCheck(lr.trigger)
		r.effect = mapToEffect(lr)
		return r
	}
	
	def Sequence mapToEffect(LocalReaction lr) {
		if (lr.effect !== null) {
			if (trace.addTraceSteps) {
				val sequence = lr.effect.mapEffect
				sequence.steps.add(0, lr.create.newTraceReactionWillFire)
				sequence.steps.add(lr.create.newTraceReactionFired)
				return sequence
			} else
				return lr.effect.mapEffect
		}
	}

	
	def Sequence mapToEffect(Transition t, Reaction r) {
		val sequence = sexec.factory.createSequence 

		// define exit behavior of transition
		
		if (trace.addTraceSteps) {
			sequence.steps.add(t.create.newTraceReactionWillFire)	
		}
		
		// first process the exit behavior of orthogonal states that has to be performed before source exit
		val topExitState = t.exitStates.last
		if (topExitState !== null) {
			val exitSequence = topExitState.create.exitSequence
			if (exitSequence !== null) {
				sequence.steps.add(exitSequence.newCall)
			}
		}

		// map transition actions
		if (t.effect !== null) sequence.steps.add(t.effect.mapEffect)	
		if (trace.addTraceSteps) { 
			sequence.steps += r.newTraceReactionFired
		}
		

		// define entry behavior of the transition
		
		sequence.steps.addAll( mapToStateConfigurationEnterSequence( newArrayList(t) ).steps )
		
		
		
		return sequence
	}
	
	/**
	 * Creates a compound effect that can consist of multiple transitions.
	 */
	def Sequence mapToEffect(List<Transition> transitions, Reaction r) {
		val sequence = sexec.factory.createSequence 

		// define exit behavior of transition
		
		// first process the exit behavior of orthogonal states that has to be performed before source exit
		val topExitState = transitions.topExitState 
		
		if (trace.addTraceSteps) {
			for (t : transitions) {
				sequence.steps.add(t.create.newTraceReactionWillFire)	
			}
		}
		
		if (topExitState !== null) {
			val exitSequence = topExitState.create.exitSequence
			if (exitSequence !== null) {
				sequence.steps.add(exitSequence.newCall)
			}
		}

		// map transition actions
		for ( t : transitions ) {
			if (t.effect !== null) sequence.steps.add(t.effect.mapEffect)	
			if (trace.addTraceSteps) { 
				sequence.steps += t.create.newTraceReactionFired
			}
		}
	
	
		// define entry behavior of the transition	
		sequence.steps.addAll( mapToStateConfigurationEnterSequence( transitions ).steps )
		
		
		// handle local reactions that are out of transition scope
		val topEntryState = transitions.topEntryState
		val commonAncestors = commonAncestors(topExitState, topEntryState)
		val lcaRegion = commonAncestors.firstRegion
		
		val localReactionSequence = lcaRegion.lcaDoSequence(topExitState.create.flow)
		if (localReactionSequence !== null) sequence.steps += localReactionSequence
		
		return sequence
	}
	
	
	protected def Step lcaDoSequence(Region region, ExecutionFlow flow) {
		
		if ( region === null ) return null

		val execRegion = region.create
		
		var List<ExecutionNode> parentNodes = new ArrayList<ExecutionNode>()
		val shouldExecuteParent = 
			if (! region.statechart.childFirstExecution) 
				[ExecutionScope parentScope, ExecutionScope execScope | false ]
			else
				[ExecutionScope parentScope, ExecutionScope execScope | 
					parentScope === execScope || parentScope.impactVector.last == execScope.impactVector.last
				]
		 
		
		if (region.parentStates.head !== null) {
			val state = region.parentStates.head
			val execState = state.create
									
			val parents = state.parentStates.map(p|p.create).filter(p| shouldExecuteParent.apply(p, execRegion) )
			
			parentNodes.addAll(parents.map(p|p as ExecutionNode))			
			if ( shouldExecuteParent.apply( flow, execState) )
				parentNodes += flow
		} else {
			if ( shouldExecuteParent.apply( flow, execRegion) )
				parentNodes += flow
		}

			
		if (region.statechart.childFirstExecution) parentNodes = parentNodes.reverse		
		
		parentNodes.fold(null, [ r, s | s.createLocalReactionSequence(r)])
	}

	
	private def Sequence createLocalReactionSequence(ExecutionNode state, Step localStep) {	
				
		val localReactions = state.reactions.filter(r | ! r.transition ).toList
		var localSteps = sexec.factory.createSequence
		localSteps.steps.addAll(localReactions.map(lr | {
				var ifStep = sexec.factory.createIf
				ifStep.check = lr.check.newRef		
				ifStep.thenStep = lr.effect.newCall
				ifStep
		}))

		if (localStep !== null) localSteps.steps += localStep
		return localSteps
	}
	
	/**
	 * Calcuates a sequence to enter one or more states. Entering multiple states is required for fork, where parts of a state 
	 * configuration is specified.
	 */
	def Sequence mapToStateConfigurationEnterSequence(List<Transition> transitions) {
	
		// precondition : common source vertex
		// ? precondition : targets are Regular States ?
		
		val sequence = sexec.factory.createSequence 

		// determine start entry scope
		val entryScopes = transitions.get(0).entryScopes.drop(1).toList.reverse
		for ( t: transitions ) {
			entryScopes.retainAll(t.entryScopes)
		}
		val entryScope = entryScopes.head
		
		// determine all target vertices
		val List<TargetEntrySpec> targets = transitions
												.map( t | new TargetEntrySpec(t.target.mapped, t.entryPointName) )
												.fold(new ArrayList<TargetEntrySpec>, [ s, e | { 
														if (!s.exists(tes | e.target == tes.target)) {s.add(e)} 
														s
													}])
															
		// recursively extend the sequence by entering the scope for the specified targets		
		if (entryScope !== null) entryScope.addEnterStepsForTargetsToSequence( targets, sequence)	
		else {
			for ( t : targets ) t.target.addEnterStepsForTargetsToSequence(targets, sequence)
 		}	
	
		return sequence
	}
	
	

	def Sequence enterSequence(TargetEntrySpec it) {
		if(target instanceof ExecutionScope) {
			return (target as ExecutionScope).enterSequence(entryPointName)
		}
		return null
	}
	
	def Sequence enterSequence(ExecutionScope it, String name) {
		var Sequence seq = enterSequences.byName(name)
		if (seq === null) seq = enterSequences.defaultSequence

		return seq
	}
	
	def dispatch void addEnterStepsForTargetsToSequence(ExecutionState it, List<TargetEntrySpec> targets, Sequence seq) {
		
		val target = targets.findFirst( t | t.target == it)
		
		if ( target !== null ) {
			if (target.enterSequence !== null) seq.steps += target.enterSequence.newCall		
		}
		else {
			if ( it.entryAction !== null ) seq.steps.add(it.entryAction.newCall)
			if ( trace.addTraceSteps ) seq.steps.add(it.newTraceStateEntered)

			
			for (  subScope : it.subScopes ) {
				subScope.addEnterStepsForTargetsToSequence(targets, seq)
			}
			
			/* save state to shallow history if parent region contains one */ { 
				val parentRegion = it.superScope as ExecutionRegion
				if(parentRegion.historyVector !== null) {
					seq.steps += parentRegion.newSaveHistory()
				}	
			}
						
		}

	}


	def dispatch void addEnterStepsForTargetsToSequence(ExecutionRegion it, List<TargetEntrySpec> targets, Sequence seq) {
		
		// if a target is a direct node
		val target =  targets.filter( t | it.nodes.contains( t.target )).head 

		if (target !== null) {
			target.target.addEnterStepsForTargetsToSequence(targets, seq)
			return
		}
		
		// if the execution region contains targets 
		val List<ExecutionNode> targetNodes = targets.map(t | t.target)
		if ( allNodes.exists( n | targetNodes.contains(n) ) ) {
			for ( s : subScopes ) {
				if ( s.allNodes.exists( n | targetNodes.contains(n)))
					s.addEnterStepsForTargetsToSequence(targets, seq)
			}
		} else {
			// in the case only sibling regions contain targets the region must be entered 
			// using the defaut enter sequence, if this exists
			it.enterSequences.defaultSequence?.newCall?.addTo(seq.steps)
		}
	}
	
	
	/** TODO: move... */
	def <T> Collection<T> addTo(T it, Collection<T> c) {
		c.add(it);
		c
	}
	
	
	def dispatch Set<ExecutionNode> allNodes(ExecutionRegion it) {
		val allNodes = new HashSet<ExecutionNode>()
		allNodes.addAll(nodes)

		for ( s : subScopes ) {
			allNodes.addAll( s.allNodes )
		}
		
		allNodes
	}
	
	def dispatch Set<ExecutionNode> allNodes(ExecutionState it) {
		val allNodes = new HashSet<ExecutionNode>()
		allNodes.add(it)

		for ( s : subScopes ) {
			allNodes.addAll( s.allNodes )
		}
		
		allNodes
	}
		
	
	def dispatch void addEnterStepsForTargetsToSequence(ExecutionChoice it, List<TargetEntrySpec> targets, Sequence seq) {
		seq.steps.add( reactSequence.newCall )	
	}
	
	def dispatch void addEnterStepsForTargetsToSequence(ExecutionEntry it, List<TargetEntrySpec> targets, Sequence seq) {
		seq.steps.add( reactSequence.newCall )	
	}
	
	def dispatch void addEnterStepsForTargetsToSequence(ExecutionSynchronization it, List<TargetEntrySpec> targets, Sequence seq) {
		seq.steps.add( reactSequence.newCall )	
	}
	
	
		
	
	def List<ExecutionScope> entryScopes(Transition t) {
		// we determine the scopes that have to be entered by 		
		val targetPath = t.target.containers // getting the path elements from the target node
		val sourcePath = t.source.containers // and the path elements from the target all target node
		{ // and for the case of self transitions
			sourcePath.remove(t.target) // we make sure that target node
			sourcePath.remove(t.source) // and source node are not part of the target path
		}
		targetPath.removeAll(sourcePath) // the relevant entry scopes are then determined by removing all common source scopes

		// and map the elements to scopes...
		targetPath.map( c | 
			if ( c instanceof RegularState ) c.create as ExecutionScope
			else if ( c instanceof Region ) c.create as ExecutionScope
			else if ( c instanceof Statechart ) c.create as ExecutionScope
		).toList
	}
	
	/**
	 * Determines the list of states that are exited by a transition.
	 */
	def Iterable<State> exitStates(Transition t) {
		// we determine the states that have to be exited by 
		val sourcePath = t.source.containers // getting the path elements from the source node 
		val targetPath = t.target.containers // and the path elements from the target node
		{ // and for the case of self transitions
			targetPath.remove(t.target) // we make sure that target node
			targetPath.remove(t.source) // and source node are not part of the target path
		}
		sourcePath.removeAll(targetPath) // the relevant exit elements are then determined by removing all common target path elements
		sourcePath.filter( typeof(State) ) // and reducing this exit path to states 
	}

	def State topExitState(List<Transition> transitions) {
				// first process the exit behavior of orthogonal states that has to be performed before source exit
		val exitStates = transitions.get(0).exitStates.toList

		for ( t : transitions ) {
			exitStates.retainAll(t.exitStates.toList)
		}
		
		exitStates.last		
	}

	
	/**
	 * Determines the list of states that are entered by a transition.
	 */
	def Iterable<State> entryStates(Transition t) {
		// we determine the states that have to be entered by 
		val sourcePath = t.source.containers // getting the path elements from the source node 
		val targetPath = t.target.containers // and the path elements from the target node
		{ // and for the case of self transitions
			sourcePath.remove(t.target) // we make sure that target node
			sourcePath.remove(t.source) // and source node are not part of the source path
		}
		targetPath.removeAll(sourcePath) // the relevant entry elements are then determined by removing all common source path elements
		targetPath.filter( typeof(State) ) // and reducing this entry path to states 
	}

	
	def State topEntryState(List<Transition> transitions) {
		// first process the exit behavior of orthogonal states that has to be performed before source exit
		val states = transitions.get(0).entryStates.toList

		for ( t : transitions ) {
			states.retainAll(t.entryStates.toList)
		}
		
		states.last		
	}

	
	def List<EObject> commonAncestors(Vertex a, Vertex b) {
		// we determine the states that have to be exited by 
		val aParents = a.containers // getting the path elements from the source node 
		val bParents = b.containers // and the path elements from the target all target node
		{ // and for the case of self transitions
			bParents.remove(b) // we make sure that target node
			aParents.remove(a) // and source node are not part of the target path
		}
		
		aParents.retainAll(bParents) // get all ancestors by retaining the common elements
		aParents		
	}
	

	def firstState(Iterable<EObject> it) {
		filter( typeof(State) ).head	
	} 
	
	def firstRegion(Iterable<EObject> it) {
		filter( typeof(Region) ).head			
	}
	
	def State leastCommonAncesterState(State a, State b) {
		commonAncestors(a,b).firstState
	}
	
	
	def dispatch Expression buildCondition (Trigger t) { null }


	def dispatch Expression buildCondition (DefaultTrigger t) { 
		true.expression
	 }

	def Expression expression (boolean b) { 
		val r = ExpressionsFactory.eINSTANCE.createPrimitiveValueExpression
		val BoolLiteral boolLit = ExpressionsFactory.eINSTANCE.createBoolLiteral
		boolLit.value = b		
		r.value = boolLit
		return r
	 }
	
	def dispatch Expression buildCondition (ReactionTrigger t) {
		
		val hasTriggers = ! t.triggers.empty
		val triggersAreAlwaysTrue = t.triggers.filter(AlwaysEvent).size > 0 
		val triggerCheck = if (hasTriggers && !triggersAreAlwaysTrue) t.toTriggerCheck else null;
		
		val guard = t.buildGuard
		
		if ( triggerCheck !== null && guard !== null )  stext.and(stext.parenthesis(triggerCheck), stext.parenthesis(guard))
		else if ( triggerCheck !== null )  triggerCheck
		else if ( guard !== null ) guard
		else if ( triggersAreAlwaysTrue ) _true
	}
	
	
	def toTriggerCheck(ReactionTrigger t) {
		t.triggers.reverseView.fold(null as Expression,
			[s,e | {
				val Expression raised = e.raised()
				
				if (raised === null) s
				else if (s===null) raised  
				else raised.or(s)
			}])		
	}
	
	
	def dispatch Expression buildGuard( Trigger t) {null}
	
	def dispatch Expression buildGuard( ReactionTrigger t) {
		if ( t.guard !== null ) EcoreUtil::copy(t.guard.expression) else null
	}
		
	
}
