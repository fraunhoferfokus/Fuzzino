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

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BigIntFromRangesAsString;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.SmallGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;

public class BigIntFromRangesAsStringTest {

	protected static final long SEED = 4711;
	protected static final int MIN_LENGTH = 2;
	protected static final int MAX_LENGTH = 3;
	protected static final SmallGenerator OWNER;
	protected static final StringSpecification STRING_SPEC;
	protected BigIntFromRangesAsString HEURISTIC;
	static {
		STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
		STRING_SPEC.setMinLength(MIN_LENGTH);
		STRING_SPEC.setMaxLength(MAX_LENGTH);
		OWNER = new SmallGenerator(STRING_SPEC, SEED);
	}
	
	@Before
	public void init() {
		HEURISTIC = 
				new BigIntFromRangesAsString(STRING_SPEC, OWNER, SEED, new BigIntFromRangesAsString.Builder(
						                                                           new BigInteger("-9223372036854775858"),
				                                                                   new BigInteger("-9223372036854775759"))
		                                                                 .addRange(new BigInteger("9223372036854775757"), 
		                                                                   		   new BigInteger("9223372036854775856"))
		                                                                 .addRange(new BigInteger("18446744073709551565"),
		                                                                           new BigInteger("18446744073709551664")));
	}
	
	@Test
	public void testValues() {
		List<String> expectedValues = computeExpectedValues();
		
		int index = 0;
		for (FuzzedValue<String> fuzzedValue : HEURISTIC) {
			String value = fuzzedValue.getValue();
			assertTrue("Unknown value \"" + value + "\" at index " + index,
					   expectedValues.contains(value));
			index++;
		}
	}
	
	@Test
	public void testSpecialValue() {
		FuzzedValue<String> fuzzedValue_1 = HEURISTIC.get(1);
		FuzzedValue<String> fuzzedValue_148 = HEURISTIC.get(148);
		
		String value_1 = fuzzedValue_1.getValue();
		String value_148 = fuzzedValue_148.getValue();
		
		assertTrue("Values are different: \"" + value_1 + "\" vs. \"" + value_148 + "\"",
				   !value_1.equals(value_148));
	}
	
	public List<String> computeExpectedValues() {
		List<String> expectedValues = new ArrayList<>();
		
		List<BigInteger> startIndices = new ArrayList<>();
		startIndices.add(new BigInteger("-9223372036854775858"));
		startIndices.add(new BigInteger("9223372036854775757"));
		startIndices.add(new BigInteger("18446744073709551565"));
		
		List<BigInteger> stopIndices = new ArrayList<>();
		stopIndices.add(new BigInteger("-9223372036854775759"));
		stopIndices.add(new BigInteger("9223372036854775856"));
		stopIndices.add(new BigInteger("18446744073709551664"));
		
		for (int i=0; i<startIndices.size(); i++) {
			BigInteger startIndex = startIndices.get(i);
			BigInteger stopIndex = stopIndices.get(i);
			for (BigInteger j=startIndex; j.compareTo(stopIndex)<=0; j = j.add(BigInteger.ONE)) {
				expectedValues.add(j.toString());
			}
		}
		
		return expectedValues;
	}

}
