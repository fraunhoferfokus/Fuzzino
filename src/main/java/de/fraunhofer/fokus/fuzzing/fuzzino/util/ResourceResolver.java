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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ResourceResolver {
	
	private final String BYTE_ORDER_MARK = "\uFEFF";
	private final String TEMPORARY_SCHEMA_FILE_NAME = "schema.temp.xsd";
	
	/**
	 * Loads a XML schema from a jar as an inputStream and returns a temporary file.
	 * 
	 * XML are processed by javax.xml.validation.SchemaFactory which needs a file. 
	 * Because all files are contained in a jar, we can only access the XML schema as an
	 * input stream. This method writes the schema input stream to a file, after
	 * deleting the byte order mark (BOM), which would corrupt the XML schema.
	 * 
	 * @param path
	 * @return
	 */
	public File loadSchemaFromJarAsNewFile(String path) {
		try {
			File schema = new File(path);
			
			if (schema.exists()) {
				return schema;
			}
			else 
			{
				InputStream inputStream = loadResource(path);
	
				// Convert InputStream to String to delete the byte order mark (BOM)
				String nonValidXmlString = new BufferedReader(new InputStreamReader(inputStream)).lines()
						.collect(Collectors.joining("\n"));
				String validXmlString = nonValidXmlString.replace(BYTE_ORDER_MARK, "");
	
				// Create temporary File
				File targetFile = new File(TEMPORARY_SCHEMA_FILE_NAME);
				targetFile.deleteOnExit();
	
				FileWriter outStream = new FileWriter(targetFile);
				outStream.write(validXmlString);
				outStream.flush();
				outStream.close();
				return targetFile;
			}
		}
		catch(IOException e) {
			throw new RuntimeException(e);
		}		
	}
	
	public InputStream loadResource(String fullPath) throws FileNotFoundException {
		// TODO check if called two times for overlappingRangesTest
		
		// Try loading via fileName and ClassLoader - for loading files from and within jar
		String fileInJar = getJarPathOfFile(fullPath);
		InputStream inputStream = loadViaClassLoader(fileInJar);
		
		// Try loading via path and file - for loading files from and within eclipse
		if (inputStream == null) {
			inputStream = loadViaFile(fullPath);
		}
		
		if (inputStream == null) {
			String message = "Could not find file in path \"" + fullPath + "\"." +
					"Neither could load \"" + fileInJar + "\" with classLoader.";
			throw new FileNotFoundException(message);
		}
		
		return inputStream;
	}
	
	public File loadProjectFile(String path) {
		return new File(path);
	}
		
	private InputStream loadViaClassLoader(String pathOrFilename) {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream(pathOrFilename);
	}
	
	/**
	 * The path of the files in the jar do not contain the part to the maven 
	 * resource directories (src/main/resources and src/test/resources).
	 * 
	 * @param path
	 * @return
	 */
	public String getJarPathOfFile(String path) {
		String alteredPath;
		
		if (path.contains(ResourcePath.MAIN_RESOURCE)) {
			alteredPath = path.replace(ResourcePath.MAIN_RESOURCE, "");			
		}
		else if (path.contains(ResourcePath.TEST_RESOURCE)) {
			alteredPath = path.replace(ResourcePath.TEST_RESOURCE, "");
		}
		else {
			return path;
		}
		
		// Replace all backslash with slash as the classLoader does not work with them
		return alteredPath.replaceAll("\\\\", "/");
	}

	private InputStream loadViaFile(String path) throws FileNotFoundException {
		File file = new File(path);
		return new FileInputStream(file);
	}
	
}
