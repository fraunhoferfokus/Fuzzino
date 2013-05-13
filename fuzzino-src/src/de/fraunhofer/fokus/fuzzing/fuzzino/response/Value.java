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
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Value#getValue <em>Value</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Value#getBasedOn <em>Based On</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Value#getGenerator <em>Generator</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Value#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getValue()
 * @model extendedMetaData="name='value_._type' kind='simple'"
 * @generated
 */
public interface Value extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getValue_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="name=':0' kind='simple'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Value#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

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
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getValue_BasedOn()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName"
	 *        extendedMetaData="kind='attribute' name='basedOn'"
	 * @generated
	 */
	String getBasedOn();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Value#getBasedOn <em>Based On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Based On</em>' attribute.
	 * @see #getBasedOn()
	 * @generated
	 */
	void setBasedOn(String value);

	/**
	 * Returns the value of the '<em><b>Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generator</em>' attribute.
	 * @see #setGenerator(String)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getValue_Generator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName"
	 *        extendedMetaData="kind='attribute' name='generator'"
	 * @generated
	 */
	String getGenerator();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Value#getGenerator <em>Generator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generator</em>' attribute.
	 * @see #getGenerator()
	 * @generated
	 */
	void setGenerator(String value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(String)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getValue_Operator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName"
	 *        extendedMetaData="kind='attribute' name='operator'"
	 * @generated
	 */
	String getOperator();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Value#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(String value);

} // Value
