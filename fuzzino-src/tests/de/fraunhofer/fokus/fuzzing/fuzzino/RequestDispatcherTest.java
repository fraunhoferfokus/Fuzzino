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

import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.assertTrueWithPrefix;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkCloseRequestConfirmationForId;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkCloseRequestConfirmationForName;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkGeneratorPartForNumFuzzedValues;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkIllegalRequestFormatForElementAndId;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkIllegalRequestFormatForMissingElement;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkOperatorPartForNumFuzzedValues;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForErrorMessage;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForErrorResponse;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumCollectionResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumNumberResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumStringResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumStructureResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForNumGeneratorParts;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForNumIllegalRequestFormats;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForNumOperatorParts;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForWarningsPart;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.createCloseRequestFileFromResponse;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getCloseRequestConfirmationFromResponseDoc;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getGeneratorPartFromResponseByName;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getIllegalRequestFormatFromCloseRequestConfirmation;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getIllegalRequestFormatFromResponse;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getNumberResponseFromResponseDoc;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getOperatorPartFromNumberResponseByName;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getOperatorPartFromResponseByName;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getResponseDocForRequest;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getResponseDocForRequestString;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getStringResponseFromResponseDoc;

import java.io.IOException;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument;

public class RequestDispatcherTest extends FuzzinoTest {
	
	@Test
	public void testNonExistingRequestFile() throws IOException {
		String requestFilename = "./testdata/general/THAT_FILE_MUST_NOT_EXIST";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
		String expectedErrorMessage = "The system cannot find the file specified";
		checkResponseDocForErrorMessage(responseDoc, expectedErrorMessage);
	
		checkResponseDocForNumStringResponses(responseDoc, 0);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}

	@Test
	public void testInvalidXmlDocument() {
		String requestFilename = "./testdata/general/NotWellFormedXmlFile.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
		String expectedErrorMessage = "The element type \"validValues\" must be terminated by the matching end-tag \"</validValues>\".";
		checkResponseDocForErrorMessage(responseDoc, expectedErrorMessage);

		checkResponseDocForNumStringResponses(responseDoc, 0);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}

	@Test
	public void testWithFilenameEqualToUsualResponseFilename() {
		// try to load request file that would have the same name as the response file to be created
		String requestFilename = "./testdata/general/ResponseExtensionForRequest.response.xml";
		// check if response file exists having the filename ".response.xml" appended to the request filename
		getResponseDocForRequest(requestFilename);
	}
	
	@Test
	public void testWithRequestNotConformToXmlSchema() {
		String requestFilename = "./testdata/general/IllegalRequestFormat.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
		String expectedErrorMessage = "Feature 'generator' not found.";
		checkResponseDocForErrorMessage(responseDoc, expectedErrorMessage);
		
		checkResponseDocForNumStringResponses(responseDoc, 0);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}
	
	@Test
	public void testCloseStringRequest() {
		// load initial request
		String requestFilename = "./testdata/stringRequests/ValidStringRequest.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);

		StringResponse stringResponse = getStringResponseFromResponseDoc(responseDoc, 0);
		
		// create second request with close request
		String closeRequestFilename = "./testdata/stringRequests/CloseStringRequest.request.xml";
		createCloseRequestFileFromResponse(closeRequestFilename, stringResponse);
		
		// check response to close request
		XmlResponseDocument closeRequestResponseDoc = getResponseDocForRequest(closeRequestFilename);
		
		CloseRequestConfirmation closeRequestConfirmation = getCloseRequestConfirmationFromResponseDoc(closeRequestResponseDoc, 0);
		
		String requestName = stringResponse.getName();
		checkCloseRequestConfirmationForName(closeRequestConfirmation, requestName);

		String requestId = stringResponse.getId();
		checkCloseRequestConfirmationForId(closeRequestConfirmation, requestId);

		checkResponseDocForErrorResponse(closeRequestResponseDoc, false);
		checkResponseDocForNumStringResponses(closeRequestResponseDoc, 0);
		checkResponseDocForNumNumberResponses(closeRequestResponseDoc, 0);
		checkResponseDocForNumCollectionResponses(closeRequestResponseDoc, 0);
		checkResponseDocForNumStructureResponses(closeRequestResponseDoc, 0);
	}
	
	@Test
	public void testCloseIntegerRequest() {
		// load initial request
		String requestFilename = "./testdata/numberRequests/ValidIntegerRequest.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);

		NumberResponse numberResponse = getNumberResponseFromResponseDoc(responseDoc, 0);
		
		// create second request with close request
		String closeRequestFilename = "./testdata/numberRequests/CloseIntegerRequest.request.xml";
		createCloseRequestFileFromResponse(closeRequestFilename, numberResponse);
		
		// check response to close request
		XmlResponseDocument closeRequestResponseDoc = getResponseDocForRequest(closeRequestFilename);
		
		CloseRequestConfirmation closeRequestConfirmation = getCloseRequestConfirmationFromResponseDoc(closeRequestResponseDoc, 0);
		
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
	public void testCloseRequestWithInvalidId() {
		String closeRequestFilename = "./testdata/general/CloseRequestInvalidId.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(closeRequestFilename);
		
		CloseRequestConfirmation closeRequestConfirmation = getCloseRequestConfirmationFromResponseDoc(responseDoc, 0);
		
		checkCloseRequestConfirmationForId(closeRequestConfirmation, "INVALID_ID");
		
		IllegalRequestFormat illegalRequestFormat = getIllegalRequestFormatFromCloseRequestConfirmation(closeRequestConfirmation, 0);
		checkIllegalRequestFormatForElementAndId(illegalRequestFormat, "closeRequest", "id");

		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumStringResponses(responseDoc, 0);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}
	
	@Test
	public void testContinuedRequestWithInvalidId() {
		String requestFileName = "./testdata/general/StringRequestTestInvalidId.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFileName);
		
		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse stringResponse = getStringResponseFromResponseDoc(responseDoc, 0);
		
		checkResponseForNumIllegalRequestFormats(stringResponse, 1);
		IllegalRequestFormat illReqFormat = getIllegalRequestFormatFromResponse(stringResponse, 0);
		
		checkIllegalRequestFormatForElementAndId(illReqFormat, "string", "id");
		
		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}
	
	@Test
	public void testWithNumberRequestWithMissingSpecification() {
		String requestFilename = "./testdata/NumberRequests/IntegerRequestMissingSpecification.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
		checkResponseDocForNumNumberResponses(responseDoc, 1);
		NumberResponse numberResponse = getNumberResponseFromResponseDoc(responseDoc, 0);
		
		checkResponseForNumIllegalRequestFormats(numberResponse, 1);
		IllegalRequestFormat illegalRequestFormat = getIllegalRequestFormatFromResponse(numberResponse, 0);
		checkIllegalRequestFormatForMissingElement(illegalRequestFormat, "specification");
		
		checkResponseForNumGeneratorParts(numberResponse, 0);
		checkResponseForNumOperatorParts(numberResponse, 0);
		
		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumStringResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}
	
	@Test
	public void testWithNumberRequestWithInvalidParameter() {
		String requestFilename = "./testdata/NumberRequests/IntegerRequestInvalidParameter.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
		checkResponseDocForNumNumberResponses(responseDoc, 1);
		NumberResponse numberResponse = getNumberResponseFromResponseDoc(responseDoc, 0);
		
		assertTrueWithPrefix("No seed in response.",
				   numberResponse.getSeed() != null);

		checkResponseForNumGeneratorParts(numberResponse, 0);
		checkResponseForNumOperatorParts(numberResponse, 1);
		OperatorPart operatorPart = getOperatorPartFromNumberResponseByName(numberResponse, "NumericalVariance", "10");
		checkOperatorPartForNumFuzzedValues(operatorPart, 20);
		checkResponseForWarningsPart(numberResponse, false);

		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumStringResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}
	
	@Test
	public void testWithValidXmlString() {
		String xmlRequest = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
				"<request xmlns=\"http://fuzzino.fuzzing.fokus.fraunhofer.de/request\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n\t" +
				"xsi:schemaLocation=\"http://fuzzino.fuzzing.fokus.fraunhofer.de/request\">\n\n" +
				"<string name=\"ValidRequest_STRING\" maxValues=\"50\">\n\t" +
				"<specification minLength=\"1\" maxLength=\"5\" nullTerminated=\"true\" encoding=\"UTF8\">MySpec</specification>\n\t" +
				"<generator>BadStrings</generator>\n\t" +
				"<validValues>\n\t\t" +
				"<value>ABC</value>\n\t\t" +
				"<operator>StringCase</operator>\n\t" +
				"</validValues>\n" +
				"</string>\n\n" +
				"</request>";
		XmlResponseDocument responseDoc = getResponseDocForRequestString(xmlRequest);
		
		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse stringResponse = getStringResponseFromResponseDoc(responseDoc, 0);

		assertTrueWithPrefix("No seed in response.",
				   stringResponse.getSeed() != null);

		checkResponseForNumGeneratorParts(stringResponse, 1);
		
		GeneratorPart generatorPart = getGeneratorPartFromResponseByName(stringResponse, "BadStrings");
		checkGeneratorPartForNumFuzzedValues(generatorPart, 47);
		
		checkResponseForNumOperatorParts(stringResponse, 1);

		OperatorPart operatorPart = getOperatorPartFromResponseByName(stringResponse, "StringCase", "ABC");
		checkOperatorPartForNumFuzzedValues(operatorPart, 3);
		
		checkResponseForWarningsPart(stringResponse, false);
		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}
	
}
