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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableListImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.IntegerGeneratorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.BoundaryNumbersGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringType;

public class BadNumbersAsStringGenerator extends ComputableListImpl<FuzzedValue<String>> implements StringGenerator {
	
	private static final long serialVersionUID = 5566745227758128426L;
	protected StringSpecification stringSpec;
	protected long seed;
	protected ComputableFuzzingHeuristic<?> owner;
	protected BoundaryNumbersGenerator boundaryNumbersGenerator;

	public BadNumbersAsStringGenerator(StringSpecification stringSpec, long seed) {
		this.stringSpec = stringSpec;
		this.seed = seed;
		owner = this;
		initHeuristic();
	}

	public BadNumbersAsStringGenerator(StringSpecification stringSpec, long seed, ComputableFuzzingHeuristic<?> owner) {
		this.stringSpec = stringSpec;
		this.seed = seed;
		this.owner = owner;
		initHeuristic();
	}
	
	private void initHeuristic() {
		boundaryNumbersGenerator = IntegerGeneratorFactory.INSTANCE.createBoundaryNumbersGenerator
				(stringSpec.createPositiveNumberSpec(), seed);
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		boolean validType = stringSpec.getType() == StringType.NUMBER;
		
		return validType;
	}

	@Override
	public String getName() {
		return "BadNumbersAsString";
	}

	@Override
	public long getSeed() {
		return seed;
	}

	@Override
	public FuzzedValue<String> computeElement(int index) {
		String fuzzedValueItself = boundaryNumbersGenerator.get(index).getValue().toString();
		FuzzedValue<String> fuzzedValue = new FuzzedValue<>(fuzzedValueItself, owner);
		
		return fuzzedValue;
	}

	@Override
	public int size() {
		return boundaryNumbersGenerator.size();
	}

}
