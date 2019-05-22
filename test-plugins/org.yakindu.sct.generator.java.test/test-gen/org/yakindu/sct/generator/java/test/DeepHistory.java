/** Generated by YAKINDU Statechart Tools code generator. */

package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.deephistory.DeepHistoryStatemachine;
import org.yakindu.scr.deephistory.DeepHistoryStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for DeepHistory
 */
@SuppressWarnings("all")
public class DeepHistory {
	
	private DeepHistoryStatemachine statemachine;	
	private VirtualTimer timer;
	
	private TestModelGenerator helper = new TestModelGenerator(
			"testmodels/SCTUnit/DeepHistory.sct", 
			"test-gen/org/yakindu/sct/generator/java/test/DeepHistory.sgen");
	
	
	
	@Before
	public void deepHistory_setUp() {
		helper.generate();
		
		statemachine = new DeepHistoryStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void deepHistory_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void deepHistoryTest() {
		statemachine.enter();
		statemachine.getSCInterface().raiseEvent1();
		timer.cycleLeap(1);
		statemachine.getSCInterface().raiseEvent3();
		timer.cycleLeap(1);
		statemachine.getSCInterface().raiseEvent5();
		timer.cycleLeap(1);
		statemachine.getSCInterface().raiseEvent7();
		timer.cycleLeap(1);
		assertTrue(!statemachine.isStateActive(State.mainRegion_State1));
		assertTrue(statemachine.isStateActive(State.mainRegion_State2__region0_State4__region0_State7__region0_State9));
		statemachine.getSCInterface().raiseEvent2();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.mainRegion_State1));
		assertTrue(!statemachine.isStateActive(State.mainRegion_State2__region0_State4__region0_State7__region0_State9));
		statemachine.getSCInterface().raiseEvent1();
		timer.cycleLeap(1);
		assertTrue(!statemachine.isStateActive(State.mainRegion_State1));
		assertTrue(statemachine.isStateActive(State.mainRegion_State2__region0_State4__region0_State7__region0_State9));
	}
}
