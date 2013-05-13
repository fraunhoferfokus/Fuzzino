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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComposedFuzzingHeuristic.ComposedIndexIterator;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.IntegerUtil;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class ComposedFuzzingHeuristicTest {

	public static final List<String> EXPECTED_VALUES = 
			StringUtil.asList("1A", "2B", "3C", "4A", "5B", "6C", "7A", "8C", "9C", "10C");
	public static SimpleComposedFuzzingHeuristic composedHeuristic;
	
	@Before
	public void init() {
		 composedHeuristic = new SimpleComposedFuzzingHeuristic();
	}
	
	@Test
	public void test() {
		int counter = 0;
		for (FuzzedValue<String> fuzzedValue : composedHeuristic) {
			String actualValue = fuzzedValue.getValue();
			String expectedValue = EXPECTED_VALUES.get(counter);
			assertTrue("Wrong value at index " + counter + " : was " + actualValue + " instead of " + expectedValue,
					   actualValue.equals(expectedValue));
			counter++;
		}
	}
	
	@Test
	public void test_computeElement() {
		for (int i=0; i<composedHeuristic.size(); i++) {
			FuzzedValue<String> fuzzedValue = composedHeuristic.computeElement(i);
			
			String actualValue = fuzzedValue.getValue();
			String expectedValue = EXPECTED_VALUES.get(i);
			assertTrue("Wrong value at index " + i + " : was " + actualValue + " instead of " + expectedValue,
					   actualValue.equals(expectedValue));
		}
	}
	
	@Test
	public void  test_computeIndex() {
		List<Integer> expectedHeuristicIndices = IntegerUtil.asList(0, 1, 2, 0, 1, 2, 0, 2, 2, 2);
		List<Integer> expectedElementIndices = IntegerUtil.asList(0, 0, 0, 1, 1, 1, 2, 2, 3, 4);
		
		for (int i=0; i<composedHeuristic.size(); i++) {
			@SuppressWarnings("rawtypes")
			ComposedIndexIterator actualComposedIndex = composedHeuristic.computeIndex(i);
			
			int expectedHeuristicIdx = expectedHeuristicIndices.get(i);
			int actualHeuristicIdx = actualComposedIndex.getIndexForHeuristic();
			assertTrue("Wrong heuristic index at index " + i + ": was " + actualHeuristicIdx + " instead of " + expectedHeuristicIdx,
					   actualHeuristicIdx == expectedHeuristicIdx);
			
			int expectedElementIdx = expectedElementIndices.get(i);
			int actualElementIdx = actualComposedIndex.getIndexForElement();
			assertTrue("Wrong element index at index " + i + ": was " + actualElementIdx + " instead of " + expectedElementIdx,
					actualElementIdx == expectedElementIdx);
			
		}
	}

}
