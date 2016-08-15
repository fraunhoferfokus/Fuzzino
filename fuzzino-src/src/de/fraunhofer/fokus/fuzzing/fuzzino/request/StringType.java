//   Copyright 2012-2014 Fraunhofer FOKUS
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

import java.util.HashMap;
import java.util.Map;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.IllegalStringTypeException;

/**
 * The function or type of a string, e.g. string, filename or IP address.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public enum StringType {

	STRING,
	SQL,
	PATH,
	FILENAME,
	HOSTNAME,
	DELIMITER,
	REGEX_FOR_VALIDVALUES,
	REGEEX_FOR_INVALIDVALUES,
	NUMBER,
	COMMAND,
	DATE,
	TIME,
	IP_ADDRESS,
	PIN4DIGIT,
	XML,
	XSS;
	
	private static final Map<String, StringType> mapping = new HashMap<>();
	static {
		mapping.put("", STRING);
		mapping.put("String".toUpperCase(), STRING);
		mapping.put("SQL".toUpperCase(), SQL);
		mapping.put("Path".toUpperCase(), PATH);
		mapping.put("Filename".toUpperCase(), FILENAME);
		mapping.put("Hostname".toUpperCase(), HOSTNAME);
		mapping.put("Delimiter".toUpperCase(), DELIMITER);
		mapping.put("RegExValid".toUpperCase(), REGEX_FOR_VALIDVALUES);
		mapping.put("RegExInvalid".toUpperCase(), REGEEX_FOR_INVALIDVALUES);
		mapping.put("Number".toUpperCase(), NUMBER);
		mapping.put("Command".toUpperCase(), COMMAND);
		mapping.put("Date".toUpperCase(), DATE);
		mapping.put("Time".toUpperCase(), TIME);
		mapping.put("IPAddress".toUpperCase(), IP_ADDRESS);
		mapping.put("PIN4Digit".toUpperCase(), PIN4DIGIT);
		mapping.put("XML".toUpperCase(), XML);
		mapping.put("XSS".toUpperCase(), XSS);
	}
	
	/**
	 * Returns the appropriate literal for a given string.
	 * 
	 * @param type The name of string type the literal is requested for.
	 * @return the appropriate enum literal for {@code type}.
	 * @throws IllegalStringTypeException If no literal is known for the given {@code type}, this exception is thrown.
	 */
	public static StringType get(String type) throws IllegalStringTypeException {
		String canonicalType = type.trim().toUpperCase();
		
		StringType result = mapping.get(canonicalType);
		if (result == null) {
			throw new IllegalStringTypeException(type);
		}
		return result;
	}
	
}
