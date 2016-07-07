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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage
 * @generated
 */
public class ResponseSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ResponsePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponseSwitch() {
		if (modelPackage == null) {
			modelPackage = ResponsePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ResponsePackage.ALL_GENERATORS_BASED_PART: {
				AllGeneratorsBasedPart allGeneratorsBasedPart = (AllGeneratorsBasedPart)theEObject;
				T result = caseAllGeneratorsBasedPart(allGeneratorsBasedPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.ALL_OPERATORS_BASED_PART: {
				AllOperatorsBasedPart allOperatorsBasedPart = (AllOperatorsBasedPart)theEObject;
				T result = caseAllOperatorsBasedPart(allOperatorsBasedPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.CLOSE_REQUEST_CONFIRMATION: {
				CloseRequestConfirmation closeRequestConfirmation = (CloseRequestConfirmation)theEObject;
				T result = caseCloseRequestConfirmation(closeRequestConfirmation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.COLLECTION_RESPONSE: {
				CollectionResponse collectionResponse = (CollectionResponse)theEObject;
				T result = caseCollectionResponse(collectionResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.ERROR_RESPONSE: {
				ErrorResponse errorResponse = (ErrorResponse)theEObject;
				T result = caseErrorResponse(errorResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.FIELD: {
				Field field = (Field)theEObject;
				T result = caseField(field);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.FUZZED_COLLECTION: {
				FuzzedCollection fuzzedCollection = (FuzzedCollection)theEObject;
				T result = caseFuzzedCollection(fuzzedCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.FUZZED_STRUCTURE: {
				FuzzedStructure fuzzedStructure = (FuzzedStructure)theEObject;
				T result = caseFuzzedStructure(fuzzedStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.GENERATOR_PART: {
				GeneratorPart generatorPart = (GeneratorPart)theEObject;
				T result = caseGeneratorPart(generatorPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.ILLEGAL_GENERATOR: {
				IllegalGenerator illegalGenerator = (IllegalGenerator)theEObject;
				T result = caseIllegalGenerator(illegalGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.ILLEGAL_OPERATOR: {
				IllegalOperator illegalOperator = (IllegalOperator)theEObject;
				T result = caseIllegalOperator(illegalOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.ILLEGAL_REQUEST_FORMAT: {
				IllegalRequestFormat illegalRequestFormat = (IllegalRequestFormat)theEObject;
				T result = caseIllegalRequestFormat(illegalRequestFormat);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.NO_MORE_VALUES_INDICATOR: {
				NoMoreValuesIndicator noMoreValuesIndicator = (NoMoreValuesIndicator)theEObject;
				T result = caseNoMoreValuesIndicator(noMoreValuesIndicator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.NUMBER_RESPONSE: {
				NumberResponse numberResponse = (NumberResponse)theEObject;
				T result = caseNumberResponse(numberResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.OPERATOR_PART: {
				OperatorPart operatorPart = (OperatorPart)theEObject;
				T result = caseOperatorPart(operatorPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.RESPONSE: {
				Response response = (Response)theEObject;
				T result = caseResponse(response);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.STRING_RESPONSE: {
				StringResponse stringResponse = (StringResponse)theEObject;
				T result = caseStringResponse(stringResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.STRUCTURE_RESPONSE: {
				StructureResponse structureResponse = (StructureResponse)theEObject;
				T result = caseStructureResponse(structureResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.VALUE: {
				Value value = (Value)theEObject;
				T result = caseValue(value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.WARNINGS_PART: {
				WarningsPart warningsPart = (WarningsPart)theEObject;
				T result = caseWarningsPart(warningsPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ResponsePackage.XML_RESPONSE_DOCUMENT: {
				XmlResponseDocument xmlResponseDocument = (XmlResponseDocument)theEObject;
				T result = caseXmlResponseDocument(xmlResponseDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>All Generators Based Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>All Generators Based Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllGeneratorsBasedPart(AllGeneratorsBasedPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>All Operators Based Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>All Operators Based Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllOperatorsBasedPart(AllOperatorsBasedPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Close Request Confirmation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Close Request Confirmation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloseRequestConfirmation(CloseRequestConfirmation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionResponse(CollectionResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorResponse(ErrorResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseField(Field object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fuzzed Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fuzzed Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFuzzedCollection(FuzzedCollection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fuzzed Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fuzzed Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFuzzedStructure(FuzzedStructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generator Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generator Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneratorPart(GeneratorPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Illegal Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Illegal Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIllegalGenerator(IllegalGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Illegal Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Illegal Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIllegalOperator(IllegalOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Illegal Request Format</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Illegal Request Format</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIllegalRequestFormat(IllegalRequestFormat object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>No More Values Indicator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>No More Values Indicator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNoMoreValuesIndicator(NoMoreValuesIndicator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Number Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Number Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumberResponse(NumberResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatorPart(OperatorPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResponse(Response object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringResponse(StringResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structure Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structure Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructureResponse(StructureResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValue(Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Warnings Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Warnings Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWarningsPart(WarningsPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xml Response Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xml Response Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXmlResponseDocument(XmlResponseDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ResponseSwitch
