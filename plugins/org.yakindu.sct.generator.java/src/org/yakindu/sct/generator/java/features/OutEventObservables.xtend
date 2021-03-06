package org.yakindu.sct.generator.java.features

import com.google.inject.Inject
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Event
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.sexec.extensions.SExecExtensions

class OutEventObservables {
	
	@Inject extension ICodegenTypeSystemAccess
	@Inject extension Naming
	@Inject extension SExecExtensions
	
	def getEventType(Event it) {
		if (hasValue) {
			val typeName = typeSpecifier.targetLanguageName
			return if (type instanceof ComplexType) typeName else typeName.toFirstUpper
		}
		return "Void"
	}
	
	def getObservableGetterName(Event it) '''get«identifier.toString.toFirstUpper»'''
	
	def getObservableName(Event it) '''«identifier»Observable'''
	
	def getObserverName(Event shadowEvent) '''«shadowEvent.name»_observer'''
	
	def getObserverType(Event it) '''«observerClass»<«eventType»>'''
	
	def getObservableType(Event it) '''«observableClass»<«eventType»>'''
	
	def observableClass() { "Observable" }
	
	def observerClass() { "Observer" }
	
	def rxPackage() 	{ "org.yakindu.sct.rx" }
	def rxPackagePath() { "org/yakindu/sct/rx" }
}