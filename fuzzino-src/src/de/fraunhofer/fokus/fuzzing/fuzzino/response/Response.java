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
 * A representation of the model object '<em><b>Response</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getStringResponses <em>String Responses</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getNumberResponses <em>Number Responses</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getStructureResponses <em>Structure Responses</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getCollectionResponses <em>Collection Responses</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getCloseRequestConfirmations <em>Close Request Confirmations</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getErrorResponse <em>Error Response</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getResponse()
 * @model extendedMetaData="name='response_._type' kind='elementOnly'"
 * @generated
 */
public interface Response extends EObject {
	/**
	 * Returns the value of the '<em><b>String Responses</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Responses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Responses</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getResponse_StringResponses()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='string' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<StringResponse> getStringResponses();

	/**
	 * Returns the value of the '<em><b>Number Responses</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Responses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Responses</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getResponse_NumberResponses()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='number' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<NumberResponse> getNumberResponses();

	/**
	 * Returns the value of the '<em><b>Structure Responses</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Structure Responses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structure Responses</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getResponse_StructureResponses()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='structure' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<StructureResponse> getStructureResponses();

	/**
	 * Returns the value of the '<em><b>Collection Responses</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Responses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Responses</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getResponse_CollectionResponses()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='collection' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<CollectionResponse> getCollectionResponses();

	/**
	 * Returns the value of the '<em><b>Close Request Confirmations</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Close Request Confirmations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Close Request Confirmations</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getResponse_CloseRequestConfirmations()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='closeRequestDone' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<CloseRequestConfirmation> getCloseRequestConfirmations();

	/**
	 * Returns the value of the '<em><b>Error Response</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Response</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Response</em>' containment reference.
	 * @see #setErrorResponse(ErrorResponse)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getResponse_ErrorResponse()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='error' namespace='##targetNamespace'"
	 * @generated
	 */
	ErrorResponse getErrorResponse();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getErrorResponse <em>Error Response</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Response</em>' containment reference.
	 * @see #getErrorResponse()
	 * @generated
	 */
	void setErrorResponse(ErrorResponse value);

} // Response
