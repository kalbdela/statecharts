/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sruntime;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.yakindu.base.base.BasePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.model.sruntime.SRuntimeFactory
 * @model kind="package"
 * @generated
 */
public interface SRuntimePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sruntime";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.yakindu.org/sct/sruntime/2.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sruntime";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SRuntimePackage eINSTANCE = org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sruntime.impl.ExecutionContextImpl <em>Execution Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sruntime.impl.ExecutionContextImpl
	 * @see org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl#getExecutionContext()
	 * @generated
	 */
	int EXECUTION_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__NAME = BasePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__VALUE = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fq Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__FQ_NAME = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Writable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__WRITABLE = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__TYPE = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Slots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__SLOTS = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Active States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__ACTIVE_STATES = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Executed Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__EXECUTED_ELEMENTS = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Suspended Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__SUSPENDED_ELEMENTS = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Context Fqn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__CONTEXT_FQN = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Snapshot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__SNAPSHOT = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Execution Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT_FEATURE_COUNT = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sruntime.impl.ExecutionSlotImpl <em>Execution Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sruntime.impl.ExecutionSlotImpl
	 * @see org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl#getExecutionSlot()
	 * @generated
	 */
	int EXECUTION_SLOT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SLOT__NAME = BasePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SLOT__VALUE = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fq Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SLOT__FQ_NAME = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Writable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SLOT__WRITABLE = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SLOT__TYPE = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Execution Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SLOT_FEATURE_COUNT = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sruntime.impl.ExecutionEventImpl <em>Execution Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sruntime.impl.ExecutionEventImpl
	 * @see org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl#getExecutionEvent()
	 * @generated
	 */
	int EXECUTION_EVENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_EVENT__NAME = EXECUTION_SLOT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_EVENT__VALUE = EXECUTION_SLOT__VALUE;

	/**
	 * The feature id for the '<em><b>Fq Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_EVENT__FQ_NAME = EXECUTION_SLOT__FQ_NAME;

	/**
	 * The feature id for the '<em><b>Writable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_EVENT__WRITABLE = EXECUTION_SLOT__WRITABLE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_EVENT__TYPE = EXECUTION_SLOT__TYPE;

	/**
	 * The feature id for the '<em><b>Raised</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_EVENT__RAISED = EXECUTION_SLOT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_EVENT__DIRECTION = EXECUTION_SLOT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Execution Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_EVENT_FEATURE_COUNT = EXECUTION_SLOT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sruntime.impl.ExecutionVariableImpl <em>Execution Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sruntime.impl.ExecutionVariableImpl
	 * @see org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl#getExecutionVariable()
	 * @generated
	 */
	int EXECUTION_VARIABLE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_VARIABLE__NAME = EXECUTION_SLOT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_VARIABLE__VALUE = EXECUTION_SLOT__VALUE;

	/**
	 * The feature id for the '<em><b>Fq Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_VARIABLE__FQ_NAME = EXECUTION_SLOT__FQ_NAME;

	/**
	 * The feature id for the '<em><b>Writable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_VARIABLE__WRITABLE = EXECUTION_SLOT__WRITABLE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_VARIABLE__TYPE = EXECUTION_SLOT__TYPE;

	/**
	 * The number of structural features of the '<em>Execution Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_VARIABLE_FEATURE_COUNT = EXECUTION_SLOT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sruntime.impl.CompositeSlotImpl <em>Composite Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sruntime.impl.CompositeSlotImpl
	 * @see org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl#getCompositeSlot()
	 * @generated
	 */
	int COMPOSITE_SLOT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SLOT__NAME = EXECUTION_SLOT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SLOT__VALUE = EXECUTION_SLOT__VALUE;

	/**
	 * The feature id for the '<em><b>Fq Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SLOT__FQ_NAME = EXECUTION_SLOT__FQ_NAME;

	/**
	 * The feature id for the '<em><b>Writable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SLOT__WRITABLE = EXECUTION_SLOT__WRITABLE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SLOT__TYPE = EXECUTION_SLOT__TYPE;

	/**
	 * The feature id for the '<em><b>Slots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SLOT__SLOTS = EXECUTION_SLOT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SLOT_FEATURE_COUNT = EXECUTION_SLOT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sruntime.impl.ReferenceSlotImpl <em>Reference Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sruntime.impl.ReferenceSlotImpl
	 * @see org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl#getReferenceSlot()
	 * @generated
	 */
	int REFERENCE_SLOT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SLOT__NAME = COMPOSITE_SLOT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SLOT__VALUE = COMPOSITE_SLOT__VALUE;

	/**
	 * The feature id for the '<em><b>Fq Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SLOT__FQ_NAME = COMPOSITE_SLOT__FQ_NAME;

	/**
	 * The feature id for the '<em><b>Writable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SLOT__WRITABLE = COMPOSITE_SLOT__WRITABLE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SLOT__TYPE = COMPOSITE_SLOT__TYPE;

	/**
	 * The feature id for the '<em><b>Slots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SLOT__SLOTS = COMPOSITE_SLOT__SLOTS;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SLOT__REFERENCE = COMPOSITE_SLOT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SLOT_FEATURE_COUNT = COMPOSITE_SLOT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sruntime.impl.ExecutionOperationImpl <em>Execution Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sruntime.impl.ExecutionOperationImpl
	 * @see org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl#getExecutionOperation()
	 * @generated
	 */
	int EXECUTION_OPERATION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_OPERATION__NAME = EXECUTION_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_OPERATION__VALUE = EXECUTION_VARIABLE__VALUE;

	/**
	 * The feature id for the '<em><b>Fq Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_OPERATION__FQ_NAME = EXECUTION_VARIABLE__FQ_NAME;

	/**
	 * The feature id for the '<em><b>Writable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_OPERATION__WRITABLE = EXECUTION_VARIABLE__WRITABLE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_OPERATION__TYPE = EXECUTION_VARIABLE__TYPE;

	/**
	 * The number of structural features of the '<em>Execution Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_OPERATION_FEATURE_COUNT = EXECUTION_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '<em>Java Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl#getJavaObject()
	 * @generated
	 */
	int JAVA_OBJECT = 7;


	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sruntime.ExecutionContext <em>Execution Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Context</em>'.
	 * @see org.yakindu.sct.model.sruntime.ExecutionContext
	 * @generated
	 */
	EClass getExecutionContext();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.model.sruntime.ExecutionContext#getActiveStates <em>Active States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Active States</em>'.
	 * @see org.yakindu.sct.model.sruntime.ExecutionContext#getActiveStates()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_ActiveStates();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.model.sruntime.ExecutionContext#getExecutedElements <em>Executed Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Executed Elements</em>'.
	 * @see org.yakindu.sct.model.sruntime.ExecutionContext#getExecutedElements()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_ExecutedElements();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.model.sruntime.ExecutionContext#getSuspendedElements <em>Suspended Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Suspended Elements</em>'.
	 * @see org.yakindu.sct.model.sruntime.ExecutionContext#getSuspendedElements()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_SuspendedElements();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sruntime.ExecutionContext#getContextFqn <em>Context Fqn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context Fqn</em>'.
	 * @see org.yakindu.sct.model.sruntime.ExecutionContext#getContextFqn()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_ContextFqn();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sruntime.ExecutionContext#isSnapshot <em>Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snapshot</em>'.
	 * @see org.yakindu.sct.model.sruntime.ExecutionContext#isSnapshot()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EAttribute getExecutionContext_Snapshot();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sruntime.ExecutionEvent <em>Execution Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Event</em>'.
	 * @see org.yakindu.sct.model.sruntime.ExecutionEvent
	 * @generated
	 */
	EClass getExecutionEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sruntime.ExecutionEvent#isRaised <em>Raised</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Raised</em>'.
	 * @see org.yakindu.sct.model.sruntime.ExecutionEvent#isRaised()
	 * @see #getExecutionEvent()
	 * @generated
	 */
	EAttribute getExecutionEvent_Raised();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sruntime.ExecutionEvent#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.yakindu.sct.model.sruntime.ExecutionEvent#getDirection()
	 * @see #getExecutionEvent()
	 * @generated
	 */
	EAttribute getExecutionEvent_Direction();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sruntime.ExecutionSlot <em>Execution Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Slot</em>'.
	 * @see org.yakindu.sct.model.sruntime.ExecutionSlot
	 * @generated
	 */
	EClass getExecutionSlot();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sruntime.ExecutionSlot#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.yakindu.sct.model.sruntime.ExecutionSlot#getValue()
	 * @see #getExecutionSlot()
	 * @generated
	 */
	EAttribute getExecutionSlot_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sruntime.ExecutionSlot#getFqName <em>Fq Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fq Name</em>'.
	 * @see org.yakindu.sct.model.sruntime.ExecutionSlot#getFqName()
	 * @see #getExecutionSlot()
	 * @generated
	 */
	EAttribute getExecutionSlot_FqName();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sruntime.ExecutionSlot#isWritable <em>Writable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Writable</em>'.
	 * @see org.yakindu.sct.model.sruntime.ExecutionSlot#isWritable()
	 * @see #getExecutionSlot()
	 * @generated
	 */
	EAttribute getExecutionSlot_Writable();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sruntime.ExecutionSlot#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.yakindu.sct.model.sruntime.ExecutionSlot#getType()
	 * @see #getExecutionSlot()
	 * @generated
	 */
	EReference getExecutionSlot_Type();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sruntime.ExecutionVariable <em>Execution Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Variable</em>'.
	 * @see org.yakindu.sct.model.sruntime.ExecutionVariable
	 * @generated
	 */
	EClass getExecutionVariable();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sruntime.CompositeSlot <em>Composite Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Slot</em>'.
	 * @see org.yakindu.sct.model.sruntime.CompositeSlot
	 * @generated
	 */
	EClass getCompositeSlot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sruntime.CompositeSlot#getSlots <em>Slots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Slots</em>'.
	 * @see org.yakindu.sct.model.sruntime.CompositeSlot#getSlots()
	 * @see #getCompositeSlot()
	 * @generated
	 */
	EReference getCompositeSlot_Slots();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sruntime.ReferenceSlot <em>Reference Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Slot</em>'.
	 * @see org.yakindu.sct.model.sruntime.ReferenceSlot
	 * @generated
	 */
	EClass getReferenceSlot();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sruntime.ReferenceSlot#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see org.yakindu.sct.model.sruntime.ReferenceSlot#getReference()
	 * @see #getReferenceSlot()
	 * @generated
	 */
	EReference getReferenceSlot_Reference();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sruntime.ExecutionOperation <em>Execution Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Operation</em>'.
	 * @see org.yakindu.sct.model.sruntime.ExecutionOperation
	 * @generated
	 */
	EClass getExecutionOperation();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Java Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Java Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getJavaObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SRuntimeFactory getSRuntimeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sruntime.impl.ExecutionContextImpl <em>Execution Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sruntime.impl.ExecutionContextImpl
		 * @see org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl#getExecutionContext()
		 * @generated
		 */
		EClass EXECUTION_CONTEXT = eINSTANCE.getExecutionContext();

		/**
		 * The meta object literal for the '<em><b>Active States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_CONTEXT__ACTIVE_STATES = eINSTANCE.getExecutionContext_ActiveStates();

		/**
		 * The meta object literal for the '<em><b>Executed Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_CONTEXT__EXECUTED_ELEMENTS = eINSTANCE.getExecutionContext_ExecutedElements();

		/**
		 * The meta object literal for the '<em><b>Suspended Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_CONTEXT__SUSPENDED_ELEMENTS = eINSTANCE.getExecutionContext_SuspendedElements();

		/**
		 * The meta object literal for the '<em><b>Context Fqn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_CONTEXT__CONTEXT_FQN = eINSTANCE.getExecutionContext_ContextFqn();

		/**
		 * The meta object literal for the '<em><b>Snapshot</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_CONTEXT__SNAPSHOT = eINSTANCE.getExecutionContext_Snapshot();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sruntime.impl.ExecutionEventImpl <em>Execution Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sruntime.impl.ExecutionEventImpl
		 * @see org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl#getExecutionEvent()
		 * @generated
		 */
		EClass EXECUTION_EVENT = eINSTANCE.getExecutionEvent();

		/**
		 * The meta object literal for the '<em><b>Raised</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_EVENT__RAISED = eINSTANCE.getExecutionEvent_Raised();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_EVENT__DIRECTION = eINSTANCE.getExecutionEvent_Direction();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sruntime.impl.ExecutionSlotImpl <em>Execution Slot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sruntime.impl.ExecutionSlotImpl
		 * @see org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl#getExecutionSlot()
		 * @generated
		 */
		EClass EXECUTION_SLOT = eINSTANCE.getExecutionSlot();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_SLOT__VALUE = eINSTANCE.getExecutionSlot_Value();

		/**
		 * The meta object literal for the '<em><b>Fq Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_SLOT__FQ_NAME = eINSTANCE.getExecutionSlot_FqName();

		/**
		 * The meta object literal for the '<em><b>Writable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_SLOT__WRITABLE = eINSTANCE.getExecutionSlot_Writable();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_SLOT__TYPE = eINSTANCE.getExecutionSlot_Type();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sruntime.impl.ExecutionVariableImpl <em>Execution Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sruntime.impl.ExecutionVariableImpl
		 * @see org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl#getExecutionVariable()
		 * @generated
		 */
		EClass EXECUTION_VARIABLE = eINSTANCE.getExecutionVariable();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sruntime.impl.CompositeSlotImpl <em>Composite Slot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sruntime.impl.CompositeSlotImpl
		 * @see org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl#getCompositeSlot()
		 * @generated
		 */
		EClass COMPOSITE_SLOT = eINSTANCE.getCompositeSlot();

		/**
		 * The meta object literal for the '<em><b>Slots</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_SLOT__SLOTS = eINSTANCE.getCompositeSlot_Slots();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sruntime.impl.ReferenceSlotImpl <em>Reference Slot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sruntime.impl.ReferenceSlotImpl
		 * @see org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl#getReferenceSlot()
		 * @generated
		 */
		EClass REFERENCE_SLOT = eINSTANCE.getReferenceSlot();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_SLOT__REFERENCE = eINSTANCE.getReferenceSlot_Reference();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sruntime.impl.ExecutionOperationImpl <em>Execution Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sruntime.impl.ExecutionOperationImpl
		 * @see org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl#getExecutionOperation()
		 * @generated
		 */
		EClass EXECUTION_OPERATION = eINSTANCE.getExecutionOperation();

		/**
		 * The meta object literal for the '<em>Java Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.yakindu.sct.model.sruntime.impl.SRuntimePackageImpl#getJavaObject()
		 * @generated
		 */
		EDataType JAVA_OBJECT = eINSTANCE.getJavaObject();

	}

} //SRuntimePackage
