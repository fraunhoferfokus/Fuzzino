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
 * A representation of the model object '<em><b>Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Request#getStringRequests <em>String Requests</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Request#getNumberRequests <em>Number Requests</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Request#getStructureRequests <em>Structure Requests</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Request#getCollectionRequests <em>Collection Requests</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Request#getCloseRequests <em>Close Requests</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequest()
 * @model extendedMetaData="name='request_._type' kind='elementOnly'"
 * @generated
 */
public interface Request extends EObject {
	/**
	 * Returns the value of the '<em><b>String Requests</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Requests</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Requests</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequest_StringRequests()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='string' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<StringRequest> getStringRequests();

	/**
	 * Returns the value of the '<em><b>Number Requests</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Requests</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Requests</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequest_NumberRequests()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='number' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<NumberRequest> getNumberRequests();

	/**
	 * Returns the value of the '<em><b>Structure Requests</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Structure Requests</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structure Requests</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequest_StructureRequests()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='structure' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<StructureRequest> getStructureRequests();

	/**
	 * Returns the value of the '<em><b>Collection Requests</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Requests</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Requests</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequest_CollectionRequests()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='collection' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<CollectionRequest> getCollectionRequests();

	/**
	 * Returns the value of the '<em><b>Close Requests</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Close Requests</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Close Requests</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequest_CloseRequests()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='closeRequest' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<CloseRequest> getCloseRequests();

} // Request
