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
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

public class SimpleStringCaseOperator extends SimpleStringOperator {
	
	private static final long serialVersionUID = 5977352812332500843L;

	public SimpleStringCaseOperator(String validValue, StringSpecification stringSpec, long seed) {
		super(validValue, stringSpec, seed);
	}

	public SimpleStringCaseOperator(String validValue, StringSpecification stringSpec, long seed, ComputableFuzzingHeuristic<?> owner) {
		super(validValue, stringSpec, seed, owner);
	}

	@Override
	public FuzzedValue<String> computeElement(int index) {
		if (index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		String fuzzedValueItself = null;
		
		switch (index) {
		case 0:
			fuzzedValueItself = toUpperCase();
			break;
		case 1:
			fuzzedValueItself = toLowerCase();
			break;
		case 2:
			fuzzedValueItself = toRandomCase();
			break;
		}
		
		FuzzedValue<String> fuzzedValue = new FuzzedValue<>(fuzzedValueItself, inputValue, owner);
		return fuzzedValue;
	}

	@Override
	public int size() {
		return 3;
	}
	
	private String toUpperCase() {
		return inputValue.toUpperCase();
	}
	
	private String toLowerCase() {
		return inputValue.toLowerCase();
	}
	
	private String toRandomCase() {
		String fuzzedValue = inputValue;
		List<Integer> indices = generateIndices(0, inputValue.length(), Math.min(inputValue.length(), 20));
		for (Integer index : indices) {
			char ch = randomLowerOrUpperCase(inputValue.charAt(index));
			fuzzedValue = fuzzedValue.substring(0, index) + ch + fuzzedValue.substring(index + 1, fuzzedValue.length());
		}
		return fuzzedValue;
	}

	private char randomLowerOrUpperCase(char ch) {
		if (random.nextBoolean()) {
			return Character.toLowerCase(ch);
		} else {
			return Character.toUpperCase(ch);
		}
	}
	
	private List<Integer> generateIndices(int minIndex, int maxIndex, int sampleSize) {
		if (sampleSize > Math.abs(maxIndex - minIndex) || minIndex > maxIndex) {
			throw new IllegalArgumentException();
		}
		List<Integer> sample = new ArrayList<>(sampleSize);
		
		while (sample.size() < sampleSize) {
			int generatedIndex = random.nextInt(maxIndex-minIndex) + minIndex;
			if (!listContains(sample, generatedIndex)) {
				sample.add(generatedIndex);
			}
		}
		
		return new ArrayList<>(sample);
	}

	private boolean listContains(List<Integer> list, Integer c) {
		for (Integer number : list) {
			if (number.compareTo(c) == 0) return true;
		}
		return false;
	}

	@Override
	public String getName() {
		return "SimpleStringCaseOperator";
	}

}
