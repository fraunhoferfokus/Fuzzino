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
package de.fraunhofer.fokus.fuzzing.fuzzino.request.java;

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
	 * @return A {@link CommonRequest} that serves as a specification for the value of 
	 *         this field.
	 */
	CommonRequest getValueRequest();
	
	/**
	 * References another {@link CommonRequest} as a specification for the value of this field.
	 * It may not reference the enclosing request.
	 * 
	 * @param value Another request serving as a specification for this field.
	 */
	void setValueRequest(CommonRequest value);
	
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
	
	/**
	 * Initializes this field with the values of the corresponding object of the EMF class
	 * {@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Field}.
	 * 
	 * @param emfField The EMF field whose values shall be transferred to this field.
	 */
	void setWithEMFObject(de.fraunhofer.fokus.fuzzing.fuzzino.request.Field emfField);
	
}
