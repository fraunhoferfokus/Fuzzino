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

import java.util.List;

/**
 * This class contains one fuzzed structure.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface FuzzedStructure extends Iterable<Field> {

	/**
	 * @return The list of fields representing the fuzzed structure.
	 */
	List<Field> getFields();
	
	/**
	 * Sets the list of fields representing the fuzzed structure. If fields are already contained
	 * they will be replaced.
	 * 
	 * @param value The list of fields.
	 */
	void setFields(List<Field> value);
	
	/**
	 * Adds a single field to the fuzzed structure
	 * 
	 * @param value The field to be added.
	 */
	void addField(Field value);
	
	/**
	 * @return The number of mutations thar are made in order to create this fuzzed structure.
	 */
	int getMutations();
	
	/**
	 * Sets the number of mutations that creates this fuzzed structure.
	 * 
	 * @param value The number of mutations.
	 */
	void setMutations(int value);
	
	/**
	 * @return The operators that created this fuzzed structure.
	 */
	Object getOperators();
	
	/**
	 * Sets the operators that created this fuzzed structure.
	 * 
	 * @param value The operators.
	 */
	void setOperators(Object value);

	/**
	 * @return Returns the corresponding EMF object {@link de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedStructure}
	 *         initialized with the values of this response.
	 */
	de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedStructure getEMFRepresentation();
}
