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

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.NoMatchingValuesException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.AscendingIntegerList.Builder;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.SmallGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

public class AscendingIntegerListTest extends FuzzinoTest {
	
	private static final long SEED = 4711;
	private static final StringSpecification STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
	private static final SmallGenerator OWNER = new SmallGenerator(STRING_SPEC, SEED);
	private static final IntegerSpecification NUMBER_SPEC = RequestFactory.INSTANCE.createNumberSpecification();
	private AscendingIntegerList ascIntList;
	
	@Before
	public void init() throws NoMatchingValuesException {
		ascIntList = new AscendingIntegerList(NUMBER_SPEC,
				                              Arrays.asList(OWNER), 
				                              SEED, 
				                              new AscendingIntegerList.Builder(-10, 10)
		                                                              .stepSize(2));
	}

	@Test
	public void testSize() {
		int expectedSize = 10;
		int actualSize = ascIntList.size();
		assertTrue("Size was " + actualSize + " instead of " + expectedSize,
				   actualSize == expectedSize);
	}
	
	@Test
	public void testIteratorHasNext() {
		boolean expectedHasNext = true;
		boolean actualHasNext = ascIntList.iterator().hasNext();
		assertTrue("hasNext() was " + actualHasNext + " instead of " + expectedHasNext, 
				   actualHasNext == expectedHasNext);
	}
	
	@Test
	public void testComputingIteratorNext() {
		Integer exptectedElement = -10;
		Integer actualElement = ascIntList.iterator().next().getValue();
		assertTrue("next() returns " + actualElement + " instead of " + exptectedElement, 
				   actualElement.equals(exptectedElement));
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testDefaultIterations() {
		int iterations = 0;
		
		Iterator<FuzzedValue<Integer>> i = ascIntList.iterator();
		while (i.hasNext()) {
			Integer actualElement = i.next().getValue();
			Integer expectedElement = -10 + 2 * iterations;
			assertTrue("Returned value was " + actualElement + " instead of " + expectedElement, 
					   actualElement.equals(expectedElement));
			iterations++;
		}
		
		int expectedIterations = 10;
		int actualIterations = iterations;
		assertTrue("Iterations are " + actualIterations + " instead of " + expectedIterations, 
				   actualIterations == expectedIterations);
		
		boolean expectedHasNext = false;
		boolean actualHasNext = i.hasNext();
		assertTrue("hasNext is true instead of " + expectedHasNext, 
				   actualHasNext == expectedHasNext);
		
		i.next();
	}
	
	@Test
	public void test_makeBuilderMatchingSpecification() throws NoMatchingValuesException {
		IntegerSpecification numberSpec = RequestFactory.INSTANCE.createNumberSpecification();
		numberSpec.setMin(0L);
		Builder builder = new Builder(-100, 200).stepSize(1);
		AscendingIntegerList ail = new AscendingIntegerList(numberSpec, Arrays.asList(OWNER), 0, builder);
		
		Builder matchingBuilder = ail.makeBuilderMatchingSpecification(builder);
		testMatchingBuilderAgainstBuilder(matchingBuilder, builder, numberSpec);
		
		
		numberSpec = RequestFactory.INSTANCE.createNumberSpecification();
		numberSpec.setMin(10L);
		numberSpec.setMax(999L);
		builder = new Builder(1, 100).stepSize(3);
		ail = new AscendingIntegerList(numberSpec, Arrays.asList(OWNER), 0, builder);
		
		matchingBuilder = ail.makeBuilderMatchingSpecification(builder);
		testMatchingBuilderAgainstBuilder(matchingBuilder, builder, numberSpec);
	}
	
	public void testMatchingBuilderAgainstBuilder(Builder matchingBuilder, Builder builder, IntegerSpecification numberSpec) {
		int actualStartInt = matchingBuilder.startInt;
		assertTrue("startInt is smaller than original startInt: " + actualStartInt + " < " + builder.startInt,
				   actualStartInt >= builder.startInt);
		assertTrue("StartInt is smaller than numberSpec.minValue: " + actualStartInt + " < " + numberSpec.getMin(),
				   actualStartInt >= numberSpec.getMin());
		
		int originalLargestValue = builder.startInt + builder.size * builder.stepSize;
		int actualLargestValue = matchingBuilder.startInt + matchingBuilder.size * matchingBuilder.stepSize;
		assertTrue("largest value is bigger than original largest value: " + actualLargestValue + " > " + originalLargestValue,
				   actualLargestValue <= originalLargestValue);
		assertTrue("largest value is bigger than numberSpec.maxValue: " + actualLargestValue + " > " + numberSpec.getMax(),
				   actualLargestValue <= numberSpec.getMax());
	}

}
