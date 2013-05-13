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
package de.fraunhofer.fokus.fuzzing.fuzzino.request;

import java.math.BigInteger;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMixed <em>Mixed</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getField <em>Field</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getBits <em>Bits</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isNullTerminated <em>Null Terminated</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getRef <em>Ref</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isSigned <em>Signed</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getType <em>Type</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isUnique <em>Unique</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequestSpecification()
 * @model extendedMetaData="name='specification_._type' kind='mixed'"
 * @generated
 */
public interface RequestSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequestSpecification_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Field</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Field}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequestSpecification_Field()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='field' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Field> getField();

	/**
	 * Returns the value of the '<em><b>Bits</b></em>' attribute.
	 * The default value is <code>"32"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bits</em>' attribute.
	 * @see #setBits(int)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequestSpecification_Bits()
	 * @model default="32" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" suppressedIsSetVisibility="true" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='bits'"
	 * @generated
	 */
	int getBits();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getBits <em>Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bits</em>' attribute.
	 * @see #getBits()
	 * @generated
	 */
	void setBits(int value);

	/**
	 * Returns the value of the '<em><b>Encoding</b></em>' attribute.
	 * The default value is <code>"ASCII"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encoding</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encoding</em>' attribute.
	 * @see #setEncoding(String)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequestSpecification_Encoding()
	 * @model default="ASCII" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.NCName" suppressedIsSetVisibility="true" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='encoding'"
	 * @generated
	 */
	String getEncoding();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getEncoding <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encoding</em>' attribute.
	 * @see #getEncoding()
	 * @generated
	 */
	void setEncoding(String value);

	/**
	 * Returns the value of the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Length</em>' attribute.
	 * @see #isSetMaxLength()
	 * @see #setMaxLength(int)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequestSpecification_MaxLength()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='maxLength'"
	 * @generated
	 */
	int getMaxLength();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMaxLength <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Length</em>' attribute.
	 * @see #isSetMaxLength()
	 * @see #getMaxLength()
	 * @generated
	 */
	void setMaxLength(int value);

	/**
	 * Returns whether the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMaxLength <em>Max Length</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Length</em>' attribute is set.
	 * @see #getMaxLength()
	 * @see #setMaxLength(int)
	 * @generated
	 */
	boolean isSetMaxLength();

	/**
	 * Returns the value of the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Value</em>' attribute.
	 * @see #setMaxValue(BigInteger)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequestSpecification_MaxValue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='maxValue'"
	 * @generated
	 */
	BigInteger getMaxValue();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMaxValue <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Value</em>' attribute.
	 * @see #getMaxValue()
	 * @generated
	 */
	void setMaxValue(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Length</em>' attribute.
	 * @see #isSetMinLength()
	 * @see #setMinLength(int)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequestSpecification_MinLength()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='minLength'"
	 * @generated
	 */
	int getMinLength();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMinLength <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Length</em>' attribute.
	 * @see #isSetMinLength()
	 * @see #getMinLength()
	 * @generated
	 */
	void setMinLength(int value);

	/**
	 * Returns whether the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMinLength <em>Min Length</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Min Length</em>' attribute is set.
	 * @see #getMinLength()
	 * @see #setMinLength(int)
	 * @generated
	 */
	boolean isSetMinLength();

	/**
	 * Returns the value of the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Value</em>' attribute.
	 * @see #setMinValue(BigInteger)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequestSpecification_MinValue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='minValue'"
	 * @generated
	 */
	BigInteger getMinValue();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMinValue <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Value</em>' attribute.
	 * @see #getMinValue()
	 * @generated
	 */
	void setMinValue(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Null Terminated</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Null Terminated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Null Terminated</em>' attribute.
	 * @see #setNullTerminated(boolean)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequestSpecification_NullTerminated()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" suppressedIsSetVisibility="true" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='nullTerminated'"
	 * @generated
	 */
	boolean isNullTerminated();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isNullTerminated <em>Null Terminated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Null Terminated</em>' attribute.
	 * @see #isNullTerminated()
	 * @generated
	 */
	void setNullTerminated(boolean value);

	/**
	 * Returns the value of the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordered</em>' attribute.
	 * @see #isSetOrdered()
	 * @see #setOrdered(boolean)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequestSpecification_Ordered()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='ordered'"
	 * @generated
	 */
	boolean isOrdered();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isOrdered <em>Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ordered</em>' attribute.
	 * @see #isSetOrdered()
	 * @see #isOrdered()
	 * @generated
	 */
	void setOrdered(boolean value);

	/**
	 * Returns whether the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isOrdered <em>Ordered</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ordered</em>' attribute is set.
	 * @see #isOrdered()
	 * @see #setOrdered(boolean)
	 * @generated
	 */
	boolean isSetOrdered();

	/**
	 * Returns the value of the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' attribute.
	 * @see #setRef(String)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequestSpecification_Ref()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='ref'"
	 * @generated
	 */
	String getRef();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getRef <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' attribute.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(String value);

	/**
	 * Returns the value of the '<em><b>Signed</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signed</em>' attribute.
	 * @see #setSigned(boolean)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequestSpecification_Signed()
	 * @model default="true" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" suppressedIsSetVisibility="true" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='signed'"
	 * @generated
	 */
	boolean isSigned();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isSigned <em>Signed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signed</em>' attribute.
	 * @see #isSigned()
	 * @generated
	 */
	void setSigned(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"String"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequestSpecification_Type()
	 * @model default="String" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.NCName" suppressedIsSetVisibility="true" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique</em>' attribute.
	 * @see #isSetUnique()
	 * @see #setUnique(boolean)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#getRequestSpecification_Unique()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" suppressedUnsetVisibility="true"
	 *        extendedMetaData="kind='attribute' name='unique'"
	 * @generated
	 */
	boolean isUnique();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isUnique <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unique</em>' attribute.
	 * @see #isSetUnique()
	 * @see #isUnique()
	 * @generated
	 */
	void setUnique(boolean value);

	/**
	 * Returns whether the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isUnique <em>Unique</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unique</em>' attribute is set.
	 * @see #isUnique()
	 * @see #setUnique(boolean)
	 * @generated
	 */
	boolean isSetUnique();

} // RequestSpecification
