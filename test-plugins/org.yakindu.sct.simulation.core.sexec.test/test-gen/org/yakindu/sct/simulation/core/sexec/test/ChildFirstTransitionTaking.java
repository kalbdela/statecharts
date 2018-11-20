/* Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.sct.simulation.core.sexec.test;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.interpreter.test.util.AbstractExecutionFlowTest;
import org.yakindu.sct.model.sexec.interpreter.test.util.SExecInjectionProvider;
import org.yakindu.sct.test.models.SCTUnitTestModels;
import com.google.inject.Inject;
import static org.junit.Assert.*;

/**
 * Unit TestCase for ChildFirstTransitionTaking
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class ChildFirstTransitionTaking extends AbstractExecutionFlowTest {
	
	@Before
	public void setup() throws Exception{
		ExecutionFlow flow = models.loadExecutionFlowFromResource("executionorder/ChildFirstTransitionTaking.sct");
		initInterpreter(flow);
	}
	@Test
	public void testParentTransitionFromSimpleState() throws Exception {
		interpreter.enter();
		assertTrue(isStateActive("AA"));
		raiseEvent("e");
		assertTrue(isStateActive("B"));
		interpreter.exit();
	}
	@Test
	public void testParentTransitionFromOrthogonalChildState() throws Exception {
		interpreter.enter();
		assertTrue(isStateActive("AA"));
		raiseEvent("go");
		assertTrue(isStateActive("ABA"));
		assertTrue(isStateActive("ABB"));
		raiseEvent("e");
		assertTrue(isStateActive("B"));
		interpreter.exit();
	}
	@Test
	public void testParentLocalReactionOnTransition() throws Exception {
		interpreter.enter();
		assertTrue(isStateActive("AA"));
		raiseEvent("go");
		assertTrue(isStateActive("ABA"));
		assertTrue(isStateActive("ABB"));
		raiseEvent("go");
		assertTrue(isStateActive("AA"));
		interpreter.exit();
	}
	@Test
	public void testLocalReactionsOnTransitionsParentScope() throws Exception {
		interpreter.enter();
		assertTrue(isStateActive("CAA"));
		assertTrue(getInteger("cLocalReaction") == 0l);
		assertTrue(getInteger("caLocalReaction") == 0l);
		raiseEvent("go");
		assertTrue(isStateActive("CAB"));
		assertTrue(getInteger("cLocalReaction") == 1l);
		assertTrue(getInteger("caLocalReaction") == 1l);
		raiseEvent("go");
		assertTrue(isStateActive("CAA"));
		assertTrue(getInteger("cLocalReaction") == 2l);
		assertTrue(getInteger("caLocalReaction") == 2l);
		raiseEvent("e");
		assertTrue(isStateActive("CB"));
		assertTrue(getInteger("cLocalReaction") == 3l);
		assertTrue(getInteger("caLocalReaction") == 2l);
		raiseEvent("e");
		assertTrue(isStateActive("CA"));
		assertTrue(getInteger("cLocalReaction") == 4l);
		assertTrue(getInteger("caLocalReaction") == 2l);
	}
}
