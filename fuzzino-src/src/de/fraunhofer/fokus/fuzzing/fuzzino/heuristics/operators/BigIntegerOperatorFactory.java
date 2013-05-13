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

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.number.BigNumericalVarianceOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.NumberSpecification;

public class BigIntegerOperatorFactory {

	public static final BigIntegerOperatorFactory INSTANCE = new BigIntegerOperatorFactory();

	private BigIntegerOperatorFactory() {
	}

	public BigIntegerOperator create(String name, 
			                         List<BigInteger> validValues, 
			                         String param, 
			                         NumberSpecification numberSpec, 
			                         long seed) throws UnknownFuzzingHeuristicException {
		if (name.equals("NumericalVariance")) {
			return createBigNumericalVarianceOperator(validValues, param, numberSpec, seed);
		} else {
			throw new UnknownFuzzingHeuristicException();
		}
	}
	
	public List<BigIntegerOperator> createAll(List<BigInteger> validValues, 
			                               NumberSpecification numberSpec, 
			                               long seed) {
		List<BigIntegerOperator> allIntegerOperators = new LinkedList<>();
		allIntegerOperators.add(createBigNumericalVarianceOperator(validValues, null, numberSpec, seed));

		List<BigIntegerOperator> applicableIntegerOperators = new LinkedList<>();
		for (BigIntegerOperator integerOperator : allIntegerOperators) {
			if (integerOperator.canCreateValuesFor(numberSpec)) {
				applicableIntegerOperators.add(integerOperator);
			}
		}
		
		return applicableIntegerOperators;
	}
	
	public BigNumericalVarianceOperator createBigNumericalVarianceOperator(List<BigInteger> validValues, String param,
			              NumberSpecification numberSpec, long seed) {
		return new BigNumericalVarianceOperator(validValues, param, numberSpec, seed);
	}

}
