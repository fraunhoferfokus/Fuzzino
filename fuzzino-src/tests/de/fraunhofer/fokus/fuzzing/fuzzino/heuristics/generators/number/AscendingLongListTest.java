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

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.NoMatchingValuesException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.AscendingLongList.Builder;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.SmallGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

public class AscendingLongListTest extends FuzzinoTest {

	private static final long SEED = 4711;
	private static final StringSpecification STRING_SPEC= RequestFactory.INSTANCE.createStringSpecification();
	private static final SmallGenerator OWNER = new SmallGenerator(STRING_SPEC, SEED);
	private static final IntegerSpecification NUMBER_SPEC = RequestFactory.INSTANCE.createNumberSpecification();
	private AscendingLongList ascLongList;
	
	@Before
	public void init() throws NoMatchingValuesException {
		ascLongList = new AscendingLongList(NUMBER_SPEC,
				                            OWNER, 
				                            SEED, 
				                            new AscendingLongList.Builder(-10, 10)
		                                                         .stepSize(2));
	}

	@Test
	public void testSize() {
		int expectedSize = 10;
		int actualSize = ascLongList.size();
		assertTrue("Size was " + actualSize + " instead of " + expectedSize,
				   actualSize == expectedSize);
	}
	
	@Test
	public void testIteratorHasNext() {
		boolean expectedHasNext = true;
		boolean actualHasNext = ascLongList.iterator().hasNext();
		assertTrue("hasNext() was " + actualHasNext + " instead of " + expectedHasNext, 
				   actualHasNext == expectedHasNext);
	}
	
	@Test
	public void testComputingIteratorNext() {
		long exptectedElement = -10l;
		long actualElement = ascLongList.iterator().next().getValue();
		assertTrue("next() returns " + actualElement + " instead of " + exptectedElement, 
				   actualElement == exptectedElement);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testDefaultIterations() {
		int iterations = 0;
		
		Iterator<FuzzedValue<Long>> i = ascLongList.iterator();
		while (i.hasNext()) {
			Long actualElement = i.next().getValue();
			Long expectedElement = -10l + 2 * iterations;
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
		AscendingLongList all = new AscendingLongList(numberSpec, null, 0, builder);
		
		Builder matchingBuilder = all.makeBuilderMatchingSpecification(builder);
		testMatchingBuilderAgainstBuilder(matchingBuilder, builder, numberSpec);
		
		
		numberSpec = RequestFactory.INSTANCE.createNumberSpecification();
		numberSpec.setMin(10L);
		numberSpec.setMax(999L);
		builder = new Builder(1, 100).stepSize(3);
		all = new AscendingLongList(numberSpec, null, 0, builder);
		
		matchingBuilder = all.makeBuilderMatchingSpecification(builder);
		testMatchingBuilderAgainstBuilder(matchingBuilder, builder, numberSpec);
	}
	
	public void testMatchingBuilderAgainstBuilder(Builder matchingBuilder, Builder builder, IntegerSpecification numberSpec) {
		long actualStartInt = matchingBuilder.startInt;
		assertTrue("startInt is smaller than original startInt: " + actualStartInt + " < " + builder.startInt,
				   actualStartInt >= builder.startInt);
		assertTrue("StartInt is smaller than numberSpec.minValue: " + actualStartInt + " < " + numberSpec.getMin(),
				   actualStartInt >= numberSpec.getMin());
		
		long originalLargestValue = builder.startInt + builder.size * builder.stepSize;
		long actualLargestValue = matchingBuilder.startInt + matchingBuilder.size * matchingBuilder.stepSize;
		assertTrue("largest value is bigger than original largest value: " + actualLargestValue + " > " + originalLargestValue,
				   actualLargestValue <= originalLargestValue);
		assertTrue("largest value is bigger than numberSpec.maxValue: " + actualLargestValue + " > " + numberSpec.getMax(),
				   actualLargestValue <= numberSpec.getMax());
	}

}
