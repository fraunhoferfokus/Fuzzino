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
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.StringContainer;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.XSSBasicInputStrings;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

public class XSSBasicInputGenerator extends ComposedStringGenerator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6965310336502008538L;
	protected StringContainer xssBasicInputStrings;

	public XSSBasicInputGenerator(StringSpecification stringSpec, long seed, String attackerURL) {
		super(stringSpec, seed);
		this.owners.add(this);
		xssBasicInputStrings = new XSSBasicInputStrings(attackerURL);
		initHeuristics();
	}
	
	public XSSBasicInputGenerator(StringSpecification stringSpec, long seed, List<FuzzingHeuristic> owners, String attackerURL) {
		super(stringSpec, seed, owners);
		this.owners.add(this);
		xssBasicInputStrings = new XSSBasicInputStrings(attackerURL);
		initHeuristics();
	}

	private void initHeuristics() {
		ConcreteValuesGenerator gen1 = new ConcreteValuesGenerator(stringSpec, seed, owners);
		gen1.addAll(xssBasicInputStrings.getValues());
		heuristics.add(gen1);
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		return stringSpec.getType() == StringType.XSS;
	}

	@Override
	public String getName() {
		return "XSSBasicInput";
	}

}
