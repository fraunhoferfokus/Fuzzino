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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number;

import java.math.BigInteger;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.BigIntegerGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.SimpleFuzzingGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.IntegerSpecification;

public abstract class SimpleBigIntegerGenerator extends SimpleFuzzingGenerator<BigInteger> implements BigIntegerGenerator {

	private static final long serialVersionUID = -4161576419721257125L;
	protected IntegerSpecification numberSpec;

	protected SimpleBigIntegerGenerator(IntegerSpecification numberSpec, long seed) {
		super(seed);
		this.numberSpec = numberSpec;
	}

	protected SimpleBigIntegerGenerator(IntegerSpecification numberSpec, long seed, ComputableFuzzingHeuristic<?> owner) {
		super(seed, owner);
		this.numberSpec = numberSpec;
	}
	
	@Override
	public boolean matchesSpecification(FuzzedValue<BigInteger> fuzzedValue) {
		if (numberSpec.ignoreMinMaxValues()) {
			return true;
		}
		BigInteger value = fuzzedValue.getValue();
		
		return value.compareTo(BigInteger.valueOf(numberSpec.getMin())) >= 0 && 
			   value.compareTo(BigInteger.valueOf(numberSpec.getMax())) <= 0;
		
	}

}
