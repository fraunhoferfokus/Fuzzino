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
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.Delimiters;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringType;

public class DelimitersGenerator extends SimpleStringGenerator {

	private static final long serialVersionUID = -5743510099717919588L;
	protected static Delimiters delimiters = Delimiters.INSTANCE;
	
	public DelimitersGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
	}

	public DelimitersGenerator(StringSpecification stringSpec, long seed, ComputableFuzzingHeuristic<?> owner) {
		super(stringSpec, seed, owner);
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		boolean validType = stringSpec.getType() == StringType.DELIMITER;
		
		return validType;
	}

	@Override
	public String getName() {
		return "Delimiters";
	}

	@Override
	public List<String> getFuzzValues() {
		return delimiters.getValues();
	}

	@Override
	public List<Integer> getFuzzValueLengths() {
		return delimiters.getLengths();
	}

}
