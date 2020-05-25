//   Copyright 2020 Fraunhofer FOKUS
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

/**
 * This class provides a method for decoding Unicode strings.
 * 
 * As an example, "AB\\x63 \\U00000031" would become "ABc 1"
 * 
 * @author Jasper v. Blanckenburg (jasper.von.blanckenburg@fokus.fraunhofer.de)
 *
 */
public class UnicodeDecoder {
	
	public static String decode(String value) {
		value = replaceUTF(value, "\\x", 2);
		value = replaceUTF(value, "\\u", 4);
		value = replaceUTF(value, "\\U", 8);
	    return value;
	}
	
	private static String replaceUTF(String value, String escapeBeginning, int hexDigitCount) {
	    int indexOf = 0;
	    while (indexOf >= 0) {
	        indexOf = value.indexOf(escapeBeginning, indexOf);
	        if (indexOf >= 0) {
	            String substring = value.substring(indexOf+2, indexOf+2+hexDigitCount);
	            int codePoint = -1;
	            try {
	                codePoint = Integer.parseInt(substring, 16);
	            } catch (NumberFormatException e) {
	                codePoint = -1;
	            }
	            if (codePoint >= 0) {
	                String encodedChar = new String(Character.toChars(codePoint));
	                value = value.replace(escapeBeginning + substring, encodedChar);
	                
	                indexOf = 0;
	            } else {
	                indexOf += 2 + hexDigitCount;
	            }
	        }
	    }
	    return value;
	}
	
}
