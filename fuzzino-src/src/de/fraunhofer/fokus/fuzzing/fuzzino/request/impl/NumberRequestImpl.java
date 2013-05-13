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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NoGenerators;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValues;

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
 * An implementation of the model object '<em><b>Number Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl#getNoGenerators <em>No Generators</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl#getGenerators <em>Generators</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl#getValidValues <em>Valid Values</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl#getMaxValues <em>Max Values</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl#getSeed <em>Seed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumberRequestImpl extends EObjectImpl implements NumberRequest {
	/**
	 * The cached value of the '{@link #getSpecification() <em>Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected RequestSpecification specification;

	/**
	 * The cached value of the '{@link #getNoGenerators() <em>No Generators</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoGenerators()
	 * @generated
	 * @ordered
	 */
	protected NoGenerators noGenerators;

	/**
	 * The cached value of the '{@link #getGenerators() <em>Generators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerators()
	 * @generated
	 * @ordered
	 */
	protected EList<Generator> generators;

	/**
	 * The cached value of the '{@link #getValidValues() <em>Valid Values</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidValues()
	 * @generated
	 * @ordered
	 */
	protected ValidValues validValues;

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
	 * The default value of the '{@link #getMaxValues() <em>Max Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValues()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_VALUES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxValues() <em>Max Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValues()
	 * @generated
	 * @ordered
	 */
	protected int maxValues = MAX_VALUES_EDEFAULT;

	/**
	 * This is true if the Max Values attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxValuesESet;

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
	 * The default value of the '{@link #getSeed() <em>Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeed()
	 * @generated
	 * @ordered
	 */
	protected static final long SEED_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getSeed() <em>Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeed()
	 * @generated
	 * @ordered
	 */
	protected long seed = SEED_EDEFAULT;

	/**
	 * This is true if the Seed attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean seedESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumberRequestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequestPackage.Literals.NUMBER_REQUEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequestSpecification getSpecification() {
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecification(RequestSpecification newSpecification, NotificationChain msgs) {
		RequestSpecification oldSpecification = specification;
		specification = newSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RequestPackage.NUMBER_REQUEST__SPECIFICATION, oldSpecification, newSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification(RequestSpecification newSpecification) {
		if (newSpecification != specification) {
			NotificationChain msgs = null;
			if (specification != null)
				msgs = ((InternalEObject)specification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RequestPackage.NUMBER_REQUEST__SPECIFICATION, null, msgs);
			if (newSpecification != null)
				msgs = ((InternalEObject)newSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RequestPackage.NUMBER_REQUEST__SPECIFICATION, null, msgs);
			msgs = basicSetSpecification(newSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.NUMBER_REQUEST__SPECIFICATION, newSpecification, newSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoGenerators getNoGenerators() {
		return noGenerators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNoGenerators(NoGenerators newNoGenerators, NotificationChain msgs) {
		NoGenerators oldNoGenerators = noGenerators;
		noGenerators = newNoGenerators;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RequestPackage.NUMBER_REQUEST__NO_GENERATORS, oldNoGenerators, newNoGenerators);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoGenerators(NoGenerators newNoGenerators) {
		if (newNoGenerators != noGenerators) {
			NotificationChain msgs = null;
			if (noGenerators != null)
				msgs = ((InternalEObject)noGenerators).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RequestPackage.NUMBER_REQUEST__NO_GENERATORS, null, msgs);
			if (newNoGenerators != null)
				msgs = ((InternalEObject)newNoGenerators).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RequestPackage.NUMBER_REQUEST__NO_GENERATORS, null, msgs);
			msgs = basicSetNoGenerators(newNoGenerators, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.NUMBER_REQUEST__NO_GENERATORS, newNoGenerators, newNoGenerators));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Generator> getGenerators() {
		if (generators == null) {
			generators = new EObjectContainmentEList<Generator>(Generator.class, this, RequestPackage.NUMBER_REQUEST__GENERATORS);
		}
		return generators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidValues getValidValues() {
		return validValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValidValues(ValidValues newValidValues, NotificationChain msgs) {
		ValidValues oldValidValues = validValues;
		validValues = newValidValues;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RequestPackage.NUMBER_REQUEST__VALID_VALUES, oldValidValues, newValidValues);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidValues(ValidValues newValidValues) {
		if (newValidValues != validValues) {
			NotificationChain msgs = null;
			if (validValues != null)
				msgs = ((InternalEObject)validValues).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RequestPackage.NUMBER_REQUEST__VALID_VALUES, null, msgs);
			if (newValidValues != null)
				msgs = ((InternalEObject)newValidValues).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RequestPackage.NUMBER_REQUEST__VALID_VALUES, null, msgs);
			msgs = basicSetValidValues(newValidValues, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.NUMBER_REQUEST__VALID_VALUES, newValidValues, newValidValues));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.NUMBER_REQUEST__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxValues() {
		return maxValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxValues(int newMaxValues) {
		int oldMaxValues = maxValues;
		maxValues = newMaxValues;
		boolean oldMaxValuesESet = maxValuesESet;
		maxValuesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.NUMBER_REQUEST__MAX_VALUES, oldMaxValues, maxValues, !oldMaxValuesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxValues() {
		int oldMaxValues = maxValues;
		boolean oldMaxValuesESet = maxValuesESet;
		maxValues = MAX_VALUES_EDEFAULT;
		maxValuesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.NUMBER_REQUEST__MAX_VALUES, oldMaxValues, MAX_VALUES_EDEFAULT, oldMaxValuesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxValues() {
		return maxValuesESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.NUMBER_REQUEST__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSeed() {
		return seed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeed(long newSeed) {
		long oldSeed = seed;
		seed = newSeed;
		boolean oldSeedESet = seedESet;
		seedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.NUMBER_REQUEST__SEED, oldSeed, seed, !oldSeedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSeed() {
		long oldSeed = seed;
		boolean oldSeedESet = seedESet;
		seed = SEED_EDEFAULT;
		seedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.NUMBER_REQUEST__SEED, oldSeed, SEED_EDEFAULT, oldSeedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSeed() {
		return seedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RequestPackage.NUMBER_REQUEST__SPECIFICATION:
				return basicSetSpecification(null, msgs);
			case RequestPackage.NUMBER_REQUEST__NO_GENERATORS:
				return basicSetNoGenerators(null, msgs);
			case RequestPackage.NUMBER_REQUEST__GENERATORS:
				return ((InternalEList<?>)getGenerators()).basicRemove(otherEnd, msgs);
			case RequestPackage.NUMBER_REQUEST__VALID_VALUES:
				return basicSetValidValues(null, msgs);
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
			case RequestPackage.NUMBER_REQUEST__SPECIFICATION:
				return getSpecification();
			case RequestPackage.NUMBER_REQUEST__NO_GENERATORS:
				return getNoGenerators();
			case RequestPackage.NUMBER_REQUEST__GENERATORS:
				return getGenerators();
			case RequestPackage.NUMBER_REQUEST__VALID_VALUES:
				return getValidValues();
			case RequestPackage.NUMBER_REQUEST__ID:
				return getId();
			case RequestPackage.NUMBER_REQUEST__MAX_VALUES:
				return getMaxValues();
			case RequestPackage.NUMBER_REQUEST__NAME:
				return getName();
			case RequestPackage.NUMBER_REQUEST__SEED:
				return getSeed();
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
			case RequestPackage.NUMBER_REQUEST__SPECIFICATION:
				setSpecification((RequestSpecification)newValue);
				return;
			case RequestPackage.NUMBER_REQUEST__NO_GENERATORS:
				setNoGenerators((NoGenerators)newValue);
				return;
			case RequestPackage.NUMBER_REQUEST__GENERATORS:
				getGenerators().clear();
				getGenerators().addAll((Collection<? extends Generator>)newValue);
				return;
			case RequestPackage.NUMBER_REQUEST__VALID_VALUES:
				setValidValues((ValidValues)newValue);
				return;
			case RequestPackage.NUMBER_REQUEST__ID:
				setId((String)newValue);
				return;
			case RequestPackage.NUMBER_REQUEST__MAX_VALUES:
				setMaxValues((Integer)newValue);
				return;
			case RequestPackage.NUMBER_REQUEST__NAME:
				setName((String)newValue);
				return;
			case RequestPackage.NUMBER_REQUEST__SEED:
				setSeed((Long)newValue);
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
			case RequestPackage.NUMBER_REQUEST__SPECIFICATION:
				setSpecification((RequestSpecification)null);
				return;
			case RequestPackage.NUMBER_REQUEST__NO_GENERATORS:
				setNoGenerators((NoGenerators)null);
				return;
			case RequestPackage.NUMBER_REQUEST__GENERATORS:
				getGenerators().clear();
				return;
			case RequestPackage.NUMBER_REQUEST__VALID_VALUES:
				setValidValues((ValidValues)null);
				return;
			case RequestPackage.NUMBER_REQUEST__ID:
				setId(ID_EDEFAULT);
				return;
			case RequestPackage.NUMBER_REQUEST__MAX_VALUES:
				unsetMaxValues();
				return;
			case RequestPackage.NUMBER_REQUEST__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RequestPackage.NUMBER_REQUEST__SEED:
				unsetSeed();
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
			case RequestPackage.NUMBER_REQUEST__SPECIFICATION:
				return specification != null;
			case RequestPackage.NUMBER_REQUEST__NO_GENERATORS:
				return noGenerators != null;
			case RequestPackage.NUMBER_REQUEST__GENERATORS:
				return generators != null && !generators.isEmpty();
			case RequestPackage.NUMBER_REQUEST__VALID_VALUES:
				return validValues != null;
			case RequestPackage.NUMBER_REQUEST__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case RequestPackage.NUMBER_REQUEST__MAX_VALUES:
				return isSetMaxValues();
			case RequestPackage.NUMBER_REQUEST__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RequestPackage.NUMBER_REQUEST__SEED:
				return isSetSeed();
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
		result.append(", maxValues: ");
		if (maxValuesESet) result.append(maxValues); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(", seed: ");
		if (seedESet) result.append(seed); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //NumberRequestImpl
