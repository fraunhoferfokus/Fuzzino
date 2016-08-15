package de.fraunhofer.fokus.fuzzing.fuzzino.jaxb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;

import org.junit.Test;
import org.xml.sax.SAXException;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Request;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollectionsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValuesSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CloseRequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringRequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.CloseRequestConfirmation;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.CollectionResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ErrorResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedValuesByGenerators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedValuesByOperators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.GeneratorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.OperatorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Response;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StructureResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.WarningsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.ResponseImpl;

public class JAXBSerializationTest extends FuzzinoTest{
	
	@Test
	public void testResponse() throws JAXBException, SAXException{
		Response resp = new ResponseImpl();
		StringResponse stringResponse = StringResponseBuilder.initStringResponse();
		NumberResponse<Integer> numberResponse = NumberResponseBuilder.initNumberResponse();
		StructureResponse structureResponse = StructureResponseBuilder.initStructureResponse();
		CollectionResponse collectionResponse = CollectionResponseBuilder.initCollectionResponse();
		ErrorResponse errorResponse = ErrorResponseBuilder.initErrorResponse();
		CloseRequestConfirmation closeRequestConfirmation = CloseRequestConfirmationBuilder.initCloseRequestConfirmation();
		resp.getCollectionResponses().add(collectionResponse);
		resp.getStringResponses().add(stringResponse);
		resp.getNumberResponses().add(numberResponse);
		resp.getStructureResponses().add(structureResponse);
		resp.setErrorResponse(errorResponse);
		resp.getCloseRequestConfirmations().add(closeRequestConfirmation);
		File responseFile = new File("testdata/reworked/general/allResponses.response.xml");
		resp.marshall(responseFile);
		resp.marshall(System.out);
		Response unMarshalled = ResponseImpl.unmarshall(responseFile);
		assertResponseEquality(stringResponse,unMarshalled.getStringResponses().get(0));
		assertResponseEquality(numberResponse,(NumberResponse<Integer>) unMarshalled.getNumberResponses().get(0));
		assertResponseEquality(structureResponse,unMarshalled.getStructureResponses().get(0));
		assertResponseEquality(collectionResponse,unMarshalled.getCollectionResponses().get(0));
		assertResponseEquality(errorResponse,unMarshalled.getErrorResponse());
		assertCloseRequestConfirmationEquality(closeRequestConfirmation,resp.getCloseRequestConfirmations().get(0));
	}
	
	@Test
	public void testRequest() throws JAXBException, SAXException {
		System.out.println(Integer.MAX_VALUE);
		Request req = new RequestImpl();
		StringRequestImpl stringReq = StringRequestBuilder.initStringRequest();
		req.addStringRequest(stringReq);
		NumberRequestImpl numberReq = NumberRequestBuilder.initNumberRequest();
		req.addNumberRequest(numberReq);
		StructureRequest structureRequest = StructureRequestBuilder.initStructureRequest();
		req.addStructureRequest(structureRequest);
		CollectionRequest collectionRequest = CollectionRequestBuilder.initCollectioNRequest();
		req.addCollectionRequest(collectionRequest);
		CloseRequest closeRequest = new CloseRequestImpl("close request id");
		req.addCloseRequest(closeRequest);
		File requestFile = new File("testdata/reworked/numberRequests/allRequests.request.xml");
		req.marshall(requestFile);
		req.marshall(System.out);
		Request unmarshalled = RequestImpl.unmarshall(requestFile);
		StringRequest unmarshalledStringRequest = unmarshalled.getStringRequests().get(0);
		NumberRequest unmarshalledNumberRequest = unmarshalled.getNumberRequests().get(0);
		StructureRequest unmarshalledStructureRequest = unmarshalled.getStructureRequests().get(0);
		CollectionRequest unmarshalledCollectionRequest = unmarshalled.getCollectionRequests().get(0);
		//TODO: write equality check for requests
		assertRequestEquality(stringReq,unmarshalledStringRequest);
		assertRequestEquality(numberReq,unmarshalledNumberRequest);
		assertRequestEquality(structureRequest,unmarshalledStructureRequest);
		assertRequestEquality(collectionRequest, unmarshalledCollectionRequest);
		assertRequestEquality(closeRequest, unmarshalled.getCloseRequests().get(0));
		
	}
	
	private void assertCloseRequestConfirmationEquality(CloseRequestConfirmation closeRequestConfirmation1,CloseRequestConfirmation closeRequestConfirmation2) {
		assertEquals(closeRequestConfirmation1.getId(),closeRequestConfirmation2.getId());
		assertEquals(closeRequestConfirmation1.getName(), closeRequestConfirmation2.getName());
		assertWarningsSectionEquality(closeRequestConfirmation1.getWarnings(), closeRequestConfirmation2.getWarnings());
		
	}

	private void assertResponseEquality(ErrorResponse errorResponse1, ErrorResponse errorResponse2) {
		assertEquals(errorResponse1.getStackTrace(),errorResponse2.getStackTrace());
		assertEquals(errorResponse1.getMessage(), errorResponse2.getMessage());
		assertEquals(errorResponse1.getReason(),errorResponse2.getReason());
	}

	private void assertResponseEquality(CollectionResponse resp1, CollectionResponse resp2) {
		assertFuzzedCollectionListEquality(resp1.getFuzzedCollections(), resp2.getFuzzedCollections());
		assertEquals(resp1.getId(),resp2.getId());
		assertEquals(resp1.getName(),resp2.getName());
		assertEquals(resp1.getSeed(),resp2.getSeed());
		assertWarningsSectionEquality(resp1.getWarningsSection(), resp2.getWarningsSection());
	}

	private void assertFuzzedCollectionListEquality(List<FuzzedCollection> fuzzedCol1,List<FuzzedCollection> fuzzedCol2) {
		assertEquals(fuzzedCol1.size(),fuzzedCol2.size());
		for(int i=0;i<fuzzedCol1.size();i++){
			assertFuzzedColEquality(fuzzedCol1.get(i),fuzzedCol2.get(i));
		}
	}

	private void assertFuzzedColEquality(FuzzedCollection fuzzedCol1, FuzzedCollection fuzzedCol2) {
		assertEquals(fuzzedCol1.getBasedOn(),fuzzedCol2.getBasedOn());
		assertEquals(fuzzedCol1.getMutations(),fuzzedCol2.getMutations());
		assertEquals(fuzzedCol1.getOperators(),fuzzedCol2.getOperators());
		assertEquals(fuzzedCol1.getValues(),fuzzedCol2.getValues());
	}

	private void assertResponseEquality(StructureResponse resp1, StructureResponse resp2) {
		assertFuzzedValueListEquality(resp1.getFuzzedStructures(),resp2.getFuzzedStructures());
		assertEquals(resp1.getId(),resp2.getId());
		assertEquals(resp1.getName(),resp2.getName());
		assertEquals(resp1.getSeed(),resp2.getSeed());
		assertWarningsSectionEquality(resp1.getWarningsSection(), resp2.getWarningsSection());
	}

	private void assertResponseEquality(NumberResponse<Integer> resp1,NumberResponse<Integer> resp2) {
		assertGeneratorBasedEquality(resp1.getGeneratorBasedSection(),resp2.getGeneratorBasedSection());
		assertEquals(resp1.getId(), resp2.getId());		
		assertEquals(resp1.getName(),resp2.getName());
		assertOperatorBasedEquality(resp1.getOperatorBasedSection(),resp2.getOperatorBasedSection());
		assertEquals(resp1.getSeed(), resp2.getSeed());
		assertWarningsSectionEquality(resp1.getWarningsSection(),resp2.getWarningsSection());
	}

	private void assertResponseEquality(StringResponse resp1, StringResponse resp2) {
		assertGeneratorBasedEquality(resp1.getGeneratorBasedSection(),resp2.getGeneratorBasedSection());
		assertEquals(resp1.getId(), resp2.getId());		
		assertEquals(resp1.getName(),resp2.getName());
		assertOperatorBasedEquality(resp1.getOperatorBasedSection(),resp2.getOperatorBasedSection());
		assertEquals(resp1.getSeed(), resp2.getSeed());
		assertWarningsSectionEquality(resp1.getWarningsSection(),resp2.getWarningsSection());
	}

	private void assertWarningsSectionEquality(WarningsSection warn1, WarningsSection warn2) {
		assertEquals(warn1.getIllegalGenerators(),warn2.getIllegalGenerators());
		assertEquals(warn1.getIllegalOperators(),warn2.getIllegalOperators());
		assertEquals(warn1.getIllegalRequestFormats(),warn2.getIllegalRequestFormats());
	}

	private <T> void assertOperatorBasedEquality(FuzzedValuesByOperators<T> byOp1, FuzzedValuesByOperators<T> byOp2) {
		assertEquals(byOp1.getOperatorSpecificSections().size(), byOp1.getOperatorSpecificSections().size());
		for (int i = 0; i < byOp1.getOperatorSpecificSections().size(); i++) {
			assertOperatorSpecificSectionEquality(byOp1.getOperatorSpecificSections().get(i),byOp2.getOperatorSpecificSections().get(i));
		}
	}

	private <T> void assertOperatorSpecificSectionEquality(OperatorSpecificFuzzedValues<T> fuzzVals1,
			OperatorSpecificFuzzedValues<T> fuzzVals2) {
		assertEquals(fuzzVals1.getName(), fuzzVals2.getName());
		assertEquals(fuzzVals1.getBasedOn(),fuzzVals2.getBasedOn());
		assertFuzzedValueListEquality(fuzzVals1.getFuzzedValues(),fuzzVals2.getFuzzedValues());
	}

	private <T> void assertGeneratorBasedEquality(FuzzedValuesByGenerators<T> genBased1,
			FuzzedValuesByGenerators<T> genBased2) {
		assertEquals(genBased1.getGeneratorSpecificSections().size(), genBased2.getGeneratorSpecificSections().size());
		for (int i = 0; i < genBased1.getGeneratorSpecificSections().size(); i++) {
			assertGeneratorSpecificSectionEquality(genBased1.getGeneratorSpecificSections().get(i),genBased2.getGeneratorSpecificSections().get(i));
		}
	}

	private <T> void assertGeneratorSpecificSectionEquality(GeneratorSpecificFuzzedValues<T> fuzzVals1,
			GeneratorSpecificFuzzedValues<T> fuzzVals2) {
		assertEquals(fuzzVals1.getName(), fuzzVals2.getName());
		assertFuzzedValueListEquality(fuzzVals1.getFuzzedValues(),fuzzVals2.getFuzzedValues());
		
	}

	private <T> void assertFuzzedValueListEquality(List<FuzzedValue<T>> list,List<FuzzedValue<T>> list2) {
		assertEquals(list.size(), list2.size());
		for (int i = 0; i < list.size(); i++) {
			assertEquals(list.get(i).isMutated(), list2.get(i).isMutated());
			if(list.get(i).isMutated()){
				assertEquals(list.get(i).getBasedOnValue(), list2.get(i).getBasedOnValue());
			}
			assertEquals(list.get(i).getValue(),list2.get(i).getValue());
			assertEquals(list.get(i).isGenerated(),list2.get(i).isGenerated());
		}
	}

	private void assertRequestEquality(CollectionRequest req1,CollectionRequest req2) {
		assertEquals(req1.getId(), req2.getId());	
		assertEquals(req1.getMaxMutations(),req2.getMaxMutations());
		assertEquals(req1.getMaxValues(),req2.getMaxValues());
		assertEquals(req1.getMinMutations(),req2.getMinMutations());
		assertEquals(req1.getName(),req2.getName());
		assertEquals(req1.getSeed(),req2.getSeed());
		assertCollectionSpecEquality(req1.getSpecification(),req2.getSpecification());
		assertValidCollectionSectionEquals(req1.getValidCollectionsSection(),req2.getValidCollectionsSection());
	}

	private void assertValidCollectionSectionEquals(ValidCollectionsSection valid1,ValidCollectionsSection valid2) {
		assertOperatorEquality(valid1.getRequestedOperators(), valid2.getRequestedOperators());
		assertEquals(valid1.getValidCollections().size(),valid2.getValidCollections().size());
		for(int i=0;i<valid1.getValidCollections().size();i++){
			assertValidCollectionEquality(valid1.getValidCollections().get(i),valid2.getValidCollections().get(i));
		}
	}

	private void assertValidCollectionEquality(ValidCollection validCollection1, ValidCollection validCollection2) {
		assertEquals(validCollection1.getName(),validCollection2.getName());
		assertEquals(validCollection1.getValues(),validCollection2.getValues());
		
	}

	private void assertCollectionSpecEquality(CollectionSpecification spec1,CollectionSpecification spec2) {
		assertEquals(spec1.getMaxLength(),spec2.getMaxLength());
		assertEquals(spec1.getMinLength(),spec2.getMinLength());
		assertEquals(spec1.getRef(),spec2.getRef());		
	}

	private void assertRequestEquality(CloseRequest closeRequest, CloseRequest closeRequest2) {
		assertEquals(closeRequest.getId(),closeRequest2.getId());
		
	}

	private void assertRequestEquality(StructureRequest req1,StructureRequest req2) {
		assertEquals(req1.getId(), req2.getId());
		assertEquals(req1.getMaxMutations(),req2.getMaxMutations());
		assertEquals(req1.getMaxValues(),req2.getMaxValues());
		assertEquals(req1.getMinMutations(),req2.getMinMutations());
		assertEquals(req1.getName(),req2.getName());
		assertOperatorEquality(req1.getRequestedOperators(),req2.getRequestedOperators());
		assertEquals(req1.getSeed(),req2.getSeed());
		assertSpecEquality(req1.getSpecification(),req2.getSpecification());
		assertEquals(req1.fuzzStructure(),req2.fuzzStructure());
	}

	private void assertSpecEquality(StructureSpecification spec1, StructureSpecification spec2) {
		assertEquals(spec1.isOrdered(), spec2.isOrdered());
		assertFieldListEquality(spec1.getFields(),spec2.getFields());
	}

	private void assertFieldListEquality(List<Field> fields1, List<Field> fields2) {
		assertEquals(fields1.size(), fields2.size());
		for(int i=0;i<fields1.size();i++){
			assertFieldEquality(fields1.get(i),fields2.get(i));
		}
	}

	private void assertFieldEquality(Field field1, Field field2) {
		assertEquals(field1.getName(), field2.getName());
		assertEquals(field1.getCorrespondingRequestId(),field2.getCorrespondingRequestId());
		//TODO: grammar requests?
	}

	private void assertRequestEquality(NumberRequest req1, NumberRequest req2) {
		assertEquals(req1.getId(),req2.getId());
		assertEquals(req1.getMaxValues(), req2.getMaxValues());
		assertEquals(req1.getName(),req2.getName());
		assertGenEquality(req1.getRequestedGenerators(),req2.getRequestedGenerators());
		assertEquals(req1.getSeed(), req2.getSeed());
		assertNumberSpecEquality(req1.getNumberSpecification(),req2.getNumberSpecification());
		assertValidValueEquality(req1.getValidValuesSection(),req2.getValidValuesSection());
		assertEquals(req1.useNoGenerators(),req2.useNoGenerators());
	}

	private void assertNumberSpecEquality(NumberSpecification<? extends Number> spec1,NumberSpecification<? extends Number> spec2) {
		assertEquals(spec1.getMax(), spec2.getMax());
		assertEquals(spec1.getMin(), spec2.getMin());
		assertEquals(spec1.getType(), spec2.getType());
		if(spec1 instanceof IntegerSpecification){
			assertTrue(spec2 instanceof IntegerSpecification);
			IntegerSpecification intSpec1 = (IntegerSpecification) spec1;
			IntegerSpecification intSpec2 = (IntegerSpecification) spec2;
			assertEquals(intSpec1.getBits(),intSpec2.getBits());
			assertEquals(intSpec1.ignoreMinMaxValues(),intSpec2.ignoreMinMaxValues());
			assertEquals(intSpec1.isSigned(),intSpec2.isSigned());
		}
	}

	private void assertRequestEquality(StringRequest req1, StringRequest req2) {
		assertEquals(req1.getId(),req2.getId());
		assertEquals(req1.getMaxValues(), req2.getMaxValues());
		assertEquals(req1.getName(),req2.getName());
		assertGenEquality(req1.getRequestedGenerators(),req2.getRequestedGenerators());
		assertEquals(req1.getSeed(), req2.getSeed());
		assertSpecEquality(req1.getSpecification(),req2.getSpecification());
		assertValidValueEquality(req1.getValidValuesSection(),req2.getValidValuesSection());
		assertEquals(req1.useNoGenerators(),req2.useNoGenerators());
	}

	private void assertValidValueEquality(ValidValuesSection vals1,ValidValuesSection vals2) {
		assertOperatorEquality(vals1.getRequestedOperators(),vals2.getRequestedOperators());
		assertEquals(vals1.getValues(),vals2.getValues());		
	}

	private void assertOperatorEquality(List<Operator> ops1, List<Operator> ops2) {
		assertEquals(ops1.size(),ops2.size());
		for(int i=0;i<ops2.size();i++){
			assertEquals(ops1.get(i).getOperatorName(), ops2.get(i).getOperatorName());
			assertEquals(ops1.get(i).getParameter(), ops2.get(i).getParameter());
		}
	}

	private void assertSpecEquality(StringSpecification spec1, StringSpecification spec2) {
		assertEquals(spec1.getEncoding(),spec2.getEncoding());
		assertEquals(spec1.getMaxLength(),spec2.getMaxLength());
		assertEquals(spec1.getMinLength(),spec2.getMinLength());
		assertEquals(spec1.getRegEx(),spec2.getRegEx());
		assertEquals(spec1.getType(),spec2.getType());		
	}

	private void assertGenEquality(List<Generator> gens1, List<Generator> gens2) {
		assertEquals(gens1.size(),gens2.size());
		for(int i=0;i<gens1.size();i++){
			assertEquals(gens1.get(i).getGeneratorName(), gens2.get(i).getGeneratorName());
			assertEquals(gens1.get(i).getParameter(), gens2.get(i).getParameter());
		}
	}

}
