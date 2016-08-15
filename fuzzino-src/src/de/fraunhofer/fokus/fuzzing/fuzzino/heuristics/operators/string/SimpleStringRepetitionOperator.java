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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.SimpleFuzzingOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringEncoding;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class SimpleStringRepetitionOperator extends SimpleFuzzingOperator<String> {
	
	private static final long serialVersionUID = -6176477901128150903L;
	StringSpecification stringSpec;
	
	public SimpleStringRepetitionOperator(String validValue, StringSpecification stringSpec, long seed) {
		super(validValue, seed);
		this.stringSpec = stringSpec;
	}
	
	public SimpleStringRepetitionOperator(String validValue, StringSpecification stringSpec, long seed, ComputableFuzzingHeuristic<?> owner) {
		super(validValue, seed, owner);
		this.stringSpec = stringSpec;
	}
	
	@Override
	public FuzzedValue<String> computeElement(int index) {
		if (index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		String fuzzedValueItself = "";
		switch (index) {
		case 0:
			fuzzedValueItself = StringUtil.repeat(inputValue, 2);
			break;
		case 1:
			fuzzedValueItself = StringUtil.repeat(inputValue, 10);
			break;
		case 2:
			fuzzedValueItself = StringUtil.repeat(inputValue, 100);
			break;
		case 3:
			fuzzedValueItself = StringUtil.repeat(inputValue, 2) + "\\xFE";
			break;
		case 4:
			fuzzedValueItself = StringUtil.repeat(inputValue, 10) + "\\xFE";
			break;
		case 5:
			fuzzedValueItself = StringUtil.repeat(inputValue, 100) + "\\xFE";
			break;
		}
		
		return new FuzzedValue<>(fuzzedValueItself, inputValue, owner);
	}
	
	@Override
	public int size() {
		if (stringSpec.getEncoding() == StringEncoding.UTF8) {
			return 6;
		} else {
			return 3;
		}
	}

	@Override
	public String getName() {
		return "SimpleStringRepetitionOperator";
	}
	
}
