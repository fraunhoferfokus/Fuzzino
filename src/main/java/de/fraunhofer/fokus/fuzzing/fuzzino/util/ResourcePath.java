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

import java.io.File;

/**
 * Contains paths of local resources.
 * @author rwi
 *
 */
public class ResourcePath {
	// INTERNAL PATHS
	public final static String fs = File.separator;
	public final static String MAIN_RESOURCE = "src"+ fs + "main" + fs + "resources" + fs;
	public final static String TEST_RESOURCE = "src"+ fs + "test" + fs + "resources" + fs;
	
	public final static String SCHEMA_DIRECTORY = MAIN_RESOURCE + "schemas" + fs;
	public final static String FUZZINO_FILES = System.getProperty("user.home") + fs + "FuzzinoFiles";
	public final static String DATA_SPEC = MAIN_RESOURCE + "DataSpec" + fs;
	public final static String FUZZING_VALUES = MAIN_RESOURCE + fs + "FuzzingValues" + fs;

}
