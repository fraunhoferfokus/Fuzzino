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

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

public class StringGeneratorFactoryTest extends FuzzinoTest {
	
	private static final long SEED = 4711;
	private static final String NO_PARAM = null;
	private static final StringSpecification STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();

	@Test
	public void testWithExistingGenerator() throws UnknownFuzzingHeuristicException {
		StringGeneratorFactory.INSTANCE.create("LongStrings", NO_PARAM, STRING_SPEC, SEED);
	}
	
	@Test(expected=UnknownFuzzingHeuristicException.class)
	public void testWithNonExistingGenerator() throws UnknownFuzzingHeuristicException {
		List<?> generator = StringGeneratorFactory.INSTANCE.create("NonExistingGenerator", NO_PARAM, STRING_SPEC, SEED);
		assertTrue("Generator is not null", generator == null);
	}
	
	@SuppressWarnings("unused")
	@Test(expected=UnknownFuzzingHeuristicException.class)
	public void testWithNullAsGeneratorName() throws UnknownFuzzingHeuristicException {
		StringGenerator generator = StringGeneratorFactory.INSTANCE.create(null, NO_PARAM, STRING_SPEC, SEED);
	}

}
