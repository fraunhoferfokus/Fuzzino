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
package de.fraunhofer.fokus.fuzzing.fuzzino.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Test;
import org.xml.sax.SAXException;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.Request;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestImpl;

public class ResourceTest {

	@Test
	public void loadTestDataDirectory() {
		assertTrue(new ResourceResolver().loadProjectFile(ResourcePath.TEST_RESOURCE).exists());
	}
	
	@Test
	public void loadSchemaDirectory() {
		assertTrue(new ResourceResolver().loadProjectFile(ResourcePath.SCHEMA_DIRECTORY).exists());
	}
	
	@Test
	public void loadSchema() throws SAXException {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new ResourceResolver().loadProjectFile(ResourcePath.SCHEMA_DIRECTORY + "request/schema2.xsd"));
		assertNotNull(schema);
	}
	
	@Test
	public void loadDataSpecDirectory() {
		assertTrue(new ResourceResolver().loadProjectFile(ResourcePath.DATA_SPEC).exists());
	}
	
	@Test
	public void loadFuzzingValuesDirectory() {
		assertTrue(new ResourceResolver().loadProjectFile(ResourcePath.FUZZING_VALUES).exists());
	}
		
	@Test
	public void loadSchemaTest() throws JAXBException, SAXException, IOException {		
		String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" + 
				"<ns2:request xmlns:ns2=\"http://fuzzino.fuzzing.fokus.fraunhofer.de/request\">\n" + 
				"    <string maxValues=\"50\" name=\"StringRequestTest\" seed=\"-1\">\n" + 
				"        <noGenerators>false</noGenerators>\n" + 
				"        <generator value=\"BADSTRINGS\"/>\n" + 
				"        <specification type=\"STRING\" nullTerminated=\"true\" minLength=\"0\" maxLength=\"2147483647\" encoding=\"UTF8\" ignoreLengths=\"false\"/>\n" + 
				"        <validValues>\n" + 
				"            <operator name=\"STRINGCASE\"/>\n" + 
				"            <value>ABC</value>\n" + 
				"        </validValues>\n" + 
				"    </string>\n" + 
				"</ns2:request>";
		
		String schemaPath = ResourcePath.SCHEMA_DIRECTORY + "request/schema2.xsd";
		File schemaFile = new ResourceResolver().loadSchemaFromJarAsNewFile(schemaPath);
		
		JAXBContext jaxbContext = JAXBContext.newInstance(RequestImpl.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaFile); 
		jaxbUnmarshaller.setSchema(schema);
		
		
		StringReader reader = new StringReader(xmlString);
		Request r =  (Request) jaxbUnmarshaller.unmarshal(reader);
		assert(r.getNumberRequests().size() == 1);
	}
}
