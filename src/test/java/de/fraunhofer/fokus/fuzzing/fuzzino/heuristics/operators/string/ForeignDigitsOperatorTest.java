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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringEncoder;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.UnicodeDecoder;

public class ForeignDigitsOperatorTest extends FuzzinoTest {
	
	private static Map<String, Integer> ABJAD;
	private static Map<String, Integer> GREEK;
	private static final String GREEK_KERAIA = "\\u0374";
	private static final String GREEK_THOUSANDS = "\\u0375";

	static {
		ABJAD = new HashMap<>();
		ABJAD.put("\\u0623", 1);
		ABJAD.put("\\u0628", 2);
		ABJAD.put("\\u062c", 3);
		ABJAD.put("\\u062f", 4);
		ABJAD.put("\\u0647", 5);
		ABJAD.put("\\u0648", 6);
		ABJAD.put("\\u0632", 7);
		ABJAD.put("\\u062d", 8);
		ABJAD.put("\\u0637", 9);
		ABJAD.put("\\u064a", 10);
		ABJAD.put("\\u0643", 20);
		ABJAD.put("\\u0644", 30);
		ABJAD.put("\\u0645", 40);
		ABJAD.put("\\u0646", 50);
		ABJAD.put("\\u0633", 60);
		ABJAD.put("\\u0639", 70);
		ABJAD.put("\\u0641", 80);
		ABJAD.put("\\u0635", 90);
		ABJAD.put("\\u0642", 100);
		ABJAD.put("\\u0631", 200);
		ABJAD.put("\\u0634", 300);
		ABJAD.put("\\u062a", 400);
		ABJAD.put("\\u062b", 500);
		ABJAD.put("\\u062e", 600);
		ABJAD.put("\\u0630", 700);
		ABJAD.put("\\u0636", 800);
		ABJAD.put("\\u0638", 900);
		ABJAD.put("\\u063a", 1000);

		GREEK = new HashMap<>();
		GREEK.put("\\u0391", 1);
		GREEK.put("\\u0392", 2);
		GREEK.put("\\u0393", 3);
		GREEK.put("\\u0394", 4);
		GREEK.put("\\u0395", 5);
		GREEK.put("\\u03da", 6);
		GREEK.put("\\u0396", 7);
		GREEK.put("\\u0397", 8);
		GREEK.put("\\u0398", 9);
		GREEK.put("\\u0399", 10);
		GREEK.put("\\u039a", 20);
		GREEK.put("\\u039b", 30);
		GREEK.put("\\u039c", 40);
		GREEK.put("\\u039d", 50);
		GREEK.put("\\u039e", 60);
		GREEK.put("\\u039f", 70);
		GREEK.put("\\u03a0", 80);
		GREEK.put("\\u03d8", 90);
		GREEK.put("\\u03a1", 100);
		GREEK.put("\\u03a3", 200);
		GREEK.put("\\u03a4", 300);
		GREEK.put("\\u03a5", 400);
		GREEK.put("\\u03a6", 500);
		GREEK.put("\\u03a7", 600);
		GREEK.put("\\u03a8", 700);
		GREEK.put("\\u03a9", 800);
		GREEK.put("\\u0372", 900);
	}
	
	public static final long SEED = 4711;
	
	private List<String> operate(String param, List<String> numbers) {
		ForeignDigitsOperator foreignDigitsOperator = new ForeignDigitsOperator(
				numbers, param, null, SEED);
		return foreignDigitsOperator.stream()
				.map(FuzzedValue::getValue)
				.collect(Collectors.toList());
	}
	
	private void testcase(String param, List<String> numbers, List<String> expected) {
		List<String> actual = operate(param, numbers);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEasternArabic() {
		testcase(
				"eastern_arabic",
				StringUtil.asList("42", "0", "1000000", "1234567890"),
				StringUtil.asList(
						"\\u0664\\u0662", "\\u0660",
						"\\u0661\\u0660\\u0660\\u0660\\u0660\\u0660\\u0660",
						"\\u0661\\u0662\\u0663\\u0664\\u0665\\u0666\\u0667\\u0668\\u0669\\u0660"
				)
		);
	}
	
	@Test
	public void testPersian() {
		testcase(
				"persian",
				StringUtil.asList("42", "0", "1000000", "1234567890"),
				StringUtil.asList(
						"\\u06f4\\u06f2", "\\u06f0",
						"\\u06f1\\u06f0\\u06f0\\u06f0\\u06f0\\u06f0\\u06f0",
						"\\u06f1\\u06f2\\u06f3\\u06f4\\u06f5\\u06f6\\u06f7\\u06f8\\u06f9\\u06f0"
				)
		);
	}
	
	@Test
	public void testNko() {
		testcase(
				"nko",
				StringUtil.asList("42", "0", "1000000", "1234567890"),
				StringUtil.asList(
						"\\u07c4\\u07c2", "\\u07c0",
						"\\u07c1\\u07c0\\u07c0\\u07c0\\u07c0\\u07c0\\u07c0",
						"\\u07c1\\u07c2\\u07c3\\u07c4\\u07c5\\u07c6\\u07c7\\u07c8\\u07c9\\u07c0"
				)
		);
	}
	
	private String digitsToUTF32(String orig, int base) {
		StringBuilder sb = new StringBuilder();
		for (char c : orig.toCharArray()) {
			sb.append(String.format("\\U%08x", base + c - '0'));
		}
		return sb.toString();
	}
	
	@Test
	public void testOsmanya() {
		List<String> data = StringUtil.asList("42", "0", "1000000", "1234567890");
		List<String> expected = data.stream()
				.map(s -> digitsToUTF32(s, 0x104A0))
				.collect(Collectors.toList());
		testcase("osmanya", data, expected);
	}
	
	@Test
	public void testChakma() {
		List<String> data = StringUtil.asList("42", "0", "1000000", "1234567890");
		List<String> expected = data.stream()
				.map(s -> digitsToUTF32(s, 0x11136))
				.collect(Collectors.toList());
		testcase("chakma", data, expected);
	}
	
	@Test
	public void testSuzhouSimple() {
		testcase(
				"suzhou",
				StringUtil.asList("42", "0", "1000000", "1425367890"),
				StringUtil.asList(
						"\\u3024\\u3022", "\\u3007",
						"\\u3021\\u3007\\u3007\\u3007\\u3007\\u3007\\u3007",
						"\\u3021\\u3024\\u3022\\u3025\\u3023\\u3026\\u3027\\u3028\\u3029\\u3007"
				)
		);
	}
	
	@Test
	public void testSuzhouHorizontalBars() {
		testcase(
				"suzhou",
				StringUtil.asList("11111", "123321", "4022"),
				StringUtil.asList(
						"\\u3021\\u4e00\\u3021\\u4e00\\u3021",
						"\\u3021\\u4e8c\\u3023\\u4e09\\u3022\\u4e00",
						"\\u3024\\u3007\\u3022\\u4e8c"
				)
		);
	}
	
	@Test
	public void testCJKSimple() {
		testcase(
				"cjk",
				StringUtil.asList("42", "0", "9876", "1235", "1111"),
				StringUtil.asList(
						"\\u56db\\u5341\\u4e8c", "\\u96f6",
						"\\u4e5d\\u5343\\u516b\\u767e\\u4e03\\u5341\\u516d",
						"\\u4e00\\u5343\\u4e8c\\u767e\\u4e09\\u5341\\u4e94",
						"\\u4e00\\u5343\\u4e00\\u767e\\u4e00\\u5341\\u4e00"
				)
		);
	}
	
	@Test
	public void testCJKZeroes() {
		testcase(
				"cjk",
				StringUtil.asList("101", "1001", "100", "1000"),
				StringUtil.asList(
						"\\u4e00\\u767e\\u96f6\\u4e00", "\\u4e00\\u5343\\u96f6\\u4e00",
						"\\u4e00\\u767e", "\\u4e00\\u5343"
				)
		);
	}
	
	@Test
	public void testCJKMyriads() {
		testcase(
				"cjk",
				StringUtil.asList(
						"12345", "201234", "100000000000000000000000000000000000000000000",
						"12345678902345", "1234567890987654321"
				),
				StringUtil.asList(
						"\\u4e00\\u4e07\\u4e8c\\u5343\\u4e09\\u767e\\u56db\\u5341\\u4e94",
						"\\u4e8c\\u5341\\u4e07\\u4e00\\u5343\\u4e8c\\u767e\\u4e09\\u5341\\u56db",
						"\\u4e00\\u8f7d",
						"\\u4e00\\u5341\\u4e8c\\u5146\\u4e09\\u5343\\u56db\\u767e\\u4e94\\u5341\\u516d\\u4ebf\\u4e03\\u5343\\u516b\\u767e\\u4e5d\\u5341\\u4e07\\u4e8c\\u5343\\u4e09\\u767e\\u56db\\u5341\\u4e94",
						"\\u4e00\\u767e\\u4e8c\\u5341\\u4e09\\u4eac\\u56db\\u5343\\u4e94\\u767e\\u516d\\u5341\\u4e03\\u5146\\u516b\\u5343\\u4e5d\\u767e\\u96f6\\u4e5d\\u4ebf\\u516b\\u5343\\u4e03\\u767e\\u516d\\u5341\\u4e94\\u4e07\\u56db\\u5343\\u4e09\\u767e\\u4e8c\\u5341\\u4e00"
				)
		);
	}
	
	@Test
	public void testCJKTens() {
		testcase(
				"cjk",
				StringUtil.asList("10", "11", "12", "19", "20"),
				StringUtil.asList(
						"\\u5341", "\\u5341\\u4e00", "\\u5341\\u4e8c",
						"\\u5341\\u4e5d", "\\u4e8c\\u5341"
				)
		);
	}
	
	private static int alphabeticToInt(String alphaNumber, Map<String, Integer> alphabet) {
		int sum = 0;
		alphaNumber = UnicodeDecoder.decode(alphaNumber);
		for (int i = 0; i < alphaNumber.length(); i++) {
			String c = StringEncoder.encode(Character.toString(alphaNumber.charAt(i)));
			sum += alphabet.get(c);
		}
		return sum;
	}
	
	@Test
	public void testAbjad() {
		List<String> numbers = Arrays.asList("42", "20000", "12356", "1", "777");
		List<String> ret = operate("abjad", numbers);
		assertEquals(2, UnicodeDecoder.decode(ret.get(0)).length());

		List<Integer> expected = numbers.stream()
				.map(Integer::valueOf)
				.collect(Collectors.toList());
		List<Integer> actual = ret.stream()
				.map(s -> alphabeticToInt(s, ABJAD))
				.collect(Collectors.toList());
		assertEquals(expected, actual);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAbjadZero() {
		operate("abjad", Arrays.asList("0"));
	}
	
	private static void checkKeraia(List<String> noKeraia, List<String> keraia) {
		for (String s : keraia) {
			assertTrue(s.indexOf(GREEK_KERAIA) == s.length() - GREEK_KERAIA.length());
		}
		assertEquals(
				noKeraia,
				keraia.stream()
					.map(s -> s.substring(0, s.length() - GREEK_KERAIA.length()))
					.collect(Collectors.toList())
		);
	}
	
	private static int greekToInt(String s) {
		int sum = 0;
		s = UnicodeDecoder.decode(s);
		for (int i = 0; i < s.length(); i++) {
			String c = StringEncoder.encode(Character.toString(s.charAt(i)));
			if (c.equals(GREEK_THOUSANDS)) {
				c = StringEncoder.encode(Character.toString(s.charAt(++i)));
				sum += 1000 * GREEK.get(c);
				continue;
			}
			sum += GREEK.get(c);
		}
		return sum;
	}
	
	@Test
	public void testGreekSimple() {
		List<String> numbers = Arrays.asList("42", "200", "1", "777");
		List<String> ret = operate("greek", numbers);
		assertEquals(2, UnicodeDecoder.decode(ret.get(0)).length());
		List<String> retKeraia = operate("greek_keraia", numbers);
		checkKeraia(ret, retKeraia);

		List<Integer> expected = numbers.stream()
				.map(Integer::valueOf)
				.collect(Collectors.toList());
		List<Integer> actual = ret.stream()
				.map(ForeignDigitsOperatorTest::greekToInt)
				.collect(Collectors.toList());
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGreekThousands() {
		List<String> numbers = Arrays.asList("1000", "9999", "4042");
		List<String> ret = operate("greek", numbers);
		List<String> retKeraia = operate("greek_keraia", numbers);
		checkKeraia(ret, retKeraia);
		
		for (String s : ret) {
			assertTrue(s.contains(GREEK_THOUSANDS));
		}
		
		List<Integer> expected = numbers.stream()
				.map(Integer::valueOf)
				.collect(Collectors.toList());
		List<Integer> actual = ret.stream()
				.map(ForeignDigitsOperatorTest::greekToInt)
				.collect(Collectors.toList());
		assertEquals(expected, actual);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGreekZero() {
		operate("greek", Arrays.asList("0"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGreekMyriad() {
		operate("greek", Arrays.asList("10000"));
	}
	
}
