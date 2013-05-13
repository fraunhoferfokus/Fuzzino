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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.NumberRequest;

/**
 * This class contains the response to a {@link NumberRequest}.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 * @param <T>
 *
 */
public interface NumberResponse<T> extends CommonResponse {
	
	/**
	 * @return The section containing all fuzzed values that are created by fuzzing generators.
	 */
	FuzzedValuesByGenerators<T> getGeneratorBasedSection();
	
	/**
	 * Sets the section that contains all fuzzed values that are created by fuzzing generators.
	 * 
	 * @param value The section of fuzzed values that are created by fuzzing generators.
	 */
	void setGeneratorBasedSection(FuzzedValuesByGenerators<T> value);
	
	/**
	 * @return The section containing all fuzzed values that are created by fuzzing operators.
	 */
	FuzzedValuesByOperators<T> getOperatorBasedSection();
	
	/**
	 * Sets the section that contains all fuzzed values that are created by fuzzing operators.
	 * 
	 * @param value The section of fuzzed values that are created by fuzzing operators.
	 */
	void setOperatorBasedSection(FuzzedValuesByOperators<T> value);

	/**
	 * @return Returns the corresponding EMF object {@link de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse}
	 *         initialized with the values of this response.
	 */
	de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse getEMFRepresentation();
	
}
