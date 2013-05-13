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
import java.util.List;

/**
 * This interface specifies a list whose elements are possibly computed instead of being stored.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 */
public interface ComputableList<E> extends List<E>, Serializable {

	/**
	 * Computes a specific element of the list.
	 * 
	 * @param index The index of the element to be computed.
	 * @return The computed element.
	 */
	E computeElement(int index);
	
	/**
	 * @param index The index of the element whose existence is in question.
	 * @return {@code true} if there is an element at the specified index.
	 */
	boolean hasElementWithIndex(int index);
	
}
