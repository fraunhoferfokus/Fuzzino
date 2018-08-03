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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

public class XSSOpenHTMLTagVarianceGenerator extends ComposedStringGenerator {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2577010930240145001L;

	public XSSOpenHTMLTagVarianceGenerator(StringSpecification stringSpec,long seed) {
		super(stringSpec, seed);
		initHeuristics();
	}
	
	public XSSOpenHTMLTagVarianceGenerator(StringSpecification stringSpec,long seed,ComputableFuzzingHeuristic<?> owner) {
		super(stringSpec, seed, owner);
		initHeuristics();
	}
	
	private void initHeuristics() {
		//TODO: maybe make the hardcoded javascript function call (alert) dynamic?
		ConcreteValuesGenerator openHTMLTagsGen = new ConcreteValuesGenerator(stringSpec, seed, owner, 
				"<",
				"%3C",
				"&lt",
				"&lt;",
				"&LT",
				"&LT;",
				"&#60",
				"&#060",
				"&#0060",
				"&#00060",
				"&#000060",
				"&#0000060",
				"&#60;",
				"&#060;",
				"&#0060;",
				"&#00060;",
				"&#000060;",
				"&#0000060;",
				"&#x3c",
				"&#x03c",
				"&#x003c",
				"&#x0003c",
				"&#x00003c",
				"&#x000003c",
				"&#x3c;",
				"&#x03c;",
				"&#x003c;",
				"&#x0003c;",
				"&#x00003c;",
				"&#x000003c;",
				"&#X3c",
				"&#X03c",
				"&#X003c",
				"&#X0003c",
				"&#X00003c",
				"&#X000003c",
				"&#X3c;",
				"&#X03c;",
				"&#X003c;",
				"&#X0003c;",
				"&#X00003c;",
				"&#X000003c;",
				"&#x3C",
				"&#x03C",
				"&#x003C",
				"&#x0003C",
				"&#x00003C",
				"&#x000003C",
				"&#x3C;",
				"&#x03C;",
				"&#x003C;",
				"&#x0003C;",
				"&#x00003C;",
				"&#x000003C;",
				"&#X3C",
				"&#X03C",
				"&#X003C",
				"&#X0003C",
				"&#X00003C",
				"&#X000003C",
				"&#X3C;",
				"&#X03C;",
				"&#X003C;",
				"&#X0003C;",
				"&#X00003C;",
				"&#X000003C;",
				"\\x3c",
				"\\x3C",
				"\\u003c",
				"\\u003C"
		);
		ConcreteValuesGenerator restCommand = new ConcreteValuesGenerator(stringSpec, seed, owner, "IMG SRC=\"javascript:alert('XSS');\">");
		heuristics.add(new Combinator(stringSpec,seed,owner,openHTMLTagsGen,restCommand));
		
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		return stringSpec.getType().equals(StringType.XSS);
	}

	@Override
	public String getName() {
		return "XSSOpenHTMLTagVariance";
	}

}
