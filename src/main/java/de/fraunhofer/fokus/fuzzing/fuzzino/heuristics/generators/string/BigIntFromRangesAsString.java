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

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableListImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.BigIntFromRanges;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.BigIntFromRangesBuilder;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.BigIntRange;

/**
 * A class that returns all elements of an {@link BigIntFromRanges} as a String.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 */
public class BigIntFromRangesAsString extends ComputableListImpl<FuzzedValue<String>> implements StringGenerator {

	private static final long serialVersionUID = 3185452668513139695L;
	protected StringSpecification stringSpec;
	protected List<FuzzingHeuristic> owners;
	protected long seed;
	private BigIntFromRanges bigIntFromRanges;
	
	public static class Builder extends BigIntFromRangesBuilder{

		public Builder(BigInteger start, BigInteger end) {
			super(start, end);
		}
		
		public Builder(BigIntRange range) {
			super(range);
		}
	}
	
	public BigIntFromRangesAsString(StringSpecification stringSpec, long seed, BigIntFromRangesBuilder builder) {
		if (stringSpec == null) {
			this.stringSpec = RequestFactory.INSTANCE.createStringSpecification();
		}
		else {
			this.stringSpec = stringSpec;
		}

		owners = new LinkedList<FuzzingHeuristic>();
		owners.add(this);
		this.seed = seed;
		
		initHeuristics(builder);
	}

	public BigIntFromRangesAsString(StringSpecification stringSpec, List<FuzzingHeuristic> owners, long seed, BigIntFromRangesBuilder builder) {
		if (stringSpec == null) {
			this.stringSpec = RequestFactory.INSTANCE.createStringSpecification();
		}
		else {
			this.stringSpec = stringSpec;
		}

		this.owners = new LinkedList<>(owners);
		this.owners.add(this);
		this.seed = seed;
		
		initHeuristics(builder);
	}
	
	private void initHeuristics(BigIntFromRangesBuilder builder) {
		IntegerSpecification numberSpec = stringSpec.createNegativeNumberSpec();
		numberSpec.setIgnoreMinMaxValues(true);
		bigIntFromRanges = new BigIntFromRanges(numberSpec, owners, seed, builder);
	}
	
	@Override
	public FuzzedValue<String> computeElement(int index) {
		String fuzzedValueItself = bigIntFromRanges.get(index).getValue().toString();
		FuzzedValue<String> fuzzedValue = new FuzzedValue<>(fuzzedValueItself, owners);
		return fuzzedValue;
	}

	@Override
	public int size() {
		return bigIntFromRanges.size();
	}

	@Override
	public String getName() {
		return "BigIntFromRangesAsString";
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
