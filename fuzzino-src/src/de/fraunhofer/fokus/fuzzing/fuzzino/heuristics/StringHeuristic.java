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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;

/**
 * A fuzzing heuristic that creates string values.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface StringHeuristic extends FuzzingHeuristic<String> {

	/**
	 * Determines if this string heuristic can create values for a certain type.
	 * 
	 * @param stringSpec A specification of a string type. 
	 * @return {@code true} if this fuzzing heuristic can create values for {@code stringSpec}.  
	 */
	boolean canCreateValuesFor(StringSpecification stringSpec);
	
}
