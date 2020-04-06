/** Generated by YAKINDU Statechart Tools code generator. */

#include "gtest/gtest.h"
#include "ConstantsVariation.h"

#include "sc_timer_service.h"

#define SC_UNUSED(P) (void)P

static ConstantsVariation statechart;


class ConstantsVariationTests : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void constantDefinition();
	void setTimer(ConstantsVariation* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(ConstantsVariation* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ConstantsVariationTests * tc;


void ConstantsVariationTests::SetUp()
{
	constantsVariation_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &constantsVariation_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void ConstantsVariationTests::constantDefinition()
{
	constantsVariation_enter(&statechart);
	EXPECT_TRUE(constantsVariation_isStateActive(&statechart, ConstantsVariation_main_region_StateA));
	EXPECT_TRUE(constantsVariationIface_get_b2(&statechart)== true);
	EXPECT_TRUE(constantsVariationIfaceNamed_get_b(&statechart) == true);
	EXPECT_TRUE(constantsVariationIface_get_i2(&statechart)== 5);
	EXPECT_TRUE(constantsVariationIfaceNamed_get_i(&statechart) == 5);
	EXPECT_TRUE(constantsVariationIface_get_r2(&statechart)== 5);
	EXPECT_TRUE(constantsVariationIfaceNamed_get_r(&statechart) == 5);
	EXPECT_TRUE(strcmp(constantsVariationIface_get_str2(&statechart), (sc_string)"String") == 0);
	EXPECT_TRUE(strcmp(constantsVariationIfaceNamed_get_str(&statechart) , (sc_string)"String") == 0);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(constantsVariation_isFinal(&statechart));
}

void ConstantsVariationTests::setTimer(ConstantsVariation* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	SC_UNUSED(statechart);
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void ConstantsVariationTests::unsetTimer(ConstantsVariation* handle, const sc_eventid evid){
	SC_UNUSED(handle);
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ConstantsVariationTests, constantDefinition) {
	constantDefinition();
}


