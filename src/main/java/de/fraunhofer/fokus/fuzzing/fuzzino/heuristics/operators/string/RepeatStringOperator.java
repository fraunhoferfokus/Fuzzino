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
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.SimpleFuzzingOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.StringOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

/**
 * This class applies the {@link RepeatStringOperator} to a list of valid values.
 *
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 */
public class RepeatStringOperator extends ComposedFuzzingHeuristic<String> implements StringOperator {

	private static final long serialVersionUID = 7254440377424293671L;

	public RepeatStringOperator(List<String> validValues, StringSpecification stringSpec, long seed) {
		super(seed);
		if (validValues == null) {
			throw new IllegalArgumentException("validValues must not be null");
		}
		initHeuristics(stringSpec, validValues);
	}

	public RepeatStringOperator(List<String> validValues, StringSpecification stringSpec, long seed, ComputableFuzzingHeuristic<?> owner) {
		super(seed);
		if (validValues == null) {
			throw new IllegalArgumentException("validValues must not be null");
		}
		initHeuristics(stringSpec, validValues);
	}
	
	private void initHeuristics(StringSpecification stringSpec, List<String> validValues) {
		if (stringSpec == null) {
			stringSpec = RequestFactory.INSTANCE.createStringSpecification();
		}
		for (String validValue : validValues) {
			SimpleStringRepetitionOperator stringRepetitionOperator = new SimpleStringRepetitionOperator(validValue, stringSpec, seed, owner);
			heuristics.add(stringRepetitionOperator);
		}
	}

	@Override
	public String getName() {
		return "RepeatString";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification spec) {
		boolean properType = spec.getType() == StringType.STRING;
		return properType;
	}

	@Override
	public List<String> getValidValues() {
		List<String> validValues = new ArrayList<>(heuristics.size()); 
		for (ComputableFuzzingHeuristic<String> fuzzingHeuristic : heuristics) {
			SimpleFuzzingOperator<String> simpleOperator = (SimpleFuzzingOperator<String>)fuzzingHeuristic;
			validValues.add(simpleOperator.getInputValue());
		}
		
		return validValues;
	}

}