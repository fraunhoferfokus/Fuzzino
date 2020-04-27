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

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.BadLongUnicodeStrings;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringEncoding;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

/**
 * This generator creates a list of long Unicode strings that are taken from the
 * fuzzer Peach.
 */
public class BadLongUnicodeStringsGenerator extends SimpleStringGenerator {

	private static final long serialVersionUID = -7960330496907626351L;
	protected static BadLongUnicodeStrings badLongUnicodeStrings = BadLongUnicodeStrings.INSTANCE;

	public BadLongUnicodeStringsGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
		this.owners.add(this);
	}

	public BadLongUnicodeStringsGenerator(List<FuzzingHeuristic> owners, long seed, StringSpecification stringSpec) {
		super(stringSpec, seed, owners);
		this.owners.add(this);
	}

	@Override
	public String getName() {
		return "BadLongUnicodeStrings";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification spec) {
		StringEncoding encoding = spec.getEncoding();
		boolean properEncoding = encoding == StringEncoding.UTF8 || encoding == StringEncoding.UTF16
				|| encoding == StringEncoding.UTF32;
		return properEncoding;
	}

	@Override
	public boolean matchesSpecification(FuzzedValue<String> value) {
		return true;
	}

	@Override
	public List<String> getFuzzValues() {
		return badLongUnicodeStrings.getValues();
	}

	@Override
	public List<Integer> getFuzzValueLengths() {
		return badLongUnicodeStrings.getLengths();
	}

}
