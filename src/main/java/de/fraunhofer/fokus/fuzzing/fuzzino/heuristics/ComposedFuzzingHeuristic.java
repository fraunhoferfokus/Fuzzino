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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;

/**
 * This fuzzing heuristic incorporates a bunch of fuzzing heuristics and returns values of each
 * alternately.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 * @param <T> the type of the fuzzing heuristics to be incorporated.
 */
public abstract class ComposedFuzzingHeuristic<T> extends ComputableListImpl<FuzzedValue<T>> implements ComputableFuzzingHeuristic<T> {

	private static final long serialVersionUID = 3890064549270092598L;
	/**
	 * The owner of the heuristic. This value is used as generator or operator for {@link FuzzedValue}.
	 */
	protected ComputableFuzzingHeuristic<?> owner;
	/**
	 * The fuzzing heuristics incorporated by this one.
	 */
	protected List<ComputableFuzzingHeuristic<T>> heuristics = new ArrayList<>();
	/**
	 * The number of values of each fuzzing heuristics. It is used for improving performance.
	 */
	protected List<Integer> heuristicSizes = new ArrayList<>();
	/**
	 * The seed used for random 
	 */
	protected long seed;
	protected Random random;
	
	protected int lastIndex;
	protected ComposedIndexIterator lastComposedIndex;
	
	/**
	 * Constructor for de-serialization
	 */
	protected ComposedFuzzingHeuristic() {
	}
	
	/**
	 * Constructor for subclasses.
	 * 
	 * @param seed The seed that is used by random-based fuzzing heuristics.
	 */
	protected ComposedFuzzingHeuristic(long seed) {
		//FIXME: If the user specifies 0 he will be surprised...
		if (seed != 0) {
			this.seed = seed;
		} else {
			Random random = new Random();
			this.seed = random.nextLong();
		}
		this.random = new Random(this.seed);
		owner = this;
		
		lastIndex = Integer.MAX_VALUE;
		lastComposedIndex = null;
 	}
	
	/**
	 * @param seed The seed that is used by random-based fuzzing heuristics.
	 * @param owner The fuzzing heuristic that uses this fuzzing operator for its own purpose.
	 *              fuzzed Value will return {@code owner} instead of {@code this} when calling
	 *              {@link FuzzedValue#getHeuristic()}.
	 */
	protected ComposedFuzzingHeuristic(long seed, ComputableFuzzingHeuristic<?> owner) {
		this.seed = seed;
		random = new Random(seed);
		if (owner == null) {
			owner = this;
		} else {
			this.owner = owner;
		}
	}
	
	@Override
	public FuzzedValue<T> computeElement(int index) {
		ComposedIndexIterator composedIndex = computeIndex(index);
		
		int heuristicIndex = composedIndex.getIndexForHeuristic();
		int elementIndex = composedIndex.getIndexForElement();
		
		ComputableFuzzingHeuristic<T> currentHeuristic = heuristics.get(heuristicIndex);
		FuzzedValue<T> currentElement = currentHeuristic.get(elementIndex);
		
		return currentElement;
	}
	
	public ComposedIndexIterator computeIndex(int index) {
		if (index < 0 || index >= size()) {
			throw new NoSuchElementException();
		}
		if (index < lastIndex || lastComposedIndex == null) {
			lastIndex = 0;
			lastComposedIndex = new ComposedIndexIterator();
		}

		if (index == lastIndex) {
			return lastComposedIndex;
		}
		
		for (; lastIndex<index; lastIndex++) {
			lastComposedIndex.next();
		}
		
		return lastComposedIndex;
	}
	
	protected class ComposedIndexIterator implements Serializable {

		private static final long serialVersionUID = 6245330871685854922L;
		private int idxHeuristic;
		private int idxElement;
		
		private List<Boolean> hasMoreElements;
		private int numHeuristicsWithMoreValues;
		
		private ComposedIndexIterator nextIndex;
		
		public ComposedIndexIterator() {
			idxHeuristic = -1;
			idxElement = 0;
			
			hasMoreElements = new ArrayList<>(heuristics.size());
			for (int i=0; i<heuristics.size(); i++) {
				hasMoreElements.add(true);
			}
			
			numHeuristicsWithMoreValues = heuristics.size();
			
			next();
		}
		
		public boolean hasNext() {
			if (nextIndex != null) {
				return true;
			}
			nextIndex = new ComposedIndexIterator();
			nextIndex.idxElement = idxElement;
			nextIndex.idxHeuristic = idxHeuristic;
			nextIndex.hasMoreElements = new ArrayList<>(hasMoreElements);
			nextIndex.numHeuristicsWithMoreValues = numHeuristicsWithMoreValues;
			
			try {
				nextIndex.next();
			} catch (NoSuchElementException e) {
				return false;
			}
			
			return true;
		}
		
		public void next() {
			if (numHeuristicsWithMoreValues == 0) {
				throw new NoSuchElementException();
			}
			
			if (nextIndex != null) {
				idxElement = nextIndex.idxElement;
				idxHeuristic = nextIndex.idxHeuristic;
				hasMoreElements = nextIndex.hasMoreElements;
				numHeuristicsWithMoreValues = nextIndex.numHeuristicsWithMoreValues;
				
				nextIndex = null;
			}
			
			boolean hasElementWithIndex = false;
			do {
				idxHeuristic++;
				if (idxHeuristic >= heuristics.size()) {
					idxHeuristic = 0;
					idxElement++;
				}
				hasElementWithIndex = updateElementAvailability();
				
			} while (!hasElementWithIndex && numHeuristicsWithMoreValues > 0);

			
			if (numHeuristicsWithMoreValues == 0) {
				throw new NoSuchElementException();
			}
		}

		protected boolean updateElementAvailability() {
			if (hasMoreElements.get(idxHeuristic) == false) {
				return false;
			}
			ComputableFuzzingHeuristic<T> heuristic = heuristics.get(idxHeuristic);
			boolean hasElementWithIndex = heuristic.hasElementWithIndex(idxElement);
			if (!hasElementWithIndex) {
				hasMoreElements.set(idxHeuristic, false);
				numHeuristicsWithMoreValues--;
			}
			return hasElementWithIndex;
		}
		
		public int getIndexForHeuristic() {
			return idxHeuristic;
		}
		
		public int getIndexForElement() {
			return idxElement;
		}

	}
	
	@Override
	public int size() {
		if (size == 0) {
			for (ComputableFuzzingHeuristic<T> list : heuristics) {
				size += list.size();
			}
			for (ComputableFuzzingHeuristic<?> heuristic : heuristics) {
				heuristicSizes.add(heuristic.size());
			}
		}
		
		return size;
	}
	
	/**
	 * @return A list of all incorporated fuzzing heuristics.
	 */
	public List<ComputableFuzzingHeuristic<T>> getAllFuzzingHeuristics() {
		return Collections.unmodifiableList(heuristics);
	}
	
	@Override
	public long getSeed() {
		return seed;
	}

	@Override
	public String toString() {
		return "[ComposedFuzzingHeuristic name:" + getName() + 
			   " heuristics:" + (heuristics == null ? "0" : heuristics.size()) +
			   " owner: " + owner +
			   " seed:" + seed + "]";
	}
	
}
