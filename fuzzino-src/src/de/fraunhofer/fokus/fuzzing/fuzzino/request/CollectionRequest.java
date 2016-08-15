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

/**
 * A CollectionRequest opens a request for a collection to be fuzzed by the library. It
 * determines the fuzzing generators and operators that shall be used for generating 
 * fuzzed collections.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface CollectionRequest extends CommonRequest {
	
	/**
	 * @return The {@link CollectionSpecification} of this collection request.
	 */
	CollectionSpecification getSpecification();
	
	/**
	 * Sets the {@link CollectionSpecification} of this collection request.
	 * 
	 * @param value the {@link CollectionSpecification} to be set.
	 */
	void setSpecification(CollectionSpecification value);
	
	/**
	 * @return {@link ValidCollectionsSection} containing a list of valid collections to be fuzzed and zero
	 *         or more fuzzing operators to be applied to these valid collections.
	 */
	ValidCollectionsSection getValidCollectionsSection();
	
	/**
	 * Replaces the {@link ValidCollectionsSection}.
	 * 
	 * @param value The {@link ValidCollectionsSection} replacing the existing one.
	 */
	void setValidCollectionsSection(ValidCollectionsSection value);
	
	/**
	 * @return {@code true} if the collections itself shall be fuzzed.
	 */
	boolean fuzzCollections();
	
	/**
	 * Set to {@code true} if the collections shall be fuzzed, meaning whether the order and appearance
	 * of the elements within the collection shall be changed.
	 * Must be true if {@code fuzzValues() == false}.
	 * 
	 * @param value Set to {@code true} if the collections shall be fuzzed.
	 */
	void setFuzzCollections(boolean value);
	
	/**
	 * @return {@code true} if the values of the collections shall be fuzzed.
	 */
	boolean fuzzValues();
	
	/**
	 * Specifies whether the values of the collection shall be fuzzed.
	 * Must be true if {@code fuzzCollection() == false}.
	 * 
	 * @param value Set to {@code true} if the values of the collection shall be fuzzed.
	 */
	void setFuzzValues(boolean value);
	
	/**
	 * @return The maximum number of mutations applied to each fuzzed collection.
	 */
	int getMaxMutations();
	
	/**
	 * Sets the maximum number of mutations applied to each fuzzed collection.
	 * 
	 * @param value The maximum number of mutations applied to each fuzzed collection.
	 */
	void setMaxMutations(int value);
	
	/**
	 * @return The minimal number of mutations applied to a valid collection.
	 */
	int getMinMutations();
	
	/**
	 * The minimum number of mutations applied to each fuzzed collection.
	 * If this attribute is not set, it has the default value 1.
	 * 
	 * @param value The minimum number of mutations applied to each fuzzed collection.
	 */
	void setMinMutations(int value);
	

}
