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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory
 * @model kind="package"
 * @generated
 */
public interface ResponsePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "response";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://fuzzino.fuzzing.fokus.fraunhofer.de/response";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "response";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResponsePackage eINSTANCE = de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.AllGeneratorsBasedPartImpl <em>All Generators Based Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.AllGeneratorsBasedPartImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getAllGeneratorsBasedPart()
	 * @generated
	 */
	int ALL_GENERATORS_BASED_PART = 0;

	/**
	 * The feature id for the '<em><b>Generator Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_GENERATORS_BASED_PART__GENERATOR_PARTS = 0;

	/**
	 * The number of structural features of the '<em>All Generators Based Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_GENERATORS_BASED_PART_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.AllOperatorsBasedPartImpl <em>All Operators Based Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.AllOperatorsBasedPartImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getAllOperatorsBasedPart()
	 * @generated
	 */
	int ALL_OPERATORS_BASED_PART = 1;

	/**
	 * The feature id for the '<em><b>Operator Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_OPERATORS_BASED_PART__OPERATOR_PARTS = 0;

	/**
	 * The number of structural features of the '<em>All Operators Based Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_OPERATORS_BASED_PART_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.CloseRequestConfirmationImpl <em>Close Request Confirmation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.CloseRequestConfirmationImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getCloseRequestConfirmation()
	 * @generated
	 */
	int CLOSE_REQUEST_CONFIRMATION = 2;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_REQUEST_CONFIRMATION__WARNINGS = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_REQUEST_CONFIRMATION__ID = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_REQUEST_CONFIRMATION__NAME = 2;

	/**
	 * The number of structural features of the '<em>Close Request Confirmation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_REQUEST_CONFIRMATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.CollectionResponseImpl <em>Collection Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.CollectionResponseImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getCollectionResponse()
	 * @generated
	 */
	int COLLECTION_RESPONSE = 3;

	/**
	 * The feature id for the '<em><b>Fuzzed Collections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESPONSE__FUZZED_COLLECTIONS = 0;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESPONSE__WARNINGS = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESPONSE__ID = 2;

	/**
	 * The feature id for the '<em><b>More Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESPONSE__MORE_VALUES = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESPONSE__NAME = 4;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESPONSE__SEED = 5;

	/**
	 * The number of structural features of the '<em>Collection Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RESPONSE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ErrorResponseImpl <em>Error Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ErrorResponseImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getErrorResponse()
	 * @generated
	 */
	int ERROR_RESPONSE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_RESPONSE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_RESPONSE__COLUMN = 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_RESPONSE__LINE = 2;

	/**
	 * The number of structural features of the '<em>Error Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_RESPONSE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FieldImpl <em>Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FieldImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getField()
	 * @generated
	 */
	int FIELD = 5;

	/**
	 * The feature id for the '<em><b>Fuzz</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__FUZZ = 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__REF = 1;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FuzzedCollectionImpl <em>Fuzzed Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FuzzedCollectionImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getFuzzedCollection()
	 * @generated
	 */
	int FUZZED_COLLECTION = 6;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZED_COLLECTION__VALUES = 0;

	/**
	 * The feature id for the '<em><b>Based On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZED_COLLECTION__BASED_ON = 1;

	/**
	 * The feature id for the '<em><b>Mutations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZED_COLLECTION__MUTATIONS = 2;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZED_COLLECTION__OPERATORS = 3;

	/**
	 * The number of structural features of the '<em>Fuzzed Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZED_COLLECTION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FuzzedStructureImpl <em>Fuzzed Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FuzzedStructureImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getFuzzedStructure()
	 * @generated
	 */
	int FUZZED_STRUCTURE = 7;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZED_STRUCTURE__FIELDS = 0;

	/**
	 * The feature id for the '<em><b>Mutations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZED_STRUCTURE__MUTATIONS = 1;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZED_STRUCTURE__OPERATORS = 2;

	/**
	 * The number of structural features of the '<em>Fuzzed Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZED_STRUCTURE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.GeneratorPartImpl <em>Generator Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.GeneratorPartImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getGeneratorPart()
	 * @generated
	 */
	int GENERATOR_PART = 8;

	/**
	 * The feature id for the '<em><b>Fuzzed Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_PART__FUZZED_VALUES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_PART__NAME = 1;

	/**
	 * The number of structural features of the '<em>Generator Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_PART_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.IllegalGeneratorImpl <em>Illegal Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.IllegalGeneratorImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getIllegalGenerator()
	 * @generated
	 */
	int ILLEGAL_GENERATOR = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_GENERATOR__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_GENERATOR__REASON = 1;

	/**
	 * The number of structural features of the '<em>Illegal Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_GENERATOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.IllegalOperatorImpl <em>Illegal Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.IllegalOperatorImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getIllegalOperator()
	 * @generated
	 */
	int ILLEGAL_OPERATOR = 10;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_OPERATOR__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_OPERATOR__REASON = 1;

	/**
	 * The number of structural features of the '<em>Illegal Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_OPERATOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.IllegalRequestFormatImpl <em>Illegal Request Format</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.IllegalRequestFormatImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getIllegalRequestFormat()
	 * @generated
	 */
	int ILLEGAL_REQUEST_FORMAT = 11;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_REQUEST_FORMAT__ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_REQUEST_FORMAT__ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Missing Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_REQUEST_FORMAT__MISSING_ATTRIBUTE = 2;

	/**
	 * The feature id for the '<em><b>Missing Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_REQUEST_FORMAT__MISSING_ELEMENT = 3;

	/**
	 * The number of structural features of the '<em>Illegal Request Format</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_REQUEST_FORMAT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.NoMoreValuesIndicatorImpl <em>No More Values Indicator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.NoMoreValuesIndicatorImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getNoMoreValuesIndicator()
	 * @generated
	 */
	int NO_MORE_VALUES_INDICATOR = 12;

	/**
	 * The number of structural features of the '<em>No More Values Indicator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_MORE_VALUES_INDICATOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.NumberResponseImpl <em>Number Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.NumberResponseImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getNumberResponse()
	 * @generated
	 */
	int NUMBER_RESPONSE = 13;

	/**
	 * The feature id for the '<em><b>Generator Based Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_RESPONSE__GENERATOR_BASED_PART = 0;

	/**
	 * The feature id for the '<em><b>Operator Based Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_RESPONSE__OPERATOR_BASED_PART = 1;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_RESPONSE__WARNINGS = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_RESPONSE__ID = 3;

	/**
	 * The feature id for the '<em><b>More Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_RESPONSE__MORE_VALUES = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_RESPONSE__NAME = 5;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_RESPONSE__SEED = 6;

	/**
	 * The number of structural features of the '<em>Number Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_RESPONSE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.OperatorPartImpl <em>Operator Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.OperatorPartImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getOperatorPart()
	 * @generated
	 */
	int OPERATOR_PART = 14;

	/**
	 * The feature id for the '<em><b>Fuzzed Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_PART__FUZZED_VALUES = 0;

	/**
	 * The feature id for the '<em><b>Based On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_PART__BASED_ON = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_PART__NAME = 2;

	/**
	 * The number of structural features of the '<em>Operator Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_PART_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponseImpl <em>Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponseImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getResponse()
	 * @generated
	 */
	int RESPONSE = 15;

	/**
	 * The feature id for the '<em><b>String Responses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE__STRING_RESPONSES = 0;

	/**
	 * The feature id for the '<em><b>Number Responses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE__NUMBER_RESPONSES = 1;

	/**
	 * The feature id for the '<em><b>Structure Responses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE__STRUCTURE_RESPONSES = 2;

	/**
	 * The feature id for the '<em><b>Collection Responses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE__COLLECTION_RESPONSES = 3;

	/**
	 * The feature id for the '<em><b>Close Request Confirmations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE__CLOSE_REQUEST_CONFIRMATIONS = 4;

	/**
	 * The feature id for the '<em><b>Error Response</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE__ERROR_RESPONSE = 5;

	/**
	 * The number of structural features of the '<em>Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.StringResponseImpl <em>String Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.StringResponseImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getStringResponse()
	 * @generated
	 */
	int STRING_RESPONSE = 16;

	/**
	 * The feature id for the '<em><b>Generator Based Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RESPONSE__GENERATOR_BASED_PART = 0;

	/**
	 * The feature id for the '<em><b>Operator Based Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RESPONSE__OPERATOR_BASED_PART = 1;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RESPONSE__WARNINGS = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RESPONSE__ID = 3;

	/**
	 * The feature id for the '<em><b>More Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RESPONSE__MORE_VALUES = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RESPONSE__NAME = 5;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RESPONSE__SEED = 6;

	/**
	 * The number of structural features of the '<em>String Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RESPONSE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.StructureResponseImpl <em>Structure Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.StructureResponseImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getStructureResponse()
	 * @generated
	 */
	int STRUCTURE_RESPONSE = 17;

	/**
	 * The feature id for the '<em><b>Fuzzed Structures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_RESPONSE__FUZZED_STRUCTURES = 0;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_RESPONSE__WARNINGS = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_RESPONSE__ID = 2;

	/**
	 * The feature id for the '<em><b>More Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_RESPONSE__MORE_VALUES = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_RESPONSE__NAME = 4;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_RESPONSE__SEED = 5;

	/**
	 * The number of structural features of the '<em>Structure Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_RESPONSE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ValueImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 18;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Based On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__BASED_ON = 1;

	/**
	 * The feature id for the '<em><b>Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__GENERATOR = 2;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__OPERATOR = 3;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.WarningsPartImpl <em>Warnings Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.WarningsPartImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getWarningsPart()
	 * @generated
	 */
	int WARNINGS_PART = 19;

	/**
	 * The feature id for the '<em><b>Illegal Generators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WARNINGS_PART__ILLEGAL_GENERATORS = 0;

	/**
	 * The feature id for the '<em><b>Illegal Operators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WARNINGS_PART__ILLEGAL_OPERATORS = 1;

	/**
	 * The feature id for the '<em><b>Illegal Request Formats</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WARNINGS_PART__ILLEGAL_REQUEST_FORMATS = 2;

	/**
	 * The feature id for the '<em><b>Flag No More Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WARNINGS_PART__FLAG_NO_MORE_VALUES = 3;

	/**
	 * The number of structural features of the '<em>Warnings Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WARNINGS_PART_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.XmlResponseDocumentImpl <em>Xml Response Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.XmlResponseDocumentImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getXmlResponseDocument()
	 * @generated
	 */
	int XML_RESPONSE_DOCUMENT = 20;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_RESPONSE_DOCUMENT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_RESPONSE_DOCUMENT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_RESPONSE_DOCUMENT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Response</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_RESPONSE_DOCUMENT__RESPONSE = 3;

	/**
	 * The number of structural features of the '<em>Xml Response Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_RESPONSE_DOCUMENT_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.AllGeneratorsBasedPart <em>All Generators Based Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All Generators Based Part</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.AllGeneratorsBasedPart
	 * @generated
	 */
	EClass getAllGeneratorsBasedPart();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.AllGeneratorsBasedPart#getGeneratorParts <em>Generator Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Generator Parts</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.AllGeneratorsBasedPart#getGeneratorParts()
	 * @see #getAllGeneratorsBasedPart()
	 * @generated
	 */
	EReference getAllGeneratorsBasedPart_GeneratorParts();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.AllOperatorsBasedPart <em>All Operators Based Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All Operators Based Part</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.AllOperatorsBasedPart
	 * @generated
	 */
	EClass getAllOperatorsBasedPart();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.AllOperatorsBasedPart#getOperatorParts <em>Operator Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operator Parts</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.AllOperatorsBasedPart#getOperatorParts()
	 * @see #getAllOperatorsBasedPart()
	 * @generated
	 */
	EReference getAllOperatorsBasedPart_OperatorParts();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation <em>Close Request Confirmation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Close Request Confirmation</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation
	 * @generated
	 */
	EClass getCloseRequestConfirmation();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation#getWarnings <em>Warnings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Warnings</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation#getWarnings()
	 * @see #getCloseRequestConfirmation()
	 * @generated
	 */
	EReference getCloseRequestConfirmation_Warnings();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation#getId()
	 * @see #getCloseRequestConfirmation()
	 * @generated
	 */
	EAttribute getCloseRequestConfirmation_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation#getName()
	 * @see #getCloseRequestConfirmation()
	 * @generated
	 */
	EAttribute getCloseRequestConfirmation_Name();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse <em>Collection Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Response</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse
	 * @generated
	 */
	EClass getCollectionResponse();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getFuzzedCollections <em>Fuzzed Collections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fuzzed Collections</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getFuzzedCollections()
	 * @see #getCollectionResponse()
	 * @generated
	 */
	EReference getCollectionResponse_FuzzedCollections();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getWarnings <em>Warnings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Warnings</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getWarnings()
	 * @see #getCollectionResponse()
	 * @generated
	 */
	EReference getCollectionResponse_Warnings();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getId()
	 * @see #getCollectionResponse()
	 * @generated
	 */
	EAttribute getCollectionResponse_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#isMoreValues <em>More Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>More Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#isMoreValues()
	 * @see #getCollectionResponse()
	 * @generated
	 */
	EAttribute getCollectionResponse_MoreValues();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getName()
	 * @see #getCollectionResponse()
	 * @generated
	 */
	EAttribute getCollectionResponse_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getSeed <em>Seed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seed</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse#getSeed()
	 * @see #getCollectionResponse()
	 * @generated
	 */
	EAttribute getCollectionResponse_Seed();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse <em>Error Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Response</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse
	 * @generated
	 */
	EClass getErrorResponse();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse#getValue()
	 * @see #getErrorResponse()
	 * @generated
	 */
	EAttribute getErrorResponse_Value();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse#getColumn()
	 * @see #getErrorResponse()
	 * @generated
	 */
	EAttribute getErrorResponse_Column();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse#getLine()
	 * @see #getErrorResponse()
	 * @generated
	 */
	EAttribute getErrorResponse_Line();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Field
	 * @generated
	 */
	EClass getField();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Field#isFuzz <em>Fuzz</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuzz</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Field#isFuzz()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Fuzz();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Field#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Field#getRef()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Ref();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection <em>Fuzzed Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fuzzed Collection</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection
	 * @generated
	 */
	EClass getFuzzedCollection();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getValues()
	 * @see #getFuzzedCollection()
	 * @generated
	 */
	EReference getFuzzedCollection_Values();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getBasedOn <em>Based On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Based On</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getBasedOn()
	 * @see #getFuzzedCollection()
	 * @generated
	 */
	EAttribute getFuzzedCollection_BasedOn();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getMutations <em>Mutations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mutations</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getMutations()
	 * @see #getFuzzedCollection()
	 * @generated
	 */
	EAttribute getFuzzedCollection_Mutations();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operators</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection#getOperators()
	 * @see #getFuzzedCollection()
	 * @generated
	 */
	EAttribute getFuzzedCollection_Operators();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedStructure <em>Fuzzed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fuzzed Structure</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedStructure
	 * @generated
	 */
	EClass getFuzzedStructure();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedStructure#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedStructure#getFields()
	 * @see #getFuzzedStructure()
	 * @generated
	 */
	EReference getFuzzedStructure_Fields();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedStructure#getMutations <em>Mutations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mutations</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedStructure#getMutations()
	 * @see #getFuzzedStructure()
	 * @generated
	 */
	EAttribute getFuzzedStructure_Mutations();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedStructure#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operators</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedStructure#getOperators()
	 * @see #getFuzzedStructure()
	 * @generated
	 */
	EAttribute getFuzzedStructure_Operators();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorPart <em>Generator Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generator Part</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorPart
	 * @generated
	 */
	EClass getGeneratorPart();

	/**
	 * Returns the meta object for the attribute list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorPart#getFuzzedValues <em>Fuzzed Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Fuzzed Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorPart#getFuzzedValues()
	 * @see #getGeneratorPart()
	 * @generated
	 */
	EAttribute getGeneratorPart_FuzzedValues();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorPart#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorPart#getName()
	 * @see #getGeneratorPart()
	 * @generated
	 */
	EAttribute getGeneratorPart_Name();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator <em>Illegal Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Illegal Generator</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator
	 * @generated
	 */
	EClass getIllegalGenerator();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator#getValue()
	 * @see #getIllegalGenerator()
	 * @generated
	 */
	EAttribute getIllegalGenerator_Value();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator#getReason <em>Reason</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reason</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator#getReason()
	 * @see #getIllegalGenerator()
	 * @generated
	 */
	EAttribute getIllegalGenerator_Reason();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator <em>Illegal Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Illegal Operator</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator
	 * @generated
	 */
	EClass getIllegalOperator();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator#getValue()
	 * @see #getIllegalOperator()
	 * @generated
	 */
	EAttribute getIllegalOperator_Value();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator#getReason <em>Reason</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reason</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator#getReason()
	 * @see #getIllegalOperator()
	 * @generated
	 */
	EAttribute getIllegalOperator_Reason();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat <em>Illegal Request Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Illegal Request Format</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat
	 * @generated
	 */
	EClass getIllegalRequestFormat();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat#getAttribute()
	 * @see #getIllegalRequestFormat()
	 * @generated
	 */
	EAttribute getIllegalRequestFormat_Attribute();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat#getElement()
	 * @see #getIllegalRequestFormat()
	 * @generated
	 */
	EAttribute getIllegalRequestFormat_Element();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat#getMissingAttribute <em>Missing Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Missing Attribute</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat#getMissingAttribute()
	 * @see #getIllegalRequestFormat()
	 * @generated
	 */
	EAttribute getIllegalRequestFormat_MissingAttribute();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat#getMissingElement <em>Missing Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Missing Element</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat#getMissingElement()
	 * @see #getIllegalRequestFormat()
	 * @generated
	 */
	EAttribute getIllegalRequestFormat_MissingElement();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.NoMoreValuesIndicator <em>No More Values Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>No More Values Indicator</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.NoMoreValuesIndicator
	 * @generated
	 */
	EClass getNoMoreValuesIndicator();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse <em>Number Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Response</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse
	 * @generated
	 */
	EClass getNumberResponse();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse#getGeneratorBasedPart <em>Generator Based Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Generator Based Part</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse#getGeneratorBasedPart()
	 * @see #getNumberResponse()
	 * @generated
	 */
	EReference getNumberResponse_GeneratorBasedPart();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse#getOperatorBasedPart <em>Operator Based Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operator Based Part</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse#getOperatorBasedPart()
	 * @see #getNumberResponse()
	 * @generated
	 */
	EReference getNumberResponse_OperatorBasedPart();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse#getWarnings <em>Warnings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Warnings</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse#getWarnings()
	 * @see #getNumberResponse()
	 * @generated
	 */
	EReference getNumberResponse_Warnings();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse#getId()
	 * @see #getNumberResponse()
	 * @generated
	 */
	EAttribute getNumberResponse_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse#isMoreValues <em>More Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>More Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse#isMoreValues()
	 * @see #getNumberResponse()
	 * @generated
	 */
	EAttribute getNumberResponse_MoreValues();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse#getName()
	 * @see #getNumberResponse()
	 * @generated
	 */
	EAttribute getNumberResponse_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse#getSeed <em>Seed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seed</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse#getSeed()
	 * @see #getNumberResponse()
	 * @generated
	 */
	EAttribute getNumberResponse_Seed();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart <em>Operator Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator Part</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart
	 * @generated
	 */
	EClass getOperatorPart();

	/**
	 * Returns the meta object for the attribute list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart#getFuzzedValues <em>Fuzzed Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Fuzzed Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart#getFuzzedValues()
	 * @see #getOperatorPart()
	 * @generated
	 */
	EAttribute getOperatorPart_FuzzedValues();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart#getBasedOn <em>Based On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Based On</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart#getBasedOn()
	 * @see #getOperatorPart()
	 * @generated
	 */
	EAttribute getOperatorPart_BasedOn();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart#getName()
	 * @see #getOperatorPart()
	 * @generated
	 */
	EAttribute getOperatorPart_Name();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Response <em>Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Response</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Response
	 * @generated
	 */
	EClass getResponse();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getStringResponses <em>String Responses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>String Responses</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getStringResponses()
	 * @see #getResponse()
	 * @generated
	 */
	EReference getResponse_StringResponses();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getNumberResponses <em>Number Responses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Number Responses</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getNumberResponses()
	 * @see #getResponse()
	 * @generated
	 */
	EReference getResponse_NumberResponses();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getStructureResponses <em>Structure Responses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Structure Responses</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getStructureResponses()
	 * @see #getResponse()
	 * @generated
	 */
	EReference getResponse_StructureResponses();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getCollectionResponses <em>Collection Responses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collection Responses</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getCollectionResponses()
	 * @see #getResponse()
	 * @generated
	 */
	EReference getResponse_CollectionResponses();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getCloseRequestConfirmations <em>Close Request Confirmations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Close Request Confirmations</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getCloseRequestConfirmations()
	 * @see #getResponse()
	 * @generated
	 */
	EReference getResponse_CloseRequestConfirmations();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getErrorResponse <em>Error Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Error Response</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Response#getErrorResponse()
	 * @see #getResponse()
	 * @generated
	 */
	EReference getResponse_ErrorResponse();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse <em>String Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Response</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse
	 * @generated
	 */
	EClass getStringResponse();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse#getGeneratorBasedPart <em>Generator Based Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Generator Based Part</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse#getGeneratorBasedPart()
	 * @see #getStringResponse()
	 * @generated
	 */
	EReference getStringResponse_GeneratorBasedPart();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse#getOperatorBasedPart <em>Operator Based Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operator Based Part</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse#getOperatorBasedPart()
	 * @see #getStringResponse()
	 * @generated
	 */
	EReference getStringResponse_OperatorBasedPart();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse#getWarnings <em>Warnings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Warnings</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse#getWarnings()
	 * @see #getStringResponse()
	 * @generated
	 */
	EReference getStringResponse_Warnings();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse#getId()
	 * @see #getStringResponse()
	 * @generated
	 */
	EAttribute getStringResponse_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse#isMoreValues <em>More Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>More Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse#isMoreValues()
	 * @see #getStringResponse()
	 * @generated
	 */
	EAttribute getStringResponse_MoreValues();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse#getName()
	 * @see #getStringResponse()
	 * @generated
	 */
	EAttribute getStringResponse_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse#getSeed <em>Seed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seed</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse#getSeed()
	 * @see #getStringResponse()
	 * @generated
	 */
	EAttribute getStringResponse_Seed();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse <em>Structure Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure Response</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse
	 * @generated
	 */
	EClass getStructureResponse();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse#getFuzzedStructures <em>Fuzzed Structures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fuzzed Structures</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse#getFuzzedStructures()
	 * @see #getStructureResponse()
	 * @generated
	 */
	EReference getStructureResponse_FuzzedStructures();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse#getWarnings <em>Warnings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Warnings</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse#getWarnings()
	 * @see #getStructureResponse()
	 * @generated
	 */
	EReference getStructureResponse_Warnings();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse#getId()
	 * @see #getStructureResponse()
	 * @generated
	 */
	EAttribute getStructureResponse_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse#isMoreValues <em>More Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>More Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse#isMoreValues()
	 * @see #getStructureResponse()
	 * @generated
	 */
	EAttribute getStructureResponse_MoreValues();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse#getName()
	 * @see #getStructureResponse()
	 * @generated
	 */
	EAttribute getStructureResponse_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse#getSeed <em>Seed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seed</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse#getSeed()
	 * @see #getStructureResponse()
	 * @generated
	 */
	EAttribute getStructureResponse_Seed();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Value#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Value#getValue()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_Value();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Value#getBasedOn <em>Based On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Based On</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Value#getBasedOn()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_BasedOn();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Value#getGenerator <em>Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generator</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Value#getGenerator()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_Generator();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Value#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Value#getOperator()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_Operator();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart <em>Warnings Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Warnings Part</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart
	 * @generated
	 */
	EClass getWarningsPart();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart#getIllegalGenerators <em>Illegal Generators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Illegal Generators</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart#getIllegalGenerators()
	 * @see #getWarningsPart()
	 * @generated
	 */
	EReference getWarningsPart_IllegalGenerators();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart#getIllegalOperators <em>Illegal Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Illegal Operators</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart#getIllegalOperators()
	 * @see #getWarningsPart()
	 * @generated
	 */
	EReference getWarningsPart_IllegalOperators();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart#getIllegalRequestFormats <em>Illegal Request Formats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Illegal Request Formats</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart#getIllegalRequestFormats()
	 * @see #getWarningsPart()
	 * @generated
	 */
	EReference getWarningsPart_IllegalRequestFormats();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart#getFlagNoMoreValues <em>Flag No More Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Flag No More Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart#getFlagNoMoreValues()
	 * @see #getWarningsPart()
	 * @generated
	 */
	EReference getWarningsPart_FlagNoMoreValues();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument <em>Xml Response Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xml Response Document</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument
	 * @generated
	 */
	EClass getXmlResponseDocument();

	/**
	 * Returns the meta object for the attribute list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument#getMixed()
	 * @see #getXmlResponseDocument()
	 * @generated
	 */
	EAttribute getXmlResponseDocument_Mixed();

	/**
	 * Returns the meta object for the map '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument#getXMLNSPrefixMap()
	 * @see #getXmlResponseDocument()
	 * @generated
	 */
	EReference getXmlResponseDocument_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument#getXSISchemaLocation()
	 * @see #getXmlResponseDocument()
	 * @generated
	 */
	EReference getXmlResponseDocument_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument#getResponse <em>Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Response</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument#getResponse()
	 * @see #getXmlResponseDocument()
	 * @generated
	 */
	EReference getXmlResponseDocument_Response();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResponseFactory getResponseFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.AllGeneratorsBasedPartImpl <em>All Generators Based Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.AllGeneratorsBasedPartImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getAllGeneratorsBasedPart()
		 * @generated
		 */
		EClass ALL_GENERATORS_BASED_PART = eINSTANCE.getAllGeneratorsBasedPart();

		/**
		 * The meta object literal for the '<em><b>Generator Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALL_GENERATORS_BASED_PART__GENERATOR_PARTS = eINSTANCE.getAllGeneratorsBasedPart_GeneratorParts();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.AllOperatorsBasedPartImpl <em>All Operators Based Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.AllOperatorsBasedPartImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getAllOperatorsBasedPart()
		 * @generated
		 */
		EClass ALL_OPERATORS_BASED_PART = eINSTANCE.getAllOperatorsBasedPart();

		/**
		 * The meta object literal for the '<em><b>Operator Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALL_OPERATORS_BASED_PART__OPERATOR_PARTS = eINSTANCE.getAllOperatorsBasedPart_OperatorParts();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.CloseRequestConfirmationImpl <em>Close Request Confirmation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.CloseRequestConfirmationImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getCloseRequestConfirmation()
		 * @generated
		 */
		EClass CLOSE_REQUEST_CONFIRMATION = eINSTANCE.getCloseRequestConfirmation();

		/**
		 * The meta object literal for the '<em><b>Warnings</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOSE_REQUEST_CONFIRMATION__WARNINGS = eINSTANCE.getCloseRequestConfirmation_Warnings();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOSE_REQUEST_CONFIRMATION__ID = eINSTANCE.getCloseRequestConfirmation_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOSE_REQUEST_CONFIRMATION__NAME = eINSTANCE.getCloseRequestConfirmation_Name();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.CollectionResponseImpl <em>Collection Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.CollectionResponseImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getCollectionResponse()
		 * @generated
		 */
		EClass COLLECTION_RESPONSE = eINSTANCE.getCollectionResponse();

		/**
		 * The meta object literal for the '<em><b>Fuzzed Collections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_RESPONSE__FUZZED_COLLECTIONS = eINSTANCE.getCollectionResponse_FuzzedCollections();

		/**
		 * The meta object literal for the '<em><b>Warnings</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_RESPONSE__WARNINGS = eINSTANCE.getCollectionResponse_Warnings();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_RESPONSE__ID = eINSTANCE.getCollectionResponse_Id();

		/**
		 * The meta object literal for the '<em><b>More Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_RESPONSE__MORE_VALUES = eINSTANCE.getCollectionResponse_MoreValues();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_RESPONSE__NAME = eINSTANCE.getCollectionResponse_Name();

		/**
		 * The meta object literal for the '<em><b>Seed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_RESPONSE__SEED = eINSTANCE.getCollectionResponse_Seed();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ErrorResponseImpl <em>Error Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ErrorResponseImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getErrorResponse()
		 * @generated
		 */
		EClass ERROR_RESPONSE = eINSTANCE.getErrorResponse();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_RESPONSE__VALUE = eINSTANCE.getErrorResponse_Value();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_RESPONSE__COLUMN = eINSTANCE.getErrorResponse_Column();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_RESPONSE__LINE = eINSTANCE.getErrorResponse_Line();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FieldImpl <em>Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FieldImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getField()
		 * @generated
		 */
		EClass FIELD = eINSTANCE.getField();

		/**
		 * The meta object literal for the '<em><b>Fuzz</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__FUZZ = eINSTANCE.getField_Fuzz();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__REF = eINSTANCE.getField_Ref();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FuzzedCollectionImpl <em>Fuzzed Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FuzzedCollectionImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getFuzzedCollection()
		 * @generated
		 */
		EClass FUZZED_COLLECTION = eINSTANCE.getFuzzedCollection();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUZZED_COLLECTION__VALUES = eINSTANCE.getFuzzedCollection_Values();

		/**
		 * The meta object literal for the '<em><b>Based On</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUZZED_COLLECTION__BASED_ON = eINSTANCE.getFuzzedCollection_BasedOn();

		/**
		 * The meta object literal for the '<em><b>Mutations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUZZED_COLLECTION__MUTATIONS = eINSTANCE.getFuzzedCollection_Mutations();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUZZED_COLLECTION__OPERATORS = eINSTANCE.getFuzzedCollection_Operators();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FuzzedStructureImpl <em>Fuzzed Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FuzzedStructureImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getFuzzedStructure()
		 * @generated
		 */
		EClass FUZZED_STRUCTURE = eINSTANCE.getFuzzedStructure();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUZZED_STRUCTURE__FIELDS = eINSTANCE.getFuzzedStructure_Fields();

		/**
		 * The meta object literal for the '<em><b>Mutations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUZZED_STRUCTURE__MUTATIONS = eINSTANCE.getFuzzedStructure_Mutations();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUZZED_STRUCTURE__OPERATORS = eINSTANCE.getFuzzedStructure_Operators();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.GeneratorPartImpl <em>Generator Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.GeneratorPartImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getGeneratorPart()
		 * @generated
		 */
		EClass GENERATOR_PART = eINSTANCE.getGeneratorPart();

		/**
		 * The meta object literal for the '<em><b>Fuzzed Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATOR_PART__FUZZED_VALUES = eINSTANCE.getGeneratorPart_FuzzedValues();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATOR_PART__NAME = eINSTANCE.getGeneratorPart_Name();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.IllegalGeneratorImpl <em>Illegal Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.IllegalGeneratorImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getIllegalGenerator()
		 * @generated
		 */
		EClass ILLEGAL_GENERATOR = eINSTANCE.getIllegalGenerator();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ILLEGAL_GENERATOR__VALUE = eINSTANCE.getIllegalGenerator_Value();

		/**
		 * The meta object literal for the '<em><b>Reason</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ILLEGAL_GENERATOR__REASON = eINSTANCE.getIllegalGenerator_Reason();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.IllegalOperatorImpl <em>Illegal Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.IllegalOperatorImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getIllegalOperator()
		 * @generated
		 */
		EClass ILLEGAL_OPERATOR = eINSTANCE.getIllegalOperator();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ILLEGAL_OPERATOR__VALUE = eINSTANCE.getIllegalOperator_Value();

		/**
		 * The meta object literal for the '<em><b>Reason</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ILLEGAL_OPERATOR__REASON = eINSTANCE.getIllegalOperator_Reason();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.IllegalRequestFormatImpl <em>Illegal Request Format</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.IllegalRequestFormatImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getIllegalRequestFormat()
		 * @generated
		 */
		EClass ILLEGAL_REQUEST_FORMAT = eINSTANCE.getIllegalRequestFormat();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ILLEGAL_REQUEST_FORMAT__ATTRIBUTE = eINSTANCE.getIllegalRequestFormat_Attribute();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ILLEGAL_REQUEST_FORMAT__ELEMENT = eINSTANCE.getIllegalRequestFormat_Element();

		/**
		 * The meta object literal for the '<em><b>Missing Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ILLEGAL_REQUEST_FORMAT__MISSING_ATTRIBUTE = eINSTANCE.getIllegalRequestFormat_MissingAttribute();

		/**
		 * The meta object literal for the '<em><b>Missing Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ILLEGAL_REQUEST_FORMAT__MISSING_ELEMENT = eINSTANCE.getIllegalRequestFormat_MissingElement();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.NoMoreValuesIndicatorImpl <em>No More Values Indicator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.NoMoreValuesIndicatorImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getNoMoreValuesIndicator()
		 * @generated
		 */
		EClass NO_MORE_VALUES_INDICATOR = eINSTANCE.getNoMoreValuesIndicator();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.NumberResponseImpl <em>Number Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.NumberResponseImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getNumberResponse()
		 * @generated
		 */
		EClass NUMBER_RESPONSE = eINSTANCE.getNumberResponse();

		/**
		 * The meta object literal for the '<em><b>Generator Based Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMBER_RESPONSE__GENERATOR_BASED_PART = eINSTANCE.getNumberResponse_GeneratorBasedPart();

		/**
		 * The meta object literal for the '<em><b>Operator Based Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMBER_RESPONSE__OPERATOR_BASED_PART = eINSTANCE.getNumberResponse_OperatorBasedPart();

		/**
		 * The meta object literal for the '<em><b>Warnings</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMBER_RESPONSE__WARNINGS = eINSTANCE.getNumberResponse_Warnings();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_RESPONSE__ID = eINSTANCE.getNumberResponse_Id();

		/**
		 * The meta object literal for the '<em><b>More Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_RESPONSE__MORE_VALUES = eINSTANCE.getNumberResponse_MoreValues();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_RESPONSE__NAME = eINSTANCE.getNumberResponse_Name();

		/**
		 * The meta object literal for the '<em><b>Seed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_RESPONSE__SEED = eINSTANCE.getNumberResponse_Seed();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.OperatorPartImpl <em>Operator Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.OperatorPartImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getOperatorPart()
		 * @generated
		 */
		EClass OPERATOR_PART = eINSTANCE.getOperatorPart();

		/**
		 * The meta object literal for the '<em><b>Fuzzed Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR_PART__FUZZED_VALUES = eINSTANCE.getOperatorPart_FuzzedValues();

		/**
		 * The meta object literal for the '<em><b>Based On</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR_PART__BASED_ON = eINSTANCE.getOperatorPart_BasedOn();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR_PART__NAME = eINSTANCE.getOperatorPart_Name();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponseImpl <em>Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponseImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getResponse()
		 * @generated
		 */
		EClass RESPONSE = eINSTANCE.getResponse();

		/**
		 * The meta object literal for the '<em><b>String Responses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSE__STRING_RESPONSES = eINSTANCE.getResponse_StringResponses();

		/**
		 * The meta object literal for the '<em><b>Number Responses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSE__NUMBER_RESPONSES = eINSTANCE.getResponse_NumberResponses();

		/**
		 * The meta object literal for the '<em><b>Structure Responses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSE__STRUCTURE_RESPONSES = eINSTANCE.getResponse_StructureResponses();

		/**
		 * The meta object literal for the '<em><b>Collection Responses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSE__COLLECTION_RESPONSES = eINSTANCE.getResponse_CollectionResponses();

		/**
		 * The meta object literal for the '<em><b>Close Request Confirmations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSE__CLOSE_REQUEST_CONFIRMATIONS = eINSTANCE.getResponse_CloseRequestConfirmations();

		/**
		 * The meta object literal for the '<em><b>Error Response</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSE__ERROR_RESPONSE = eINSTANCE.getResponse_ErrorResponse();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.StringResponseImpl <em>String Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.StringResponseImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getStringResponse()
		 * @generated
		 */
		EClass STRING_RESPONSE = eINSTANCE.getStringResponse();

		/**
		 * The meta object literal for the '<em><b>Generator Based Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_RESPONSE__GENERATOR_BASED_PART = eINSTANCE.getStringResponse_GeneratorBasedPart();

		/**
		 * The meta object literal for the '<em><b>Operator Based Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_RESPONSE__OPERATOR_BASED_PART = eINSTANCE.getStringResponse_OperatorBasedPart();

		/**
		 * The meta object literal for the '<em><b>Warnings</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_RESPONSE__WARNINGS = eINSTANCE.getStringResponse_Warnings();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_RESPONSE__ID = eINSTANCE.getStringResponse_Id();

		/**
		 * The meta object literal for the '<em><b>More Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_RESPONSE__MORE_VALUES = eINSTANCE.getStringResponse_MoreValues();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_RESPONSE__NAME = eINSTANCE.getStringResponse_Name();

		/**
		 * The meta object literal for the '<em><b>Seed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_RESPONSE__SEED = eINSTANCE.getStringResponse_Seed();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.StructureResponseImpl <em>Structure Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.StructureResponseImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getStructureResponse()
		 * @generated
		 */
		EClass STRUCTURE_RESPONSE = eINSTANCE.getStructureResponse();

		/**
		 * The meta object literal for the '<em><b>Fuzzed Structures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_RESPONSE__FUZZED_STRUCTURES = eINSTANCE.getStructureResponse_FuzzedStructures();

		/**
		 * The meta object literal for the '<em><b>Warnings</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_RESPONSE__WARNINGS = eINSTANCE.getStructureResponse_Warnings();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_RESPONSE__ID = eINSTANCE.getStructureResponse_Id();

		/**
		 * The meta object literal for the '<em><b>More Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_RESPONSE__MORE_VALUES = eINSTANCE.getStructureResponse_MoreValues();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_RESPONSE__NAME = eINSTANCE.getStructureResponse_Name();

		/**
		 * The meta object literal for the '<em><b>Seed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_RESPONSE__SEED = eINSTANCE.getStructureResponse_Seed();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ValueImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__VALUE = eINSTANCE.getValue_Value();

		/**
		 * The meta object literal for the '<em><b>Based On</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__BASED_ON = eINSTANCE.getValue_BasedOn();

		/**
		 * The meta object literal for the '<em><b>Generator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__GENERATOR = eINSTANCE.getValue_Generator();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__OPERATOR = eINSTANCE.getValue_Operator();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.WarningsPartImpl <em>Warnings Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.WarningsPartImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getWarningsPart()
		 * @generated
		 */
		EClass WARNINGS_PART = eINSTANCE.getWarningsPart();

		/**
		 * The meta object literal for the '<em><b>Illegal Generators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WARNINGS_PART__ILLEGAL_GENERATORS = eINSTANCE.getWarningsPart_IllegalGenerators();

		/**
		 * The meta object literal for the '<em><b>Illegal Operators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WARNINGS_PART__ILLEGAL_OPERATORS = eINSTANCE.getWarningsPart_IllegalOperators();

		/**
		 * The meta object literal for the '<em><b>Illegal Request Formats</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WARNINGS_PART__ILLEGAL_REQUEST_FORMATS = eINSTANCE.getWarningsPart_IllegalRequestFormats();

		/**
		 * The meta object literal for the '<em><b>Flag No More Values</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WARNINGS_PART__FLAG_NO_MORE_VALUES = eINSTANCE.getWarningsPart_FlagNoMoreValues();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.XmlResponseDocumentImpl <em>Xml Response Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.XmlResponseDocumentImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponsePackageImpl#getXmlResponseDocument()
		 * @generated
		 */
		EClass XML_RESPONSE_DOCUMENT = eINSTANCE.getXmlResponseDocument();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XML_RESPONSE_DOCUMENT__MIXED = eINSTANCE.getXmlResponseDocument_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XML_RESPONSE_DOCUMENT__XMLNS_PREFIX_MAP = eINSTANCE.getXmlResponseDocument_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XML_RESPONSE_DOCUMENT__XSI_SCHEMA_LOCATION = eINSTANCE.getXmlResponseDocument_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Response</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XML_RESPONSE_DOCUMENT__RESPONSE = eINSTANCE.getXmlResponseDocument_Response();

	}

} //ResponsePackage
