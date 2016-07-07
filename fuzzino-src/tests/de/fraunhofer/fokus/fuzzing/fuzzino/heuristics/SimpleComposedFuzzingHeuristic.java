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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.ConcreteValuesGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.SmallGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;

@SuppressWarnings("serial")
public class SimpleComposedFuzzingHeuristic extends ComposedFuzzingHeuristic<String> {

	private static final long NO_SEED = 4711;
	private static final StringSpecification STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
	private static final SmallGenerator OWNER = new SmallGenerator(STRING_SPEC, NO_SEED);
	
	public SimpleComposedFuzzingHeuristic() {
		super(NO_SEED);
		ConcreteValuesGenerator a = new ConcreteValuesGenerator(STRING_SPEC, NO_SEED, OWNER, "1A", "4A", "7A");

		ConcreteValuesGenerator b = new ConcreteValuesGenerator(STRING_SPEC, NO_SEED, OWNER, "2B", "5B");

		ConcreteValuesGenerator c = new ConcreteValuesGenerator(STRING_SPEC, NO_SEED, OWNER, "3C", "6C", "8C", "9C", "10C");
		
		heuristics.add(a);
		heuristics.add(b);
		heuristics.add(c);
}
	
	@Override
	public String getName() {
		return "SimpleComposedFuzzingHeuristic";
	}

}
