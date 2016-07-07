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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.AllGeneratorsBasedPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.AllOperatorsBasedPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedStructure;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NoMoreValuesIndicator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Response;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Value;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResponseFactoryImpl extends EFactoryImpl implements ResponseFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResponseFactory init() {
		try {
			ResponseFactory theResponseFactory = (ResponseFactory)EPackage.Registry.INSTANCE.getEFactory("http://fuzzino.fuzzing.fokus.fraunhofer.de/response"); 
			if (theResponseFactory != null) {
				return theResponseFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ResponseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponseFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ResponsePackage.ALL_GENERATORS_BASED_PART: return createAllGeneratorsBasedPart();
			case ResponsePackage.ALL_OPERATORS_BASED_PART: return createAllOperatorsBasedPart();
			case ResponsePackage.CLOSE_REQUEST_CONFIRMATION: return createCloseRequestConfirmation();
			case ResponsePackage.COLLECTION_RESPONSE: return createCollectionResponse();
			case ResponsePackage.ERROR_RESPONSE: return createErrorResponse();
			case ResponsePackage.FIELD: return createField();
			case ResponsePackage.FUZZED_COLLECTION: return createFuzzedCollection();
			case ResponsePackage.FUZZED_STRUCTURE: return createFuzzedStructure();
			case ResponsePackage.GENERATOR_PART: return createGeneratorPart();
			case ResponsePackage.ILLEGAL_GENERATOR: return createIllegalGenerator();
			case ResponsePackage.ILLEGAL_OPERATOR: return createIllegalOperator();
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT: return createIllegalRequestFormat();
			case ResponsePackage.NO_MORE_VALUES_INDICATOR: return createNoMoreValuesIndicator();
			case ResponsePackage.NUMBER_RESPONSE: return createNumberResponse();
			case ResponsePackage.OPERATOR_PART: return createOperatorPart();
			case ResponsePackage.RESPONSE: return createResponse();
			case ResponsePackage.STRING_RESPONSE: return createStringResponse();
			case ResponsePackage.STRUCTURE_RESPONSE: return createStructureResponse();
			case ResponsePackage.VALUE: return createValue();
			case ResponsePackage.WARNINGS_PART: return createWarningsPart();
			case ResponsePackage.XML_RESPONSE_DOCUMENT: return createXmlResponseDocument();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllGeneratorsBasedPart createAllGeneratorsBasedPart() {
		AllGeneratorsBasedPartImpl allGeneratorsBasedPart = new AllGeneratorsBasedPartImpl();
		return allGeneratorsBasedPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllOperatorsBasedPart createAllOperatorsBasedPart() {
		AllOperatorsBasedPartImpl allOperatorsBasedPart = new AllOperatorsBasedPartImpl();
		return allOperatorsBasedPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloseRequestConfirmation createCloseRequestConfirmation() {
		CloseRequestConfirmationImpl closeRequestConfirmation = new CloseRequestConfirmationImpl();
		return closeRequestConfirmation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionResponse createCollectionResponse() {
		CollectionResponseImpl collectionResponse = new CollectionResponseImpl();
		return collectionResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorResponse createErrorResponse() {
		ErrorResponseImpl errorResponse = new ErrorResponseImpl();
		return errorResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Field createField() {
		FieldImpl field = new FieldImpl();
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuzzedCollection createFuzzedCollection() {
		FuzzedCollectionImpl fuzzedCollection = new FuzzedCollectionImpl();
		return fuzzedCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuzzedStructure createFuzzedStructure() {
		FuzzedStructureImpl fuzzedStructure = new FuzzedStructureImpl();
		return fuzzedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorPart createGeneratorPart() {
		GeneratorPartImpl generatorPart = new GeneratorPartImpl();
		return generatorPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IllegalGenerator createIllegalGenerator() {
		IllegalGeneratorImpl illegalGenerator = new IllegalGeneratorImpl();
		return illegalGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IllegalOperator createIllegalOperator() {
		IllegalOperatorImpl illegalOperator = new IllegalOperatorImpl();
		return illegalOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IllegalRequestFormat createIllegalRequestFormat() {
		IllegalRequestFormatImpl illegalRequestFormat = new IllegalRequestFormatImpl();
		return illegalRequestFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoMoreValuesIndicator createNoMoreValuesIndicator() {
		NoMoreValuesIndicatorImpl noMoreValuesIndicator = new NoMoreValuesIndicatorImpl();
		return noMoreValuesIndicator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberResponse createNumberResponse() {
		NumberResponseImpl numberResponse = new NumberResponseImpl();
		return numberResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorPart createOperatorPart() {
		OperatorPartImpl operatorPart = new OperatorPartImpl();
		return operatorPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Response createResponse() {
		ResponseImpl response = new ResponseImpl();
		return response;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringResponse createStringResponse() {
		StringResponseImpl stringResponse = new StringResponseImpl();
		return stringResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureResponse createStructureResponse() {
		StructureResponseImpl structureResponse = new StructureResponseImpl();
		return structureResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value createValue() {
		ValueImpl value = new ValueImpl();
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WarningsPart createWarningsPart() {
		WarningsPartImpl warningsPart = new WarningsPartImpl();
		return warningsPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XmlResponseDocument createXmlResponseDocument() {
		XmlResponseDocumentImpl xmlResponseDocument = new XmlResponseDocumentImpl();
		return xmlResponseDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponsePackage getResponsePackage() {
		return (ResponsePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ResponsePackage getPackage() {
		return ResponsePackage.eINSTANCE;
	}

} //ResponseFactoryImpl
