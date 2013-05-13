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
package de.fraunhofer.fokus.fuzzing.fuzzino.request.impl;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Request;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestImpl#getStringRequests <em>String Requests</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestImpl#getNumberRequests <em>Number Requests</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestImpl#getStructureRequests <em>Structure Requests</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestImpl#getCollectionRequests <em>Collection Requests</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestImpl#getCloseRequests <em>Close Requests</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequestImpl extends EObjectImpl implements Request {
	/**
	 * The cached value of the '{@link #getStringRequests() <em>String Requests</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringRequests()
	 * @generated
	 * @ordered
	 */
	protected EList<StringRequest> stringRequests;

	/**
	 * The cached value of the '{@link #getNumberRequests() <em>Number Requests</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberRequests()
	 * @generated
	 * @ordered
	 */
	protected EList<NumberRequest> numberRequests;

	/**
	 * The cached value of the '{@link #getStructureRequests() <em>Structure Requests</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructureRequests()
	 * @generated
	 * @ordered
	 */
	protected EList<StructureRequest> structureRequests;

	/**
	 * The cached value of the '{@link #getCollectionRequests() <em>Collection Requests</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionRequests()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectionRequest> collectionRequests;

	/**
	 * The cached value of the '{@link #getCloseRequests() <em>Close Requests</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCloseRequests()
	 * @generated
	 * @ordered
	 */
	protected EList<CloseRequest> closeRequests;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequestPackage.Literals.REQUEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StringRequest> getStringRequests() {
		if (stringRequests == null) {
			stringRequests = new EObjectContainmentEList<StringRequest>(StringRequest.class, this, RequestPackage.REQUEST__STRING_REQUESTS);
		}
		return stringRequests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NumberRequest> getNumberRequests() {
		if (numberRequests == null) {
			numberRequests = new EObjectContainmentEList<NumberRequest>(NumberRequest.class, this, RequestPackage.REQUEST__NUMBER_REQUESTS);
		}
		return numberRequests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StructureRequest> getStructureRequests() {
		if (structureRequests == null) {
			structureRequests = new EObjectContainmentEList<StructureRequest>(StructureRequest.class, this, RequestPackage.REQUEST__STRUCTURE_REQUESTS);
		}
		return structureRequests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CollectionRequest> getCollectionRequests() {
		if (collectionRequests == null) {
			collectionRequests = new EObjectContainmentEList<CollectionRequest>(CollectionRequest.class, this, RequestPackage.REQUEST__COLLECTION_REQUESTS);
		}
		return collectionRequests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CloseRequest> getCloseRequests() {
		if (closeRequests == null) {
			closeRequests = new EObjectContainmentEList<CloseRequest>(CloseRequest.class, this, RequestPackage.REQUEST__CLOSE_REQUESTS);
		}
		return closeRequests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RequestPackage.REQUEST__STRING_REQUESTS:
				return ((InternalEList<?>)getStringRequests()).basicRemove(otherEnd, msgs);
			case RequestPackage.REQUEST__NUMBER_REQUESTS:
				return ((InternalEList<?>)getNumberRequests()).basicRemove(otherEnd, msgs);
			case RequestPackage.REQUEST__STRUCTURE_REQUESTS:
				return ((InternalEList<?>)getStructureRequests()).basicRemove(otherEnd, msgs);
			case RequestPackage.REQUEST__COLLECTION_REQUESTS:
				return ((InternalEList<?>)getCollectionRequests()).basicRemove(otherEnd, msgs);
			case RequestPackage.REQUEST__CLOSE_REQUESTS:
				return ((InternalEList<?>)getCloseRequests()).basicRemove(otherEnd, msgs);
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
			case RequestPackage.REQUEST__STRING_REQUESTS:
				return getStringRequests();
			case RequestPackage.REQUEST__NUMBER_REQUESTS:
				return getNumberRequests();
			case RequestPackage.REQUEST__STRUCTURE_REQUESTS:
				return getStructureRequests();
			case RequestPackage.REQUEST__COLLECTION_REQUESTS:
				return getCollectionRequests();
			case RequestPackage.REQUEST__CLOSE_REQUESTS:
				return getCloseRequests();
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
			case RequestPackage.REQUEST__STRING_REQUESTS:
				getStringRequests().clear();
				getStringRequests().addAll((Collection<? extends StringRequest>)newValue);
				return;
			case RequestPackage.REQUEST__NUMBER_REQUESTS:
				getNumberRequests().clear();
				getNumberRequests().addAll((Collection<? extends NumberRequest>)newValue);
				return;
			case RequestPackage.REQUEST__STRUCTURE_REQUESTS:
				getStructureRequests().clear();
				getStructureRequests().addAll((Collection<? extends StructureRequest>)newValue);
				return;
			case RequestPackage.REQUEST__COLLECTION_REQUESTS:
				getCollectionRequests().clear();
				getCollectionRequests().addAll((Collection<? extends CollectionRequest>)newValue);
				return;
			case RequestPackage.REQUEST__CLOSE_REQUESTS:
				getCloseRequests().clear();
				getCloseRequests().addAll((Collection<? extends CloseRequest>)newValue);
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
			case RequestPackage.REQUEST__STRING_REQUESTS:
				getStringRequests().clear();
				return;
			case RequestPackage.REQUEST__NUMBER_REQUESTS:
				getNumberRequests().clear();
				return;
			case RequestPackage.REQUEST__STRUCTURE_REQUESTS:
				getStructureRequests().clear();
				return;
			case RequestPackage.REQUEST__COLLECTION_REQUESTS:
				getCollectionRequests().clear();
				return;
			case RequestPackage.REQUEST__CLOSE_REQUESTS:
				getCloseRequests().clear();
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
			case RequestPackage.REQUEST__STRING_REQUESTS:
				return stringRequests != null && !stringRequests.isEmpty();
			case RequestPackage.REQUEST__NUMBER_REQUESTS:
				return numberRequests != null && !numberRequests.isEmpty();
			case RequestPackage.REQUEST__STRUCTURE_REQUESTS:
				return structureRequests != null && !structureRequests.isEmpty();
			case RequestPackage.REQUEST__COLLECTION_REQUESTS:
				return collectionRequests != null && !collectionRequests.isEmpty();
			case RequestPackage.REQUEST__CLOSE_REQUESTS:
				return closeRequests != null && !closeRequests.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RequestImpl
