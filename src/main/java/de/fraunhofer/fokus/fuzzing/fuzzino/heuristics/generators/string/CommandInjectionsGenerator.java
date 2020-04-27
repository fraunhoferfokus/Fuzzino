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
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.CommandInjections;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

/**
 * This generator creates some strings having the capability to reveal command
 * injection weaknesses. It is taken from Sulley.
 */
public class CommandInjectionsGenerator extends SimpleStringGenerator implements StringGenerator {

	private static final long serialVersionUID = -26300349097703353L;
	protected static CommandInjections commandInjections = CommandInjections.INSTANCE;

	public CommandInjectionsGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
		this.owners.add(this);
	}

	public CommandInjectionsGenerator(List<FuzzingHeuristic> owners, long seed, StringSpecification stringSpec) {
		super(stringSpec, seed, owners);
		this.owners.add(this);
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		boolean properType = stringSpec.getType() == StringType.COMMAND;

		return properType;
	}

	@Override
	public String getName() {
		return "CommandInjections";
	}

	@Override
	public List<String> getFuzzValues() {
		return commandInjections.getValues();
	}

	@Override
	public List<Integer> getFuzzValueLengths() {
		return commandInjections.getLengths();
	}

}
