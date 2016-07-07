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
package de.fraunhofer.fokus.fuzzing.fuzzino.response;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Response</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getFuzzedCollections <em>Fuzzed Collections</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getWarnings <em>Warnings</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getId <em>Id</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#isMoreValues <em>More Values</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getName <em>Name</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getSeed <em>Seed</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getCollectionResponse()
 * @model extendedMetaData="name='collection_._type' kind='elementOnly'"
 * @generated
 */
public interface CollectionResponse extends EObject {
	/**
	 * Returns the value of the '<em><b>Fuzzed Collections</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fuzzed Collections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fuzzed Collections</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getCollectionResponse_FuzzedCollections()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='fuzzedCollection' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<FuzzedCollection> getFuzzedCollections();

	/**
	 * Returns the value of the '<em><b>Warnings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Warnings</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warnings</em>' containment reference.
	 * @see #setWarnings(WarningsPart)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getCollectionResponse_Warnings()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='warnings' namespace='##targetNamespace'"
	 * @generated
	 */
	WarningsPart getWarnings();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getWarnings <em>Warnings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warnings</em>' containment reference.
	 * @see #getWarnings()
	 * @generated
	 */
	void setWarnings(WarningsPart value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getCollectionResponse_Id()
	 * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID" required="true"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>More Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>More Values</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>More Values</em>' attribute.
	 * @see #isSetMoreValues()
	 * @see #unsetMoreValues()
	 * @see #setMoreValues(boolean)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getCollectionResponse_MoreValues()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 *        extendedMetaData="kind='attribute' name='moreValues'"
	 * @generated
	 */
	boolean isMoreValues();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#isMoreValues <em>More Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>More Values</em>' attribute.
	 * @see #isSetMoreValues()
	 * @see #unsetMoreValues()
	 * @see #isMoreValues()
	 * @generated
	 */
	void setMoreValues(boolean value);

	/**
	 * Unsets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#isMoreValues <em>More Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMoreValues()
	 * @see #isMoreValues()
	 * @see #setMoreValues(boolean)
	 * @generated
	 */
	void unsetMoreValues();

	/**
	 * Returns whether the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#isMoreValues <em>More Values</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>More Values</em>' attribute is set.
	 * @see #unsetMoreValues()
	 * @see #isMoreValues()
	 * @see #setMoreValues(boolean)
	 * @generated
	 */
	boolean isSetMoreValues();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getCollectionResponse_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seed</em>' attribute.
	 * @see #setSeed(String)
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getCollectionResponse_Seed()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='seed'"
	 * @generated
	 */
	String getSeed();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getSeed <em>Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seed</em>' attribute.
	 * @see #getSeed()
	 * @generated
	 */
	void setSeed(String value);

} // CollectionResponse
