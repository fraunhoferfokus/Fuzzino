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
 * ValidCollections contains instances of {@link ValidCollection} to be fuzzed.
 * Additionally, some fuzzing operators can be contained to be applied to the
 * valid collections by the fuzzing libraries. 
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface ValidCollectionsSection extends Serializable {
	
	/**
	 * @return a list of {@link ValidCollection}s to be fuzzed.
	 */
	List<ValidCollection> getValidCollections();
	
	/**
	 * Replaces the list of existing valid collections.
	 * 
	 * @param value A list of {@link ValidCollection}s replacing the exisiting one.
	 */
	void setValidCollections(List<ValidCollection> value);
	
	/**
	 * Adds a valid collection.
	 * 
	 * @param value The valid collection to be added.
	 */
	void addValidCollection(ValidCollection value);
	
	/**
	 * @return A list of {@link Operator}s to be applied to the valid collections.
	 */
	List<Operator> getRequestedOperators();
	
	/**
	 * Replaces the list of existing operators.
	 * 
	 * @param value A list of {@link Operator}s replacing the existing one.
	 */
	void setRequestedOperators(List<Operator> value);
	
	/**
	 * Adds an operator to be applied to the valid collections.
	 * 
	 * @param value The operator to be added.
	 */
	void addRequestedOperator(Operator value);

}