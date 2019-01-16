package org.yakindu.scr.constonlydefaultscope;


public class ConstOnlyDefaultScopeStatemachine implements IConstOnlyDefaultScopeStatemachine {
	protected class SCInterfaceImpl implements SCInterface {
	
		public long getB() {
			return b;
		}
		
		public long getC() {
			return c;
		}
		
	}
	
	protected SCInterfaceImpl sCInterface;
	
	protected class SCIAImpl implements SCIA {
	
		private boolean e;
		
		private long eValue;
		
		public void raiseE(long value) {
			e = true;
			eValue = value;
		}
		
		protected long getEValue() {
			if (! e ) 
				throw new IllegalStateException("Illegal event value access. Event E is not raised!");
			return eValue;
		}
		
		protected void clearEvents() {
			e = false;
		}
	}
	
	protected SCIAImpl sCIA;
	
	private boolean initialized = false;
	
	public enum State {
		constOnlyDefaultScope_main_region_A,
		constOnlyDefaultScope_main_region_B,
		constOnlyDefaultScope_main_region_C,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	
	public ConstOnlyDefaultScopeStatemachine() {
		sCInterface = new SCInterfaceImpl();
		sCIA = new SCIAImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
				"The state machine needs to be initialized first by calling the init() function."
			);
		}
		enterSequence_ConstOnlyDefaultScope_main_region_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case constOnlyDefaultScope_main_region_A:
				constOnlyDefaultScope_main_region_A_react(true);
				break;
			case constOnlyDefaultScope_main_region_B:
				constOnlyDefaultScope_main_region_B_react(true);
				break;
			case constOnlyDefaultScope_main_region_C:
				constOnlyDefaultScope_main_region_C_react(true);
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
	public void exit() {
		exitSequence_ConstOnlyDefaultScope_main_region();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
	}
	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
		sCIA.clearEvents();
	}
	
	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
	}
	
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case constOnlyDefaultScope_main_region_A:
			return stateVector[0] == State.constOnlyDefaultScope_main_region_A;
		case constOnlyDefaultScope_main_region_B:
			return stateVector[0] == State.constOnlyDefaultScope_main_region_B;
		case constOnlyDefaultScope_main_region_C:
			return stateVector[0] == State.constOnlyDefaultScope_main_region_C;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public SCIA getSCIA() {
		return sCIA;
	}
	
	public long getB() {
		return sCInterface.getB();
	}
	
	public long getC() {
		return sCInterface.getC();
	}
	
	/* 'default' enter sequence for state A */
	private void enterSequence_ConstOnlyDefaultScope_main_region_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.constOnlyDefaultScope_main_region_A;
	}
	
	/* 'default' enter sequence for state B */
	private void enterSequence_ConstOnlyDefaultScope_main_region_B_default() {
		nextStateIndex = 0;
		stateVector[0] = State.constOnlyDefaultScope_main_region_B;
	}
	
	/* 'default' enter sequence for state C */
	private void enterSequence_ConstOnlyDefaultScope_main_region_C_default() {
		nextStateIndex = 0;
		stateVector[0] = State.constOnlyDefaultScope_main_region_C;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_ConstOnlyDefaultScope_main_region_default() {
		react_declarations_ConstOnlyDefaultScope_main_region__entry_Default();
	}
	
	/* Default exit sequence for state A */
	private void exitSequence_ConstOnlyDefaultScope_main_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state B */
	private void exitSequence_ConstOnlyDefaultScope_main_region_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state C */
	private void exitSequence_ConstOnlyDefaultScope_main_region_C() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_ConstOnlyDefaultScope_main_region() {
		switch (stateVector[0]) {
		case constOnlyDefaultScope_main_region_A:
			exitSequence_ConstOnlyDefaultScope_main_region_A();
			break;
		case constOnlyDefaultScope_main_region_B:
			exitSequence_ConstOnlyDefaultScope_main_region_B();
			break;
		case constOnlyDefaultScope_main_region_C:
			exitSequence_ConstOnlyDefaultScope_main_region_C();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_declarations_ConstOnlyDefaultScope_main_region__entry_Default() {
		enterSequence_ConstOnlyDefaultScope_main_region_A_default();
	}
	
	private boolean react() {
		return false;
	}
	
	private boolean constOnlyDefaultScope_main_region_A_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				if (((sCIA.e) && (sCIA.getEValue()==sCInterface.getB()))) {
					exitSequence_ConstOnlyDefaultScope_main_region_A();
					enterSequence_ConstOnlyDefaultScope_main_region_B_default();
				} else {
					if (((sCIA.e) && (sCIA.getEValue()==sCInterface.getC()))) {
						exitSequence_ConstOnlyDefaultScope_main_region_A();
						enterSequence_ConstOnlyDefaultScope_main_region_C_default();
					} else {
						did_transition = false;
					}
				}
			}
		}
		return did_transition;
	}
	
	private boolean constOnlyDefaultScope_main_region_B_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				did_transition = false;
			}
		}
		return did_transition;
	}
	
	private boolean constOnlyDefaultScope_main_region_C_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				did_transition = false;
			}
		}
		return did_transition;
	}
	
}
