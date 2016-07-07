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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedStructure;

/**
 * A fuzzing heuristic that creates fuzzed values of type structure.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface StructureHeuristic extends ComputableFuzzingHeuristic<FuzzedStructure> {

	/**
	 * Determines if this structure heuristic can create values for a certain type.
	 * 
	 * @param structSpec A specification of a structure.
	 * @return {@code true} if this fuzzing heuristic can create values for {@code structSpec}.
	 */
	boolean canCreatesValuesFor(StructureSpecification structSpec);

}
