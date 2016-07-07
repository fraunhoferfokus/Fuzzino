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

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

/**
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 */
public class StringRepeaterTest {
	
	public static final long SEED = 4711;
	public static final StringSpecification STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
	public static final SmallGenerator OWNER = new SmallGenerator(STRING_SPEC, SEED);
	
	private StringRepeater customStringRepeater;
	
	@Before
	public void init() {
		customStringRepeater = new StringRepeater(STRING_SPEC, OWNER, SEED, new StringRepeater.Builder().string("ABC").stepSize(3).size(4).offset(1));
	}

	@Test
	public void testCustomSize() {
		int expectedSize = 4;
		int actualSize = customStringRepeater.size();
		assertTrue("Size was " + actualSize + " instead of " + expectedSize,
				   actualSize == expectedSize);
	}
	
	@Test
	public void testCustomHasNext() {
		boolean expectedHasNext = true;
		boolean actualHasNext = customStringRepeater.iterator().hasNext();
		assertTrue("hasNext() was " + actualHasNext + " instead of " + expectedHasNext,
				actualHasNext == expectedHasNext);
	}
	
	@Test
	public void testCustomNext() {
		String expectedElement = StringUtil.repeat("ABC", 1);
		FuzzedValue<String> fuzzedValue = customStringRepeater.iterator().next();
		String actualElement = fuzzedValue.getValue();
		assertTrue("next() returns " + actualElement + " instead of " + expectedElement,
				   actualElement.equals(expectedElement));
	}


	@Test(expected=NoSuchElementException.class)
	public void testCustomIterations() {
		int iterations = 0;
		
		Iterator<FuzzedValue<String>> i = customStringRepeater.iterator();
		while (i.hasNext()) {
			String expectedElement = StringUtil.repeat("ABC", 1 + 3 * (iterations));
			FuzzedValue<String> fuzzedValue = i.next();
			String actualElement = fuzzedValue.getValue();
			assertTrue("Returned value was " + actualElement + " instead of " + expectedElement, 
					   actualElement.equals(expectedElement));
			iterations++;
		}
		
		int expectedIterations = 4;
		int actualIterations = iterations;
		assertTrue("Iterations are " + actualIterations + " instead of " + expectedIterations, 
				   iterations == expectedIterations);
		
		boolean expectedHasNext = false;
		boolean actualHasNext = i.hasNext();
		assertTrue("hasNext is " + actualHasNext + " instead of " + expectedHasNext,
				   actualHasNext == expectedHasNext);
		
		i.next();
	}

}
