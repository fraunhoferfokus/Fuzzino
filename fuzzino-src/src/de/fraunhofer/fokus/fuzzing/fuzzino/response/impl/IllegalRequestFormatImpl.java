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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Illegal Request Format</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.IllegalRequestFormatImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.IllegalRequestFormatImpl#getElement <em>Element</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.IllegalRequestFormatImpl#getMissingAttribute <em>Missing Attribute</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.IllegalRequestFormatImpl#getMissingElement <em>Missing Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IllegalRequestFormatImpl extends EObjectImpl implements IllegalRequestFormat {
	/**
	 * The default value of the '{@link #getAttribute() <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected String attribute = ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getElement() <em>Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected String element = ELEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMissingAttribute() <em>Missing Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMissingAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String MISSING_ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMissingAttribute() <em>Missing Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMissingAttribute()
	 * @generated
	 * @ordered
	 */
	protected String missingAttribute = MISSING_ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMissingElement() <em>Missing Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMissingElement()
	 * @generated
	 * @ordered
	 */
	protected static final String MISSING_ELEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMissingElement() <em>Missing Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMissingElement()
	 * @generated
	 * @ordered
	 */
	protected String missingElement = MISSING_ELEMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IllegalRequestFormatImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResponsePackage.Literals.ILLEGAL_REQUEST_FORMAT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(String newAttribute) {
		String oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResponsePackage.ILLEGAL_REQUEST_FORMAT__ATTRIBUTE, oldAttribute, attribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(String newElement) {
		String oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResponsePackage.ILLEGAL_REQUEST_FORMAT__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMissingAttribute() {
		return missingAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMissingAttribute(String newMissingAttribute) {
		String oldMissingAttribute = missingAttribute;
		missingAttribute = newMissingAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResponsePackage.ILLEGAL_REQUEST_FORMAT__MISSING_ATTRIBUTE, oldMissingAttribute, missingAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMissingElement() {
		return missingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMissingElement(String newMissingElement) {
		String oldMissingElement = missingElement;
		missingElement = newMissingElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResponsePackage.ILLEGAL_REQUEST_FORMAT__MISSING_ELEMENT, oldMissingElement, missingElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT__ATTRIBUTE:
				return getAttribute();
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT__ELEMENT:
				return getElement();
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT__MISSING_ATTRIBUTE:
				return getMissingAttribute();
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT__MISSING_ELEMENT:
				return getMissingElement();
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
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT__ATTRIBUTE:
				setAttribute((String)newValue);
				return;
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT__ELEMENT:
				setElement((String)newValue);
				return;
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT__MISSING_ATTRIBUTE:
				setMissingAttribute((String)newValue);
				return;
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT__MISSING_ELEMENT:
				setMissingElement((String)newValue);
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
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT__ATTRIBUTE:
				setAttribute(ATTRIBUTE_EDEFAULT);
				return;
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT__ELEMENT:
				setElement(ELEMENT_EDEFAULT);
				return;
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT__MISSING_ATTRIBUTE:
				setMissingAttribute(MISSING_ATTRIBUTE_EDEFAULT);
				return;
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT__MISSING_ELEMENT:
				setMissingElement(MISSING_ELEMENT_EDEFAULT);
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
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT__ATTRIBUTE:
				return ATTRIBUTE_EDEFAULT == null ? attribute != null : !ATTRIBUTE_EDEFAULT.equals(attribute);
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT__ELEMENT:
				return ELEMENT_EDEFAULT == null ? element != null : !ELEMENT_EDEFAULT.equals(element);
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT__MISSING_ATTRIBUTE:
				return MISSING_ATTRIBUTE_EDEFAULT == null ? missingAttribute != null : !MISSING_ATTRIBUTE_EDEFAULT.equals(missingAttribute);
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT__MISSING_ELEMENT:
				return MISSING_ELEMENT_EDEFAULT == null ? missingElement != null : !MISSING_ELEMENT_EDEFAULT.equals(missingElement);
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
		result.append(" (attribute: ");
		result.append(attribute);
		result.append(", element: ");
		result.append(element);
		result.append(", missingAttribute: ");
		result.append(missingAttribute);
		result.append(", missingElement: ");
		result.append(missingElement);
		result.append(')');
		return result.toString();
	}

} //IllegalRequestFormatImpl
