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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.number;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComposedFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.BigIntegerOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.IntegerSpecification;

public class BigNumericalVarianceOperator extends ComposedFuzzingHeuristic<BigInteger> implements BigIntegerOperator {

	private static final long serialVersionUID = -3024782387631734857L;
	protected List<BigInteger> validValues;

	public BigNumericalVarianceOperator(List<BigInteger> validValues, 
			                         String param,
			                         IntegerSpecification numberSpec,
			                         long seed) {
		super(seed);
		if (validValues == null) {
			throw new IllegalArgumentException("validValues must not be null");
		}
		int varianceRange = 10;
		this.validValues = validValues;
		try {
			varianceRange = Integer.parseInt(param);
		} catch (NumberFormatException e) {
			varianceRange = 10;
		}
		for (BigInteger validValue : validValues) {
			SimpleNumericalVarianceOperator<BigInteger> simpleNumericalVarianceOperator = 
					new SimpleNumericalVarianceOperator<>(validValue, varianceRange, numberSpec, seed, owner);
			heuristics.add(simpleNumericalVarianceOperator);
		}
	}
	
	@Override
	public boolean canCreateValuesFor(IntegerSpecification numberSpec) {
		return true;
	}

	@Override
	public List<BigInteger> getValidValues() {
		return Collections.unmodifiableList(validValues);
	}

	@Override
	public String getName() {
		return "NumericalVariance";
	}

}
