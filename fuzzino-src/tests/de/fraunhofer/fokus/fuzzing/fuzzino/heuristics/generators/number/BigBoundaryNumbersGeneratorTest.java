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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.BigIntegerGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.BigIntegerGeneratorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;

public class BigBoundaryNumbersGeneratorTest extends FuzzinoTest {

	private BigIntegerGenerator generator;
	private static final long SEED = 4711;
	private static final IntegerSpecification NUMBER_SPEC;
	static {
		NUMBER_SPEC = RequestFactory.INSTANCE.createNumberSpecification();
		NUMBER_SPEC.setBits(128);
		NUMBER_SPEC.setMinValue(BigInteger.valueOf(Long.MIN_VALUE).subtract(BigInteger.ONE));
		NUMBER_SPEC.setMaxValue(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE));
	}

	@Before
	public void init() {
		generator = BigIntegerGeneratorFactory.INSTANCE.createBoundaryNumbersGenerator(NUMBER_SPEC, SEED);
	}
	
	@Test
	public void testSize() {
		int expectedSize = 17;
		int actualSize = generator.size();
		
		assertTrue("Wrong size: was " + actualSize + " instead of " + expectedSize,
				   actualSize == expectedSize);
	}
	
	@Test
	public void testValues() {
		List<BigInteger> expectedValues = new ArrayList<>();
		expectedValues.add(BigInteger.valueOf(Long.MIN_VALUE).subtract(BigInteger.ONE));
		expectedValues.add(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE));
		
		for (FuzzedValue<BigInteger> fuzzedValue : generator) {
			expectedValues.remove(fuzzedValue.getValue());
		}
		assertTrue("Missing " + expectedValues.size() + " values: " + expectedValues,
				   expectedValues.isEmpty());
	}

}
