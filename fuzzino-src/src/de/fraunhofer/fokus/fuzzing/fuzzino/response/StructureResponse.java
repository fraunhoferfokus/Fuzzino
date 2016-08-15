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
package de.fraunhofer.fokus.fuzzing.fuzzino.response;

import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;

/**
 * This class contains the response to a {@link StructureRequest}.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface StructureResponse extends CommonResponse, Iterable<FuzzedValue<Structure>> {

	/**
	 * @return A list of all fuzzed structures created by the library.
	 */
	List<FuzzedValue<Structure>> getFuzzedStructures();
	
	/**
	 * Sets the list of fuzzed structures to be contained in this response.
	 * If this response already contains fuzzed structures, they will be replaced.
	 * 
	 * @param value The list of fuzzed structures to be contained in this response.
	 */
	void setFuzzedStructures(List<FuzzedValue<Structure>> value);
	
	/**
	 * Adds a single fuzzed structure to the response.
	 * 
	 * @param value The fuzzed structure to be added.
	 */
	void addFuzzedStructure(FuzzedValue<Structure> value);
	
}
