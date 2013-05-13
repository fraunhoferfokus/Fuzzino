//   Copyright 2012-2013 Fraunhofer FOKUS
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
package de.fraunhofer.fokus.fuzzing.fuzzino.request;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Number Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getSpecification <em>Specification</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getNoGenerators <em>No Generators</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getGenerators <em>Generators</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getValidValues <em>Valid Values</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getId <em>Id</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getMaxValues <em>Max Values</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getName <em>Name</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getSeed <em>Seed</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getNumberRequest()
 * @model extendedMetaData="name='number_._type' kind='elementOnly'"
 * @generated
 */
public interface NumberRequest extends EObject {
	/**
	 * Returns the value of the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' containment reference.
	 * @see #setSpecification(RequestSpecification)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getNumberRequest_Specification()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='specification' namespace='##targetNamespace'"
	 * @generated
	 */
	RequestSpecification getSpecification();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getSpecification <em>Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' containment reference.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(RequestSpecification value);

	/**
	 * Returns the value of the '<em><b>No Generators</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Generators</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Generators</em>' containment reference.
	 * @see #setNoGenerators(NoGenerators)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getNumberRequest_NoGenerators()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='noGenerators' namespace='##targetNamespace'"
	 * @generated
	 */
	NoGenerators getNoGenerators();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getNoGenerators <em>No Generators</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Generators</em>' containment reference.
	 * @see #getNoGenerators()
	 * @generated
	 */
	void setNoGenerators(NoGenerators value);

	/**
	 * Returns the value of the '<em><b>Generators</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generators</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getNumberRequest_Generators()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='generator' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Generator> getGenerators();

	/**
	 * Returns the value of the '<em><b>Valid Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid Values</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid Values</em>' containment reference.
	 * @see #setValidValues(ValidValues)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getNumberRequest_ValidValues()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='validValues' namespace='##targetNamespace'"
	 * @generated
	 */
	ValidValues getValidValues();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getValidValues <em>Valid Values</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid Values</em>' containment reference.
	 * @see #getValidValues()
	 * @generated
	 */
	void setValidValues(ValidValues value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getNumberRequest_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Max Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Values</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Values</em>' attribute.
	 * @see #setMaxValues(int)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getNumberRequest_MaxValues()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true" suppressedIsSetVisibility="true" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='maxValues'"
	 * @generated
	 */
	int getMaxValues();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getMaxValues <em>Max Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Values</em>' attribute.
	 * @see #getMaxValues()
	 * @generated
	 */
	void setMaxValues(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getNumberRequest_Name()
	 * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID" required="true" suppressedIsSetVisibility="true" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seed</em>' attribute.
	 * @see #isSetSeed()
	 * @see #setSeed(long)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getNumberRequest_Seed()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='seed'"
	 * @generated
	 */
	long getSeed();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getSeed <em>Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seed</em>' attribute.
	 * @see #isSetSeed()
	 * @see #getSeed()
	 * @generated
	 */
	void setSeed(long value);

	/**
	 * Returns whether the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getSeed <em>Seed</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Seed</em>' attribute is set.
	 * @see #getSeed()
	 * @see #setSeed(long)
	 * @generated
	 */
	boolean isSetSeed();

} // NumberRequest
