/** Generated by YAKINDU Statechart Tools code generator. */

package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.transitionhandlesmultipleexits.TransitionHandlesMultipleExitsStatemachine;
import org.yakindu.scr.transitionhandlesmultipleexits.TransitionHandlesMultipleExitsStatemachine.State;	

/**
 * Unit TestCase for TransitionHandlesMultipleExits
 */
@SuppressWarnings("all")
public class TransitionHandlesMultipleExists {
	
	private TransitionHandlesMultipleExitsStatemachine statemachine;	
	
	
	@Before
	public void transitionHandlesMultipleExists_setUp() {
		statemachine = new TransitionHandlesMultipleExitsStatemachine();
		
		statemachine.init();
		
	}

	@After
	public void transitionHandlesMultipleExists_tearDown() {
		statemachine = null;
		
	}
	
	@Test
	public void testTransitionHandling2Of2Exits() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.transitionHandlesMultipleExits_main_region_A_r_AA));
		statemachine.raiseE();
		assertTrue(statemachine.isStateActive(State.transitionHandlesMultipleExits_main_region_B_r_BB));
		assertTrue(statemachine.getX() == 1l);
		statemachine.exit();
		statemachine.enter();
		statemachine.setX(0l);
		assertTrue(statemachine.isStateActive(State.transitionHandlesMultipleExits_main_region_A_r_AA));
		statemachine.raiseF();
		assertTrue(statemachine.isStateActive(State.transitionHandlesMultipleExits_main_region_B_r_BB));
		assertTrue(statemachine.getX() == 2l);
	}
	
	@Test
	public void testTransitionHandling2Of3Exits() {
		statemachine.enter();
		statemachine.raiseE();
		assertTrue(statemachine.isStateActive(State.transitionHandlesMultipleExits_main_region_B_r_BB));
		statemachine.setX(0l);
		statemachine.raiseE();
		assertTrue(statemachine.isStateActive(State.transitionHandlesMultipleExits_main_region_A_r_AA));
		assertTrue(statemachine.getX() == 11l);
		statemachine.raiseE();
		assertTrue(statemachine.isStateActive(State.transitionHandlesMultipleExits_main_region_B_r_BB));
		statemachine.setX(0l);
		statemachine.raiseG();
		assertTrue(statemachine.isStateActive(State.transitionHandlesMultipleExits_main_region_A_r_AA));
		assertTrue(statemachine.getX() == 10l);
		statemachine.exit();
	}
	
	@Test
	public void testTransitionHandling1Of3Exits() {
		statemachine.enter();
		statemachine.raiseE();
		assertTrue(statemachine.isStateActive(State.transitionHandlesMultipleExits_main_region_B_r_BB));
		statemachine.setX(0l);
		statemachine.raiseF();
		assertTrue(statemachine.isStateActive(State.transitionHandlesMultipleExits_main_region_A_r_AA));
		assertTrue(statemachine.getX() == 24l);
		statemachine.exit();
	}
}
