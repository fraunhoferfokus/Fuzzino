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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.UnicodeDecoder;

public class ForeignDigitsGeneratorTest extends FuzzinoTest {

	public static final long SEED = 4711;
	public static final StringSpecification STRING_SPEC;
	public static final List<List<String>> ALL_SYSTEMS;
	public static final List<String> ALL_DIGITS;
	
	static {
		STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
		List<String> suzhou = new ArrayList<>();
		suzhou.add("\u3007");
		suzhou.addAll(unicodeRange(0x3021, 0x3029));
		List<String> cjk = Arrays.asList(
				"\u96f6", "\u4e00", "\u4e8c", "\u4e09", "\u56db",
				"\u4e94", "\u516d", "\u4e03", "\u516b", "\u4e5d",
				"\u5341", "\u767e", "\u5343",
				"\u4e07", "\u4ebf", "\u5146", "\u4eac", "\u5793",
				"\u79ed", "\u7a70", "\u6c9f", "\u6da7", "\u6b63", "\u8f7d"
		);
		List<String> abjad = Arrays.asList(
				"\u0623", "\u0628", "\u062a", "\u062b", "\u062c",
				"\u062d", "\u062e", "\u062f", "\u0630", "\u0631",
				"\u0632", "\u0633", "\u0634", "\u0635", "\u0636",
				"\u0637", "\u0638", "\u0639", "\u063a", "\u0641",
				"\u0642", "\u0643", "\u0644", "\u0645", "\u0646",
				"\u0647", "\u0648", "\u064a"
		);
		List<String> greek = Arrays.asList(
				"\u0391", "\u0392", "\u0393", "\u0394", "\u0395",
				"\u03da", "\u0396", "\u0397", "\u0398", "\u0399",
				"\u039a", "\u039b", "\u039c", "\u039d", "\u039e",
				"\u039f", "\u03a0", "\u03d8", "\u03a1", "\u03a3",
				"\u03a4", "\u03a5", "\u03a6", "\u03a7", "\u03a8",
				"\u03a9", "\u0372"
		);
		ALL_SYSTEMS = Arrays.asList(
				unicodeRange(0x660, 0x669), // Eastern Arabic
				unicodeRange(0x6f0, 0x6f9), // Persian
				unicodeRange(0x7c0, 0x7c9), // NKO
				unicodeRange(0x966, 0x96f), // Devanagari
				unicodeRange(0x104a0, 0x104a9), // Osmanya
				unicodeRange(0x11066, 0x1106f), // Brahmi
				unicodeRange(0x110f0, 0x110f9), // Sora Sompeng
				unicodeRange(0x11136, 0x1113f), // Chakma
				suzhou,
				cjk,
				abjad,
				greek
		);
		ALL_DIGITS = ALL_SYSTEMS.parallelStream()
				.flatMap(List::stream)
				.collect(Collectors.toList());
	}

	private static final List<String> unicodeRange(int start, int end) {
		return IntStream.rangeClosed(start, end)
			.mapToObj(i -> new String(Character.toChars(i)))
			.collect(Collectors.toList());
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
		ForeignDigitsGenerator foreignDigitsGenerator = new ForeignDigitsGenerator(STRING_SPEC, SEED);
		for (List<String> digits : ALL_SYSTEMS) {
			assertTrue(fuzzedValuesContainASubstring(foreignDigitsGenerator, digits));
		}
	}
}
