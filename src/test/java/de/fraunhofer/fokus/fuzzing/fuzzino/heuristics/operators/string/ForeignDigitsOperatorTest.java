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
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class ForeignDigitsOperatorTest extends FuzzinoTest {
	
	private static Map<String, Integer> ABJAD;
	private static Map<String, Integer> GREEK;
	private static final String GREEK_KERAIA = "\u0374";
	private static final String GREEK_THOUSANDS = "͵";

	static {
		ABJAD = new HashMap<>();
		ABJAD.put("أ", 1);
		ABJAD.put("ب", 2);
		ABJAD.put("ج", 3);
		ABJAD.put("د", 4);
		ABJAD.put("ه", 5);
		ABJAD.put("و", 6);
		ABJAD.put("ز", 7);
		ABJAD.put("ح", 8);
		ABJAD.put("ط", 9);
		ABJAD.put("ي", 10);
		ABJAD.put("ك", 20);
		ABJAD.put("ل", 30);
		ABJAD.put("م", 40);
		ABJAD.put("ن", 50);
		ABJAD.put("س", 60);
		ABJAD.put("ع", 70);
		ABJAD.put("ف", 80);
		ABJAD.put("ص", 90);
		ABJAD.put("ق", 100);
		ABJAD.put("ر", 200);
		ABJAD.put("ش", 300);
		ABJAD.put("ت", 400);
		ABJAD.put("ث", 500);
		ABJAD.put("خ", 600);
		ABJAD.put("ذ", 700);
		ABJAD.put("ض", 800);
		ABJAD.put("ظ", 900);
		ABJAD.put("غ", 1000);

		GREEK = new HashMap<>();
		GREEK.put("Α", 1);
		GREEK.put("Β", 2);
		GREEK.put("Γ", 3);
		GREEK.put("Δ", 4);
		GREEK.put("Ε", 5);
		GREEK.put("Ϛ", 6);
		GREEK.put("Ζ", 7);
		GREEK.put("Η", 8);
		GREEK.put("Θ", 9);
		GREEK.put("Ι", 10);
		GREEK.put("Κ", 20);
		GREEK.put("Λ", 30);
		GREEK.put("Μ", 40);
		GREEK.put("Ν", 50);
		GREEK.put("Ξ", 60);
		GREEK.put("Ο", 70);
		GREEK.put("Π", 80);
		GREEK.put("Ϙ", 90);
		GREEK.put("Ρ", 100);
		GREEK.put("Σ", 200);
		GREEK.put("Τ", 300);
		GREEK.put("Υ", 400);
		GREEK.put("Φ", 500);
		GREEK.put("Χ", 600);
		GREEK.put("Ψ", 700);
		GREEK.put("Ω", 800);
		GREEK.put("Ͳ", 900);
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
				StringUtil.asList("٤٢", "٠", "١٠٠٠٠٠٠", "١٢٣٤٥٦٧٨٩٠")
		);
	}
	
	@Test
	public void testPersian() {
		testcase(
				"persian",
				StringUtil.asList("42", "0", "1000000", "1234567890"),
				StringUtil.asList("۴۲", "۰", "۱۰۰۰۰۰۰", "۱۲۳۴۵۶۷۸۹۰")
		);
	}
	
	@Test
	public void testSuzhouSimple() {
		testcase(
				"suzhou",
				StringUtil.asList("42", "0", "1000000", "1425367890"),
				StringUtil.asList("〤〢", "〇", "〡〇〇〇〇〇〇", "〡〤〢〥〣〦〧〨〩〇")
		);
	}
	
	@Test
	public void testSuzhouHorizontalBars() {
		testcase(
				"suzhou",
				StringUtil.asList("11111", "123321", "4022"),
				StringUtil.asList("〡一〡一〡", "〡二〣三〢一", "〤〇〢二")
		);
	}
	
	@Test
	public void testCJKSimple() {
		testcase(
				"cjk",
				StringUtil.asList("42", "0", "9876", "1235", "1111"),
				StringUtil.asList("四十二", "零", "九千八百七十六", "一千二百三十五", "一千一百一十一")
		);
	}
	
	@Test
	public void testCJKZeroes() {
		testcase(
				"cjk",
				StringUtil.asList("101", "1001", "100", "1000"),
				StringUtil.asList("一百零一", "一千零一", "一百", "一千")
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
						"一万二千三百四十五", "二十万一千二百三十四", "一载",
						"一十二兆三千四百五十六亿七千八百九十万二千三百四十五",
						"一百二十三京四千五百六十七兆八千九百零九亿八千七百六十五万四千三百二十一"
				)
		);
	}
	
	@Test
	public void testCJKTens() {
		testcase(
				"cjk",
				StringUtil.asList("10", "11", "12", "19", "20"),
				StringUtil.asList("十", "十一", "十二", "十九", "二十")
		);
	}
	
	private static int alphabeticToInt(String alphaNumber, Map<String, Integer> alphabet) {
		int sum = 0;
		for (int i = 0; i < alphaNumber.length(); i++) {
			String c = Character.toString(alphaNumber.charAt(i));
			sum += alphabet.get(c);
		}
		return sum;
	}
	
	@Test
	public void testAbjad() {
		List<String> numbers = Arrays.asList("42", "20000", "12356", "1", "777");
		List<String> ret = operate("abjad", numbers);
		assertTrue(ret.get(0).length() == 2);

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
			assertTrue(s.indexOf(GREEK_KERAIA) == s.length() - 1);
		}
		assertEquals(
				noKeraia,
				keraia.stream()
					.map(s -> s.substring(0, s.length() - 1))
					.collect(Collectors.toList())
		);
	}
	
	private static int greekToInt(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			String c = Character.toString(s.charAt(i));
			if (c.equals(GREEK_THOUSANDS)) {
				c = Character.toString(s.charAt(++i));
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
		assertTrue(ret.get(0).length() == 2);
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
