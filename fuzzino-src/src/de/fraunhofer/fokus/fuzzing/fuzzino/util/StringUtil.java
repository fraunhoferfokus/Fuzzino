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
package de.fraunhofer.fokus.fuzzing.fuzzino.util;

import java.util.ArrayList;
import java.util.List;

/**
 * String utility class for fuzzing operators. 
 * 
 * @author Martin Schneider
 *
 */
public class StringUtil {

	/**
	 * Repeats a string.
	 * 
	 * @param str the string to be repeated.
	 * @param times the number of repetitions.
	 * @return the repeated string.
	 */
	public static String repeat(String str, int times) {
		StringBuilder buffer = new StringBuilder(str.length() * times);
		
		for (int i=0; i<times; i++) {
			buffer.append(str);
		}
	
		return buffer.toString();
	}
	
	/**
	 * Returns from a variable number of String parameters a <code>List&lt;String&gt;</code>
	 * 
	 * @param strings the variable number of Strings to be converted to a list.
	 * @return the list of strings.
	 */
	public static List<String> asList(String ...strings) {
		List<String> listOfStrings = new ArrayList<>(strings.length);
		for (int i=0; i < strings.length; i++) {
			listOfStrings.add(strings[i]);
		}
		
		return listOfStrings;
	}
	
	public static String normalize(String str) {
		return str.trim().toUpperCase();
	}
	
	public static int length(String str) {
		// FIXME compute length with respect to length("\x00")==1, length("\u0000")==1 and length("\U00000000")==1
		return str.length();
	}
	
}
