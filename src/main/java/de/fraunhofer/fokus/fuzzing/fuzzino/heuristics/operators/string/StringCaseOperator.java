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
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.SimpleFuzzingOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.StringOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

/**
 * This class applies the {@link SimpleStringCaseOperator} to a list of valid values.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 */
public class StringCaseOperator extends ComposedFuzzingHeuristic<String> implements StringOperator {
	
	private static final long serialVersionUID = 8344258191871805712L;

	public StringCaseOperator(List<String> validValues, StringSpecification stringSpec, long seed) {
		super(seed);
		this.owners.add(this);
		if (validValues == null) {
			throw new IllegalArgumentException("validValues must not be null");
		}
		initHeuristics(stringSpec, validValues);
	}

	public StringCaseOperator(List<String> listOfValidValues, StringSpecification stringSpec, long seed , List<FuzzingHeuristic> owners) {
		super(seed, owners);
		this.owners.add(this);
		if (listOfValidValues == null) {
			throw new IllegalArgumentException("validValues must not be null");
		}
		initHeuristics(stringSpec, listOfValidValues);
	}
	
	private void initHeuristics(StringSpecification stringSpec, List<String> validValues) {
		if (stringSpec == null) {
			stringSpec = RequestFactory.INSTANCE.createStringSpecification();
		}
		for (String validValue : validValues) {
			SimpleStringCaseOperator stringCaseOperator = new SimpleStringCaseOperator(validValue, stringSpec, seed, owners);
			heuristics.add(stringCaseOperator);
		}
	}

	@Override
	public String getName() {
		return "StringCase";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification spec) {
		boolean properType = spec.getType() == StringType.STRING || 
				             spec.getType() == StringType.SQL;
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
