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

import org.junit.Before;
import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

public class MatchesStringLength extends FuzzinoTest {
	
	public static final long SEED = 4711;
	public static SmallGenerator smallGenerator;
	public static StringSpecification stringSpec;
	
	public static final int MIN_LENGTH = 2;
	public static final int MAX_LENGTH = 5;

	@Before
	public void init() {
		stringSpec = RequestFactory.INSTANCE.createStringSpecification();
		stringSpec.setMinLength(MIN_LENGTH);
		stringSpec.setMaxLength(MAX_LENGTH);
		
		smallGenerator = new SmallGenerator(stringSpec, SEED);
	}
	
	@Test
	public void test() {
		for (FuzzedValue<String> fuzzedValue : smallGenerator) {
			int actualLength = fuzzedValue.getValue().length();
			
			assertTrue("Wrong length: was too short - " + actualLength + " < MIN_LENGTH(" + MIN_LENGTH + ")",
					   actualLength >= MIN_LENGTH);

			assertTrue("Wrong length: was too long - " + actualLength + " > MAX_LENGTH(" + MAX_LENGTH + ")",
					   actualLength <= MAX_LENGTH);
		}
	}

}
