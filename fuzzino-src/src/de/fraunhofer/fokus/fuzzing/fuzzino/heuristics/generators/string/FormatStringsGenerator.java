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
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.FormatStrings;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;

public class FormatStringsGenerator extends SimpleStringGenerator {
	
	private static final long serialVersionUID = -972726578158153904L;
	protected static FormatStrings formatStrings = FormatStrings.INSTANCE;

	public FormatStringsGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
	}
	
	public FormatStringsGenerator(ComputableFuzzingHeuristic<?> owner, long seed, StringSpecification stringSpec) {
		super(stringSpec, seed, owner);
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		return true;
	}

	@Override
	public String getName() {
		return "FormatStrings";
	}

	@Override
	public List<String> getFuzzValues() {
		return formatStrings.getValues();
	}

	@Override
	public List<Integer> getFuzzValueLengths() {
		return formatStrings.getLengths();
	}

}
