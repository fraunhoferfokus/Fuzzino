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

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.IntegerGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.SimpleFuzzingGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;

public abstract class SimpleIntegerGenerator extends SimpleFuzzingGenerator<Long> implements IntegerGenerator {

	private static final long serialVersionUID = 5027532426844708457L;
	protected IntegerSpecification numberSpec;
	
	public SimpleIntegerGenerator(IntegerSpecification numberSpec, long seed) {
		super(seed);
		this.numberSpec = numberSpec;
	}
	
	public SimpleIntegerGenerator(IntegerSpecification numberSpec, long seed, ComputableFuzzingHeuristic<?> owner) {
		super(seed, owner);
		this.numberSpec = numberSpec;
	}
	
	@Override
	public boolean matchesSpecification(FuzzedValue<Long> fuzzedValue) {
		if (numberSpec.ignoreMinMaxValues()) {
			return true;
		}
		long value = fuzzedValue.getValue();
		
		return value >= numberSpec.getMin() && value <= numberSpec.getMax();
	}

}
