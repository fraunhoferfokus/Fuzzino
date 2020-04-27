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

import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableListImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.LongFromRanges;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.LongFromRangesBuilder;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.LongRange;

/**
 * A class that returns all elements of an {@link LongFromRangesAsString} as a String.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 */
public class LongFromRangesAsString extends ComputableListImpl<FuzzedValue<String>> implements StringGenerator {

	private static final long serialVersionUID = -5335433153804940901L;
	protected StringSpecification stringSpec;
	protected List<FuzzingHeuristic> owner;
	protected long seed;
	private LongFromRanges longFromRanges;
	
	public static class Builder extends LongFromRangesBuilder {

		public Builder(long start, long end) {
			super(start, end);
		}
		
		public Builder(LongRange range) {
			super(range);
		}
	}
	
	public LongFromRangesAsString(StringSpecification stringSpec, long seed, LongFromRangesBuilder builder) {
		if (stringSpec == null) {
			this.stringSpec = RequestFactory.INSTANCE.createStringSpecification();
		}
		else {
			this.stringSpec = stringSpec;
		}
		owner = new LinkedList<FuzzingHeuristic>();
		owner.add(this);
		this.seed = seed;
		
		initHeuristics(builder);
	}

	public LongFromRangesAsString(StringSpecification stringSpec, List<FuzzingHeuristic> owners, long seed, LongFromRangesBuilder builder) {
		if (stringSpec == null) {
			this.stringSpec = RequestFactory.INSTANCE.createStringSpecification();
		}
		else {
			this.stringSpec = stringSpec;
		}
		this.owner = new LinkedList<FuzzingHeuristic>(owners);
		this.owner.add(this);
		this.seed = seed;
		
		initHeuristics(builder);
	}
	
	private void initHeuristics(LongFromRangesBuilder builder) {
		longFromRanges = new LongFromRanges(stringSpec.createNegativeNumberSpec(), owner, seed, builder);
	}

	@Override
	public FuzzedValue<String> computeElement(int index) {
		String fuzzedValueItself = longFromRanges.get(index).getValue().toString();
		FuzzedValue<String> fuzzedValue = new FuzzedValue<>(fuzzedValueItself, owner);
		return fuzzedValue;
	}

	@Override
	public int size() {
		return longFromRanges.size();
	}

	@Override
	public String getName() {
		return "LongFromRangesAsString";
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
