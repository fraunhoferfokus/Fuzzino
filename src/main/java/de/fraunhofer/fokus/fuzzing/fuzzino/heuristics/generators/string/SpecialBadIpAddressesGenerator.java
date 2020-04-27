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
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.SpecialBadIpAddresses;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

public class SpecialBadIpAddressesGenerator extends SimpleStringGenerator {

	private static final long serialVersionUID = -5544865396650771012L;
	protected static SpecialBadIpAddresses specialBadIpAddresses = SpecialBadIpAddresses.INSTANCE;

	public SpecialBadIpAddressesGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
		this.owners.add(this);
	}

	public SpecialBadIpAddressesGenerator(StringSpecification stringSpec, long seed, List<FuzzingHeuristic> owners) {
		super(stringSpec, seed, owners);
		this.owners.add(this);
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		boolean validType = stringSpec.getType() == StringType.IP_ADDRESS;
		
		return validType;
	}

	@Override
	public String getName() {
		return "SpecialBadIpAddresses";
	}

	@Override
	public List<String> getFuzzValues() {
		return specialBadIpAddresses.getValues();
	}

	@Override
	public List<Integer> getFuzzValueLengths() {
		return specialBadIpAddresses.getLengths();
	}

}
