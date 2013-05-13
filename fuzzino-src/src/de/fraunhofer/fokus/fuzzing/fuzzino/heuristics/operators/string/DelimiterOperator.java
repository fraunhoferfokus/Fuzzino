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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string;

import java.util.ArrayList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComposedFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.StringOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringType;

public class DelimiterOperator extends ComposedFuzzingHeuristic<String> implements StringOperator {

	private static final long serialVersionUID = -913348243610129815L;
	List<String> validValues = new ArrayList<>();
	
	public DelimiterOperator(List<String> validValues, StringSpecification stringSpec, long seed) {
		super(seed);
		if (validValues == null) {
			throw new IllegalArgumentException("validValues must not be null");
		}
		initHeuristics(stringSpec, validValues);
	}

	public DelimiterOperator(List<String> validValues, StringSpecification stringSpec, long seed, FuzzingHeuristic<?> owner) {
		super(seed);
		if (validValues == null) {
			throw new IllegalArgumentException("validValues must not be null");
		}
		initHeuristics(stringSpec, validValues);
	}
	
	private void initHeuristics(StringSpecification stringSpec, List<String> validValues) {
		this.validValues.addAll(validValues);
		for (String validValue : validValues) {
			SimpleDelimiterOperator stringRepetitionOperator = new SimpleDelimiterOperator(validValue, stringSpec, seed, owner);
			heuristics.add(stringRepetitionOperator);
		}
	}


	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		boolean validType = stringSpec.getType() == StringType.DELIMITER;
		
		return validType;
	}

	@Override
	public List<String> getValidValues() {
		return validValues;
	}

	@Override
	public String getName() {
		return "Delimiter";
	}

}
