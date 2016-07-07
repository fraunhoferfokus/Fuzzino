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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.Attribute;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NoGenerators;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Request;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollections;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RequestFactoryImpl extends EFactoryImpl implements RequestFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RequestFactory init() {
		try {
			RequestFactory theRequestFactory = (RequestFactory)EPackage.Registry.INSTANCE.getEFactory("http://fuzzino.fuzzing.fokus.fraunhofer.de/request"); 
			if (theRequestFactory != null) {
				return theRequestFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RequestFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequestFactoryImpl() {
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
			case RequestPackage.ATTRIBUTE: return createAttribute();
			case RequestPackage.CLOSE_REQUEST: return createCloseRequest();
			case RequestPackage.COLLECTION_REQUEST: return createCollectionRequest();
			case RequestPackage.FIELD: return createField();
			case RequestPackage.GENERATOR: return createGenerator();
			case RequestPackage.NO_GENERATORS: return createNoGenerators();
			case RequestPackage.NUMBER_REQUEST: return createNumberRequest();
			case RequestPackage.OPERATOR: return createOperator();
			case RequestPackage.REQUEST: return createRequest();
			case RequestPackage.REQUEST_SPECIFICATION: return createRequestSpecification();
			case RequestPackage.STRING_REQUEST: return createStringRequest();
			case RequestPackage.STRUCTURE_REQUEST: return createStructureRequest();
			case RequestPackage.VALID_COLLECTION: return createValidCollection();
			case RequestPackage.VALID_COLLECTIONS: return createValidCollections();
			case RequestPackage.VALID_VALUES: return createValidValues();
			case RequestPackage.XML_REQUEST_DOCUMENT: return createXmlRequestDocument();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloseRequest createCloseRequest() {
		CloseRequestImpl closeRequest = new CloseRequestImpl();
		return closeRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionRequest createCollectionRequest() {
		CollectionRequestImpl collectionRequest = new CollectionRequestImpl();
		return collectionRequest;
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
	public Generator createGenerator() {
		GeneratorImpl generator = new GeneratorImpl();
		return generator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoGenerators createNoGenerators() {
		NoGeneratorsImpl noGenerators = new NoGeneratorsImpl();
		return noGenerators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberRequest createNumberRequest() {
		NumberRequestImpl numberRequest = new NumberRequestImpl();
		return numberRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator createOperator() {
		OperatorImpl operator = new OperatorImpl();
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Request createRequest() {
		RequestImpl request = new RequestImpl();
		return request;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequestSpecification createRequestSpecification() {
		RequestSpecificationImpl requestSpecification = new RequestSpecificationImpl();
		return requestSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringRequest createStringRequest() {
		StringRequestImpl stringRequest = new StringRequestImpl();
		return stringRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureRequest createStructureRequest() {
		StructureRequestImpl structureRequest = new StructureRequestImpl();
		return structureRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidCollection createValidCollection() {
		ValidCollectionImpl validCollection = new ValidCollectionImpl();
		return validCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidCollections createValidCollections() {
		ValidCollectionsImpl validCollections = new ValidCollectionsImpl();
		return validCollections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidValues createValidValues() {
		ValidValuesImpl validValues = new ValidValuesImpl();
		return validValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XmlRequestDocument createXmlRequestDocument() {
		XmlRequestDocumentImpl xmlRequestDocument = new XmlRequestDocumentImpl();
		return xmlRequestDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequestPackage getRequestPackage() {
		return (RequestPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RequestPackage getPackage() {
		return RequestPackage.eINSTANCE;
	}

} //RequestFactoryImpl
