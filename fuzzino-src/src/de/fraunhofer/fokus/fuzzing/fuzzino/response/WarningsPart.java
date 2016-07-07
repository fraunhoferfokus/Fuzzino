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
 * A representation of the model object '<em><b>Warnings Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart#getIllegalGenerators <em>Illegal Generators</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart#getIllegalOperators <em>Illegal Operators</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart#getIllegalRequestFormats <em>Illegal Request Formats</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart#getFlagNoMoreValues <em>Flag No More Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getWarningsPart()
 * @model extendedMetaData="name='warnings_._type' kind='elementOnly'"
 * @generated
 */
public interface WarningsPart extends EObject {
	/**
	 * Returns the value of the '<em><b>Illegal Generators</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Illegal Generators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Illegal Generators</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getWarningsPart_IllegalGenerators()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='illegalGenerator' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<IllegalGenerator> getIllegalGenerators();

	/**
	 * Returns the value of the '<em><b>Illegal Operators</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Illegal Operators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Illegal Operators</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getWarningsPart_IllegalOperators()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='illegalOperator' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<IllegalOperator> getIllegalOperators();

	/**
	 * Returns the value of the '<em><b>Illegal Request Formats</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Illegal Request Formats</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Illegal Request Formats</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getWarningsPart_IllegalRequestFormats()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='illegalRequestFormat' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<IllegalRequestFormat> getIllegalRequestFormats();

	/**
	 * Returns the value of the '<em><b>Flag No More Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flag No More Values</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flag No More Values</em>' containment reference.
	 * @see #setFlagNoMoreValues(NoMoreValuesIndicator)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getWarningsPart_FlagNoMoreValues()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='noMoreValuesAvailable' namespace='##targetNamespace'"
	 * @generated
	 */
	NoMoreValuesIndicator getFlagNoMoreValues();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart#getFlagNoMoreValues <em>Flag No More Values</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flag No More Values</em>' containment reference.
	 * @see #getFlagNoMoreValues()
	 * @generated
	 */
	void setFlagNoMoreValues(NoMoreValuesIndicator value);

} // WarningsPart
