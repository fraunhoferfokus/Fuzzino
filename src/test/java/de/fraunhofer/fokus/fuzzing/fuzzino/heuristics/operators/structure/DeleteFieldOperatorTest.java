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

import java.util.UUID;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.StructureRequestProcessor;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure_tests.StructureRequestProcessorFuzzAllFieldsTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure_tests.StructureTestUtil;

public class DeleteFieldOperatorTest extends FuzzinoTest {

	@Test
	public void fuzzStructureOnly() {
		StructureSpecification strucSpec = StructureRequestProcessorFuzzAllFieldsTest.buildExampleStructureSpecificationWithStringAndNumber();
		//struc Spec contains two fields
		StructureRequest req = StructureTestUtil.createExampleRequest(strucSpec,true,"testStructureRequest", "DeleteField");
		StructureRequestProcessor proc = new StructureRequestProcessor(req, new UUID(0, 0));
	    StructureResponse resp = (StructureResponse) proc.buildResponse();
	    //two fuzzed structures should be created:
	    assertEquals(2,resp.getFuzzedStructures().size());
	    //each fuzzed structure should contain one field:
	    FuzzedValue<Structure> fuzzedStruc = resp.getFuzzedStructures().get(0);
	    assertEquals(1,fuzzedStruc.getValue().getFields().size());
	    fuzzedStruc = resp.getFuzzedStructures().get(1);
	    assertEquals(1,fuzzedStruc.getValue().getFields().size());
	}

}
