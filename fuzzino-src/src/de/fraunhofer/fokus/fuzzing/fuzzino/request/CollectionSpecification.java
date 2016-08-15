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
 * A CollectionSpecification is a description of a type of a request. It gives hints to the fuzzing 
 * library that reduces the set of fuzz testing values in a reasonable way by omitting values
 * that are not appropriate to this specification.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface CollectionSpecification extends TypeSpecification {
	
	/**
	 * @return A value of the name attribute of another request that serves as
	 *         a specification for the values of the specified collection. 
	 */
	String getRef();

	/**
	 * References another request as a specification for the values of the specified collection.
	 * The value of this attribute must match the name attribute of another request.
	 * It may not reference the enclosing request.
	 * 
	 * @param value The value of the name attribute of another request.
	 */
	void setRef(String value);
	
	/**
	 * @return A {@link CommonRequest} that serves as a specification for the values of the specified collection.
	 */
	CommonRequest getValuesRequest();
	
	/**
	 * References another {@link CommonRequest} as a specification for the values of the specified collection.
	 * It may not reference the enclosing request.
	 * 
	 * @param value Another request serving as a specification for this field.
	 */
	void setValuesRequest(CommonRequest value);
	
	/**
	 * @return {@code true} if each of the values within this collection must be unique.
	 */
	boolean isUnique();
	
	/**
	 * Specifies if each value of the collection must be unique (as usually for sets).
	 * 
	 * @param value Set to {@code true} if each of the values must be unique.
	 */
	void setUnique(boolean value);
	
	boolean isOrdered();
	
	/**
	 * Specifies if the order of values within the collection is relevant (as usually for lists).
	 * 
	 * @param value Set to {@code true} if the order of values within this collection is relevant.
	 */
	void setOrdered(boolean value);
	
	/**
	 * @return The minimal number of elements in the collection.
	 */
	int getMinLength();
	
	/**
	 * Specifies the minimal number of elements in the collection.
	 * 
	 * @param value The minimal number of elements in the collection.
	 */
	void setMinLength(int value);
	
	/**
	 * @return The maximal number of elements in the collection.
	 */
	int getMaxLength();

	/**
	 * Specifies the maximal number of elements in the collection.
	 * 
	 * @param value The maximal number of elements in the collection.
	 */
	void setMaxLength(int value);

	
}
