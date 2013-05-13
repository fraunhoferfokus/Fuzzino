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

import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.*;

import java.util.List;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class NumberSpecTests {

	@Test
	public void testValidNumberRequest() {
		String requestFilename = "./testdata/numberRequests/NumberSpec_Tests.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
		checkResponsesForExistence(responseDoc);
		checkResponsesWithInvalidTypes(responseDoc);
		checkResponsesWithInvalidBits(responseDoc);
		checkResponsesToValidRequests(responseDoc);
	}
	
	public void checkResponsesForExistence(XmlResponseDocument responseDoc) {
		List<String> expectedResponses = StringUtil.asList("NumberSpec_integer",
				                                           "NumberSpec_integer_differentCases",
//				                                           "NumberSpec_float", not implemented yet
//				                                           "NumberSpec_float_differentCases", not implemented yet
				                                           "NumberSpec_INVALIDTYPE",
				                                           "NumberSpec_integer_minValueGTmaxValue",
				                                           "NumberSpec_integer_minValueEQmaxValue",
				                                           "NumberSpec_integer_minValueSTmaxValue",
				                                           "NumberSpec_integer_isSigned",
				                                           "NumberSpec_integer_isNotSigned",
				                                           "NumberSpec_integer_bitsMinus1",
				                                           "NumberSpec_integer_bits0",
				                                           "NumberSpec_integer_bits1",
				                                           "NumberSpec_integer_bits7",
				                                           "NumberSpec_integer_bits8",
				                                           "NumberSpec_integer_bits9",
				                                           "NumberSpec_integer_bits15",
				                                           "NumberSpec_integer_bits16",
				                                           "NumberSpec_integer_bits17",
				                                           "NumberSpec_integer_bits31",
				                                           "NumberSpec_integer_bits32",
				                                           "NumberSpec_integer_bits33",
				                                           "NumberSpec_integer_bits63",
				                                           "NumberSpec_integer_bits64",
				                                           "NumberSpec_integer_bits65",
				                                           "NumberSpec_integer_bits127",
				                                           "NumberSpec_integer_bits128",
				                                           "NumberSpec_integer_bits129");
		List<NumberResponse> numberResponses = responseDoc.getResponse().getNumberResponses();
		for (NumberResponse numberResponse : numberResponses) {
			expectedResponses.remove(numberResponse.getName());
		}
		
		assertTrueWithPrefix(expectedResponses.size() + " missing responses: " + expectedResponses,
				   expectedResponses.isEmpty());
	}
	
	public void checkResponsesWithInvalidTypes(XmlResponseDocument responseDoc) {
		NumberResponse numberResponse = 
				getNumberResponseFromResponseDocByName(responseDoc, "NumberSpec_INVALIDTYPE");
		
		IllegalRequestFormat illegalRequestFormat = getIllegalRequestFormatFromResponse(numberResponse, 0);
		checkIllegalRequestFormatForElementAndId(illegalRequestFormat, "specification", "type");
	}

	public void checkResponsesWithInvalidMaxValues(XmlResponseDocument responseDoc) {
		NumberResponse numberResponse = 
				getNumberResponseFromResponseDocByName(responseDoc, "NumberSpec_integer_minValueGTmaxValue");
		
		IllegalRequestFormat illegalRequestFormat = getIllegalRequestFormatFromResponse(numberResponse, 0);
		checkIllegalRequestFormatForElementAndId(illegalRequestFormat, "specification", "maxValue");
	}

	public void checkResponsesWithInvalidBits(XmlResponseDocument responseDoc) {
		List<String> responseNamesWithInvalidBits = StringUtil.asList("NumberSpec_integer_bitsMinus1",
                                                                      "NumberSpec_integer_bits0",
                                                                      "NumberSpec_integer_bits1",
                                                                      "NumberSpec_integer_bits7",
                                                                      "NumberSpec_integer_bits9",
                                                                      "NumberSpec_integer_bits15",
                                                                      "NumberSpec_integer_bits17",
                                                                      "NumberSpec_integer_bits31",
                                                                      "NumberSpec_integer_bits33",
                                                                      "NumberSpec_integer_bits63",
                                                                      "NumberSpec_integer_bits65",
                                                                      "NumberSpec_integer_bits127",
                                                                      "NumberSpec_integer_bits129");
		
		for (String responseName : responseNamesWithInvalidBits) {
			NumberResponse numberResponse = 
					getNumberResponseFromResponseDocByName(responseDoc, responseName);
			
			setPrefix(responseName + ": ");
				
			checkResponseForNumIllegalRequestFormats(numberResponse, 1);
			
			IllegalRequestFormat illegalRequestFormat = getIllegalRequestFormatFromResponse(numberResponse, 0);
			checkIllegalRequestFormatForElementAndId(illegalRequestFormat, "specification", "bits");

			checkResponseForNumGeneratorParts(numberResponse, 0);
			checkResponseForNumOperatorParts(numberResponse, 0);
			checkResponseForNumIllegalGenerators(numberResponse, 0);
			checkResponseForNumIllegalOperators(numberResponse, 0);
		}
		setPrefix("");
	}
	
	public void checkResponsesToValidRequests(XmlResponseDocument responseDoc) {
		List<String> responseNamesWithInvalidBits = StringUtil.asList("NumberSpec_integer",
				                                                      "NumberSpec_integer_differentCases",
				                                                      "NumberSpec_integer_minValueEQmaxValue",
				                                                      "NumberSpec_integer_minValueSTmaxValue",
				                                                      "NumberSpec_integer_isSigned",
				                                                      "NumberSpec_integer_isNotSigned",
				                                                      "NumberSpec_integer_bits8",
				                                                      "NumberSpec_integer_bits16",
				                                                      "NumberSpec_integer_bits32",
				                                                      "NumberSpec_integer_bits64",
				                                                      "NumberSpec_integer_bits128");

		for (String responseName : responseNamesWithInvalidBits) {
			NumberResponse numberResponse = 
					getNumberResponseFromResponseDocByName(responseDoc, responseName);

			setPrefix(responseName + ": ");

			checkResponseForWarningsPart(numberResponse, false);
		}
		setPrefix("");
	}

}
