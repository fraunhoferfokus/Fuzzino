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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.structure;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringType;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.impl.FieldImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.impl.StructureSpecificationImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.CommonResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.StructureImpl;
public class TypeDependentFieldSwapOperatorTest {

	/**
	 * The tests are executed with exactly the following structure:
	 * struct{
	 * 		NumberRequest
	 * 		NumberRequest
	 * 		StringRequest (Date)
	 * 		StringRequest (Date)
	 * 		StringRequest (Filename)
	 * }
	 */
	
	@Test
	public void typeUnconformOperatorTest() throws IOException {
		StructureSpecification typeMixedStructure = createMixedStructureSpec();
		Structure struc = buildStructureWithDummyResponses(typeMixedStructure);
		TypeUnConformFieldSwapOperator op = new TypeUnConformFieldSwapOperator(struc, 10);
		assertEquals(5,op.size());
		for(int i=0;i<op.size();i++){
			Structure fuzzedStruc = op.computeElement(i).getValue();
			assertCountOfUnequalFields(struc,fuzzedStruc,2);
			//TODO: assert the type difference at field with index i? For now Difficult to do and almost certainly correct
		}
	}

	@Test
	public void typeConformOperatorTest() throws IOException{
		StructureSpecification typeMixedStructure = createMixedStructureSpec();
		Structure struc = buildStructureWithDummyResponses(typeMixedStructure);
		TypeConformFieldSwapOperator op = new TypeConformFieldSwapOperator(struc, 10);
		assertEquals(4,op.size());
		for(int i=0;i<op.size();i++){
			Structure fuzzedStruc = op.computeElement(i).getValue();
			assertCountOfUnequalFields(struc,fuzzedStruc,2);
			//TODO: assert the type equality at field with index i? For now Difficult to do and almost certainly correct
		}
	}

	private void assertCountOfUnequalFields(Structure struc,Structure fuzzedStruc, int unequalityCount) {
		int count = 0;
		for(int i=0;i<struc.getFields().size();i++){
			if(!struc.getFields().get(i).equals(fuzzedStruc.getFields().get(i))){
				count++;
			}
		}
		assertEquals(count,unequalityCount);
	}

	private Structure buildStructureWithDummyResponses(StructureSpecification typeMixedStructure) {
		Structure struc = new StructureImpl();
		struc.setStructureSpecification(typeMixedStructure);
		for(int i=0;i<typeMixedStructure.getFields().size();i++){
			de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Field<CommonResponse> structureField = new de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.FieldImpl<>();
			structureField.setValue(new DummyCommonResponse());
			struc.add(structureField);
		}
		return struc;
	}

	/**
	 * 
	 * @return a structureSpecification with two number requests and 2 String Requests of the same type and 1 other String request of another type
	 * @throws InvalidABNFFileException 
	 * @throws IOException 
	 */
	private StructureSpecification createMixedStructureSpec() throws IOException {
		StructureSpecification strucSpec = new StructureSpecificationImpl();
		strucSpec.addField(getNumberField());
		strucSpec.addField(getNumberField());
		strucSpec.addField(getStringField(StringType.DATE));
		strucSpec.addField(getStringField(StringType.DATE));
		strucSpec.addField(getStringField(StringType.FILENAME));
		strucSpec.setOrdered(true);
		return strucSpec;	
	}

	private Field getStringField(StringType value) {
		Field stringField = new FieldImpl();
		StringRequest req = RequestFactory.INSTANCE.createStringRequest();
		StringSpecification stringSpec = RequestFactory.INSTANCE.createStringSpecification();
		stringSpec.setType(value);
		req.setSpecification(stringSpec);
		stringField.setValueRequest(req);
		return stringField;
	}

	private Field getNumberField() {
		Field numberField = new FieldImpl();
		numberField.setValueRequest(RequestFactory.INSTANCE.createNumberRequest());
		return numberField;
	}

}
