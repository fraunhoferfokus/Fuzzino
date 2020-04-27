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
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

/**
 * Bad paths are created by combine different special purpose strings for
 * filesystems, e.g. "." and ".." and combines them with directory separators
 * from different operating systems, for instance "/" (from Linux), "\" (from
 * Windows) and ":" (from MacOS). They are taken from Peach.
 */
public class BadPathsGenerator extends ComposedStringGenerator {

	private static final long serialVersionUID = 7934181535264715351L;

	public BadPathsGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
		this.owners.add(this);
		initHeuristics();
	}

	public BadPathsGenerator(List<FuzzingHeuristic> owners, long seed, StringSpecification stringSpec) {
		super(stringSpec, seed, owners);
		this.owners.add(this);
		initHeuristics();
	}

	private void initHeuristics() {
		List<String> simpleRepeaterValues = StringUtil.asList(".", "\\", "/", ":", "../", "..\\");
		for (String str : simpleRepeaterValues) {
			StringRepeater.Builder builder = new StringRepeater.Builder().string(str).startIndex(1);
			StringRepeater strRepeater = new StringRepeater(stringSpec, owners, seed, builder);
			heuristics.add(strRepeater);
		}

		List<String> specialRepeatedValues = StringUtil.asList("*\\", "*/", "//\\", "//..\\..", "aaa//", "aaa\\");
		for (String str : specialRepeatedValues) {
			StringRepeater.Builder builder = new StringRepeater.Builder().string(str).size(100).stepSize(10)
					.startIndex(1);
			StringRepeater strRepeater = new StringRepeater(stringSpec, owners, seed, builder);
			heuristics.add(strRepeater);
		}

		AllBadStringsGenerator badStrings = new AllBadStringsGenerator(owners, seed, stringSpec);
		ConcreteValuesGenerator colonBackslash = new ConcreteValuesGenerator(stringSpec, seed, owners, ":\\");

		Combinator badColonBackslash = new Combinator(stringSpec, seed, owners, badStrings, colonBackslash);
		heuristics.add(badColonBackslash);

		ConcreteValuesGenerator colonSlash = new ConcreteValuesGenerator(stringSpec, seed, owners, ":/");
		Combinator badColonSlash = new Combinator(stringSpec, seed, owners, badStrings, colonSlash);
		heuristics.add(badColonSlash);

		ConcreteValuesGenerator backslashBackslash = new ConcreteValuesGenerator(stringSpec, seed, owners, "\\\\");
		Combinator backslashBackslashBad = new Combinator(stringSpec, seed, owners, backslashBackslash, badStrings);
		heuristics.add(backslashBackslashBad);

		ConcreteValuesGenerator dotSlash = new ConcreteValuesGenerator(stringSpec, seed, owners, "./");
		Combinator dotSlashBad = new Combinator(stringSpec, seed, owners, dotSlash, badStrings);
		heuristics.add(dotSlashBad);

		ConcreteValuesGenerator slash = new ConcreteValuesGenerator(stringSpec, seed, owners, "/");
		Combinator slashBadSlash = new Combinator(stringSpec, seed, owners, slash, badStrings, slash);
		heuristics.add(slashBadSlash);
	}

	@Override
	public String getName() {
		return "BadPaths";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification spec) {
		boolean properType = spec.getType() == StringType.FILENAME || spec.getType() == StringType.PATH;
		return properType;
	}

}
