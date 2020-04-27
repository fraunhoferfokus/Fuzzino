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

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

/**
 * This generator creates IPv4 addresses consisting of bad numbers for each part
 * of an IPv4 address and with illegal combinations of dots and numbers. They
 * are taken from Peach.
 */
public class BadIpAddressesGenerator extends ComposedStringGenerator {

	private static final long serialVersionUID = -4963585339268120873L;

	public BadIpAddressesGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
		this.owners.add(this);
		initHeuristics();
	}

	public BadIpAddressesGenerator(StringSpecification stringSpec, long seed, List<FuzzingHeuristic> owners) {
		super(stringSpec, seed, owners);
		this.owners.add(this);
		initHeuristics();
	}
	
	private void initHeuristics() {
		SpecialBadIpAddressesGenerator specialBadIpAddressesGenerator = new SpecialBadIpAddressesGenerator(stringSpec, seed, owners);
		
		BadNumbersAsStringGenerator badNumbers = new BadNumbersAsStringGenerator(stringSpec, seed, owners);
		ConcreteValuesGenerator dot = new ConcreteValuesGenerator(stringSpec, seed, owners, ".");
		Combinator badIpAddress = new Combinator(stringSpec, seed, owners, badNumbers, dot, badNumbers, dot, badNumbers, dot, badNumbers);
		
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