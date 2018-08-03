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
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getOperatorPartFromNumberResponseByName;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getResponseDocForRequest;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.IntegerGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.IntegerGeneratorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.IntegerOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.IntegerOperatorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Request;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.GeneratorImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.IntegerSpecificationImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Response;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ResourcePath;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ResourceResolver;

public class BigIntegerRequestProcessorTest extends FuzzinoTest{

	private static final long SEED = 4711;
	private static final String NO_PARAM = null;
	private static final IntegerSpecification NUMBER_SPEC = RequestFactory.INSTANCE.createNumberSpecification();
	static {
		NUMBER_SPEC.setBits(128);
		NUMBER_SPEC.setIsSigned(true);
	}
	protected BigIntegerRequestProcessor reqProc;

	private static String numRequestRoot = ResourcePath.TEST_RESOURCE + "reworked/NumberRequests/";

	
	@Before
	public void init() throws Exception {
		
		Request request = RequestImpl.unmarshall(new File(numRequestRoot + "ValidBigIntegerRequest.request.xml"));
		NumberRequest numberRequest = request.getNumberRequests().get(0);
		//TODO: we originally made a deepcopy here - was that important?
		reqProc = new BigIntegerRequestProcessor(numberRequest, UUID.randomUUID());
		
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
	public void testValidIntegerRequest() throws IOException, JAXBException, SAXException {
		//test
		String requestFilename = numRequestRoot + "ValidBigIntegerRequest.request.xml";
		Response response = getResponseDocForRequest(requestFilename);
		
		NumberResponse<?> numberResponse = response.getNumberResponses().get(0);
		
		checkResponseForNumGeneratorParts(numberResponse, 1);
		GeneratorSpecificFuzzedValues<?> generatorPart = getGeneratorPartFromResponseByName(numberResponse, "BoundaryNumbers");
		checkGeneratorPartForNumFuzzedValues(generatorPart, 17);
		
		checkResponseForNumOperatorParts(numberResponse, 1);
		OperatorSpecificFuzzedValues<?> operatorPart = getOperatorPartFromNumberResponseByName(numberResponse, "NumericalVariance", "10");
		checkOperatorPartForNumFuzzedValues(operatorPart, 20);
		
		checkResponseForWarningsPart(numberResponse, false);

		checkResponseDocForErrorResponse(response, false);
		checkResponseDocForNumStringResponses(response, 0);
		checkResponseDocForNumCollectionResponses(response, 0);
		checkResponseDocForNumStructureResponses(response, 0);
	}
	
	@Test
	public void testValidIntegerRequest_BoundaryNumbers() throws JAXBException, SAXException {
		String requestFilename = numRequestRoot + "ValidBigIntegerReqeuest_BoundaryNumbers.request.xml";
		Response response = getResponseDocForRequest(requestFilename);
		NumberResponse<?> numberResponse = response.getNumberResponses().get(0);

		checkResponseForNumGeneratorParts(numberResponse, 1);
		GeneratorSpecificFuzzedValues<?> generatorPart = getGeneratorPartFromResponseByName(numberResponse, "BoundaryNumbers");
		checkGeneratorPartForNumFuzzedValues(generatorPart, 5);
		
		checkResponseForNumOperatorParts(numberResponse, 0);
		
		checkResponseForWarningsPart(numberResponse, false);

		checkResponseDocForErrorResponse(response, false);
		checkResponseDocForNumStringResponses(response, 0);
		checkResponseDocForNumCollectionResponses(response, 0);
		checkResponseDocForNumStructureResponses(response, 0);
	}
	
	@Test
	public void testValidIntegerRequest_BoundaryNumbersContinued() throws JAXBException, SAXException {
		String requestFilename = numRequestRoot + "ValidBigIntegerReqeuest_BoundaryNumbers.request.xml";
		Response response = getResponseDocForRequest(requestFilename);
		
		NumberResponse<?> numberResponse = response.getNumberResponses().get(0);
		
		String contdRequestFilename = numRequestRoot +"ValidBigIntegerReqeuest_BoundaryNumbers_contd.request.xml";
		int expectedNumFuzzedValues = 12;
		createContdRequest(numberResponse, contdRequestFilename, expectedNumFuzzedValues);
		
		Response responseDocContd = getResponseDocForRequest(contdRequestFilename);
		
		NumberResponse<?> numberResponseContd = responseDocContd.getNumberResponses().get(0);

		checkResponseForMoreValuesAttribute(numberResponseContd, false);

		checkResponseForNumGeneratorParts(numberResponseContd, 1);
		GeneratorSpecificFuzzedValues<?> generatorPart = getGeneratorPartFromResponseByName(numberResponseContd, "BoundaryNumbers");
		checkGeneratorPartForNumFuzzedValues(generatorPart, expectedNumFuzzedValues);
		

		checkResponseForNumOperatorParts(numberResponseContd, 0);
		
		checkResponseForWarningsPart(numberResponseContd, false);
		checkResponseDocForErrorResponse(responseDocContd, false);
		checkResponseDocForNumStringResponses(responseDocContd, 0);
		checkResponseDocForNumCollectionResponses(responseDocContd, 0);
		checkResponseDocForNumStructureResponses(responseDocContd, 0);
	}
	
	@Test
	public void testValidIntegerRequest_BoundaryNumbersContinuedTwoTimes() throws JAXBException, SAXException {
		String requestFilename =  numRequestRoot + "ValidBigIntegerReqeuest_BoundaryNumbers.request.xml";
		Response response = getResponseDocForRequest(requestFilename);
		
		NumberResponse<?> numberResponse = response.getNumberResponses().get(0);
		
		String contdRequestFilename = numRequestRoot + "ValidBigIntegerReqeuest_BoundaryNumbers_contd.request.xml";
		int expectedNumFuzzedValues = 7;
		createContdRequest(numberResponse, contdRequestFilename, expectedNumFuzzedValues);
		
		Response responseDocContd = getResponseDocForRequest(contdRequestFilename);
		
		NumberResponse<?> numberResponseContd = response.getNumberResponses().get(0);

		int expectedNumFuzzedValues2 = 5;
		String contd2RequestFilename = numRequestRoot +"ValidBigIntegerReqeuest_BoundaryNumbers_contd2.request.xml";
		createContdRequest(numberResponseContd, contd2RequestFilename, expectedNumFuzzedValues2);
		
		Response responseDocContd2 = getResponseDocForRequest(contd2RequestFilename);
		
		NumberResponse<?> numberResponseContd2 = responseDocContd2.getNumberResponses().get(0);

		checkResponseForMoreValuesAttribute(numberResponseContd2, false);

		checkResponseForNumGeneratorParts(numberResponseContd2, 1);
		GeneratorSpecificFuzzedValues<?> generatorPart = getGeneratorPartFromResponseByName(numberResponseContd2, "BoundaryNumbers");
		checkGeneratorPartForNumFuzzedValues(generatorPart, expectedNumFuzzedValues2);
		
		checkResponseForNumOperatorParts(numberResponseContd2, 0);
		
		checkResponseForWarningsPart(numberResponseContd2, false);
		checkResponseDocForErrorResponse(responseDocContd2, false);
		checkResponseDocForNumStringResponses(responseDocContd2, 0);
		checkResponseDocForNumCollectionResponses(responseDocContd2, 0);
		checkResponseDocForNumStructureResponses(responseDocContd2, 0);
	}

	@Test
	public void testContdIntegerRequestWithMoreValuesThanAvailable() throws JAXBException, SAXException {
		String requestFilename = numRequestRoot + "ValidBigIntegerReqeuest_BoundaryNumbers.request.xml";
		Response response = getResponseDocForRequest(requestFilename);
		
		NumberResponse<?> numberResponse = response.getNumberResponses().get(0);
		
		String contdRequestFilename = numRequestRoot + "ValidBigIntegerReqeuest_BoundaryNumbers_MoreValuesContd.request.xml";
		createContdRequest(numberResponse, contdRequestFilename, 100);
		Response responseDocContd = getResponseDocForRequest(contdRequestFilename);
		
		NumberResponse<?> numberResponseContd = responseDocContd.getNumberResponses().get(0);

		String contd2RequestFilename = numRequestRoot +"ValidBigIntegerReqeuest_BoundaryNumbers_MoreValuesContd2.request.xml";
		createContdRequest(numberResponseContd, contd2RequestFilename, 1);
		
		Response responseDocContd2 = getResponseDocForRequest(contd2RequestFilename);
		
		NumberResponse<?> numberResponseContd2 = responseDocContd2.getNumberResponses().get(0);

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
	public void testValidIntegerRequest_NumericalVariance() throws JAXBException, SAXException {
		String requestFilename = numRequestRoot + "ValidBigIntegerRequest_NumericalVariance.request.xml";
		Response response = getResponseDocForRequest(requestFilename);
		
		NumberResponse<?> numberResponse = response.getNumberResponses().get(0);
		
		checkResponseForNumOperatorParts(numberResponse, 1);
		OperatorSpecificFuzzedValues<?> operatorPart = getOperatorPartFromNumberResponseByName(numberResponse, "NumericalVariance", "10");
		int expNumFuzzedValues = 20;
		checkOperatorPartForNumFuzzedValues(operatorPart, expNumFuzzedValues);
		
		checkResponseForNumGeneratorParts(numberResponse, 0);
		checkResponseForWarningsPart(numberResponse, false);

		checkResponseDocForErrorResponse(response, false);
		checkResponseDocForNumStringResponses(response, 0);
		checkResponseDocForNumCollectionResponses(response, 0);
		checkResponseDocForNumStructureResponses(response, 0);
	}

}
