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

import de.fraunhofer.fokus.fuzzing.fuzzino.LibraryType;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ValidationResult;

/**
 * The common base of all type specific request.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface CommonRequest extends Serializable {

	LibraryType getLibraryType();
	
	/**
	 * @return The ID that was set in order to receive more values from an initial request.
	 */
	String getId();
	
	/**
	 * Identifier for the fuzzing library to request more values. Can 
	 * only be set to a meaningful value if an initial request has been
	 * taken place that returned a valid id.
	 * If set, all child elements of this request are ignored.
	 * 
	 * @param value the ID to request more values from an initial request.
	 */
	void setId(String value);
	
	/**
	 * @return The maximal number of fuzzed values to be returned by the fuzzing library.
	 */
	int getMaxValues();
	
	/**
	 * Sets the maximal number of fuzzed values to be returned by the fuzzing library.
	 * 
	 * @param value The maximal number of fuzzed values to be returned by the fuzzing library.
	 */
	void setMaxValues(int value);
	
	/**
	 * @return The user-defined name of the request.
	 */
	String getName();
	
	/**
	 * Identifier for the user of the fuzzing library, will be mentioned in the response.
	 * The name must be unique in the whole enclosing {@link Request}.
	 * 
	 * @param value The user-defined name for the request.
	 */
	void setName(String value);
	
	/**
	 * @return The seed to be used.
	 */
	long getSeed();
	
	/**
	 * Sets a seed for getting the same results if random-based generators or operators are involved.
	 * 
	 * @param value The seed to be used.
	 */
	void setSeed(long value);
	
	/**
	 * @return {@code true} if this request contains an ID meaning that it is a request for further
	 *         values.
	 */
	boolean isContinued();
	
	/**
	 * @return {@code true} if this request was initialized using #setWithEMFObject().
	 */
	boolean isEMFBased();
	
	/**
	 * @return A validation result containing the information whether this request is valid
	 *         and - if not - the corresponding warnings.
	 */
	ValidationResult validate();
	
	/**
	 * @return {@code true} if this request is valid..
	 */
	boolean isValid();

}
