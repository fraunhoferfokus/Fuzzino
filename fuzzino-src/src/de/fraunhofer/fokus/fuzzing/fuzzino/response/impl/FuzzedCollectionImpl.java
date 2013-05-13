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

import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Value;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fuzzed Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FuzzedCollectionImpl#getValues <em>Values</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FuzzedCollectionImpl#getBasedOn <em>Based On</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FuzzedCollectionImpl#getMutations <em>Mutations</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FuzzedCollectionImpl#getOperators <em>Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FuzzedCollectionImpl extends EObjectImpl implements FuzzedCollection {
	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> values;

	/**
	 * The default value of the '{@link #getBasedOn() <em>Based On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasedOn()
	 * @generated
	 * @ordered
	 */
	protected static final String BASED_ON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBasedOn() <em>Based On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasedOn()
	 * @generated
	 * @ordered
	 */
	protected String basedOn = BASED_ON_EDEFAULT;

	/**
	 * The default value of the '{@link #getMutations() <em>Mutations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutations()
	 * @generated
	 * @ordered
	 */
	protected static final int MUTATIONS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMutations() <em>Mutations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutations()
	 * @generated
	 * @ordered
	 */
	protected int mutations = MUTATIONS_EDEFAULT;

	/**
	 * This is true if the Mutations attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean mutationsESet;

	/**
	 * The default value of the '{@link #getOperators() <em>Operators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATORS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperators() <em>Operators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
	protected String operators = OPERATORS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FuzzedCollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResponsePackage.Literals.FUZZED_COLLECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getValues() {
		if (values == null) {
			values = new EObjectContainmentEList<Value>(Value.class, this, ResponsePackage.FUZZED_COLLECTION__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBasedOn() {
		return basedOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasedOn(String newBasedOn) {
		String oldBasedOn = basedOn;
		basedOn = newBasedOn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResponsePackage.FUZZED_COLLECTION__BASED_ON, oldBasedOn, basedOn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMutations() {
		return mutations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMutations(int newMutations) {
		int oldMutations = mutations;
		mutations = newMutations;
		boolean oldMutationsESet = mutationsESet;
		mutationsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResponsePackage.FUZZED_COLLECTION__MUTATIONS, oldMutations, mutations, !oldMutationsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMutations() {
		int oldMutations = mutations;
		boolean oldMutationsESet = mutationsESet;
		mutations = MUTATIONS_EDEFAULT;
		mutationsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ResponsePackage.FUZZED_COLLECTION__MUTATIONS, oldMutations, MUTATIONS_EDEFAULT, oldMutationsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMutations() {
		return mutationsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperators() {
		return operators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperators(String newOperators) {
		String oldOperators = operators;
		operators = newOperators;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResponsePackage.FUZZED_COLLECTION__OPERATORS, oldOperators, operators));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResponsePackage.FUZZED_COLLECTION__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
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
			case ResponsePackage.FUZZED_COLLECTION__VALUES:
				return getValues();
			case ResponsePackage.FUZZED_COLLECTION__BASED_ON:
				return getBasedOn();
			case ResponsePackage.FUZZED_COLLECTION__MUTATIONS:
				return getMutations();
			case ResponsePackage.FUZZED_COLLECTION__OPERATORS:
				return getOperators();
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
			case ResponsePackage.FUZZED_COLLECTION__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends Value>)newValue);
				return;
			case ResponsePackage.FUZZED_COLLECTION__BASED_ON:
				setBasedOn((String)newValue);
				return;
			case ResponsePackage.FUZZED_COLLECTION__MUTATIONS:
				setMutations((Integer)newValue);
				return;
			case ResponsePackage.FUZZED_COLLECTION__OPERATORS:
				setOperators((String)newValue);
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
			case ResponsePackage.FUZZED_COLLECTION__VALUES:
				getValues().clear();
				return;
			case ResponsePackage.FUZZED_COLLECTION__BASED_ON:
				setBasedOn(BASED_ON_EDEFAULT);
				return;
			case ResponsePackage.FUZZED_COLLECTION__MUTATIONS:
				unsetMutations();
				return;
			case ResponsePackage.FUZZED_COLLECTION__OPERATORS:
				setOperators(OPERATORS_EDEFAULT);
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
			case ResponsePackage.FUZZED_COLLECTION__VALUES:
				return values != null && !values.isEmpty();
			case ResponsePackage.FUZZED_COLLECTION__BASED_ON:
				return BASED_ON_EDEFAULT == null ? basedOn != null : !BASED_ON_EDEFAULT.equals(basedOn);
			case ResponsePackage.FUZZED_COLLECTION__MUTATIONS:
				return isSetMutations();
			case ResponsePackage.FUZZED_COLLECTION__OPERATORS:
				return OPERATORS_EDEFAULT == null ? operators != null : !OPERATORS_EDEFAULT.equals(operators);
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
		result.append(" (basedOn: ");
		result.append(basedOn);
		result.append(", mutations: ");
		if (mutationsESet) result.append(mutations); else result.append("<unset>");
		result.append(", operators: ");
		result.append(operators);
		result.append(')');
		return result.toString();
	}

} //FuzzedCollectionImpl
