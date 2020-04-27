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

import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.NoMatchingValuesException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComposedFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.NumberGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.IntegerFromRangesBuilder;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.Range;

/**
 * This class returns all numbers from several ranges that aren't connected.
 * For this purpose the class {@link AscendingIntegerList} is used. 
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 */
public class IntegerFromRanges extends ComposedFuzzingHeuristic<Integer> implements NumberGenerator<Integer> {

	private static final long serialVersionUID = 6647804440422006646L;
	protected IntegerSpecification numberSpec;

	public static class Builder extends IntegerFromRangesBuilder {

		public Builder(int start, int end) {
			super(start, end);
		}
		
		public Builder(Range range) {
			super(range);
		}
	}
	
	public IntegerFromRanges(IntegerSpecification numberSpec, List<FuzzingHeuristic> owners, long seed, IntegerFromRangesBuilder builder) {
		super(seed, owners);
		this.owners.add(this);
		if (numberSpec == null) {
			this.numberSpec = RequestFactory.INSTANCE.createNumberSpecification();
		}
		else {
			this.numberSpec = numberSpec;
		}
		for (Range range : builder.allRanges()) {
			try {
				AscendingIntegerList.Builder localBuilder = new AscendingIntegerList.Builder(range.start(), range.size());			
				AscendingIntegerList intList = new AscendingIntegerList(numberSpec, owners, seed, localBuilder);
				heuristics.add(intList);
			} catch (NoMatchingValuesException e) {
				// don't add heuristic if it has no matching values
			}
		}
	}

	@Override
	public String getName() {
		return "IntegerFromRanges";
	}

	@Override
	public boolean canCreateValuesFor(IntegerSpecification numberSpec) {
		return true;
	}

	@Override
	public long getSeed() {
		return seed;
	}
	
}
