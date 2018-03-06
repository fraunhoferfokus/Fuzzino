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

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.NoMatchingValuesException;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class CombinatorTest extends FuzzinoTest {
	
	public static final long SEED = 4711;
	public static final StringSpecification STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
	public static final SmallGenerator OWNER = new SmallGenerator(STRING_SPEC, SEED);
	
	@Test
	public void testWithOneList() throws NoMatchingValuesException {
		AscendingIntegerAsStringList ascIntList = new AscendingIntegerAsStringList(STRING_SPEC, OWNER, SEED,
				new AscendingIntegerAsStringList.Builder(0, 10));
		
		Combinator combinator = new Combinator(STRING_SPEC, SEED, OWNER, ascIntList);

		int counter = 0;
		for (FuzzedValue<String> fuzzedValue : combinator) {
			String actualValue = fuzzedValue.getValue();
			String expectedValue = Integer.toString(counter);
			assertTrue("Invalid value: was " + actualValue + " instead of " + expectedValue,
					   actualValue.equals(expectedValue));
			counter++;
		}
	}
	
	@Test
	public void testWithTwoLists() throws NoMatchingValuesException {
		AscendingIntegerAsStringList ascIntList1 = new AscendingIntegerAsStringList(STRING_SPEC, OWNER, SEED,
				new AscendingIntegerAsStringList.Builder(0, 2));
		AscendingIntegerAsStringList ascIntList2 = new AscendingIntegerAsStringList(STRING_SPEC, OWNER, SEED, 
				new AscendingIntegerAsStringList.Builder(0, 3));
		
		List<String> expectedValues = StringUtil.asList("00", "10", "01", "11", "02", "12");
		
		Combinator combinator = new Combinator(STRING_SPEC, SEED, OWNER, ascIntList1, ascIntList2);

		int counter = 0;
		for (FuzzedValue<String> fuzzedValue : combinator) {
			String actualValue = fuzzedValue.getValue();
			String expectedValue = expectedValues.get(counter);
			assertTrue("Invalid value: was " + actualValue + " instead of " + expectedValue,
					   actualValue.equals(expectedValue));
			counter++;
		}
	}
	
	@Test
	public void testWithThreeLists() throws NoMatchingValuesException {
		AscendingIntegerAsStringList ascIntList1 = new AscendingIntegerAsStringList(STRING_SPEC, OWNER, SEED,
				new AscendingIntegerAsStringList.Builder(0, 2));
		AscendingIntegerAsStringList ascIntList2 = new AscendingIntegerAsStringList(STRING_SPEC, OWNER, SEED,
				new AscendingIntegerAsStringList.Builder(2, 3));
		AscendingIntegerAsStringList ascIntList3 = new AscendingIntegerAsStringList(STRING_SPEC, OWNER, SEED,
				new AscendingIntegerAsStringList.Builder(5, 2));
		
		List<String> expectedValues = StringUtil.asList("025", "125", "035", "135", "045", "145", 
				                                        "026", "126", "036", "136", "046", "146");
		
		Combinator combinator = new Combinator(STRING_SPEC, SEED, OWNER, ascIntList1, ascIntList2, ascIntList3);

		int counter = 0;
		for (FuzzedValue<String> fuzzedValue : combinator) {
			String actualValue = fuzzedValue.getValue();
			String expectedValue = expectedValues.get(counter);
			assertTrue("Invalid value: was " + actualValue + " instead of " + expectedValue,
					   actualValue.equals(expectedValue));
			counter++;
		}
	}
	
}
