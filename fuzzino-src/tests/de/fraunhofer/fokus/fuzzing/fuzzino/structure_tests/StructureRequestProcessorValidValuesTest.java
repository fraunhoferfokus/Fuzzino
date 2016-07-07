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
package de.fraunhofer.fokus.fuzzing.fuzzino.structure_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.IntegerRequestProcessor;
import de.fraunhofer.fokus.fuzzing.fuzzino.StringRequestProcessor;
import de.fraunhofer.fokus.fuzzing.fuzzino.StructureRequestProcessor;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.CommonRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StructureRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.impl.FieldImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.impl.StructureSpecificationImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.CommonResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StructureResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ValidValuesResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;


/***
 * 
 * @author Leon Bornemann (leon.bornemann@fokus.fraunhofer.de ) 
 * This class provides integration tests for the fuzzing process of structures. 
 * This includes specification and operator requests, StructureRequest, processing of the request and checking the response
 * This test class focuses on tests where all fields of the structure are fuzzed.
 */
public class StructureRequestProcessorValidValuesTest {

	private static final List<String> validStrings = Arrays.asList("this is a valid string","this as well","and we allow this one too");
	private static final List<String> validNumbers = Arrays.asList("42","1337","pi because pi is a number :)");
	private static final String structureOperatorName = "DublicateField";
	private static final NumberRequest exampleNumberRequest = StructureTestUtil.createNewExampleNumberRequest("numberRequest1", 10, StructureTestUtil.createExampleNumberSpec(), "BoundaryNumbers",validNumbers);
	private static final StringRequest exampleStringRequest = StructureTestUtil.createNewExampleStringRequest("stringRequest1", 10, StructureTestUtil.createExampleStringSpec(), "BadFilenames",validStrings, 10);
	
	
	@Test
	/***
	 * Tests a flat structure with 10 requests as elements. Mixes string and number, as well as fuzzing of the fields vs taking valid values
	 */
	public void flatStructure() {
		//build structure
		StructureSpecification strucSpec = new StructureSpecificationImpl();
		strucSpec.setOrdered(true);
		//every second field will have its value fuzzed
		List<Field> fields = new ArrayList<>();
		for(int i=0;i<10;i++){
			Field field = new FieldImpl();
			fields.add(field);
			if(i>=5){
				field.setValueRequest(exampleNumberRequest);
			} else{
				field.setValueRequest(exampleStringRequest);
			}
			if(i%2==0){
				field.setFuzz(true);
			} else{
				field.setFuzz(false);
			}
		}
		initRequests();
		strucSpec.setFields(fields );
		StructureRequest request = StructureTestUtil.createExampleRequest(strucSpec, false, "request1", structureOperatorName);
		StructureRequestProcessor proc = new StructureRequestProcessor(request, UUID.randomUUID());
		StructureResponse resp = (StructureResponse) proc.getResponse();
		assertEquals(1,resp.getFuzzedStructures().size());
		Structure fuzzedStruc = resp.getFuzzedStructures().get(0).getValue();
		for(int i=0;i<fuzzedStruc.getFields().size();i++){
			de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Field<CommonResponse> field = fuzzedStruc.getFields().get(i);
			if(i%2==0){
				assertTrue(field.isValueFuzzed());
			} else{
				assertFalse(field.isValueFuzzed());
				assertTrue(field.getValue() instanceof ValidValuesResponse<?>);
				ValidValuesResponse<String> fieldResponse = (ValidValuesResponse<String>) field.getValue();
				if(i>=5){
					assertEquals(validNumbers,fieldResponse.getValidValues());
				} else{
					assertEquals(validStrings,fieldResponse.getValidValues());
				}
			}
		}
		System.out.println(fuzzedStruc);
	}
	
	@Test
	public void nestedStructure(){
		//build structure
		StructureSpecification innerStrucSpec = buildInnerRequestSpec();
		StructureRequest innerRequest = StructureTestUtil.createExampleRequest(innerStrucSpec, true, "innerRequest", structureOperatorName);
		StructureSpecification outerStrucSpec = new StructureSpecificationImpl();
		outerStrucSpec.setOrdered(true);
		List<Field> fields = new ArrayList<>();
		addToFieldList(fields,innerRequest,true);
		addToFieldList(fields, innerRequest, false);
		addToFieldList(fields,exampleStringRequest,true);
		addToFieldList(fields, exampleStringRequest, false);
		outerStrucSpec.setFields(fields);
		initRequests();
		initRequest(innerRequest);
		StructureRequest outerRequest = StructureTestUtil.createExampleRequest(outerStrucSpec, false, "outerRequest", structureOperatorName);
		StructureRequestProcessor proc = new StructureRequestProcessor(outerRequest, UUID.randomUUID());
		StructureResponse resp = (StructureResponse) proc.getResponse();
		assertEquals(1,resp.getFuzzedStructures().size());
		Structure fuzzedStruc = resp.getFuzzedStructures().get(0).getValue();
		for(int i=0;i<fuzzedStruc.getFields().size();i++){
			de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Field<CommonResponse> field = fuzzedStruc.getFields().get(i);
			if(i%2==0){
				assertTrue(field.isValueFuzzed());
			} else{
				assertFalse(field.isValueFuzzed());
				assertTrue(field.getValue() instanceof ValidValuesResponse<?>);
				if(i==0){
					ValidValuesResponse<Structure> validValues = (ValidValuesResponse<Structure>) field.getValue();
					assertEquals(1,validValues.getValidValues().size());
					Structure validStruc = validValues.getValidValues().get(0);
					assertEquals(4,validStruc.getFields().size());
					//check structure content:
					assertEquals(validNumbers,((ValidValuesResponse<String>) validStruc.getFields().get(0).getValue()).getValidValues());
					assertEquals(validNumbers,((ValidValuesResponse<String>) validStruc.getFields().get(1).getValue()).getValidValues());
					assertEquals(validStrings,((ValidValuesResponse<String>) validStruc.getFields().get(2).getValue()).getValidValues());
					assertEquals(validStrings,((ValidValuesResponse<String>) validStruc.getFields().get(3).getValue()).getValidValues());
				} else if(i==2){
					ValidValuesResponse<String> validValues = (ValidValuesResponse<String>) field.getValue();
					assertEquals(validStrings,validValues.getValidValues());
				}
			}
		}		
	}	

	private void initRequest(StructureRequest request) {
		new StructureRequestProcessor(request, UUID.randomUUID());
	}

	private StructureSpecification buildInnerRequestSpec() {
		StructureSpecificationImpl strucSpec = new StructureSpecificationImpl();
		strucSpec.setOrdered(true);
		List<Field> fields = new ArrayList<>();
		addToFieldList(fields, exampleNumberRequest, true);
		addToFieldList(fields, exampleNumberRequest, false);
		addToFieldList(fields, exampleStringRequest, true);
		addToFieldList(fields, exampleStringRequest, false);
		strucSpec.setFields(fields);
		return strucSpec;
	}

	private void addToFieldList(List<Field> fields, CommonRequest request, boolean fuzzField) {
		Field field = new FieldImpl();
		field.setFuzz(fuzzField);
		field.setValueRequest(request);
		fields.add(field);
	}

	private void initRequests() {
		new IntegerRequestProcessor(exampleNumberRequest,UUID.randomUUID());
		new StringRequestProcessor(exampleStringRequest, UUID.randomUUID());
	}

}
