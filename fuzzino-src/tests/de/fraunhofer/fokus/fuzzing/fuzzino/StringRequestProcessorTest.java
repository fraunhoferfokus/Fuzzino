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

import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkGeneratorPartForNumFuzzedValues;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkOperatorPartForNumFuzzedValues;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForErrorResponse;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumCollectionResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumNumberResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumStringResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumStructureResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForMinNumGeneratorParts;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForMoreValuesAttribute;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForNoMoreValuesWarning;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForNumGeneratorParts;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForNumOperatorParts;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForSeedValue;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForWarningsPart;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.compareTwoSequences;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.createContdRequest;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getGeneratorPartFromResponseByName;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getOperatorPartFromNumberResponseByName;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getResponseDocForRequest;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGeneratorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.StringOperatorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Request;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringEncoding;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.GeneratorImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.OperatorImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringRequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringSpecificationImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.GeneratorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.OperatorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Response;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class StringRequestProcessorTest extends FuzzinoTest {

	private static final long SEED = 4711;
	private static final String NO_PARAM = null;
	private static final StringSpecification STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
	protected StringRequestProcessor reqProc;
	
	public static final int MIN_LENGTH = 2;
	public static final int MAX_LENGTH = 5;
	
	private static String stringRootDir = "testdata/reworked/stringRequests/";
	
	@Before
	public void init() throws Exception {
		Request request = RequestImpl.unmarshall(new File(stringRootDir + "validStringRequest.request.xml"));
		StringRequest stringRequest = request.getStringRequests().get(0);
		reqProc = new StringRequestProcessor(stringRequest, UUID.randomUUID());
	}

	@Test
	public void testGenerators() {
		int expectedNumOfHeuristics = 2;
		int actualNumOfHeuristics = reqProc.getAllFuzzingHeuristics().size();
		assertTrue("Invalid number of generators: was "+ actualNumOfHeuristics + " instead of " + expectedNumOfHeuristics,
				actualNumOfHeuristics == expectedNumOfHeuristics);
		String expectedGeneratorName = "BadStrings";
		ComputableFuzzingHeuristic<?> heuristic = reqProc.getAllFuzzingHeuristics().get(0);
		String actualGeneratorName = heuristic.getName();
		assertTrue("Invalid generator: was " + actualGeneratorName + " instead of " + expectedGeneratorName,
				actualGeneratorName.equals(expectedGeneratorName));
	}

	@Test
	public void testOperators() {
		int expectedNumOfOps = 2;
		int actualNumOfOps = reqProc.getAllFuzzingHeuristics().size();
		assertTrue("Invalid number of operators: was " + actualNumOfOps + " instead of " + expectedNumOfOps,
				actualNumOfOps == expectedNumOfOps);
		String expectedOperatorName = "StringCase";
		ComputableFuzzingHeuristic<String> heuristic = (ComputableFuzzingHeuristic<String>) reqProc.getAllFuzzingHeuristics().get(1);
		String actualOperatorName = heuristic.getName();
		assertTrue("Invalid operator: was " + actualOperatorName + " instead of " + expectedOperatorName,
				expectedOperatorName.equals(actualOperatorName));
	}

	@Test
	public void testValues() throws UnknownFuzzingHeuristicException {
		int expectedNumOfValues = StringGeneratorFactory.INSTANCE.create("BadStrings", NO_PARAM, STRING_SPEC, SEED).size()
				+ StringOperatorFactory.INSTANCE.create("StringCase", StringUtil.asList("ABC"), NO_PARAM, STRING_SPEC, SEED).size();

		int actualNumOfValues = 0;
		for (FuzzedValue<String> fuzzedValue : reqProc) {
			assertTrue("At index " +  actualNumOfValues + ": fuzzedValue is null", fuzzedValue != null);
			actualNumOfValues++;
		}

		assertTrue("Invalid number of values: was " + actualNumOfValues + " instead of " + expectedNumOfValues,
				actualNumOfValues == expectedNumOfValues);
	}
	
	@Test
	public void testWithValidStringRequest() throws JAXBException, SAXException {
		String requestFilename = stringRootDir + "validStringRequest.request.xml";
		Response responseDoc = getResponseDocForRequest(requestFilename);
		
		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse stringResponse = responseDoc.getStringResponses().get(0);
		checkResponseForNumGeneratorParts(stringResponse, 1);
		
		GeneratorSpecificFuzzedValues<String> generatorPart = getGeneratorPartFromResponseByName(stringResponse, "BadStrings");
		checkGeneratorPartForNumFuzzedValues(generatorPart, 47);
		
		checkResponseForNumOperatorParts(stringResponse, 1);

		OperatorSpecificFuzzedValues<String> operatorPart = getOperatorPartFromNumberResponseByName(stringResponse, "StringCase", "ABC");
		checkOperatorPartForNumFuzzedValues(operatorPart, 3);
		
		checkResponseForWarningsPart(stringResponse, false);
		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}
	
	@Test
	public void testValidRequestWithEncodeAllCharacters() throws JAXBException, SAXException {
		String requestFilename = stringRootDir + "validStringRequest.request.xml";
		Response responseDoc = getResponseDocForRequest(requestFilename, true);
		
		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse stringResponse = responseDoc.getStringResponses().get(0);
		checkResponseForNumGeneratorParts(stringResponse, 1);
		
		GeneratorSpecificFuzzedValues<String> generatorPart = getGeneratorPartFromResponseByName(stringResponse, "BadStrings");
		checkGeneratorPartForNumFuzzedValues(generatorPart, 47);
		
		checkResponseForNumOperatorParts(stringResponse, 1);

		OperatorSpecificFuzzedValues<String> operatorPart = getOperatorPartFromNumberResponseByName(stringResponse, "StringCase", "ABC");
		checkOperatorPartForNumFuzzedValues(operatorPart, 3);
		
		checkResponseForWarningsPart(stringResponse, false);
		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}
	
	@Test
	public void testContinuedStringRequest() throws JAXBException, SAXException {
		// load initial request
		String requestFilename = stringRootDir + "validStringRequest.request.xml";
		Response responseDoc = getResponseDocForRequest(requestFilename);

		StringResponse stringResponse = responseDoc.getStringResponses().get(0);
		
		// create second request continuing the first one
		String contdRequestFilename = stringRootDir + "ValidStringRequestContinued.request.xml";
		int expectedNumOfContdFuzzedValues = 5;
		createContdRequest(stringResponse, contdRequestFilename, expectedNumOfContdFuzzedValues);

		// check response doc
		Response contdResponse = getResponseDocForRequest(contdRequestFilename);

		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse contdStringResponse = contdResponse.getStringResponses().get(0);

		checkResponseForNumGeneratorParts(contdStringResponse, 1);
		GeneratorSpecificFuzzedValues<String> contdGeneratorPart = getGeneratorPartFromResponseByName(contdStringResponse, "BadStrings");;
		checkGeneratorPartForNumFuzzedValues(contdGeneratorPart, expectedNumOfContdFuzzedValues);
		
		checkResponseForNumOperatorParts(contdStringResponse, 0);
		checkResponseForWarningsPart(contdStringResponse, false);

		checkResponseDocForErrorResponse(contdResponse, false);
		checkResponseDocForNumNumberResponses(contdResponse, 0);
		checkResponseDocForNumCollectionResponses(contdResponse, 0);
		checkResponseDocForNumStructureResponses(contdResponse, 0);
	}
	
	@Test
	public void testContinuedStringRequestWithMoreValuesRequestedThanAvailable() throws UnknownFuzzingHeuristicException, JAXBException, SAXException {
		// load initial request
		String requestFileName = stringRootDir + "StringRequestSmallGenerator.request.xml";
		Response responseDoc = getResponseDocForRequest(requestFileName);

		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse stringResponse = responseDoc.getStringResponses().get(0);
		
		checkResponseForMoreValuesAttribute(stringResponse, false);
		
		checkResponseForNumGeneratorParts(stringResponse, 1);
		
		String generatorName = "SmallGenerator";
		GeneratorSpecificFuzzedValues<String> generatorPart = getGeneratorPartFromResponseByName(stringResponse, generatorName);
		StringGenerator smallGenerator = StringGeneratorFactory.INSTANCE.create(generatorName, NO_PARAM, STRING_SPEC, SEED); 
		checkGeneratorPartForNumFuzzedValues(generatorPart, smallGenerator.size());

		checkResponseForNumOperatorParts(stringResponse, 0);
		checkResponseForWarningsPart(stringResponse, false);

		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);

		// create second request continuing the first one
		String contdRequestFilename = stringRootDir + "StringRequestSmallGeneratorContinued.request.xml";
		int requestedNumFuzzedValuesContinued = 5;
		createContdRequest(stringResponse, contdRequestFilename, requestedNumFuzzedValuesContinued);
		Response contdResponseDoc = getResponseDocForRequest(contdRequestFilename);
		
		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse contdStringResponse = contdResponseDoc.getStringResponses().get(0);
		
		checkResponseForMoreValuesAttribute(contdStringResponse, false);
		
		checkResponseForNumGeneratorParts(contdStringResponse, 0);
		checkResponseForNumOperatorParts(contdStringResponse, 0);
		checkResponseForNoMoreValuesWarning(contdStringResponse);
		
		checkResponseDocForErrorResponse(contdResponseDoc, false);
		checkResponseDocForNumNumberResponses(contdResponseDoc, 0);
		checkResponseDocForNumCollectionResponses(contdResponseDoc, 0);
		checkResponseDocForNumStructureResponses(contdResponseDoc, 0);
	}
	
	@Test
	public void testTwoRunsOfSameStringRequestWithSeed() throws JAXBException, SAXException {
		String generatorName = "SmallGenerator";
		String operatorName = "StringCase";
		String validValue = "ABCDEFGHIJKLMNOPQRST";
		long expectedSeed = 500000;
		int expectedNumOfFuzzedValues = 3;
		
		List<FuzzedValue<String>> fuzzedValuesFromFirstRun;
		List<FuzzedValue<String>> fuzzedValuesFromSecondRun;
		
		String requestFileName = stringRootDir + "ValidRequestWithSeed.request.xml";
		
		// first run
		Response responseDocFromFirstRun = getResponseDocForRequest(requestFileName);

		checkResponseDocForNumStringResponses(responseDocFromFirstRun, 1);
		StringResponse stringResponseFirstRun = responseDocFromFirstRun.getStringResponses().get(0);
		checkResponseForSeedValue(stringResponseFirstRun, expectedSeed);
		
		checkResponseForNumGeneratorParts(stringResponseFirstRun, 1);
		GeneratorSpecificFuzzedValues<String> generatorPartFirstRun = getGeneratorPartFromResponseByName(stringResponseFirstRun, generatorName);
		checkGeneratorPartForNumFuzzedValues(generatorPartFirstRun, 10);
		checkResponseForNumOperatorParts(stringResponseFirstRun, 1);
		OperatorSpecificFuzzedValues<String> operatorPartFirstRun = getOperatorPartFromNumberResponseByName(stringResponseFirstRun, operatorName, validValue);
		checkOperatorPartForNumFuzzedValues(operatorPartFirstRun, expectedNumOfFuzzedValues);
		checkResponseForWarningsPart(stringResponseFirstRun, false);
		
		checkResponseDocForErrorResponse(responseDocFromFirstRun, false);
		checkResponseDocForNumNumberResponses(responseDocFromFirstRun, 0);
		checkResponseDocForNumCollectionResponses(responseDocFromFirstRun, 0);
		checkResponseDocForNumStructureResponses(responseDocFromFirstRun, 0);
		
		fuzzedValuesFromFirstRun = operatorPartFirstRun.getFuzzedValues();

		// second run
		Response responseDocFromSecondRun = getResponseDocForRequest(requestFileName);

		checkResponseDocForNumStringResponses(responseDocFromSecondRun, 1);
		StringResponse stringResponseSecondRun = responseDocFromSecondRun.getStringResponses().get(0);
		checkResponseForSeedValue(stringResponseSecondRun, expectedSeed);
		
		checkResponseForNumGeneratorParts(stringResponseSecondRun, 1);
		GeneratorSpecificFuzzedValues<String> generatorPartSecondRun = getGeneratorPartFromResponseByName(stringResponseSecondRun, generatorName);
		checkGeneratorPartForNumFuzzedValues(generatorPartSecondRun, 10);
		checkResponseForNumOperatorParts(stringResponseSecondRun, 1);
		OperatorSpecificFuzzedValues<String> operatorPartSecondRun = getOperatorPartFromNumberResponseByName(stringResponseSecondRun, operatorName, validValue);
		checkOperatorPartForNumFuzzedValues(operatorPartSecondRun, expectedNumOfFuzzedValues);
		checkResponseForWarningsPart(stringResponseSecondRun, false);
		
		checkResponseDocForErrorResponse(responseDocFromSecondRun, false);
		checkResponseDocForNumNumberResponses(responseDocFromSecondRun, 0);
		checkResponseDocForNumCollectionResponses(responseDocFromSecondRun, 0);
		checkResponseDocForNumStructureResponses(responseDocFromSecondRun, 0);
		
		fuzzedValuesFromSecondRun = operatorPartFirstRun.getFuzzedValues();
		
		compareTwoSequences(fuzzedValuesFromFirstRun, fuzzedValuesFromSecondRun);
	}
	
	@Test
	public void testMatchesLength() throws JAXBException, SAXException {
		String requestFilename = stringRootDir + "StringRequestTestMatchesLength.request.xml";
		Response responseDoc = getResponseDocForRequest(requestFilename);
		
		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse stringResponse = responseDoc.getStringResponses().get(0);
		checkResponseForNumGeneratorParts(stringResponse, 1);
		
		GeneratorSpecificFuzzedValues<String> generatorPart = getGeneratorPartFromResponseByName(stringResponse, "SmallGenerator");
		List<FuzzedValue<String>> fuzzedValues = generatorPart.getFuzzedValues();
		for (FuzzedValue<String> fuzzValue : fuzzedValues) {
			String value = fuzzValue.getValue();
			int actualLength = value.length();
			
			assertTrue("Wrong length: was too short  " + actualLength + " < MIN_LENGTH(" + MIN_LENGTH + ")",
					   actualLength >= MIN_LENGTH);

			assertTrue("Wrong length: was too long  " + actualLength + " > MAX_LENGTH(" + MAX_LENGTH + ")",
					   actualLength <= MAX_LENGTH);
		}
		checkGeneratorPartForNumFuzzedValues(generatorPart, 4);
		
		checkResponseForNumOperatorParts(stringResponse, 0);
		checkResponseForWarningsPart(stringResponse, false);
		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}

	@Test
	public void testIgnoringLength() throws JAXBException, SAXException {
		String requestFilename = stringRootDir + "StringRequestTestIgnoringLength.request.xml";
		Response responseDoc = getResponseDocForRequest(requestFilename);
		
		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse stringResponse = responseDoc.getStringResponses().get(0);

		checkResponseForNumGeneratorParts(stringResponse, 1);
		
		GeneratorSpecificFuzzedValues<String> generatorPart = getGeneratorPartFromResponseByName(stringResponse, "LongStrings");
		checkGeneratorPartForNumFuzzedValues(generatorPart, 50);
		
		checkResponseForNumOperatorParts(stringResponse, 0);
		checkResponseForWarningsPart(stringResponse, false);
		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}
	
	@Test
	public void testAllGeneratorsOneOperator() throws JAXBException, SAXException {
		String requestFilename = stringRootDir + "ValidRequestAllGeneratorsOneOperator.request.xml";
		Response responseDoc = getResponseDocForRequest(requestFilename);
		
		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse stringResponse = responseDoc.getStringResponses().get(0);

		checkResponseForMinNumGeneratorParts(stringResponse, 1);
		checkResponseForNumOperatorParts(stringResponse, 1);
		
		checkResponseForWarningsPart(stringResponse, false);
		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}

}
