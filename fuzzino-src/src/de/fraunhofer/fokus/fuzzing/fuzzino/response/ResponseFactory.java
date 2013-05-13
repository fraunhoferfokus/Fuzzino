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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage
 * @generated
 */
public interface ResponseFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResponseFactory eINSTANCE = de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponseFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>All Generators Based Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>All Generators Based Part</em>'.
	 * @generated
	 */
	AllGeneratorsBasedPart createAllGeneratorsBasedPart();

	/**
	 * Returns a new object of class '<em>All Operators Based Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>All Operators Based Part</em>'.
	 * @generated
	 */
	AllOperatorsBasedPart createAllOperatorsBasedPart();

	/**
	 * Returns a new object of class '<em>Close Request Confirmation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Close Request Confirmation</em>'.
	 * @generated
	 */
	CloseRequestConfirmation createCloseRequestConfirmation();

	/**
	 * Returns a new object of class '<em>Collection Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Response</em>'.
	 * @generated
	 */
	CollectionResponse createCollectionResponse();

	/**
	 * Returns a new object of class '<em>Error Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Response</em>'.
	 * @generated
	 */
	ErrorResponse createErrorResponse();

	/**
	 * Returns a new object of class '<em>Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Field</em>'.
	 * @generated
	 */
	Field createField();

	/**
	 * Returns a new object of class '<em>Fuzzed Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fuzzed Collection</em>'.
	 * @generated
	 */
	FuzzedCollection createFuzzedCollection();

	/**
	 * Returns a new object of class '<em>Fuzzed Structure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fuzzed Structure</em>'.
	 * @generated
	 */
	FuzzedStructure createFuzzedStructure();

	/**
	 * Returns a new object of class '<em>Generator Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generator Part</em>'.
	 * @generated
	 */
	GeneratorPart createGeneratorPart();

	/**
	 * Returns a new object of class '<em>Illegal Generator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Illegal Generator</em>'.
	 * @generated
	 */
	IllegalGenerator createIllegalGenerator();

	/**
	 * Returns a new object of class '<em>Illegal Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Illegal Operator</em>'.
	 * @generated
	 */
	IllegalOperator createIllegalOperator();

	/**
	 * Returns a new object of class '<em>Illegal Request Format</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Illegal Request Format</em>'.
	 * @generated
	 */
	IllegalRequestFormat createIllegalRequestFormat();

	/**
	 * Returns a new object of class '<em>No More Values Indicator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>No More Values Indicator</em>'.
	 * @generated
	 */
	NoMoreValuesIndicator createNoMoreValuesIndicator();

	/**
	 * Returns a new object of class '<em>Number Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Number Response</em>'.
	 * @generated
	 */
	NumberResponse createNumberResponse();

	/**
	 * Returns a new object of class '<em>Operator Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operator Part</em>'.
	 * @generated
	 */
	OperatorPart createOperatorPart();

	/**
	 * Returns a new object of class '<em>Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Response</em>'.
	 * @generated
	 */
	Response createResponse();

	/**
	 * Returns a new object of class '<em>String Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Response</em>'.
	 * @generated
	 */
	StringResponse createStringResponse();

	/**
	 * Returns a new object of class '<em>Structure Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structure Response</em>'.
	 * @generated
	 */
	StructureResponse createStructureResponse();

	/**
	 * Returns a new object of class '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value</em>'.
	 * @generated
	 */
	Value createValue();

	/**
	 * Returns a new object of class '<em>Warnings Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Warnings Part</em>'.
	 * @generated
	 */
	WarningsPart createWarningsPart();

	/**
	 * Returns a new object of class '<em>Xml Response Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xml Response Document</em>'.
	 * @generated
	 */
	XmlResponseDocument createXmlResponseDocument();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ResponsePackage getResponsePackage();

} //ResponseFactory
