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
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringType;

public class BadIpAddressesGenerator extends ComposedStringGenerator {

	private static final long serialVersionUID = -4963585339268120873L;

	public BadIpAddressesGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
		initHeuristics();
	}

	public BadIpAddressesGenerator(StringSpecification stringSpec, long seed, ComputableFuzzingHeuristic<?> owner) {
		super(stringSpec, seed, owner);
		initHeuristics();
	}
	
	private void initHeuristics() {
		SpecialBadIpAddressesGenerator specialBadIpAddressesGenerator = new SpecialBadIpAddressesGenerator(stringSpec, seed, owner);
		
		BadNumbersAsStringGenerator badNumbers = new BadNumbersAsStringGenerator(stringSpec, seed, owner);
		ConcreteValuesGenerator dot = new ConcreteValuesGenerator(stringSpec, seed, owner, ".");
		Combinator badIpAddress = new Combinator(stringSpec, seed, owner, badNumbers, dot, badNumbers, dot, badNumbers, dot, badNumbers);
		
		heuristics.add(specialBadIpAddressesGenerator);
		heuristics.add(badIpAddress);
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		boolean validType = stringSpec.getType() == StringType.IP_ADDRESS;
		
		return validType;
	}

	@Override
	public String getName() {
		return "BadIpAddresses";
	}

}