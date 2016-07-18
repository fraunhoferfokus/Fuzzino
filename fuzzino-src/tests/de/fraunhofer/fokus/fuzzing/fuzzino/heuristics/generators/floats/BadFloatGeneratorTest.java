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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.floats;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.BadFloatGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.NumberSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.impl.FloatSpecificationImpl;

public class BadFloatGeneratorTest extends FuzzinoTest {

	@Test
	public void test() {
		NumberSpecification<Double> floatSpec = new FloatSpecificationImpl(0.1, 0.5);
		List<Double> expected = new ArrayList<>(Arrays.asList(0.1,0.5,Double.MAX_VALUE,Double.MIN_VALUE,Double.NaN,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY));
		BadFloatGenerator gen = new BadFloatGenerator(floatSpec, 10);
		for(FuzzedValue<Double> val:gen){
			System.out.println(val.getValue());
			expected.remove(val.getValue());
		}
		assertEquals(0,expected.size());
	}

}
