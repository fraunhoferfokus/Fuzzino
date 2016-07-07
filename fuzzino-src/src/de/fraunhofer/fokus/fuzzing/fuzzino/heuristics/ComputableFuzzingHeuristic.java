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

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;

/**
 * Either a fuzzing generator or a fuzzing operator for a specific type.
 * The seed is used for random-based heuristics.
 * There is a known issue, not within this class, but with the calling of its methods. 
 * The RequestProcessors seem to call get/computeElement for the same index multiple times, even though the value is only needed once.
 * Thus, all ComputableFuzzingHeuristics must make sure that they return the same value for the same index at any time
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 * @param <T> the type of the fuzzed value the fuzzing heuristic creates.
 */
public interface ComputableFuzzingHeuristic<T> extends ComputableList<FuzzedValue<T>>, FuzzingHeuristic {
	
	/**
	 * @return The seed that is used by random-based fuzzing heuristics.
	 */
	long getSeed();
	
}
