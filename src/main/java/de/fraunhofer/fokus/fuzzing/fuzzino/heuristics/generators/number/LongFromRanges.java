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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.NoMatchingValuesException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComposedFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.NumberGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.LongFromRangesBuilder;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.LongRange;

/**
 * This class returns all numbers from several ranges that aren't connected.
 * For this purpose the class {@link AscendingLongList} is used. 
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 */
public class LongFromRanges extends ComposedFuzzingHeuristic<Long> implements NumberGenerator<Long> {

	private static final long serialVersionUID = 5755165007328149946L;
	protected IntegerSpecification numberSpec;

	public static class Builder extends LongFromRangesBuilder {

		public Builder(long start, long end) {
			super(start, end);
		}
		
		public Builder(LongRange range) {
			super(range);
		}
	}
	
	public LongFromRanges(IntegerSpecification numberSpec, ComputableFuzzingHeuristic<?> owner, long seed, LongFromRangesBuilder builder) {
		super(seed, owner);
		this.numberSpec = numberSpec;
		for (LongRange range : builder.allRanges()) {
			AscendingLongList intList;
			try {
				intList = new AscendingLongList(numberSpec, owner, seed, new AscendingLongList.Builder(range.start(), range.size()));
				heuristics.add(intList);
			} catch (NoMatchingValuesException e) {
			}
		}
	}
	
	@Override
	public String getName() {
		return "LongFromRanges";
	}

	@Override
	public boolean canCreateValuesFor(IntegerSpecification numberSpec) {
		return true;
	}
	
}
