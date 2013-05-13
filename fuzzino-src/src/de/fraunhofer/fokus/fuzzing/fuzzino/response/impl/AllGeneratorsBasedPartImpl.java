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

import de.fraunhofer.fokus.fuzzing.fuzzino.response.AllGeneratorsBasedPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage;

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
 * An implementation of the model object '<em><b>All Generators Based Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.AllGeneratorsBasedPartImpl#getGeneratorParts <em>Generator Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllGeneratorsBasedPartImpl extends EObjectImpl implements AllGeneratorsBasedPart {
	/**
	 * The cached value of the '{@link #getGeneratorParts() <em>Generator Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratorParts()
	 * @generated
	 * @ordered
	 */
	protected EList<GeneratorPart> generatorParts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllGeneratorsBasedPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResponsePackage.Literals.ALL_GENERATORS_BASED_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneratorPart> getGeneratorParts() {
		if (generatorParts == null) {
			generatorParts = new EObjectContainmentEList<GeneratorPart>(GeneratorPart.class, this, ResponsePackage.ALL_GENERATORS_BASED_PART__GENERATOR_PARTS);
		}
		return generatorParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResponsePackage.ALL_GENERATORS_BASED_PART__GENERATOR_PARTS:
				return ((InternalEList<?>)getGeneratorParts()).basicRemove(otherEnd, msgs);
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
			case ResponsePackage.ALL_GENERATORS_BASED_PART__GENERATOR_PARTS:
				return getGeneratorParts();
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
			case ResponsePackage.ALL_GENERATORS_BASED_PART__GENERATOR_PARTS:
				getGeneratorParts().clear();
				getGeneratorParts().addAll((Collection<? extends GeneratorPart>)newValue);
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
			case ResponsePackage.ALL_GENERATORS_BASED_PART__GENERATOR_PARTS:
				getGeneratorParts().clear();
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
			case ResponsePackage.ALL_GENERATORS_BASED_PART__GENERATOR_PARTS:
				return generatorParts != null && !generatorParts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AllGeneratorsBasedPartImpl
