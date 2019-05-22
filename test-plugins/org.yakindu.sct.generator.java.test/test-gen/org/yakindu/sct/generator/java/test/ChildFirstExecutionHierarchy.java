/** Generated by YAKINDU Statechart Tools code generator. */

package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.childfirstexecutionhierarchy.ChildFirstExecutionHierarchyStatemachine;
import org.yakindu.scr.childfirstexecutionhierarchy.ChildFirstExecutionHierarchyStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for ChildFirstExecutionHierarchy
 */
@SuppressWarnings("all")
public class ChildFirstExecutionHierarchy {
	
	private ChildFirstExecutionHierarchyStatemachine statemachine;	
	private VirtualTimer timer;
	
	private TestModelGenerator helper = new TestModelGenerator(
			"testmodels/SCTUnit/executionorder/ChildFirstExecutionHierarchy.sct", 
			"test-gen/org/yakindu/sct/generator/java/test/ChildFirstExecutionHierarchy.sgen");
	
	
	
	@Before
	public void childFirstExecutionHierarchy_setUp() {
		helper.generate();
		
		statemachine = new ChildFirstExecutionHierarchyStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void childFirstExecutionHierarchy_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void childShouldTakeTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.childFirstExecutionHierarchy_r_A_r_AA_r_AAA));
		statemachine.getSCInterface().raiseE();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.childFirstExecutionHierarchy_r_B));
		assertTrue(!statemachine.getA_reacted());
		assertTrue(!statemachine.getAa_reacted());
		assertTrue(statemachine.getAaa_reacted());
		assertNoLocalReaction();
	}
	
	@Test
	public void parentShouldTakeTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.childFirstExecutionHierarchy_r_A_r_AA_r_AAA));
		statemachine.getSCInterface().setDisable_aaa(true);
		statemachine.getSCInterface().raiseE();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.childFirstExecutionHierarchy_r_B));
		assertTrue(!statemachine.getA_reacted());
		assertTrue(statemachine.getAa_reacted());
		assertTrue(!statemachine.getAaa_reacted());
		assertTrue(!statemachine.getA_local());
		assertTrue(!statemachine.getAa_local());
		assertTrue(statemachine.getAaa_local());
	}
	
	@Test
	public void grandparentShouldTakeTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.childFirstExecutionHierarchy_r_A_r_AA_r_AAA));
		statemachine.getSCInterface().setDisable_aa(true);
		statemachine.getSCInterface().setDisable_aaa(true);
		statemachine.getSCInterface().raiseE();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.childFirstExecutionHierarchy_r_B));
		assertTrue(statemachine.getA_reacted());
		assertTrue(!statemachine.getAa_reacted());
		assertTrue(!statemachine.getAaa_reacted());
		assertTrue(!statemachine.getA_local());
		assertTrue(statemachine.getAa_local());
		assertTrue(statemachine.getAaa_local());
	}
	
	@Test
	public void expectLocalReactrionsExecuteWithNoTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.childFirstExecutionHierarchy_r_A_r_AA_r_AAA));
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.childFirstExecutionHierarchy_r_A_r_AA_r_AAA));
		assertTrue(statemachine.getA_local());
		assertTrue(statemachine.getAa_local());
		assertTrue(statemachine.getAaa_local());
	}
	
	public void assertNoLocalReaction() {
		assertTrue(!statemachine.getA_local());
		assertTrue(!statemachine.getAa_local());
		assertTrue(!statemachine.getAaa_local());
	}
}
