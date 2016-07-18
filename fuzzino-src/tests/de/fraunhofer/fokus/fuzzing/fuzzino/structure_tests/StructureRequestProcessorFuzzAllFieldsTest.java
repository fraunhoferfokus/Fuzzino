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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.IntegerRequestProcessor;
import de.fraunhofer.fokus.fuzzing.fuzzino.StringRequestProcessor;
import de.fraunhofer.fokus.fuzzing.fuzzino.StructureRequestProcessor;
import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.IntegerGeneratorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGeneratorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StructureRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.impl.FieldImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.impl.StructureSpecificationImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IntegerResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StructureResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;

/***
 * 
 * @author Leon Bornemann (leon.bornemann@fokus.fraunhofer.de ) 
 * This class provides integration tests for the fuzzing process of structures. 
 * This includes specification and operator requests, StructureRequest, processing of the request and checking the response
 * This test class focuses on tests where all fields of the structure are fuzzed.
 */
public class StructureRequestProcessorFuzzAllFieldsTest extends FuzzinoTest {

	/*These are a few constants that are necessary, since in order to test the StructureRequestProcessor a few string/number generators are needed,
	 * as well as a structure-operator to ensure that operators are executed properly. 
	 * 
	 */
	private static final String EXAMPLE_NUMBER_GENERATOR_1 = "BoundaryNumbers";
	private static final String EXAMPLE_STRING_GENERATOR_2_NAME = "BadFilenames";
	private static final String EXAMPLE_STRING_GENERATOR_1_NAME = "AllBadStrings";
	private static final String EXAMPLE_STRUCTURE_OPERATOR_NAME = "DublicateField"; //watch out! if this is changed some assertions in testcases need to change (since behavior of this operator is tested in assertions)
	public static final long seed = -1;
	private static final StringSpecification exampleStringSpec = StructureTestUtil.createExampleStringSpec();
	private static final IntegerSpecification exampleNumberSpec = StructureTestUtil.createExampleNumberSpec();

	@Test
	public void fuzzContentOnlyTest() throws UnknownFuzzingHeuristicException{
		StructureSpecification strucSpec = buildExampleStructureSpecificationWithStringAndNumber();
		//request initialization:
		StructureRequest req = StructureTestUtil.createExampleRequest(strucSpec,false,"testStructureRequest", EXAMPLE_STRUCTURE_OPERATOR_NAME);
		//execute request
		StructureRequestProcessor proc = new StructureRequestProcessor(req, new UUID(0, 0));
	    StructureResponse resp = (StructureResponse) proc.buildResponse();
	    FuzzedValue<Structure> fuzzedStruc = resp.getFuzzedStructures().get(0);
	    //assert that structure stayed the same:
	    assertEquals(2,fuzzedStruc.getValue().getFields().size());
	    //get the field contents
	    StringResponse resp1 = (StringResponse) fuzzedStruc.getValue().getFields().get(0).getValue();
	    IntegerResponse resp2 = (IntegerResponse) fuzzedStruc.getValue().getFields().get(1).getValue();
	    List<FuzzedValue<String>> stringvals = resp1.getGeneratorBasedSection().getGeneratorSpecificSections().get(0).getFuzzedValues();
	    List<FuzzedValue<Long>> longvals = resp2.getGeneratorBasedSection().getGeneratorSpecificSections().get(0).getFuzzedValues();
	    //Compare to the values created by the generators, they must be all equal:
	    Iterator<FuzzedValue<String>> genValueStringIterator = StringGeneratorFactory.INSTANCE.create(EXAMPLE_STRING_GENERATOR_1_NAME, null, exampleStringSpec, seed).iterator();
	    for(FuzzedValue<String> val :stringvals){
			assertEquals(genValueStringIterator.next().getValue(),val.getValue());
	    }
	    Iterator<FuzzedValue<Long>> genValueLongIterator = IntegerGeneratorFactory.INSTANCE.create(EXAMPLE_NUMBER_GENERATOR_1, null, exampleNumberSpec, seed).iterator();
	    for(FuzzedValue<Long> val :longvals){
	    	assertEquals(genValueLongIterator.next().getValue(),val.getValue());
	    }
	    
	}
	
	@Test
	public void fuzzContentAndStructureDifferentFieldTypesTest(){
		StructureSpecification strucSpec = buildExampleStructureSpecificationWithStringAndNumber();
		fuzzContentAndStructure(strucSpec);
	}
	
	@Test
	public void fuzzContentAndStructureTestSameFieldTypesTest(){
		StructureSpecification strucSpec = buildExampleStringOnlyStructureSpecification();
		fuzzContentAndStructure(strucSpec);
	}
	
	/***
	* This test tests if the following structure is processed correctly:
	* 
	* struct{
	* 		Field_1 = StringRequest
	* 		Field_2 = NumberRequest
	* 		Field_3 = struct{
	* 						Field_1 = StringRequest
	* 						Field_2 = StringRequest
	* 		}
	* }
	*	
	*/
	@Test
	public void fuzzNestedStructureTest(){
		StructureSpecification outerStructureSpec = buildExampleStructureSpecificationWithStringAndNumber();
		//build nested structure:
		StructureSpecification innerStrucSpec = buildExampleStringOnlyStructureSpecification();
		StructureRequest innerStructureRequest = StructureTestUtil.createExampleRequest(innerStrucSpec, false, "innerStructureRequest", EXAMPLE_STRUCTURE_OPERATOR_NAME);
		//create processor for the structure request:
		new StructureRequestProcessor(innerStructureRequest, new UUID(0, 0));
		//add the inner structure request as an extra field
		Field field_3 = new FieldImpl();
		field_3.setFuzz(true);
		field_3.setValueRequest(innerStructureRequest);
		outerStructureSpec.addField(field_3);
		StructureRequest outerRequest = StructureTestUtil.createExampleRequest(outerStructureSpec, true, "topStructureRequest", EXAMPLE_STRUCTURE_OPERATOR_NAME);
		//execute top request:
		StructureRequestProcessor proc = new StructureRequestProcessor(outerRequest, new UUID(0, 0));
	    StructureResponse resp = (StructureResponse) proc.buildResponse();
	    //test if everything worked:
	    assertEquals(3,resp.getFuzzedStructures().size());
	    Structure exampleStruc = resp.getFuzzedStructures().get(0).getValue();
	    //assert that dublicateField works correctly:
	    assertEquals(exampleStruc.getFields().get(0),exampleStruc.getFields().get(1));
	    assertEquals(4,exampleStruc.getFields().size());
	    //check if the third element is a structure element, otherwise this throws an exception:
	    StructureResponse nestedResp = (StructureResponse) exampleStruc.getFields().get(3).getValue();
	    assertEquals(1,nestedResp.getFuzzedStructures().size()); //we did not fuzz the structure here so there can only be one result
	    assertEquals(2,nestedResp.getFuzzedStructures().get(0).getValue().getFields().size()); //with 2 fields
	}
	
	//Helper methods
	
	private void fuzzContentAndStructure(StructureSpecification strucSpec){
		//StructureSpecification strucSpec = buildExampleStructureSpecification(true,false);
		StructureRequest req = StructureTestUtil.createExampleRequest(strucSpec, true, "testStructureRequest", EXAMPLE_STRUCTURE_OPERATOR_NAME);
		StructureRequestProcessor proc = new StructureRequestProcessor(req, new UUID(0, 0));
	    StructureResponse resp = (StructureResponse) proc.buildResponse();
	    assertEquals(2,resp.getFuzzedStructures().size());
	    //test if structure operator worked correctly:
	    FuzzedValue<Structure> fuzzedStruc1 = resp.getFuzzedStructures().get(0);
	    assertEquals(3,fuzzedStruc1.getValue().getFields().size());
	    assertEquals(fuzzedStruc1.getValue().getFields().get(0),fuzzedStruc1.getValue().getFields().get(1));
	    FuzzedValue<Structure> fuzzedStruc2 = resp.getFuzzedStructures().get(1);
	    assertEquals(3,fuzzedStruc2.getValue().getFields().size());
	    assertEquals(fuzzedStruc2.getValue().getFields().get(1),fuzzedStruc2.getValue().getFields().get(2));
	    //no need to check the contents, they are being checked inside the testcase fuzzContentOnlyTest()
	}

	public static StructureSpecification buildExampleStringOnlyStructureSpecification() {
		//structure specification;
		StructureSpecificationImpl strucSpec = createEmptyStructureSpecification(2);
		initStringRequests(strucSpec.getFields().get(0), strucSpec.getFields().get(1));
		return strucSpec;
	}
	
	public static StructureSpecification buildExampleStructureSpecificationWithStringAndNumber(){
		StructureSpecificationImpl strucSpec = createEmptyStructureSpecification(2);
		initStringAndNumberRequest(strucSpec.getFields().get(0), strucSpec.getFields().get(1));
		return strucSpec;
	}
	
	private static StructureSpecificationImpl createEmptyStructureSpecification(int fieldCount) {
		ArrayList<Field> fieldList = new ArrayList<Field>();
		for(int i= 0;i<fieldCount;i++){
			FieldImpl field = new FieldImpl();
			field.setFuzz(true);
			fieldList.add(field);
		}
		StructureSpecificationImpl strucSpec = new StructureSpecificationImpl();
		strucSpec.setFields(fieldList);
		strucSpec.setOrdered(true);
		return strucSpec;
	}

	private static void initStringRequests(Field a, Field b) {
		StringRequest req1 = StructureTestUtil.createNewExampleStringRequest("field1",seed,exampleStringSpec, EXAMPLE_STRING_GENERATOR_1_NAME,new LinkedList<String>(), 10);
		a.setValueRequest(req1);
		StringRequest req2 = StructureTestUtil.createNewExampleStringRequest("field2",seed,exampleStringSpec, EXAMPLE_STRING_GENERATOR_2_NAME,new LinkedList<String>(), 10);
		b.setValueRequest(req2);
		//create processors, they are automatically added to the processorregistry:
		new StringRequestProcessor(req1, UUID.randomUUID());
		new StringRequestProcessor(req2, UUID.randomUUID());
	}
	
	private static void initStringAndNumberRequest(Field a, Field b) {
		StringRequest req1 = StructureTestUtil.createNewExampleStringRequest("field1",seed,exampleStringSpec, EXAMPLE_STRING_GENERATOR_1_NAME,new LinkedList<String>(), 10);
		a.setValueRequest(req1);
		NumberRequest req2 = StructureTestUtil.createNewExampleNumberRequest("field2",seed,exampleNumberSpec , EXAMPLE_NUMBER_GENERATOR_1,new LinkedList<String>());
		b.setValueRequest(req2);
		//create processors, they are automatically added to the processorregistry:
		new StringRequestProcessor(req1, UUID.randomUUID());
		new IntegerRequestProcessor(req2, UUID.randomUUID());
	}
}
