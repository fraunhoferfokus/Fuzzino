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
package de.fraunhofer.fokus.fuzzing.fuzzino.response.java;

/**
 * This element specifies one field of a fuzzed data structure. It refers to a collection, 
 * number, string or structure by their name attribute. 
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface Field {

	/**
	 * @return {@code true} if the value of this field is fuzzed.
	 */
	boolean isValueFuzzed();
	
	/**
	 * Sets to {@code true} if the value of this field is fuzzed.
	 * 
	 * @param value Indicator whether the value of this field if fuzzed.
	 */
	void setValueIsFuzzed(boolean value);
	
	/**
	 * @return The name of a response for fuzzed values.
	 */
	String getRef();
	
	/**
	 * Sets the name of a response for fuzzed value.
	 * 
	 * @param value
	 */
	void setRef(String value);
	
	/**
	 * @return The response containing fuzzed values of this response.
	 */
	CommonResponse getValuesResponse();
	
	/**
	 * Sets the response for the values.
	 * 
	 * @param value A response for the fuzzed values of this field.
	 */
	void setValuesResponse(CommonResponse value);
	
	/**
	 * @return Returns the corresponding EMF object {@link de.fraunhofer.fokus.fuzzing.fuzzino.response.Field}
	 *         initialized with the values of this response.
	 */
	de.fraunhofer.fokus.fuzzing.fuzzino.response.Field getEMFRepresentation();
}
