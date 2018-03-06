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
package de.fraunhofer.fokus.fuzzing.fuzzino.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class implements a generator of all permutations with a length l that uses a set of n elements.
 * 
 * @author Martin Schneider
 *
 */
public class PermutationsOfFixedLength<T> implements Iterable<List<T>> {
	
	protected int lengthOfPermutations;
	protected int maxNumOfPermutations;
	protected List<T> elements;
	protected List<List<T>> generatedPermutations;
	
	/**
	 * This constructor prepares and generates the permutations.  
	 * 
	 * @param elements the elements to generates the permutations from.
	 * @param lengthOfPermutations the maximum length of each permutation.
	 * @param maxNumOfPermutations the maximum number of permutations to generate.
	 */
	public PermutationsOfFixedLength(Collection<T> elements, int lengthOfPermutations, int maxNumOfPermutations) {
		if (lengthOfPermutations > elements.size()) {
			throw new IllegalArgumentException("The requested size of the permutations is greater than the number of elements provided.");
		}
		this.maxNumOfPermutations = maxNumOfPermutations;
		this.lengthOfPermutations = lengthOfPermutations;
		this.elements = new LinkedList<>(elements);
		this.generatedPermutations = new LinkedList<>();
		
		List<T> emptyPermutation = new LinkedList<>();

		generatePermutations(emptyPermutation, this.elements);
	}
	
	/**
	 * This method recursively generates all permutations. The recursion stops if the given length is achieved.
	 * 
	 * @param permutationToBeCompleted An incomplete permutation to be completed. 
	 * @param sourceElements All elements that can be used for completing the permutation.
	 * @param length The length of the permutation.
	 */
	protected void generatePermutations(List<T> permutationToBeCompleted, List<T> sourceElements) {
		for (int i = 0; i < sourceElements.size(); i++) {
			List<T> reducedSourceElements = new LinkedList<>(sourceElements);
			     T  nextElement           = reducedSourceElements.get(i);
			List<T> nextPermutation       = new LinkedList<>(permutationToBeCompleted);
			
			nextPermutation.add(nextElement);
			reducedSourceElements.remove(i);

			if (nextPermutation.size() == this.lengthOfPermutations) {
				this.generatedPermutations.add(nextPermutation);
			} else {
				if (this.generatedPermutations.size() <= this.maxNumOfPermutations) {
					generatePermutations(nextPermutation, reducedSourceElements);					
				}
			}
		}
	}

	@Override
	public Iterator<List<T>> iterator() {
		return this.generatedPermutations.iterator();
	}
	
	public int getNumberOfPermutations() {
		return this.generatedPermutations.size();
	}
	
	public int getPermutationLength() {
		return this.lengthOfPermutations;
	}
	
	public int getMaxNumOfPermutations() {
		return this.maxNumOfPermutations;
	}
	
	public List<List<T>> getAllPermutations() {
		return this.generatedPermutations;
	}

	
}
