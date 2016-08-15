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
package de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.CloseRequestConfirmation;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.CollectionResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ErrorResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Response;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StructureResponse;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.NONE)
public class ResponseImpl implements Response {

	private static final File schemaLocation = new File("schemas/response/schema3.xsd");
	
	protected List<StringResponse> stringResponses;
	protected List<NumberResponse<? extends Number>> numberResponses;
	protected List<StructureResponse> structureResponses;
	protected List<CollectionResponse> collectionResponses;
	protected List<CloseRequestConfirmation> closeRequestConfirmations;
	protected ErrorResponse errorResponse;
	
	@Override
	@XmlElement(name="string", type=StringResponseImpl.class)
	public List<StringResponse> getStringResponses() {
		if (stringResponses == null) {
			stringResponses = new LinkedList<>();
		}
		return stringResponses;
	}

	@Override
	@XmlElement(name="number", type=NumberResponseImpl.class)
	public List<NumberResponse<? extends Number>> getNumberResponses() {
		if (numberResponses == null) {
			numberResponses = new ArrayList<>();
		}
		return numberResponses;
	}

	@Override
	@XmlElement(name = "structure", type= StructureResponseImpl.class)
	public List<StructureResponse> getStructureResponses() { 
		if (structureResponses == null) {
			structureResponses = new LinkedList<>();
		}
		return structureResponses;
	}

	@Override
	@XmlElement(name = "collection", type= CollectionResponseImpl.class)
	public List<CollectionResponse> getCollectionResponses() {
		if (collectionResponses == null) {
			collectionResponses = new LinkedList<>();
		}
		return collectionResponses;
	}

	@Override
	@XmlElement(name = "closeRequestDone", type= CloseRequestConfirmationImpl.class)
	public List<CloseRequestConfirmation> getCloseRequestConfirmations() {
		if (closeRequestConfirmations == null) {
			closeRequestConfirmations = new LinkedList<>();
		}
		return closeRequestConfirmations;
	}

	@Override
	@XmlElement(type = ErrorResponseImpl.class)
	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	@Override
	public void setErrorResponse(ErrorResponse value) {
		errorResponse = value;
	}
	
	@Override
	public String toString() {
		return "[Response stringResponses:" + (stringResponses == null ? "0" : stringResponses.size()) +
			 "\n          numberResponses:" + (numberResponses == null ? "0" : numberResponses.size()) +
			 "\n          structureResponses:" + (structureResponses == null ? "0" : structureResponses.size()) + 
			 "\n          collectionResponses:" + (collectionResponses == null ? "0" : collectionResponses.size()) +
			 "\n          closeRequestConfirmations:" + (closeRequestConfirmations == null ? "0" : closeRequestConfirmations.size()) +
			 "\n          errorResponses:" + errorResponse + "]";
	}

	@Override
	public void marshall(File file) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(ResponseImpl.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(this, file);
	}

	@Override
	public void marshall(PrintStream out) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(ResponseImpl.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(this, out);
	}
	
	public static Response unmarshall(File file) throws JAXBException, SAXException {
		JAXBContext jaxbContext = JAXBContext.newInstance(ResponseImpl.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaLocation); 
		jaxbUnmarshaller.setSchema(schema);
		return (Response) jaxbUnmarshaller.unmarshal( file );
	}

}
