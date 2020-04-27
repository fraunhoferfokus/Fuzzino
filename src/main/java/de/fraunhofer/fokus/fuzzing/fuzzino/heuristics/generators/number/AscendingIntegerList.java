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

import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.NoMatchingValuesException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableListImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.NumberGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;

/**
 * * Computes a list of ascending numbers of the type BigInteger.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public class AscendingIntegerList extends ComputableListImpl<FuzzedValue<Integer>> implements NumberGenerator<Integer> {

	private static final long serialVersionUID = -8675236820178092587L;
	protected IntegerSpecification numberSpec;
	protected long seed;
	protected List<FuzzingHeuristic> owners;
	/**
	 * The first integer.
	 */
	private int startInt;
	/**
	 * The number of elements to be computed.
	 */
	private int size;
	/**
	 * The step size between elements that is the number of omitted integers + 1. Optional, default is 1.
	 */
	private int stepSize;
	
	/**
	 * Builder for {@link AscendingIntegerList}, allows custom ascending integer lists.
	 * 
	 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
	 *
	 */
	public static class Builder {
		protected int startInt;
		protected int size;
		protected int stepSize = 1;
		
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
		
		@Override
		public String toString() {
			return "[AscendingIntegerList.Builder startInt:" + startInt + " stepSize: " + stepSize + " size:" + size + "]";
		}
	}
	
	/**
	 * Constructs an AscendingIntegerList.
	 * 
	 * @param builder the builder holding the parameters for the AscendingIntegerList to be constructed.
	 * @throws NoMatchingValuesException 
	 */
	public AscendingIntegerList(IntegerSpecification numberSpec, List<FuzzingHeuristic> owner, long seed, Builder builder) throws NoMatchingValuesException {
		if (numberSpec == null) {
			this.numberSpec = RequestFactory.INSTANCE.createNumberSpecification();
		}
		else {
			this.numberSpec = numberSpec;
		}
		this.owners = new LinkedList<FuzzingHeuristic>(owner);
		this.owners.add(this);
		this.seed = seed;
		Builder matchingBuilder = makeBuilderMatchingSpecification(builder);
		startInt = matchingBuilder.startInt;
		size = matchingBuilder.size;
		stepSize = matchingBuilder.stepSize;
	}
	
	protected Builder makeBuilderMatchingSpecification(Builder builder) throws NoMatchingValuesException {
		if (numberSpec.ignoreMinMaxValues()) {
			return builder;
		}
		
		int matchingStartInt = builder.startInt;
		int matchingSize = builder.size;
		int stepSize = builder.stepSize;
		
		int largestValue = matchingStartInt + stepSize * matchingSize;
		int largestValidValue = (int) Math.min(largestValue, numberSpec.getMax());
		
		if (matchingStartInt < numberSpec.getMin()) {
			long minValue = numberSpec.getMin();
			double diff = minValue - matchingStartInt;
			matchingStartInt += Math.ceil(diff/stepSize) * stepSize;
			
			if (matchingStartInt > largestValidValue) {
				throw new NoMatchingValuesException();
			}
			
			largestValue = matchingStartInt + stepSize * matchingSize;
		}
		
		if (largestValue > largestValidValue) {
			double diff = largestValue - largestValidValue;
			matchingSize -= Math.ceil(diff/stepSize);
		}
		
		if (matchingSize <= 0) {
			throw new NoMatchingValuesException();
		}
		
		return new Builder(matchingStartInt, matchingSize).stepSize(stepSize);
	}

	@Override
	public FuzzedValue<Integer> get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		return computeElement(index);
	}
	
	@Override
	public FuzzedValue<Integer> computeElement(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		int nextElement = startInt + index * stepSize;
		
		Integer fuzzedValueItself = nextElement;
		FuzzedValue<Integer> fuzzedValue = new FuzzedValue<>(fuzzedValueItself, owners);
		
		return fuzzedValue;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean canCreateValuesFor(IntegerSpecification numberSpec) {
		return true;
	}

	@Override
	public String getName() {
		return "AscendingIntegerList";
	}

	@Override
	public long getSeed() {
		return seed;
	}

}
