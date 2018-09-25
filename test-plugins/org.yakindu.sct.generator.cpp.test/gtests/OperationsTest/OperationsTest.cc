/* Generated by YAKINDU Statechart Tools code generator. */
#include <string>
#include "gtest/gtest.h"
#include "Operations.h"
#include "sc_runner.h"
#include "sc_types.h"
#include "gmock/gmock.h"

using ::testing::AtLeast;
using ::testing::Return;
using ::testing::_;

namespace  {

Operations* statechart;


class AlwaysTrueMock{
	typedef sc_boolean (AlwaysTrueMock::*functiontype)();
	public:
	sc_boolean (AlwaysTrueMock::*alwaysTrueBehaviorDefault)();

	sc_boolean alwaysTrue1(){
		return (true);
	}

	sc_boolean alwaysTrueDefault(){
		sc_boolean defaultValue = null;
		return (defaultValue);
	}

	functiontype getBehavior(){
		return alwaysTrueBehaviorDefault;
	}
	
	void setDefaultBehavior(sc_boolean (AlwaysTrueMock::*defaultBehavior)()){
		alwaysTrueBehaviorDefault = defaultBehavior;
	}
	
	void initializeBehavior() {
		setDefaultBehavior(&AlwaysTrueMock::alwaysTrueDefault);
	}
	
	void reset() {
		initializeBehavior();
	}
};
static AlwaysTrueMock* alwaysTrueMock;

class InternalOperation1Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void internalOperation1() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static InternalOperation1Mock* internalOperation1Mock;

class InternalOperation2Mock{
	struct parameters {
		sc_integer param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<InternalOperation2Mock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void InternalOperation2(const sc_integer param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static InternalOperation2Mock* internalOperation2Mock;

class InternalOperation3Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void internalOperation3() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static InternalOperation3Mock* internalOperation3Mock;

class InternalOperation3aMock{
	struct parameters {
		sc_real param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<InternalOperation3aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_real param1){
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_real param1){
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void internalOperation3a(const sc_real param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static InternalOperation3aMock* internalOperation3aMock;

class InternalOperation4Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void internalOperation4() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static InternalOperation4Mock* internalOperation4Mock;

class InternalOperation4aMock{
	struct parameters {
		sc_integer param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<InternalOperation4aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void internalOperation4a(const sc_integer param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static InternalOperation4aMock* internalOperation4aMock;

class InternalOperation5Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void internalOperation5() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static InternalOperation5Mock* internalOperation5Mock;

class InternalOperation5aMock{
	struct parameters {
		const sc_string param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<InternalOperation5aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_string param1){
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_string param1){
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void internalOperation5a(const sc_string param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static InternalOperation5aMock* internalOperation5aMock;

class Interface1InterfaceOperation1Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void interfaceOperation1() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static Interface1InterfaceOperation1Mock* interface1InterfaceOperation1Mock;

class Interface1InterfaceOperation2Mock{
	struct parameters {
		sc_integer param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<Interface1InterfaceOperation2Mock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void InterfaceOperation2(const sc_integer param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static Interface1InterfaceOperation2Mock* interface1InterfaceOperation2Mock;

class Interface1InterfaceOperation3Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void interfaceOperation3() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static Interface1InterfaceOperation3Mock* interface1InterfaceOperation3Mock;

class Interface1InterfaceOperation3aMock{
	struct parameters {
		sc_real param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<Interface1InterfaceOperation3aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_real param1){
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_real param1){
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void interfaceOperation3a(const sc_real param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static Interface1InterfaceOperation3aMock* interface1InterfaceOperation3aMock;

class Interface1InterfaceOperation4Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void interfaceOperation4() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static Interface1InterfaceOperation4Mock* interface1InterfaceOperation4Mock;

class Interface1InterfaceOperation4aMock{
	struct parameters {
		sc_integer param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<Interface1InterfaceOperation4aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void interfaceOperation4a(const sc_integer param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static Interface1InterfaceOperation4aMock* interface1InterfaceOperation4aMock;

class Interface1InterfaceOperation5Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void interfaceOperation5() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static Interface1InterfaceOperation5Mock* interface1InterfaceOperation5Mock;

class Interface1InterfaceOperation5aMock{
	struct parameters {
		const sc_string param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<Interface1InterfaceOperation5aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_string param1){
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_string param1){
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void interfaceOperation5a(const sc_string param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static Interface1InterfaceOperation5aMock* interface1InterfaceOperation5aMock;

class UnnamedInterfaceOperation1Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void unnamedInterfaceOperation1() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static UnnamedInterfaceOperation1Mock* unnamedInterfaceOperation1Mock;

class UnnamedInterfaceOperation2Mock{
	struct parameters {
		sc_integer param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<UnnamedInterfaceOperation2Mock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedInterfaceOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedInterfaceOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void UnnamedInterfaceOperation2(const sc_integer param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedInterfaceOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static UnnamedInterfaceOperation2Mock* unnamedInterfaceOperation2Mock;

class UnnamedOperation3Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void unnamedOperation3() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static UnnamedOperation3Mock* unnamedOperation3Mock;

class UnnamedOperation3aMock{
	struct parameters {
		sc_real param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<UnnamedOperation3aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_real param1){
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_real param1){
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void unnamedOperation3a(const sc_real param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static UnnamedOperation3aMock* unnamedOperation3aMock;

class UnnamedOperation4Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void unnamedOperation4() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static UnnamedOperation4Mock* unnamedOperation4Mock;

class UnnamedOperation4aMock{
	struct parameters {
		sc_integer param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<UnnamedOperation4aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void unnamedOperation4a(const sc_integer param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static UnnamedOperation4aMock* unnamedOperation4aMock;

class UnnamedOperation5Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void unnamedOperation5() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static UnnamedOperation5Mock* unnamedOperation5Mock;

class UnnamedOperation5aMock{
	struct parameters {
		const sc_string param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<UnnamedOperation5aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_string param1){
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_string param1){
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void unnamedOperation5a(const sc_string param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static UnnamedOperation5aMock* unnamedOperation5aMock;

class MockInternal : public Operations::InternalSCI_OCB {
	public:
	void internalOperation1() {
		internalOperation1Mock->internalOperation1();
	}
	sc_boolean InternalOperation2(sc_integer param1) {
		internalOperation2Mock->InternalOperation2(param1);
		return null;
	}
	sc_real internalOperation3() {
		internalOperation3Mock->internalOperation3();
		return null;
	}
	sc_real internalOperation3a(sc_real param1) {
		internalOperation3aMock->internalOperation3a(param1);
		return null;
	}
	sc_integer internalOperation4() {
		internalOperation4Mock->internalOperation4();
		return null;
	}
	sc_integer internalOperation4a(sc_integer param1) {
		internalOperation4aMock->internalOperation4a(param1);
		return null;
	}
	sc_string internalOperation5() {
		internalOperation5Mock->internalOperation5();
		return null;
	}
	sc_string internalOperation5a(sc_string param1) {
		internalOperation5aMock->internalOperation5a(param1);
		return null;
	}
};
class MockInterface1 : public Operations::SCI_Interface1_OCB {
	public:
	void interfaceOperation1() {
		interface1InterfaceOperation1Mock->interfaceOperation1();
	}
	sc_boolean InterfaceOperation2(sc_integer param1) {
		interface1InterfaceOperation2Mock->InterfaceOperation2(param1);
		return null;
	}
	sc_real interfaceOperation3() {
		interface1InterfaceOperation3Mock->interfaceOperation3();
		return null;
	}
	sc_real interfaceOperation3a(sc_real param1) {
		interface1InterfaceOperation3aMock->interfaceOperation3a(param1);
		return null;
	}
	sc_integer interfaceOperation4() {
		interface1InterfaceOperation4Mock->interfaceOperation4();
		return null;
	}
	sc_integer interfaceOperation4a(sc_integer param1) {
		interface1InterfaceOperation4aMock->interfaceOperation4a(param1);
		return null;
	}
	sc_string interfaceOperation5() {
		interface1InterfaceOperation5Mock->interfaceOperation5();
		return null;
	}
	sc_string interfaceOperation5a(sc_string param1) {
		interface1InterfaceOperation5aMock->interfaceOperation5a(param1);
		return null;
	}
};
class MockDefault : public Operations::DefaultSCI_OCB {
	public:
	void unnamedInterfaceOperation1() {
		unnamedInterfaceOperation1Mock->unnamedInterfaceOperation1();
	}
	sc_boolean UnnamedInterfaceOperation2(sc_integer param1) {
		unnamedInterfaceOperation2Mock->UnnamedInterfaceOperation2(param1);
		return null;
	}
	sc_real unnamedOperation3() {
		unnamedOperation3Mock->unnamedOperation3();
		return null;
	}
	sc_real unnamedOperation3a(sc_real param1) {
		unnamedOperation3aMock->unnamedOperation3a(param1);
		return null;
	}
	sc_integer unnamedOperation4() {
		unnamedOperation4Mock->unnamedOperation4();
		return null;
	}
	sc_integer unnamedOperation4a(sc_integer param1) {
		unnamedOperation4aMock->unnamedOperation4a(param1);
		return null;
	}
	sc_string unnamedOperation5() {
		unnamedOperation5Mock->unnamedOperation5();
		return null;
	}
	sc_string unnamedOperation5a(sc_string param1) {
		unnamedOperation5aMock->unnamedOperation5a(param1);
		return null;
	}
	sc_boolean alwaysTrue() {
		return (alwaysTrueMock->*(alwaysTrueMock->getBehavior()))();
	}
};

//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class OperationsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new Operations();
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


TEST_F(OperationsTest, operationsCalled) {
	internalOperation1Mock = new InternalOperation1Mock();
	internalOperation2Mock = new InternalOperation2Mock();
	internalOperation3Mock = new InternalOperation3Mock();
	internalOperation3aMock = new InternalOperation3aMock();
	internalOperation4Mock = new InternalOperation4Mock();
	internalOperation4aMock = new InternalOperation4aMock();
	internalOperation5Mock = new InternalOperation5Mock();
	internalOperation5aMock = new InternalOperation5aMock();
	interface1InterfaceOperation1Mock = new Interface1InterfaceOperation1Mock();
	interface1InterfaceOperation2Mock = new Interface1InterfaceOperation2Mock();
	interface1InterfaceOperation3Mock = new Interface1InterfaceOperation3Mock();
	interface1InterfaceOperation3aMock = new Interface1InterfaceOperation3aMock();
	interface1InterfaceOperation4Mock = new Interface1InterfaceOperation4Mock();
	interface1InterfaceOperation4aMock = new Interface1InterfaceOperation4aMock();
	interface1InterfaceOperation5Mock = new Interface1InterfaceOperation5Mock();
	interface1InterfaceOperation5aMock = new Interface1InterfaceOperation5aMock();
	unnamedInterfaceOperation1Mock = new UnnamedInterfaceOperation1Mock();
	unnamedInterfaceOperation2Mock = new UnnamedInterfaceOperation2Mock();
	unnamedOperation3Mock = new UnnamedOperation3Mock();
	unnamedOperation3aMock = new UnnamedOperation3aMock();
	unnamedOperation4Mock = new UnnamedOperation4Mock();
	unnamedOperation4aMock = new UnnamedOperation4aMock();
	unnamedOperation5Mock = new UnnamedOperation5Mock();
	unnamedOperation5aMock = new UnnamedOperation5aMock();
	alwaysTrueMock = new AlwaysTrueMock();
	alwaysTrueMock->initializeBehavior();
	
	MockDefault defaultMock;
	MockInternal internalMock;
	MockInterface1 interface1Mock;
	statechart->setDefaultSCI_OCB(&defaultMock);
	statechart->setInternalSCI_OCB(&internalMock);
	statechart->setSCI_Interface1_OCB(&interface1Mock);
	alwaysTrueMock->setDefaultBehavior(&AlwaysTrueMock::alwaysTrue1);
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(Operations::main_region_A));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(Operations::main_region_B));
	
	EXPECT_TRUE(internalOperation1Mock->calledAtLeastOnce());
	
	EXPECT_TRUE(internalOperation2Mock->calledAtLeastOnce(4l));
	
	EXPECT_TRUE(internalOperation3Mock->calledAtLeastOnce());
	
	EXPECT_TRUE(internalOperation3aMock->calledAtLeastOnce(1.0));
	
	EXPECT_TRUE(internalOperation4Mock->calledAtLeastOnce());
	
	EXPECT_TRUE(internalOperation4aMock->calledAtLeastOnce(5l));
	
	EXPECT_TRUE(internalOperation5Mock->calledAtLeastOnce());
	
	EXPECT_TRUE(internalOperation5aMock->calledAtLeastOnce());
	
	statechart->getDefaultSCI()->raise_ev();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(Operations::main_region_C));
	
	EXPECT_TRUE(interface1InterfaceOperation1Mock->calledAtLeastOnce());
	
	EXPECT_TRUE(interface1InterfaceOperation2Mock->calledAtLeastOnce(4l));
	
	EXPECT_TRUE(interface1InterfaceOperation3Mock->calledAtLeastOnce());
	
	EXPECT_TRUE(interface1InterfaceOperation3aMock->calledAtLeastOnce(1.0));
	
	EXPECT_TRUE(interface1InterfaceOperation4Mock->calledAtLeastOnce());
	
	EXPECT_TRUE(interface1InterfaceOperation4aMock->calledAtLeastOnce(5l));
	
	EXPECT_TRUE(interface1InterfaceOperation5Mock->calledAtLeastOnce());
	
	EXPECT_TRUE(interface1InterfaceOperation5aMock->calledAtLeastOnce());
	
	statechart->getDefaultSCI()->raise_ev();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(Operations::main_region_D));
	
	EXPECT_TRUE(unnamedInterfaceOperation1Mock->calledAtLeastOnce());
	
	EXPECT_TRUE(unnamedInterfaceOperation2Mock->calledAtLeastOnce(4l));
	
	EXPECT_TRUE(unnamedOperation3Mock->calledAtLeastOnce());
	
	EXPECT_TRUE(unnamedOperation3aMock->calledAtLeastOnce(1.0));
	
	EXPECT_TRUE(unnamedOperation4Mock->calledAtLeastOnce());
	
	EXPECT_TRUE(unnamedOperation4aMock->calledAtLeastOnce(5l));
	
	EXPECT_TRUE(unnamedOperation5Mock->calledAtLeastOnce());
	
	EXPECT_TRUE(unnamedOperation5aMock->calledAtLeastOnce());
	
	
	internalOperation1Mock->reset();
	internalOperation2Mock->reset();
	internalOperation3Mock->reset();
	internalOperation3aMock->reset();
	internalOperation4Mock->reset();
	internalOperation4aMock->reset();
	internalOperation5Mock->reset();
	internalOperation5aMock->reset();
	interface1InterfaceOperation1Mock->reset();
	interface1InterfaceOperation2Mock->reset();
	interface1InterfaceOperation3Mock->reset();
	interface1InterfaceOperation3aMock->reset();
	interface1InterfaceOperation4Mock->reset();
	interface1InterfaceOperation4aMock->reset();
	interface1InterfaceOperation5Mock->reset();
	interface1InterfaceOperation5aMock->reset();
	unnamedInterfaceOperation1Mock->reset();
	unnamedInterfaceOperation2Mock->reset();
	unnamedOperation3Mock->reset();
	unnamedOperation3aMock->reset();
	unnamedOperation4Mock->reset();
	unnamedOperation4aMock->reset();
	unnamedOperation5Mock->reset();
	unnamedOperation5aMock->reset();
	alwaysTrueMock->reset();
}
TEST_F(OperationsTest, operationsNotCalled) {
	internalOperation1Mock = new InternalOperation1Mock();
	internalOperation2Mock = new InternalOperation2Mock();
	internalOperation3Mock = new InternalOperation3Mock();
	internalOperation3aMock = new InternalOperation3aMock();
	internalOperation4Mock = new InternalOperation4Mock();
	internalOperation4aMock = new InternalOperation4aMock();
	internalOperation5Mock = new InternalOperation5Mock();
	internalOperation5aMock = new InternalOperation5aMock();
	interface1InterfaceOperation1Mock = new Interface1InterfaceOperation1Mock();
	interface1InterfaceOperation2Mock = new Interface1InterfaceOperation2Mock();
	interface1InterfaceOperation3Mock = new Interface1InterfaceOperation3Mock();
	interface1InterfaceOperation3aMock = new Interface1InterfaceOperation3aMock();
	interface1InterfaceOperation4Mock = new Interface1InterfaceOperation4Mock();
	interface1InterfaceOperation4aMock = new Interface1InterfaceOperation4aMock();
	interface1InterfaceOperation5Mock = new Interface1InterfaceOperation5Mock();
	interface1InterfaceOperation5aMock = new Interface1InterfaceOperation5aMock();
	unnamedInterfaceOperation1Mock = new UnnamedInterfaceOperation1Mock();
	unnamedInterfaceOperation2Mock = new UnnamedInterfaceOperation2Mock();
	unnamedOperation3Mock = new UnnamedOperation3Mock();
	unnamedOperation3aMock = new UnnamedOperation3aMock();
	unnamedOperation4Mock = new UnnamedOperation4Mock();
	unnamedOperation4aMock = new UnnamedOperation4aMock();
	unnamedOperation5Mock = new UnnamedOperation5Mock();
	unnamedOperation5aMock = new UnnamedOperation5aMock();
	alwaysTrueMock = new AlwaysTrueMock();
	alwaysTrueMock->initializeBehavior();
	
	MockDefault defaultMock;
	MockInternal internalMock;
	MockInterface1 interface1Mock;
	statechart->setDefaultSCI_OCB(&defaultMock);
	statechart->setInternalSCI_OCB(&internalMock);
	statechart->setSCI_Interface1_OCB(&interface1Mock);
	alwaysTrueMock->setDefaultBehavior(&AlwaysTrueMock::alwaysTrue1);
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(Operations::main_region_A));
	
	EXPECT_FALSE(internalOperation1Mock->calledAtLeastOnce());
	
	EXPECT_FALSE(internalOperation2Mock->calledAtLeastOnce(4l));
	
	EXPECT_FALSE(internalOperation3Mock->calledAtLeastOnce());
	
	EXPECT_FALSE(internalOperation3aMock->calledAtLeastOnce(1.0));
	
	EXPECT_FALSE(internalOperation4Mock->calledAtLeastOnce());
	
	EXPECT_FALSE(internalOperation4aMock->calledAtLeastOnce(5l));
	
	EXPECT_FALSE(internalOperation5Mock->calledAtLeastOnce());
	
	EXPECT_FALSE(internalOperation5aMock->calledAtLeastOnce());
	
	statechart->getDefaultSCI()->raise_ev();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(Operations::main_region_B));
	
	EXPECT_FALSE(interface1InterfaceOperation1Mock->calledAtLeastOnce());
	
	EXPECT_FALSE(interface1InterfaceOperation2Mock->calledAtLeastOnce(4l));
	
	EXPECT_FALSE(interface1InterfaceOperation3Mock->calledAtLeastOnce());
	
	EXPECT_FALSE(interface1InterfaceOperation3aMock->calledAtLeastOnce(1.0));
	
	EXPECT_FALSE(interface1InterfaceOperation4Mock->calledAtLeastOnce());
	
	EXPECT_FALSE(interface1InterfaceOperation4aMock->calledAtLeastOnce(5l));
	
	EXPECT_FALSE(interface1InterfaceOperation5Mock->calledAtLeastOnce());
	
	EXPECT_FALSE(interface1InterfaceOperation5aMock->calledAtLeastOnce());
	
	statechart->getDefaultSCI()->raise_ev();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(Operations::main_region_C));
	
	EXPECT_FALSE(unnamedInterfaceOperation1Mock->calledAtLeastOnce());
	
	EXPECT_FALSE(unnamedInterfaceOperation2Mock->calledAtLeastOnce(4l));
	
	EXPECT_FALSE(unnamedOperation3Mock->calledAtLeastOnce());
	
	EXPECT_FALSE(unnamedOperation3aMock->calledAtLeastOnce(1.0));
	
	EXPECT_FALSE(unnamedOperation4Mock->calledAtLeastOnce());
	
	EXPECT_FALSE(unnamedOperation4aMock->calledAtLeastOnce(5l));
	
	EXPECT_FALSE(unnamedOperation5Mock->calledAtLeastOnce());
	
	EXPECT_FALSE(unnamedOperation5aMock->calledAtLeastOnce());
	
	
	internalOperation1Mock->reset();
	internalOperation2Mock->reset();
	internalOperation3Mock->reset();
	internalOperation3aMock->reset();
	internalOperation4Mock->reset();
	internalOperation4aMock->reset();
	internalOperation5Mock->reset();
	internalOperation5aMock->reset();
	interface1InterfaceOperation1Mock->reset();
	interface1InterfaceOperation2Mock->reset();
	interface1InterfaceOperation3Mock->reset();
	interface1InterfaceOperation3aMock->reset();
	interface1InterfaceOperation4Mock->reset();
	interface1InterfaceOperation4aMock->reset();
	interface1InterfaceOperation5Mock->reset();
	interface1InterfaceOperation5aMock->reset();
	unnamedInterfaceOperation1Mock->reset();
	unnamedInterfaceOperation2Mock->reset();
	unnamedOperation3Mock->reset();
	unnamedOperation3aMock->reset();
	unnamedOperation4Mock->reset();
	unnamedOperation4aMock->reset();
	unnamedOperation5Mock->reset();
	unnamedOperation5aMock->reset();
	alwaysTrueMock->reset();
}


}
