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

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.IllegalStringEncodingException;

/**
 * The character encoding of a string.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public enum StringEncoding {

	ASCII,
	UTF8,
	UTF16,
	UTF32;
	
	private static final Map<String, StringEncoding> mapping = new HashMap<>();
	static {
		mapping.put("", ASCII);
		mapping.put("ASCII".toUpperCase(), ASCII);
		mapping.put("UTF-8".toUpperCase(), UTF8);
		mapping.put("UTF8".toUpperCase(), UTF8);
		mapping.put("UTF-16".toUpperCase(), UTF16);
		mapping.put("UTF16".toUpperCase(), UTF16);
		mapping.put("UTF-32".toUpperCase(), UTF32);
		mapping.put("UTF32".toUpperCase(), UTF32);
	}
	
	/**
	 * Returns the appropriate literal for a given string.
	 * 
	 * @param type The name of string encoding the literal is requested for.
	 * @return the appropriate enum literal for {@code type}.
	 * @throws IllegalStringEncodingException If no literal is known for the given {@code type}, this exception is thrown.
	 */
	public static StringEncoding get(String encoding) throws IllegalStringEncodingException {
		String canonicalEncoding = encoding.trim().replace("-","").toUpperCase();
		
		StringEncoding result = mapping.get(canonicalEncoding);
		if (result == null) {
			throw new IllegalStringEncodingException(encoding);
		}
		return result;
	}
}
