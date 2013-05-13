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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Field#isFuzz <em>Fuzz</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Field#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getField()
 * @model extendedMetaData="name='field_._type' kind='empty'"
 * @generated
 */
public interface Field extends EObject {
	/**
	 * Returns the value of the '<em><b>Fuzz</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fuzz</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fuzz</em>' attribute.
	 * @see #isSetFuzz()
	 * @see #unsetFuzz()
	 * @see #setFuzz(boolean)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getField_Fuzz()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='fuzz'"
	 * @generated
	 */
	boolean isFuzz();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Field#isFuzz <em>Fuzz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fuzz</em>' attribute.
	 * @see #isSetFuzz()
	 * @see #unsetFuzz()
	 * @see #isFuzz()
	 * @generated
	 */
	void setFuzz(boolean value);

	/**
	 * Unsets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Field#isFuzz <em>Fuzz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFuzz()
	 * @see #isFuzz()
	 * @see #setFuzz(boolean)
	 * @generated
	 */
	void unsetFuzz();

	/**
	 * Returns whether the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Field#isFuzz <em>Fuzz</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Fuzz</em>' attribute is set.
	 * @see #unsetFuzz()
	 * @see #isFuzz()
	 * @see #setFuzz(boolean)
	 * @generated
	 */
	boolean isSetFuzz();

	/**
	 * Returns the value of the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' attribute.
	 * @see #setRef(String)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getField_Ref()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='ref'"
	 * @generated
	 */
	String getRef();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Field#getRef <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' attribute.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(String value);

} // Field
