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
package de.fraunhofer.fokus.fuzzing.fuzzino.response;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fuzzed Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getValues <em>Values</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getBasedOn <em>Based On</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getMutations <em>Mutations</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getOperators <em>Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getFuzzedCollection()
 * @model extendedMetaData="name='fuzzedCollection_._type' kind='elementOnly'"
 * @generated
 */
public interface FuzzedCollection extends EObject {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Value}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getFuzzedCollection_Values()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='value' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Value> getValues();

	/**
	 * Returns the value of the '<em><b>Based On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Based On</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Based On</em>' attribute.
	 * @see #setBasedOn(String)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getFuzzedCollection_BasedOn()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='basedOn'"
	 * @generated
	 */
	String getBasedOn();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getBasedOn <em>Based On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Based On</em>' attribute.
	 * @see #getBasedOn()
	 * @generated
	 */
	void setBasedOn(String value);

	/**
	 * Returns the value of the '<em><b>Mutations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mutations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mutations</em>' attribute.
	 * @see #isSetMutations()
	 * @see #unsetMutations()
	 * @see #setMutations(int)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getFuzzedCollection_Mutations()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='attribute' name='mutations'"
	 * @generated
	 */
	int getMutations();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getMutations <em>Mutations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mutations</em>' attribute.
	 * @see #isSetMutations()
	 * @see #unsetMutations()
	 * @see #getMutations()
	 * @generated
	 */
	void setMutations(int value);

	/**
	 * Unsets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getMutations <em>Mutations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMutations()
	 * @see #getMutations()
	 * @see #setMutations(int)
	 * @generated
	 */
	void unsetMutations();

	/**
	 * Returns whether the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getMutations <em>Mutations</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mutations</em>' attribute is set.
	 * @see #unsetMutations()
	 * @see #getMutations()
	 * @see #setMutations(int)
	 * @generated
	 */
	boolean isSetMutations();

	/**
	 * Returns the value of the '<em><b>Operators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' attribute.
	 * @see #setOperators(String)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getFuzzedCollection_Operators()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='operators'"
	 * @generated
	 */
	String getOperators();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getOperators <em>Operators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operators</em>' attribute.
	 * @see #getOperators()
	 * @generated
	 */
	void setOperators(String value);

} // FuzzedCollection
