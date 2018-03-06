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

import java.math.BigInteger;

/**
 * A NumberSpecification is a description of a type of a request. It gives hints to the fuzzing 
 * library that reduces the set of fuzz testing values in a reasonable way by omitting values
 * that are not appropriate to this specification.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface IntegerSpecification extends TypeSpecification, NumberSpecification<Long> {
	
	/**
	 * @return {@code true} if {@link #getMinValueBig()}{@code < {@link Long#MIN_VALUE} {@code || }{@link #getMinValueBig()}{@code > {@link Long#MAX_VALUE}. 
	 */
	boolean isMinValueBig();
	
	/**
	 * @return The smallest valid number.
	 */
	BigInteger getMinValueBig();
	
	/**
	 * Specifiest the smallest valid number as a BigInteger.
	 * 
	 * @param value
	 */
	void setMinValue(BigInteger value);
	
	/**
	 * @return {@code true} if {@link #getMaxValueBig()}{@code < {@link Long#MIN_VALUE} {@code || }{@link #getMaxValueBig()}{@code > {@link Long#MAX_VALUE}. 
	 */
	boolean isMaxValueBig();
	
	/**
	 * @return The biggest valid number.
	 */
	BigInteger getMaxValueBig();
	
	void setMaxValue(BigInteger value);
	
	/**
	 * @return The number of bits that is used for the representation of the number.
	 */
	int getBits();
	
	/**
	 * Specifies the number of bits that is used for the representation of the number.
	 * If this attribute is not set, it has the default value 32.
	 * 
	 * @param value The number of bits that is used for the representation of the number.
	 */
	void setBits(int value);
	
	/**
	 * @return {@code true} if the specified value is signed.
	 */
	boolean isSigned();
	
	/**
	 * Specifies whether the number is signed.
	 * If this attribute is not set, is has the default value {@code true}.
	 * 
	 * @param value Set to {@code true} if the number is a a signed value.
	 */
	void setIsSigned(boolean value);
	
	/**
	 * Specifies whether {@link #getMinValue()} and {@link #getMaxValue()} shall be ignored.
	 * 
	 * @param value Set to {@code true} to let the library ignore {@link #getMinValue()} and {@link #getMaxValue()}.
	 */
	void setIgnoreMinMaxValues(boolean value);
	
	/**
	 * @return {@code true} if {@link #getMinValue()} and {@link #getMaxValue()} shall be ignored.
	 */
	boolean ignoreMinMaxValues();
	
	/**
	 * @return {@code true} if {@link #getType()} {@code ==} {@link NumberType#INTEGER} and {@link #getBits()} {@code <= 64}.
	 */
	boolean isLongCompatible();
	
	/**
	 * @return {@code true} if {@link #getType()} {@code ==} {@link NumberType#INTEGER} and {@link #getBits()} {@code > 64}.
	 */
	boolean isBigIntegerCompatible();

}
