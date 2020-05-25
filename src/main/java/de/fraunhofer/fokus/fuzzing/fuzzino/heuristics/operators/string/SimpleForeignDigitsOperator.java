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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringEncoder;

/**
 * Converts a number into different number systems.
 * 
 * The param is a semicolon-separated list of number systems to convert to.
 * Possible values are (case-insensitive):
 *  - eastern_arabic
 *  - persian (same as eastern_arabic, but with the Persian variant of the characters)
 *  - nko
 *  - devanagari
 *  - osmanya
 *  - brahmi
 *  - sora_sompeng
 *  - chakma
 *  - abjad
 *  - greek
 *  - greek_keraia (same as greek, but with a keraia at the end)
 *  - cjk
 *  - suzhou
 *  
 * @author Jasper v. Blanckenburg (jasper.von.blanckenburg@fokus.fraunhofer.de)
 *
 */
public class SimpleForeignDigitsOperator extends SimpleStringOperator {
	
	private static final long serialVersionUID = -7192971817019979803L;

	enum NumberSystem {
		EASTERN_ARABIC, PERSIAN, NKO, DEVANAGARI, OSMANYA, BRAHMI, SORA_SOMPENG,
		CHAKMA, ABJAD, GREEK, GREEK_KERAIA, CJK, SUZHOU
	};
	private List<NumberSystem> enabledSystems;
	private static final Map<String, NumberSystem> SYSTEM_NAMES;
	private static final Map<NumberSystem, List<Double>> SYSTEM_LIMITS;
	private static final Map<NumberSystem, List<String>> DECIMAL_DIGITS;
	private static final List<String> SUZHOU_DIGITS;
	private static final List<String> CJK_DIGITS;
	private static final List<String> CJK_POWERS_OF_TEN;
	private static final List<String> CJK_MYRIADS;
	private static final SortedMap<Integer, String> ABJAD_DIGITS;
	private static final SortedMap<Integer, String> GREEK_DIGITS;
	private static final String GREEK_KERAIA = "\u0374";
	private static final String GREEK_THOUSANDS = "\u0375";
	
	static {
		SYSTEM_NAMES = new HashMap<>();
		SYSTEM_NAMES.put("EASTERN_ARABIC", NumberSystem.EASTERN_ARABIC);
		SYSTEM_NAMES.put("PERSIAN", NumberSystem.PERSIAN);
		SYSTEM_NAMES.put("NKO", NumberSystem.NKO);
		SYSTEM_NAMES.put("DEVANAGARI", NumberSystem.DEVANAGARI);
		SYSTEM_NAMES.put("OSMANYA", NumberSystem.OSMANYA);
		SYSTEM_NAMES.put("BRAHMI", NumberSystem.BRAHMI);
		SYSTEM_NAMES.put("SORA_SOMPENG", NumberSystem.SORA_SOMPENG);
		SYSTEM_NAMES.put("CHAKMA", NumberSystem.CHAKMA);
		SYSTEM_NAMES.put("ABJAD", NumberSystem.ABJAD);
		SYSTEM_NAMES.put("GREEK", NumberSystem.GREEK);
		SYSTEM_NAMES.put("GREEK_KERAIA", NumberSystem.GREEK_KERAIA);
		SYSTEM_NAMES.put("CJK", NumberSystem.CJK);
		SYSTEM_NAMES.put("SUZHOU", NumberSystem.SUZHOU);
		SYSTEM_LIMITS = new HashMap<>();
		// Technically, Abjad numbers can be arbitrarily large, but it doesn't make sense
		// past a certain point
		SYSTEM_LIMITS.put(NumberSystem.ABJAD, Arrays.asList(1., 1E4));
		SYSTEM_LIMITS.put(NumberSystem.GREEK, Arrays.asList(1., 1E4));
		SYSTEM_LIMITS.put(NumberSystem.GREEK_KERAIA, Arrays.asList(1., 1E4));
		DECIMAL_DIGITS = new HashMap<>();
		DECIMAL_DIGITS.put(NumberSystem.EASTERN_ARABIC, unicodeRange(0x660, 0x669));
		DECIMAL_DIGITS.put(NumberSystem.PERSIAN, unicodeRange(0x6f0, 0x6f9));
		DECIMAL_DIGITS.put(NumberSystem.NKO, unicodeRange(0x7c0, 0x7c9));
		DECIMAL_DIGITS.put(NumberSystem.DEVANAGARI, unicodeRange(0x966, 0x96f));
		DECIMAL_DIGITS.put(NumberSystem.OSMANYA, unicodeRange(0x104a0, 0x104a9));
		DECIMAL_DIGITS.put(NumberSystem.BRAHMI, unicodeRange(0x11066, 0x1106f));
		DECIMAL_DIGITS.put(NumberSystem.SORA_SOMPENG, unicodeRange(0x110f0, 0x110f9));
		DECIMAL_DIGITS.put(NumberSystem.CHAKMA, unicodeRange(0x11136, 0x1113f));
		SUZHOU_DIGITS = Arrays.asList(
				"\u3007", "\u3021", "\u3022", "\u3023", "\u3024",
				"\u3025", "\u3026", "\u3027", "\u3028", "\u3029"
		);
		CJK_DIGITS = Arrays.asList(
				"\u96f6", "\u4e00", "\u4e8c", "\u4e09", "\u56db",
				"\u4e94", "\u516d", "\u4e03", "\u516b", "\u4e5d"
		);
		CJK_POWERS_OF_TEN = Arrays.asList(
				"\u5341", "\u767e", "\u5343"
		);
		CJK_MYRIADS = Arrays.asList(
				"\u4e07", "\u4ebf", "\u5146", "\u4eac", "\u5793",
				"\u79ed", "\u7a70", "\u6c9f", "\u6da7", "\u6b63", "\u8f7d"
		);
		ABJAD_DIGITS = new TreeMap<>(Collections.reverseOrder());
		ABJAD_DIGITS.put(1, "\u0623");
		ABJAD_DIGITS.put(2, "\u0628");
		ABJAD_DIGITS.put(3, "\u062c");
		ABJAD_DIGITS.put(4, "\u062f");
		ABJAD_DIGITS.put(5, "\u0647");
		ABJAD_DIGITS.put(6, "\u0648");
		ABJAD_DIGITS.put(7, "\u0632");
		ABJAD_DIGITS.put(8, "\u062d");
		ABJAD_DIGITS.put(9, "\u0637");
		ABJAD_DIGITS.put(10, "\u064a");
		ABJAD_DIGITS.put(20, "\u0643");
		ABJAD_DIGITS.put(30, "\u0644");
		ABJAD_DIGITS.put(40, "\u0645");
		ABJAD_DIGITS.put(50, "\u0646");
		ABJAD_DIGITS.put(60, "\u0633");
		ABJAD_DIGITS.put(70, "\u0639");
		ABJAD_DIGITS.put(80, "\u0641");
		ABJAD_DIGITS.put(90, "\u0635");
		ABJAD_DIGITS.put(100, "\u0642");
		ABJAD_DIGITS.put(200, "\u0631");
		ABJAD_DIGITS.put(300, "\u0634");
		ABJAD_DIGITS.put(400, "\u062a");
		ABJAD_DIGITS.put(500, "\u062b");
		ABJAD_DIGITS.put(600, "\u062e");
		ABJAD_DIGITS.put(700, "\u0630");
		ABJAD_DIGITS.put(800, "\u0636");
		ABJAD_DIGITS.put(900, "\u0638");
		ABJAD_DIGITS.put(1000, "\u063a");

		GREEK_DIGITS = new TreeMap<>(Collections.reverseOrder());
		GREEK_DIGITS.put(1, "\u0391");
		GREEK_DIGITS.put(2, "\u0392");
		GREEK_DIGITS.put(3, "\u0393");
		GREEK_DIGITS.put(4, "\u0394");
		GREEK_DIGITS.put(5, "\u0395");
		GREEK_DIGITS.put(6, "\u03da");
		GREEK_DIGITS.put(7, "\u0396");
		GREEK_DIGITS.put(8, "\u0397");
		GREEK_DIGITS.put(9, "\u0398");
		GREEK_DIGITS.put(10, "\u0399");
		GREEK_DIGITS.put(20, "\u039a");
		GREEK_DIGITS.put(30, "\u039b");
		GREEK_DIGITS.put(40, "\u039c");
		GREEK_DIGITS.put(50, "\u039d");
		GREEK_DIGITS.put(60, "\u039e");
		GREEK_DIGITS.put(70, "\u039f");
		GREEK_DIGITS.put(80, "\u03a0");
		GREEK_DIGITS.put(90, "\u03d8");
		GREEK_DIGITS.put(100, "\u03a1");
		GREEK_DIGITS.put(200, "\u03a3");
		GREEK_DIGITS.put(300, "\u03a4");
		GREEK_DIGITS.put(400, "\u03a5");
		GREEK_DIGITS.put(500, "\u03a6");
		GREEK_DIGITS.put(600, "\u03a7");
		GREEK_DIGITS.put(700, "\u03a8");
		GREEK_DIGITS.put(800, "\u03a9");
		GREEK_DIGITS.put(900, "\u0372");
	}
	
	private static final List<String> unicodeRange(int start, int end) {
		return IntStream.rangeClosed(start, end)
			.mapToObj(i -> new String(Character.toChars(i)))
			.collect(Collectors.toList());
	}

	public SimpleForeignDigitsOperator(String validValue, String param, StringSpecification stringSpec, long seed,
			List<FuzzingHeuristic> owners) {
		super(validValue, stringSpec, seed, owners);

		if (param == null || param == "") {
			enabledSystems = generateEnabledSystems();
		} else {
			String[] systems = param.split(";");
			enabledSystems = new ArrayList<>(systems.length);
			for (String s : systems) {
				NumberSystem ns = SYSTEM_NAMES.get(s.toUpperCase());
				if (ns == null) {
					throw new IllegalArgumentException(s + " is not a supported number system");
				}
				enabledSystems.add(ns);
			}
		}
	}

	private List<NumberSystem> generateEnabledSystems() {
		double val = Double.valueOf(inputValue);
		return Arrays.stream(NumberSystem.values())
				.filter(ns -> {
					List<Double> limits = SYSTEM_LIMITS.get(ns);
					return limits == null || (val >= limits.get(0) && val <= limits.get(1));
				})
				.collect(Collectors.toList());
	}

	@Override
	public FuzzedValue<String> computeElement(int index) {
		String value;
		NumberSystem system = enabledSystems.get(index);
		List<String> decDigits = DECIMAL_DIGITS.get(system);

		if (decDigits != null) {
			value = replaceDigits(decDigits);
		} else {
			switch (system) {
			case ABJAD:
				value = abjadString(ABJAD_DIGITS);
				break;
			case GREEK:
				value = greekDigits();
				break;
			case GREEK_KERAIA:
				value = greekDigits() + GREEK_KERAIA;
				break;
			case CJK:
				value = cjkDigits();
				break;
			// Suzhou is almost Arabic with other characters, but it has an exception for consecutive 1/2/3
			case SUZHOU:
				value = suzhouDigits();
				break;
			default:
				throw new RuntimeException();
			}
		}
		
		value = StringEncoder.encode(value);
		return new FuzzedValue<String>(value, inputValue, owners);
	}
	
	private String replaceDigits(List<String> digits) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < inputValue.length(); i++) {
			int digit = inputValue.charAt(i) - '0';
			sb.append(digits.get(digit));
		}

		return sb.toString();
	}
	
	private String suzhouDigits() {
		StringBuilder sb = new StringBuilder();
		boolean last_was_vertical = false;

		for (int i = 0; i < inputValue.length(); i++) {
			int digit = inputValue.charAt(i) - '0';
			if (digit >= 1 && digit <= 3) {
				if (last_was_vertical) {
					sb.append(CJK_DIGITS.get(digit));
					last_was_vertical = false;
				} else {
					last_was_vertical = true;
					sb.append(SUZHOU_DIGITS.get(digit));
				}
				continue;
			}
			last_was_vertical = false;
			sb.append(SUZHOU_DIGITS.get(digit));
		}

		return sb.toString();
	}
	
	private String cjkDigits() {
		// Edge case: Zero
		if (inputValue.equals("0")) return CJK_DIGITS.get(0);
		// Edge case: 10-19 don't have a leading 1
		if (inputValue.length() == 2 && inputValue.charAt(0) == '1') {
			StringBuilder sb = new StringBuilder(CJK_POWERS_OF_TEN.get(0));
			int second_digit = inputValue.charAt(1) - '0';
			if (second_digit != 0) {
				sb.append(CJK_DIGITS.get(second_digit));
			}
			return sb.toString();
		}

		StringBuilder sb = new StringBuilder();
		int power_of_ten = 0;
		int myriad = 0;
		boolean last_was_zero = false;
		boolean last_digit = true;
		boolean new_myriad;
		boolean nonzero_in_myriad = false;

		for (int i = inputValue.length() - 1; i >= 0; i--) {
			if (power_of_ten == 4) {
				new_myriad = true;
				// Remove previous myriad if it was empty
				if (!nonzero_in_myriad && sb.length() > 0) {
					sb.setLength(sb.length() - 1);
				}
				sb.append(CJK_MYRIADS.get(myriad));
				myriad++;
				power_of_ten = 0;
				nonzero_in_myriad = false;
			} else {
				new_myriad = false;
			}
			int digit = inputValue.charAt(i) - '0';
			// CJK numerals are complicated with zeroes
			if (digit == 0) {
				// Trailing zeroes are not written
				if (last_digit) {
					last_was_zero = true;
				}
				// Consecutive zeroes and zeroes before a myriad are not written
				if (!last_was_zero && !new_myriad) {
					sb.append(CJK_DIGITS.get(0));
					last_was_zero = true;
				}
				// The power of ten is only written if the digit was not zero
			} else {
				last_was_zero = false;
				nonzero_in_myriad = true;
				if (power_of_ten > 0) {
					sb.append(CJK_POWERS_OF_TEN.get(power_of_ten - 1));
				}
				sb.append(CJK_DIGITS.get(digit));
			}
			power_of_ten++;
			last_digit = false;
		}

		return sb.reverse().toString();
	}
	
	private String abjadString(SortedMap<Integer, String> abjad) {
		StringBuilder sb = new StringBuilder();
		int remaining = Integer.valueOf(inputValue);

		if (remaining == 0) {
			throw new IllegalArgumentException("0 can not be translated into an Abjad system");
		}

		while (remaining > 0) {
			for (Map.Entry<Integer, String> entry : abjad.entrySet()) {
				if (entry.getKey() <= remaining) {
					sb.append(entry.getValue());
					remaining -= entry.getKey();
					break;
				}
			}
		}
		
		return sb.toString();
	}
	
	private String greekDigits() {
		StringBuilder sb = new StringBuilder();
		int remaining = Integer.valueOf(inputValue);

		if (remaining == 0) {
			throw new IllegalArgumentException("0 can not be written in Greek numerals");
		} else if (remaining >= 10000) {
			// Ancient Greek had the Myriad notation which could express numbers up to 
			// 10000^2, but this is ambiguous with the modern uppercase numbers
			throw new IllegalArgumentException("Numbers >=10000 can not be written in modern Greek numerals");
		}

		while (remaining > 0) {
			if (remaining >= 1000) {
				Map.Entry<Integer, String> d = greekDigit(remaining / 1000);
				sb.append(GREEK_THOUSANDS + d.getValue());
				remaining -= d.getKey() * 1000;
				continue;
			}
			Map.Entry<Integer, String> d = greekDigit(remaining);
			sb.append(d.getValue());
			remaining -= d.getKey();
		}
		
		return sb.toString();
	}
	
	private Map.Entry<Integer, String> greekDigit(int remaining) {
		for (Map.Entry<Integer, String> entry : GREEK_DIGITS.entrySet()) {
			if (entry.getKey() <= remaining) {
				return entry;
			}
		}
		
		return null;
	}

	@Override
	public String getName() {
		return "SimpleForeignDigitsOperator";
	}

	@Override
	public int size() {
		return enabledSystems.size();
	}

}
