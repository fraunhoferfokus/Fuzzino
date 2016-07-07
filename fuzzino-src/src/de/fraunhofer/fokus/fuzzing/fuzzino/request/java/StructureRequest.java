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
 * A StructureRequest opens a request for a data structure to be fuzzed by the library.
 * It determines the fuzzing generators and operators that shall be used for generating
 * fuzzed data structures.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface StructureRequest extends CommonRequest {

	/**
	 * @return The {@link StructureSpecification} of this structure request.
	 */
	StructureSpecification getSpecification();

	/**
	 * Sets the {@link StructureSpecification} of this structure request.
	 * 
	 * @param value the {@link StructureSpecification} to be set.
	 */
	void setSpecification(StructureSpecification value);
	
	/**
	 * @return The {@link Operator}s to be used by the fuzzing library.
	 */
	List<Operator> getRequestedOperators();
	
	/**
	 * Replaces the list of {@link Operator}s to be used by the fuzzing library.
	 * 
	 * @param value the list of {@link Operator}s replacing the existing one.
	 */
	void setRequestedOperators(List<Operator> value);
	
	/**
	 * Adds an {@link Operator} to be used by the fuzzing library.
	 * 
	 * @param value The {@link Operator} to be added.
	 */
	void addRequestedOperator(Operator value);
	
	/**
	 * @return {@code true} if the structure itself shall be fuzzed.
	 */
	boolean fuzzStructure();
	
	/**
	 * Specifies if the structure of the data structure shall be fuzzed, meaning whether 
	 * the order and appearance of the fields within the data structure shall be changed.
	 * Must be true if {@code fuzzValues() == false}.
	 * 
	 * @param value Set to {@code true} if the structure itself shall be fuzzed.
	 */
	void setFuzzStructure(boolean value);
	
	/**
	 * @return The maximum number of mutations applied to each fuzzed structure.
	 */
	int getMaxMutations();
	
	/**
	 * Sets the maximum number of mutations applied to each fuzzed structure.
	 * 
	 * @param value The maximum number of mutations applied to each fuzzed structure.
	 */
	void setMaxMutations(int value);
	
	/**
	 * @return The minimal number of mutations applied to a valid structure.
	 */
	int getMinMutations();

	/**
	 * The minimum number of mutations applied to each fuzzed structure.
	 * If this attribute is not set, it has the default value 1.
	 * 
	 * @param value The minimum number of mutations applied to each fuzzed structure.
	 */
	void setMinMutations(int value);
	
	/**
	 * Initializes this request with the values of the corresponding object of the EMF class
	 * {@link de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest}.
	 * 
	 * @param emfStructureRequest the EMF structure request whose values shall be transferred to this request.
	 */
	void setWithEMFObject(de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest emfStructureRequest);

}
