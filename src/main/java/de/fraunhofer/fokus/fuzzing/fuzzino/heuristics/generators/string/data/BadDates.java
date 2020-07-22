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

public final class BadDates extends StringContainer {
	
	public final static BadDates INSTANCE = new BadDates();
	
	private BadDates() {
		super();
	}

	@Override
	protected void initValues() {
		add("1/1/1");
		add("0/0/0");
		add("0-0-0");
		add("00-00-00");
		add("-1/-1/-1");
		add("XX/XX/XX");
		add("-1-1-1-1-1-1-1-1-1-1-1-");
		add("Jun 39th 1999");
		add("June -1th 1999");
		
		add("2000");
		add("1997");
		add("0000");
		add("0001");
		add("9999");
		
		add("0000-00");
		add("0000-01");
		add("0000-99");
		add("0000-13");
		add("0001-00");
		add("0001-01");
		add("0001-99");
		add("0001-13");
		add("9999-00");
		add("9999-01");
		add("9999-99");
		add("9999-13");
				
		add("0000-00-00");
		add("0000-01-00");
		add("0000-99-00");
		add("0000-13-00");
		add("0001-00-00");
		add("0001-01-00");
		add("0001-99-00");
		add("0001-13-00");
		add("9999-00-00");
		add("9999-01-00");
		add("9999-99-00");
		add("9999-13-00");
		add("0000-00-01");
		add("0000-01-01");
		add("0000-99-01");
		add("0000-13-01");
		add("0001-00-01");
		add("0001-01-01");
		add("0001-99-01");
		add("0001-13-01");
		add("9999-00-01");
		add("9999-01-01");
		add("9999-99-01");
		add("9999-13-01");
		add("0000-00-99");
		add("0000-01-99");
		add("0000-99-99");
		add("0000-13-99");
		add("0001-00-99");
		add("0001-01-99");
		add("0001-99-99");
		add("0001-13-99");
		add("9999-00-99");
		add("9999-01-99");
		add("9999-99-99");
		add("9999-13-99");
	}

}
