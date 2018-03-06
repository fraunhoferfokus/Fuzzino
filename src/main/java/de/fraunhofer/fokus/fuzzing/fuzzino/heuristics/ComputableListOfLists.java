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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class is a computable lists that takes its values from several
 * lists that are added to it. A specialization of this class
 * must implement a constructor that adds all lists to the member
 * {@link #allLists}. 
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 */
public abstract class ComputableListOfLists<E> extends ComputableListImpl<E> {
	
	private static final long serialVersionUID = -6169462032998662081L;
	protected List<List<E>> allLists;
	
	/**
	 * The constructor that must be overwritten by a specializing class.
	 * The overridden constructor must add all lists where values shall be taken from.
	 * Usually, these lists shall be {@link ComputableList}s.
	 */
	public ComputableListOfLists() {
		allLists = new LinkedList<>();
	}
	
	@Override
	public E computeElement(int index) {
		if (index >= size()) {
			throw new NoSuchElementException();
		}
		
		int numElements = 0;
		for (List<E> list : allLists) {
			if (index < numElements + list.size()) {
				return list.get(index - numElements);
			} else {
				numElements += list.size();
			}
		}
		
		return null; // impossible
	}
	
	@Override
	public int size() {
		int size = 0;
		for (List<E> list : allLists) {
			size += list.size();
		}
		
		return size;
	}
	
	/**
	 * @return the name of the fuzzing operator that is used in a request file.
	 */
	public abstract String getName();
	
	public List<List<E>> getAllLists() {
		return Collections.unmodifiableList(allLists);
	}

}
