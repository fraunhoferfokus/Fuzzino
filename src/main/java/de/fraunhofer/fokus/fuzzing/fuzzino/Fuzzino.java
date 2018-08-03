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
   
package de.fraunhofer.fokus.fuzzing.fuzzino;

import java.util.ArrayList;
import java.util.List;

/**
<<<<<<< HEAD
 * The entry point of Fuzzino.
=======
 * <p>
 * This class is the entry point of Fuzzino.
 * </p>
 * <p>
 * 1. Use Fuzzino as a command line tool:<br>
 * Build the project with Maven and use {@code java -jar Fuzzino.jar [-encode]
 * <requestFileName>} on the command line to pass a XML file to Fuzzino to
 * process. Fuzzino will create a file "&ltrequestFileName&gt.response.xml" in
 * the directory of the input file, that either contains the response or, if the
 * execution failed, an exception.
 * </p>
 * <p>
 * 2. Pass XML strings directly to Fuzzino:<br>
 * Use either one of the two methods {@link #processXmlString(String)} or
 * {@link #processXmlString(String)} to pass a XML file as Java string. This
 * avoids time-consuming serialization and deserialization.
 * </p>
 * <p>
 * 3. Use heuristics directly: <br>
 * There exists multiple factory classes that list all existing heuristics. You
 * can create generators by using the factories defined in package
 * {@link de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators
 * fuzzino.heuristics.generators} and you can create operators by using the
 * factories defined in package
 * {@link de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators
 * fuzzino.heuristics.operators}. Alternatively you can also directly
 * instantiate the heuristics.
 * </p>
>>>>>>> 82b7d95... added some javadoc
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
	private static final String version = "0.6.0.1";
	
	private static boolean encode = false;
	private static String filename = null;
	private static List<String> unknownOptions = new ArrayList<>();

	private Fuzzino() {
	}
	
	/**
	 * Get the current version of Fuzzino.
	 * 
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

	/**
	 * After it was invoked by executing the {@code Fuzzino.jar}, this method
	 * handles command-line parameters and forwards execution to the
	 * {@link RequestDispatcher}.
	 * 
	 * @param args
	 */
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
