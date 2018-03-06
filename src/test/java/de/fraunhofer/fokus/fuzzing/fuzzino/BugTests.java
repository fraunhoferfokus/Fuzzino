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
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForErrorResponse;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumCollectionResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumNumberResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumStringResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseDocForNumStructureResponses;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForNumGeneratorParts;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForNumOperatorParts;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.checkResponseForWarningsPart;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getGeneratorPartFromResponseByName;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getResponseDocForRequest;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.xml.sax.SAXException;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Response;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse;

public class BugTests extends FuzzinoTest{

	private static String bugDir = "testdata/reworked/bugs/";
	
	/*@Test
	public void init() throws JAXBException{
		String baseFilename = "2013-02-04_14_38_750";
		String reqFilename = bugDir + baseFilename +".request.xml";
		String respFilename = bugDir + baseFilename +".response.xml";
		StringRequest stringReq = new StringRequestImpl();
		stringReq.setName("SimpleStringRequest");
		stringReq.setMaxValues(750);
		StringSpecification spec = new StringSpecificationImpl();
		spec.setEncoding(StringEncoding.UTF8);
		spec.setMinLength(0);
		spec.setMaxLength(255);
		spec.setIsNullTerminated(true);
		stringReq.setSpecification(spec);
		stringReq.addRequestedGenerator(new GeneratorImpl("AllBadStrings"));		
		Request req = new RequestImpl();
		req.getStringRequests().add(stringReq);
		req.marshall(new File(reqFilename));
		StringRequestProcessor proc = new StringRequestProcessor(stringReq, UUID.randomUUID());
		de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StringResponse a = proc.getResponse();
		Response resp = new ResponseImpl();
		resp.getStringResponses().add(a);
		resp.marshall(new File(respFilename));
	}*/
	
	@Test
	public void testBug_2012_06_11_16_47() throws JAXBException, SAXException {
		String requestFilename = bugDir + "2012-06-11_16-47.request.xml";
		Response response = getResponseDocForRequest(requestFilename);
		
		checkResponseDocForNumStringResponses(response, 1);
		StringResponse stringResponse = response.getStringResponses().get(0);
		checkResponseForNumGeneratorParts(stringResponse, 1);
		
		GeneratorSpecificFuzzedValues<String> generatorPart = getGeneratorPartFromResponseByName(stringResponse, "BadNumbersAsString");
		checkGeneratorPartForNumFuzzedValues(generatorPart, 10);
		
		checkResponseForNumOperatorParts(stringResponse, 0);

		checkResponseForWarningsPart(stringResponse, false);
		
		checkResponseDocForErrorResponse(response, false);
		checkResponseDocForNumNumberResponses(response, 0);
		checkResponseDocForNumCollectionResponses(response, 0);
		checkResponseDocForNumStructureResponses(response, 0);
	}
	
	@Test
	public void testBug_2012_10_10_19_08() throws JAXBException, SAXException {
		String requestFilename = bugDir + "2012-10-10_19-08.request.xml";
		Response response = getResponseDocForRequest(requestFilename);
		
		checkResponseDocForNumStringResponses(response, 1);
		StringResponse stringResponse = response.getStringResponses().get(0);

		checkResponseForNumGeneratorParts(stringResponse, 1);
		
		GeneratorSpecificFuzzedValues<String> generatorPart = getGeneratorPartFromResponseByName(stringResponse, "BadStrings");
		checkGeneratorPartForNumFuzzedValues(generatorPart, 40);
		
		checkResponseForNumOperatorParts(stringResponse, 0);

		checkResponseForWarningsPart(stringResponse, false);
		
		checkResponseDocForErrorResponse(response, false);
		checkResponseDocForNumNumberResponses(response, 0);
		checkResponseDocForNumCollectionResponses(response, 0);
		checkResponseDocForNumStructureResponses(response, 0);
	}
	
	@Test
	public void testBug_2012_10_10_19_08_delete() {

		String requestFilename = bugDir + "2012-10-10_19-08.request.xml";

		Fuzzino.main(new String[]{requestFilename});
		
		String responseFilename = bugDir + "2012-10-10_19-08.response.xml";
		
		File response = new File(responseFilename);
		if (response.exists()) {
			assertTrue("Response file could not be deleted",
					   response.delete());
		}
	}
	
	@Test
	public void testBug_2012_10_10_19_08_callLibraryTwice() {
		String requestFilename1 = bugDir + "2012-10-10_19-08.request.xml";
		String reqeustFilename2 = bugDir + "2012-06-11_16-47.request.xml";
		Fuzzino.main(new String[]{requestFilename1});
		Fuzzino.main(new String[]{reqeustFilename2});
	}
	
	@Test
	public void testBug_2012_10_10_19_08_processXmlString() {
		String xmlRequest = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                            "<request>" +
				            "<string name=\"SimpleStringRequest\" maxValues=\"40\">\n" +
                            "<specification type=\"STRING\" minLength=\"1\" maxLength=\"5\" nullTerminated=\"true\" encoding=\"UTF8\" />\n" +
				            "<generator value =\"BadStrings\" />\n" + 
                            "</string>\n" +
				            "</request>";
		
		String xmlResponse = Fuzzino.processXmlString(xmlRequest);
		
		assertTrue("xmlResponse is null", xmlResponse != null);
	}
	
	@Test
	public void testBug_2013_02_04_14_38_manyValuesRequested_5000() {
		String requestFilename = bugDir + "2013-02-04_14_38_5000.request.xml";
		
		try {
			Fuzzino.main(new String[]{requestFilename});
		} catch (Exception e) {
			fail(e.toString());
		}
	}
	
	@Test
	public void testBug_2013_02_04_14_38_manyValuesRequested_750() {
		String requestFilename = bugDir + "2013-02-04_14_38_750.request.xml";
		
		try {
			Fuzzino.main(new String[]{requestFilename});
		} catch (Exception e) {
			fail(e.toString());
		}
	}
	
}
