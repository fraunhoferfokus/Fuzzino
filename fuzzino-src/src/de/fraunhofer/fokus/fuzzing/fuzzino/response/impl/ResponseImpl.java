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
package de.fraunhofer.fokus.fuzzing.fuzzino.response.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Response;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Response</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponseImpl#getStringResponses <em>String Responses</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponseImpl#getNumberResponses <em>Number Responses</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponseImpl#getStructureResponses <em>Structure Responses</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponseImpl#getCollectionResponses <em>Collection Responses</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponseImpl#getCloseRequestConfirmations <em>Close Request Confirmations</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponseImpl#getErrorResponse <em>Error Response</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResponseImpl extends EObjectImpl implements Response {
	/**
	 * The cached value of the '{@link #getStringResponses() <em>String Responses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringResponses()
	 * @generated
	 * @ordered
	 */
	protected EList<StringResponse> stringResponses;

	/**
	 * The cached value of the '{@link #getNumberResponses() <em>Number Responses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberResponses()
	 * @generated
	 * @ordered
	 */
	protected EList<NumberResponse> numberResponses;

	/**
	 * The cached value of the '{@link #getStructureResponses() <em>Structure Responses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructureResponses()
	 * @generated
	 * @ordered
	 */
	protected EList<StructureResponse> structureResponses;

	/**
	 * The cached value of the '{@link #getCollectionResponses() <em>Collection Responses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionResponses()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectionResponse> collectionResponses;

	/**
	 * The cached value of the '{@link #getCloseRequestConfirmations() <em>Close Request Confirmations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCloseRequestConfirmations()
	 * @generated
	 * @ordered
	 */
	protected EList<CloseRequestConfirmation> closeRequestConfirmations;

	/**
	 * The cached value of the '{@link #getErrorResponse() <em>Error Response</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorResponse()
	 * @generated
	 * @ordered
	 */
	protected ErrorResponse errorResponse;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResponseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResponsePackage.Literals.RESPONSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StringResponse> getStringResponses() {
		if (stringResponses == null) {
			stringResponses = new EObjectContainmentEList<StringResponse>(StringResponse.class, this, ResponsePackage.RESPONSE__STRING_RESPONSES);
		}
		return stringResponses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NumberResponse> getNumberResponses() {
		if (numberResponses == null) {
			numberResponses = new EObjectContainmentEList<NumberResponse>(NumberResponse.class, this, ResponsePackage.RESPONSE__NUMBER_RESPONSES);
		}
		return numberResponses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StructureResponse> getStructureResponses() {
		if (structureResponses == null) {
			structureResponses = new EObjectContainmentEList<StructureResponse>(StructureResponse.class, this, ResponsePackage.RESPONSE__STRUCTURE_RESPONSES);
		}
		return structureResponses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CollectionResponse> getCollectionResponses() {
		if (collectionResponses == null) {
			collectionResponses = new EObjectContainmentEList<CollectionResponse>(CollectionResponse.class, this, ResponsePackage.RESPONSE__COLLECTION_RESPONSES);
		}
		return collectionResponses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CloseRequestConfirmation> getCloseRequestConfirmations() {
		if (closeRequestConfirmations == null) {
			closeRequestConfirmations = new EObjectContainmentEList<CloseRequestConfirmation>(CloseRequestConfirmation.class, this, ResponsePackage.RESPONSE__CLOSE_REQUEST_CONFIRMATIONS);
		}
		return closeRequestConfirmations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetErrorResponse(ErrorResponse newErrorResponse, NotificationChain msgs) {
		ErrorResponse oldErrorResponse = errorResponse;
		errorResponse = newErrorResponse;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResponsePackage.RESPONSE__ERROR_RESPONSE, oldErrorResponse, newErrorResponse);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorResponse(ErrorResponse newErrorResponse) {
		if (newErrorResponse != errorResponse) {
			NotificationChain msgs = null;
			if (errorResponse != null)
				msgs = ((InternalEObject)errorResponse).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResponsePackage.RESPONSE__ERROR_RESPONSE, null, msgs);
			if (newErrorResponse != null)
				msgs = ((InternalEObject)newErrorResponse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResponsePackage.RESPONSE__ERROR_RESPONSE, null, msgs);
			msgs = basicSetErrorResponse(newErrorResponse, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResponsePackage.RESPONSE__ERROR_RESPONSE, newErrorResponse, newErrorResponse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResponsePackage.RESPONSE__STRING_RESPONSES:
				return ((InternalEList<?>)getStringResponses()).basicRemove(otherEnd, msgs);
			case ResponsePackage.RESPONSE__NUMBER_RESPONSES:
				return ((InternalEList<?>)getNumberResponses()).basicRemove(otherEnd, msgs);
			case ResponsePackage.RESPONSE__STRUCTURE_RESPONSES:
				return ((InternalEList<?>)getStructureResponses()).basicRemove(otherEnd, msgs);
			case ResponsePackage.RESPONSE__COLLECTION_RESPONSES:
				return ((InternalEList<?>)getCollectionResponses()).basicRemove(otherEnd, msgs);
			case ResponsePackage.RESPONSE__CLOSE_REQUEST_CONFIRMATIONS:
				return ((InternalEList<?>)getCloseRequestConfirmations()).basicRemove(otherEnd, msgs);
			case ResponsePackage.RESPONSE__ERROR_RESPONSE:
				return basicSetErrorResponse(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResponsePackage.RESPONSE__STRING_RESPONSES:
				return getStringResponses();
			case ResponsePackage.RESPONSE__NUMBER_RESPONSES:
				return getNumberResponses();
			case ResponsePackage.RESPONSE__STRUCTURE_RESPONSES:
				return getStructureResponses();
			case ResponsePackage.RESPONSE__COLLECTION_RESPONSES:
				return getCollectionResponses();
			case ResponsePackage.RESPONSE__CLOSE_REQUEST_CONFIRMATIONS:
				return getCloseRequestConfirmations();
			case ResponsePackage.RESPONSE__ERROR_RESPONSE:
				return getErrorResponse();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ResponsePackage.RESPONSE__STRING_RESPONSES:
				getStringResponses().clear();
				getStringResponses().addAll((Collection<? extends StringResponse>)newValue);
				return;
			case ResponsePackage.RESPONSE__NUMBER_RESPONSES:
				getNumberResponses().clear();
				getNumberResponses().addAll((Collection<? extends NumberResponse>)newValue);
				return;
			case ResponsePackage.RESPONSE__STRUCTURE_RESPONSES:
				getStructureResponses().clear();
				getStructureResponses().addAll((Collection<? extends StructureResponse>)newValue);
				return;
			case ResponsePackage.RESPONSE__COLLECTION_RESPONSES:
				getCollectionResponses().clear();
				getCollectionResponses().addAll((Collection<? extends CollectionResponse>)newValue);
				return;
			case ResponsePackage.RESPONSE__CLOSE_REQUEST_CONFIRMATIONS:
				getCloseRequestConfirmations().clear();
				getCloseRequestConfirmations().addAll((Collection<? extends CloseRequestConfirmation>)newValue);
				return;
			case ResponsePackage.RESPONSE__ERROR_RESPONSE:
				setErrorResponse((ErrorResponse)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ResponsePackage.RESPONSE__STRING_RESPONSES:
				getStringResponses().clear();
				return;
			case ResponsePackage.RESPONSE__NUMBER_RESPONSES:
				getNumberResponses().clear();
				return;
			case ResponsePackage.RESPONSE__STRUCTURE_RESPONSES:
				getStructureResponses().clear();
				return;
			case ResponsePackage.RESPONSE__COLLECTION_RESPONSES:
				getCollectionResponses().clear();
				return;
			case ResponsePackage.RESPONSE__CLOSE_REQUEST_CONFIRMATIONS:
				getCloseRequestConfirmations().clear();
				return;
			case ResponsePackage.RESPONSE__ERROR_RESPONSE:
				setErrorResponse((ErrorResponse)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ResponsePackage.RESPONSE__STRING_RESPONSES:
				return stringResponses != null && !stringResponses.isEmpty();
			case ResponsePackage.RESPONSE__NUMBER_RESPONSES:
				return numberResponses != null && !numberResponses.isEmpty();
			case ResponsePackage.RESPONSE__STRUCTURE_RESPONSES:
				return structureResponses != null && !structureResponses.isEmpty();
			case ResponsePackage.RESPONSE__COLLECTION_RESPONSES:
				return collectionResponses != null && !collectionResponses.isEmpty();
			case ResponsePackage.RESPONSE__CLOSE_REQUEST_CONFIRMATIONS:
				return closeRequestConfirmations != null && !closeRequestConfirmations.isEmpty();
			case ResponsePackage.RESPONSE__ERROR_RESPONSE:
				return errorResponse != null;
		}
		return super.eIsSet(featureID);
	}

} //ResponseImpl
