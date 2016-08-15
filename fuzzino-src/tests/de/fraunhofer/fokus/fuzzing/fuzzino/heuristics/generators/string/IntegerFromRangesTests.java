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

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.IntegerFromRanges;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.IntegerFromRangesBuilder;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.IntegerUtil;

public class IntegerFromRangesTests extends FuzzinoTest {
	
	private static final long SEED = 4711;
	private static final StringSpecification STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
	private static final ComputableFuzzingHeuristic<?> OWNER = new SmallGenerator(STRING_SPEC, SEED);
	private static final IntegerSpecification NUMBER_SPEC = RequestFactory.INSTANCE.createNumberSpecification();
	IntegerFromRanges intFromRanges;
	
	@Before
	public void init() {
		intFromRanges = new IntegerFromRanges(NUMBER_SPEC, 
				                              OWNER, 
				                              SEED, 
				                              new IntegerFromRanges.Builder(-2, -1)
		                                                           .addRange(0, 1)
		                                                           .addRange(2, 3));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidRange() {
		intFromRanges = new IntegerFromRanges(NUMBER_SPEC, 
				                              OWNER, 
				                              SEED, 
				                              new IntegerFromRanges.Builder(11, 10));
	}
	
	@Test
	public void testRangeOfOneValue() {
		intFromRanges = new IntegerFromRanges(NUMBER_SPEC, 
				                              OWNER, 
				                              SEED, 
				                              new IntegerFromRanges.Builder(10, 10));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNegativeInvalidRange() {
		intFromRanges = new IntegerFromRanges(NUMBER_SPEC, 
				                              OWNER, 
				                              SEED, 
				                              new IntegerFromRangesBuilder(-10, -11));
	}
	
	@Test
	public void testNegativeValidRange() {
		intFromRanges = new IntegerFromRanges(NUMBER_SPEC, 
				                              OWNER, 
				                              SEED, 
				                              new IntegerFromRangesBuilder(-11, -10));
	}
	
	@Test
	public void testSizeWithOneRange() {
		intFromRanges = new IntegerFromRanges(NUMBER_SPEC, 
				                              OWNER, 
				                              SEED, 
				                              new IntegerFromRanges.Builder(-10, 10));
		
		int expectedSize = 21;
		int actualSize = intFromRanges.size();
		assertTrue("Invalid size: was " + actualSize + " instead of " + expectedSize,
				   actualSize == expectedSize);
	}
	
	@Test
	public void testSizeWithTwoRanges() {
		intFromRanges = new IntegerFromRanges(NUMBER_SPEC, 
				                              OWNER, 
				                              SEED, 
				                              new IntegerFromRanges.Builder(-10, 10)
		                                                           .addRange(-20, -15));
		int expectedSize = 27;
		int actualSize = intFromRanges.size();
		assertTrue("Invalid size: was " + actualSize + " instead of " + expectedSize,
				   actualSize == expectedSize);

	}
	
	@Test
	public void testSizeWithThreeRanges() {
		int expectedSize = 6;
		int actualSize = intFromRanges.size();
		assertTrue("Invalid size: was " + actualSize + " instead of " + expectedSize,
				   actualSize == expectedSize);
	}
	
	@Test
	public void testValues() {
		List<Integer> expectedValues = IntegerUtil.asList(-2, 0, 2, -1, 1, 3);
		for (int i=0; i<expectedValues.size(); i++) {
			int expectedValue = expectedValues.get(i);
			int actualValue = intFromRanges.get(i).getValue();
			assertTrue("Wrong value at index " + i + ": was " + actualValue + " instead of " + expectedValue,
			           actualValue == expectedValue);
		}
	}
	
	

}
