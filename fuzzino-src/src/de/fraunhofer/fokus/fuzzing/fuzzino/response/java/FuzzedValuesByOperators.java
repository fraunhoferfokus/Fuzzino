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

import java.util.Collection;
import java.util.List;

/**
 * This class contains all values that are created by operators.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 * @param <T>
 *
 */
public interface FuzzedValuesByOperators<T> extends Iterable<OperatorSpecificFuzzedValues<T>> {

	/**
	 * @return A list of section where each section contains fuzzed value that are created by the same operator
	 *         that is applied to a single valid value in different ways.
	 */
	List<OperatorSpecificFuzzedValues<T>> getOperatorSpecificSections();
	
	/**
	 * Sets the list of sections of fuzzed values (one section for each operator and each valid value).
	 * If sections are already contained they will be replaced.
	 * 
	 * @param value The list of section of fuzzed values to be contained.
	 */
	void setOperatorSpecificSections(Collection<OperatorSpecificFuzzedValues<T>> value);
	
	/**
	 * Adds a section of fuzzed values that are all created by the same operator that is applied to a singlie
	 * valid va lue in different ways.
	 * 
	 * @param value The section to be added.
	 */
	void addOperatorSpecificSection(OperatorSpecificFuzzedValues<T> value);
	
}
