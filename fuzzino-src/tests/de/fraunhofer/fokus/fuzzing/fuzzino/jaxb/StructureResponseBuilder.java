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
package de.fraunhofer.fokus.fuzzing.fuzzino.jaxb;

import java.util.Arrays;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.structure.DeleteFieldOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FieldImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.StructureResponseImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.StructureImpl;

public class StructureResponseBuilder {

	public static StructureResponse initStructureResponse() {
		StructureResponse resp = new StructureResponseImpl();
		resp.setFuzzedStructures(initFuzzedStructures());
		resp.setId("fuzz struc id");
		resp.setMoreValuesAvailable(true);
		resp.setName("fuzz struc name");
		resp.setSeed(1234667);
		resp.setWarningsSection(StringResponseBuilder.initWarningsSection());
		return resp;
	}

	private static List<FuzzedValue<Structure>> initFuzzedStructures() {
		FuzzedValue<Structure> val1 = new FuzzedValue<>(initSimpleStructure(),initSimpleStructure(),new DeleteFieldOperator(initSimpleStructure(), 13));
		FuzzedValue<Structure> val2 = new FuzzedValue<>(initSimpleStructure(),initSimpleStructure(),new DeleteFieldOperator(initSimpleStructure(), 13));
		return Arrays.asList(val1,val2);
	}

	private static Structure initSimpleStructure() {
		Structure struc = new StructureImpl();
		struc.setFields(initFields());
		struc.setStructureSpecification(StructureRequestBuilder.initStructureSpec());
		return struc;
	}


	private static List<Field> initFields() {
		Field f1 = new FieldImpl();
		f1.setCorrespondingResponseId("corresponding id 1");
		f1.setName("f1");
		f1.setValueIsFuzzed(true);
		Field f2 = new FieldImpl();
		f2.setCorrespondingResponseId("corresponding id 2");
		f2.setName("f2");
		f2.setValueIsFuzzed(true);
		return Arrays.asList(f1,f2);
	}

}
