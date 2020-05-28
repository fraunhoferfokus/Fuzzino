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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ResourcePath;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ResourceResolver;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.UnicodeDecoder;

public class UnicodeNumeralsOperatorTest extends FuzzinoTest {
	
	public static final long SEED = 4711;
	private static Map<Integer, Integer> decimals;
	private static Map<Integer, Integer> digits;
	
	static {
		Scanner scanner;
		try {
			scanner = new Scanner(
					new ResourceResolver().loadProjectFile(
							ResourcePath.TEST_RESOURCE + "unicode/UnicodeDataNumeric.txt"
					)
			);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("UnicodeDataNumeric.txt is missing!");
		}
		
		decimals = new HashMap<>();
		digits = new HashMap<>();
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] spl = line.split(";");
			int cp = Integer.valueOf(spl[0], 16);
			if (!spl[6].isEmpty()) {
				decimals.put(cp, Integer.valueOf(spl[6]));
			}
			digits.put(cp, Integer.valueOf(spl[7]));
		}
	}

	private static List<String> operate(String param, List<String> numbers) {
		UnicodeNumeralsOperator operator = new UnicodeNumeralsOperator(
				numbers, param, null, SEED);
		return operator.stream()
				.map(FuzzedValue::getValue)
				.map(UnicodeDecoder::decode)
				.collect(Collectors.toList());
	}
	
	private void checkValue(String input, String result) {
		for (int offset = 0, i = 0; offset < result.length(); i++) {
			int expected = input.charAt(i) - '0';
			int cp = result.codePointAt(offset);
			int actual = digits.get(cp);
			assertEquals(expected, actual);
			
			offset += Character.charCount(cp);
		}
	}
	
	private void checkValues(List<String> input, List<String> result, int num) {
		assertEquals(num * input.size(), result.size());
		for (int i = 0; i < result.size(); i++) {
			checkValue(input.get(i % input.size()), result.get(i));
		}
	}
	
	@Test
	public void testSimple() {
		List<String> input = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
		List<String> result = operate("num=20", input);
		checkValues(input, result, 20);
	}
	
	@Test
	public void testNum() {
		List<String> input = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
		List<String> result5 = operate("num=5", input);
		List<String> result20 = operate("num=20", input);
		checkValues(input, result5, 5);
		checkValues(input, result20, 20);
	}
	
	@Test
	public void testDecimal() {
		List<String> input = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
		List<String> resultAny = operate("num=20", input);
		List<String> resultYes = operate("num=20;decimal=yes", input);
		List<String> resultNo = operate("num=20;decimal=no", input);
		checkValues(input, resultYes, 20);
		checkValues(input, resultNo, 20);

		boolean anyDecimal = false;
		boolean anyNotDecimal = false;
		for (int i = 0; i < 200; i++) {
			int y = resultYes.get(i).codePointAt(0);
			int n = resultNo.get(i).codePointAt(0);
			assertNotNull(decimals.get(y));
			assertNull(decimals.get(n));

			int a = resultAny.get(i).codePointAt(0);
			if (decimals.get(a) == null) {
				anyNotDecimal = true;
			} else {
				anyDecimal = true;
			}
		}
		assertTrue(anyDecimal);
		assertTrue(anyNotDecimal);
	}
	
	@Test
	public void testSupp() {
		List<String> input = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
		List<String> resultAny = operate("num=20", input);
		List<String> resultYes = operate("num=20;supp=yes", input);
		List<String> resultNo = operate("num=20;supp=no", input);
		checkValues(input, resultYes, 20);
		checkValues(input, resultNo, 20);

		boolean anySupp = false;
		boolean anyNotSupp = false;
		for (int i = 0; i < 200; i++) {
			int y = resultYes.get(i).codePointAt(0);
			int n = resultNo.get(i).codePointAt(0);
			assertTrue(Character.isSupplementaryCodePoint(y));
			assertFalse(Character.isSupplementaryCodePoint(n));

			int a = resultAny.get(i).codePointAt(0);
			if (Character.isSupplementaryCodePoint(a)) {
				anySupp = true;
			} else {
				anyNotSupp = true;
			}
		}
		assertTrue(anySupp);
		assertTrue(anyNotSupp);
	}
	
	@Test
	public void testEmptyParam() {
		List<String> input = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
		List<String> result = operate("", input);
		checkValues(input, result, 5);
	}
	
	@Test
	public void testComplex() {
		List<String> input = Arrays.asList("1234567890", "42424242", "777777");
		List<String> resultAny = operate("num=20", input);
		List<String> result = operate("num=20;supp=yes;decimal=no", input);
		checkValues(input, resultAny, 20);
		checkValues(input, result, 20);
		
		for (int i = 0; i < result.size(); i++) {
			String r = result.get(i);
			for (int offset = 0; offset < r.length();) {
				int cp = r.codePointAt(offset);
				assertTrue(Character.isSupplementaryCodePoint(cp));
				assertNull(decimals.get(cp));

				offset += Character.charCount(cp);
			}
		}
	}

}
