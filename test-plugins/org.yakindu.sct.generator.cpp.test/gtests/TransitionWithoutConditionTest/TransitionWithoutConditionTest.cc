#include <string>
#include "gtest/gtest.h"
#include "TransitionWithoutCondition.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

TransitionWithoutCondition* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class TransitionWithoutConditionTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new TransitionWithoutCondition();
		statechart->init();
		runner = new SctUnitRunner(
			statechart,
			false,
			200
		);
	}
	virtual void TearDown() {
		delete statechart;
		delete runner;
	}
};


TEST_F(TransitionWithoutConditionTest, TransitionWithoutConditionTest) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(TransitionWithoutCondition::main_region_A));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(TransitionWithoutCondition::main_region_B));
	
	
}

}

