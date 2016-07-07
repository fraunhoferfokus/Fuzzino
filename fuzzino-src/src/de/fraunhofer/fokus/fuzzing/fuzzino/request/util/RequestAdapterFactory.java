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
package de.fraunhofer.fokus.fuzzing.fuzzino.request.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.Attribute;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NoGenerators;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Request;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage
 * @generated
 */
public class RequestAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RequestPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequestAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RequestPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequestSwitch<Adapter> modelSwitch =
		new RequestSwitch<Adapter>() {
			@Override
			public Adapter caseAttribute(Attribute object) {
				return createAttributeAdapter();
			}
			@Override
			public Adapter caseCloseRequest(CloseRequest object) {
				return createCloseRequestAdapter();
			}
			@Override
			public Adapter caseCollectionRequest(CollectionRequest object) {
				return createCollectionRequestAdapter();
			}
			@Override
			public Adapter caseField(Field object) {
				return createFieldAdapter();
			}
			@Override
			public Adapter caseGenerator(Generator object) {
				return createGeneratorAdapter();
			}
			@Override
			public Adapter caseNoGenerators(NoGenerators object) {
				return createNoGeneratorsAdapter();
			}
			@Override
			public Adapter caseNumberRequest(NumberRequest object) {
				return createNumberRequestAdapter();
			}
			@Override
			public Adapter caseOperator(Operator object) {
				return createOperatorAdapter();
			}
			@Override
			public Adapter caseRequest(Request object) {
				return createRequestAdapter();
			}
			@Override
			public Adapter caseRequestSpecification(RequestSpecification object) {
				return createRequestSpecificationAdapter();
			}
			@Override
			public Adapter caseStringRequest(StringRequest object) {
				return createStringRequestAdapter();
			}
			@Override
			public Adapter caseStructureRequest(StructureRequest object) {
				return createStructureRequestAdapter();
			}
			@Override
			public Adapter caseValidCollection(ValidCollection object) {
				return createValidCollectionAdapter();
			}
			@Override
			public Adapter caseValidCollections(ValidCollections object) {
				return createValidCollectionsAdapter();
			}
			@Override
			public Adapter caseValidValues(ValidValues object) {
				return createValidValuesAdapter();
			}
			@Override
			public Adapter caseXmlRequestDocument(XmlRequestDocument object) {
				return createXmlRequestDocumentAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest <em>Close Request</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest
	 * @generated
	 */
	public Adapter createCloseRequestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest <em>Collection Request</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest
	 * @generated
	 */
	public Adapter createCollectionRequestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Field
	 * @generated
	 */
	public Adapter createFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator <em>Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator
	 * @generated
	 */
	public Adapter createGeneratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NoGenerators <em>No Generators</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.NoGenerators
	 * @generated
	 */
	public Adapter createNoGeneratorsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest <em>Number Request</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest
	 * @generated
	 */
	public Adapter createNumberRequestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator
	 * @generated
	 */
	public Adapter createOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Request <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.Request
	 * @generated
	 */
	public Adapter createRequestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification
	 * @generated
	 */
	public Adapter createRequestSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest <em>String Request</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest
	 * @generated
	 */
	public Adapter createStringRequestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest <em>Structure Request</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest
	 * @generated
	 */
	public Adapter createStructureRequestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection <em>Valid Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection
	 * @generated
	 */
	public Adapter createValidCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollections <em>Valid Collections</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollections
	 * @generated
	 */
	public Adapter createValidCollectionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValues <em>Valid Values</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValues
	 * @generated
	 */
	public Adapter createValidValuesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument <em>Xml Request Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument
	 * @generated
	 */
	public Adapter createXmlRequestDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //RequestAdapterFactory
