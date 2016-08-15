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

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Request;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CloseRequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringRequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.CommonResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedValuesByGenerators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Response;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StructuredValueResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponseImpl;

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
	 * @throws JAXBException 
	 * @throws SAXException 
	 */
		
		public static Response getResponseDocForRequest(String requestFilename) throws JAXBException, SAXException {
			return getResponseDocForRequest(requestFilename, false);
		}
	
	public static Response getResponseDocForRequest(String requestFilename, boolean encode) throws JAXBException, SAXException {
		RequestDispatcher dispatcher = new RequestDispatcher(requestFilename, encode);
		dispatcher.dispatch();
		return loadResponseFileForRequest(requestFilename);
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
	public static void checkResponseDocForErrorMessage(Response responseDoc, String expectedErrorMessage) {
		checkResponseDocForErrorResponse(responseDoc, true);
		ErrorResponse errorResponse = responseDoc.getErrorResponse();
		
		String actualErrorMessage = errorResponse.getReason();
		assertTrueWithPrefix("ErrorResponse is " + actualErrorMessage + " instead of containing " + expectedErrorMessage,
		           actualErrorMessage.contains(expectedErrorMessage));
	}
	
	/**
	 * Checks a response for an error response (XML tag 'response:error').
	 * 
	 * @param responseDoc the response possibly containing an error response.
	 * @param expectedErrorResponseExists set to {@code true} if an error response is expected, {@code false} otherwise.
	 */
	public static void checkResponseDocForErrorResponse(Response responseDoc, boolean expectedErrorResponseExists) {
		boolean actualErrorResponseExists = responseDoc.getErrorResponse() != null;
		
		String message = expectedErrorResponseExists ? "No error response but was expected." : 
			                                     "Error response exists but no error response was expected.";
		
		assertTrueWithPrefix(message,
				   actualErrorResponseExists == expectedErrorResponseExists);
	}

	
	/**
	 * Checks if there is a certain number of string responses (XML tag 'response:string') within a response 
	 * (XML tag 'response:response').
	 * Fails if not.
	 * 
	 * @param responseDoc the response containing the string responses.
	 * @param expectedNumStringResponses the number of string responses to check for.
	 */
	public static void checkResponseDocForNumStringResponses(Response responseDoc, int expectedNumStringResponses) {
		List<StringResponse> stringResponses = responseDoc.getStringResponses();
		int actualNumResponses = stringResponses.size();
		assertTrueWithPrefix("Wrong number of string responses: was " + actualNumResponses + " instead of " + expectedNumStringResponses,
				   actualNumResponses == expectedNumStringResponses);
	}

	
	/**
	 * Checks if there is a certain number of number responses (XML tag 'response:number') within a response 
	 * (XML tag 'response:response').
	 * Fails if not.
	 * 
	 * @param responseDoc the response containing the number responses.
	 * @param expectedNumNumberResponses the number of number responses to check for.
	 */
	public static void checkResponseDocForNumNumberResponses(Response response, int expectedNumNumberResponses) {
		List<NumberResponse<? extends Number>> numberResponses = response.getNumberResponses();
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
	public static void checkResponseDocForNumCollectionResponses(Response responseDoc, int expectedNumCollectionResponses) {
		List<CollectionResponse> collectionResponses = responseDoc.getCollectionResponses();
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
	public static void checkResponseDocForNumStructureResponses(Response responseDoc, int expectedNumStructureResponses) {
		List<StructureResponse> structureResponses = responseDoc.getStructureResponses();
		int actualNumResponses = structureResponses.size();
		assertTrueWithPrefix("Wrong number of structure responses: was " + actualNumResponses + " instead of " + expectedNumStructureResponses,
				   actualNumResponses == expectedNumStructureResponses);
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
	 * Returns a illegal request format (XML tag 'response:illegalRequestFormat') identified by its index.
	 * Fails if there is no illegal request format with the given index.
	 * 
	 * @param stringResponse the string response containing the illegal request formats.
	 * @param index the index identifying the requested illegal request format.
	 * @return the requested illegal request format.
	 */
	public static IllegalRequestFormat getIllegalRequestFormatFromResponse(CommonResponse response, int index) {
		int counter = 0;
		for (IllegalRequestFormat illegalRequestFormat : response.getWarningsSection().getIllegalRequestFormats()) {
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
	public static void checkResponseForNumIllegalRequestFormats(CommonResponse stringResponse, int expectedNumIllReqFormats) {
		checkResponseForWarningsPart(stringResponse, true);
		
		int actualNumIllReqFormats = stringResponse.getWarningsSection().getIllegalRequestFormats().size();
		assertTrueWithPrefix("Wrong number of illegal request formats: was " + actualNumIllReqFormats + " instead of " + expectedNumIllReqFormats,
				   actualNumIllReqFormats == expectedNumIllReqFormats);
	}
	
	/**
	 * Checks a number response (XML tag 'response:number') for the number of illegal generators
	 * (XML tag 'response:illegallGenerator').
	 * 
	 * @param numberResponse the number response containing the illegal generators.
	 * @param expectedNumIllegalGenerators the expected number of illegal generator elements within the number response.
	 */
	public static void checkResponseForNumIllegalGenerators(CommonResponse numberResponse, int expectedNumIllegalGenerators) {
		checkResponseForWarningsPart(numberResponse, true);
		int actualNumIllGenerators = numberResponse.getWarningsSection().getIllegalGenerators().size();
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
	public static void checkResponseForNumIllegalOperators(CommonResponse stringResponse, int expectedNumIllegalOperators) {
		checkResponseForWarningsPart(stringResponse, true);
		int actualNumIllOperators = stringResponse.getWarningsSection().getIllegalOperators().size();
		assertTrueWithPrefix("Wrong number of illegal operators: was " + actualNumIllOperators + " instead of " + expectedNumIllegalOperators,
				   actualNumIllOperators == expectedNumIllegalOperators);
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
	 * @param <T>
	 * 
	 * @param stringResponse the string response containing the generator parts.
	 * @param expectedNumGeneratorParts the expected number of generator parts within the string response.
	 */
	public static <T> void checkResponseForNumGeneratorParts(StructuredValueResponse<T> response, int expectedNumGeneratorParts) {
		FuzzedValuesByGenerators<T> allGeneratorsBasedPart = response.getGeneratorBasedSection();
		if (allGeneratorsBasedPart == null && expectedNumGeneratorParts == 0) {
			return;
		} else {
			assertTrueWithPrefix("Response does not contain generator parts.", 
					   allGeneratorsBasedPart != null);
		}
		List<GeneratorSpecificFuzzedValues<T>> generatorParts = allGeneratorsBasedPart.getGeneratorSpecificSections();
		int actualNumGeneratorParts = generatorParts.size();
		assertTrueWithPrefix("Wrong number of generator specific sections: was " + actualNumGeneratorParts + " instead of " + expectedNumGeneratorParts,
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
		FuzzedValuesByGenerators<String> allGeneratorsBasedPart = stringResponse.getGeneratorBasedSection();
		if (allGeneratorsBasedPart == null && expectedMinNumGeneratorParts == 0) {
			return;
		} else {
			assertTrueWithPrefix("String response does not contain generator parts.", 
					   allGeneratorsBasedPart != null);
		}
		 List<GeneratorSpecificFuzzedValues<String>> generatorParts = allGeneratorsBasedPart.getGeneratorSpecificSections();
		int actualNumGeneratorParts = generatorParts.size();
		assertTrueWithPrefix("Wrong number of generator parts: was " + actualNumGeneratorParts + " instead of " + expectedMinNumGeneratorParts,
				   actualNumGeneratorParts >= expectedMinNumGeneratorParts);
	}	
	
	/**
	 * Checks if a certain number of operator parts (XML tag 'response:operator') exists within a number response
	 * (XML tag 'response:number').
	 * Fails if the number differs from the expected.
	 * @param <T>
	 * 
	 * @param numberResponse the number response containing the operator parts.
	 * @param expectedNumOperatorParts the expected number of operator parts within the number response.
	 */
	public static <T> void checkResponseForNumOperatorParts(StructuredValueResponse<T> numberResponse, int expectedNumOperatorParts) {
		if(numberResponse.getOperatorBasedSection()==null && expectedNumOperatorParts==0){
			return;
		}
		List<OperatorSpecificFuzzedValues<T>> allOperatorsBasedPart = numberResponse.getOperatorBasedSection().getOperatorSpecificSections();
		if (allOperatorsBasedPart == null && expectedNumOperatorParts == 0) {
			return;
		} else {
			assertTrueWithPrefix("Number response contains no operator specific sections.", 
					   allOperatorsBasedPart != null);
		}
		int actualNumOperatorParts = allOperatorsBasedPart.size();
		assertTrueWithPrefix("Wrong number of operator specific sections: was " + actualNumOperatorParts + " instead of " + expectedNumOperatorParts,
				             actualNumOperatorParts == expectedNumOperatorParts);
	}	

	
	/**
	 * Returns a certain generator part (XML tag 'response:generator') identified by the attribute 'name'.
	 * Fails if there is no such generator part.
	 * @param <T>
	 * 
	 * @param stringResponse the string response containing the generator parts.
	 * @param generatorName the name of the generator that identifies the request generator part.
	 * @return the request generator part.
	 */
	public static <T> GeneratorSpecificFuzzedValues<T> getGeneratorPartFromResponseByName(StructuredValueResponse<T> response, String generatorName) {
		for (GeneratorSpecificFuzzedValues<T> generatorPart : response.getGeneratorBasedSection().getGeneratorSpecificSections()) {
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
	 * @param <T>
	 * 
	 * @param numberResponse the number response containing the operator parts.
	 * @param operatorName the name of the operator that identifies the request operator part.
	 * @param validValue the valid value the operator is applied to.
	 * @return the request operator part.
	 */
	public static <T> OperatorSpecificFuzzedValues<T> getOperatorPartFromNumberResponseByName(StructuredValueResponse<T> numberResponse, 
			                                                     String operatorName, 
			                                                     String validValue) {
		for (OperatorSpecificFuzzedValues<T> operatorPart : numberResponse.getOperatorBasedSection().getOperatorSpecificSections()) {
			if (operatorPart.getName().equals(operatorName)) {
				return operatorPart;
			}
		}
		fail("operator specific section for operator \"" + operatorName + "\" does not exists.");
		return null;
	}
	
	/**
	 * Checks a generator part (XML tag 'response:generator')for a certain number of fuzzed values 
	 * (XML tag 'response:fuzzedValue').
	 * Fails if the number differs.
	 * @param <T>
	 * 
	 * @param generatorPart the generator part containing the fuzzed values.
	 * @param expectedNumFuzzedValues the expected number of fuzzed values.
	 */
	public static <T> void checkGeneratorPartForNumFuzzedValues(GeneratorSpecificFuzzedValues<T> generatorPart, int expectedNumFuzzedValues) {
		List<FuzzedValue<T>> fuzzedValues = generatorPart.getFuzzedValues();
		int actualNumFuzzedValues = fuzzedValues.size();
		assertTrueWithPrefix("Wrong number of fuzzed values: was " + actualNumFuzzedValues + " instead of " + expectedNumFuzzedValues,
				   actualNumFuzzedValues == expectedNumFuzzedValues);
	}
	
	/**
	 * Checks a operator part (XML tag 'response:operator')for a certain number of fuzzed values 
	 * (XML tag 'response:fuzzedValue').
	 * Fails if the number differs.
	 * @param <T>
	 * 
	 * @param opratorPart the operator part containing the fuzzed values.
	 * @param expectedNumFuzzedValues the expected number of fuzzed values.
	 */
	public static <T> void checkOperatorPartForNumFuzzedValues(OperatorSpecificFuzzedValues<T> operatorPart, int expectedNumFuzzedValues) {
		List<FuzzedValue<T>> fuzzedValues = operatorPart.getFuzzedValues();
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
	public static void checkResponseForMoreValuesAttribute(CommonResponse response,
			                                               boolean expectedMoreValuesAttribute) {
		boolean actualValue = response.moreValuesAvailable();
		assertTrueWithPrefix("moreValuesAvailable was " + actualValue + " instead of " + expectedMoreValuesAttribute,
				   actualValue == expectedMoreValuesAttribute);
	}
	
	/**
	 * Checks a string response for its seed value. Fails if it differs from the expected one.
	 * 
	 * @param stringResponse the string response containing the seed.
	 * @param expectedSeed the seed expected in the string response.
	 */
	public static void checkResponseForSeedValue(StringResponse stringResponse, long expectedSeed) {
		Long actualSeed = stringResponse.getSeed();
		assertTrueWithPrefix("Wrong seed: was " + actualSeed + " instead of " + expectedSeed,
				   actualSeed.equals(expectedSeed));
	}
	
	/**
	 * Checks a string response for warnings.
	 * 
	 * @param stringResponse the string response that possibly contains warnings.
	 * @param warningsPartExist set to {@code true} if warnings were expected, otherwise to {@code false}.
	 */
	public static void checkResponseForWarningsPart(CommonResponse response, boolean warningsPartExist) {
		boolean actualWarningsPartExist = response.getWarningsSection() != null;
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
	public static void checkResponseForNoMoreValuesWarning(CommonResponse response) {
		WarningsSection warningsPart = response.getWarningsSection();
		assertTrueWithPrefix("No warnings exist in string response.",
				    warningsPart != null);
		org.junit.Assert.assertFalse(warningsPart.hasMoreValues());
	}

	/**
	 * Creates a string request (XML tag 'request:string') that continues another one.
	 * 
	 * @param stringResponseToContinueFrom the string response to continue from.
	 * @param filename where to save the continued string request.
	 * @param numValues the number of values to be requested by the continued request.
	 * @throws JAXBException 
	 */
	public static void createContdRequest(StringResponse stringResponseToContinueFrom, String filename, int numValues) throws JAXBException {
		StringRequest contdStringRequest = new StringRequestImpl();
		contdStringRequest.setId(stringResponseToContinueFrom.getId());
		contdStringRequest.setName(stringResponseToContinueFrom.getName());
		contdStringRequest.setMaxValues(numValues);
		
		Request request = RequestFactory.INSTANCE.createRequest();
		request.getStringRequests().add(contdStringRequest);
		request.marshall(new File(filename));
	}
	
	/**
	 * Creates a number request (XML tag 'request:number') that continues another one.
	 * 
	 * @param numberResponseToContinueFrom the number response to continue from.
	 * @param filename where to save the continued number request.
	 * @param numValues the number of values to be requested by the continued request.
	 * @throws JAXBException 
	 */
	public static void createContdRequest(NumberResponse<?> numberResponseToContinueFrom, String filename, int numValues) throws JAXBException {
		NumberRequest contdNumberRequest = RequestFactory.INSTANCE.createNumberRequest();
		contdNumberRequest.setId(numberResponseToContinueFrom.getId());
		contdNumberRequest.setName(numberResponseToContinueFrom.getName());
		contdNumberRequest.setMaxValues(numValues);
		
		Request request = RequestFactory.INSTANCE.createRequest();
		request.getNumberRequests().add(contdNumberRequest);
		request.marshall(new File(filename));
		
	}
	
	/**
	 * Creates a request file that closes another one identified by the id from its response.
	 * 
	 * @param requestFilename where to save the close request.
	 * @param numberResponse the response containing the id that is necessary to close the request.
	 * @throws JAXBException 
	 */
	public static void createCloseRequestFileFromResponse(String requestFilename, CommonResponse response) throws JAXBException {
		Request request = new RequestImpl();
		CloseRequest closeRequest = new CloseRequestImpl();
		closeRequest.setId(response.getId());
		request.addCloseRequest(closeRequest);
		request.marshall(new File(requestFilename));
	}
	
	/**
	 * Loads the response file that is generated for a certain request file.
	 * Fails if such file does not exists.
	 * 
	 * @param requestFilename the filename of the request where the response is generated for.
	 * @return the response.
	 * @throws JAXBException 
	 * @throws SAXException 
	 */
	public static Response loadResponseFileForRequest(String requestFilename) throws JAXBException, SAXException {
		checkIfResponseFileExists(requestFilename);
		String responseFilename = getResponseFilenameForRequest(requestFilename);
		return ResponseImpl.unmarshall(new File(responseFilename));
	}
	
	/**
	 * Compares two string sequences.
	 * Fails if they are not identical.
	 * 
	 * @param list1 one sequence of string values to be compared with <code>list1</code>.
	 * @param list2 another sequence of string values to be compared with <code>list2</code>.
	 */
	public static void compareTwoSequences(List<FuzzedValue<String>> list1, List<FuzzedValue<String>> list2) {
		assertTrueWithPrefix("Different lengths: list1 has " + list1.size() + " elements, list2 has " + list2.size() + " elements",
				   list1.size() == list2.size());
		
		for (int i=0; i<list1.size(); i++) {
			FuzzedValue<String> list1Value = list1.get(i);
			FuzzedValue<String> list2Value = list2.get(i);
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
