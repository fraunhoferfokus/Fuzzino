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

import java.util.HashMap;
import java.util.Map;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.IllegalNumberTypeException;

/**
 * The type of a number, either integer or float.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public enum NumberType {

	/**
	 * Represents all kinds of integers, signed or unsigned, independent of the number bits.
	 */
	INTEGER,
	
	/**
	 * Represents all kinds of decimals, signed or unsigned, independent of the number of bits. 
	 */
	FLOAT;
	
	private static final Map<String, NumberType> mapping = new HashMap<>();
	static {
		mapping.put("integer".toUpperCase(), INTEGER);
		mapping.put("float".toUpperCase(), FLOAT);
	}
	
	/**
	 * Returns the appropriate literal for a given string.
	 * 
	 * @param type The name of the number type the literal is requested for.
	 * @return The appropriate enum literal for {@code type}.
	 * @throws IllegalNumberTypeException If no literal is known for the given {@code type}, this exception is thrown.
	 */
	public static NumberType get(String type) throws IllegalNumberTypeException {
		String canonicalType = type.trim().toUpperCase();
		
		NumberType result = mapping.get(canonicalType);
		if (result == null) {
			throw new IllegalNumberTypeException(type);
		}
		return result;
	}
	
}
