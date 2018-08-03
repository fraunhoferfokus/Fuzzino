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
package de.fraunhofer.fokus.fuzzing.fuzzino;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.BadFloatGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.FloatSpecificationImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.GeneratorImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse;

public class FloatRequestProcessorTest extends FuzzinoTest {

	@Test
	public void oneGen() {
		NumberSpecification<Double> numSpec = new FloatSpecificationImpl(0.1, 0.5);
		NumberRequest req = new NumberRequestImpl();
		req.setRequestedGenerators(new ArrayList<Generator>(Arrays.asList(new GeneratorImpl("BadFloat"))));
		req.setName("reqname");
		req.setMaxValues(100);
		req.setNumberSpecification(numSpec);
		req.setSeed(10);
		req.setUseNoGenerators(false);
		FloatRequestProcessor reqProc = new FloatRequestProcessor(req, UUID.randomUUID());
		NumberResponse<Double> resp = reqProc.getResponse();
		//expected content:
		BadFloatGenerator gen= new BadFloatGenerator(numSpec, 10);
		List<Double> expected = gen.getFuzzValues();
		assertEquals(1,resp.getGeneratorBasedSection().getGeneratorSpecificSections().size());
		for(FuzzedValue<Double> val : resp.getGeneratorBasedSection().getGeneratorSpecificSections().get(0)){
			expected.remove(val.getValue());
		}
		assertEquals(0, expected.size());
	}
	
	@Test
	public void testAllGens(){
		NumberSpecification<Double> numSpec = new FloatSpecificationImpl(0.1, 0.5);
		NumberRequest req = new NumberRequestImpl();
		req.setRequestedGenerators(new ArrayList<Generator>());
		req.setName("reqname");
		req.setMaxValues(100);
		req.setNumberSpecification(numSpec);
		req.setSeed(10);
		req.setUseNoGenerators(false);
		FloatRequestProcessor reqProc = new FloatRequestProcessor(req, UUID.randomUUID());
		NumberResponse<Double> resp = reqProc.getResponse();
		//expected content:
		BadFloatGenerator gen= new BadFloatGenerator(numSpec, 10);
		List<Double> expected = gen.getFuzzValues();
		assertEquals(1,resp.getGeneratorBasedSection().getGeneratorSpecificSections().size());
		for(FuzzedValue<Double> val : resp.getGeneratorBasedSection().getGeneratorSpecificSections().get(0)){
			expected.remove(val.getValue());
		}
		assertEquals(0, expected.size());
	}

}
