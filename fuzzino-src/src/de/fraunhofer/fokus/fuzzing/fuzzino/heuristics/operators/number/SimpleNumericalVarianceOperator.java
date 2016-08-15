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

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.SimpleFuzzingOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;

public class SimpleNumericalVarianceOperator<T extends Number> extends SimpleFuzzingOperator<T> {
	
	private static final long serialVersionUID = -2230636085971265105L;
	protected IntegerSpecification numberSpec;
	protected int varianceRange = 10;

	public SimpleNumericalVarianceOperator(T validValue, long seed) {
		super(validValue, seed);
}
	/**
	 * Creates a new instance where this operator is owned by another meaning the heuristic stores
	 * in each {@link FuzzedValue} is owner, not this instance.
	 * @param validValue the valid value used to generate number around.
	 * @param seed the seed needed to support repeatibility.
	 * @param owner the owner of the operator.
	 */
	public SimpleNumericalVarianceOperator(T validValue, 
			                               long seed, 
			                               ComputableFuzzingHeuristic<?> owner) {
		super(validValue, seed, owner);
	}

	public SimpleNumericalVarianceOperator(T validValue, 
                                           int varianceRange,
                                           long seed) {
		super(validValue, seed);
		if (varianceRange != 0) {
			this.varianceRange = Math.abs(varianceRange);
		}
	}
	/**
	 * Creates a new instance with a given range used to generate numbers around the given value,
	 * where the operator is owned by another meaning the heuristic stores
	 * in each {@link FuzzedValue} is owner, not this instance.
	 * @param validValue the valid value used to generate number around.
	 * @param varianceRange the range to generate values around <code>validValue</code>
	 * @param seed the seed needed to support repeatibility.
	 * @param owner the owner of the operator.
	 */
	public SimpleNumericalVarianceOperator(T validValue,
			                               int varianceRange,
			                               IntegerSpecification numberSpec,
			                               long seed,
			                               ComputableFuzzingHeuristic<?> owner) {
		super(validValue, seed, owner);
		if (varianceRange != 0) {
			this.varianceRange = Math.abs(varianceRange);
		}
	}

	@Override
	public String getName() {
		return "NumericalVarianceOperator";
	}

	@Override
	public FuzzedValue<T> computeElement(int index) {
		int offset = index - varianceRange;
		if (index >= varianceRange) {
			offset++; // that is necessary to exculde the valid value itself
		}
		return new FuzzedValue<>(addToValidValue(offset), inputValue, owner);
	}
	
	private T addToValidValue(int value2) {
		if (inputValue instanceof Long) {
			return (T) Long.valueOf(inputValue.longValue() + value2);
		}
		if (inputValue instanceof BigInteger) {
			BigInteger inputValue = (BigInteger)this.inputValue;
			return (T) inputValue.add(BigInteger.valueOf(value2));
		}
		if (inputValue instanceof Double) {
			return (T) Double.valueOf(inputValue.doubleValue() + value2);
		}
		return null;
	}

	@Override
	public int size() {
		return 2*varianceRange;
	}

}
