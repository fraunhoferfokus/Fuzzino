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
package de.fraunhofer.fokus.fuzzing.fuzzino;

import java.io.Serializable;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;

/**
 * This class contains all information related to a fuzzed value including
 * the fuzzed value itself and how it is generated.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public class FuzzedValue<T> implements Serializable {
	
	private static final long serialVersionUID = 5673943690714774557L;

	protected enum Kind {
		GENERATED,
		MUTATED,
		NONE
	}
	
	protected T value = null;
	protected T basedOnValue = null;
	protected FuzzingHeuristic<?> heuristic = null;
	protected Kind kind;
	
	/**
	 * This variable is used instead of <code>null</code>.
	 */
	@SuppressWarnings("rawtypes")
	public static final FuzzedValue NONE = new FuzzedValue();
	
	/**
	 * Constructs a fuzzed value equal to {@link FuzzedValue#NONE}.
	 */
	public FuzzedValue() {
		kind = Kind.NONE;
	}
	
	/**
	 * Creates a new instance that stores a fuzzed value created by a fuzzing generator.
	 * 
	 * @param fuzzedValue The value created by {@code generator}.
	 * @param generator The fuzzing generator that created {@code fuzzedValue}.
	 */
	public FuzzedValue(T fuzzedValue, FuzzingHeuristic<?> generator) {
		if (generator == null) {
			throw new IllegalArgumentException("generator must not be null.");
		}
		value = fuzzedValue;
		heuristic = generator;
		kind = Kind.GENERATED;
	}
	
	/**
	 * Creates a new instance that stores a fuzzed value created by applying a fuzzing operator to a valid value.
	 * 
	 * @param fuzzedValue The value that is created by applying {@code operator} to {@code basedOnValue}.
	 * @param basedOnValue The valid value that was fuzzed by {@code operator}.
	 * @param operator The fuzzing operator that mutated {@code basedOnValue}.
	 */
	public FuzzedValue(T fuzzedValue, T basedOnValue, FuzzingHeuristic<?> operator) {
		if (operator == null) {
			throw new IllegalArgumentException("operator must not be null.");
		}
		value = fuzzedValue;
		this.basedOnValue = basedOnValue;
		heuristic = operator;
		kind = Kind.MUTATED;
	}
	
	/**
	 * @return {@code true} if the value was created by a fuzzing generator.
	 */
	public boolean isGenerated() {
		return kind == Kind.GENERATED;
	}
	
	/**
	 * @return {@code true} if the value was created by a fuzzing operator.
	 */
	public boolean isMutated() {
		return kind == Kind.MUTATED;
	}
	
	/**
	 * @return {@code true} if no value was generated.
	 */
	public boolean isNone() {
		return kind == Kind.NONE;
	}
	
	@Override
	public int hashCode() {
		if (isNone()) {
			return 0;
		}
		if (isGenerated()) {
			return heuristic.hashCode();
		} else {
			return heuristic.hashCode() + getBasedOnValue().hashCode();
		}
	}
	
	/**
	 * Defines equivalence between two fuzzed values either by the used fuzzing generator
	 * or by the used fuzzing operator and the used valid value.
	 */
	@Override
	public boolean equals(Object another) {
		if (!(another instanceof FuzzedValue)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		FuzzedValue<T> other = (FuzzedValue<T>)another;
		
		if (isGenerated() != other.isGenerated()) {
			return false;
		}
		
		if (isGenerated() && other.isGenerated()) {
			return getHeuristic() == other.getHeuristic();
		}
		
		return (getHeuristic() == other.getHeuristic() && getBasedOnValue().equals(other.getBasedOnValue()));
	}
	
	/**
	 * @return The fuzzed value itself.
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @return The valid value that was modified by a fuzzing operator.
	 * @throws UnsupportedOperationException if {@link #isMutated()} returns {@code false}.
	 */
	public T getBasedOnValue() {
		if (!isMutated()) {
			throw new UnsupportedOperationException("This value is generated, not mutated.");
		}
		return basedOnValue;
	}

	/**
	 * @return The fuzzing heuristic the created the fuzzed value {@link #getValue()}.
	 * @throws UnsupportedOperationException if {@link #isGenerated()} returns {@code false}.
	 */
	public FuzzingHeuristic<?> getHeuristic() {
		if (isNone()) {
			throw new UnsupportedOperationException("This is not fuzzed value, neither generated nor mutated.");
		}
		return heuristic;
	}
	
	@Override
	public String toString() {
		return "[FuzzedValue value:" + value + " kind:" + kind + " heuristic:" + heuristic.getName() + 
				(basedOnValue == null ? "" : basedOnValue) + "]";
	}
}
