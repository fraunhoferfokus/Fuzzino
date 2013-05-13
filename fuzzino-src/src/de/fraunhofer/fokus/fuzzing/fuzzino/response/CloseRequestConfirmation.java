/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fraunhofer.fokus.fuzzing.fuzzino.response;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Close Request Confirmation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation#getWarnings <em>Warnings</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation#getId <em>Id</em>}</li>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getCloseRequestConfirmation()
 * @model extendedMetaData="name='closeRequestDone_._type' kind='elementOnly'"
 * @generated
 */
public interface CloseRequestConfirmation extends EObject {
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
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getCloseRequestConfirmation_Warnings()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='warnings' namespace='##targetNamespace'"
	 * @generated
	 */
	WarningsPart getWarnings();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation#getWarnings <em>Warnings</em>}' containment reference.
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
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getCloseRequestConfirmation_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

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
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getCloseRequestConfirmation_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // CloseRequestConfirmation
