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

import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.createCloseRequestCommandFromResponse;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.createCloseRequestFileFromResponse;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.createContdRequest;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getNumberResponseFromResponseDoc;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getResponseDocForRequest;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.getStringResponseFromResponseDoc;
import static de.fraunhofer.fokus.fuzzing.fuzzino.TestUtil.saveRequest;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.Request;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument;

public class BuildExampleFiles extends FuzzinoTest {

	@Test
	public void buildGeneralExampleFilesForString() {
		String requestFilename = "./general/CloseRequestInvalidId.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		
		requestFilename = "./general/RequestWithSeed.request.xml";
		responseDoc = getResponseDocForRequest(requestFilename);
		StringResponse stringResponse = getStringResponseFromResponseDoc(responseDoc, 0);
		String closeRequestFilename = "./general/CloseRequestValid.request.xml";
		createCloseRequestFileFromResponse(closeRequestFilename, stringResponse);
		getResponseDocForRequest(closeRequestFilename);
		
		requestFilename = "./general/example1.request.xml";
		responseDoc = getResponseDocForRequest(requestFilename);
		stringResponse = getStringResponseFromResponseDoc(responseDoc, 0);
		NumberResponse numberResponse = getNumberResponseFromResponseDoc(responseDoc, 0);
		
		requestFilename = "./general/example2.request.xml";
		Request request = RequestFactory.eINSTANCE.createRequest();
		getResponseDocForRequest(requestFilename);
		
		createCloseRequestCommandFromResponse(stringResponse, request);
		createCloseRequestCommandFromResponse(numberResponse, request);
			
		XmlRequestDocument requestDoc = RequestFactory.eINSTANCE.createXmlRequestDocument();
		requestDoc.setRequest(request);
		saveRequest(requestDoc, requestFilename);
		getResponseDocForRequest(requestFilename);
	}

	@Test
	public void buildExampleFilesForString() {
		String requestFilename = "./string/StringRequest.request.xml";
		XmlResponseDocument responseDoc = getResponseDocForRequest(requestFilename);
		StringResponse stringResponse = getStringResponseFromResponseDoc(responseDoc, 0); 

		String contdRequestFilename = "./string/StringRequest_contd.request.xml";
		int expectedNumOfContdFuzzedValues = 5;
		createContdRequest(stringResponse, contdRequestFilename, expectedNumOfContdFuzzedValues);
		getResponseDocForRequest(contdRequestFilename);
		
		String closeRequestFilename = "./string/StringRequest_close.request.xml";
		createCloseRequestFileFromResponse(closeRequestFilename, stringResponse);
		getResponseDocForRequest(closeRequestFilename);
		
		requestFilename = "./string/1_BluetoothPIN.request.xml";
		responseDoc = getResponseDocForRequest(requestFilename);
		stringResponse = getStringResponseFromResponseDoc(responseDoc, 0);
		requestFilename = "./string/2_BluetoothPIN_contd.request.xml";
		createContdRequest(stringResponse, requestFilename, 10);
		getResponseDocForRequest(requestFilename);
		
		closeRequestFilename = "./string/3_BluetoothPIN_close.request.xml";
		createCloseRequestFileFromResponse(closeRequestFilename, stringResponse);
		getResponseDocForRequest(closeRequestFilename);
	}

}
