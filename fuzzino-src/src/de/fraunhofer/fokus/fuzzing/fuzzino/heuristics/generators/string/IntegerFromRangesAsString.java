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
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableListImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.IntegerFromRanges;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.IntegerFromRangesBuilder;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.Range;

/**
 * A class that returns all elements of an {@link IntegerFromRanges} as a String.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 */
public class IntegerFromRangesAsString extends ComputableListImpl<FuzzedValue<String>> implements StringGenerator {
	
	private static final long serialVersionUID = 1709289383888439893L;
	protected StringSpecification stringSpec;
	protected FuzzingHeuristic<?> owner;
	protected long seed;
	private IntegerFromRanges intFromRanges;
	
	public static class Builder extends IntegerFromRangesBuilder{

		public Builder(int start, int end) {
			super(start, end);
		}
		
		public Builder(Range range) {
			super(range);
		}
	}
	
	public IntegerFromRangesAsString(StringSpecification stringSpec, long seed, IntegerFromRangesBuilder builder) {
		this.stringSpec = stringSpec;
		owner = this;
		this.seed = seed;
		initHeuristics(builder);
	}

	public IntegerFromRangesAsString(StringSpecification stringSpec, FuzzingHeuristic<?> owner, long seed, IntegerFromRangesBuilder builder) {
		this.stringSpec = stringSpec;
		this.owner = owner;
		this.seed = seed;
		initHeuristics(builder);
	}
	
	private void initHeuristics(IntegerFromRangesBuilder builder) {
		intFromRanges = new IntegerFromRanges(stringSpec.createNegativeNumberSpec(), owner, seed, builder);
	}

	@Override
	public FuzzedValue<String> computeElement(int index) {
		String fuzzedValueItself = intFromRanges.get(index).getValue().toString();
		FuzzedValue<String> fuzzedValue = new FuzzedValue<>(fuzzedValueItself, owner);
		return fuzzedValue;
	}

	@Override
	public int size() {
		return intFromRanges.size();
	}

	@Override
	public String getName() {
		return "IntegerFromRangesAsString";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpecification) {
		return true;
	}

	@Override
	public long getSeed() {
		return seed;
	}

}
