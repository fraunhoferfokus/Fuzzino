package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

/**
 * Converts a number into different number systems.
 * 
 * The param is a semicolon-separated list of number systems to convert to.
 * Possible values are (case-insensitive):
 *  - eastern_arabic
 *  - persian (same as eastern_arabic, but with the Persian variant of the characters)
 *  - abjad
 *  - greek
 *  - greek_keraia (same as greek, but with a keraia at the end)
 *  - cjk
 *  - suzhou
 *  
 * @author jbl
 *
 */
public class SimpleForeignDigitsOperator extends SimpleStringOperator {
	
	private static final long serialVersionUID = -7192971817019979803L;

	enum NumberSystem {EASTERN_ARABIC, PERSIAN, ABJAD, GREEK, GREEK_KERAIA, CJK, SUZHOU};
	private List<NumberSystem> enabledSystems;
	private static final Map<String, NumberSystem> SYSTEM_NAMES;
	private static final List<String> EASTERN_ARABIC_DIGITS;
	private static final List<String> PERSIAN_DIGITS;
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
		SYSTEM_NAMES.put("ABJAD", NumberSystem.ABJAD);
		SYSTEM_NAMES.put("GREEK", NumberSystem.GREEK);
		SYSTEM_NAMES.put("GREEK_KERAIA", NumberSystem.GREEK_KERAIA);
		SYSTEM_NAMES.put("CJK", NumberSystem.CJK);
		SYSTEM_NAMES.put("SUZHOU", NumberSystem.SUZHOU);
		EASTERN_ARABIC_DIGITS = Arrays.asList(
				"٠", "١", "٢", "٣", "٤", "٥", "٦", "٧", "٨", "٩"
		);
		PERSIAN_DIGITS = Arrays.asList(
				"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"
		);
		SUZHOU_DIGITS = Arrays.asList(
				"〇", "〡", "〢", "〣", "〤", "〥", "〦", "〧", "〨", "〩"
		);
		CJK_DIGITS = Arrays.asList(
				"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"
		);
		CJK_POWERS_OF_TEN = Arrays.asList(
				"十", "百", "千"
		);
		CJK_MYRIADS = Arrays.asList(
				"万", "亿", "兆", "京", "垓", "秭", "穰", "沟", "涧", "正", "载"
		);
		ABJAD_DIGITS = new TreeMap<>(Collections.reverseOrder());
		ABJAD_DIGITS.put(1, "أ");
		ABJAD_DIGITS.put(2, "ب");
		ABJAD_DIGITS.put(3, "ج");
		ABJAD_DIGITS.put(4, "د");
		ABJAD_DIGITS.put(5, "ه");
		ABJAD_DIGITS.put(6, "و");
		ABJAD_DIGITS.put(7, "ز");
		ABJAD_DIGITS.put(8, "ح");
		ABJAD_DIGITS.put(9, "ط");
		ABJAD_DIGITS.put(10, "ي");
		ABJAD_DIGITS.put(20, "ك");
		ABJAD_DIGITS.put(30, "ل");
		ABJAD_DIGITS.put(40, "م");
		ABJAD_DIGITS.put(50, "ن");
		ABJAD_DIGITS.put(60, "س");
		ABJAD_DIGITS.put(70, "ع");
		ABJAD_DIGITS.put(80, "ف");
		ABJAD_DIGITS.put(90, "ص");
		ABJAD_DIGITS.put(100, "ق");
		ABJAD_DIGITS.put(200, "ر");
		ABJAD_DIGITS.put(300, "ش");
		ABJAD_DIGITS.put(400, "ت");
		ABJAD_DIGITS.put(500, "ث");
		ABJAD_DIGITS.put(600, "خ");
		ABJAD_DIGITS.put(700, "ذ");
		ABJAD_DIGITS.put(800, "ض");
		ABJAD_DIGITS.put(900, "ظ");
		ABJAD_DIGITS.put(1000, "غ");

		GREEK_DIGITS = new TreeMap<>(Collections.reverseOrder());
		GREEK_DIGITS.put(1, "Α");
		GREEK_DIGITS.put(2, "Β");
		GREEK_DIGITS.put(3, "Γ");
		GREEK_DIGITS.put(4, "Δ");
		GREEK_DIGITS.put(5, "Ε");
		GREEK_DIGITS.put(6, "Ϛ");
		GREEK_DIGITS.put(7, "Ζ");
		GREEK_DIGITS.put(8, "Η");
		GREEK_DIGITS.put(9, "Θ");
		GREEK_DIGITS.put(10, "Ι");
		GREEK_DIGITS.put(20, "Κ");
		GREEK_DIGITS.put(30, "Λ");
		GREEK_DIGITS.put(40, "Μ");
		GREEK_DIGITS.put(50, "Ν");
		GREEK_DIGITS.put(60, "Ξ");
		GREEK_DIGITS.put(70, "Ο");
		GREEK_DIGITS.put(80, "Π");
		GREEK_DIGITS.put(90, "Ϙ");
		GREEK_DIGITS.put(100, "Ρ");
		GREEK_DIGITS.put(200, "Σ");
		GREEK_DIGITS.put(300, "Τ");
		GREEK_DIGITS.put(400, "Υ");
		GREEK_DIGITS.put(500, "Φ");
		GREEK_DIGITS.put(600, "Χ");
		GREEK_DIGITS.put(700, "Ψ");
		GREEK_DIGITS.put(800, "Ω");
		GREEK_DIGITS.put(900, "Ͳ");
	}

	public SimpleForeignDigitsOperator(String validValue, String param, StringSpecification stringSpec, long seed,
			List<FuzzingHeuristic> owners) {
		super(validValue, stringSpec, seed, owners);
		this.owners.add(this);

		if (param == null || param == "") {
			enabledSystems = Arrays.asList(NumberSystem.values());
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

	@Override
	public FuzzedValue<String> computeElement(int index) {
		String value;
		switch (enabledSystems.get(index)) {
		// Eastern Arabic/Persian are simply Arabic numbers with other characters
		case EASTERN_ARABIC:
			value = replaceDigits(EASTERN_ARABIC_DIGITS);
			break;
		case PERSIAN:
			value = replaceDigits(PERSIAN_DIGITS);
			break;
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
			// 〡〢 could be mistaken for 〣, so CJK ideographs (horizontal lines)
			// are alternated with normal Suzhou characters sometimes
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
		if (inputValue.equals("0")) return "零";
		// Edge case: 10-19 don't have a leading 一
		if (inputValue.length() == 2 && inputValue.charAt(0) == '1') {
			StringBuilder sb = new StringBuilder("十");
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
