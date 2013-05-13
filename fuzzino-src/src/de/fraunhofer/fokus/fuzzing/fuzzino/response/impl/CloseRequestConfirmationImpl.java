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

import de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Close Request Confirmation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.CloseRequestConfirmationImpl#getWarnings <em>Warnings</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.CloseRequestConfirmationImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.CloseRequestConfirmationImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CloseRequestConfirmationImpl extends EObjectImpl implements CloseRequestConfirmation {
	/**
	 * The cached value of the '{@link #getWarnings() <em>Warnings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarnings()
	 * @generated
	 * @ordered
	 */
	protected WarningsPart warnings;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CloseRequestConfirmationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResponsePackage.Literals.CLOSE_REQUEST_CONFIRMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WarningsPart getWarnings() {
		return warnings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWarnings(WarningsPart newWarnings, NotificationChain msgs) {
		WarningsPart oldWarnings = warnings;
		warnings = newWarnings;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResponsePackage.CLOSE_REQUEST_CONFIRMATION__WARNINGS, oldWarnings, newWarnings);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarnings(WarningsPart newWarnings) {
		if (newWarnings != warnings) {
			NotificationChain msgs = null;
			if (warnings != null)
				msgs = ((InternalEObject)warnings).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResponsePackage.CLOSE_REQUEST_CONFIRMATION__WARNINGS, null, msgs);
			if (newWarnings != null)
				msgs = ((InternalEObject)newWarnings).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResponsePackage.CLOSE_REQUEST_CONFIRMATION__WARNINGS, null, msgs);
			msgs = basicSetWarnings(newWarnings, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResponsePackage.CLOSE_REQUEST_CONFIRMATION__WARNINGS, newWarnings, newWarnings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResponsePackage.CLOSE_REQUEST_CONFIRMATION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResponsePackage.CLOSE_REQUEST_CONFIRMATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResponsePackage.CLOSE_REQUEST_CONFIRMATION__WARNINGS:
				return basicSetWarnings(null, msgs);
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
			case ResponsePackage.CLOSE_REQUEST_CONFIRMATION__WARNINGS:
				return getWarnings();
			case ResponsePackage.CLOSE_REQUEST_CONFIRMATION__ID:
				return getId();
			case ResponsePackage.CLOSE_REQUEST_CONFIRMATION__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ResponsePackage.CLOSE_REQUEST_CONFIRMATION__WARNINGS:
				setWarnings((WarningsPart)newValue);
				return;
			case ResponsePackage.CLOSE_REQUEST_CONFIRMATION__ID:
				setId((String)newValue);
				return;
			case ResponsePackage.CLOSE_REQUEST_CONFIRMATION__NAME:
				setName((String)newValue);
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
			case ResponsePackage.CLOSE_REQUEST_CONFIRMATION__WARNINGS:
				setWarnings((WarningsPart)null);
				return;
			case ResponsePackage.CLOSE_REQUEST_CONFIRMATION__ID:
				setId(ID_EDEFAULT);
				return;
			case ResponsePackage.CLOSE_REQUEST_CONFIRMATION__NAME:
				setName(NAME_EDEFAULT);
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
			case ResponsePackage.CLOSE_REQUEST_CONFIRMATION__WARNINGS:
				return warnings != null;
			case ResponsePackage.CLOSE_REQUEST_CONFIRMATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ResponsePackage.CLOSE_REQUEST_CONFIRMATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //CloseRequestConfirmationImpl
