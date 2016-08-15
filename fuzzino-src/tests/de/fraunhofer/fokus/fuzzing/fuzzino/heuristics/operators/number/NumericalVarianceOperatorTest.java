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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.number;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.IntegerOperatorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;

public class NumericalVarianceOperatorTest extends FuzzinoTest {

	private static final long SEED = 4711;
	private static final String NO_PARAM = null;
	private static final IntegerSpecification NUMBER_SPEC = RequestFactory.INSTANCE.createNumberSpecification();
	static {
		NUMBER_SPEC.setBits(32);
		NUMBER_SPEC.setIsSigned(true);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testWithNullValue() {
		List<Long> nullValueList = new LinkedList<>();
		nullValueList.add(null);
		IntegerOperatorFactory.INSTANCE.createNumericalVarianceOperator(nullValueList, NO_PARAM, NUMBER_SPEC, SEED);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testWithNullList() {
		IntegerOperatorFactory.INSTANCE.createNumericalVarianceOperator((List<Long>)null, NO_PARAM, NUMBER_SPEC, SEED);
	}
	
	@Test
	public void testWithListOfOneLong() {
		List<Long> numberList = asList(1L);
		NumericalVarianceOperator numericalVarianceOperator = 
				IntegerOperatorFactory.INSTANCE.createNumericalVarianceOperator(numberList, NO_PARAM, NUMBER_SPEC, SEED);
		
		int expectedSize = 1;
		int actualSize = numericalVarianceOperator.getValidValues().size();
		assertTrue("Wrong number of valid values: was " + actualSize + " instead of " + expectedSize,
			    actualSize == expectedSize);
	}
	
	@Test
	public void testWithListOfTwoLongs() {
		List<Long> numberList = asList(1L, 42L);
		NumericalVarianceOperator numericalVarianceOperator = 
				IntegerOperatorFactory.INSTANCE.createNumericalVarianceOperator(numberList, NO_PARAM, NUMBER_SPEC, SEED);
		
		int expectedSize = 2;
		int actualSize = numericalVarianceOperator.getValidValues().size();
		assertTrue("Wrong number of valid values: was " + actualSize + " instead of " + expectedSize,
			    actualSize == expectedSize);
	}
	
	@Test
	public void testFuzzedValues() {
		List<Long> numberList = asList(1L, 42L);
		List<Long> expectedValues = asList(-9L, 32L, -8L, 33L, -7L, 34L, -6L, 35L, -5L, 36L, -4L, 37L, -3L,
				                           38L, -2L, 39L, -1L, 40L, 0L, 41L, 2L, 43L, 3L, 44L, 4L, 45L, 5L, 
				                           46L, 6L, 47L, 7L, 48L, 8L, 49L, 9L, 50L, 10L, 51L, 11L, 52L);
		NumericalVarianceOperator numericalVarianceOperator = 
				IntegerOperatorFactory.INSTANCE.createNumericalVarianceOperator(numberList, NO_PARAM, NUMBER_SPEC, SEED);

		int expectedSize = expectedValues.size();
		int actualSize = numericalVarianceOperator.size();
		assertTrue("Wrong size: was " + actualSize + " instead of " + expectedSize,
			    actualSize == expectedSize);
		
		for (int i=0; i<expectedSize; i++) {
			long expectedValue = expectedValues.get(i);
			long actualValue = numericalVarianceOperator.get(i).getValue();
			assertTrue("Wrong value at index " + i + ": was " + actualValue + " instead of " + expectedValue,
					   actualValue == expectedValue);
		}
	}
	
	@Test
	public void testFuzzedValuesWithNullParameter() {
		List<Long> numberList = asList(1L, 42L);
		List<Long> expectedValues = asList(-9L, 32L, -8L, 33L, -7L, 34L, -6L, 35L, -5L, 36L, -4L, 37L, -3L,
                38L, -2L, 39L, -1L, 40L, 0L, 41L, 2L, 43L, 3L, 44L, 4L, 45L, 5L, 
                46L, 6L, 47L, 7L, 48L, 8L, 49L, 9L, 50L, 10L, 51L, 11L, 52L);
		NumericalVarianceOperator numericalVarianceOperator = 
				IntegerOperatorFactory.INSTANCE.createNumericalVarianceOperator(numberList, "0", NUMBER_SPEC, SEED);
		
		int expectedSize = expectedValues.size();
		int actualSize = numericalVarianceOperator.size();
		assertTrue("Wrong size: was " + actualSize + " instead of " + expectedSize,
			    actualSize == expectedSize);
		
		for (int i=0; i<expectedSize; i++) {
			long expectedValue = expectedValues.get(i);
			long actualValue = numericalVarianceOperator.get(i).getValue();
			assertTrue("Wrong value at index " + i + ": was " + actualValue + " instead of " + expectedValue,
					   actualValue == expectedValue);
		}
	}
	
	@Test
	public void testFuzzedValuesWithMinus10Parameter() {
		List<Long> numberList = asList(1L, 42L);
		List<Long> expectedValues = asList(-9L, 32L, -8L, 33L, -7L, 34L, -6L, 35L, -5L, 36L, -4L, 37L, -3L,
                38L, -2L, 39L, -1L, 40L, 0L, 41L, 2L, 43L, 3L, 44L, 4L, 45L, 5L, 
                46L, 6L, 47L, 7L, 48L, 8L, 49L, 9L, 50L, 10L, 51L, 11L, 52L);
		NumericalVarianceOperator numericalVarianceOperator = 
				IntegerOperatorFactory.INSTANCE.createNumericalVarianceOperator(numberList, "-10", NUMBER_SPEC, SEED);
		
		int expectedSize = expectedValues.size();
		int actualSize = numericalVarianceOperator.size();
		assertTrue("Wrong size: was " + actualSize + " instead of " + expectedSize,
			    actualSize == expectedSize);
		
		for (int i=0; i<expectedSize; i++) {
			long expectedValue = expectedValues.get(i);
			long actualValue = numericalVarianceOperator.get(i).getValue();
			assertTrue("Wrong value at index " + i + ": was " + actualValue + " instead of " + expectedValue,
					   actualValue == expectedValue);
		}
	}
	
	
	@Test
	public void testFuzzedValuesWith3Parameter() {
		String varianceRange = "3";
		List<Long> numberList = asList(1L, 42L);
		List<Long> expectedValues = asList(-2L, 39L, -1L, 40L, 0L, 41L, 2L, 43L, 3L, 44L, 4L, 45L);
		NumericalVarianceOperator numericalVarianceOperator = 
				IntegerOperatorFactory.INSTANCE.createNumericalVarianceOperator(numberList, varianceRange, NUMBER_SPEC, SEED);
		
		int expectedSize = expectedValues.size();
		int actualSize = numericalVarianceOperator.size();
		assertTrue("Wrong size: was " + actualSize + " instead of " + expectedSize,
			    actualSize == expectedSize);
		
		for (int i=0; i<expectedSize; i++) {
			long expectedValue = expectedValues.get(i);
			long actualValue = numericalVarianceOperator.get(i).getValue();
			assertTrue("Wrong value at index " + i + ": was " + actualValue + " instead of " + expectedValue,
					   actualValue == expectedValue);
		}
	}
	
	public static List<Long> asList(Long ...values) {
		ArrayList<Long> listOfLongs = new ArrayList<>(values.length);
		for (int i=0; i<values.length; i++) {
			listOfLongs.add(values[i]);
		}
	
		return listOfLongs;
	}

}
