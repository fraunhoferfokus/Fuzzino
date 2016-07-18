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
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumStringResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumStructureResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForMoreValuesAttribute;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForNoMoreValuesWarning;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForNumGeneratorParts;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForNumIllegalGenerators;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForNumIllegalOperators;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForNumIllegalRequestFormats;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForNumOperatorParts;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForWarningsPart;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.createContdRequest;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getGeneratorPartFromResponseByName;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getNumberResponseFromResponseDoc;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getOperatorPartFromNumberResponseByName;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getResponseDocForRequest;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.loadRequestFile;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.IntegerGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.IntegerGeneratorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.IntegerOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.IntegerOperatorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument;

public class IntegerRequestProcessorTest extends FuzzinoTest {

	private static final long SEED = 4711;
	private static final String NO_PARAM = null;
	private static final IntegerSpecification NUMBER_SPEC = RequestFactory.INSTANCE.createNumberSpecification();
	static {
		NUMBER_SPEC.setBits(32);
		NUMBER_SPEC.setIsSigned(true);
	}
	protected IntegerRequestProcessor reqProc;

	@Before
	public void init() throws Exception {
		XmlRequestDocument request = loadRequestFile("./testdata/NumberRequests/ValidIntegerRequest.request.xml");
		if (request != null) {
			de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest numberRequestEMF = 
					request.getRequest().getNumberRequests().get(0);
			NumberRequest numberRequest = RequestFactory.INSTANCE.createNumberRequest(numberRequestEMF);
			reqProc = new IntegerRequestProcessor(numberRequest, UUID.randomUUID());
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
		String expectedGeneratorName = "BoundaryNumbers";
		ComputableFuzzingHeuristic<?> heuristic = reqProc.getAllFuzzingHeuristics().get(0);
		String actualGeneratorName = heuristic.getName();
		assertTrue("Invalid generator: was " + actualGeneratorName + " instead of " + expectedGeneratorName,
				actualGeneratorName.equals(expectedGeneratorName));
	}
	
	@Test
	public void testOperators() {
		int expectedNumOfHeuristics = 2;
		int actualNumOfHeuristics = reqProc.getAllFuzzingHeuristics().size();
		assertTrue("Invalid number of operators: was " + actualNumOfHeuristics + " instead of " + expectedNumOfHeuristics,
				actualNumOfHeuristics == expectedNumOfHeuristics);
		String expectedOperatorName = "NumericalVariance";
		ComputableFuzzingHeuristic<?> heuristic = reqProc.getAllFuzzingHeuristics().get(1);
		String actualOperatorName = heuristic.getName();
		assertTrue("Invalid operator: was " + actualOperatorName + " instead of " + expectedOperatorName,
				expectedOperatorName.equals(actualOperatorName));
	}
	
	@Test
	public void testValues() throws UnknownFuzzingHeuristicException {
		List<Long> listOfLongs = new LinkedList<>();
		listOfLongs.add(10L);
		IntegerGenerator badNumbers = IntegerGeneratorFactory.INSTANCE.create("BoundaryNumbers", NO_PARAM, NUMBER_SPEC, SEED);
		IntegerOperator numericalVariance = IntegerOperatorFactory.INSTANCE.create("NumericalVariance", listOfLongs, "10", null, SEED);
		
		int expectedNumOfValues = badNumbers.size() + numericalVariance.size();
		int actualNumOfValues = reqProc.size();
		assertTrue("Invalid number of values: was " + actualNumOfValues + " instead of " + expectedNumOfValues,
				   actualNumOfValues == expectedNumOfValues);
	}

	@Test
	public void testValidIntegerRequest() {
		String requestFilename = "./testdata/NumberRequests/ValidIntegerRequest.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
		NumberResponse numberResponse = getNumberResponseFromResponseDoc(responseDoc, 0);
		
		assertTrueWithPrefix("No seed in response.",
				   numberResponse.getSeed() != null);

		checkResponseForNumGeneratorParts(numberResponse, 1);
		GeneratorPart generatorPart = getGeneratorPartFromResponseByName(numberResponse, "BoundaryNumbers");
		checkGeneratorPartForNumFuzzedValues(generatorPart, 17);
		
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
	public void testValidIntegerRequest_BoundaryNumbers() {
		String requestFilename = "./testdata/NumberRequests/ValidIntegerReqeuest_BoundaryNumbers.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
		NumberResponse numberResponse = getNumberResponseFromResponseDoc(responseDoc, 0);
		
		assertTrueWithPrefix("No seed in response.",
				   numberResponse.getSeed() != null);

		checkResponseForNumGeneratorParts(numberResponse, 1);
		GeneratorPart generatorPart = getGeneratorPartFromResponseByName(numberResponse, "BoundaryNumbers");
		checkGeneratorPartForNumFuzzedValues(generatorPart, 5);
		
		checkResponseForNumOperatorParts(numberResponse, 0);
		
		checkResponseForWarningsPart(numberResponse, false);

		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumStringResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}
	
	@Test
	public void testValidIntegerRequest_BoundaryNumbersContinued() {
		String requestFilename = "./testdata/NumberRequests/ValidIntegerReqeuest_BoundaryNumbers.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
		NumberResponse numberResponse = getNumberResponseFromResponseDoc(responseDoc, 0);
		
		String contdRequestFilename = "./testdata/NumberRequests/ValidIntegerReqeuest_BoundaryNumbers_contd.request.xml";
		int expectedNumFuzzedValues = 12;
		createContdRequest(numberResponse, contdRequestFilename, expectedNumFuzzedValues);
		
		XmlResponseDocument responseDocContd = getResponseDocForRequest(contdRequestFilename);
		
		NumberResponse numberResponseContd = getNumberResponseFromResponseDoc(responseDocContd, 0);
		
		assertTrueWithPrefix("No seed in response.",
				numberResponseContd.getSeed() != null);
		
		checkResponseForMoreValuesAttribute(numberResponseContd, false);

		checkResponseForNumGeneratorParts(numberResponseContd, 1);
		GeneratorPart generatorPart = getGeneratorPartFromResponseByName(numberResponseContd, "BoundaryNumbers");
		checkGeneratorPartForNumFuzzedValues(generatorPart, expectedNumFuzzedValues);
		

		checkResponseForNumOperatorParts(numberResponseContd, 0);
		
		checkResponseForWarningsPart(numberResponseContd, false);
		checkResponseDocForErrorResponse(responseDocContd, false);
		checkResponseDocForNumStringResponses(responseDocContd, 0);
		checkResponseDocForNumCollectionResponses(responseDocContd, 0);
		checkResponseDocForNumStructureResponses(responseDocContd, 0);
	}
	
	@Test
	public void testValidIntegerRequest_BoundaryNumbersContinuedTwoTimes() {
		String requestFilename = "./testdata/NumberRequests/ValidIntegerReqeuest_BoundaryNumbers.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
		NumberResponse numberResponse = getNumberResponseFromResponseDoc(responseDoc, 0);
		
		String contdRequestFilename = "./testdata/NumberRequests/ValidIntegerReqeuest_BoundaryNumbers_contd.request.xml";
		int expectedNumFuzzedValues = 7;
		createContdRequest(numberResponse, contdRequestFilename, expectedNumFuzzedValues);
		
		XmlResponseDocument responseDocContd = getResponseDocForRequest(contdRequestFilename);
		
		NumberResponse numberResponseContd = getNumberResponseFromResponseDoc(responseDocContd, 0);

		int expectedNumFuzzedValues2 = 5;
		String contd2RequestFilename = "./testdata/NumberRequests/ValidIntegerReqeuest_BoundaryNumbers_contd2.request.xml";
		createContdRequest(numberResponseContd, contd2RequestFilename, expectedNumFuzzedValues2);
		
		XmlResponseDocument responseDocContd2 = getResponseDocForRequest(contd2RequestFilename);
		
		NumberResponse numberResponseContd2 = getNumberResponseFromResponseDoc(responseDocContd2, 0);

		checkResponseForMoreValuesAttribute(numberResponseContd2, false);

		checkResponseForNumGeneratorParts(numberResponseContd2, 1);
		GeneratorPart generatorPart = getGeneratorPartFromResponseByName(numberResponseContd2, "BoundaryNumbers");
		checkGeneratorPartForNumFuzzedValues(generatorPart, expectedNumFuzzedValues2);
		
		checkResponseForNumOperatorParts(numberResponseContd2, 0);
		
		checkResponseForWarningsPart(numberResponseContd2, false);
		checkResponseDocForErrorResponse(responseDocContd2, false);
		checkResponseDocForNumStringResponses(responseDocContd2, 0);
		checkResponseDocForNumCollectionResponses(responseDocContd2, 0);
		checkResponseDocForNumStructureResponses(responseDocContd2, 0);
	}

	@Test
	public void testContdIntegerRequestWithMoreValuesThanAvailable() {
		String requestFilename = "./testdata/NumberRequests/ValidIntegerReqeuest_BoundaryNumbers.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
		NumberResponse numberResponse = getNumberResponseFromResponseDoc(responseDoc, 0);
		
		String contdRequestFilename = "./testdata/NumberRequests/ValidIntegerReqeuest_BoundaryNumbers_MoreValuesContd.request.xml";
		createContdRequest(numberResponse, contdRequestFilename, 100);
		XmlResponseDocument responseDocContd = getResponseDocForRequest(contdRequestFilename);
		
		NumberResponse numberResponseContd = getNumberResponseFromResponseDoc(responseDocContd, 0);

		String contd2RequestFilename = "./testdata/NumberRequests/ValidIntegerReqeuest_BoundaryNumbers_MoreValuesContd2.request.xml";
		createContdRequest(numberResponseContd, contd2RequestFilename, 1);
		
		XmlResponseDocument responseDocContd2 = getResponseDocForRequest(contd2RequestFilename);
		
		NumberResponse numberResponseContd2 = getNumberResponseFromResponseDoc(responseDocContd2, 0);

		checkResponseForNoMoreValuesWarning(numberResponseContd2);
		
		checkResponseForNumGeneratorParts(numberResponseContd2, 0);
		checkResponseForNumOperatorParts(numberResponseContd2, 0);
		checkResponseForNumIllegalGenerators(numberResponseContd2, 0);
		checkResponseForNumIllegalOperators(numberResponseContd2, 0);
		checkResponseForNumIllegalRequestFormats(numberResponseContd2, 0);
		
		checkResponseDocForErrorResponse(responseDocContd2, false);
		checkResponseDocForNumStringResponses(responseDocContd2, 0);
		checkResponseDocForNumCollectionResponses(responseDocContd2, 0);
		checkResponseDocForNumStructureResponses(responseDocContd2, 0);
	}
	
	@Test
	public void testValidIntegerRequest_NumericalVariance() {
		String requestFilename = "./testdata/NumberRequests/ValidIntegerRequest_NumericalVariance.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
		NumberResponse numberResponse = getNumberResponseFromResponseDoc(responseDoc, 0);
		
		assertTrueWithPrefix("No seed in response.",
				   numberResponse.getSeed() != null);

		checkResponseForNumOperatorParts(numberResponse, 1);
		OperatorPart operatorPart = getOperatorPartFromNumberResponseByName(numberResponse, "NumericalVariance", "10");
		int expNumFuzzedValues = 20;
		checkOperatorPartForNumFuzzedValues(operatorPart, expNumFuzzedValues);
		
		checkResponseForNumGeneratorParts(numberResponse, 0);
		checkResponseForWarningsPart(numberResponse, false);

		checkResponseDocForErrorResponse(responseDoc, false);
		checkResponseDocForNumStringResponses(responseDoc, 0);
		checkResponseDocForNumCollectionResponses(responseDoc, 0);
		checkResponseDocForNumStructureResponses(responseDoc, 0);
	}
	
}