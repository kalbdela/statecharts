/** Generated by YAKINDU Statechart Tools code generator. */

#include "gtest/gtest.h"
#include "ChildFirstTransitionTaking.h"

#include "sc_timer_service.h"

#define SC_UNUSED(P) (void)P

static ChildFirstTransitionTaking statechart;


class ChildFirstTransitionTakingTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void testParentTransitionFromSimpleState();
	void testParentTransitionFromOrthogonalChildState();
	void testParentLocalReactionOnTransition();
	void testLocalReactionsOnTransitionsParentScope();
	void setTimer(ChildFirstTransitionTaking* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(ChildFirstTransitionTaking* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ChildFirstTransitionTakingTest * tc;


void ChildFirstTransitionTakingTest::SetUp()
{
	childFirstTransitionTaking_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &childFirstTransitionTaking_runCycle,
		true,
		200,
		&statechart
	);
	
	
	tc = this;
}
void ChildFirstTransitionTakingTest::testParentTransitionFromSimpleState()
{
	childFirstTransitionTaking_enter(&statechart);
	EXPECT_TRUE(childFirstTransitionTaking_isStateActive(&statechart, ChildFirstTransitionTaking_r1_A_r1_AA));
	childFirstTransitionTakingIface_raise_e(&statechart);
	EXPECT_TRUE(childFirstTransitionTaking_isStateActive(&statechart, ChildFirstTransitionTaking_r1_B));
	childFirstTransitionTaking_exit(&statechart);
}
void ChildFirstTransitionTakingTest::testParentTransitionFromOrthogonalChildState()
{
	childFirstTransitionTaking_enter(&statechart);
	EXPECT_TRUE(childFirstTransitionTaking_isStateActive(&statechart, ChildFirstTransitionTaking_r1_A_r1_AA));
	childFirstTransitionTakingIface_raise_go(&statechart);
	EXPECT_TRUE(childFirstTransitionTaking_isStateActive(&statechart, ChildFirstTransitionTaking_r1_A_r1_AB_r1_ABA));
	EXPECT_TRUE(childFirstTransitionTaking_isStateActive(&statechart, ChildFirstTransitionTaking_r1_A_r1_AB_r2_ABB));
	childFirstTransitionTakingIface_raise_e(&statechart);
	EXPECT_TRUE(childFirstTransitionTaking_isStateActive(&statechart, ChildFirstTransitionTaking_r1_B));
	childFirstTransitionTaking_exit(&statechart);
}
void ChildFirstTransitionTakingTest::testParentLocalReactionOnTransition()
{
	childFirstTransitionTaking_enter(&statechart);
	EXPECT_TRUE(childFirstTransitionTaking_isStateActive(&statechart, ChildFirstTransitionTaking_r1_A_r1_AA));
	childFirstTransitionTakingIface_raise_go(&statechart);
	EXPECT_TRUE(childFirstTransitionTaking_isStateActive(&statechart, ChildFirstTransitionTaking_r1_A_r1_AB_r1_ABA));
	EXPECT_TRUE(childFirstTransitionTaking_isStateActive(&statechart, ChildFirstTransitionTaking_r1_A_r1_AB_r2_ABB));
	childFirstTransitionTakingIface_raise_go(&statechart);
	EXPECT_TRUE(childFirstTransitionTaking_isStateActive(&statechart, ChildFirstTransitionTaking_r1_A_r1_AA));
	childFirstTransitionTaking_exit(&statechart);
}
void ChildFirstTransitionTakingTest::testLocalReactionsOnTransitionsParentScope()
{
	childFirstTransitionTaking_enter(&statechart);
	EXPECT_TRUE(childFirstTransitionTaking_isStateActive(&statechart, ChildFirstTransitionTaking_r2_C_r_CA_r_CAA));
	EXPECT_TRUE(childFirstTransitionTakingIface_get_cLocalReaction(&statechart)== 0);
	EXPECT_TRUE(childFirstTransitionTakingIface_get_caLocalReaction(&statechart)== 0);
	childFirstTransitionTakingIface_raise_go(&statechart);
	EXPECT_TRUE(childFirstTransitionTaking_isStateActive(&statechart, ChildFirstTransitionTaking_r2_C_r_CA_r_CAB));
	EXPECT_TRUE(childFirstTransitionTakingIface_get_cLocalReaction(&statechart)== 1);
	EXPECT_TRUE(childFirstTransitionTakingIface_get_caLocalReaction(&statechart)== 1);
	childFirstTransitionTakingIface_raise_go(&statechart);
	EXPECT_TRUE(childFirstTransitionTaking_isStateActive(&statechart, ChildFirstTransitionTaking_r2_C_r_CA_r_CAA));
	EXPECT_TRUE(childFirstTransitionTakingIface_get_cLocalReaction(&statechart)== 2);
	EXPECT_TRUE(childFirstTransitionTakingIface_get_caLocalReaction(&statechart)== 2);
	childFirstTransitionTakingIface_raise_e(&statechart);
	EXPECT_TRUE(childFirstTransitionTaking_isStateActive(&statechart, ChildFirstTransitionTaking_r2_C_r_CB));
	EXPECT_TRUE(childFirstTransitionTakingIface_get_cLocalReaction(&statechart)== 3);
	EXPECT_TRUE(childFirstTransitionTakingIface_get_caLocalReaction(&statechart)== 2);
	childFirstTransitionTakingIface_raise_e(&statechart);
	EXPECT_TRUE(childFirstTransitionTaking_isStateActive(&statechart, ChildFirstTransitionTaking_r2_C_r_CA));
	EXPECT_TRUE(childFirstTransitionTakingIface_get_cLocalReaction(&statechart)== 4);
	EXPECT_TRUE(childFirstTransitionTakingIface_get_caLocalReaction(&statechart)== 2);
}

void ChildFirstTransitionTakingTest::setTimer(ChildFirstTransitionTaking* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid, statechart);
	insert_timer(&(tc->timer_service), timer);
}

void ChildFirstTransitionTakingTest::unsetTimer(ChildFirstTransitionTaking* handle, const sc_eventid evid){
	SC_UNUSED(handle);
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ChildFirstTransitionTakingTest, testParentTransitionFromSimpleState) {
	testParentTransitionFromSimpleState();
}
TEST_F(ChildFirstTransitionTakingTest, testParentTransitionFromOrthogonalChildState) {
	testParentTransitionFromOrthogonalChildState();
}
TEST_F(ChildFirstTransitionTakingTest, testParentLocalReactionOnTransition) {
	testParentLocalReactionOnTransition();
}
TEST_F(ChildFirstTransitionTakingTest, testLocalReactionsOnTransitionsParentScope) {
	testLocalReactionsOnTransitionsParentScope();
}


