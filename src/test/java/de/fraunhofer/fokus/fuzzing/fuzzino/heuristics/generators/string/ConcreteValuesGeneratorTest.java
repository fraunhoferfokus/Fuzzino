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

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringEncoding;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringSpecificationImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class ConcreteValuesGeneratorTest extends FuzzinoTest {

	@Test
	public void testBug_dublicateValuesInConreteGenerator(){
		StringSpecification sP = new StringSpecificationImpl();
		sP.setType(StringType.get("XSS"));
		sP.setMinLength(1);
		sP.setMaxLength(1000);
		sP.setIsNullTerminated(true);
		sP.setEncoding(StringEncoding.get("ASCII"));
		sP.setIgnoreLengths(true);
		AllBadStringsGenerator owner = new AllBadStringsGenerator(sP, 0);
		ConcreteValuesGenerator gen1 = new ConcreteValuesGenerator(sP, 0, Arrays.asList(owner),"test1","test2");
		gen1.addAll(StringUtil.asList("test3","test4"));
		Iterator<FuzzedValue<String>> it = gen1.iterator();
		List<String> allValues= StringUtil.asList("test1","test2","test3","test4");
		while(it.hasNext()){
			allValues.remove(it.next());
		}
	}	

}
