//   Copyright 2020 Fraunhofer FOKUS
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

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.ForeignDigits;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

/**
 * A generator that generates combinations of non-Arabic numerals.
 * 
 * <p>
 * Note: The generated strings may not mean any actual numbers or mix systems.
 * </p>
 * <p>
 * Note: Some of the characters used in the generated strings may function as
 * both numerals and non-numeric characters.
 * </p>
 * 
 * @author Jasper v. Blanckenburg <jasper.von.blanckenburg@fokus.fraunhofer.de>
 */
public class ForeignDigitsGenerator extends SimpleStringGenerator {

	private static final long serialVersionUID = 1099147236269479496L;
	protected static ForeignDigits foreignDigits = ForeignDigits.INSTANCE;

	public ForeignDigitsGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
		this.owners.add(this);
	}
	
	public ForeignDigitsGenerator(StringSpecification stringSpec, long seed, List<FuzzingHeuristic> owners) {
		super(stringSpec, seed, owners);
		this.owners.add(this);
	}

	@Override
	public String getName() {
		return "ForeignDigits";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpecification) {
		return true;
	}

	@Override
	public List<String> getFuzzValues() {
		return foreignDigits.getValues();
	}

	@Override
	public List<Integer> getFuzzValueLengths() {
		return foreignDigits.getLengths();
	}

}