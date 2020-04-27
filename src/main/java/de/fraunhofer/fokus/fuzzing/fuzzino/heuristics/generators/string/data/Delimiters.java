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

import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class Delimiters extends StringContainer {
	
	public static final Delimiters INSTANCE = new Delimiters();
	
	private Delimiters() {
		super();
	}

	@Override
	protected void initValues() {
		add(" ");
		add("");
		add("\\x09");
		add(StringUtil.repeat("\\x09", 2));
		add(StringUtil.repeat("\\x09", 100));
		add(StringUtil.repeat("\\x09\\x0D\\0A", 100));
		add("!");
		add("@");
		add("#");
		add("$");
		add("%");
		add("^");
		add("&");
		add("*");
		add("(");
		add(")");
		add("-");
		add("_");
		add("+");
		add("=");
		add(":");
		add(StringUtil.repeat(":", 100));
		add(StringUtil.repeat(":7", 100));
		add(";");
		add("'");
		add("\\");
		add("/");
		add("\\\\");
		add("?");
		add("\\x3C");
		add("\\3E");
		add(".");
		add(",");
		add("\\x0D");
		add("\\x0A");
		add("\"");
		add(StringUtil.repeat("\\x0D\\x0A", 64));
		add(StringUtil.repeat("\\x0D\\x0A", 128));
		add(StringUtil.repeat("\\x0D\\x0A", 512));
	}

}
