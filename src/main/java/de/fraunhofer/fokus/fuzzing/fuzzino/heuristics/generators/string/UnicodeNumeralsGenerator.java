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

import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.UnicodeNumerals;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

/**
 * A generator that generates strings containing various Unicode characters
 * with the Numeric_Value and Numeric_Decimal or Numeric_Digit property.
 *  
 * @author Jasper v. Blanckenburg <jasper.von.blanckenburg@fokus.fraunhofer.de>
 */
public class UnicodeNumeralsGenerator extends SimpleStringGenerator {

	private static final long serialVersionUID = -5093288138451258616L;
	protected static UnicodeNumerals unicodeNumerals = UnicodeNumerals.INSTANCE;

	public UnicodeNumeralsGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
		this.owners.add(this);
	}
	
	public UnicodeNumeralsGenerator(StringSpecification stringSpec, long seed, List<FuzzingHeuristic> owners) {
		super(stringSpec, seed, owners);
		this.owners.add(this);
	}

	@Override
	public String getName() {
		return "UnicodeNumerals";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		return true;
	}

	@Override
	public List<String> getFuzzValues() {
		return unicodeNumerals.getValues();
	}

	@Override
	public List<Integer> getFuzzValueLengths() {
		return unicodeNumerals.getLengths();
	}

}
