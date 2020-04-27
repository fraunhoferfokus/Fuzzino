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
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.BadStrings;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

/**
 * Bad strings are for instance strings with a special meaning for specific
 * operating systems, e.g. "COM1:", and many other special purpose strings. They
 * are taken from Peach.
 */
public class BadStringsGenerator extends SimpleStringGenerator {

	private static final long serialVersionUID = 6147412563759585722L;
	protected static BadStrings badStrings = BadStrings.INSTANCE;

	public BadStringsGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
		this.owners.add(this);
	}

	public BadStringsGenerator(StringSpecification stringSpec, long seed, List<FuzzingHeuristic> owners) {
		super(stringSpec, seed, owners);
		this.owners.add(this);
	}

	@Override
	public String getName() {
		return "BadStrings";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpecification) {
		return true;
	}

	@Override
	public List<String> getFuzzValues() {
		return badStrings.getValues();
	}

	@Override
	public List<Integer> getFuzzValueLengths() {
		return badStrings.getLengths();
	}

}