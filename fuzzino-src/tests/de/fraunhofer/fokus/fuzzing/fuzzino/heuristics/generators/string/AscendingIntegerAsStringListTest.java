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

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.NoMatchingValuesException;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;

public class AscendingIntegerAsStringListTest {

	private static final int START_INT = 1;
	private static final int STEP_SIZE = 3;
	private static final int SIZE = 100;
	
	private static final int SEED = 4711;
	private static final int MIN_LENGTH = 2;
	private static final int MAX_LENGTH = 3;
	private static final StringSpecification STRING_SPEC;
	static {
		STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
		STRING_SPEC.setMinLength(MIN_LENGTH);
		STRING_SPEC.setMaxLength(MAX_LENGTH);
	}
	private static final SmallGenerator OWNER = new SmallGenerator(STRING_SPEC, SEED);
	
	@Test
	public void test() throws NoMatchingValuesException {
		AscendingIntegerAsStringList.Builder builder = 
				new AscendingIntegerAsStringList.Builder(START_INT, SIZE).stepSize(STEP_SIZE);
		
		AscendingIntegerAsStringList heuristic = 
				new AscendingIntegerAsStringList(STRING_SPEC, OWNER, SEED, builder);
		
		int expectedSize = 97;
		int actualSize = heuristic.size();
		assertTrue("Wrong size: was " + actualSize + " instead of " + expectedSize,
				   actualSize == expectedSize);
		
		for (int i=0; i<heuristic.size(); i++) {
			String value = heuristic.get(i).getValue();
			int actualLength = value.length();

			assertTrue("Wrong length at index " + i + ": " + actualLength + " < " + MIN_LENGTH,
					   actualLength >= MIN_LENGTH);

			assertTrue("Wrong length at index " + i + ": " + actualLength + " > " + MIN_LENGTH,
					   actualLength <= MAX_LENGTH);
		}

	}

}
