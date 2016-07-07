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

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.Popular4DigitPins;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringType;

public class Popular4DigitPinsGenerator extends SimpleStringGenerator {
	
	private static final long serialVersionUID = -6472836655948431488L;
	protected static Popular4DigitPins popular4DigitPins = Popular4DigitPins.INSTANCE;

	public Popular4DigitPinsGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
	}

	public Popular4DigitPinsGenerator(StringSpecification stringSpec, long seed, ComputableFuzzingHeuristic<?> owner) {
		super(stringSpec, seed, owner);
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		boolean validType = stringSpec.getType() == StringType.PIN4DIGIT;
		boolean validLength = stringSpec.getMinLength() <= 4 && stringSpec.getMaxLength() >= 4;
		
		return validType && validLength;
	}

	@Override
	public String getName() {
		return "Popular4DigitPins";
	}

	@Override
	public List<String> getFuzzValues() {
		return popular4DigitPins.getValues();
	}

	@Override
	public List<Integer> getFuzzValueLengths() {
		return popular4DigitPins.getLengths();
	}

}
