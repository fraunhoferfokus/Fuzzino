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

import java.util.LinkedList;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.CommonResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.FieldImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.StructureImpl;

public class NeighbouringFieldSwapOperatorTest {

	private static final long SEED = 10;

	@Test
	public void test() {
		int fieldCount = 10;
		NeighbouringFieldSwapOperator op = new NeighbouringFieldSwapOperator(getExampleStructure(fieldCount),SEED);
		assertEquals(fieldCount-1,op.size());
		for(int i=0;i<op.size();i++){
			//assert the swapping occured correctly:
			FuzzedValue<Structure> fuzzedStructure = op.computeElement(i);
			Structure original = fuzzedStructure.getBasedOnValue();
			Structure mutated = fuzzedStructure.getValue();
			assertEquals(original.getFields().get(i),mutated.getFields().get(i+1));
			assertEquals(original.getFields().get(i+1),mutated.getFields().get(i));
		}
	}

	private Structure getExampleStructure(int fieldCount) {
		LinkedList<Field<CommonResponse>> fields = new LinkedList<>();
		//fill fieldList:
		for(int i =0;i<fieldCount;i++){
			FieldImpl<CommonResponse> a = new FieldImpl<>();
			a.setValue(new DummyCommonResponse());
			fields.add(a);
		}
		Structure struc = new StructureImpl();
		struc.setFields(fields);
		return struc;
	}

}
