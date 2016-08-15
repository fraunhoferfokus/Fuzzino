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
package de.fraunhofer.fokus.fuzzing.fuzzino.request;

import java.io.Serializable;

/**
 * This element specifies one field of a data structure. It refers to request for collection, 
 * number, string or structure by their name attribute. 
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface Field extends Serializable {
	
	/**
	 * @return An Id that corresponds to the id of another request, which serves as a specification for the value of 
	 *         this field.
	 */
	String getCorrespondingRequestId();
	
	/**
	 * References another Request via its id as a specification for the value of this field. By referencing other structure requests nested structures can be built.
	 * 
	 * @param value Another request serving as a specification for this field.
	 */
	void setCorrespondingRequestId(String id);
	
	/***
	 * Set whether this field should be fuzzed (fuzzField=true) or filled with valid data (fuzzField=false)
	 * @param fuzzField
	 */
	void setFuzz(boolean fuzzField);
	
	/***
	 * Get whether this field should be fuzzed (fuzzField=true) or filled with valid data (fuzzField=false)
	 * @param fuzzField
	 */
	boolean fuzz();
	
	String getName();
	
	void setName(String name);
	
}
