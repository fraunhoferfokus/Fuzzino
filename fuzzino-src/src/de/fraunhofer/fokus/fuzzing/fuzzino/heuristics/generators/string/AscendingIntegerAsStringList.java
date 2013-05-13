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
import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.NoMatchingValuesException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableListImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.AscendingIntegerList;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringType;

/**
 * A class that returns all elements of an {@link AscendingIntegerList} as a String.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public class AscendingIntegerAsStringList extends ComputableListImpl<FuzzedValue<String>> implements StringGenerator {

	private static final long serialVersionUID = -1618516165078304269L;
	protected StringSpecification stringSpec;
	protected FuzzingHeuristic<?> owner;
	protected long seed;
	private AscendingIntegerList ascIntegerList;

	/**
	 * Builder for {@link AscendingIntegerList}, allows custom ascending integer lists.
	 * 
	 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
	 *
	 */
	public static class Builder {
		private int startInt;
		private int size;
		private int stepSize = 1;
		
		/**
		 * Determines the mandatory parameters for {@link AscendingIntegerList}.
		 * 
		 * @param startInt the first integer to start computing further values from.
		 * @param size the number of values to be computed.
		 */
		public Builder(int startInt, int size) {
			if (size <= 0) {
				throw new IllegalArgumentException("size must be greater than 0.");
			}
			this.startInt = startInt;
			this.size = size;
		}
		
		/**
		 * Determines the difference between each computed integer that is the number of omitted integers + 1.
		 * Optional, default is 1.
		 * 
		 * @param val the difference between each computed integer.
		 * @return this Builder instance.
		 */
		public Builder stepSize(int val) {
			if (val <= 0) {
				throw new IllegalArgumentException("stepSize must be greater than 0.");
			}
			stepSize = val;
			return this;
		}
	}
	
	public AscendingIntegerAsStringList(StringSpecification stringSpec, 
			                            FuzzingHeuristic<?> owner, 
			                            long seed, 
			                            Builder builder) throws NoMatchingValuesException {
		this.stringSpec = stringSpec;
		this.owner = owner;
		this.seed = seed;
		AscendingIntegerList.Builder integerBuilder = 
				new AscendingIntegerList.Builder(builder.startInt, builder.size).stepSize(builder.stepSize);
		
		ascIntegerList = new AscendingIntegerList(stringSpec.createPositiveNumberSpec(), owner, seed, integerBuilder);
	}
	
	@Override
	public FuzzedValue<String> computeElement(int index) {
		String fuzzedValueItself = Integer.toString(ascIntegerList.get(index).getValue());
		FuzzedValue<String> fuzzedValue = new FuzzedValue<>(fuzzedValueItself, owner);
		return fuzzedValue;
	}

	@Override
	public int size() {
		return ascIntegerList.size();
	}

	@Override
	public String getName() {
		return "AscendingIntegerAsString";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpecification) {
		return stringSpecification.getType() == StringType.NUMBER;
	}

	@Override
	public long getSeed() {
		return seed;
	}

}
