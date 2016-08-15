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

/**
 * A Generator requests a specific fuzzing generator to be used by the fuzzing library. 
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface Generator extends Serializable {
	
	/**
	 * @return The name of the requested generator.
	 */
	String getGeneratorName();
	
	/**
	 * Sets the name of the generator to be used by the fuzzing library.
	 *
	 * @param value The name of the generator. 
	 */
	void setGeneratorName(String value);
	
	/**
	 * @return The value of a parameter for this generator.
	 */
	String getParameter();
	
	/**
	 * Some generators may have a parameter that can be used in order to specify how the generator should work.
	 * If no parameter is set for a generator that may have one, its default value for the parameter is used.
	 * 
	 * @param value The value of a parameter for the generator.
	 */
	void setParameter(String value);
	
}
