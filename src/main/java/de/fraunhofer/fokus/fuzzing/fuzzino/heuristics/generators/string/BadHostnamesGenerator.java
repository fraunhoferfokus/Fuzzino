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

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

/**
 * This generator creates long hostnames, host names with sequences of "." and
 * similar hostnames including top level domains. They are taken from Peach.
 */
public class BadHostnamesGenerator extends ComposedStringGenerator {

	private static final long serialVersionUID = -5983266903748753992L;

	public BadHostnamesGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
		initHeuristics();
	}

	public BadHostnamesGenerator(ComputableFuzzingHeuristic<?> owner, long seed, StringSpecification stringSpec) {
		super(stringSpec, seed, owner);
		initHeuristics();
	}

	private void initHeuristics() {

		AllBadStringsGenerator badStrings = new AllBadStringsGenerator(owner, seed, stringSpec);
		heuristics.add(badStrings);

		StringRepeater strRepeater_A_1 = new StringRepeater(stringSpec, owner, seed,
				new StringRepeater.Builder().startIndex(1));
		heuristics.add(strRepeater_A_1);

		StringRepeater strRepeater_A_2 = new StringRepeater(stringSpec, owner, seed,
				new StringRepeater.Builder().stepSize(100).size(100).startIndex(100));
		heuristics.add(strRepeater_A_2);

		StringRepeater strRepeater_AdotAdotAdotAdotAdot_ = new StringRepeater(stringSpec, owner, seed,
				new StringRepeater.Builder().string(StringUtil.repeat("A.", 5)).size(100).startIndex(1));
		heuristics.add(strRepeater_AdotAdotAdotAdotAdot_);

		StringRepeater strRepeater_dot_ = new StringRepeater(stringSpec, owner, seed,
				new StringRepeater.Builder().string(".").size(10).startIndex(1));
		heuristics.add(strRepeater_dot_);

		StringRepeater strRepeater_dot_20 = new StringRepeater(stringSpec, owner, seed,
				new StringRepeater.Builder().string(StringUtil.repeat(".", 20)).size(20).startIndex(1));
		heuristics.add(strRepeater_dot_20);

		StringRepeater strRepeater_AAAAA_20 = new StringRepeater(stringSpec, owner, seed,
				new StringRepeater.Builder().string(StringUtil.repeat("A", 5)).size(20).startIndex(1));
		ConcreteValuesGenerator dotGenerator = new ConcreteValuesGenerator(stringSpec, seed, owner, ".");
		Combinator aaaaDotAaaaaDotAaaaa = new Combinator(stringSpec, seed, owner, strRepeater_AAAAA_20, dotGenerator,
				strRepeater_AAAAA_20);
		heuristics.add(aaaaDotAaaaaDotAaaaa);

		ConcreteValuesGenerator tld = new ConcreteValuesGenerator(stringSpec, seed, owner, "AC", "AD", "AE", "AERO",
				"AF", "AG", "AI", "AL", "AM", "AN", "AO", "AQ", "AR", "ARPA", "AS", "AT", "AU", "AW", "AX", "AZ", "BA",
				"BB", "BD", "BE", "BF", "BG", "BH", "BI", "BIZ", "BJ", "BM", "BN", "BO", "BR", "BS", "BT", "BV", "BW",
				"BY", "BZ", "CA", "CAT", "CC", "CD", "CF", "CG", "CH", "CI", "CK", "CL", "CM", "CN", "CO", "COM",
				"COOP", "CR", "CU", "CV", "CX", "CY", "CZ", "DE", "DJ", "DK", "DM", "DO", "DZ", "EC", "EDU", "EE", "EG",
				"ER", "ES", "ET", "EU", "FI", "FJ", "FK", "FM", "FO", "FR", "GA", "GB", "GD", "GE", "GF", "GG", "GH",
				"GI", "GL", "GM", "GN", "GOV", "GP", "GQ", "GR", "GS", "GT", "GU", "GW", "GY", "HK", "HM", "HN", "HR",
				"HT", "HU", "ID", "IE", "IL", "IM", "IN", "INFO", "INT", "IO", "IQ", "IR", "IS", "IT", "JE", "JM", "JO",
				"JOBS", "JP", "KE", "KG", "KH", "KI", "KM", "KN", "KR", "KW", "KY", "KZ", "LA", "LB", "LC", "LI", "LK",
				"LR", "LS", "LT", "LU", "LV", "LY", "MA", "MC", "MD", "MG", "MH", "MIL", "MK", "ML", "MM", "MN", "MO",
				"MOBI", "MP", "MQ", "MR", "MS", "MT", "MU", "MUSEUM", "MV", "MW", "MX", "MY", "MZ", "NA", "NAME", "NC",
				"NE", "NET", "NF", "NG", "NI", "NL", "NO", "NP", "NR", "NU", "NZ", "OM", "ORG", "PA", "PE", "PF", "PG",
				"PH", "PK", "PL", "PM", "PN", "PR", "PRO", "PS", "PT", "PW", "PY", "QA", "RE", "RO", "RU", "RW", "SA",
				"SB", "SC", "SD", "SE", "SG", "SH", "SI", "SJ", "SK", "SL", "SM", "SN", "SO", "SR", "ST", "SU", "SV",
				"SY", "SZ", "TC", "TD", "TF", "TG", "TH", "TJ", "TK", "TL", "TM", "TN", "TO", "TP", "TR", "TRAVEL",
				"TT", "TV", "TW", "TZ", "UA", "UG", "UK", "UM", "US", "UY", "UZ", "VA", "VC", "VE", "VG", "VI", "VN",
				"VU", "WF", "WS", "YE", "YT", "YU", "ZA", "ZM", "ZW");

		ConcreteValuesGenerator aaaaDot = new ConcreteValuesGenerator(stringSpec, seed, owner, "AAAA.");
		Combinator aaaaDotTld = new Combinator(stringSpec, seed, owner, aaaaDot, tld);
		heuristics.add(aaaaDotTld);

		heuristics.add(new ConcreteValuesGenerator(stringSpec, seed, owner, "localhost"));
	}

	@Override
	public String getName() {
		return "BadHostnames";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification spec) {
		boolean properType = spec.getType() == StringType.HOSTNAME;
		return properType;
	}

}
