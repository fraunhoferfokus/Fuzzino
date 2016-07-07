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
 * A representation of the model object '<em><b>Structure Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getSpecification <em>Specification</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getOperators <em>Operators</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#isFuzzStructure <em>Fuzz Structure</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#isFuzzValues <em>Fuzz Values</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getId <em>Id</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getMaxMutations <em>Max Mutations</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getMaxValues <em>Max Values</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getMinMutations <em>Min Mutations</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getName <em>Name</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getSeed <em>Seed</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getStructureRequest()
 * @model extendedMetaData="name='structure_._type' kind='elementOnly'"
 * @generated
 */
public interface StructureRequest extends EObject {
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
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getStructureRequest_Specification()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='specification' namespace='##targetNamespace'"
	 * @generated
	 */
	RequestSpecification getSpecification();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getSpecification <em>Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' containment reference.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(RequestSpecification value);

	/**
	 * Returns the value of the '<em><b>Operators</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getStructureRequest_Operators()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='operator' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Operator> getOperators();

	/**
	 * Returns the value of the '<em><b>Fuzz Structure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fuzz Structure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fuzz Structure</em>' attribute.
	 * @see #setFuzzStructure(boolean)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getStructureRequest_FuzzStructure()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" suppressedIsSetVisibility="true" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='fuzzStructure'"
	 * @generated
	 */
	boolean isFuzzStructure();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#isFuzzStructure <em>Fuzz Structure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuzz Structure</em>' attribute.
	 * @see #isFuzzStructure()
	 * @generated
	 */
	void setFuzzStructure(boolean value);

	/**
	 * Returns the value of the '<em><b>Fuzz Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fuzz Values</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fuzz Values</em>' attribute.
	 * @see #setFuzzValues(boolean)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getStructureRequest_FuzzValues()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" suppressedIsSetVisibility="true" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='fuzzValues'"
	 * @generated
	 */
	boolean isFuzzValues();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#isFuzzValues <em>Fuzz Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuzz Values</em>' attribute.
	 * @see #isFuzzValues()
	 * @generated
	 */
	void setFuzzValues(boolean value);

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
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getStructureRequest_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Max Mutations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Mutations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Mutations</em>' attribute.
	 * @see #setMaxMutations(int)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getStructureRequest_MaxMutations()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" suppressedIsSetVisibility="true" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='maxMutations'"
	 * @generated
	 */
	int getMaxMutations();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getMaxMutations <em>Max Mutations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Mutations</em>' attribute.
	 * @see #getMaxMutations()
	 * @generated
	 */
	void setMaxMutations(int value);

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
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getStructureRequest_MaxValues()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true" suppressedIsSetVisibility="true" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='maxValues'"
	 * @generated
	 */
	int getMaxValues();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getMaxValues <em>Max Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Values</em>' attribute.
	 * @see #getMaxValues()
	 * @generated
	 */
	void setMaxValues(int value);

	/**
	 * Returns the value of the '<em><b>Min Mutations</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Mutations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Mutations</em>' attribute.
	 * @see #setMinMutations(int)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getStructureRequest_MinMutations()
	 * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" suppressedIsSetVisibility="true" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='minMutations'"
	 * @generated
	 */
	int getMinMutations();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getMinMutations <em>Min Mutations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Mutations</em>' attribute.
	 * @see #getMinMutations()
	 * @generated
	 */
	void setMinMutations(int value);

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
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getStructureRequest_Name()
	 * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID" required="true" suppressedIsSetVisibility="true" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getName <em>Name</em>}' attribute.
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
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getStructureRequest_Seed()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='seed'"
	 * @generated
	 */
	long getSeed();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getSeed <em>Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seed</em>' attribute.
	 * @see #isSetSeed()
	 * @see #getSeed()
	 * @generated
	 */
	void setSeed(long value);

	/**
	 * Returns whether the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getSeed <em>Seed</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Seed</em>' attribute is set.
	 * @see #getSeed()
	 * @see #setSeed(long)
	 * @generated
	 */
	boolean isSetSeed();

} // StructureRequest
