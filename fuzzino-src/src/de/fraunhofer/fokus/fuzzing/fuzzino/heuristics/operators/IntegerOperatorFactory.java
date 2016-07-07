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

import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.number.NumericalVarianceOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.IntegerSpecification;

/**
 * A factory for all kinds of NumberOperators.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public class IntegerOperatorFactory {

	/**
	 * The singleton instance of the factory.
	 */
	public static final IntegerOperatorFactory INSTANCE = new IntegerOperatorFactory();

	/**
	 * Private constructor because it's a singleton.
	 */
	private IntegerOperatorFactory() {
	}
	
	public IntegerOperator create(String name, List<Long> validValues, String param, IntegerSpecification numberSpec, long seed) throws UnknownFuzzingHeuristicException {
		String canonicalName = name.trim().toUpperCase();
		if (canonicalName.equals("NumericalVariance".toUpperCase())) {
			return createNumericalVarianceOperator(validValues, param, numberSpec, seed);
		} else {
			throw new UnknownFuzzingHeuristicException();
		}
	}
	
	public List<IntegerOperator> createAll(List<Long> validValues, 
			                               IntegerSpecification numberSpec, 
			                               long seed) {
		List<IntegerOperator> allIntegerOperators = new LinkedList<>();
		allIntegerOperators.add(createNumericalVarianceOperator(validValues, null, numberSpec, seed));

		List<IntegerOperator> applicableIntegerOperators = new LinkedList<>();
		for (IntegerOperator integerOperator : allIntegerOperators) {
			if (integerOperator.canCreateValuesFor(numberSpec)) {
				applicableIntegerOperators.add(integerOperator);
			}
		}
		
		return applicableIntegerOperators;
	}
	
	public NumericalVarianceOperator createNumericalVarianceOperator(List<Long> validValues, 
			                                                         String param, 
			                                                         IntegerSpecification numberSpec, 
			                                                         long seed) {
		return new NumericalVarianceOperator(validValues, param, numberSpec, seed);
	}

}
