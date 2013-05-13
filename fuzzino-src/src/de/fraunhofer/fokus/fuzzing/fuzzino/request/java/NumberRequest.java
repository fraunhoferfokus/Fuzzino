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

import java.util.List;

/**
 * A NumberRequest opens a request for a number to be fuzzed by the library. It
 * determines the fuzzing generators and operators that can be used for generating
 * fuzz testing values.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface NumberRequest extends CommonRequest {
	
	/**
	 * @return The {@link NumberSpecification} of this number request.
	 */
	NumberSpecification getSpecification();
	
	/**
	 * Sets the {@link NumberSpecification} of this number request.
	 * 
	 * @param value the {@link NumberSpecification} to be set.
	 */
	void setSpecification(NumberSpecification value);
	
	/**
	 * @return A list of {@link Generator}s to be used by the fuzzing library.
	 */
	List<Generator> getRequestedGenerators();

	/**
	 * Replaces the list of {@link Generator}s to be used by the fuzzing library.
	 * 
	 * @param value The new list of {@link Generator}s replacing the existing one.
	 */
	void setRequestedGenerators(List<Generator> value);
	
	/**
	 * Adds a {@link Generator} to be used by the fuzzing library.
	 * 
	 * @param value The {@link Generator} to be used.
	 */
	void addRequestedGenerator(Generator value);

	/**
	 * @return {@code true} if no {@link Generator}s shall be used by the fuzzing library to
	 *         process this request.
	 */
	boolean useNoGenerators();
	
	/**
	 * Sets the flag whether or not to use {@link Generator}s. If set to {@code true}, all
	 * requested {@link Generator}s that possibly are set will be ignored.
	 * 
	 * @param value Set it to {@code true} if no generators shall be used.
	 */
	void setUseNoGenerators(boolean value);
	
	/**
	 * @return {@link ValidValuesSection} containing a list of valid values to be fuzzed and zero ore more
	 *         fuzzing operators to be applied to these valid values.
	 */
	ValidValuesSection getValidValuesSection();

	/**
	 * Replaces the {@link ValidValuesSection}.
	 * 
	 * @param value The {@link ValidValuesSection} replacing the existing one.
	 */
	void setValidValuesSection(ValidValuesSection value);

	/**
	 * Adds a valid value to be fuzzed to this request.
	 * 
	 * @param value
	 */
	void addValidValue(String validValue);

	/**
	 * Initializes this request with the values of the corresponding object of the EMF class
	 * {@link de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest}.
	 * 
	 * @param emfNumberRequest the EMF number request whose values shall be transferred to this request.
	 */
	void setWithEMFObject(de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest emfNumberRequest);
	
}
