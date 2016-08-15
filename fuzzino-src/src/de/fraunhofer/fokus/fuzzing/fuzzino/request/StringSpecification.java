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
 * A StringSpecification is a description of a type for a {@link StringRequest}. It gives hints
 * to the fuzzing library that reduces the set of fuzz testing values in a reasonable way by
 * omitting values or generating values that do not match this specification.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface StringSpecification extends TypeSpecification {

	/**
	 * @return The type of the string. The possible values are specified by {@link StringType}.
	 */
	StringType getType();
	
	/**
	 * By setting this attribute the format of the string can be constrained.
	 * If this attribute is not set, it has the default value String.
	 * The possible types are specified by {@link StringType}.
	 * 
	 * @param value The type of the string.
	 */
	void setType(StringType value);
	
	/**
	 * @return The minimal length of a valid string.
	 */
	int getMinLength();
	
	/**
	 * @return The maximal length of a valid string.
	 */
	int getMaxLength();
	
	/**
	 * Sets the minimal length of a valid string.
	 *  
	 * @param value The minimal length of a valid string.
	 */
	void setMinLength(int value);
	
	/**
	 * Sets the maximal length of a valid string.
	 * 
	 * @param value The maximal length of a valid string.
	 */
	void setMaxLength(int value);
	
	/**
	 * @return {@code true} if a string is terminated by a null character. 
	 */
	boolean isNullTerminated();
	
	/**
	 * Specifies whether a string is terminated by a null character, e.g. like C strings.
	 * If this attribute is not set, it has the default value {@code false}.
	 * 
	 * @param value Set to {@code true} if the string is terminated by a null character.
	 */
	void setIsNullTerminated(boolean value);
	
	/**
	 * @return The encoding of the string. The possible values are specified by {@link StringEncoding}.
	 */
	StringEncoding getEncoding();
	
	/**
	 * Specifies the encoding that is used by the SUT and hence determines the available character set.
	 * It does not describe the encoding that is used for {@link ValidValuesSection} within a {@link StringRequest} or
	 * that shall be used by the fuzzing library for the response.
	 * If this attribute is not set, it has the default value {@link StringEncoding#ASCII}.
	 * 
	 * @param value The encoding of the string.
	 */
	void setEncoding(StringEncoding value);
	
	String getRegEx();
	
	/**
	 * If {@code getType() == StringType.REGEX_FOR_VALIDVALUES || getType() == REGEEX_FOR_INVALIDVALUES}, 
	 * valid respectively invalid values can be specified by a regular expression.
	 * 
	 * @param value A regular expression specifying either valid or invalid values.
	 */
	void setRegEx(String value);
	
	/**
	 * @return A {@link IntegerSpecification} whose {@link IntegerSpecification#getMinValue()} and 
	 *         {@link IntegerSpecification#getMaxValue()} matches {@link #getMinLength()} and 
	 *         {@link #getMaxLength()} providing the values >= 0.
	 */
	IntegerSpecification createPositiveNumberSpec();

	/**
	 * @return A {@link IntegerSpecification} whose {@link IntegerSpecification#getMinValue()} and 
	 *         {@link IntegerSpecification#getMaxValue()} matches {@link #getMinLength()} and 
	 *         {@link #getMaxLength()} providing the values < 0.
	 */
	IntegerSpecification createNegativeNumberSpec();
	
	/**
	 * Set this value in order to specify if the length shall be ignored. // TODO why?
	 * 
	 * @param value Set to {@code true} to indicate that the length values shall be ignored.
	 */
	void setIgnoreLengths(boolean value);
	
	/**
	 * @return {@code true} if the length values shall be ignored and any length is valid.
	 */
	boolean ignoreLengths();

}
