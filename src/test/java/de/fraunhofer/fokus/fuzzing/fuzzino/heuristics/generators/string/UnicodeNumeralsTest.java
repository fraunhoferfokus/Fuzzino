//   Copyright 2020 Fraunhofer FOKUS
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

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.UnicodeDecoder;

public class UnicodeNumeralsTest extends FuzzinoTest {
	
	public static final long SEED = 4711;
	public static final StringSpecification STRING_SPEC;
	public static final List<List<String>> DECIMALS;
	public static final List<List<String>> NONDECIMALS;
	
	static {
		STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();

		DECIMALS = new ArrayList<>();
		DECIMALS.add(uniRange(0xFF10, 0xFF19));
		DECIMALS.add(uniRange(0x1D7CE, 0x1D7D7));
		DECIMALS.add(uniRange(0x1D7D8, 0x1D7E1));
		DECIMALS.add(uniRange(0x1D7E2, 0x1D7EB));
		DECIMALS.add(uniRange(0x1D7EC, 0x1D7F5));
		DECIMALS.add(uniRange(0x1D7F6, 0x1D7FF));
		DECIMALS.add(uniRange(0x1FBF0, 0x1FBF9));

		NONDECIMALS = new ArrayList<>();
		List<String> superscript = new ArrayList<>();
		superscript.add(uniDigit(0xB2));
		superscript.add(uniDigit(0xB3));
		superscript.add(uniDigit(0xB9));
		superscript.add(uniDigit(0x2070));
		superscript.addAll(uniRange(0x2074, 0x2079));
		NONDECIMALS.add(superscript);
		NONDECIMALS.add(uniRange(0x2080, 0x2089));
		List<String> circled = uniRange(0x2460, 0x2468);
		circled.add(uniDigit(0x24EA));
		NONDECIMALS.add(circled);
		NONDECIMALS.add(uniRange(0x2474, 0x247C));
		List<String> fullstop = uniRange(0x2488, 0x2490);
		fullstop.add(uniDigit(0x1F100));
		NONDECIMALS.add(fullstop);
		NONDECIMALS.add(uniRange(0x24F5, 0x24FD));
		NONDECIMALS.add(uniRange(0x2776, 0x277E));
		NONDECIMALS.add(uniRange(0x2780, 0x2788));
		NONDECIMALS.add(uniRange(0x278A, 0x2792));
		NONDECIMALS.add(uniRange(0x1F101, 0x1F10A));
	}

	private static String uniDigit(int uni) {
		return new String(Character.toChars(uni));
	}
	
	private static List<String> uniRange(int uniStart, int uniEnd) {
		int count = uniEnd - uniStart;
		List<String> ret = new ArrayList<>(count);
		for (int i = 0; i <= count; i++) {
			ret.add(uniDigit(uniStart + i));
		}
		return ret;
	}

	private static boolean stringContainsASubstring(String s, List<String> substrings) {
		return substrings.parallelStream().anyMatch(s::contains);
	}
	
	private static boolean fuzzedValuesContainASubstring(StringGenerator gen,
			List<String> substrings) {
		boolean ret = false;
		for (FuzzedValue<String> fuzzedValue : gen) {
			String value = UnicodeDecoder.decode(fuzzedValue.getValue());
			if (stringContainsASubstring(value, substrings)) {
				ret = true;
				break;
			}
		}
		return ret;
	}
	
	@Test
	public void testHasNumbersFromAllSystems() {
		UnicodeNumeralsGenerator generator = new UnicodeNumeralsGenerator(STRING_SPEC, SEED);
		for (List<String> digits : DECIMALS) {
			assertTrue(fuzzedValuesContainASubstring(generator, digits));
		}
		for (List<String> digits : NONDECIMALS) {
			assertTrue(fuzzedValuesContainASubstring(generator, digits));
		}
	}

}
