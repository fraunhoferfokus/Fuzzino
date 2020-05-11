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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

public class ForeignDigitsGeneratorTest extends FuzzinoTest {

	public static final long SEED = 4711;
	public static final StringSpecification STRING_SPEC;
	public static final List<List<String>> ALL_SYSTEMS;
	public static final List<String> EASTERN_ARABIC_DIGITS;
	public static final List<String> PERSIAN_DIGITS;
	public static final List<String> ABJAD_DIGITS;
	public static final List<String> GREEK_DIGITS;
	public static final List<String> CJK_DIGITS;
	public static final List<String> SUZHOU_DIGITS;
	public static final List<String> ALL_DIGITS;
	
	static {
		STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
		EASTERN_ARABIC_DIGITS = Arrays.asList(
				"٠", "١", "٢", "٣", "٤", "٥", "٦", "٧", "٨", "٩"
		);
		PERSIAN_DIGITS = Arrays.asList(
				"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"
		);
		ABJAD_DIGITS = Arrays.asList(
				"أ", "ب", "ج", "د", "ه", "و", "ز", "ح", "ط", "ي",
				"ك", "ل", "م", "ن", "س", "ع", "ف", "ص", "ق", "ر",
				"ش", "ت", "ث", "خ", "ذ", "ض", "ظ", "غ"
		);
		GREEK_DIGITS = Arrays.asList(
				"Α", "Β", "Γ", "Δ", "Ε", "Ϛ", "Ζ", "Η", "Θ",
				"Ι", "Κ", "Λ", "Μ", "Ν", "Ξ", "Ο", "Π", "Ϙ",
				"Ρ", "Σ", "Τ", "Υ", "Φ", "Χ", "Ψ", "Ω", "Ͳ"
		);
		CJK_DIGITS = Arrays.asList(
				"零", "一", "二", "三", "四", "五", "六", "七", "八", "九",
				"十", "百", "千", "万", "亿", "萬", "億"
		);
		SUZHOU_DIGITS = Arrays.asList(
				"〇", "〡", "〢", "〣", "〤", "〥", "〦", "〧", "〨", "〩"
		);
		ALL_SYSTEMS = Arrays.asList(
				EASTERN_ARABIC_DIGITS, PERSIAN_DIGITS, ABJAD_DIGITS,
				GREEK_DIGITS, CJK_DIGITS, SUZHOU_DIGITS
		);
		ALL_DIGITS = ALL_SYSTEMS.parallelStream()
				.flatMap(List::stream)
				.collect(Collectors.toList());
	}
	
	private static boolean stringContainsASubstring(String s, List<String> substrings) {
		return substrings.parallelStream().anyMatch(s::contains);
	}
	
	private static boolean fuzzedValuesContainASubstring(StringGenerator gen,
			List<String> substrings) {
		boolean ret = false;
		for (FuzzedValue<String> fuzzedValue : gen) {
			String value = fuzzedValue.getValue();
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
		
		System.out.println("testHasNumbersFromAllSystems");
	}
	
	@Test
	public void testHasMixedNumbers() {
		ForeignDigitsGenerator foreignDigitsGenerator = new ForeignDigitsGenerator(STRING_SPEC, SEED);
		for (FuzzedValue<String> fuzzedValue : foreignDigitsGenerator) {
			String value = fuzzedValue.getValue();
			int systemsCount = 0;
			for (List<String> digits : ALL_SYSTEMS) {
				if (stringContainsASubstring(value, digits)) {
					systemsCount++;
				}
			}
			if (systemsCount > 1) {
				return;
			}
		}
		assertTrue(false);
	}
}
