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
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FuzzedCollectionImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.StructureImpl;

/**
 * This class contains all information related to a fuzzed value including
 * the fuzzed value itself and how it is generated.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({
    StructureImpl.class, //TODO: add every possible value of T here! (this is ugly but it works and should be ok for our case
    FuzzedCollectionImpl.class
})
public class FuzzedValue<T> implements Serializable {
	
	private static final long serialVersionUID = 5673943690714774557L;

	protected enum Kind {
		GENERATED,
		MUTATED,
		NONE
	}
	
	@XmlElement
	protected T value = null;
	@XmlElement
	protected T basedOnValue = null;
	
	
	//TODO: what do we do here - for now we don't serialize it
	/*@XmlElements({ 
	    @XmlElement(name="FuzzingHeuristic", type=FuzzingHeuristicImpl.class)
	})
	@XmlElementWrapper */
	protected final List<FuzzingHeuristic> heuristics = new LinkedList<>();
	@XmlElement
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
//	public FuzzedValue(T fuzzedValue, FuzzingHeuristic generator) {
//		if (generator == null) {
//			throw new IllegalArgumentException("generator must not be null.");
//		}
//		value = fuzzedValue;
//		heuristics.add(generator);
//		kind = Kind.GENERATED;
//	}

	/**
	 * Creates a new instance that stores a fuzzed value created by a fuzzing generator.
	 * 
	 * @param fuzzedValue The value created by {@code generator}.
	 * @param generator The fuzzing generator that created {@code fuzzedValue}.
	 */
	public FuzzedValue(T fuzzedValue, List<FuzzingHeuristic> generators) {
		if (generators == null || generators.isEmpty()) {
			throw new IllegalArgumentException("generator must not be null.");
		}
		value = fuzzedValue;
		heuristics.addAll(generators);
		kind = Kind.GENERATED;
	}
	
	/**
	 * Creates a new instance that stores a fuzzed value created by applying a fuzzing operator to a valid value.
	 * 
	 * @param fuzzedValue The value that is created by applying {@code operator} to {@code basedOnValue}.
	 * @param basedOnValue The valid value that was fuzzed by {@code operator}.
	 * @param operator The fuzzing operator that mutated {@code basedOnValue}.
	 */
	public FuzzedValue(T fuzzedValue, T basedOnValue, FuzzingHeuristic operator) {
		if (operator == null) {
			throw new IllegalArgumentException("operator must not be null.");
		}
		value = fuzzedValue;
		this.basedOnValue = basedOnValue;
		heuristics.add(operator);
		kind = Kind.MUTATED;
	}
	
	/**
	 * Creates a new instance that stores a fuzzed value created by applying a fuzzing operator to a valid value.
	 * 
	 * @param fuzzedValue The value that is created by applying {@code operator} to {@code basedOnValue}.
	 * @param basedOnValue The valid value that was fuzzed by {@code operator}.
	 * @param operators The fuzzing operators that mutated {@code basedOnValue}.
	 */
	public FuzzedValue(T fuzzedValue, T basedOnValue, List<FuzzingHeuristic> operators) {
		if (operators == null || operators.isEmpty()) {
			throw new IllegalArgumentException("operators must not be null.");
		}
		value = fuzzedValue;
		this.basedOnValue = basedOnValue;
		heuristics.addAll(operators);
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
			return heuristics.hashCode();
		} else {
			return heuristics.hashCode() + getBasedOnValue().hashCode();
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
	 * @return The most specific fuzzing heuristic that was used while creating the fuzzed value {@link #getValue()}.
	 * In a lot of cases there is only one fuzzing heuristic involved in the creation of one FuzzedValue
	 * @throws UnsupportedOperationException if {@link #isGenerated()} returns {@code false}.
	 */
	public FuzzingHeuristic getHeuristic() {
		if (isNone()) {
			throw new UnsupportedOperationException("This is not a fuzzed value, neither generated nor mutated.");
		}
		if (heuristics.isEmpty()) {
			return null;
		}
		return heuristics.get(heuristics.size()-1);
	}
	
	@Override
	public String toString() {
		return "[FuzzedValue value:" + value + " kind:" + kind + " heuristics:" + getAllHeuristicNames() + 
				(basedOnValue == null ? "" : basedOnValue) + "]";
	}

	public String getAllHeuristicNames() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<heuristics.size();i++){
			FuzzingHeuristic heuristic = heuristics.get(i);
			sb.append(heuristic.getName());
			if(i!=heuristics.size()){
				sb.append(",");
			}
		}
		return sb.toString();
	}

}
