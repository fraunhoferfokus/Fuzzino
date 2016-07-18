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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class StringOperatorFactoryTest extends FuzzinoTest {
	
	private static final long SEED = 4711;
	private static final String NO_PARAM = null;
	private static final StringSpecification STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();

	@Test
	public void testWithStringParameter() throws Exception {
		String expectedValue = "HELLO, world!";
		StringOperator op = StringOperatorFactory.INSTANCE.create("StringCase", StringUtil.asList(expectedValue), NO_PARAM, STRING_SPEC, SEED);
		String actualValue = op.getValidValues().get(0);
		assertTrue("Invalid value: was " + actualValue + " instead of " + expectedValue,
				   actualValue.equals(expectedValue));
	}
	
	@Test
	public void testWithListOfStringParameter() throws Exception {
		List<String> expectedValues = StringUtil.asList("HELLO, world!", "hello, WORLD!");
		StringOperator op = StringOperatorFactory.INSTANCE.create("StringCase", expectedValues, NO_PARAM, STRING_SPEC, SEED);
		ListIterator<String> i = op.getValidValues().listIterator();
		while (i.hasNext()) {
			int currentIndex = i.nextIndex();
			String expectedValue = expectedValues.get(currentIndex);
			String actualValue = i.next();
			assertTrue("Invalid value: was " + actualValue + " instead of " + expectedValue,
					   actualValue.equals(expectedValue));
		}
	}
	

}
