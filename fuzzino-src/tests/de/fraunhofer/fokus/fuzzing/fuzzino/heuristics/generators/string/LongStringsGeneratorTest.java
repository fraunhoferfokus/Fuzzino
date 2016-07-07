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

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.ComposedFuzzingHeuristicTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.IntegerUtil;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class LongStringsGeneratorTest extends ComposedFuzzingHeuristicTest<String> {

	public static final long SEED = 4711;
	public static final StringSpecification STRING_SPEC;
	public static final StringSpecification STRING_SPEC_LENGTH;
	
	static {
		STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
		
		STRING_SPEC_LENGTH = RequestFactory.INSTANCE.createStringSpecification();
		STRING_SPEC_LENGTH.setMinLength(1);
		STRING_SPEC_LENGTH.setMaxLength(1);
	}

	@Before
	public void init() {
		composedHeuristics = new LongStringsGenerator(STRING_SPEC, SEED);
		expectedValues = new ArrayList<>();

		for (int i=1; i<=200; i++) {
			expectedValues.add(StringUtil.repeat("A", 10 * i));
		}

		for (int i=1; i<=100; i++) {
			expectedValues.add(StringUtil.repeat("A", 127 * i));
		}

		for (int i=1; i<=10; i++) {
			expectedValues.add(StringUtil.repeat("A", 1024 * i));
		}

		for (String str : StringUtil.asList("A", "B", "1", "2", "3", "<", ">", "'", "\"", "/", "\\", "?", "=", "a=", 
				"&", ".", ",", "(", ")", "]", "[", "%", "*", "-", "+", "{", "}", 
				"\\x14", "\\xFE", "\\xFF")) {
			for (Integer i : IntegerUtil.asList(128, 255, 256, 257, 511, 512, 513, 1023, 1024, 2048, 2049, 4095, 4096, 
					4097, 5000, 10000, 20000,32762, 32763, 32764, 32765, 32766, 32767,
					32768, 32769, 0xFFFF-2, 0xFFFF-1, 0xFFFF, 0xFFFF+1, 0xFFFF+2, 99999, 
					100000, 500000, 1000000))
				expectedValues.add(StringUtil.repeat(str, i));
		}
		
	
		for (int repetitions : IntegerUtil.asList(128, 256, 1024, 2048, 4096, 32767, 0xFFFF)) {
			String surrounding = StringUtil.repeat("B", repetitions/2);
			String expectedString = surrounding + "\\x00" + surrounding;
			expectedValues.add(expectedString);
		}
		
		List<String> characters = StringUtil.asList("A", "B", "1", "2", "3", "<", ">", "'", "\"", "/", "\\", "?", "=", "a=", 
				"&", ".", ",", "(", ")", "]", "[", "%", "*", "-", "+", "{", "}", 
				"\\x14", "\\xFE", "\\xFF");
		List<Integer>repetitions = IntegerUtil.asList(128, 255, 256, 257, 511, 512, 513, 1023, 1024, 2048, 2049, 4095, 4096, 
				4097, 5000, 10000, 20000,32762, 32763, 32764, 32765, 32766, 32767,
				32768, 32769, 0xFFFF-2, 0xFFFF-1, 0xFFFF, 0xFFFF+1, 0xFFFF+2, 99999, 
				100000, 500000, 1000000);

		List<Integer> nullInsideRepetitions = IntegerUtil.asList(128, 256, 1024, 2048, 4096, 32767, 0xFFFF);
		
		
		final int SIZE_FIRST_PART = characters.size() * repetitions.size();
		for (int index=0; index<0; index++) {
			String fuzzedValueItself;
			if (index < SIZE_FIRST_PART) {
				int charIndex = index / repetitions.size();
				int repetitionIndex = index % repetitions.size();
				
				String character = characters.get(charIndex);
				int repetition = repetitions.get(repetitionIndex);
				fuzzedValueItself = StringUtil.repeat(character, repetition);
			} else {
				// the following values are taken from Sulley 1.5.7, sulley/primitives.py
				// class strings, lines 523-525
				index -= SIZE_FIRST_PART;
				int repetition = nullInsideRepetitions.get(index);
				String surrounding = StringUtil.repeat("B", repetition/2);
			
				fuzzedValueItself = surrounding + "\\x00" + surrounding;
			}
			
			expectedValues.add(fuzzedValueItself);

		}
		
		
	}
	
	@Test
	public void testIgnoreLength() {
		LongStringsGenerator longStringsGenerator = new LongStringsGenerator(STRING_SPEC_LENGTH, SEED);
		int counter = 0;
		for (FuzzedValue<String> fuzzedValue : longStringsGenerator) {
			String fuzzedValueItself = fuzzedValue.getValue();
			int length = fuzzedValueItself.length();
			assertTrue(length >= 1);
			counter++;
		}
		
		assertTrue(counter >= 100);
	}


}
