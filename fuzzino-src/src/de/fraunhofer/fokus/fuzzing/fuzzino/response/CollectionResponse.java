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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest;

/**
 * This class contains the response to a {@link CollectionRequest}.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface CollectionResponse extends CommonResponse {
	
	/**
	 * @return A list of all fuzzed collections created by the library.
	 */
	List<FuzzedCollection> getFuzzedCollections();
	
	/**
	 * Sets the list of fuzzed collections to be contained in this response.
	 * If this response already contains fuzzed collections, they will be replaced.
	 * 
	 * @param value The list of fuzzed collections to be contained in this response.
	 */
	void setFuzzedCollection(List<FuzzedCollection> value);
	
	/**
	 * Adds a single fuzzed collection to the response.
	 * 
	 * @param value The fuzzed collection to be added.
	 */
	void addFuzzedCollection(FuzzedCollection value);
	
}
