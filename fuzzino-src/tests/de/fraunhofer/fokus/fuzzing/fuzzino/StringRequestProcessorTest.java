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
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getOperatorPartFromResponseByName;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getResponseDocForRequest;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getStringResponseFromResponseDoc;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.loadRequestFile;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGeneratorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.StringOperatorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class StringRequestProcessorTest {

	private static final long SEED = 4711;
	private static final String NO_PARAM = null;
	private static final StringSpecification STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
	protected StringRequestProcessor reqProc;
	
	public static final int MIN_LENGTH = 2;
	public static final int MAX_LENGTH = 5;

	
	@Before
	public void init() throws Exception {
		XmlRequestDocument request = loadRequestFile("./testdata/stringRequests/ValidStringRequest.request.xml");
		if (request != null) {
			de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest stringRequestEMF = request.getRequest().getStringRequests().get(0);
			StringRequest stringRequest = RequestFactory.INSTANCE.createStringRequest(stringRequestEMF);
			reqProc = new StringRequestProcessor(stringRequest, UUID.randomUUID());
		} else {
			throw new Exception("Request file could not be loaded.");
		}
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
	public void testWithValidStringRequest() {
		String requestFilename = "./testdata/general/ValidRequest.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
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
	
	@Test
	public void testValidRequestWithEncodeAllCharacters() {
		String requestFilename = "./testdata/general/ValidRequest.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename, true);
		
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
	
	@Test
	public void testContinuedStringRequest() {
		// load initial request
		String requestFilename = "./testdata/stringRequests/ValidStringRequest.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);

		StringResponse stringResponse = getStringResponseFromResponseDoc(responseDoc, 0); 
		
		// create second request continuing the first one
		String contdRequestFilename = "./testdata/stringRequests/ValidStringRequestContinued.request.xml";
		int expectedNumOfContdFuzzedValues = 5;
		createContdRequest(stringResponse, contdRequestFilename, expectedNumOfContdFuzzedValues);

		// check response doc
		XmlResponseDocument contdResponse = getResponseDocForRequest(contdRequestFilename);

		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse contdStringResponse = getStringResponseFromResponseDoc(contdResponse, 0);

		checkResponseForNumGeneratorParts(contdStringResponse, 1);
		GeneratorPart contdGeneratorPart = getGeneratorPartFromResponseByName(contdStringResponse, "BadStrings");;
		checkGeneratorPartForNumFuzzedValues(contdGeneratorPart, expectedNumOfContdFuzzedValues);
		
		checkResponseForNumOperatorParts(contdStringResponse, 0);
		checkResponseForWarningsPart(contdStringResponse, false);

		checkResponseDocForErrorResponse(contdResponse, false);
		checkResponseDocForNumNumberResponses(contdResponse, 0);
		checkResponseDocForNumCollectionResponses(contdResponse, 0);
		checkResponseDocForNumStructureResponses(contdResponse, 0);
	}
	
	@Test
	public void testContinuedStringRequestWithMoreValuesRequestedThanAvailable() throws UnknownFuzzingHeuristicException {
		// load initial request
		String requestFileName = "./testdata/general/StringRequestSmallGenerator.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFileName);

		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse stringResponse = getStringResponseFromResponseDoc(responseDoc, 0);
		
		checkResponseForMoreValuesAttribute(stringResponse, false);
		
		checkResponseForNumGeneratorParts(stringResponse, 1);
		
		String generatorName = "SmallGenerator";
		GeneratorPart generatorPart = getGeneratorPartFromResponseByName(stringResponse, generatorName);
		StringGenerator smallGenerator = StringGeneratorFactory.INSTANCE.create(generatorName, NO_PARAM, STRING_SPEC, SEED); 
		checkGeneratorPartForNumFuzzedValues(generatorPart, smallGenerator.size());

		checkResponseForNumOperatorParts(stringResponse, 0);
		checkResponseForWarningsPart(stringResponse, false);

		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);

		// create second request continuing the first one
		String contdRequestFilename = "./testdata/stringRequests/StringRequestSmallGeneratorContinued.request.xml";
		int requestedNumFuzzedValuesContinued = 5;
		createContdRequest(stringResponse, contdRequestFilename, requestedNumFuzzedValuesContinued);
		XmlResponseDocument contdResponseDoc = getResponseDocForRequest(contdRequestFilename);
		
		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse contdStringResponse = getStringResponseFromResponseDoc(contdResponseDoc, 0);
		
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
	public void testTwoRunsOfSameStringRequestWithSeed() {
		String generatorName = "SmallGenerator";
		String operatorName = "StringCase";
		String validValue = "ABCDEFGHIJKLMNOPQRST";
		String expectedSeed = "500000";
		int expectedNumOfFuzzedValues = 3;
		
		List<String> fuzzedValuesFromFirstRun;
		List<String> fuzzedValuesFromSecondRun;
		
		String requestFileName = "./testdata/general/ValidRequestWithSeed.request.xml";
		
		// first run
		XmlResponseDocument responseDocFromFirstRun = getResponseDocForRequest(requestFileName);

		checkResponseDocForNumStringResponses(responseDocFromFirstRun, 1);
		StringResponse stringResponseFirstRun = getStringResponseFromResponseDoc(responseDocFromFirstRun, 0);
		checkResponseForSeedValue(stringResponseFirstRun, expectedSeed);
		
		checkResponseForNumGeneratorParts(stringResponseFirstRun, 1);
		GeneratorPart generatorPartFirstRun =
				getGeneratorPartFromResponseByName(stringResponseFirstRun, generatorName);
		checkGeneratorPartForNumFuzzedValues(generatorPartFirstRun, 10);
		checkResponseForNumOperatorParts(stringResponseFirstRun, 1);
		OperatorPart operatorPartFirstRun = 
				getOperatorPartFromResponseByName(stringResponseFirstRun, operatorName, validValue);
		checkOperatorPartForNumFuzzedValues(operatorPartFirstRun, expectedNumOfFuzzedValues);
		checkResponseForWarningsPart(stringResponseFirstRun, false);
		
		checkResponseDocForErrorResponse(responseDocFromFirstRun, false);
		checkResponseDocForNumNumberResponses(responseDocFromFirstRun, 0);
		checkResponseDocForNumCollectionResponses(responseDocFromFirstRun, 0);
		checkResponseDocForNumStructureResponses(responseDocFromFirstRun, 0);
		
		fuzzedValuesFromFirstRun = operatorPartFirstRun.getFuzzedValues();

		// second run
		XmlResponseDocument responseDocFromSecondRun = getResponseDocForRequest(requestFileName);

		checkResponseDocForNumStringResponses(responseDocFromSecondRun, 1);
		StringResponse stringResponseSecondRun = getStringResponseFromResponseDoc(responseDocFromSecondRun, 0);
		checkResponseForSeedValue(stringResponseSecondRun, expectedSeed);
		
		checkResponseForNumGeneratorParts(stringResponseSecondRun, 1);
		GeneratorPart generatorPartSecondRun =
				getGeneratorPartFromResponseByName(stringResponseSecondRun, generatorName);
		checkGeneratorPartForNumFuzzedValues(generatorPartSecondRun, 10);
		checkResponseForNumOperatorParts(stringResponseSecondRun, 1);
		OperatorPart operatorPartSecondRun = 
				getOperatorPartFromResponseByName(stringResponseSecondRun, operatorName, validValue);
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
	public void testMatchesLength() {
		String requestFilename = "./testdata/stringRequests/StringRequestTestMatchesLength.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse stringResponse = getStringResponseFromResponseDoc(responseDoc, 0);

		assertTrueWithPrefix("No seed in response.",
				   stringResponse.getSeed() != null);

		checkResponseForNumGeneratorParts(stringResponse, 1);
		
		GeneratorPart generatorPart = getGeneratorPartFromResponseByName(stringResponse, "SmallGenerator");
		List<String> fuzzedValues = generatorPart.getFuzzedValues();
		for (String value : fuzzedValues) {
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
	public void testIgnoringLength() {
		String requestFilename = "./testdata/stringRequests/StringRequestTestIgnoringLength.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse stringResponse = getStringResponseFromResponseDoc(responseDoc, 0);

		assertTrueWithPrefix("No seed in response.",
				   stringResponse.getSeed() != null);

		checkResponseForNumGeneratorParts(stringResponse, 1);
		
		GeneratorPart generatorPart = getGeneratorPartFromResponseByName(stringResponse, "LongStrings");
		checkGeneratorPartForNumFuzzedValues(generatorPart, 50);
		
		checkResponseForNumOperatorParts(stringResponse, 0);
		checkResponseForWarningsPart(stringResponse, false);
		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}
	
	@Test
	public void testAllGeneratorsOneOperator() {
		String requestFilename = "./testdata/general/ValidRequestAllGeneratorsOneOperator.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
		checkResponseDocForNumStringResponses(responseDoc, 1);
		StringResponse stringResponse = getStringResponseFromResponseDoc(responseDoc, 0);

		checkResponseForMinNumGeneratorParts(stringResponse, 1);
		checkResponseForNumOperatorParts(stringResponse, 1);
		
		checkResponseForWarningsPart(stringResponse, false);
		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumNumberResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}

}
