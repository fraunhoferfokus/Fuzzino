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

import java.util.ArrayList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class SimpleDelimiterOperator extends SimpleStringOperator {

	private static final long serialVersionUID = 2663297152869256604L;
	protected static final List<Integer> repetitions = new ArrayList<>();
	static {
		repetitions.add(2);
		repetitions.add(5);
		repetitions.add(10);
		repetitions.add(25);
		repetitions.add(100);
		repetitions.add(500);
		repetitions.add(1000);
	}

	public SimpleDelimiterOperator(String validValue, StringSpecification stringSpec, long seed) {
		super(validValue, stringSpec, seed);
	}

	public SimpleDelimiterOperator(String validValue, StringSpecification stringSpec, long seed, ComputableFuzzingHeuristic<?> owner) {
		super(validValue, stringSpec, seed, owner);
	}

	@Override
	public String getName() {
		return "SimpleDelimiterOperator";
	}

	@Override
	public FuzzedValue<String> computeElement(int index) {
		String fuzzedValueItself = StringUtil.repeat(inputValue, repetitions.get(index));
		FuzzedValue<String> fuzzedValue = new FuzzedValue<>(fuzzedValueItself, inputValue, owner);
		return fuzzedValue;
	}

	@Override
	public int size() {
		return repetitions.size();
	}

}
