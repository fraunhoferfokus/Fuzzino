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

import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.SimpleFuzzingGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringEncoder;

public abstract class SimpleStringGenerator extends SimpleFuzzingGenerator<String> implements StringGenerator {
	
	private static final long serialVersionUID = 2878812254102277733L;
	protected StringSpecification stringSpec;
	
	public SimpleStringGenerator(StringSpecification stringSpec, long seed) {
		super(seed);
		this.owners.add(this);
		if (stringSpec == null) {
			this.stringSpec = RequestFactory.INSTANCE.createStringSpecification();
		}
		else {
			this.stringSpec = stringSpec;
		}
		findMatchingValues();
	}
	
	public SimpleStringGenerator(StringSpecification stringSpec, long seed, List<FuzzingHeuristic> owners) {
		super(seed, owners);
		this.owners.add(this);
		if (stringSpec == null) {
			this.stringSpec = RequestFactory.INSTANCE.createStringSpecification();
		}
		else {
			this.stringSpec = stringSpec;
		}
		findMatchingValues();
	}
	
	protected void findMatchingValues() {
		matchingValues.clear();
		List<Integer> lengths = getFuzzValueLengths();
		if (lengths == null) {
			return;
		}
		for (int i=0; i<lengths.size(); i++) {
			if (matchesLength(lengths.get(i))) {
				matchingValues.add(i);
			}
		}
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
	
	@Override
	public int size() {
		return matchingValues.size();
	}
	
	@Override
	public abstract List<String> getFuzzValues();
	public abstract List<Integer> getFuzzValueLengths();

}
