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

import java.math.BigInteger;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.NoMatchingValuesException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComposedFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.NumberGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.BigIntFromRangesBuilder;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.BigIntRange;

/**
 * This class returns all numbers from several ranges that aren't connected.
 * For this purpose the class {@link AscendingBigIntList} is used.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 */
public class BigIntFromRanges extends ComposedFuzzingHeuristic<BigInteger> implements NumberGenerator<BigInteger> {
	
	private static final long serialVersionUID = -8447711782470137056L;
	protected IntegerSpecification numberSpec;

	public static class Builder extends BigIntFromRangesBuilder {

		public Builder(BigInteger start, BigInteger end) {
			super(start, end);
		}
		
		public Builder(BigIntRange range) {
			super(range);
		}
	}
	
	public BigIntFromRanges(IntegerSpecification numberSpec, ComputableFuzzingHeuristic<?> owner, long seed, BigIntFromRangesBuilder builder) {
		super(seed, owner);
		this.numberSpec = numberSpec;
		for (BigIntRange range : builder.allRanges()) {
			try {
				AscendingBigIntList intList = new AscendingBigIntList(numberSpec, owner, seed, new AscendingBigIntList.Builder(range.start(), range.size()));
				heuristics.add(intList);
			} catch (NoMatchingValuesException e) {
				// don't add the heuristic
			}
		}
	}
	
	@Override
	public String getName() {
		return "BigIntFromRanges";
	}

	@Override
	public boolean canCreateValuesFor(IntegerSpecification numberSpec) {
		return true;
	}
}
