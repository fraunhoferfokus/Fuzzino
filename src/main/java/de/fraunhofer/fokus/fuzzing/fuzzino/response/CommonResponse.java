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

/**
 * The common base of all type specific responses. Setter methods are used by the fuzzing library.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface CommonResponse  {


	/**
	 * @return Identifier set by the library. It can be used to request further values from the library.
	 */
	String getId();

	/**
	 * Sets the identifier to be used for further requests.
	 * 
	 * @param value The identifier.
	 */
	void setId(String value);

	/**
	 * @return {@code true} if further values can be requeste from the library.
	 */
	boolean moreValuesAvailable();
	
	/**
	 * Sets the flag indicating whether more values can be requested from the library.
	 * 
	 * @param value Set to {@code true} if more values can be requested.
	 */
	void setMoreValuesAvailable(boolean value);

	/**
	 * @return The user-defined identifier taken from the request.
	 */
	String getName();
	
	/**
	 * Sets the name of the response. The name is user-defined and allows to identify
	 * for which request this is the response.
	 * 
	 * @param value The user-defined identifier (shall be identical to the request this is the response for).
	 */
	void setName(String value);
	
	/**
	 * @return The seed that was used for random-based fuzzing heuristics.
	 */
	long getSeed();
	
	/**
	 * Sets the seed that was used by the library for random-based fuzzing heuristics.
	 * 
	 * @param value The seed value.
	 */
	void setSeed(long value);

	/**
	 * @return The section containing all warnings resulting from malformed requests.
	 */
	WarningsSection getWarningsSection();
	
	/**
	 * Sets the warnings section.
	 * 
	 * @param value
	 */
	void setWarningsSection(WarningsSection value);

	
}
