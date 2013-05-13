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
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * This class is a skeleton for implementations of a computed list of values. Instead
 * of having all values stored, a ComputedList usually computes each element when it is
 * requested. Hence, this list cannot be modified.
 * This class provides a special list iterator that call the {@link #computeElement(int)} method
 * of the enclosing ComputableList.
 * 
 * To implement a ComputableListImpl the methods {@link #size()} and {@link #computeElement(int)}
 * must be implemented.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 */
public abstract class ComputableListImpl<E> extends AbstractSequentialList<E> implements ComputableList<E> {
	
	private static final long serialVersionUID = 5805347245683536343L;
	/**
	 * Index of last values that {@link #matchesSpecification(Object)}.
	 */
	private int lastIndex = 0;
	/**
	 * The indices of already found values that suffice {@link #matchesSpecification(Object)}.
	 */
	protected List<Integer> matchingValues = new ArrayList<>();
	/**
	 * The size of this list
	 */
	protected int size;

	@Override
	public E get(int index) {
		if (index < 0 || index >= size()) {
			throw new NoSuchElementException();
		}
		lastIndex = index;
		int flatIndex = findMatchingElement(index);
		
		return computeElement(flatIndex);
	}

	/**
	 * Finds the first value that suffices {@link #matchesSpecification(Object)} and stores its index to {@link #matchingValues}.
	 */
	private void findFirstMatchingElement() {
		if (matchingValues.isEmpty()) {
			int indexOfFirstMatchingElement = findNextMatchingElement(-1);
			matchingValues.add(indexOfFirstMatchingElement);
		}
	}
	
	/**
	 * Finds the next matching element. Search after the given index.
	 * 
	 * @param index The index of the last matching element that suffices {@link #matchesSpecification(Object)}.
	 * @return The index of the next element that {@link #matchesSpecification(Object)}.
	 */
	private int findMatchingElement(int index) {
		if (matchingValues.isEmpty()) {
			findFirstMatchingElement();
		}
		
		int internalIndex;

		if (index >= matchingValues.size()) {
			// if the index-th element that matches the specification was never found
			// start to search from the last known element that matches the specification
			internalIndex = matchingValues.get(matchingValues.size()-1);
			for (int i=matchingValues.size(); i<=index; i++) {
				internalIndex = findNextMatchingElement(internalIndex);
				matchingValues.add(internalIndex);
			}
		} else {
			// if the index-th element that matches the specification was already found
			internalIndex = matchingValues.get(index);
		}
		
		return internalIndex;
	}
	
	/**
	 * Finds the next matching element that {@link #matchesSpecification(Object)} starting from an actual
	 * element index {@code internalStartIndex}.
	 * 
	 * @param internalStartIndex the actual index to start from.
	 * @return  the next actual index of an element that {@link #matchesSpecification(Object)}.
	 */
	protected int findNextMatchingElement(int internalStartIndex) {
		if (internalStartIndex == size()-1) {
			throw new NoSuchElementException();
		}
		int i = internalStartIndex;
		E element;
		boolean matchesSpecification = false;
		while (!matchesSpecification && i<size()-1) {
			i++;
			element = computeElement(i);
			matchesSpecification = matchesSpecification(element);
		}
		
		if (i == size()-1 && !matchesSpecification) {
			throw new NoSuchElementException();
		}
		
		return i;
	}
		
	@Override
	public boolean hasElementWithIndex(int index) {
		try {
			findMatchingElement(index);
		} catch (NoSuchElementException e) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" (");
		sb.append(size());
		sb.append(" elements: ");
		if (size() <= 10) {
			sb.append(super.toString());
		} else {
			sb.append("[");
			for (int i=0; i<5; i++) {
				sb.append(get(i));
				sb.append(", ");
			}
			sb.append("... ");
			for (int i=size()-6; i<size(); i++) {
				sb.append(", ");
				sb.append(get(i));
			}
			sb.append("]");
		}
		return sb.toString();
	}
	
	/**
	 * @return the last index that was requested.
	 */
	public int lastIndex() {
		return lastIndex;
	}
	
	@Override
	public int hashCode() {
		// this is necessary because iteration through all objects of the list takes too much time
		// to put a ComputableList in a HashMap.
		return System.identityHashCode(this);
	}
	
	@Override
	public Iterator<E> iterator() {
		return listIterator();
	}
	
	@Override
	public ListIterator<E> listIterator() {
		return listIterator(0);
	}
	
	@Override
	public ListIterator<E> listIterator(int index) {
		return new ComputingItr(index);
	}
	
	public boolean matchesSpecification(E value) {
		return true;
	}

	private class ComputingItr implements ListIterator<E>, Serializable {
		
		private static final long serialVersionUID = 8661734456747312922L;
		private int nextIndex;
		private E nextElement;
		
		ComputingItr(int index) {
			if (index < 0 || index >= size()) {
				throw new IndexOutOfBoundsException();
			}
			nextIndex = index;
			nextElement = get(index);
		}

		@Override
		public boolean hasNext() {
			if (nextIndex >= size()) {
				return false;
			}

			try {
				nextElement = get(nextIndex);
			} catch (NoSuchElementException e) {
				nextElement = null;
				return false;
			}
			
			return true;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			nextIndex++;

			return nextElement;
		}

		@Override
		public boolean hasPrevious() {
			return nextIndex > 0;
		}

		@Override
		public E previous() {
			if (nextIndex <= 0) {
				throw new NoSuchElementException();
			}
			nextIndex--;
			E nextElement = get(nextIndex);
			
			return nextElement;
		}

		@Override
		public int nextIndex() {
			return nextIndex;
		}

		@Override
		public int previousIndex() {
			return nextIndex - 1;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(E e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(E e) {
			throw new UnsupportedOperationException();
		}

	}

}
