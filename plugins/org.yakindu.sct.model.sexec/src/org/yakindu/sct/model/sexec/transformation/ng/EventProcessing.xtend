package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.SexecBuilder
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.sexec.TimeEvent
import java.util.List

class EventProcessing {


	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder
	@Inject extension SexecBuilder
	
	@Inject extension SExecExtensions
	@Inject extension StateMachineConcept
	@Inject protected extension EventBuffer
	

	public static val CLEAR_EVENT = StateMachineConcept.CONCEPT_NAME_PREFIX + "clearEvent"
	public static val MOVE_EVENT = StateMachineConcept.CONCEPT_NAME_PREFIX + "moveEvent"
	public static val CLEAR_OUT_EVENTS = "clearOutEvents"
	public static val CLEAR_IN_EVENTS = "clearInEvents"
	public static val CLEAR_INTERNAL_EVENTS = "clearInternalEvents"
	public static val TAKE_IN_EVENTS = "takeInEvents"
	public static val TAKE_INTERNAL_EVENTS = "takeInternalEvents"


	def defineFeatures (ExecutionFlow it) {
		if (hasOutgoingEvents) defineClearOutEvents
		if (hasIncomingEvents) {
			if (buffersIncomingEvents) defineTakeInEvents
			else defineClearInEvents
		}
		if (hasLocalEvents) {
			if (buffersInternalEvents) defineTakeInternalEvents
			else defineClearInternalEvents
		}
	}


	def defineClearOutEvents(ExecutionFlow it) {
		it._method(CLEAR_OUT_EVENTS) => [ m | 
			m._type(_void)
			m._body(
				outgoingEvents.map[ o |
					o._clear
				]
			)
		]
	}
	
	def defineClearInEvents(ExecutionFlow it) {
		it._method(CLEAR_IN_EVENTS) => [ m | 
			m._type(_void)
			
			m._body(
				#[flow.incomingEvents, flow.timeEvents].flatten.map[ i |
					i._clear
				]
			)
		]
	}
	
	def defineClearInternalEvents(ExecutionFlow it) {
		it._method(CLEAR_INTERNAL_EVENTS) => [ m | 
			m._type(_void)
			
			m._body(
				localEvents.map[ i |
					i._clear
				]
			)
		]
	}


	def defineTakeInEvents(ExecutionFlow it) {
		it._method(TAKE_IN_EVENTS) => [ m | 
			m._type(_void)
			
			m._body(
				it.bufferEventExpressions.incoming
					.map[ e |
						e.event.originEvent._move(e)
					]
			)
		]
	}
	


	def defineTakeInternalEvents(ExecutionFlow it) {
		it._method(TAKE_INTERNAL_EVENTS) => [ m | 
			m._type(_void)
			
			m._body(
				it.bufferEventExpressions.internal
					.map[ e | 
						e.event.originEvent._move(e)
					]
			)
		]
	}
	
	def Step _eventProcessing(ExecutionFlow it, Step body) {
		_sequence(
			_takeInEvents,
			_clearOutEvents,
			_eventLoop(body),
			_clearInEvents	
		)
	}


	def Step _eventLoop(ExecutionFlow it, Step body) {
		if (hasLocalEvents) 
			_do(_sequence(
				body,
				_takeInternalEvents
			))._while(
				bufferEventExpressions.internal.reduce[r1, r2| r1._or(r2)]
			)
		else 
			body	
	}

	def Step _clearOutEvents(ExecutionFlow it) {
		if ( hasOutgoingEvents ) clearOutEvents._call._statement 
		else _empty	
	}


	def Step _clearInEvents(ExecutionFlow it) {
		if ( hasIncomingEvents && !buffersIncomingEvents ) clearInEvents._call._statement 
		else _empty	
	}

	def Step _takeInEvents(ExecutionFlow it) {
		if (takeInEvents !== null)
			takeInEvents._call._statement
		else _empty
	}

	def Step _takeInternalEvents(ExecutionFlow it) {
		if (takeInternalEvents !== null)
			takeInternalEvents._call._statement
		else _empty
	}


	def Step _clear(EObject it){
		_conceptSequence(CLEAR_EVENT, it)	
	}
	
	def Step _move(EObject source, EObject target){
		_conceptSequence(MOVE_EVENT, source, target)	
	}
	
	def dispatch Event event(Sequence it){
		it.getParameter as Event
	}
	
	def protected List<Expression> bufferEventExpressions(ExecutionFlow it) {
		it
			.eventBuffer
			.bufferEvents
			.asExpressions		
	}
	
	def protected internal(List<Expression> it) {
		filter[ e | 
			val o = e.event.originEvent;
			o instanceof EventDefinition && o.direction == Direction.LOCAL
		]
	}
	
	def protected incoming(List<Expression> it) {
		filter[ e | 
			val o = e.event.originEvent;
			(o instanceof EventDefinition && o.direction == Direction.IN) || (o instanceof TimeEvent) 
		]
	}
	
	def dispatch Event event(ElementReferenceExpression it){
		it.reference as Event
	}
	
	def Property valueFeature(Event it) {
		it.metaFeatures.filter(Property).filter[ p | p.name == "value"].head
	} 
	
	def dispatch Event event(FeatureCall it){
		it.feature as Event
	}
	

	def Method clearOutEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == CLEAR_OUT_EVENTS).head
	}
	
	def Method clearInEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == CLEAR_IN_EVENTS).head
	}
	
	def Method takeInternalEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == TAKE_INTERNAL_EVENTS).head
	}

	def Method takeInEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == TAKE_IN_EVENTS).head
	}
	

	def hasIncomingEvents(ExecutionFlow it) {
		hasInEvents || timeEvents.size > 0 	
	}
	
	def buffersIncomingEvents(ExecutionFlow it) {
		true 
	}

	def buffersInternalEvents(ExecutionFlow it) {
		true 
	}

	
	
}