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


import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

/**
 * This generator just creates simple long strings, e.g. 10,240 "A"s. 
 */
public class LongStringsGenerator extends ComposedStringGenerator {
	
	private static final long serialVersionUID = -6590352070931853912L;

	public LongStringsGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
		initHeuristics();
	}
	
	public LongStringsGenerator(ComputableFuzzingHeuristic<?> owner, long seed, StringSpecification stringSpec) {
		super(stringSpec, seed, owner);
		initHeuristics();
	}
	
	@Override
	public boolean matchesSpecification(FuzzedValue<String> value) {
		return true;
	}
	
	private void initHeuristics() {
		StringRepeater repeaterOf10_A_ = new StringRepeater(stringSpec, owner, seed, new StringRepeater.Builder().string(StringUtil.repeat("A", 10))
				                                                                        .size(200)
				                                                                        .startIndex(1));

		StringRepeater repeaterOf127_A_ = new StringRepeater(stringSpec, owner, seed, new StringRepeater.Builder().string(StringUtil.repeat("A", 127))
                                                                                         .size(100)
                                                                                         .startIndex(1));

		StringRepeater repeaterOf1024_A_ = new StringRepeater(stringSpec, owner, seed, new StringRepeater.Builder().string(StringUtil.repeat("A", 1024))
                                                                                          .size(10)
                                                                                          .startIndex(1));
		
		heuristics.add(repeaterOf10_A_);
		heuristics.add(repeaterOf127_A_);
		heuristics.add(repeaterOf1024_A_);
		
		heuristics.add(new LongStrings2Generator(owner, seed, stringSpec));
	}

	@Override
	public String getName() {
		return "LongStrings";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification spec) {
		return true;
	}

}
