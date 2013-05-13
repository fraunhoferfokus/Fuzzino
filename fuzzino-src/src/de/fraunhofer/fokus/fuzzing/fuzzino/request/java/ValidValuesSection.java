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
import java.util.List;

/**
 * Instances of this class contain valid values available for fuzzing. Additionally, 
 * operators to be used can be specified.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface ValidValuesSection extends Serializable {
	
	/**
	 * @return The list of valid values to be fuzzed.
	 */
	List<String> getValues();
	
	/**
	 * Replaces the list of valid values.
	 * 
	 * @param value A list of valid values replacing the existing ones.
	 */
	void setValues(List<String> value);
	
	/**
	 * Adds a valid value to the list of valid values.
	 * 
	 * @param value A valid value to be added.
	 */
	void addValue(String value);
	
	/**
	 * @return The list of operators to be applied to the valid values.
	 */
	List<Operator> getRequestedOperators();
	
	/**
	 * Replaces the list of {@link Operator}s to be applied to the valid values.
	 * 
	 * @param value A list of operators replacing the existing one.
	 */
	void setRequestedOperators(List<Operator> value);
	
	/**
	 * Adds an operator to be applied to the valid values.
	 * 
	 * @param value An operator to be applied by the fuzzing library.
	 */
	void addRequestedOperator(Operator value);
	
	/**
	 * Initializes this instance with the values of the corresponding object of the EMF class
	 * {@link de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValues}.
	 * 
	 * @param emfValidValues The EMF valid values instance whose values shall be transferred
	 *                       to this one.
	 */
	void setWithEMFObject(de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValues emfValidValues);

}
