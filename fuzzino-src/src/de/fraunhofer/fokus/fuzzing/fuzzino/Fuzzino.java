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
   
package de.fraunhofer.fokus.fuzzing.fuzzino;

import java.util.ArrayList;
import java.util.List;

/**
 * The entry point of Fuzzino.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public final class Fuzzino {

	private static final String helpText = "Syntax: java -jar Fuzzino.jar [-encode] <requestFileName>\n" +
			                               "-encode Encodes all characters:\n" +
			                               "  \\x<nn>;      ASCII character\n" +
			                               "  \\u<nnnn>     16-bit Unicode character\n" +
			                               "  \\U<nnnnnnnn> 32-bit Unicode character\n" +
			                               "  n is a hexa-dezimal digit\n" +
			                               "  If this argument is omitted, only characters <= 32 and >=255 will be encoded.";
	private static final String version = "0.2.4.2";
	
	private static boolean encode = false;
	private static String filename = null;
	private static List<String> unknownOptions = new ArrayList<>();

	private Fuzzino() {
	}
	
	/**
	 * @return The version of the fuzzing library. 
	 */
	public static String getVersion() {
		return version;
	}
	
	/**
	 * This method forwards a string containing an XML request to Fuzzino.
	 * Using this method improves performances by omitting serialization and deserialization
	 * of the XML request (created by the caller) and of the XML response (created by Fuzzino).
	 * 
	 * @param xmlString A string containing a request in XML format.
	 * @return The response of Fuzzino as a string in XML format.
	 */
	public static String processXmlString(String xmlString) {
		return processXmlString(xmlString, false);
	}
	
	/**
	 * This method forwards a string containing an XML request to Fuzzino.
	 * Using this method improves performances by omitting serialization and deserialization
	 * of the XML request (created by the caller) and of the XML response (created by Fuzzino).
	 * Additionally, this method allows to activate encoding of all characters by the
	 * parameter {@code encodeAll}.
	 * 
	 * @param xmlString A string containing a request in XML format.
	 * @param encodeAll Set this parameter to {@code true} in order to activate encoding for all
	 *                   characters instead of only special characters (control chars, etc.).
	 * @return The response of Fuzzino as a string in XML format.
	 */
	public static String processXmlString(String xmlString, boolean encodeAll) {
		RequestDispatcher dispatcher = new  RequestDispatcher(xmlString);
		dispatcher.dispatch();
		return dispatcher.getXmlResponseString();
	}

	public static void main(String[] args) {
		System.out.println("Fuzzino v" + version + " developed by Fraunhofer FOKUS.");
		
		if (args.length > 2) {
			showHelpText();
			return;
		}
		
		for (String str : args) {
			if (str.startsWith("-")) {
				String optionName = str.substring(1);
				decodeOptionName(optionName);
			} else {
				filename = str;
			}
		}
		
		if (filename == null || !unknownOptions.isEmpty()) {
			showHelpText();
			return;
		}

		RequestDispatcher dispatcher = new RequestDispatcher(filename, encode);
		dispatcher.dispatch();
	}

	private static void showHelpText() {
		System.out.println(helpText);
	}

	private static void decodeOptionName(String optionName) {
		if (optionName.equals("encode")) {
			encode = true;
		} else {
			unknownOptions.add(optionName);
		}
	}
	
}
