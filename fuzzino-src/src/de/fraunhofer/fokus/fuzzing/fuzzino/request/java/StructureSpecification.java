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
 * A StructureSpecification is a description of a type of a request. It gives hints to the fuzzing 
 * library that reduces the set of fuzz testing values in a reasonable way by omitting values
 * that are not appropriate to this specification.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface StructureSpecification extends TypeSpecification {
	
	/**
	 * @return
	 */
	List<Field> getFields();
	
	/**
	 * Replaces the list of fields with another one.
	 * 
	 * @param value The list of fields replacing the existing one within the specification.
	 */
	void setFields(List<Field> value);
	
	/**
	 * Adds to the list of fields another one.
	 * 
	 * @param value The field to be added.
	 */
	void addField(Field value);
	
	/**
	 * @return {@code true} if the fields are ordered within the data structure.
	 */
	boolean isOrdered();
	
	/**
	 * Specifies whether the order of the fields within the data structure is relevant.
	 * 
	 * @param value {@code true} if the fields are ordered within the data structure.
	 */
	void setOrdered(boolean value);
	
}
