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
package de.fraunhofer.fokus.fuzzing.fuzzino.response;

import java.util.Collection;
import java.util.List;

/**
 * This class contains all values that are created by generators.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface FuzzedValuesByGenerators<T> extends Iterable<GeneratorSpecificFuzzedValues<T>> {
	
	/**
	 * @return A list of section where each section contains fuzzed value that are created by the same generators.
	 */
	List<GeneratorSpecificFuzzedValues<T>> getGeneratorSpecificSections();
	
	/**
	 * Sets the list of sections of fuzzed values (one section for each generator).
	 * If sections are already contained they will be replaced.
	 * 
	 * @param value The list of section of fuzzed values to be contained.
	 */
	void setGeneratorSpecificSections(Collection<GeneratorSpecificFuzzedValues<T>> value);
	
	/**
	 * Adds a section of fuzzed values that are all created by the same generator.
	 * 
	 * @param value The section to be added.
	 */
	void addGeneratorSpecificSection(GeneratorSpecificFuzzedValues<T> value);

}
