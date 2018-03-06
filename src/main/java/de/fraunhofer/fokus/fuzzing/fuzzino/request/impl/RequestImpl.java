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
package de.fraunhofer.fokus.fuzzing.fuzzino.request.impl;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.ArrayList;
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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Request;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest;

@XmlRootElement(namespace = "request",name = "request")
@XmlAccessorType(XmlAccessType.NONE)
public class RequestImpl implements Request {
	
	private static final File schemaLocation = new File("schemas/request/schema2.xsd");
	private static final long serialVersionUID = 1915856810760232417L;
	protected List<StringRequest> stringRequests;
	protected List<NumberRequest> numberRequests;
	protected List<StructureRequest> structureRequests;
	protected List<CollectionRequest> collectionRequests;
	protected List<CloseRequest> closeRequests;
	
	@Override
	@XmlElement(name="string", type=StringRequestImpl.class)
	public List<StringRequest> getStringRequests() {
		if (stringRequests == null) {
			stringRequests = new ArrayList<>();
		}
		return stringRequests;
	}
	
	@Override
	public void setStringRequests(List<StringRequest> value) {
		getStringRequests().addAll(value);
	}
	
	@Override
	@XmlElement(name="number", type=NumberRequestImpl.class)
	public List<NumberRequest> getNumberRequests() {
		if (numberRequests == null) {
			numberRequests = new ArrayList<>();
		}
		return numberRequests;
	}
	
	@Override
	public void setNumberRequests(List<NumberRequest> value) {
		getNumberRequests().addAll(value);
	}
	
	@Override
	@XmlElement(name="structure", type=StructureRequestImpl.class)
	public List<StructureRequest> getStructureRequests() {
		if (structureRequests == null) {
			structureRequests = new ArrayList<>();
		}
		return structureRequests;
	}
	
	@Override
	public void setStructureRequests(List<StructureRequest> value) {
		getStructureRequests().addAll(value);
	}
	
	@Override
	@XmlElement(name="CollectionRequest", type=CollectionRequestImpl.class)
	public List<CollectionRequest> getCollectionRequests() {
		if (collectionRequests == null) {
			collectionRequests = new ArrayList<>();
		}
		return collectionRequests;
	}
	
	@Override
	public void setCollectionRequests(List<CollectionRequest> value) {
		getCollectionRequests().addAll(value);
	}
	
	@Override
	@XmlElement(name="closeRequest", type=CloseRequestImpl.class)
	public List<CloseRequest> getCloseRequests() {
		if (closeRequests == null) {
			closeRequests = new ArrayList<>();
		}
		return closeRequests;
	}
	
	@Override
	public void setCloseRequests(List<CloseRequest> value) {
		getCloseRequests().addAll(value);
	}

	@Override
	public void addStringRequest(StringRequest value) {
		getStringRequests().add(value);
	}

	@Override
	public void addNumberRequest(NumberRequest value) {
		getNumberRequests().add(value);
	}

	@Override
	public void addStructureRequest(StructureRequest value) {
		getStructureRequests().add(value);
	}

	@Override
	public void addCollectionRequest(CollectionRequest value) {
		getCollectionRequests().add(value);
	}

	@Override
	public void addCloseRequest(CloseRequest value) {
		getCloseRequests().add(value);
	}
	
	@Override
	public String toString() {
		return "[Request stringRequests:" + (stringRequests == null ? "0" : stringRequests.size()) + 
			 "\n         numberRequests:" + (numberRequests == null ? "0" : numberRequests.size()) +
			 "\n         structureRequests:" + (structureRequests == null ? "0" : structureRequests.size()) +
			 "\n         collectionRequets:" + (collectionRequests == null ? "0" : collectionRequests.size()) +
			 "\n         closeRequests:" + (closeRequests == null ? "0" : closeRequests.size()) + "]";
		}

	@Override
	public void marshall(File file) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(RequestImpl.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(this, file);
	}

	@Override
	public void marshall(PrintStream out) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(RequestImpl.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(this, out);
	}
	
	public static Request unmarshall(File requestFile) throws JAXBException, SAXException {
		JAXBContext jaxbContext = JAXBContext.newInstance(RequestImpl.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaLocation); 
		jaxbUnmarshaller.setSchema(schema);
		return (Request) jaxbUnmarshaller.unmarshal( requestFile );
	}

	public static Request unmarshall(String xmlString) throws JAXBException, SAXException {
		JAXBContext jaxbContext = JAXBContext.newInstance(RequestImpl.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaLocation); 
		jaxbUnmarshaller.setSchema(schema);
		StringReader reader = new StringReader(xmlString);
		return (Request) jaxbUnmarshaller.unmarshal(reader);
		
	}
	
}
