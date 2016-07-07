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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators;

import java.util.Random;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableListImpl;

/**
 * A fuzzing operator that fuzzes a single value.
 * 
 * To implement a SimpleFuzzingOperator the method {@link #getName()}, {@link #computeElement(int)} and {@link #size()}
 * must be implemented.
 * 
 * @author Martin Schneider
 */
public abstract class SimpleFuzzingOperator<T> extends ComputableListImpl<FuzzedValue<T>> 
                                               implements ComputableFuzzingHeuristic<T> {
	
	private static final long serialVersionUID = -1331806699416808551L;
	protected T inputValue;
	protected ComputableFuzzingHeuristic<?> owner;
	protected long seed;
	protected Random random;

	/**
	 * Constructor for subclasses.
	 * 
	 * @param inputValue The input value to be fuzzed.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 */
	protected SimpleFuzzingOperator(T inputValue, long seed) {
		super();
		if (inputValue == null) {
			throw new IllegalArgumentException("inputValue must not be null");
		}
		this.seed = seed;
		this.random = new Random(this.seed);
		this.inputValue = inputValue;
		owner = this;
	}

	/**
	 * Constructor for subclasses.
	 * 
	 * @param inputValue An input value to be fuzzed.
	 * @param seed The seed to be used for random-based fuzzingheuristics.
	 * @param owner The fuzzing heuristic that uses this fuzzing operator for its own purpose.
	 *              fuzzed Value will return {@code owner} instead of {@code this} when calling
	 *              {@link FuzzedValue#getHeuristic()}.
	 */
	protected SimpleFuzzingOperator(T inputValue, long seed, ComputableFuzzingHeuristic<?> owner) {
		super();
		if (inputValue == null) {
			throw new IllegalArgumentException("inputValue must not be null");
		}
		this.seed = seed;
		this.random = new Random(this.seed);
		this.inputValue = inputValue;
		this.owner = owner;
	}
	
	/**
	 * @return all input values to be fuzzed (for strings and numbers, an input value is a valid value,
	 *         for collections andd structures this is not necessarily  the case).
	 */
	public T getInputValue() {
		return inputValue;
	}
	
	@Override
	public long getSeed() {
		return seed;
	}
	
	@Override
	public String toString() {
		return "[SimpleFuzzingOperator name:" + getName() + " owner:" + owner.getName() + " inputValue:" + inputValue + " seed:" + seed + "]";
	}

}
