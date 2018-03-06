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

import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.SpecialUnicodeBomStrings;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringEncoding;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

public class SpecialUnicodeBomStringsGenerator extends SimpleStringGenerator {
	
	private static final long serialVersionUID = -3788510733877627596L;
	protected static SpecialUnicodeBomStrings specialUnicodeBomStrings = SpecialUnicodeBomStrings.INSTANCE;

	public SpecialUnicodeBomStringsGenerator(long seed, StringSpecification stringSpec) {
		super(stringSpec, seed);
	}
	
	public SpecialUnicodeBomStringsGenerator(ComputableFuzzingHeuristic<?> owner, long seed, StringSpecification stringSpec) {
		super(stringSpec, seed, owner);
	}
	
	@Override
	public String getName() {
		return "SpecialUnicodeBomStrings";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		boolean validEncoding = stringSpec.getEncoding() == StringEncoding.UTF8 ||
				                stringSpec.getEncoding() == StringEncoding.UTF16 ||
				                stringSpec.getEncoding() == StringEncoding.UTF32;
		return validEncoding;
	}

	@Override
	public List<String> getFuzzValues() {
		return specialUnicodeBomStrings.getValues();
	}

	@Override
	public List<Integer> getFuzzValueLengths() {
		return specialUnicodeBomStrings.getLengths();
	}

}
