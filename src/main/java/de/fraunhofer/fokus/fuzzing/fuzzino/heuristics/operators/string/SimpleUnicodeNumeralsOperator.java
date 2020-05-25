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
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

/**
 * Replaces digits (U+0030 through U+0039) with various unicode characters
 * that have the corresponding Numeric_Digit property.
 * 
 * The param is a semicolon-separated list of optional parameters "num", "supp"
 * and "decimal". "num=X" specifies the number of values to generate (default: 5).
 * "supp" and "decimal" take values "yes" or "no":
 * 
 *  - "supp=yes" -> Only use supplementary characters
 *  - "supp=no" -> Only use non-supplementary characters
 *  - "decimal=yes" -> Only use characters with the Numeric_Decimal property
 *  - "decimal=no" -> Only use characters without the Numeric_Decimal property
 * 
 * If "supp=X" or "decimal=Y" are omitted, then no restriction is made on the
 * use of supplementary/decimal characters.
 * 
 * @author Jasper v. Blanckenburg (jasper.von.blanckenburg@fokus.fraunhofer.de)
 *
 */
public class SimpleUnicodeNumeralsOperator extends SimpleStringOperator {

	private static final long serialVersionUID = 6308550742368963820L;
	
	private static final List<List<String>> decimals;
	private static final List<List<String>> nondecimals;
	
	static {
		decimals = new ArrayList<>(10);
		nondecimals = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			decimals.add(new ArrayList<>());
			nondecimals.add(new ArrayList<>());
		}
		addRange(true, 0, 0xFF10, 0xFF19);   // FULLWIDTH
		addRange(true, 0, 0x1D7CE, 0x1D7D7); // MATHEMATICAL BOLD
		addRange(true, 0, 0x1D7D8, 0x1D7E1); // MATHEMATICAL DOUBLE-STRUCK
		addRange(true, 0, 0x1D7E2, 0x1D7EB); // MATHEMATICAL SANS-SERIF
		addRange(true, 0, 0x1D7EC, 0x1D7F5); // MATHEMATICAL SANS-SERIF BOLD
		addRange(true, 0, 0x1D7F6, 0x1D7FF); // MATHEMATICAL MONOSPACE
		addRange(true, 0, 0x1FBF0, 0x1FBF9); // SEGMENTED

		// SUPERSCRIPT {{{
		addDigit(false, 2, 0xB2);
		addDigit(false, 3, 0xB3);
		addDigit(false, 1, 0xB9);
		addDigit(false, 0, 0x2070);
		addRange(false, 4, 0x2074, 0x2079);
		// }}}
		addRange(false, 0, 0x2080, 0x2089);   // SUBSCRIPT
		addRange(false, 1, 0x2460, 0x2468);   // CIRCLED
		addRange(false, 1, 0x2474, 0x247C);   // PARENTHESIZED
		addRange(false, 1, 0x2488, 0x2490);   // FULL STOP
		addDigit(false, 0, 0x24EA);           // CIRCLED DIGIT ZERO
		addRange(false, 1, 0x24F5, 0x24FD);   // DOUBLE CIRCLED
		addDigit(false, 0, 0x24FF);           // NEGATIVE CIRCLED DIGIT ZERO
		addRange(false, 1, 0x2776, 0x277E);   // DINGBAT NEGATIVE CIRCLED
		addRange(false, 1, 0x2780, 0x2788);   // DINGBAT CIRCLED SANS-SERIF
		addRange(false, 1, 0x278A, 0x2792);   // DINGBAT NEGATIVE CIRCLED SANS-SERIF
		addDigit(false, 0, 0x1F100);          // DIGIT ZERO FULL STOP
		addRange(false, 0, 0x1F101, 0x1F10A); // COMMA
	}
	
	protected List<List<String>> digits;
	
	enum YESNO {NO, YES, ANY};
	
	protected int num;
	protected YESNO decimal;
	protected YESNO supp;
	
	private static void addDigit(boolean decimal, int digit, int uni) {
		List<List<String>> list = decimal ? decimals : nondecimals;
		list.get(digit).add(new String(Character.toChars(uni)));
	}
	
	private static void addRange(boolean decimal, int digitStart, int uniStart, int uniEnd) {
		int count = uniEnd - uniStart;
		for (int i = 0; i <= count; i++) {
			addDigit(decimal, digitStart + i, uniStart + i);
		}
	}

	public SimpleUnicodeNumeralsOperator(String validValue, String param, StringSpecification stringSpec, long seed,
			List<FuzzingHeuristic> owners) {
		super(validValue, stringSpec, seed, owners);

		num = 5;
		decimal = YESNO.ANY;
		supp = YESNO.ANY;
		parseParam(param);
		initDigits();
	}
	
	private void parseParam(String param) {
		if (param == null || param == "") {
			return;
		}
		String[] params = param.split(";");
		for (String p : params) {
			String[] spl = p.split("=");
			if (spl.length != 2) {
				throw new IllegalArgumentException(p + " is not a valid parameter");
			}
			if (spl[0].equals("num")) {
				num = Integer.valueOf(spl[1]);
			} else if (spl[0].equals("decimal")) {
				if (spl[1].equalsIgnoreCase("YES")) {
					decimal = YESNO.YES;
				} else if (spl[1].equalsIgnoreCase("NO")) {
					decimal = YESNO.NO;
				} else {
					throw new IllegalArgumentException(spl[1] = " is not a valid value for decimal");
				}
			} else if (spl[0].equals("supp")) {
				if (spl[1].equalsIgnoreCase("YES")) {
					supp = YESNO.YES;
				} else if (spl[1].equalsIgnoreCase("NO")) {
					supp = YESNO.NO;
				} else {
					throw new IllegalArgumentException(spl[1] = " is not a valid value for supp");
				}
			} else {
				throw new IllegalArgumentException(p + " is not a valid parameter");
			}
		}
	}

	private void initDigits() {
		digits = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			List<String> d = new ArrayList<>();
			if (decimal == YESNO.YES || decimal == YESNO.ANY) {
				addDigitsFrom(d, decimals.get(i));
			}
			if (decimal == YESNO.NO || decimal == YESNO.ANY) {
				addDigitsFrom(d, nondecimals.get(i));
			}
			digits.add(d);
		}
	}
	
	private void addDigitsFrom(List<String> addTo, List<String> addFrom) {
		for (String d : addFrom) {
			if (supp == YESNO.YES && !Character.isSupplementaryCodePoint(d.codePointAt(0))) {
				continue;
			}
			if (supp == YESNO.NO && Character.isSupplementaryCodePoint(d.codePointAt(0))) {
				break;
			}
			addTo.add(d);
		}
	}

	@Override
	public FuzzedValue<String> computeElement(int index) {
		if (index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < inputValue.length(); i++) {
			int digit = inputValue.charAt(i) - '0';
			sb.append(randomDigit(digit));
		}
		
		return new FuzzedValue<String>(sb.toString(), inputValue, owners);
	}
	
	protected String randomDigit(int digit) {
		List<String> d = digits.get(digit);
		return d.get(random.nextInt(d.size()));
	}

	@Override
	public String getName() {
		return "SimpleUnicodeNumeralsOperator";
	}

	@Override
	public int size() {
		return num;
	}

}
