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

import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkCloseRequestConfirmationForId;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkCloseRequestConfirmationForName;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkIllegalRequestFormatForElementAndId;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkOperatorPartForNumFuzzedValues;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForErrorMessage;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForErrorResponse;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumCollectionResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumNumberResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumStringResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumStructureResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForNumIllegalRequestFormats;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForNumOperatorParts;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForWarningsPart;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.createCloseRequestFileFromResponse;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getIllegalRequestFormatFromResponse;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getOperatorPartFromNumberResponseByName;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getResponseDocForRequest;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.xml.sax.SAXException;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.Request;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.GeneratorImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.OperatorImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringRequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringSpecificationImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Response;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse;

public class RequestDispatcherTest extends FuzzinoTest {
	
	private static String generalRequestRoot = "testdata/reworked/general/";
	private static String stringRequestRoot = "testdata/reworked/stringRequests/";
	private static String integerRequestRoot = "testdata/reworked/integerRequests/";
	
	@Test
	public void testNonExistingRequestFile() throws IOException, JAXBException, SAXException {
		String requestFilename = generalRequestRoot +"THAT_FILE_MUST_NOT_EXIST";
		RequestDispatcher dispatcher = new RequestDispatcher(requestFilename);
		dispatcher.dispatch();
		Response responseDoc = getResponseDocForRequest(requestFilename);
		String expectedErrorMessage = "The system cannot find the file specified";
		checkResponseDocForErrorMessage(responseDoc, expectedErrorMessage);
	
		checkResponseDocForNumStringResponses(responseDoc, 0);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}

	@Test
	public void testInvalidXmlDocument() throws JAXBException, SAXException {
		String requestFilename = generalRequestRoot +"NotWellFormedXmlFile.request.xml";
		Response response = getResponseDocForRequest(requestFilename);
		String expectedErrorMessage = "The element type \"validValues\" must be terminated by the matching end-tag \"</validValues>\".";
		checkResponseDocForErrorMessage(response, expectedErrorMessage);

		checkResponseDocForNumStringResponses(response, 0);
		checkResponseDocForNumNumberResponses(response, 0);
		checkResponseDocForNumCollectionResponses(response, 0);
		checkResponseDocForNumStructureResponses(response, 0);
	}
	
	@Test
	public void testWithRequestNotConformToXmlSchema() throws JAXBException, SAXException {
		//fail("Schemas do not yet work - for some reason...");
		String requestFilename = generalRequestRoot +"IllegalRequestFormat.request.xml";
		RequestDispatcher dispatcher = new RequestDispatcher(requestFilename);
		dispatcher.dispatch();
		Response responseDoc = getResponseDocForRequest(requestFilename);
		
		String expectedErrorMessage = "cvc-complex-type.4: Attribute 'maxValues' must appear on element 'string'.";
		checkResponseDocForErrorMessage(responseDoc, expectedErrorMessage);
		
		checkResponseDocForNumStringResponses(responseDoc, 0);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}
	
	@Test
	public void testCloseStringRequest() throws JAXBException, SAXException {
		// load initial request
		String requestFilename = stringRequestRoot + "ValidStringRequest.request.xml";
		Response responseDoc = getResponseDocForRequest(requestFilename);
		
		StringResponse stringResponse = responseDoc.getStringResponses().get(0);
		
		// create second request with close request
		String closeRequestFilename = stringRequestRoot + "CloseStringRequest.request.xml";
		createCloseRequestFileFromResponse(closeRequestFilename, stringResponse);
		// check response to close request
		Response closeRequestResponseDoc = getResponseDocForRequest(closeRequestFilename);
		
		CloseRequestConfirmation closeRequestConfirmation = closeRequestResponseDoc.getCloseRequestConfirmations().get(0);

		String requestId = stringResponse.getId();
		checkCloseRequestConfirmationForId(closeRequestConfirmation, requestId);

		checkResponseDocForErrorResponse(closeRequestResponseDoc, false);
		checkResponseDocForNumStringResponses(closeRequestResponseDoc, 0);
		checkResponseDocForNumNumberResponses(closeRequestResponseDoc, 0);
		checkResponseDocForNumCollectionResponses(closeRequestResponseDoc, 0);
		checkResponseDocForNumStructureResponses(closeRequestResponseDoc, 0);
	}
	
	@Test
	public void testCloseIntegerRequest() throws JAXBException, SAXException {
		// load initial request
		String requestFilename = integerRequestRoot+"ValidIntegerRequest.request.xml";
		Response responseDoc = getResponseDocForRequest(requestFilename);

		NumberResponse<?> numberResponse = responseDoc.getNumberResponses().get(0);
		
		// create second request with close request
		String closeRequestFilename = integerRequestRoot+"CloseIntegerRequest.request.xml";
		createCloseRequestFileFromResponse(closeRequestFilename, numberResponse);
		
		// check response to close request
		Response closeRequestResponseDoc = getResponseDocForRequest(closeRequestFilename);
		
		CloseRequestConfirmation closeRequestConfirmation = closeRequestResponseDoc.getCloseRequestConfirmations().get(0);
		
		String requestName = numberResponse.getName();
		checkCloseRequestConfirmationForName(closeRequestConfirmation, requestName);

		String requestId = numberResponse.getId();
		checkCloseRequestConfirmationForId(closeRequestConfirmation, requestId);

		checkResponseDocForErrorResponse(closeRequestResponseDoc, false);
		checkResponseDocForNumStringResponses(closeRequestResponseDoc, 0);
		checkResponseDocForNumNumberResponses(closeRequestResponseDoc, 0);
		checkResponseDocForNumCollectionResponses(closeRequestResponseDoc, 0);
		checkResponseDocForNumStructureResponses(closeRequestResponseDoc, 0);
	}
	
	@Test
	public void testCloseRequestWithInvalidId() throws JAXBException, SAXException {
		String closeRequestFilename = generalRequestRoot + "CloseRequestInvalidId.request.xml";
		Response responseDoc = getResponseDocForRequest(closeRequestFilename);
		
		CloseRequestConfirmation closeRequestConfirmation = responseDoc.getCloseRequestConfirmations().get(0);
		
		checkCloseRequestConfirmationForId(closeRequestConfirmation, "INVALID_ID");
		
		IllegalRequestFormat illegalRequestFormat = responseDoc.getCloseRequestConfirmations().get(0).getWarnings().getIllegalRequestFormats().get(0);
		checkIllegalRequestFormatForElementAndId(illegalRequestFormat, "closeRequest", "id");

		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumStringResponses(responseDoc, 0);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}
	
	@Test
	public void testContinuedRequestWithInvalidId() throws JAXBException, SAXException {
		String requestFileName = generalRequestRoot + "StringRequestTestInvalidId.request.xml";
		Response responseDoc = getResponseDocForRequest(requestFileName);
		
		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse stringResponse = responseDoc.getStringResponses().get(0);
		
		checkResponseForNumIllegalRequestFormats(stringResponse, 1);
		IllegalRequestFormat illReqFormat = getIllegalRequestFormatFromResponse(stringResponse, 0);
		
		checkIllegalRequestFormatForElementAndId(illReqFormat, "string", "id");
		
		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}

	@Test
	public void testWithNumberRequestWithInvalidParameter() throws JAXBException, SAXException {
		String requestFilename = integerRequestRoot+ "IntegerRequestInvalidParameter.request.xml";
		Response responseDoc = getResponseDocForRequest(requestFilename);
		
		checkResponseDocForNumNumberResponses(responseDoc, 1);
		NumberResponse<?> numberResponse = responseDoc.getNumberResponses().get(0);

		checkResponseForNumOperatorParts(numberResponse, 1);
		OperatorSpecificFuzzedValues<?> operatorPart = getOperatorPartFromNumberResponseByName(numberResponse, "NumericalVariance", "10");
		checkOperatorPartForNumFuzzedValues(operatorPart, 20);
		checkResponseForWarningsPart(numberResponse, false);

		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumStringResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}
	
	
}
