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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollections;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CollectionRequestImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CollectionRequestImpl#getValidCollections <em>Valid Collections</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CollectionRequestImpl#isFuzzStructure <em>Fuzz Structure</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CollectionRequestImpl#isFuzzValues <em>Fuzz Values</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CollectionRequestImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CollectionRequestImpl#getMaxMutations <em>Max Mutations</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CollectionRequestImpl#getMaxValues <em>Max Values</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CollectionRequestImpl#getMinMutations <em>Min Mutations</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CollectionRequestImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CollectionRequestImpl#getSeed <em>Seed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionRequestImpl extends EObjectImpl implements CollectionRequest {
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
	 * The cached value of the '{@link #getValidCollections() <em>Valid Collections</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidCollections()
	 * @generated
	 * @ordered
	 */
	protected ValidCollections validCollections;

	/**
	 * The default value of the '{@link #isFuzzStructure() <em>Fuzz Structure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFuzzStructure()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FUZZ_STRUCTURE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFuzzStructure() <em>Fuzz Structure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFuzzStructure()
	 * @generated
	 * @ordered
	 */
	protected boolean fuzzStructure = FUZZ_STRUCTURE_EDEFAULT;

	/**
	 * This is true if the Fuzz Structure attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean fuzzStructureESet;

	/**
	 * The default value of the '{@link #isFuzzValues() <em>Fuzz Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFuzzValues()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FUZZ_VALUES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFuzzValues() <em>Fuzz Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFuzzValues()
	 * @generated
	 * @ordered
	 */
	protected boolean fuzzValues = FUZZ_VALUES_EDEFAULT;

	/**
	 * This is true if the Fuzz Values attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean fuzzValuesESet;

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
	 * The default value of the '{@link #getMaxMutations() <em>Max Mutations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxMutations()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_MUTATIONS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxMutations() <em>Max Mutations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxMutations()
	 * @generated
	 * @ordered
	 */
	protected int maxMutations = MAX_MUTATIONS_EDEFAULT;

	/**
	 * This is true if the Max Mutations attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxMutationsESet;

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
	 * The default value of the '{@link #getMinMutations() <em>Min Mutations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinMutations()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_MUTATIONS_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getMinMutations() <em>Min Mutations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinMutations()
	 * @generated
	 * @ordered
	 */
	protected int minMutations = MIN_MUTATIONS_EDEFAULT;

	/**
	 * This is true if the Min Mutations attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean minMutationsESet;

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
	protected CollectionRequestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequestPackage.Literals.COLLECTION_REQUEST;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RequestPackage.COLLECTION_REQUEST__SPECIFICATION, oldSpecification, newSpecification);
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
				msgs = ((InternalEObject)specification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RequestPackage.COLLECTION_REQUEST__SPECIFICATION, null, msgs);
			if (newSpecification != null)
				msgs = ((InternalEObject)newSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RequestPackage.COLLECTION_REQUEST__SPECIFICATION, null, msgs);
			msgs = basicSetSpecification(newSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.COLLECTION_REQUEST__SPECIFICATION, newSpecification, newSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidCollections getValidCollections() {
		return validCollections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValidCollections(ValidCollections newValidCollections, NotificationChain msgs) {
		ValidCollections oldValidCollections = validCollections;
		validCollections = newValidCollections;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RequestPackage.COLLECTION_REQUEST__VALID_COLLECTIONS, oldValidCollections, newValidCollections);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidCollections(ValidCollections newValidCollections) {
		if (newValidCollections != validCollections) {
			NotificationChain msgs = null;
			if (validCollections != null)
				msgs = ((InternalEObject)validCollections).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RequestPackage.COLLECTION_REQUEST__VALID_COLLECTIONS, null, msgs);
			if (newValidCollections != null)
				msgs = ((InternalEObject)newValidCollections).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RequestPackage.COLLECTION_REQUEST__VALID_COLLECTIONS, null, msgs);
			msgs = basicSetValidCollections(newValidCollections, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.COLLECTION_REQUEST__VALID_COLLECTIONS, newValidCollections, newValidCollections));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFuzzStructure() {
		return fuzzStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuzzStructure(boolean newFuzzStructure) {
		boolean oldFuzzStructure = fuzzStructure;
		fuzzStructure = newFuzzStructure;
		boolean oldFuzzStructureESet = fuzzStructureESet;
		fuzzStructureESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.COLLECTION_REQUEST__FUZZ_STRUCTURE, oldFuzzStructure, fuzzStructure, !oldFuzzStructureESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFuzzStructure() {
		boolean oldFuzzStructure = fuzzStructure;
		boolean oldFuzzStructureESet = fuzzStructureESet;
		fuzzStructure = FUZZ_STRUCTURE_EDEFAULT;
		fuzzStructureESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.COLLECTION_REQUEST__FUZZ_STRUCTURE, oldFuzzStructure, FUZZ_STRUCTURE_EDEFAULT, oldFuzzStructureESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFuzzStructure() {
		return fuzzStructureESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFuzzValues() {
		return fuzzValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuzzValues(boolean newFuzzValues) {
		boolean oldFuzzValues = fuzzValues;
		fuzzValues = newFuzzValues;
		boolean oldFuzzValuesESet = fuzzValuesESet;
		fuzzValuesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.COLLECTION_REQUEST__FUZZ_VALUES, oldFuzzValues, fuzzValues, !oldFuzzValuesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFuzzValues() {
		boolean oldFuzzValues = fuzzValues;
		boolean oldFuzzValuesESet = fuzzValuesESet;
		fuzzValues = FUZZ_VALUES_EDEFAULT;
		fuzzValuesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.COLLECTION_REQUEST__FUZZ_VALUES, oldFuzzValues, FUZZ_VALUES_EDEFAULT, oldFuzzValuesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFuzzValues() {
		return fuzzValuesESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.COLLECTION_REQUEST__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxMutations() {
		return maxMutations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxMutations(int newMaxMutations) {
		int oldMaxMutations = maxMutations;
		maxMutations = newMaxMutations;
		boolean oldMaxMutationsESet = maxMutationsESet;
		maxMutationsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.COLLECTION_REQUEST__MAX_MUTATIONS, oldMaxMutations, maxMutations, !oldMaxMutationsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxMutations() {
		int oldMaxMutations = maxMutations;
		boolean oldMaxMutationsESet = maxMutationsESet;
		maxMutations = MAX_MUTATIONS_EDEFAULT;
		maxMutationsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.COLLECTION_REQUEST__MAX_MUTATIONS, oldMaxMutations, MAX_MUTATIONS_EDEFAULT, oldMaxMutationsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxMutations() {
		return maxMutationsESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.COLLECTION_REQUEST__MAX_VALUES, oldMaxValues, maxValues, !oldMaxValuesESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.COLLECTION_REQUEST__MAX_VALUES, oldMaxValues, MAX_VALUES_EDEFAULT, oldMaxValuesESet));
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
	public int getMinMutations() {
		return minMutations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinMutations(int newMinMutations) {
		int oldMinMutations = minMutations;
		minMutations = newMinMutations;
		boolean oldMinMutationsESet = minMutationsESet;
		minMutationsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.COLLECTION_REQUEST__MIN_MUTATIONS, oldMinMutations, minMutations, !oldMinMutationsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinMutations() {
		int oldMinMutations = minMutations;
		boolean oldMinMutationsESet = minMutationsESet;
		minMutations = MIN_MUTATIONS_EDEFAULT;
		minMutationsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.COLLECTION_REQUEST__MIN_MUTATIONS, oldMinMutations, MIN_MUTATIONS_EDEFAULT, oldMinMutationsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinMutations() {
		return minMutationsESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.COLLECTION_REQUEST__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.COLLECTION_REQUEST__SEED, oldSeed, seed, !oldSeedESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.COLLECTION_REQUEST__SEED, oldSeed, SEED_EDEFAULT, oldSeedESet));
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
			case RequestPackage.COLLECTION_REQUEST__SPECIFICATION:
				return basicSetSpecification(null, msgs);
			case RequestPackage.COLLECTION_REQUEST__VALID_COLLECTIONS:
				return basicSetValidCollections(null, msgs);
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
			case RequestPackage.COLLECTION_REQUEST__SPECIFICATION:
				return getSpecification();
			case RequestPackage.COLLECTION_REQUEST__VALID_COLLECTIONS:
				return getValidCollections();
			case RequestPackage.COLLECTION_REQUEST__FUZZ_STRUCTURE:
				return isFuzzStructure();
			case RequestPackage.COLLECTION_REQUEST__FUZZ_VALUES:
				return isFuzzValues();
			case RequestPackage.COLLECTION_REQUEST__ID:
				return getId();
			case RequestPackage.COLLECTION_REQUEST__MAX_MUTATIONS:
				return getMaxMutations();
			case RequestPackage.COLLECTION_REQUEST__MAX_VALUES:
				return getMaxValues();
			case RequestPackage.COLLECTION_REQUEST__MIN_MUTATIONS:
				return getMinMutations();
			case RequestPackage.COLLECTION_REQUEST__NAME:
				return getName();
			case RequestPackage.COLLECTION_REQUEST__SEED:
				return getSeed();
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
			case RequestPackage.COLLECTION_REQUEST__SPECIFICATION:
				setSpecification((RequestSpecification)newValue);
				return;
			case RequestPackage.COLLECTION_REQUEST__VALID_COLLECTIONS:
				setValidCollections((ValidCollections)newValue);
				return;
			case RequestPackage.COLLECTION_REQUEST__FUZZ_STRUCTURE:
				setFuzzStructure((Boolean)newValue);
				return;
			case RequestPackage.COLLECTION_REQUEST__FUZZ_VALUES:
				setFuzzValues((Boolean)newValue);
				return;
			case RequestPackage.COLLECTION_REQUEST__ID:
				setId((String)newValue);
				return;
			case RequestPackage.COLLECTION_REQUEST__MAX_MUTATIONS:
				setMaxMutations((Integer)newValue);
				return;
			case RequestPackage.COLLECTION_REQUEST__MAX_VALUES:
				setMaxValues((Integer)newValue);
				return;
			case RequestPackage.COLLECTION_REQUEST__MIN_MUTATIONS:
				setMinMutations((Integer)newValue);
				return;
			case RequestPackage.COLLECTION_REQUEST__NAME:
				setName((String)newValue);
				return;
			case RequestPackage.COLLECTION_REQUEST__SEED:
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
			case RequestPackage.COLLECTION_REQUEST__SPECIFICATION:
				setSpecification((RequestSpecification)null);
				return;
			case RequestPackage.COLLECTION_REQUEST__VALID_COLLECTIONS:
				setValidCollections((ValidCollections)null);
				return;
			case RequestPackage.COLLECTION_REQUEST__FUZZ_STRUCTURE:
				unsetFuzzStructure();
				return;
			case RequestPackage.COLLECTION_REQUEST__FUZZ_VALUES:
				unsetFuzzValues();
				return;
			case RequestPackage.COLLECTION_REQUEST__ID:
				setId(ID_EDEFAULT);
				return;
			case RequestPackage.COLLECTION_REQUEST__MAX_MUTATIONS:
				unsetMaxMutations();
				return;
			case RequestPackage.COLLECTION_REQUEST__MAX_VALUES:
				unsetMaxValues();
				return;
			case RequestPackage.COLLECTION_REQUEST__MIN_MUTATIONS:
				unsetMinMutations();
				return;
			case RequestPackage.COLLECTION_REQUEST__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RequestPackage.COLLECTION_REQUEST__SEED:
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
			case RequestPackage.COLLECTION_REQUEST__SPECIFICATION:
				return specification != null;
			case RequestPackage.COLLECTION_REQUEST__VALID_COLLECTIONS:
				return validCollections != null;
			case RequestPackage.COLLECTION_REQUEST__FUZZ_STRUCTURE:
				return isSetFuzzStructure();
			case RequestPackage.COLLECTION_REQUEST__FUZZ_VALUES:
				return isSetFuzzValues();
			case RequestPackage.COLLECTION_REQUEST__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case RequestPackage.COLLECTION_REQUEST__MAX_MUTATIONS:
				return isSetMaxMutations();
			case RequestPackage.COLLECTION_REQUEST__MAX_VALUES:
				return isSetMaxValues();
			case RequestPackage.COLLECTION_REQUEST__MIN_MUTATIONS:
				return isSetMinMutations();
			case RequestPackage.COLLECTION_REQUEST__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RequestPackage.COLLECTION_REQUEST__SEED:
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
		result.append(" (fuzzStructure: ");
		if (fuzzStructureESet) result.append(fuzzStructure); else result.append("<unset>");
		result.append(", fuzzValues: ");
		if (fuzzValuesESet) result.append(fuzzValues); else result.append("<unset>");
		result.append(", id: ");
		result.append(id);
		result.append(", maxMutations: ");
		if (maxMutationsESet) result.append(maxMutations); else result.append("<unset>");
		result.append(", maxValues: ");
		if (maxValuesESet) result.append(maxValues); else result.append("<unset>");
		result.append(", minMutations: ");
		if (minMutationsESet) result.append(minMutations); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(", seed: ");
		if (seedESet) result.append(seed); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //CollectionRequestImpl
