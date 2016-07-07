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
package de.fraunhofer.fokus.fuzzing.fuzzino.response.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

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
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Value;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage
 * @generated
 */
public class ResponseAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ResponsePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponseAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ResponsePackage.eINSTANCE;
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
	protected ResponseSwitch<Adapter> modelSwitch =
		new ResponseSwitch<Adapter>() {
			@Override
			public Adapter caseAllGeneratorsBasedPart(AllGeneratorsBasedPart object) {
				return createAllGeneratorsBasedPartAdapter();
			}
			@Override
			public Adapter caseAllOperatorsBasedPart(AllOperatorsBasedPart object) {
				return createAllOperatorsBasedPartAdapter();
			}
			@Override
			public Adapter caseCloseRequestConfirmation(CloseRequestConfirmation object) {
				return createCloseRequestConfirmationAdapter();
			}
			@Override
			public Adapter caseCollectionResponse(CollectionResponse object) {
				return createCollectionResponseAdapter();
			}
			@Override
			public Adapter caseErrorResponse(ErrorResponse object) {
				return createErrorResponseAdapter();
			}
			@Override
			public Adapter caseField(Field object) {
				return createFieldAdapter();
			}
			@Override
			public Adapter caseFuzzedCollection(FuzzedCollection object) {
				return createFuzzedCollectionAdapter();
			}
			@Override
			public Adapter caseFuzzedStructure(FuzzedStructure object) {
				return createFuzzedStructureAdapter();
			}
			@Override
			public Adapter caseGeneratorPart(GeneratorPart object) {
				return createGeneratorPartAdapter();
			}
			@Override
			public Adapter caseIllegalGenerator(IllegalGenerator object) {
				return createIllegalGeneratorAdapter();
			}
			@Override
			public Adapter caseIllegalOperator(IllegalOperator object) {
				return createIllegalOperatorAdapter();
			}
			@Override
			public Adapter caseIllegalRequestFormat(IllegalRequestFormat object) {
				return createIllegalRequestFormatAdapter();
			}
			@Override
			public Adapter caseNoMoreValuesIndicator(NoMoreValuesIndicator object) {
				return createNoMoreValuesIndicatorAdapter();
			}
			@Override
			public Adapter caseNumberResponse(NumberResponse object) {
				return createNumberResponseAdapter();
			}
			@Override
			public Adapter caseOperatorPart(OperatorPart object) {
				return createOperatorPartAdapter();
			}
			@Override
			public Adapter caseResponse(Response object) {
				return createResponseAdapter();
			}
			@Override
			public Adapter caseStringResponse(StringResponse object) {
				return createStringResponseAdapter();
			}
			@Override
			public Adapter caseStructureResponse(StructureResponse object) {
				return createStructureResponseAdapter();
			}
			@Override
			public Adapter caseValue(Value object) {
				return createValueAdapter();
			}
			@Override
			public Adapter caseWarningsPart(WarningsPart object) {
				return createWarningsPartAdapter();
			}
			@Override
			public Adapter caseXmlResponseDocument(XmlResponseDocument object) {
				return createXmlResponseDocumentAdapter();
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
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.AllGeneratorsBasedPart <em>All Generators Based Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.AllGeneratorsBasedPart
	 * @generated
	 */
	public Adapter createAllGeneratorsBasedPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.AllOperatorsBasedPart <em>All Operators Based Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.AllOperatorsBasedPart
	 * @generated
	 */
	public Adapter createAllOperatorsBasedPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation <em>Close Request Confirmation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation
	 * @generated
	 */
	public Adapter createCloseRequestConfirmationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse <em>Collection Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse
	 * @generated
	 */
	public Adapter createCollectionResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse <em>Error Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse
	 * @generated
	 */
	public Adapter createErrorResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Field
	 * @generated
	 */
	public Adapter createFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection <em>Fuzzed Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection
	 * @generated
	 */
	public Adapter createFuzzedCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedStructure <em>Fuzzed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedStructure
	 * @generated
	 */
	public Adapter createFuzzedStructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorPart <em>Generator Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorPart
	 * @generated
	 */
	public Adapter createGeneratorPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator <em>Illegal Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator
	 * @generated
	 */
	public Adapter createIllegalGeneratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator <em>Illegal Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator
	 * @generated
	 */
	public Adapter createIllegalOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat <em>Illegal Request Format</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat
	 * @generated
	 */
	public Adapter createIllegalRequestFormatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.NoMoreValuesIndicator <em>No More Values Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.NoMoreValuesIndicator
	 * @generated
	 */
	public Adapter createNoMoreValuesIndicatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse <em>Number Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse
	 * @generated
	 */
	public Adapter createNumberResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart <em>Operator Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart
	 * @generated
	 */
	public Adapter createOperatorPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Response <em>Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Response
	 * @generated
	 */
	public Adapter createResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse <em>String Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse
	 * @generated
	 */
	public Adapter createStringResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse <em>Structure Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse
	 * @generated
	 */
	public Adapter createStructureResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.Value
	 * @generated
	 */
	public Adapter createValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart <em>Warnings Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart
	 * @generated
	 */
	public Adapter createWarningsPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument <em>Xml Response Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument
	 * @generated
	 */
	public Adapter createXmlResponseDocumentAdapter() {
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

} //ResponseAdapterFactory
