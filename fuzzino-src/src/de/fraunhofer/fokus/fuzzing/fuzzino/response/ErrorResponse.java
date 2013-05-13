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
 * A representation of the model object '<em><b>Error Response</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse#getValue <em>Value</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse#getColumn <em>Column</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse#getLine <em>Line</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getErrorResponse()
 * @model extendedMetaData="name='error_._type' kind='simple'"
 * @generated
 */
public interface ErrorResponse extends EObject {
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
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getErrorResponse_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="name=':0' kind='simple'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' attribute.
	 * @see #isSetColumn()
	 * @see #unsetColumn()
	 * @see #setColumn(int)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getErrorResponse_Column()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='attribute' name='column'"
	 * @generated
	 */
	int getColumn();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' attribute.
	 * @see #isSetColumn()
	 * @see #unsetColumn()
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(int value);

	/**
	 * Unsets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetColumn()
	 * @see #getColumn()
	 * @see #setColumn(int)
	 * @generated
	 */
	void unsetColumn();

	/**
	 * Returns whether the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse#getColumn <em>Column</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Column</em>' attribute is set.
	 * @see #unsetColumn()
	 * @see #getColumn()
	 * @see #setColumn(int)
	 * @generated
	 */
	boolean isSetColumn();

	/**
	 * Returns the value of the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line</em>' attribute.
	 * @see #isSetLine()
	 * @see #unsetLine()
	 * @see #setLine(int)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getErrorResponse_Line()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='attribute' name='line'"
	 * @generated
	 */
	int getLine();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse#getLine <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' attribute.
	 * @see #isSetLine()
	 * @see #unsetLine()
	 * @see #getLine()
	 * @generated
	 */
	void setLine(int value);

	/**
	 * Unsets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse#getLine <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLine()
	 * @see #getLine()
	 * @see #setLine(int)
	 * @generated
	 */
	void unsetLine();

	/**
	 * Returns whether the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse#getLine <em>Line</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Line</em>' attribute is set.
	 * @see #unsetLine()
	 * @see #getLine()
	 * @see #setLine(int)
	 * @generated
	 */
	boolean isSetLine();

} // ErrorResponse
