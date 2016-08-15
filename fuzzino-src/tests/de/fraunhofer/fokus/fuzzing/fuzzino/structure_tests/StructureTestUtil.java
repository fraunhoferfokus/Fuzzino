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

import java.util.ArrayList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValuesSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.GeneratorImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.IntegerSpecificationImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.OperatorImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringRequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringSpecificationImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StructureRequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidValuesSectionImpl;

public class StructureTestUtil extends FuzzinoTest {

	
	public static StructureRequest createExampleRequest(StructureSpecification strucSpec, boolean fuzzStructure, String requestName, String structureOperatorName) {
		StructureRequest req = new StructureRequestImpl();
		if(fuzzStructure){
			//requested Operator:
			OperatorImpl op = new OperatorImpl(structureOperatorName);
			List<Operator> ops = new ArrayList<Operator>();
			ops.add(op);
			req.setRequestedOperators(ops);
		}
		//request initialization:
		req.setFuzzStructure(fuzzStructure);
		req.setName(requestName);
		req.setSpecification(strucSpec);
		req.setMaxValues(10);
		return req;
	}

	static StringRequest createNewExampleStringRequest(String name, long seed, StringSpecification stringSpec, String genName,List<String> validValues, int maxValues) {
		StringRequest sr = new StringRequestImpl();
		GeneratorImpl requestedGen = new GeneratorImpl();
		requestedGen.setGeneratorName(genName);
		sr.addRequestedGenerator(requestedGen);
		sr.setName(name);
		sr.setSpecification(stringSpec);
		sr.setMaxValues(maxValues);
		ValidValuesSection validValuesSection = new ValidValuesSectionImpl();
		validValuesSection.setValues(validValues);
		sr.setValidValuesSection(validValuesSection );
		return sr;
	}

	static NumberRequest createNewExampleNumberRequest(String name,long seed, IntegerSpecification numSpec, String genName, List<String> validValues) {
		NumberRequest nr = new NumberRequestImpl();
		GeneratorImpl requestedGen = new GeneratorImpl();
		requestedGen.setGeneratorName(genName);
		nr.addRequestedGenerator(requestedGen);
		nr.setName(name);
		nr.setNumberSpecification(numSpec);
		nr.setMaxValues(10);
		ValidValuesSection validValuesSection = new ValidValuesSectionImpl();
		validValuesSection.setValues(validValues);
		nr.setValidValuesSection(validValuesSection );
		return nr;
	}

	static StringSpecification createExampleStringSpec() {
		StringSpecification spec = new StringSpecificationImpl();
		spec.setMaxLength(10000);
		spec.setMinLength(1);
		spec.setIsNullTerminated(false);
		return spec;
	}

	static IntegerSpecification createExampleNumberSpec() {
		IntegerSpecification numSpec = new IntegerSpecificationImpl();
		numSpec.setMax(100000000L);
		numSpec.setMin(10L);
		return numSpec;
		
	}
}
