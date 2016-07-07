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
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringEncoding;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringType;

public class BadUnicodeUtf8StringsGenerator extends ComposedStringGenerator {
	
	private static final long serialVersionUID = 1630014597804770527L;

	public BadUnicodeUtf8StringsGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
		initHeuristics();
	}
	
	public BadUnicodeUtf8StringsGenerator(ComputableFuzzingHeuristic<?> owner, long seed, StringSpecification stringSpec) {
		super(stringSpec, seed, owner);
		initHeuristics();
	}
	
	private void initHeuristics() {
		StringRepeater stringRepeater = new StringRepeater(stringSpec, owner, seed, new StringRepeater.Builder().string("\\x00;ef\\x00;83\\x00;b0")
				                                                                       .offset(2)
				                                                                       .stepSize(2)
				                                                                       .size(512));
		heuristics.add(stringRepeater);
		heuristics.add(new SpecialBadUtf8StringsGenerator(owner, seed, stringSpec));		
	}

	@Override
	public String getName() {
		return "BadUnicodeUtf8Strings";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification spec) {
		boolean properType = spec.getType() == StringType.STRING;
		boolean properEncoding = spec.getEncoding() == StringEncoding.UTF8;
		return properType && properEncoding;
	}

}
