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
import java.util.List;

/**
 * This class represents a valid collection made up of its elements.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface ValidCollection extends Serializable {

	/**
	 * @return A list of all values contained in this collection.
	 */
	List<String> getValues();
	
	/**
	 * Replaces all values of this collection.
	 * 
	 * @param value A list of values replacing the existing values.
	 */
	void setValues(List<String> value);
	
	/**
	 * Adds a value at the end of the list of all values.
	 * 
	 * @param value The value to be added at the end of the list.
	 */
	void addValue(String value);
	
	/**
	 * @return The user-defined identifier of this collection.
	 */
	String getName();
	
	/**
	 * User-defined dentifier of this collection that will be mentioned in the response.
	 * 
	 * @param value
	 */
	void setName(String value);
	
}
