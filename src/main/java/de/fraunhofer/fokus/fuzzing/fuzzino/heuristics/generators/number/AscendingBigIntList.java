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

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.NoMatchingValuesException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableListImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.NumberGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;

/**
 * Computes a list of ascending numbers of the type BigInteger.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public class AscendingBigIntList extends ComputableListImpl<FuzzedValue<BigInteger>> implements NumberGenerator<BigInteger> {

	private static final long serialVersionUID = 2624736600645787331L;
	protected IntegerSpecification numberSpec;
	protected long seed;
	protected ComputableFuzzingHeuristic<?> owner;
	/**
	 * The first integer.
	 */
	private BigInteger startInt;
	/**
	 * The number of elements to be computed.
	 */
	private int size;
	/**
	 * The step size between elements that is the number of omitted integers + 1. Optional, default is 1.
	 */
	private int stepSize;
	
	
	/**
	 * Builder for {@link AscendingLongList}, allows custom ascending integer lists.
	 * 
	 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
	 *
	 */
	public static class Builder {
		protected BigInteger startInt;
		protected int size;
		protected int stepSize = 1;
		
		/**
		 * Determines the mandatory parameters for {@link AscendingIntegerList}.
		 * 
		 * @param startInt the first integer to start computing further values from.
		 * @param size the number of values to be computed.
		 */
		public Builder(BigInteger theStartInt, int theSize) {
			if (theSize <= 0) {
				throw new IllegalArgumentException("size must be greater than 0.");
			}
			startInt = theStartInt;
			size = theSize;
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
			return "[AscendingBigIntList.Builder startInt:" + startInt + " stepSize:" + stepSize + " size:" + size + "]";
		}
	}
	
	/**
	 * Constructs an AscendingIntegerList.
	 * 
	 * @param builder the builder holding the parameters for the AscendingIntegerList to be constructed.
	 * @throws NoMatchingValuesException 
	 */
	public AscendingBigIntList(IntegerSpecification numberSpec, ComputableFuzzingHeuristic<?> owner, long seed, Builder builder) throws NoMatchingValuesException {
		this.numberSpec = numberSpec;
		this.owner = owner;
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
		
		BigInteger matchingStartInt = builder.startInt;
		int matchingSize = builder.size;
		int stepSize = builder.stepSize;
		
		BigInteger bigMinValue = BigInteger.valueOf(numberSpec.getMin());
		BigInteger bigMaxValue = BigInteger.valueOf(numberSpec.getMax());
		
		BigInteger bigStepSize = BigInteger.valueOf(stepSize);
		BigInteger bigMatchingSize = BigInteger.valueOf(matchingSize);

		BigInteger largestValue = matchingStartInt.add(bigStepSize.multiply(bigMatchingSize));
		BigInteger largestValidValue = largestValue.compareTo(bigMaxValue) <= 0 ? largestValue : bigMaxValue;
		
		if (matchingStartInt.compareTo(bigMinValue) < 0) {
			BigInteger diff = bigMinValue.subtract(matchingStartInt);
			
			matchingStartInt = matchingStartInt.add((diff.divide(bigStepSize)
					                                 .add(BigInteger.ONE))
					                                 .multiply(bigStepSize));
			
			if (matchingStartInt.compareTo(largestValidValue) > 0) {
				throw new NoMatchingValuesException();
			}
			
			largestValue = matchingStartInt.add(bigStepSize.multiply(bigMatchingSize));
		}
		
		if (largestValue.compareTo(largestValidValue) > 0) {
			double diff = (double)largestValue.subtract(largestValidValue).intValue();
			matchingSize -= Math.ceil(diff/stepSize);
		}
		
		if (matchingSize <= 0) {
			throw new NoMatchingValuesException();
		}
		
		return new Builder(matchingStartInt, matchingSize).stepSize(stepSize);
	}
	
	@Override
	public FuzzedValue<BigInteger> get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		return computeElement(index);
	}
	
	@Override
	public FuzzedValue<BigInteger> computeElement(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		BigInteger addThis = BigInteger.valueOf(index).multiply(BigInteger.valueOf(stepSize));
		BigInteger nextElement = startInt.add(addThis);
		
		FuzzedValue<BigInteger> fuzzedValue = new FuzzedValue<>(nextElement, owner);
		
		return fuzzedValue;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String getName() {
		return "AscendingBigIntegers";
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
