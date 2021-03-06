/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.c.types

import com.google.inject.Inject
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sgraph.util.StatechartUtil

import static org.yakindu.sct.generator.c.CGeneratorConstants.*

/**
 * @author andreas muelder
 */
class CTypeSystemAccess implements ICodegenTypeSystemAccess {

	@Inject protected extension ITypeSystem
	@Inject protected extension StatechartUtil
	
	protected static val String ARRAY = "array"
	protected static val String POINTER = "pointer"
	
	override getTargetLanguageName(Type type) {
		val originalType = type?.originType
		switch (originalType) {
			case originalType === null || isVoid(originalType) : 'void'
			case isInteger(originalType): INT_TYPE
			case isReal(originalType): REAL_TYPE
			case isBoolean(originalType): BOOL_TYPE
			case isString(originalType): STRING_TYPE
			EnumerationType case isOriginStatechart(originalType): originalType.printStateEnumType
			ComplexType case isOriginStatechart(originalType): '''«type.name.toFirstUpper»*'''
			default: type.name
		}
	}
	
	override getTargetLanguageName(TypeSpecifier typeSpecifier) {
		return getTargetLanguageName(typeSpecifier?.type)
	}

	protected def printVoidType() {
		'void'
	}

	protected def printBuiltInType(TypeSpecifier typeSpecifier) {
		if (typeSpecifier.type.name == POINTER) {
			return '''«getTargetLanguageName(typeSpecifier.typeArguments.head)» *'''
		} else if (typeSpecifier.type.name == ARRAY) {
			// TODO Array brackets after variable name
			return '''«typeSpecifier.typeArguments.head.type.name»'''
		}
	}
	
	protected def printStateEnumType(EnumerationType type) {
		type.name
	}

	protected def printType(TypeSpecifier typeSpecifier) {
		return getTargetLanguageName(typeSpecifier?.type)
	}


}
