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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification;

import java.math.BigInteger;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl#getField <em>Field</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl#getBits <em>Bits</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl#isNullTerminated <em>Null Terminated</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl#isSigned <em>Signed</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl#isUnique <em>Unique</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequestSpecificationImpl extends EObjectImpl implements RequestSpecification {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The default value of the '{@link #getBits() <em>Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBits()
	 * @generated
	 * @ordered
	 */
	protected static final int BITS_EDEFAULT = 32;

	/**
	 * The cached value of the '{@link #getBits() <em>Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBits()
	 * @generated
	 * @ordered
	 */
	protected int bits = BITS_EDEFAULT;

	/**
	 * This is true if the Bits attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean bitsESet;

	/**
	 * The default value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
	protected static final String ENCODING_EDEFAULT = "ASCII";

	/**
	 * The cached value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
	protected String encoding = ENCODING_EDEFAULT;

	/**
	 * This is true if the Encoding attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean encodingESet;

	/**
	 * The default value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected int maxLength = MAX_LENGTH_EDEFAULT;

	/**
	 * This is true if the Max Length attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxLengthESet;

	/**
	 * The default value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MAX_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected BigInteger maxValue = MAX_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected int minLength = MIN_LENGTH_EDEFAULT;

	/**
	 * This is true if the Min Length attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean minLengthESet;

	/**
	 * The default value of the '{@link #getMinValue() <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MIN_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinValue() <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected BigInteger minValue = MIN_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #isNullTerminated() <em>Null Terminated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullTerminated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NULL_TERMINATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNullTerminated() <em>Null Terminated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullTerminated()
	 * @generated
	 * @ordered
	 */
	protected boolean nullTerminated = NULL_TERMINATED_EDEFAULT;

	/**
	 * This is true if the Null Terminated attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean nullTerminatedESet;

	/**
	 * The default value of the '{@link #isOrdered() <em>Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ORDERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOrdered() <em>Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrdered()
	 * @generated
	 * @ordered
	 */
	protected boolean ordered = ORDERED_EDEFAULT;

	/**
	 * This is true if the Ordered attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean orderedESet;

	/**
	 * The default value of the '{@link #getRef() <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected static final String REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected String ref = REF_EDEFAULT;

	/**
	 * The default value of the '{@link #isSigned() <em>Signed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSigned()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SIGNED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isSigned() <em>Signed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSigned()
	 * @generated
	 * @ordered
	 */
	protected boolean signed = SIGNED_EDEFAULT;

	/**
	 * This is true if the Signed attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean signedESet;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = "String";

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * This is true if the Type attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean typeESet;

	/**
	 * The default value of the '{@link #isUnique() <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNIQUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUnique() <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnique()
	 * @generated
	 * @ordered
	 */
	protected boolean unique = UNIQUE_EDEFAULT;

	/**
	 * This is true if the Unique attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean uniqueESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequestSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequestPackage.Literals.REQUEST_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, RequestPackage.REQUEST_SPECIFICATION__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Field> getField() {
		return getMixed().list(RequestPackage.Literals.REQUEST_SPECIFICATION__FIELD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBits() {
		return bits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBits(int newBits) {
		int oldBits = bits;
		bits = newBits;
		boolean oldBitsESet = bitsESet;
		bitsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.REQUEST_SPECIFICATION__BITS, oldBits, bits, !oldBitsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBits() {
		int oldBits = bits;
		boolean oldBitsESet = bitsESet;
		bits = BITS_EDEFAULT;
		bitsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.REQUEST_SPECIFICATION__BITS, oldBits, BITS_EDEFAULT, oldBitsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBits() {
		return bitsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEncoding(String newEncoding) {
		String oldEncoding = encoding;
		encoding = newEncoding;
		boolean oldEncodingESet = encodingESet;
		encodingESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.REQUEST_SPECIFICATION__ENCODING, oldEncoding, encoding, !oldEncodingESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEncoding() {
		String oldEncoding = encoding;
		boolean oldEncodingESet = encodingESet;
		encoding = ENCODING_EDEFAULT;
		encodingESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.REQUEST_SPECIFICATION__ENCODING, oldEncoding, ENCODING_EDEFAULT, oldEncodingESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEncoding() {
		return encodingESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxLength() {
		return maxLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxLength(int newMaxLength) {
		int oldMaxLength = maxLength;
		maxLength = newMaxLength;
		boolean oldMaxLengthESet = maxLengthESet;
		maxLengthESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.REQUEST_SPECIFICATION__MAX_LENGTH, oldMaxLength, maxLength, !oldMaxLengthESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxLength() {
		int oldMaxLength = maxLength;
		boolean oldMaxLengthESet = maxLengthESet;
		maxLength = MAX_LENGTH_EDEFAULT;
		maxLengthESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.REQUEST_SPECIFICATION__MAX_LENGTH, oldMaxLength, MAX_LENGTH_EDEFAULT, oldMaxLengthESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxLength() {
		return maxLengthESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMaxValue() {
		return maxValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxValue(BigInteger newMaxValue) {
		BigInteger oldMaxValue = maxValue;
		maxValue = newMaxValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.REQUEST_SPECIFICATION__MAX_VALUE, oldMaxValue, maxValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinLength() {
		return minLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinLength(int newMinLength) {
		int oldMinLength = minLength;
		minLength = newMinLength;
		boolean oldMinLengthESet = minLengthESet;
		minLengthESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.REQUEST_SPECIFICATION__MIN_LENGTH, oldMinLength, minLength, !oldMinLengthESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinLength() {
		int oldMinLength = minLength;
		boolean oldMinLengthESet = minLengthESet;
		minLength = MIN_LENGTH_EDEFAULT;
		minLengthESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.REQUEST_SPECIFICATION__MIN_LENGTH, oldMinLength, MIN_LENGTH_EDEFAULT, oldMinLengthESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinLength() {
		return minLengthESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMinValue() {
		return minValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinValue(BigInteger newMinValue) {
		BigInteger oldMinValue = minValue;
		minValue = newMinValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.REQUEST_SPECIFICATION__MIN_VALUE, oldMinValue, minValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNullTerminated() {
		return nullTerminated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNullTerminated(boolean newNullTerminated) {
		boolean oldNullTerminated = nullTerminated;
		nullTerminated = newNullTerminated;
		boolean oldNullTerminatedESet = nullTerminatedESet;
		nullTerminatedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.REQUEST_SPECIFICATION__NULL_TERMINATED, oldNullTerminated, nullTerminated, !oldNullTerminatedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNullTerminated() {
		boolean oldNullTerminated = nullTerminated;
		boolean oldNullTerminatedESet = nullTerminatedESet;
		nullTerminated = NULL_TERMINATED_EDEFAULT;
		nullTerminatedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.REQUEST_SPECIFICATION__NULL_TERMINATED, oldNullTerminated, NULL_TERMINATED_EDEFAULT, oldNullTerminatedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNullTerminated() {
		return nullTerminatedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOrdered() {
		return ordered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrdered(boolean newOrdered) {
		boolean oldOrdered = ordered;
		ordered = newOrdered;
		boolean oldOrderedESet = orderedESet;
		orderedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.REQUEST_SPECIFICATION__ORDERED, oldOrdered, ordered, !oldOrderedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOrdered() {
		boolean oldOrdered = ordered;
		boolean oldOrderedESet = orderedESet;
		ordered = ORDERED_EDEFAULT;
		orderedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.REQUEST_SPECIFICATION__ORDERED, oldOrdered, ORDERED_EDEFAULT, oldOrderedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOrdered() {
		return orderedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRef(String newRef) {
		String oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.REQUEST_SPECIFICATION__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSigned() {
		return signed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSigned(boolean newSigned) {
		boolean oldSigned = signed;
		signed = newSigned;
		boolean oldSignedESet = signedESet;
		signedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.REQUEST_SPECIFICATION__SIGNED, oldSigned, signed, !oldSignedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSigned() {
		boolean oldSigned = signed;
		boolean oldSignedESet = signedESet;
		signed = SIGNED_EDEFAULT;
		signedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.REQUEST_SPECIFICATION__SIGNED, oldSigned, SIGNED_EDEFAULT, oldSignedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSigned() {
		return signedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		boolean oldTypeESet = typeESet;
		typeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.REQUEST_SPECIFICATION__TYPE, oldType, type, !oldTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetType() {
		String oldType = type;
		boolean oldTypeESet = typeESet;
		type = TYPE_EDEFAULT;
		typeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.REQUEST_SPECIFICATION__TYPE, oldType, TYPE_EDEFAULT, oldTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetType() {
		return typeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnique() {
		return unique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnique(boolean newUnique) {
		boolean oldUnique = unique;
		unique = newUnique;
		boolean oldUniqueESet = uniqueESet;
		uniqueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequestPackage.REQUEST_SPECIFICATION__UNIQUE, oldUnique, unique, !oldUniqueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUnique() {
		boolean oldUnique = unique;
		boolean oldUniqueESet = uniqueESet;
		unique = UNIQUE_EDEFAULT;
		uniqueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RequestPackage.REQUEST_SPECIFICATION__UNIQUE, oldUnique, UNIQUE_EDEFAULT, oldUniqueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUnique() {
		return uniqueESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RequestPackage.REQUEST_SPECIFICATION__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case RequestPackage.REQUEST_SPECIFICATION__FIELD:
				return ((InternalEList<?>)getField()).basicRemove(otherEnd, msgs);
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
			case RequestPackage.REQUEST_SPECIFICATION__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case RequestPackage.REQUEST_SPECIFICATION__FIELD:
				return getField();
			case RequestPackage.REQUEST_SPECIFICATION__BITS:
				return getBits();
			case RequestPackage.REQUEST_SPECIFICATION__ENCODING:
				return getEncoding();
			case RequestPackage.REQUEST_SPECIFICATION__MAX_LENGTH:
				return getMaxLength();
			case RequestPackage.REQUEST_SPECIFICATION__MAX_VALUE:
				return getMaxValue();
			case RequestPackage.REQUEST_SPECIFICATION__MIN_LENGTH:
				return getMinLength();
			case RequestPackage.REQUEST_SPECIFICATION__MIN_VALUE:
				return getMinValue();
			case RequestPackage.REQUEST_SPECIFICATION__NULL_TERMINATED:
				return isNullTerminated();
			case RequestPackage.REQUEST_SPECIFICATION__ORDERED:
				return isOrdered();
			case RequestPackage.REQUEST_SPECIFICATION__REF:
				return getRef();
			case RequestPackage.REQUEST_SPECIFICATION__SIGNED:
				return isSigned();
			case RequestPackage.REQUEST_SPECIFICATION__TYPE:
				return getType();
			case RequestPackage.REQUEST_SPECIFICATION__UNIQUE:
				return isUnique();
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
			case RequestPackage.REQUEST_SPECIFICATION__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case RequestPackage.REQUEST_SPECIFICATION__FIELD:
				getField().clear();
				getField().addAll((Collection<? extends Field>)newValue);
				return;
			case RequestPackage.REQUEST_SPECIFICATION__BITS:
				setBits((Integer)newValue);
				return;
			case RequestPackage.REQUEST_SPECIFICATION__ENCODING:
				setEncoding((String)newValue);
				return;
			case RequestPackage.REQUEST_SPECIFICATION__MAX_LENGTH:
				setMaxLength((Integer)newValue);
				return;
			case RequestPackage.REQUEST_SPECIFICATION__MAX_VALUE:
				setMaxValue((BigInteger)newValue);
				return;
			case RequestPackage.REQUEST_SPECIFICATION__MIN_LENGTH:
				setMinLength((Integer)newValue);
				return;
			case RequestPackage.REQUEST_SPECIFICATION__MIN_VALUE:
				setMinValue((BigInteger)newValue);
				return;
			case RequestPackage.REQUEST_SPECIFICATION__NULL_TERMINATED:
				setNullTerminated((Boolean)newValue);
				return;
			case RequestPackage.REQUEST_SPECIFICATION__ORDERED:
				setOrdered((Boolean)newValue);
				return;
			case RequestPackage.REQUEST_SPECIFICATION__REF:
				setRef((String)newValue);
				return;
			case RequestPackage.REQUEST_SPECIFICATION__SIGNED:
				setSigned((Boolean)newValue);
				return;
			case RequestPackage.REQUEST_SPECIFICATION__TYPE:
				setType((String)newValue);
				return;
			case RequestPackage.REQUEST_SPECIFICATION__UNIQUE:
				setUnique((Boolean)newValue);
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
			case RequestPackage.REQUEST_SPECIFICATION__MIXED:
				getMixed().clear();
				return;
			case RequestPackage.REQUEST_SPECIFICATION__FIELD:
				getField().clear();
				return;
			case RequestPackage.REQUEST_SPECIFICATION__BITS:
				unsetBits();
				return;
			case RequestPackage.REQUEST_SPECIFICATION__ENCODING:
				unsetEncoding();
				return;
			case RequestPackage.REQUEST_SPECIFICATION__MAX_LENGTH:
				unsetMaxLength();
				return;
			case RequestPackage.REQUEST_SPECIFICATION__MAX_VALUE:
				setMaxValue(MAX_VALUE_EDEFAULT);
				return;
			case RequestPackage.REQUEST_SPECIFICATION__MIN_LENGTH:
				unsetMinLength();
				return;
			case RequestPackage.REQUEST_SPECIFICATION__MIN_VALUE:
				setMinValue(MIN_VALUE_EDEFAULT);
				return;
			case RequestPackage.REQUEST_SPECIFICATION__NULL_TERMINATED:
				unsetNullTerminated();
				return;
			case RequestPackage.REQUEST_SPECIFICATION__ORDERED:
				unsetOrdered();
				return;
			case RequestPackage.REQUEST_SPECIFICATION__REF:
				setRef(REF_EDEFAULT);
				return;
			case RequestPackage.REQUEST_SPECIFICATION__SIGNED:
				unsetSigned();
				return;
			case RequestPackage.REQUEST_SPECIFICATION__TYPE:
				unsetType();
				return;
			case RequestPackage.REQUEST_SPECIFICATION__UNIQUE:
				unsetUnique();
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
			case RequestPackage.REQUEST_SPECIFICATION__MIXED:
				return mixed != null && !mixed.isEmpty();
			case RequestPackage.REQUEST_SPECIFICATION__FIELD:
				return !getField().isEmpty();
			case RequestPackage.REQUEST_SPECIFICATION__BITS:
				return isSetBits();
			case RequestPackage.REQUEST_SPECIFICATION__ENCODING:
				return isSetEncoding();
			case RequestPackage.REQUEST_SPECIFICATION__MAX_LENGTH:
				return isSetMaxLength();
			case RequestPackage.REQUEST_SPECIFICATION__MAX_VALUE:
				return MAX_VALUE_EDEFAULT == null ? maxValue != null : !MAX_VALUE_EDEFAULT.equals(maxValue);
			case RequestPackage.REQUEST_SPECIFICATION__MIN_LENGTH:
				return isSetMinLength();
			case RequestPackage.REQUEST_SPECIFICATION__MIN_VALUE:
				return MIN_VALUE_EDEFAULT == null ? minValue != null : !MIN_VALUE_EDEFAULT.equals(minValue);
			case RequestPackage.REQUEST_SPECIFICATION__NULL_TERMINATED:
				return isSetNullTerminated();
			case RequestPackage.REQUEST_SPECIFICATION__ORDERED:
				return isSetOrdered();
			case RequestPackage.REQUEST_SPECIFICATION__REF:
				return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
			case RequestPackage.REQUEST_SPECIFICATION__SIGNED:
				return isSetSigned();
			case RequestPackage.REQUEST_SPECIFICATION__TYPE:
				return isSetType();
			case RequestPackage.REQUEST_SPECIFICATION__UNIQUE:
				return isSetUnique();
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(", bits: ");
		if (bitsESet) result.append(bits); else result.append("<unset>");
		result.append(", encoding: ");
		if (encodingESet) result.append(encoding); else result.append("<unset>");
		result.append(", maxLength: ");
		if (maxLengthESet) result.append(maxLength); else result.append("<unset>");
		result.append(", maxValue: ");
		result.append(maxValue);
		result.append(", minLength: ");
		if (minLengthESet) result.append(minLength); else result.append("<unset>");
		result.append(", minValue: ");
		result.append(minValue);
		result.append(", nullTerminated: ");
		if (nullTerminatedESet) result.append(nullTerminated); else result.append("<unset>");
		result.append(", ordered: ");
		if (orderedESet) result.append(ordered); else result.append("<unset>");
		result.append(", ref: ");
		result.append(ref);
		result.append(", signed: ");
		if (signedESet) result.append(signed); else result.append("<unset>");
		result.append(", type: ");
		if (typeESet) result.append(type); else result.append("<unset>");
		result.append(", unique: ");
		if (uniqueESet) result.append(unique); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //RequestSpecificationImpl
