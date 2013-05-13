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

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.SpecialBadUtf8Strings;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;

public class SpecialBadUtf8StringsGenerator extends SimpleStringGenerator {

	private static final long serialVersionUID = 4106194963270267622L;
	protected static SpecialBadUtf8Strings specialBadUtf8Strings = SpecialBadUtf8Strings.INSTANCE;
	
	public SpecialBadUtf8StringsGenerator(long seed, StringSpecification stringSpec) {
		super(stringSpec, seed);
	}
	
	public SpecialBadUtf8StringsGenerator(FuzzingHeuristic<?> owner, long seed, StringSpecification stringSpec) {
		super(stringSpec, seed, owner);
	}
	
	@Override
	public String getName() {
		return "SpecialBadUtf8StringsGenerator";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpecification) {
		return true;
	}

	@Override
	public List<String> getFuzzValues() {
		return specialBadUtf8Strings.getValues();
	}

	@Override
	public List<Integer> getFuzzValueLengths() {
		return specialBadUtf8Strings.getLengths();
	}

}
