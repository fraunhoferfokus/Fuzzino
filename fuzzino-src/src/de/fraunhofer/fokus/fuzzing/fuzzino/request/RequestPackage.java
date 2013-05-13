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
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory
 * @model kind="package"
 * @generated
 */
public interface RequestPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "request";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://fuzzino.fuzzing.fokus.fraunhofer.de/request";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "request";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RequestPackage eINSTANCE = de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CloseRequestImpl <em>Close Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CloseRequestImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getCloseRequest()
	 * @generated
	 */
	int CLOSE_REQUEST = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_REQUEST__ID = 0;

	/**
	 * The number of structural features of the '<em>Close Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_REQUEST_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CollectionRequestImpl <em>Collection Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CollectionRequestImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getCollectionRequest()
	 * @generated
	 */
	int COLLECTION_REQUEST = 1;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_REQUEST__SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Valid Collections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_REQUEST__VALID_COLLECTIONS = 1;

	/**
	 * The feature id for the '<em><b>Fuzz Structure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_REQUEST__FUZZ_STRUCTURE = 2;

	/**
	 * The feature id for the '<em><b>Fuzz Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_REQUEST__FUZZ_VALUES = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_REQUEST__ID = 4;

	/**
	 * The feature id for the '<em><b>Max Mutations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_REQUEST__MAX_MUTATIONS = 5;

	/**
	 * The feature id for the '<em><b>Max Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_REQUEST__MAX_VALUES = 6;

	/**
	 * The feature id for the '<em><b>Min Mutations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_REQUEST__MIN_MUTATIONS = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_REQUEST__NAME = 8;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_REQUEST__SEED = 9;

	/**
	 * The number of structural features of the '<em>Collection Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_REQUEST_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.FieldImpl <em>Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.FieldImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getField()
	 * @generated
	 */
	int FIELD = 2;

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
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.GeneratorImpl <em>Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.GeneratorImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getGenerator()
	 * @generated
	 */
	int GENERATOR = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Param</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR__PARAM = 1;

	/**
	 * The number of structural features of the '<em>Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NoGeneratorsImpl <em>No Generators</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NoGeneratorsImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getNoGenerators()
	 * @generated
	 */
	int NO_GENERATORS = 4;

	/**
	 * The number of structural features of the '<em>No Generators</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_GENERATORS_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl <em>Number Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getNumberRequest()
	 * @generated
	 */
	int NUMBER_REQUEST = 5;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_REQUEST__SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>No Generators</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_REQUEST__NO_GENERATORS = 1;

	/**
	 * The feature id for the '<em><b>Generators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_REQUEST__GENERATORS = 2;

	/**
	 * The feature id for the '<em><b>Valid Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_REQUEST__VALID_VALUES = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_REQUEST__ID = 4;

	/**
	 * The feature id for the '<em><b>Max Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_REQUEST__MAX_VALUES = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_REQUEST__NAME = 6;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_REQUEST__SEED = 7;

	/**
	 * The number of structural features of the '<em>Number Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_REQUEST_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.OperatorImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Param</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__PARAM = 1;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestImpl <em>Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getRequest()
	 * @generated
	 */
	int REQUEST = 7;

	/**
	 * The feature id for the '<em><b>String Requests</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__STRING_REQUESTS = 0;

	/**
	 * The feature id for the '<em><b>Number Requests</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__NUMBER_REQUESTS = 1;

	/**
	 * The feature id for the '<em><b>Structure Requests</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__STRUCTURE_REQUESTS = 2;

	/**
	 * The feature id for the '<em><b>Collection Requests</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__COLLECTION_REQUESTS = 3;

	/**
	 * The feature id for the '<em><b>Close Requests</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__CLOSE_REQUESTS = 4;

	/**
	 * The number of structural features of the '<em>Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl <em>Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getRequestSpecification()
	 * @generated
	 */
	int REQUEST_SPECIFICATION = 8;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SPECIFICATION__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Field</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SPECIFICATION__FIELD = 1;

	/**
	 * The feature id for the '<em><b>Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SPECIFICATION__BITS = 2;

	/**
	 * The feature id for the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SPECIFICATION__ENCODING = 3;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SPECIFICATION__MAX_LENGTH = 4;

	/**
	 * The feature id for the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SPECIFICATION__MAX_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SPECIFICATION__MIN_LENGTH = 6;

	/**
	 * The feature id for the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SPECIFICATION__MIN_VALUE = 7;

	/**
	 * The feature id for the '<em><b>Null Terminated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SPECIFICATION__NULL_TERMINATED = 8;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SPECIFICATION__ORDERED = 9;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SPECIFICATION__REF = 10;

	/**
	 * The feature id for the '<em><b>Signed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SPECIFICATION__SIGNED = 11;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SPECIFICATION__TYPE = 12;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SPECIFICATION__UNIQUE = 13;

	/**
	 * The number of structural features of the '<em>Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_SPECIFICATION_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringRequestImpl <em>String Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringRequestImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getStringRequest()
	 * @generated
	 */
	int STRING_REQUEST = 9;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_REQUEST__SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>No Generators</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_REQUEST__NO_GENERATORS = 1;

	/**
	 * The feature id for the '<em><b>Generators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_REQUEST__GENERATORS = 2;

	/**
	 * The feature id for the '<em><b>Valid Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_REQUEST__VALID_VALUES = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_REQUEST__ID = 4;

	/**
	 * The feature id for the '<em><b>Max Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_REQUEST__MAX_VALUES = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_REQUEST__NAME = 6;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_REQUEST__SEED = 7;

	/**
	 * The number of structural features of the '<em>String Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_REQUEST_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StructureRequestImpl <em>Structure Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StructureRequestImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getStructureRequest()
	 * @generated
	 */
	int STRUCTURE_REQUEST = 10;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_REQUEST__SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_REQUEST__OPERATORS = 1;

	/**
	 * The feature id for the '<em><b>Fuzz Structure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_REQUEST__FUZZ_STRUCTURE = 2;

	/**
	 * The feature id for the '<em><b>Fuzz Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_REQUEST__FUZZ_VALUES = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_REQUEST__ID = 4;

	/**
	 * The feature id for the '<em><b>Max Mutations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_REQUEST__MAX_MUTATIONS = 5;

	/**
	 * The feature id for the '<em><b>Max Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_REQUEST__MAX_VALUES = 6;

	/**
	 * The feature id for the '<em><b>Min Mutations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_REQUEST__MIN_MUTATIONS = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_REQUEST__NAME = 8;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_REQUEST__SEED = 9;

	/**
	 * The number of structural features of the '<em>Structure Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_REQUEST_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidCollectionImpl <em>Valid Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidCollectionImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getValidCollection()
	 * @generated
	 */
	int VALID_COLLECTION = 11;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_COLLECTION__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_COLLECTION__NAME = 1;

	/**
	 * The number of structural features of the '<em>Valid Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_COLLECTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidCollectionsImpl <em>Valid Collections</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidCollectionsImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getValidCollections()
	 * @generated
	 */
	int VALID_COLLECTIONS = 12;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_COLLECTIONS__VALUES = 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_COLLECTIONS__OPERATORS = 1;

	/**
	 * The number of structural features of the '<em>Valid Collections</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_COLLECTIONS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidValuesImpl <em>Valid Values</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidValuesImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getValidValues()
	 * @generated
	 */
	int VALID_VALUES = 13;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_VALUES__VALUES = 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_VALUES__OPERATORS = 1;

	/**
	 * The number of structural features of the '<em>Valid Values</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_VALUES_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.XmlRequestDocumentImpl <em>Xml Request Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.XmlRequestDocumentImpl
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getXmlRequestDocument()
	 * @generated
	 */
	int XML_REQUEST_DOCUMENT = 14;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_REQUEST_DOCUMENT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_REQUEST_DOCUMENT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_REQUEST_DOCUMENT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Request</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_REQUEST_DOCUMENT__REQUEST = 3;

	/**
	 * The number of structural features of the '<em>Xml Request Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_REQUEST_DOCUMENT_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest <em>Close Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Close Request</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest
	 * @generated
	 */
	EClass getCloseRequest();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest#getId()
	 * @see #getCloseRequest()
	 * @generated
	 */
	EAttribute getCloseRequest_Id();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest <em>Collection Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Request</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest
	 * @generated
	 */
	EClass getCollectionRequest();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specification</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#getSpecification()
	 * @see #getCollectionRequest()
	 * @generated
	 */
	EReference getCollectionRequest_Specification();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#getValidCollections <em>Valid Collections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Valid Collections</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#getValidCollections()
	 * @see #getCollectionRequest()
	 * @generated
	 */
	EReference getCollectionRequest_ValidCollections();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#isFuzzStructure <em>Fuzz Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuzz Structure</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#isFuzzStructure()
	 * @see #getCollectionRequest()
	 * @generated
	 */
	EAttribute getCollectionRequest_FuzzStructure();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#isFuzzValues <em>Fuzz Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuzz Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#isFuzzValues()
	 * @see #getCollectionRequest()
	 * @generated
	 */
	EAttribute getCollectionRequest_FuzzValues();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#getId()
	 * @see #getCollectionRequest()
	 * @generated
	 */
	EAttribute getCollectionRequest_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#getMaxMutations <em>Max Mutations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Mutations</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#getMaxMutations()
	 * @see #getCollectionRequest()
	 * @generated
	 */
	EAttribute getCollectionRequest_MaxMutations();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#getMaxValues <em>Max Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#getMaxValues()
	 * @see #getCollectionRequest()
	 * @generated
	 */
	EAttribute getCollectionRequest_MaxValues();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#getMinMutations <em>Min Mutations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Mutations</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#getMinMutations()
	 * @see #getCollectionRequest()
	 * @generated
	 */
	EAttribute getCollectionRequest_MinMutations();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#getName()
	 * @see #getCollectionRequest()
	 * @generated
	 */
	EAttribute getCollectionRequest_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#getSeed <em>Seed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seed</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest#getSeed()
	 * @see #getCollectionRequest()
	 * @generated
	 */
	EAttribute getCollectionRequest_Seed();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Field
	 * @generated
	 */
	EClass getField();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Field#isFuzz <em>Fuzz</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuzz</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Field#isFuzz()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Fuzz();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Field#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Field#getRef()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Ref();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator <em>Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generator</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator
	 * @generated
	 */
	EClass getGenerator();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator#getValue()
	 * @see #getGenerator()
	 * @generated
	 */
	EAttribute getGenerator_Value();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Param</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator#getParam()
	 * @see #getGenerator()
	 * @generated
	 */
	EAttribute getGenerator_Param();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NoGenerators <em>No Generators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>No Generators</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.NoGenerators
	 * @generated
	 */
	EClass getNoGenerators();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest <em>Number Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Request</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest
	 * @generated
	 */
	EClass getNumberRequest();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specification</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getSpecification()
	 * @see #getNumberRequest()
	 * @generated
	 */
	EReference getNumberRequest_Specification();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getNoGenerators <em>No Generators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>No Generators</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getNoGenerators()
	 * @see #getNumberRequest()
	 * @generated
	 */
	EReference getNumberRequest_NoGenerators();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getGenerators <em>Generators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Generators</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getGenerators()
	 * @see #getNumberRequest()
	 * @generated
	 */
	EReference getNumberRequest_Generators();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getValidValues <em>Valid Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Valid Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getValidValues()
	 * @see #getNumberRequest()
	 * @generated
	 */
	EReference getNumberRequest_ValidValues();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getId()
	 * @see #getNumberRequest()
	 * @generated
	 */
	EAttribute getNumberRequest_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getMaxValues <em>Max Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getMaxValues()
	 * @see #getNumberRequest()
	 * @generated
	 */
	EAttribute getNumberRequest_MaxValues();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getName()
	 * @see #getNumberRequest()
	 * @generated
	 */
	EAttribute getNumberRequest_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getSeed <em>Seed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seed</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest#getSeed()
	 * @see #getNumberRequest()
	 * @generated
	 */
	EAttribute getNumberRequest_Seed();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator#getValue()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_Value();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Param</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator#getParam()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_Param();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Request <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Request</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Request
	 * @generated
	 */
	EClass getRequest();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Request#getStringRequests <em>String Requests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>String Requests</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Request#getStringRequests()
	 * @see #getRequest()
	 * @generated
	 */
	EReference getRequest_StringRequests();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Request#getNumberRequests <em>Number Requests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Number Requests</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Request#getNumberRequests()
	 * @see #getRequest()
	 * @generated
	 */
	EReference getRequest_NumberRequests();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Request#getStructureRequests <em>Structure Requests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Structure Requests</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Request#getStructureRequests()
	 * @see #getRequest()
	 * @generated
	 */
	EReference getRequest_StructureRequests();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Request#getCollectionRequests <em>Collection Requests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collection Requests</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Request#getCollectionRequests()
	 * @see #getRequest()
	 * @generated
	 */
	EReference getRequest_CollectionRequests();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Request#getCloseRequests <em>Close Requests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Close Requests</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Request#getCloseRequests()
	 * @see #getRequest()
	 * @generated
	 */
	EReference getRequest_CloseRequests();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specification</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification
	 * @generated
	 */
	EClass getRequestSpecification();

	/**
	 * Returns the meta object for the attribute list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMixed()
	 * @see #getRequestSpecification()
	 * @generated
	 */
	EAttribute getRequestSpecification_Mixed();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Field</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getField()
	 * @see #getRequestSpecification()
	 * @generated
	 */
	EReference getRequestSpecification_Field();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getBits <em>Bits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bits</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getBits()
	 * @see #getRequestSpecification()
	 * @generated
	 */
	EAttribute getRequestSpecification_Bits();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getEncoding <em>Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encoding</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getEncoding()
	 * @see #getRequestSpecification()
	 * @generated
	 */
	EAttribute getRequestSpecification_Encoding();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Length</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMaxLength()
	 * @see #getRequestSpecification()
	 * @generated
	 */
	EAttribute getRequestSpecification_MaxLength();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMaxValue <em>Max Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Value</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMaxValue()
	 * @see #getRequestSpecification()
	 * @generated
	 */
	EAttribute getRequestSpecification_MaxValue();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Length</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMinLength()
	 * @see #getRequestSpecification()
	 * @generated
	 */
	EAttribute getRequestSpecification_MinLength();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMinValue <em>Min Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Value</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getMinValue()
	 * @see #getRequestSpecification()
	 * @generated
	 */
	EAttribute getRequestSpecification_MinValue();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isNullTerminated <em>Null Terminated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Null Terminated</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isNullTerminated()
	 * @see #getRequestSpecification()
	 * @generated
	 */
	EAttribute getRequestSpecification_NullTerminated();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isOrdered <em>Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ordered</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isOrdered()
	 * @see #getRequestSpecification()
	 * @generated
	 */
	EAttribute getRequestSpecification_Ordered();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getRef()
	 * @see #getRequestSpecification()
	 * @generated
	 */
	EAttribute getRequestSpecification_Ref();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isSigned <em>Signed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signed</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isSigned()
	 * @see #getRequestSpecification()
	 * @generated
	 */
	EAttribute getRequestSpecification_Signed();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#getType()
	 * @see #getRequestSpecification()
	 * @generated
	 */
	EAttribute getRequestSpecification_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isUnique <em>Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unique</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification#isUnique()
	 * @see #getRequestSpecification()
	 * @generated
	 */
	EAttribute getRequestSpecification_Unique();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest <em>String Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Request</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest
	 * @generated
	 */
	EClass getStringRequest();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specification</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest#getSpecification()
	 * @see #getStringRequest()
	 * @generated
	 */
	EReference getStringRequest_Specification();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest#getNoGenerators <em>No Generators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>No Generators</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest#getNoGenerators()
	 * @see #getStringRequest()
	 * @generated
	 */
	EReference getStringRequest_NoGenerators();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest#getGenerators <em>Generators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Generators</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest#getGenerators()
	 * @see #getStringRequest()
	 * @generated
	 */
	EReference getStringRequest_Generators();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest#getValidValues <em>Valid Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Valid Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest#getValidValues()
	 * @see #getStringRequest()
	 * @generated
	 */
	EReference getStringRequest_ValidValues();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest#getId()
	 * @see #getStringRequest()
	 * @generated
	 */
	EAttribute getStringRequest_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest#getMaxValues <em>Max Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest#getMaxValues()
	 * @see #getStringRequest()
	 * @generated
	 */
	EAttribute getStringRequest_MaxValues();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest#getName()
	 * @see #getStringRequest()
	 * @generated
	 */
	EAttribute getStringRequest_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest#getSeed <em>Seed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seed</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest#getSeed()
	 * @see #getStringRequest()
	 * @generated
	 */
	EAttribute getStringRequest_Seed();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest <em>Structure Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure Request</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest
	 * @generated
	 */
	EClass getStructureRequest();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specification</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getSpecification()
	 * @see #getStructureRequest()
	 * @generated
	 */
	EReference getStructureRequest_Specification();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operators</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getOperators()
	 * @see #getStructureRequest()
	 * @generated
	 */
	EReference getStructureRequest_Operators();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#isFuzzStructure <em>Fuzz Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuzz Structure</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#isFuzzStructure()
	 * @see #getStructureRequest()
	 * @generated
	 */
	EAttribute getStructureRequest_FuzzStructure();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#isFuzzValues <em>Fuzz Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fuzz Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#isFuzzValues()
	 * @see #getStructureRequest()
	 * @generated
	 */
	EAttribute getStructureRequest_FuzzValues();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getId()
	 * @see #getStructureRequest()
	 * @generated
	 */
	EAttribute getStructureRequest_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getMaxMutations <em>Max Mutations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Mutations</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getMaxMutations()
	 * @see #getStructureRequest()
	 * @generated
	 */
	EAttribute getStructureRequest_MaxMutations();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getMaxValues <em>Max Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getMaxValues()
	 * @see #getStructureRequest()
	 * @generated
	 */
	EAttribute getStructureRequest_MaxValues();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getMinMutations <em>Min Mutations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Mutations</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getMinMutations()
	 * @see #getStructureRequest()
	 * @generated
	 */
	EAttribute getStructureRequest_MinMutations();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getName()
	 * @see #getStructureRequest()
	 * @generated
	 */
	EAttribute getStructureRequest_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getSeed <em>Seed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seed</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest#getSeed()
	 * @see #getStructureRequest()
	 * @generated
	 */
	EAttribute getStructureRequest_Seed();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection <em>Valid Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Valid Collection</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection
	 * @generated
	 */
	EClass getValidCollection();

	/**
	 * Returns the meta object for the attribute list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection#getValue()
	 * @see #getValidCollection()
	 * @generated
	 */
	EAttribute getValidCollection_Value();

	/**
	 * Returns the meta object for the attribute '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection#getName()
	 * @see #getValidCollection()
	 * @generated
	 */
	EAttribute getValidCollection_Name();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollections <em>Valid Collections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Valid Collections</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollections
	 * @generated
	 */
	EClass getValidCollections();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollections#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollections#getValues()
	 * @see #getValidCollections()
	 * @generated
	 */
	EReference getValidCollections_Values();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollections#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operators</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollections#getOperators()
	 * @see #getValidCollections()
	 * @generated
	 */
	EReference getValidCollections_Operators();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValues <em>Valid Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Valid Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValues
	 * @generated
	 */
	EClass getValidValues();

	/**
	 * Returns the meta object for the attribute list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValues#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValues#getValues()
	 * @see #getValidValues()
	 * @generated
	 */
	EAttribute getValidValues_Values();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValues#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operators</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValues#getOperators()
	 * @see #getValidValues()
	 * @generated
	 */
	EReference getValidValues_Operators();

	/**
	 * Returns the meta object for class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument <em>Xml Request Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xml Request Document</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument
	 * @generated
	 */
	EClass getXmlRequestDocument();

	/**
	 * Returns the meta object for the attribute list '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument#getMixed()
	 * @see #getXmlRequestDocument()
	 * @generated
	 */
	EAttribute getXmlRequestDocument_Mixed();

	/**
	 * Returns the meta object for the map '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument#getXMLNSPrefixMap()
	 * @see #getXmlRequestDocument()
	 * @generated
	 */
	EReference getXmlRequestDocument_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument#getXSISchemaLocation()
	 * @see #getXmlRequestDocument()
	 * @generated
	 */
	EReference getXmlRequestDocument_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument#getRequest <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Request</em>'.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument#getRequest()
	 * @see #getXmlRequestDocument()
	 * @generated
	 */
	EReference getXmlRequestDocument_Request();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RequestFactory getRequestFactory();

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
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CloseRequestImpl <em>Close Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CloseRequestImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getCloseRequest()
		 * @generated
		 */
		EClass CLOSE_REQUEST = eINSTANCE.getCloseRequest();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOSE_REQUEST__ID = eINSTANCE.getCloseRequest_Id();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CollectionRequestImpl <em>Collection Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CollectionRequestImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getCollectionRequest()
		 * @generated
		 */
		EClass COLLECTION_REQUEST = eINSTANCE.getCollectionRequest();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_REQUEST__SPECIFICATION = eINSTANCE.getCollectionRequest_Specification();

		/**
		 * The meta object literal for the '<em><b>Valid Collections</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_REQUEST__VALID_COLLECTIONS = eINSTANCE.getCollectionRequest_ValidCollections();

		/**
		 * The meta object literal for the '<em><b>Fuzz Structure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_REQUEST__FUZZ_STRUCTURE = eINSTANCE.getCollectionRequest_FuzzStructure();

		/**
		 * The meta object literal for the '<em><b>Fuzz Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_REQUEST__FUZZ_VALUES = eINSTANCE.getCollectionRequest_FuzzValues();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_REQUEST__ID = eINSTANCE.getCollectionRequest_Id();

		/**
		 * The meta object literal for the '<em><b>Max Mutations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_REQUEST__MAX_MUTATIONS = eINSTANCE.getCollectionRequest_MaxMutations();

		/**
		 * The meta object literal for the '<em><b>Max Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_REQUEST__MAX_VALUES = eINSTANCE.getCollectionRequest_MaxValues();

		/**
		 * The meta object literal for the '<em><b>Min Mutations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_REQUEST__MIN_MUTATIONS = eINSTANCE.getCollectionRequest_MinMutations();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_REQUEST__NAME = eINSTANCE.getCollectionRequest_Name();

		/**
		 * The meta object literal for the '<em><b>Seed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_REQUEST__SEED = eINSTANCE.getCollectionRequest_Seed();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.FieldImpl <em>Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.FieldImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getField()
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
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.GeneratorImpl <em>Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.GeneratorImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getGenerator()
		 * @generated
		 */
		EClass GENERATOR = eINSTANCE.getGenerator();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATOR__VALUE = eINSTANCE.getGenerator_Value();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATOR__PARAM = eINSTANCE.getGenerator_Param();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NoGeneratorsImpl <em>No Generators</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NoGeneratorsImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getNoGenerators()
		 * @generated
		 */
		EClass NO_GENERATORS = eINSTANCE.getNoGenerators();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl <em>Number Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getNumberRequest()
		 * @generated
		 */
		EClass NUMBER_REQUEST = eINSTANCE.getNumberRequest();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMBER_REQUEST__SPECIFICATION = eINSTANCE.getNumberRequest_Specification();

		/**
		 * The meta object literal for the '<em><b>No Generators</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMBER_REQUEST__NO_GENERATORS = eINSTANCE.getNumberRequest_NoGenerators();

		/**
		 * The meta object literal for the '<em><b>Generators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMBER_REQUEST__GENERATORS = eINSTANCE.getNumberRequest_Generators();

		/**
		 * The meta object literal for the '<em><b>Valid Values</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMBER_REQUEST__VALID_VALUES = eINSTANCE.getNumberRequest_ValidValues();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_REQUEST__ID = eINSTANCE.getNumberRequest_Id();

		/**
		 * The meta object literal for the '<em><b>Max Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_REQUEST__MAX_VALUES = eINSTANCE.getNumberRequest_MaxValues();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_REQUEST__NAME = eINSTANCE.getNumberRequest_Name();

		/**
		 * The meta object literal for the '<em><b>Seed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_REQUEST__SEED = eINSTANCE.getNumberRequest_Seed();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.OperatorImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getOperator()
		 * @generated
		 */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__VALUE = eINSTANCE.getOperator_Value();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__PARAM = eINSTANCE.getOperator_Param();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestImpl <em>Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getRequest()
		 * @generated
		 */
		EClass REQUEST = eINSTANCE.getRequest();

		/**
		 * The meta object literal for the '<em><b>String Requests</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUEST__STRING_REQUESTS = eINSTANCE.getRequest_StringRequests();

		/**
		 * The meta object literal for the '<em><b>Number Requests</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUEST__NUMBER_REQUESTS = eINSTANCE.getRequest_NumberRequests();

		/**
		 * The meta object literal for the '<em><b>Structure Requests</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUEST__STRUCTURE_REQUESTS = eINSTANCE.getRequest_StructureRequests();

		/**
		 * The meta object literal for the '<em><b>Collection Requests</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUEST__COLLECTION_REQUESTS = eINSTANCE.getRequest_CollectionRequests();

		/**
		 * The meta object literal for the '<em><b>Close Requests</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUEST__CLOSE_REQUESTS = eINSTANCE.getRequest_CloseRequests();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl <em>Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestSpecificationImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getRequestSpecification()
		 * @generated
		 */
		EClass REQUEST_SPECIFICATION = eINSTANCE.getRequestSpecification();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_SPECIFICATION__MIXED = eINSTANCE.getRequestSpecification_Mixed();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUEST_SPECIFICATION__FIELD = eINSTANCE.getRequestSpecification_Field();

		/**
		 * The meta object literal for the '<em><b>Bits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_SPECIFICATION__BITS = eINSTANCE.getRequestSpecification_Bits();

		/**
		 * The meta object literal for the '<em><b>Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_SPECIFICATION__ENCODING = eINSTANCE.getRequestSpecification_Encoding();

		/**
		 * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_SPECIFICATION__MAX_LENGTH = eINSTANCE.getRequestSpecification_MaxLength();

		/**
		 * The meta object literal for the '<em><b>Max Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_SPECIFICATION__MAX_VALUE = eINSTANCE.getRequestSpecification_MaxValue();

		/**
		 * The meta object literal for the '<em><b>Min Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_SPECIFICATION__MIN_LENGTH = eINSTANCE.getRequestSpecification_MinLength();

		/**
		 * The meta object literal for the '<em><b>Min Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_SPECIFICATION__MIN_VALUE = eINSTANCE.getRequestSpecification_MinValue();

		/**
		 * The meta object literal for the '<em><b>Null Terminated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_SPECIFICATION__NULL_TERMINATED = eINSTANCE.getRequestSpecification_NullTerminated();

		/**
		 * The meta object literal for the '<em><b>Ordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_SPECIFICATION__ORDERED = eINSTANCE.getRequestSpecification_Ordered();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_SPECIFICATION__REF = eINSTANCE.getRequestSpecification_Ref();

		/**
		 * The meta object literal for the '<em><b>Signed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_SPECIFICATION__SIGNED = eINSTANCE.getRequestSpecification_Signed();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_SPECIFICATION__TYPE = eINSTANCE.getRequestSpecification_Type();

		/**
		 * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_SPECIFICATION__UNIQUE = eINSTANCE.getRequestSpecification_Unique();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringRequestImpl <em>String Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringRequestImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getStringRequest()
		 * @generated
		 */
		EClass STRING_REQUEST = eINSTANCE.getStringRequest();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_REQUEST__SPECIFICATION = eINSTANCE.getStringRequest_Specification();

		/**
		 * The meta object literal for the '<em><b>No Generators</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_REQUEST__NO_GENERATORS = eINSTANCE.getStringRequest_NoGenerators();

		/**
		 * The meta object literal for the '<em><b>Generators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_REQUEST__GENERATORS = eINSTANCE.getStringRequest_Generators();

		/**
		 * The meta object literal for the '<em><b>Valid Values</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_REQUEST__VALID_VALUES = eINSTANCE.getStringRequest_ValidValues();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_REQUEST__ID = eINSTANCE.getStringRequest_Id();

		/**
		 * The meta object literal for the '<em><b>Max Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_REQUEST__MAX_VALUES = eINSTANCE.getStringRequest_MaxValues();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_REQUEST__NAME = eINSTANCE.getStringRequest_Name();

		/**
		 * The meta object literal for the '<em><b>Seed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_REQUEST__SEED = eINSTANCE.getStringRequest_Seed();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StructureRequestImpl <em>Structure Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StructureRequestImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getStructureRequest()
		 * @generated
		 */
		EClass STRUCTURE_REQUEST = eINSTANCE.getStructureRequest();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_REQUEST__SPECIFICATION = eINSTANCE.getStructureRequest_Specification();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_REQUEST__OPERATORS = eINSTANCE.getStructureRequest_Operators();

		/**
		 * The meta object literal for the '<em><b>Fuzz Structure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_REQUEST__FUZZ_STRUCTURE = eINSTANCE.getStructureRequest_FuzzStructure();

		/**
		 * The meta object literal for the '<em><b>Fuzz Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_REQUEST__FUZZ_VALUES = eINSTANCE.getStructureRequest_FuzzValues();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_REQUEST__ID = eINSTANCE.getStructureRequest_Id();

		/**
		 * The meta object literal for the '<em><b>Max Mutations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_REQUEST__MAX_MUTATIONS = eINSTANCE.getStructureRequest_MaxMutations();

		/**
		 * The meta object literal for the '<em><b>Max Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_REQUEST__MAX_VALUES = eINSTANCE.getStructureRequest_MaxValues();

		/**
		 * The meta object literal for the '<em><b>Min Mutations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_REQUEST__MIN_MUTATIONS = eINSTANCE.getStructureRequest_MinMutations();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_REQUEST__NAME = eINSTANCE.getStructureRequest_Name();

		/**
		 * The meta object literal for the '<em><b>Seed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURE_REQUEST__SEED = eINSTANCE.getStructureRequest_Seed();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidCollectionImpl <em>Valid Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidCollectionImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getValidCollection()
		 * @generated
		 */
		EClass VALID_COLLECTION = eINSTANCE.getValidCollection();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALID_COLLECTION__VALUE = eINSTANCE.getValidCollection_Value();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALID_COLLECTION__NAME = eINSTANCE.getValidCollection_Name();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidCollectionsImpl <em>Valid Collections</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidCollectionsImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getValidCollections()
		 * @generated
		 */
		EClass VALID_COLLECTIONS = eINSTANCE.getValidCollections();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALID_COLLECTIONS__VALUES = eINSTANCE.getValidCollections_Values();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALID_COLLECTIONS__OPERATORS = eINSTANCE.getValidCollections_Operators();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidValuesImpl <em>Valid Values</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidValuesImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getValidValues()
		 * @generated
		 */
		EClass VALID_VALUES = eINSTANCE.getValidValues();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALID_VALUES__VALUES = eINSTANCE.getValidValues_Values();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALID_VALUES__OPERATORS = eINSTANCE.getValidValues_Operators();

		/**
		 * The meta object literal for the '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.XmlRequestDocumentImpl <em>Xml Request Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.XmlRequestDocumentImpl
		 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestPackageImpl#getXmlRequestDocument()
		 * @generated
		 */
		EClass XML_REQUEST_DOCUMENT = eINSTANCE.getXmlRequestDocument();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XML_REQUEST_DOCUMENT__MIXED = eINSTANCE.getXmlRequestDocument_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XML_REQUEST_DOCUMENT__XMLNS_PREFIX_MAP = eINSTANCE.getXmlRequestDocument_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XML_REQUEST_DOCUMENT__XSI_SCHEMA_LOCATION = eINSTANCE.getXmlRequestDocument_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Request</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XML_REQUEST_DOCUMENT__REQUEST = eINSTANCE.getXmlRequestDocument_Request();

	}

} //RequestPackage
