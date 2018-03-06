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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.ComposedFuzzingHeuristicTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class BadLongStringsGeneratorTest extends ComposedFuzzingHeuristicTest<String> {

	public static final long SEED = 4711;
	public static final StringSpecification STRING_SPEC;
	public static final StringSpecification STRING_SPEC_WITH_LENGTH;
	
	static {
		STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
		
		STRING_SPEC_WITH_LENGTH = RequestFactory.INSTANCE.createStringSpecification();
		STRING_SPEC_WITH_LENGTH.setMinLength(1);
		STRING_SPEC_WITH_LENGTH.setMaxLength(1);
	}

	@Before
	public void init() {
		composedHeuristics = new BadLongStringsGenerator(STRING_SPEC, SEED);
		expectedValues = new ArrayList<>();
		
		for (int i=1; i<=1000; i++) {
			expectedValues.add(StringUtil.repeat("A\\x00", 10 * i));
		}

		for (int i=1; i<=100; i++) {
			expectedValues.add(StringUtil.repeat("A\\x00", 127 * i));
		}

		for (int i=1; i<=10; i++) {
			expectedValues.add(StringUtil.repeat("A\\x00", 1024 * i));
		}
		
		for (int i=-50; i<=49; i++) {
			expectedValues.add(Integer.toString(i));
		}
		
		for (int i=-178; i<=-79; i++) {
			expectedValues.add(Integer.toString(i));
		}
		
		for (int i=77; i<=176; i++) {
			expectedValues.add(Integer.toString(i));
		}
		
		for (int i=205; i<=304; i++) {
			expectedValues.add(Integer.toString(i));
		}
		
		for (int i=-32818; i<=-32719; i++) {
			expectedValues.add(Integer.toString(i));
		}
		
		for (int i=32717; i<=32816; i++) {
			expectedValues.add(Integer.toString(i));
		}
		
		for (int i=65485; i<=65584; i++) {
			expectedValues.add(Integer.toString(i));
		}
		for (long i=-2147483698l; i<=-2147483599l; i++) {
			expectedValues.add(Long.toString(i));
		}
		
		for (long i=2147483597l; i<=2147483696l; i++) {
			expectedValues.add(Long.toString(i));
		}
		
		for (long i=4294967245l; i<=4294967344l; i++) {
			expectedValues.add(Long.toString(i));
		}
		
		BigInteger bi = new BigInteger("-9223372036854775858");
		BigInteger biEnd = new BigInteger("-9223372036854775759");
		do {
			expectedValues.add(bi.toString());
			bi = bi.add(BigInteger.ONE);
		} while (bi.compareTo(biEnd) <= 0);
		
		bi = new BigInteger("9223372036854775757");
		biEnd = new BigInteger("9223372036854775856");
		do {
			expectedValues.add(bi.toString());
			bi = bi.add(BigInteger.ONE);
		} while (bi.compareTo(biEnd) <= 0);

		bi = new BigInteger("18446744073709551565");
		biEnd = new BigInteger("18446744073709551664");
		do {
			expectedValues.add(bi.toString());
			bi = bi.add(BigInteger.ONE);
		} while (bi.compareTo(biEnd) <= 0);
		
		expectedValues.add("\\x00\\x00" + StringUtil.repeat("A", 7000));
		expectedValues.add("%00%00" + StringUtil.repeat("A", 7000));
		expectedValues.add("10");
	}
	
	@Test
	public void testIgnoreLength() {
		BadLongStringsGenerator badLongStringsGenerator = new BadLongStringsGenerator(STRING_SPEC_WITH_LENGTH, SEED);
		int counter = 0;
		for (FuzzedValue<String> fuzzedValue : badLongStringsGenerator) {
			String fuzzedValueItself = fuzzedValue.getValue();
			int length = fuzzedValueItself.length();
			assertTrue(length >= 1);
			counter++;
		}
		
		assertTrue(counter >= 100);
	}
	
}
