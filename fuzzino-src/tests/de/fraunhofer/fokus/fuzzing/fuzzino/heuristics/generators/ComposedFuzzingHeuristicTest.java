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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComposedFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;

public abstract class ComposedFuzzingHeuristicTest<T> {

	public static final StringSpecification STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
	protected ComposedFuzzingHeuristic<T> composedHeuristics;
	protected List<T> expectedValues;

	@Test
	public void testOnCorrectSize() {
		int expectedSize = expectedValues.size();
		int actualSize = composedHeuristics.size();
		assertTrue("Invalid size: " + actualSize + " instead of " + expectedSize,
				   actualSize == expectedSize);
	}
	
	@Test
	public void testOnCorrectValues() {
		int index = 0;
		for (FuzzedValue<T> fuzzedValue : composedHeuristics) {
			T actualValue = fuzzedValue.getValue();
			
			boolean condition = expectedValues.contains(actualValue); 
			assertTrue("At index " + index + ": unknown value \"" + actualValue + "\"",
					condition);
			expectedValues.remove(actualValue);
			index++;
		}
		
		assertTrue(expectedValues.size() + " missing values",
				   expectedValues.size() == 0);
	}

}
