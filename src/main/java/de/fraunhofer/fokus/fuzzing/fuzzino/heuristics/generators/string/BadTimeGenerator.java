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

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGeneratorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

public class BadTimeGenerator extends ComposedStringGenerator {

	private static final long serialVersionUID = -1977467047419460480L;

	public BadTimeGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
		initHeuristics();
	}

	public BadTimeGenerator(StringSpecification stringSpec, long seed, ComputableFuzzingHeuristic<?> owner) {
		super(stringSpec, seed, owner);
		initHeuristics();
	}
	
	private void initHeuristics() {
		ConcreteValuesGenerator str08 = new ConcreteValuesGenerator(stringSpec, seed, owner, "08");
		BadStringsGenerator badString = StringGeneratorFactory.INSTANCE.createBadStringsGenerator(stringSpec, seed);
		BadNumbersAsStringGenerator badNumbers = StringGeneratorFactory.INSTANCE.createBadNumbersAsStringGenerator(stringSpec, seed);
		ConcreteValuesGenerator strColon01Colon01 = new ConcreteValuesGenerator(stringSpec, seed, owner, ":01:01");
		ConcreteValuesGenerator strColon01 = new ConcreteValuesGenerator(stringSpec, seed, owner, ":01");
		
		Combinator str08BadStringBadNumbers08Colon01Colon01 = 
				new Combinator(stringSpec, seed, owner, str08, badString, badNumbers, str08, strColon01Colon01);
		
		Combinator str08BadStringBadNumbers08Colon01 = 
				new Combinator(stringSpec, seed, owner, str08, badString, badNumbers, str08, strColon01);
		
		Combinator str08BadStringBadNumbers08 = 
				new Combinator(stringSpec, seed, owner, str08, badString, badNumbers, str08);
	
		heuristics.add(str08BadStringBadNumbers08Colon01Colon01);
		heuristics.add(str08BadStringBadNumbers08Colon01);
		heuristics.add(str08BadStringBadNumbers08);
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		boolean validType = stringSpec.getType() == StringType.TIME;
		
		return validType;
	}

	@Override
	public String getName() {
		return "BadTime";
	}
	
}
