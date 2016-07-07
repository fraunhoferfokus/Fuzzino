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
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComposedFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringEncoder;

public abstract class ComposedStringGenerator extends ComposedFuzzingHeuristic<String> implements StringGenerator {
	
	private static final long serialVersionUID = 3715317289237992195L;
	protected StringSpecification stringSpec;
	
	public ComposedStringGenerator(StringSpecification stringSpec, long seed) {
		super(seed);
		if (stringSpec == null) {
			throw new IllegalArgumentException("stringSpec must not be null");
		}
		this.stringSpec = stringSpec;
	}
	
	public ComposedStringGenerator(StringSpecification stringSpec, long seed, ComputableFuzzingHeuristic<?> owner) {
		super(seed, owner);
		if (stringSpec == null) {
			throw new IllegalArgumentException("stringSpec must not be null");
		}
		this.stringSpec = stringSpec;
	}

	@Override
	public boolean matchesSpecification(FuzzedValue<String> value) {
		String fuzzedValueItself = value.getValue();
		int length = StringEncoder.length(fuzzedValueItself);
		
		return matchesLength(length);
	}
	
	protected boolean matchesLength(int length) {
		if (stringSpec.ignoreLengths()) {
			return true;
		}
		boolean isLongEnough = length >= stringSpec.getMinLength();
		boolean isShortEnough = length <= stringSpec.getMaxLength(); 
		
		return (isLongEnough && isShortEnough);
	}
	
}
