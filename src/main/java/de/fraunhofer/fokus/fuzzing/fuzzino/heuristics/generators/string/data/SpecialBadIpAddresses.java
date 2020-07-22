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

public class SpecialBadIpAddresses extends StringContainer {
	
	public static final SpecialBadIpAddresses INSTANCE = new SpecialBadIpAddresses();
	
	private SpecialBadIpAddresses() {
		super();
	}

	@Override
	protected void initValues() {
		add("0");
		add("0.");
		add("1.");
		add("1.1");
		add("1.1.1");
		add("1.1.1.1.");
		add("1.1.1.1.1");
		add(".1");
		add(".1.1.1");
		add(".1.1.1.1");
		add("1.1.1.1\\x00AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		add("0.0.0.0");
		add("127.0.0.1");
		add("255.255.255");
		add("256.256.256");
		add("-1.-1.-1.-1");
		add("FF.FF.FF");
		add("\\x0.\\x00.\\x00.\\x00");
		add("\\x01.\\x01.\\x01.\\x01");
		add("1\\x00.1\\x00.1\\x00.1\\x00");
		add("1\\x00.\\x01\\x00.\\x01\\x00.\\x01\\x00");
		add("0\\x00.\\x00\\x00.\\x00\\x00.\\x00\\x00");
		add("999.999.999");
	}

}
