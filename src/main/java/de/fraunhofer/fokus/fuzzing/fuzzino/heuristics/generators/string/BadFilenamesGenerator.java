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
 * This generator creates filenames of different lengths and formats, e.g. a
 * long string followed by a "." or a string followed by many repetitions of the
 * file extension ".doc". They are taken from Peach.
 */
public class BadFilenamesGenerator extends ComposedStringGenerator {

	private static final long serialVersionUID = 3849636252243363106L;

	public BadFilenamesGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
		this.owners.add(this);
		initHeuristics();
	}

	public BadFilenamesGenerator(List<FuzzingHeuristic> owners, long seed, StringSpecification stringSpec) {
		super(stringSpec, seed, owners);
		this.owners.add(this);
		initHeuristics();
	}

	private void initHeuristics() {
		AllBadStringsGenerator badStrings = new AllBadStringsGenerator(owners, seed, stringSpec);
		ConcreteValuesGenerator dotGenerator = new ConcreteValuesGenerator(stringSpec, seed, owners, ".");
		heuristics.add(badStrings);

		Combinator badDotBad = new Combinator(stringSpec, seed, owners, badStrings, dotGenerator, badStrings);
		heuristics.add(badDotBad);

		Combinator dotBad = new Combinator(stringSpec, seed, owners, dotGenerator, badStrings);
		heuristics.add(dotBad);

		Combinator badDot = new Combinator(stringSpec, seed, owners, badStrings, dotGenerator);
		heuristics.add(badDot);

		StringRepeater strRepeaterDot = new StringRepeater(stringSpec, owners, seed,
				new StringRepeater.Builder().string(".").startIndex(1));
		heuristics.add(strRepeaterDot);

		StringRepeater strRepeater_a_dot_a = new StringRepeater(stringSpec, owners, seed,
				new StringRepeater.Builder().string("a.a").startIndex(1));
		heuristics.add(strRepeater_a_dot_a);

		StringRepeater strRepeaterAdot_A_ = new StringRepeater(stringSpec, owners, seed,
				new StringRepeater.Builder().prefix("A.").startIndex(1));
		heuristics.add(strRepeaterAdot_A_);

		StringRepeater strRepeater_A_dotA = new StringRepeater(stringSpec, owners, seed,
				new StringRepeater.Builder().suffix(".A").startIndex(1));
		heuristics.add(strRepeater_A_dotA);

		StringRepeater strRepeaterAAAA_dotDoc_ = new StringRepeater(stringSpec, owners, seed,
				new StringRepeater.Builder().string(".doc").prefix("AAAA").startIndex(1));
		heuristics.add(strRepeaterAAAA_dotDoc_);

		StringRepeater strRepeater_AAAAAAAAAA_ = new StringRepeater(stringSpec, owners, seed,
				new StringRepeater.Builder().stepSize(10).startIndex(1).size(100));
		Combinator aDotA = new Combinator(stringSpec, seed, owners, strRepeater_AAAAAAAAAA_, dotGenerator,
				strRepeater_AAAAAAAAAA_);
		heuristics.add(aDotA);
	}

	@Override
	public String getName() {
		return "BadFilenames";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification spec) {
		boolean properType = spec.getType() == StringType.FILENAME || spec.getType() == StringType.PATH;
		return properType;
	}

}
