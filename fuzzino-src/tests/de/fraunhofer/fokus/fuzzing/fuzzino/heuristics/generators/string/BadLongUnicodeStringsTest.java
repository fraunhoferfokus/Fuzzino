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

import static org.junit.Assert.*;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadLongStringsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;

public class BadLongUnicodeStringsTest {
	
	public static final long SEED = 4711;
	public static final StringSpecification STRING_SPEC;
	public static final StringSpecification STRING_SPEC_WITH_LENGTH;
	
	static {
		STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
		
		STRING_SPEC_WITH_LENGTH = RequestFactory.INSTANCE.createStringSpecification();
		STRING_SPEC_WITH_LENGTH.setMinLength(1);
		STRING_SPEC_WITH_LENGTH.setMaxLength(1);
	}

	@Test
	public void testIgnoreLength() {
		BadLongStringsGenerator badLongStringsGenerator = new BadLongStringsGenerator(STRING_SPEC_WITH_LENGTH, SEED);
		int counter = 0;
		for (FuzzedValue<String> fuzzedValue : badLongStringsGenerator) {
			String fuzzedValueItself = fuzzedValue.getValue();
			int length = fuzzedValueItself.length();
			assertTrue(length >= 1);
			counter++;
		}
		
		assertTrue(counter >= 100);
	}

}
