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

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.SmallGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

public class ComputableListImplTest extends FuzzinoTest {

	public static final StringSpecification STRING_SPEC;
	public static final int MIN_LENGTH = 2;
	public static final int MAX_LENGTH = 5;
	public static final long SEED = 4711;
	public static SmallGenerator smallGenerator;
	
	static {
		STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
		STRING_SPEC.setMinLength(MIN_LENGTH);
		STRING_SPEC.setMaxLength(MAX_LENGTH);
	}
	
	@Before
	public void init() {
		smallGenerator = new SmallGenerator(STRING_SPEC, SEED);
	}
	
	@Test
	public void test() {
		int counter = 0;
		Iterator<FuzzedValue<String>> i = smallGenerator.iterator();
		while (i.hasNext()) {
			FuzzedValue<String> fuzzedValue = i.next();
			String fuzzedValueItself = fuzzedValue.getValue();
			
			int actualLength = fuzzedValueItself.length();
			
			assertTrue("Wrong length at index " + counter + ": was too short  " + actualLength + " < MIN_LENGTH(" + MIN_LENGTH + ")",
					   actualLength >= MIN_LENGTH);

			assertTrue("Wrong length at index " + counter + ": was too long  " + actualLength + " > MAX_LENGTH(" + MAX_LENGTH + ")",
					   actualLength <= MAX_LENGTH);
			
			counter++;
		}
	}

}
