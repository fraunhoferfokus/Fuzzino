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

import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NoMoreValuesIndicator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart;

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
 * An implementation of the model object '<em><b>Warnings Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.WarningsPartImpl#getIllegalGenerators <em>Illegal Generators</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.WarningsPartImpl#getIllegalOperators <em>Illegal Operators</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.WarningsPartImpl#getIllegalRequestFormats <em>Illegal Request Formats</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.WarningsPartImpl#getFlagNoMoreValues <em>Flag No More Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WarningsPartImpl extends EObjectImpl implements WarningsPart {
	/**
	 * The cached value of the '{@link #getIllegalGenerators() <em>Illegal Generators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIllegalGenerators()
	 * @generated
	 * @ordered
	 */
	protected EList<IllegalGenerator> illegalGenerators;

	/**
	 * The cached value of the '{@link #getIllegalOperators() <em>Illegal Operators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIllegalOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<IllegalOperator> illegalOperators;

	/**
	 * The cached value of the '{@link #getIllegalRequestFormats() <em>Illegal Request Formats</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIllegalRequestFormats()
	 * @generated
	 * @ordered
	 */
	protected EList<IllegalRequestFormat> illegalRequestFormats;

	/**
	 * The cached value of the '{@link #getFlagNoMoreValues() <em>Flag No More Values</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlagNoMoreValues()
	 * @generated
	 * @ordered
	 */
	protected NoMoreValuesIndicator flagNoMoreValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WarningsPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResponsePackage.Literals.WARNINGS_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IllegalGenerator> getIllegalGenerators() {
		if (illegalGenerators == null) {
			illegalGenerators = new EObjectContainmentEList<IllegalGenerator>(IllegalGenerator.class, this, ResponsePackage.WARNINGS_PART__ILLEGAL_GENERATORS);
		}
		return illegalGenerators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IllegalOperator> getIllegalOperators() {
		if (illegalOperators == null) {
			illegalOperators = new EObjectContainmentEList<IllegalOperator>(IllegalOperator.class, this, ResponsePackage.WARNINGS_PART__ILLEGAL_OPERATORS);
		}
		return illegalOperators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IllegalRequestFormat> getIllegalRequestFormats() {
		if (illegalRequestFormats == null) {
			illegalRequestFormats = new EObjectContainmentEList<IllegalRequestFormat>(IllegalRequestFormat.class, this, ResponsePackage.WARNINGS_PART__ILLEGAL_REQUEST_FORMATS);
		}
		return illegalRequestFormats;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoMoreValuesIndicator getFlagNoMoreValues() {
		return flagNoMoreValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFlagNoMoreValues(NoMoreValuesIndicator newFlagNoMoreValues, NotificationChain msgs) {
		NoMoreValuesIndicator oldFlagNoMoreValues = flagNoMoreValues;
		flagNoMoreValues = newFlagNoMoreValues;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResponsePackage.WARNINGS_PART__FLAG_NO_MORE_VALUES, oldFlagNoMoreValues, newFlagNoMoreValues);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlagNoMoreValues(NoMoreValuesIndicator newFlagNoMoreValues) {
		if (newFlagNoMoreValues != flagNoMoreValues) {
			NotificationChain msgs = null;
			if (flagNoMoreValues != null)
				msgs = ((InternalEObject)flagNoMoreValues).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResponsePackage.WARNINGS_PART__FLAG_NO_MORE_VALUES, null, msgs);
			if (newFlagNoMoreValues != null)
				msgs = ((InternalEObject)newFlagNoMoreValues).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResponsePackage.WARNINGS_PART__FLAG_NO_MORE_VALUES, null, msgs);
			msgs = basicSetFlagNoMoreValues(newFlagNoMoreValues, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResponsePackage.WARNINGS_PART__FLAG_NO_MORE_VALUES, newFlagNoMoreValues, newFlagNoMoreValues));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResponsePackage.WARNINGS_PART__ILLEGAL_GENERATORS:
				return ((InternalEList<?>)getIllegalGenerators()).basicRemove(otherEnd, msgs);
			case ResponsePackage.WARNINGS_PART__ILLEGAL_OPERATORS:
				return ((InternalEList<?>)getIllegalOperators()).basicRemove(otherEnd, msgs);
			case ResponsePackage.WARNINGS_PART__ILLEGAL_REQUEST_FORMATS:
				return ((InternalEList<?>)getIllegalRequestFormats()).basicRemove(otherEnd, msgs);
			case ResponsePackage.WARNINGS_PART__FLAG_NO_MORE_VALUES:
				return basicSetFlagNoMoreValues(null, msgs);
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
			case ResponsePackage.WARNINGS_PART__ILLEGAL_GENERATORS:
				return getIllegalGenerators();
			case ResponsePackage.WARNINGS_PART__ILLEGAL_OPERATORS:
				return getIllegalOperators();
			case ResponsePackage.WARNINGS_PART__ILLEGAL_REQUEST_FORMATS:
				return getIllegalRequestFormats();
			case ResponsePackage.WARNINGS_PART__FLAG_NO_MORE_VALUES:
				return getFlagNoMoreValues();
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
			case ResponsePackage.WARNINGS_PART__ILLEGAL_GENERATORS:
				getIllegalGenerators().clear();
				getIllegalGenerators().addAll((Collection<? extends IllegalGenerator>)newValue);
				return;
			case ResponsePackage.WARNINGS_PART__ILLEGAL_OPERATORS:
				getIllegalOperators().clear();
				getIllegalOperators().addAll((Collection<? extends IllegalOperator>)newValue);
				return;
			case ResponsePackage.WARNINGS_PART__ILLEGAL_REQUEST_FORMATS:
				getIllegalRequestFormats().clear();
				getIllegalRequestFormats().addAll((Collection<? extends IllegalRequestFormat>)newValue);
				return;
			case ResponsePackage.WARNINGS_PART__FLAG_NO_MORE_VALUES:
				setFlagNoMoreValues((NoMoreValuesIndicator)newValue);
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
			case ResponsePackage.WARNINGS_PART__ILLEGAL_GENERATORS:
				getIllegalGenerators().clear();
				return;
			case ResponsePackage.WARNINGS_PART__ILLEGAL_OPERATORS:
				getIllegalOperators().clear();
				return;
			case ResponsePackage.WARNINGS_PART__ILLEGAL_REQUEST_FORMATS:
				getIllegalRequestFormats().clear();
				return;
			case ResponsePackage.WARNINGS_PART__FLAG_NO_MORE_VALUES:
				setFlagNoMoreValues((NoMoreValuesIndicator)null);
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
			case ResponsePackage.WARNINGS_PART__ILLEGAL_GENERATORS:
				return illegalGenerators != null && !illegalGenerators.isEmpty();
			case ResponsePackage.WARNINGS_PART__ILLEGAL_OPERATORS:
				return illegalOperators != null && !illegalOperators.isEmpty();
			case ResponsePackage.WARNINGS_PART__ILLEGAL_REQUEST_FORMATS:
				return illegalRequestFormats != null && !illegalRequestFormats.isEmpty();
			case ResponsePackage.WARNINGS_PART__FLAG_NO_MORE_VALUES:
				return flagNoMoreValues != null;
		}
		return super.eIsSet(featureID);
	}

} //WarningsPartImpl
