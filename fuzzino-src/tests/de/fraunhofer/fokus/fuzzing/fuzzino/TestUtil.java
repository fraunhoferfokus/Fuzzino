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
package de.fraunhofer.fokus.fuzzing.fuzzino;

import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.xml.sax.SAXParseException;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Request;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.util.RequestResourceFactoryImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.AllGeneratorsBasedPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.AllOperatorsBasedPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NoMoreValuesIndicator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.util.ResponseResourceFactoryImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.Helpers;

public class TestUtil {
	
	protected static String prefix = "";
	
	public static void setPrefix(String prefix) {
		TestUtil.prefix = prefix;
	}
	
	protected static void assertTrueWithPrefix(String message, boolean condition) {
		org.junit.Assert.assertTrue(prefix + message, condition);
	}

	/**
	 * Starts the fuzzing library with the given filename and returns its XML response
	 * already parsed to {@link XmlResponseDocument}.
	 * 
	 * @param requestFilename The filename of the XML request.
	 * @return The parsed XML response from the library.
	 */
	public static XmlResponseDocument getResponseDocForRequest(String requestFilename) {
		return getResponseDocForRequest(requestFilename, false);
	}
	
	public static XmlResponseDocument getResponseDocForRequest(String requestFilename, boolean encode) {
		RequestDispatcher dispatcher = new RequestDispatcher(requestFilename, encode);
		dispatcher.dispatch();
		return loadResponseFileForRequest(requestFilename);
	}
	
	/**
	 * Starts the fuzzing library with the given filename and returns its XML response
	 * already parsed to {@link XmlResponseDocument}.
	 * 
	 * @param xmlString A string containig a request in XML format.
	 * @return The parsed XML response from the library.
	 */
	public static XmlResponseDocument getResponseDocForRequestString(String xmlString) {
		RequestDispatcher dispatcher = new RequestDispatcher(xmlString);
		dispatcher.dispatch();
		return loadResponseString(dispatcher.getXmlResponseString());
	}
	
	/**
	 * Loads an {@link XmlRequestDocument} from a file.
	 * 
	 * @param fileName The filename of the file containing the request.
	 * @return The parsed XML file as {@link XmlRequestDocument}.
	 */
	public static XmlRequestDocument loadRequestFile(String fileName) {
		XmlRequestDocument requestDoc = null;

		RequestPackage.eINSTANCE.eClass();

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new RequestResourceFactoryImpl());

		ResourceSet resSet = new ResourceSetImpl();

		Resource resource = null;
		try {
			resource = resSet.getResource(URI.createURI(fileName), true);
			requestDoc = (XmlRequestDocument) resource.getContents().get(0);
		} catch (WrappedException e) {
			SAXParseException cause = (SAXParseException) e.getCause();
			System.out.println("line " + cause.getLineNumber() + ", column " + cause.getColumnNumber() + " : " + cause.getMessage());
		}
		return requestDoc;
	}
	
	/**
	 * Loads an {@link XmlRequestDocument} from an XML string.
	 * 
	 * @param 
	 * @param xmlString The string containing a request in XML format.
	 * @return The parsed XML file as {@link XmlRequestDocument}.
	 */
	public static XmlRequestDocument loadRequestString(String xmlString) {
		XmlRequestDocument requestDoc = null;
		RequestPackage.eINSTANCE.eClass();

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new RequestResourceFactoryImpl());

		ResourceSet resSet = new ResourceSetImpl();
		
		try {
			EObject model = Helpers.load(new ByteArrayInputStream(xmlString.getBytes()), "", resSet);	
			requestDoc = (XmlRequestDocument) model;
		} catch (WrappedException e) {
			SAXParseException cause = (SAXParseException) e.getCause();
			System.out.println("line " + cause.getLineNumber() + ", column " + cause.getColumnNumber() + " : " + cause.getMessage());
		}
		return requestDoc;
	}
	
	/**
	 * Checks if a response file exists for a given request filename.
	 * Fails if the response file does not exist.
	 * 
	 * @param requestFilename the request filename whose response is in question.
	 */
	public static void checkIfResponseFileExists(String requestFilename) {
		String responseFilename = getResponseFilenameForRequest(requestFilename);
		File responseFile = new File(responseFilename);
		assertTrueWithPrefix("Reponse file \"" + responseFilename + "\"was not created",
				   responseFile.exists());
	}
	
	/**
	 * Checks if a certain error message (XML tag 'response:error') exists within a response.
	 * Fails if there is no error response or if it contains another message.
	 * 
	 * @param responseDoc the response that should contain the error response.
	 * @param expectedErrorMessage the message that should be enclosed in the error response.
	 */
	public static void checkResponseDocForErrorMessage(XmlResponseDocument responseDoc, String expectedErrorMessage) {
		checkResponseDocForErrorResponse(responseDoc, true);
		ErrorResponse errorResponse = responseDoc.getResponse().getErrorResponse();
		
		String actualErrorMessage = errorResponse.getValue();
		assertTrueWithPrefix("ErrorResponse is " + actualErrorMessage + " instead of containing " + expectedErrorMessage,
		           actualErrorMessage.contains(expectedErrorMessage));
	}
	
	/**
	 * Checks a response for an error response (XML tag 'response:error').
	 * 
	 * @param responseDoc the response possibly containing an error response.
	 * @param expectedErrorResponseExists set to {@code true} if an error response is expected, {@code false} otherwise.
	 */
	public static void checkResponseDocForErrorResponse(XmlResponseDocument responseDoc, boolean expectedErrorResponseExists) {
		boolean actualErrorResponseExists = responseDoc.getResponse().getErrorResponse() != null;
		
		String message = expectedErrorResponseExists ? "No error response but was expected." : 
			                                     "Error response exists but no error response was expected.";
		
		assertTrueWithPrefix(message,
				   actualErrorResponseExists == expectedErrorResponseExists);
	}
//	
	/**
	 * Returns a string response (XML tag 'response:string') from a response (XML tag 'response:response') identified
	 * by its index.
	 * Fails if there is no string response with the given index. 
	 * 
	 * @param responseDoc the response containing the string response.
	 * @param index the index that identifies the requested string response.
	 * @return the requested string response.
	 */
	public static StringResponse getStringResponseFromResponseDoc(XmlResponseDocument responseDoc, int index) {
		checkResponseDocForMinNumStringResponses(responseDoc, index+1);
		return responseDoc.getResponse().getStringResponses().get(index);
	}
	
	/**
	 * Checks if there is at least a certain number of string responses (XML tag 'response:string') 
	 * within a response (XML tag 'response:response').
	 * Fails if not.
	 * 
	 * @param responseDoc the response containing the string responses.
	 * @param expectedNumStringResponses the number of string responses to check for.
	 */
	public static void checkResponseDocForMinNumStringResponses(XmlResponseDocument responseDoc, int expectedNumStringResponses) {
		List<StringResponse> stringResponses = responseDoc.getResponse().getStringResponses();
		int actualNumResponses = stringResponses.size();
		assertTrueWithPrefix("Wrong number of string responses: was " + actualNumResponses + " instead of " + expectedNumStringResponses,
				   actualNumResponses >= expectedNumStringResponses);
	}
	
	/**
	 * Checks if there is a certain number of string responses (XML tag 'response:string') within a response 
	 * (XML tag 'response:response').
	 * Fails if not.
	 * 
	 * @param responseDoc the response containing the string responses.
	 * @param expectedNumStringResponses the number of string responses to check for.
	 */
	public static void checkResponseDocForNumStringResponses(XmlResponseDocument responseDoc, int expectedNumStringResponses) {
		List<StringResponse> stringResponses = responseDoc.getResponse().getStringResponses();
		int actualNumResponses = stringResponses.size();
		assertTrueWithPrefix("Wrong number of string responses: was " + actualNumResponses + " instead of " + expectedNumStringResponses,
				   actualNumResponses == expectedNumStringResponses);
	}
	
	/**
	 * Returns a numbere response (XML tag 'response:number') from a response (XML tag 'response:response') identified
	 * by its index.
	 * Fails if there is no number response with the given index. 
	 * 
	 * @param responseDoc the response containing the number response.
	 * @param index the index that identifies the requested number response.
	 * @return the requested number response.
	 */
	public static NumberResponse getNumberResponseFromResponseDoc(XmlResponseDocument responseDoc, int index) {
		checkResponseDocForMinNumNumberResponses(responseDoc, index+1);
		return responseDoc.getResponse().getNumberResponses().get(index);
	}
	
	/**
	 * Returns a numbere response (XML tag 'response:number') from a response (XML tag 'response:response') identified
	 * by its index.
	 * Fails if there is no number response with the given index. 
	 * 
	 * @param responseDoc the response containing the number response.
	 * @param index the index that identifies the requested number response.
	 * @return the requested number response.
	 */
	public static NumberResponse getNumberResponseFromResponseDocByName(XmlResponseDocument responseDoc, String name) {
		List<NumberResponse> numberResponses = responseDoc.getResponse().getNumberResponses();
		for (NumberResponse numberResponse : numberResponses) {
			if (numberResponse.getName().equals(name)) {
				return numberResponse;
			}
		}
		
		fail("Number response with the name " + name + " does not exists.");
		
		return null;
	}
	
	/**
	 * Checks if there is at least a certain number of number responses (XML tag 'response:number') 
	 * within a response (XML tag 'response:response').
	 * Fails if the number is smaller.
	 * 
	 * @param responseDoc the response containing the number responses.
	 * @param expectedNumNumberResponses the number of number responses to check for.
	 */
	public static void checkResponseDocForMinNumNumberResponses(XmlResponseDocument responseDoc, int expectedNumNumberResponses) {
		List<NumberResponse> numberResponses = responseDoc.getResponse().getNumberResponses();
		int actualNumResponses = numberResponses.size();
		assertTrueWithPrefix("Wrong number of number responses: was " + actualNumResponses + " instead of " + expectedNumNumberResponses,
				   actualNumResponses >= expectedNumNumberResponses);
	}
	
	/**
	 * Checks if there is a certain number of number responses (XML tag 'response:number') within a response 
	 * (XML tag 'response:response').
	 * Fails if not.
	 * 
	 * @param responseDoc the response containing the number responses.
	 * @param expectedNumNumberResponses the number of number responses to check for.
	 */
	public static void checkResponseDocForNumNumberResponses(XmlResponseDocument responseDoc, int expectedNumNumberResponses) {
		List<NumberResponse> numberResponses = responseDoc.getResponse().getNumberResponses();
		int actualNumResponses = numberResponses.size();
		assertTrueWithPrefix("Wrong number of number responses: was " + actualNumResponses + " instead of " + expectedNumNumberResponses,
				   actualNumResponses == expectedNumNumberResponses);
	}
	
	/**
	 * Checks if there is a certain number of collection responses (XML tag 'response:collection') within a response 
	 * (XML tag 'response:response').
	 * Fails if not.
	 * 
	 * @param responseDoc the response containing the collection responses.
	 * @param expectedNumCollectionResponses the number of collection responses to check for.
	 */
	public static void checkResponseDocForNumCollectionResponses(XmlResponseDocument responseDoc, int expectedNumCollectionResponses) {
		List<CollectionResponse> collectionResponses = responseDoc.getResponse().getCollectionResponses();
		int actualNumResponses = collectionResponses.size();
		assertTrueWithPrefix("Wrong number of collection responses: was " + actualNumResponses + " instead of " + expectedNumCollectionResponses,
				   actualNumResponses == expectedNumCollectionResponses);
	}
	
	/**
	 * Checks if there is a certain number of structure responses (XML tag 'structure') within a response 
	 * (XML tag 'response:response').
	 * Fails if not.
	 * 
	 * @param responseDoc the response containing the structure responses.
	 * @param expectedNumStructureResponses the number of structure responses to check for.
	 */
	public static void checkResponseDocForNumStructureResponses(XmlResponseDocument responseDoc, int expectedNumStructureResponses) {
		List<StructureResponse> structureResponses = responseDoc.getResponse().getStructureResponses();
		int actualNumResponses = structureResponses.size();
		assertTrueWithPrefix("Wrong number of structure responses: was " + actualNumResponses + " instead of " + expectedNumStructureResponses,
				   actualNumResponses == expectedNumStructureResponses);
	}
	
	/**
	 * Returns a close request confirmation (XML tag 'response:closeRequestDone') from a response 
	 * (XML tag 'response:response') identified by its index.
	 * Fails if there is no close request confirmation with the given index.
	 * 
	 * @param responseDoc the response containing the request close request confirmation.
	 * @param index the index that identifies the requested close request confirmation.
	 * @return the requested close request confirmation.
	 */
	public static CloseRequestConfirmation getCloseRequestConfirmationFromResponseDoc(XmlResponseDocument responseDoc,
			                                                                   int index) {
		checkResponseDocForMinNumCloseRequestConfirmations(responseDoc, index+1);
		return responseDoc.getResponse().getCloseRequestConfirmations().get(index);
	}
	
	/**
	 * Checks if there is a certain number of close request confirmations (XML tag 'response:closeRequestDone') 
	 * within a response (XML tag 'response:response').
	 * Fails if not.
	 * 
	 * @param responseDoc the response containing the close request confirmations.
	 * @param expectedNumCloseRequestConfirmations the number of close request confirmation to check for.
	 */
	public static void checkResponseDocForNumCloseRequestConfirmations(XmlResponseDocument responseDoc,
			                                                    int expectedNumCloseRequestConfirmations) {
		List<CloseRequestConfirmation> closeRequestConfirmations = responseDoc.getResponse().getCloseRequestConfirmations();
		
		int actualNumCloseRequestConfirmations = closeRequestConfirmations.size();
		assertTrueWithPrefix("Wrong number of close request confirmations: was " + actualNumCloseRequestConfirmations + " instead of " + expectedNumCloseRequestConfirmations,
				   actualNumCloseRequestConfirmations == expectedNumCloseRequestConfirmations);
	}
	
	/**
	 * Checks if there is a minimal number of close request confirmations (XML tag 'response:closeRequestDone') 
	 * within a response (XML tag 'response:response').
	 * Fails if not.
	 * 
	 * @param responseDoc the response containing the close request confirmations.
	 * @param expectedMinNumCloseRequestConfirmations the number of close request confirmation to check for.
	 */
	public static void checkResponseDocForMinNumCloseRequestConfirmations(XmlResponseDocument responseDoc,
			                                                    int expectedMinNumCloseRequestConfirmations) {
		List<CloseRequestConfirmation> closeRequestConfirmations = responseDoc.getResponse().getCloseRequestConfirmations();
		
		int actualNumCloseRequestConfirmations = closeRequestConfirmations.size();
		assertTrueWithPrefix("Wrong number of close request confirmations: was " + actualNumCloseRequestConfirmations + " instead of " + expectedMinNumCloseRequestConfirmations,
				   actualNumCloseRequestConfirmations >= expectedMinNumCloseRequestConfirmations);
	}
	
	/**
	 * Checks the 'id' attribute of a close request confirmation (XML tag 'response:closeRequestDone') for a certain value.
	 * Fails if the 'id' attribute has another value.
	 * 
	 * @param closeRequestConfirmation the close request conformation in question.
	 * @param expectedId the expected value of the id attribute.
	 */
	public static void checkCloseRequestConfirmationForId(CloseRequestConfirmation closeRequestConfirmation,
			                                       String expectedId) {
		String actualId = closeRequestConfirmation.getId();
		assertTrueWithPrefix("Wrong id in close request confirmation: was " + actualId + " instead of " + expectedId,
				   actualId.equals(expectedId));
	}
	
	/**
	 * Checks the 'name' attribute of a close request confirmation (XML tag 'response:closeRequestDone') for a certain value.
	 * Fails if he 'name' attribute has another value.
	 * 
	 * @param closeRequestConfirmation the close request confirmation in question.
	 * @param expectedName the expected value of the name attribute.
	 */
	public static void checkCloseRequestConfirmationForName(CloseRequestConfirmation closeRequestConfirmation,
			                                         String expectedName) {
		String actualName = closeRequestConfirmation.getName();
		assertTrueWithPrefix("No name in close request confirmation.",
				   actualName != null);
		
		assertTrueWithPrefix("Wrong id in close request conformation: was " + actualName + " instead of " + expectedName,
				   actualName.equals(expectedName));
	}
	
	/**
	 * Checks a close request confirmation (XML tag 'response:closeRequestDone') for a certain number of 
	 * illegal request formats (XML tag 'response:illegalRequestFormat').
	 * Fails if there is another number.
	 * 
	 * @param closeRequestConfirmation the close request confirmation in question.
	 * @param expectedNumIllRequFormat the expected number of illegal request formats with the close request confirmation.
	 */
	public static void checkCloseRequestConfirmationForNumIllegalRequestFormats(CloseRequestConfirmation closeRequestConfirmation,
			                                                             int expectedNumIllRequFormat) {
		WarningsPart warningsPart = closeRequestConfirmation.getWarnings();
		assertTrueWithPrefix("No warnings in close request confirmation with invalid id.",
				   warningsPart != null);
		
		List<IllegalRequestFormat> illegalRequestFormats = warningsPart.getIllegalRequestFormats();
		int actualNumIllRequFormat = illegalRequestFormats.size();
		assertTrueWithPrefix("Wrong number of illegal request formats: was " + actualNumIllRequFormat + " instead of " + expectedNumIllRequFormat,
				   actualNumIllRequFormat == expectedNumIllRequFormat);
	}
	
	/**
	 * Returns a illegal request format (XML tag 'response:illegalRequestFormat') from a close request confirmation 
	 * (XML tag 'response:closeRequestDone') identified by its index. 
	 * Fails if there is no such illegal request format.
	 * 
	 * @param closeRequestConfirmation the close request confirmation to get the illegal request format from.
	 * @param index the index that identifies the requested illegal request format.
	 * @return the requested illegal request format.
	 */
	public static IllegalRequestFormat getIllegalRequestFormatFromCloseRequestConfirmation(CloseRequestConfirmation closeRequestConfirmation,
			                                                                        int index) {
		checkCloseRequestConfirmationForNumIllegalRequestFormats(closeRequestConfirmation, index+1);
		
		return closeRequestConfirmation.getWarnings().getIllegalRequestFormats().get(index);
	}
	
	/**
	 * Returns a illegal request format (XML tag 'response:illegalRequestFormat') identified by its index.
	 * Fails if there is no illegal request format with the given index.
	 * 
	 * @param stringResponse the string response containing the illegal request formats.
	 * @param index the index identifying the requested illegal request format.
	 * @return the requested illegal request format.
	 */
	public static IllegalRequestFormat getIllegalRequestFormatFromResponse(StringResponse stringResponse, int index) {
		int counter = 0;
		for (IllegalRequestFormat illegalRequestFormat : stringResponse.getWarnings().getIllegalRequestFormats()) {
			if (counter == index) {
				return illegalRequestFormat;
			}
			counter++;
		}
		fail("IllegalRequestFormat with index " + index + " does not exists.");
		return null;
	}
	
	/**
	 * Checks a string response (XML tag 'response:string') for the number of illegal request format
	 * (XML tag 'response:illegalRequestFormat').
	 * 
	 * @param stringResponse the string response containing the illegal request formats.
	 * @param expectedNumIllReqFormats the expected number of illegal request format elements within the string response.
	 */
	public static void checkResponseForNumIllegalRequestFormats(StringResponse stringResponse, int expectedNumIllReqFormats) {
		checkResponseForWarningsPart(stringResponse, true);
		
		int actualNumIllReqFormats = stringResponse.getWarnings().getIllegalRequestFormats().size();
		assertTrueWithPrefix("Wrong number of illegal request formats: was " + actualNumIllReqFormats + " instead of " + expectedNumIllReqFormats,
				   actualNumIllReqFormats == expectedNumIllReqFormats);
	}
	
	/**
	 * Checks a number response (XML tag 'response:number') for the number of illegal request format
	 * (XML tag 'response:illegalRequestFormat').
	 * 
	 * @param numberResponse the number response containing the illegal request formats.
	 * @param expectedNumIllReqFormats the expected number of illegal request format elements within the number response.
	 */
	public static void checkResponseForNumIllegalRequestFormats(NumberResponse numberResponse, int expectedNumIllReqFormats) {
		checkResponseForWarningsPart(numberResponse, true);
		
		int actualNumIllReqFormats = numberResponse.getWarnings().getIllegalRequestFormats().size();
		assertTrueWithPrefix("Wrong number of illegal request formats: was " + actualNumIllReqFormats + " instead of " + expectedNumIllReqFormats,
				   actualNumIllReqFormats == expectedNumIllReqFormats);
	}
	
	/**
	 * Checks a string response (XML tag 'response:string') for the number of illegal operators
	 * (XML tag 'response:illegallGenerator').
	 * 
	 * @param stringResponse the string response containing the illegal generators.
	 * @param expectedNumIllegalGenerators the expected number of illegal generator elements within the string response.
	 */
	public static void checkResponseForNumIllegalGenerators(StringResponse stringResponse, int expectedNumIllegalGenerators) {
		checkResponseForWarningsPart(stringResponse, true);

		int actualNumIllGenerators = stringResponse.getWarnings().getIllegalOperators().size();
		assertTrueWithPrefix("Wrong number of illegal operators: was " + actualNumIllGenerators + " instead of " + expectedNumIllegalGenerators,
				   actualNumIllGenerators == expectedNumIllegalGenerators);
	}
	
	/**
	 * Checks a number response (XML tag 'response:number') for the number of illegal generators
	 * (XML tag 'response:illegallGenerator').
	 * 
	 * @param numberResponse the number response containing the illegal generators.
	 * @param expectedNumIllegalGenerators the expected number of illegal generator elements within the number response.
	 */
	public static void checkResponseForNumIllegalGenerators(NumberResponse numberResponse, int expectedNumIllegalGenerators) {
		checkResponseForWarningsPart(numberResponse, true);

		int actualNumIllGenerators = numberResponse.getWarnings().getIllegalGenerators().size();
		assertTrueWithPrefix("Wrong number of illegal operators: was " + actualNumIllGenerators + " instead of " + expectedNumIllegalGenerators,
				   actualNumIllGenerators == expectedNumIllegalGenerators);
	}
	
	/**
	 * Checks a string response (XML tag 'response:string') for the number of illegal operators
	 * (XML tag 'response:illegallOperator').
	 * 
	 * @param stringResponse the string response containing the illegal operators.
	 * @param expectedNumIllegalOperators the expected number of illegal operator elements within the string response.
	 */
	public static void checkResponseForNumIllegalOperators(StringResponse stringResponse, int expectedNumIllegalOperators) {
		checkResponseForWarningsPart(stringResponse, true);

		int actualNumIllOperators = stringResponse.getWarnings().getIllegalOperators().size();
		assertTrueWithPrefix("Wrong number of illegal operators: was " + actualNumIllOperators + " instead of " + expectedNumIllegalOperators,
				   actualNumIllOperators == expectedNumIllegalOperators);
	}
	
	/**
	 * Checks a number response (XML tag 'response:number') for the number of illegal operators
	 * (XML tag 'response:illegallOperator').
	 * 
	 * @param numberResponse the number response containing the illegal operators.
	 * @param expectedNumIllegalOperators the expected number of illegal operator elements within the number response.
	 */
	public static void checkResponseForNumIllegalOperators(NumberResponse numberResponse, int expectedNumIllegalOperators) {
		checkResponseForWarningsPart(numberResponse, true);

		int actualNumIllOperators = numberResponse.getWarnings().getIllegalOperators().size();
		assertTrueWithPrefix("Wrong number of illegal operators: was " + actualNumIllOperators + " instead of " + expectedNumIllegalOperators,
				   actualNumIllOperators == expectedNumIllegalOperators);
	}
	
	/**
	 * Returns a illegal request format (XML tag 'response:illegalRequestFormat') identified by its index.
	 * Fails if there is no illegal request format with the given index.
	 * 
	 * @param numberResponse the number response containing the illegal request formats.
	 * @param index the index identifying the requested illegal request format.
	 * @return the requested illegal request format.
	 */
	public static IllegalRequestFormat getIllegalRequestFormatFromResponse(NumberResponse numberResponse, int index) {
		checkResponseForWarningsPart(numberResponse, true);		

		assertTrueWithPrefix("Number response does not contain illegal request formats.",
				   numberResponse.getWarnings().getIllegalRequestFormats() != null);
		
		assertTrueWithPrefix("Number response does not contain illegal request formats.",
				   !numberResponse.getWarnings().getIllegalRequestFormats().isEmpty());
		
		int counter = 0;
		for (IllegalRequestFormat illegalRequestFormat : numberResponse.getWarnings().getIllegalRequestFormats()) {
			if (counter == index) {
				return illegalRequestFormat;
			}
			counter++;
		}
		fail("IllegalRequestFormat with index " + index + " does not exists.");
		return null;
	}
	
	/**
	 * Checks a illegal request format (XML tag 'response:illegalRequestFormat') for a its attributes 'element' and 'attribute'.
	 * Fails if the 'element' and 'attribute' attributes differ from the expected ones.
	 * 
	 * @param illegalRequestFormat the illegal request format in question.
	 * @param expectedElement the expected value of the attribute 'element' of the illegal request format.
	 * @param expectedAttribute the expected value of the attribute 'attribute' of the illegal request format.
	 */
	public static void checkIllegalRequestFormatForElementAndId(IllegalRequestFormat illegalRequestFormat,
			                                             String expectedElement,
			                                             String expectedAttribute) {
		String actualElement = illegalRequestFormat.getElement();
		assertTrueWithPrefix("Wrong element: was " + actualElement + " instead of " + expectedElement,
				   actualElement.equals(expectedElement));
		
		String actualAttribute = illegalRequestFormat.getAttribute();
		assertTrueWithPrefix("Wrong attribute: was " + actualAttribute + " instead of " + expectedAttribute,
				   actualAttribute.equals(expectedAttribute));
		
		String actualMissingElement = illegalRequestFormat.getMissingElement();
		assertTrueWithPrefix("Missing element is " + actualMissingElement + " instead of null",
				   actualMissingElement == null);
		
		String actualMissingAttribute = illegalRequestFormat.getMissingAttribute();
		assertTrueWithPrefix("Missing attribute is " + actualMissingAttribute + " instead of null",
				actualMissingAttribute == null);
	}
	
	/**
	 * Checks a illegal request format (XML tag 'response:illegalRequestFormat') for a its attribute 'element'.
	 * Fails if the 'element' attribute differs from the expected one.
	 * 
	 * @param illegalRequestFormat the illegal request format in question.
	 * @param expectedMissingElement the expected value of the attribute 'element' of the illegal request format.
	 */
	public static void checkIllegalRequestFormatForMissingElement(IllegalRequestFormat illegalRequestFormat, String expectedMissingElement) {
		String actualElement = illegalRequestFormat.getMissingElement();
		assertTrueWithPrefix("Wrong element: was " + actualElement + " instead of " + expectedMissingElement,
				   actualElement != null && actualElement.equals(expectedMissingElement));
	}
	
	/**
	 * Checks if a certain number of generator parts (XML tag 'response:generator') exists within a string response
	 * (XML tag 'response:string').
	 * Fails if the number differs from the expected.
	 * 
	 * @param stringResponse the string response containing the generator parts.
	 * @param expectedNumGeneratorParts the expected number of generator parts within the string response.
	 */
	public static void checkResponseForNumGeneratorParts(StringResponse stringResponse, int expectedNumGeneratorParts) {
		AllGeneratorsBasedPart allGeneratorsBasedPart = stringResponse.getGeneratorBasedPart();
		if (allGeneratorsBasedPart == null && expectedNumGeneratorParts == 0) {
			return;
		} else {
			assertTrueWithPrefix("String response does not contain generator parts.", 
					   allGeneratorsBasedPart != null);
		}
		List<GeneratorPart> generatorParts = allGeneratorsBasedPart.getGeneratorParts();
		int actualNumGeneratorParts = generatorParts.size();
		assertTrueWithPrefix("Wrong number of generator parts: was " + actualNumGeneratorParts + " instead of " + expectedNumGeneratorParts,
				   actualNumGeneratorParts == expectedNumGeneratorParts);
	}	
	
	/**
	 * Checks if a minimal number of generator parts (XML tag 'response:generator') exists within a string response
	 * (XML tag 'response:string').
	 * Fails if the number differs from the expected.
	 * 
	 * @param stringResponse the string response containing the generator parts.
	 * @param expectedMinNumGeneratorParts the expected number of generator parts within the string response.
	 */
	public static void checkResponseForMinNumGeneratorParts(StringResponse stringResponse, int expectedMinNumGeneratorParts) {
		AllGeneratorsBasedPart allGeneratorsBasedPart = stringResponse.getGeneratorBasedPart();
		if (allGeneratorsBasedPart == null && expectedMinNumGeneratorParts == 0) {
			return;
		} else {
			assertTrueWithPrefix("String response does not contain generator parts.", 
					   allGeneratorsBasedPart != null);
		}
		List<GeneratorPart> generatorParts = allGeneratorsBasedPart.getGeneratorParts();
		int actualNumGeneratorParts = generatorParts.size();
		assertTrueWithPrefix("Wrong number of generator parts: was " + actualNumGeneratorParts + " instead of " + expectedMinNumGeneratorParts,
				   actualNumGeneratorParts >= expectedMinNumGeneratorParts);
	}	
	
	/**
	 * Checks if a certain number of operator parts (XML tag 'response:operator') exists within a number response
	 * (XML tag 'response:number').
	 * Fails if the number differs from the expected.
	 * 
	 * @param numberResponse the number response containing the operator parts.
	 * @param expectedNumOperatorParts the expected number of operator parts within the number response.
	 */
	public static void checkResponseForNumOperatorParts(NumberResponse numberResponse, int expectedNumOperatorParts) {
		AllOperatorsBasedPart allOperatorsBasedPart = numberResponse.getOperatorBasedPart();
		if (allOperatorsBasedPart == null && expectedNumOperatorParts == 0) {
			return;
		} else {
			assertTrueWithPrefix("Number response contains no operator parts.", 
					   allOperatorsBasedPart != null);
		}
		List<OperatorPart> operatorParts = allOperatorsBasedPart.getOperatorParts();
		int actualNumOperatorParts = operatorParts.size();
		assertTrueWithPrefix("Wrong number of operator parts: was " + actualNumOperatorParts + " instead of " + expectedNumOperatorParts,
				             actualNumOperatorParts == expectedNumOperatorParts);
	}	
	
	/**
	 * Checks if a certain number of operator parts (XML tag 'response:operator') exists within a string response
	 * (XML tag 'response:string').
	 * Fails if the number differs from the expected.
	 * 
	 * @param stringResponse the string response containing the operator parts.
	 * @param expectedNumOperatorParts the expected number of operator parts within the string response.
	 */
	public static void checkResponseForNumOperatorParts(StringResponse stringResponse, int expectedNumOperatorParts) {
		AllOperatorsBasedPart allOperatorsBasedPart = stringResponse.getOperatorBasedPart();
		if (allOperatorsBasedPart == null && expectedNumOperatorParts == 0) {
			return;
		} else {
			assertTrueWithPrefix("String response does not contain operator parts.", 
					             allOperatorsBasedPart != null);
		}
		List<OperatorPart> operatorParts = allOperatorsBasedPart.getOperatorParts();
		int actualNumOperatorParts = operatorParts.size();
		assertTrueWithPrefix("Wrong number of operator parts: was " + actualNumOperatorParts + " instead of " + expectedNumOperatorParts,
				             actualNumOperatorParts == expectedNumOperatorParts);
	}	
	
	/**
	 * Checks if a minimal number of operator parts (XML tag 'response:operator') exists within a string response
	 * (XML tag 'response:string').
	 * Fails if the number differs from the expected.
	 * 
	 * @param stringResponse the string response containing the operator parts.
	 * @param expectedMinNumOperatorParts the expected number of operator parts within the string response.
	 */
	public static void checkResponseForMinNumOperatorParts(StringResponse stringResponse, int expectedMinNumOperatorParts) {
		AllOperatorsBasedPart allOperatorsBasedPart = stringResponse.getOperatorBasedPart();
		if (allOperatorsBasedPart == null && expectedMinNumOperatorParts == 0) {
			return;
		} else {
			assertTrueWithPrefix("String response does not contain operator parts.", 
					   allOperatorsBasedPart != null);
		}
		List<OperatorPart> operatorParts = allOperatorsBasedPart.getOperatorParts();
		int actualNumOperatorParts = operatorParts.size();
		assertTrueWithPrefix("Wrong number of operator parts: was " + actualNumOperatorParts + " instead of " + expectedMinNumOperatorParts,
				             actualNumOperatorParts >= expectedMinNumOperatorParts);
	}	
	
	/**
	 * Checks if a certain number of generator parts (XML tag 'response:generator') exists within a number response
	 * (XML tag 'response:number').
	 * Fails if the number differs from the expected.
	 * 
	 * @param numberResponse the number response containing the generator parts.
	 * @param expectedNumGeneratorParts the expected number of generator parts within the number response.
	 */
	public static void checkResponseForNumGeneratorParts(NumberResponse numberResponse, int expectedNumGeneratorParts) {
		AllGeneratorsBasedPart allGeneratorsBasedPart = numberResponse.getGeneratorBasedPart();
		if (allGeneratorsBasedPart == null && expectedNumGeneratorParts == 0) {
			return;
		} else {
			assertTrueWithPrefix("Number response contains no generator parts.", 
					   allGeneratorsBasedPart != null);
		}
		List<GeneratorPart> generatorParts = allGeneratorsBasedPart.getGeneratorParts();
		int actualNumGeneratorParts = generatorParts.size();
		assertTrueWithPrefix("Wrong number of generator parts: was " + actualNumGeneratorParts + " instead of " + expectedNumGeneratorParts,
				   actualNumGeneratorParts == expectedNumGeneratorParts);
	}
	
	/**
	 * Returns a certain generator part (XML tag 'response:generator') identified by the attribute 'name'.
	 * Fails if there is no such generator part.
	 * 
	 * @param stringResponse the string response containing the generator parts.
	 * @param generatorName the name of the generator that identifies the request generator part.
	 * @return the request generator part.
	 */
	public static GeneratorPart getGeneratorPartFromResponseByName(StringResponse stringResponse, String generatorName) {
		for (GeneratorPart generatorPart : stringResponse.getGeneratorBasedPart().getGeneratorParts()) {
			if (generatorPart.getName().equals(generatorName)) {
				return generatorPart;
			}
		}
		fail("GeneratorPart for generator \"" + generatorName + "\" does not exists.");
		return null;
	}
	
	/**
	 * Returns a certain operator part (XML tag 'response:operator') identified by the attribute 'name'.
	 * Fails if there is no such operator part.
	 * 
	 * @param stringResponse the string response containing the operator parts.
	 * @param operatorName the name of the operator that identifies the request operator part.
	 * @return the request operator part.
	 */
	public static OperatorPart getOperatorPartFromResponseByName(StringResponse stringResponse, 
			                                                     String operatorName,
			                                                     String validValue) {
		for (OperatorPart operatorPart : stringResponse.getOperatorBasedPart().getOperatorParts()) {
			if (operatorPart.getName().equals(operatorName) && operatorPart.getBasedOn().equals(validValue)) {
				return operatorPart;
			}
		}
		fail("OperatorPart for operator \"" + operatorName + "\" does not exists.");
		return null;
	}	
	/**
	 * Returns a certain generator part (XML tag 'response:generator') identified by the attribute 'name'.
	 * Fails if there is no such generator part.
	 * 
	 * @param numberResponse the number response containing the generator parts.
	 * @param generatorName the name of the generator that identifies the request generator part.
	 * @return the request generator part.
	 */
	public static GeneratorPart getGeneratorPartFromResponseByName(NumberResponse numberResponse, String generatorName) {
		for (GeneratorPart generatorPart : numberResponse.getGeneratorBasedPart().getGeneratorParts()) {
			if (generatorPart.getName().equals(generatorName)) {
				return generatorPart;
			}
		}
		fail("GeneratorPart for generator \"" + generatorName + "\" does not exists.");
		return null;
	}
	
	/**
	 * Returns a certain operator part (XML tag 'response:operator') identified by the attribute 'name'.
	 * Fails if there is no such operator part.
	 * 
	 * @param numberResponse the number response containing the operator parts.
	 * @param operatorName the name of the operator that identifies the request operator part.
	 * @param validValue the valid value the operator is applied to.
	 * @return the request operator part.
	 */
	public static OperatorPart getOperatorPartFromNumberResponseByName(NumberResponse numberResponse, 
			                                                     String operatorName, 
			                                                     String validValue) {
		for (OperatorPart operatorPart : numberResponse.getOperatorBasedPart().getOperatorParts()) {
			if (operatorPart.getName().equals(operatorName)) {
				return operatorPart;
			}
		}
		fail("OperatorPart for operator \"" + operatorName + "\" does not exists.");
		return null;
	}
	
	/**
	 * Checks a generator part (XML tag 'response:generator')for a certain number of fuzzed values 
	 * (XML tag 'response:fuzzedValue').
	 * Fails if the number differs.
	 * 
	 * @param generatorPart the generator part containing the fuzzed values.
	 * @param expectedNumFuzzedValues the expected number of fuzzed values.
	 */
	public static void checkGeneratorPartForNumFuzzedValues(GeneratorPart generatorPart, int expectedNumFuzzedValues) {
		List<String> fuzzedValues = generatorPart.getFuzzedValues();
		int actualNumFuzzedValues = fuzzedValues.size();
		assertTrueWithPrefix("Wrong number of fuzzed values: was " + actualNumFuzzedValues + " instead of " + expectedNumFuzzedValues,
				   actualNumFuzzedValues == expectedNumFuzzedValues);
	}
	
	/**
	 * Checks a operator part (XML tag 'response:operator')for a certain number of fuzzed values 
	 * (XML tag 'response:fuzzedValue').
	 * Fails if the number differs.
	 * 
	 * @param opratorPart the operator part containing the fuzzed values.
	 * @param expectedNumFuzzedValues the expected number of fuzzed values.
	 */
	public static void checkOperatorPartForNumFuzzedValues(OperatorPart operatorPart, int expectedNumFuzzedValues) {
		List<String> fuzzedValues = operatorPart.getFuzzedValues();
		int actualNumFuzzedValues = fuzzedValues.size();
		assertTrueWithPrefix("Wrong number of fuzzed values: was " + actualNumFuzzedValues + " instead of " + expectedNumFuzzedValues,
				   actualNumFuzzedValues == expectedNumFuzzedValues);
	}
	
	/**
	 * Checks a string response (XML tag 'response:string') for the value of its 'moreValues' attribute.
	 * Fails if it differs from the expected value.
	 * 
	 * @param stringResponse the string response whose more values attribute shall be checked.
	 * @param expectedMoreValuesAttribute the expected value of the more values attribute.
	 */
	public static void checkResponseForMoreValuesAttribute(StringResponse stringResponse,
			                                               boolean expectedMoreValuesAttribute) {
		boolean actualValue = stringResponse.isMoreValues();
		assertTrueWithPrefix("moreValues was " + actualValue + " instead of " + expectedMoreValuesAttribute,
				   actualValue == expectedMoreValuesAttribute);
	}
	
	/**
	 * Checks a number response (XML tag 'response:number') for the value of its 'moreValues' attribute.
	 * Fails if it differs from the expected value.
	 * 
	 * @param numberResponse The number response whose more values attribute shall be checked.
	 * @param expectedMoreValuesAttribute The expected value of the more values attribute.
	 */
	public static void checkResponseForMoreValuesAttribute(NumberResponse numberResponse,
			                                               boolean expectedMoreValuesAttribute) {
		boolean actualValue = numberResponse.isMoreValues();
		assertTrueWithPrefix("moreValues was " + actualValue + " instead of " + expectedMoreValuesAttribute,
				   actualValue == expectedMoreValuesAttribute);
	}
	
	/**
	 * Checks a string response for its seed value. Fails if it differs from the expected one.
	 * 
	 * @param stringResponse the string response containing the seed.
	 * @param expectedSeed the seed expected in the string response.
	 */
	public static void checkResponseForSeedValue(StringResponse stringResponse, String expectedSeed) {
		String actualSeed = stringResponse.getSeed();
		assertTrueWithPrefix("Wrong seed: was " + actualSeed + " instead of " + expectedSeed,
				   actualSeed.equals(expectedSeed));
	}
	
	/**
	 * Checks a string response for warnings.
	 * 
	 * @param stringResponse the string response that possibly contains warnings.
	 * @param warningsPartExist set to {@code true} if warnings were expected, otherwise to {@code false}.
	 */
	public static void checkResponseForWarningsPart(StringResponse stringResponse, boolean warningsPartExist) {
		boolean actualWarningsPartExist = stringResponse.getWarnings() != null;
		String message = (warningsPartExist ? "No warning exists but was expected." : "Warning exists but no warning was expected.");
		assertTrueWithPrefix(message,
				   actualWarningsPartExist == warningsPartExist);
	}	

	/**
	 * Checks a number response for warnings.
	 * 
	 * @param numberResponse the string response that possibly contains warnings.
	 * @param warningsPartExist set to {@code true} if warnings were expected, otherwise to {@code false}.
	 */
	public static void checkResponseForWarningsPart(NumberResponse numberResponse, boolean warningsPartExist) {
		boolean actualWarningsPartExist = numberResponse.getWarnings() != null;
		String message = (warningsPartExist ? "No warning exists but was expected." : "Warning exists but no warning was expected.");
		assertTrueWithPrefix(message,
				   actualWarningsPartExist == warningsPartExist);
	}	

	/**
	 * Checks if a string response (XML tag 'response:string') contains a no more values warning
	 * (XML tag 'response:noMoreValuesAvailable').
	 * Fails if the indicator does not exist.
	 * 
	 * @param contdStringResponse the string response that should contain the no more values indicator.
	 */
	public static void checkResponseForNoMoreValuesWarning(StringResponse contdStringResponse) {
		WarningsPart warningsPart = contdStringResponse.getWarnings();
		assertTrueWithPrefix("No warnings exist in string response.",
				    warningsPart != null);
		
		NoMoreValuesIndicator noMoreValuesIndicator = warningsPart.getFlagNoMoreValues();
		assertTrueWithPrefix("No more values indicator is not set.",
				   noMoreValuesIndicator != null);
	}

	/**
	 * Checks if a number response (XML tag 'response:number') contains a no more values warning
	 * (XML tag 'response:noMoreValuesAvailable').
	 * Fails if the indicator does not exist.
	 * 
	 * @param contdNumberResponse the number response that should contain the no more values indicator.
	 */
	public static void checkResponseForNoMoreValuesWarning(NumberResponse contdNumberResponse) {
		WarningsPart warningsPart = contdNumberResponse.getWarnings();
		assertTrueWithPrefix("No warnings exist in string response.",
				             warningsPart != null);
		
		NoMoreValuesIndicator noMoreValuesIndicator = warningsPart.getFlagNoMoreValues();
		assertTrueWithPrefix("No more values indicator is not set.",
				             noMoreValuesIndicator != null);
	}

	/**
	 * Creates a string request (XML tag 'request:string') that continues another one.
	 * 
	 * @param stringResponseToContinueFrom the string response to continue from.
	 * @param filename where to save the continued string request.
	 * @param numValues the number of values to be requested by the continued request.
	 */
	public static void createContdRequest(StringResponse stringResponseToContinueFrom, String filename, int numValues) {
		StringRequest contdStringRequest = RequestFactory.eINSTANCE.createStringRequest();
		contdStringRequest.setId(stringResponseToContinueFrom.getId());
		contdStringRequest.setName(stringResponseToContinueFrom.getName());
		contdStringRequest.setMaxValues(numValues);
		
		Request request = RequestFactory.eINSTANCE.createRequest();
		request.getStringRequests().add(contdStringRequest);
		XmlRequestDocument requestDoc = RequestFactory.eINSTANCE.createXmlRequestDocument();
		requestDoc.setRequest(request);
		
		saveRequest(requestDoc, filename);
	}
	
	/**
	 * Creates a number request (XML tag 'request:number') that continues another one.
	 * 
	 * @param numberResponseToContinueFrom the number response to continue from.
	 * @param filename where to save the continued number request.
	 * @param numValues the number of values to be requested by the continued request.
	 */
	public static void createContdRequest(NumberResponse numberResponseToContinueFrom, String filename, int numValues) {
		NumberRequest contdNumberRequest = RequestFactory.eINSTANCE.createNumberRequest();
		contdNumberRequest.setId(numberResponseToContinueFrom.getId());
		contdNumberRequest.setName(numberResponseToContinueFrom.getName());
		contdNumberRequest.setMaxValues(numValues);
		
		Request request = RequestFactory.eINSTANCE.createRequest();
		request.getNumberRequests().add(contdNumberRequest);
		XmlRequestDocument requestDoc = RequestFactory.eINSTANCE.createXmlRequestDocument();
		requestDoc.setRequest(request);
		
		saveRequest(requestDoc, filename);
	}
	
	/**
	 * Creates a request file that closes another one identified by the id from its response.
	 * 
	 * @param requestFilename where to save the close request.
	 * @param stringResponse the response containing the id that is necessary to close the request.
	 */
	public static void createCloseRequestFileFromResponse(String requestFilename, StringResponse stringResponse) {
		Request request = RequestFactory.eINSTANCE.createRequest();
		createCloseRequestCommandFromResponse(stringResponse, request);
		
		XmlRequestDocument xmlRequestDocument = RequestFactory.eINSTANCE.createXmlRequestDocument();
		xmlRequestDocument.setRequest(request);
		
		saveRequest(xmlRequestDocument, requestFilename);
	}
	
	/**
	 * Creates a request file that closes another one identified by the id from its response.
	 * 
	 * @param requestFilename where to save the close request.
	 * @param numberResponse the response containing the id that is necessary to close the request.
	 */
	public static void createCloseRequestFileFromResponse(String requestFilename, NumberResponse numberResponse) {
		Request request = RequestFactory.eINSTANCE.createRequest();
		createCloseRequestCommandFromResponse(numberResponse, request);
		
		XmlRequestDocument xmlRequestDocument = RequestFactory.eINSTANCE.createXmlRequestDocument();
		xmlRequestDocument.setRequest(request);
		
		saveRequest(xmlRequestDocument, requestFilename);
	}
	
	/**
	 * Creates a close request command (XML tag 'request:closeRequest') for a given string response and stores it
	 * into a given request.
	 * 
	 * @param stringResponse The string response to be closed.
	 * @param request The request where to save the created close request command.
	 */
	public static void createCloseRequestCommandFromResponse(StringResponse stringResponse, Request request) {
		CloseRequest closeRequest = RequestFactory.eINSTANCE.createCloseRequest();
		closeRequest.setId(stringResponse.getId());
		request.getCloseRequests().add(closeRequest);
	}
	
	/**
	 * Creates a close request command (XML tag 'request:closeRequest') for a given response and stores it
	 * into a given request.
	 * 
	 * @param numberResponse The number response to be closed.
	 * @param request The request where to save the created close request command.
	 */
	public static void createCloseRequestCommandFromResponse(NumberResponse numberResponse, Request request) {
		CloseRequest closeRequest = RequestFactory.eINSTANCE.createCloseRequest();
		closeRequest.setId(numberResponse.getId());
		request.getCloseRequests().add(closeRequest);
	}
	
	/**
	 * Loads the response file that is generated for a certain request file.
	 * Fails if such file does not exists.
	 * 
	 * @param requestFilename the filename of the request where the response is generated for.
	 * @return the response.
	 */
	public static XmlResponseDocument loadResponseFileForRequest(String requestFilename) {
		checkIfResponseFileExists(requestFilename);
		
		String responseFilename = getResponseFilenameForRequest(requestFilename);
		XmlResponseDocument responseDoc = null;

		ResponsePackage.eINSTANCE.eClass();

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new RequestResourceFactoryImpl());

		ResourceSet resSet = new ResourceSetImpl();

		Resource resource = null;
		try {
			resource = resSet.getResource(URI.createURI(responseFilename), true);
			responseDoc = (XmlResponseDocument) resource.getContents().get(0);
		} catch (WrappedException e) {
			SAXParseException cause = (SAXParseException) e.getCause();
			System.out.println("line " + cause.getLineNumber() + ", column " + cause.getColumnNumber() + " : " + cause.getMessage());
		}
		return responseDoc;
	}
	
	/**
	 * Loads an {@link XmlResponseDocument} from an XML string.
	 * 
	 * @param 
	 * @param xmlString The string containing a response in XML format.
	 * @return The parsed XML file as {@link XmlRequestDocument}.
	 */
	public static XmlResponseDocument loadResponseString(String xmlString) {
		XmlResponseDocument responseDoc = null;
		ResponsePackage.eINSTANCE.eClass();

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new ResponseResourceFactoryImpl());

		ResourceSet resSet = new ResourceSetImpl();
		
		try {
			EObject model = Helpers.load(new ByteArrayInputStream(xmlString.getBytes()), "", resSet);	
			responseDoc = (XmlResponseDocument) model;
		} catch (WrappedException e) {
			SAXParseException cause = (SAXParseException) e.getCause();
			System.out.println("line " + cause.getLineNumber() + ", column " + cause.getColumnNumber() + " : " + cause.getMessage());
		}
		return responseDoc;
	}
	

	
	/**
	 * Saves a request to a file.
	 * 
	 * @param xmlRequestDocument  the request to be saved.
	 * @param fileName where to save the request.
	 */
	public static void saveRequest(XmlRequestDocument xmlRequestDocument, String fileName) {
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file extensions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		(Resource.Factory.Registry.DEFAULT_EXTENSION, new ResponseResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		resourceSet.getPackageRegistry().put(ResponsePackage.eNS_URI, ResponsePackage.eINSTANCE);

		try {
			Resource resource = resourceSet.createResource(URI.createURI("http://library.fuzzing.fokus.fraunhofer.de/request"));
			resource.getContents().add(xmlRequestDocument);

			FileOutputStream out = new FileOutputStream(fileName);
			resource.save(out, null);
		}
		catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	
	/**
	 * Compares two string sequences.
	 * Fails if they are not identical.
	 * 
	 * @param list1 one sequence of string values to be compared with <code>list1</code>.
	 * @param list2 another sequence of string values to be compared with <code>list2</code>.
	 */
	public static void compareTwoSequences(List<String> list1, List<String> list2) {
		assertTrueWithPrefix("Different lengths: list1 has " + list1.size() + " elements, list2 has " + list2.size() + " elements",
				   list1.size() == list2.size());
		
		for (int i=0; i<list1.size(); i++) {
			String list1Value = list1.get(i);
			String list2Value = list2.get(i);
			assertTrueWithPrefix("Differents elements (at index " + i + "): list1 has " + list1Value + ", list2 has " + list2Value,
					   list1Value.equals(list2Value));
		}
	}
	
	/**
	 * Generates the filename of a response from a given request filename.
	 * 
	 * @param requestFilename the filename of the request to generate the corresponding response filename.
	 * @return the reponse filename correspondent to the request filenam.
	 */
	public static String getResponseFilenameForRequest(String requestFilename) {
		return requestFilename.replace(".request.xml", "") + ".response.xml";
	}

	
}
