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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string.DelimiterOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string.StringCaseOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string.StringRepetitionOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

public class StringOperatorFactory {

	public static final StringOperatorFactory INSTANCE = new StringOperatorFactory();
	
	/**
	 * Private constructor, because it's a singleton.
	 */
	private StringOperatorFactory() {
	}
	
	public StringOperator create(String name, 
			                     List<String> validValues,
			                     String param,
			                     StringSpecification stringSpec, 
			                     long seed) throws UnknownFuzzingHeuristicException {
		String canonicalName = name.trim().toUpperCase();
		if (canonicalName.equals("Delimiter".toUpperCase())) {
			return createDelimiterOperator(validValues, stringSpec, seed);
		}
		if (canonicalName.equals("StringCase".toUpperCase())) {
			return createStringCaseOperator(validValues, stringSpec, seed);
		} else
		if (canonicalName.equals("StringRepetition".toUpperCase())) {
			return createStringRepetitionOperator(validValues, stringSpec, seed);
		} else {
			throw new UnknownFuzzingHeuristicException(name);
		}
	}
	
	/**
	 * Returns all String generators that are applicable to a given specification.
	 * @param spec the specification of a String the generators must be applicable to.
	 * 
	 * @return all String generators that are applicable to <code>spec</spec>
	 */
	public List<StringOperator> createAll(List<String> validValues, StringSpecification stringSpec, long seed) {
		List<StringOperator> allStringOperators = new ArrayList<>();
		allStringOperators.add(createDelimiterOperator(validValues, stringSpec, seed));
		allStringOperators.add(createStringCaseOperator(validValues, stringSpec, seed));
		allStringOperators.add(createStringRepetitionOperator(validValues, stringSpec, seed));
		
		List<StringOperator> applicableOperators = new LinkedList<>();
		for (StringOperator stringOperator : allStringOperators) {
			if (stringOperator.canCreateValuesFor(stringSpec)) {
				applicableOperators.add(stringOperator);
			}
		}
		
		return applicableOperators;
	}
	
	public DelimiterOperator createDelimiterOperator(List<String> validValues, StringSpecification stringSpec, long seed) {
		return new DelimiterOperator(validValues, stringSpec, seed);
	}
	
	public StringCaseOperator createStringCaseOperator(List<String> validValues, StringSpecification stringSpec, long seed) {
		return new StringCaseOperator(validValues, stringSpec, seed);
	}
	
	public StringRepetitionOperator createStringRepetitionOperator(List<String> validValues, StringSpecification stringSpec, long seed) {
		return new StringRepetitionOperator(validValues, stringSpec, seed);
	}

}
