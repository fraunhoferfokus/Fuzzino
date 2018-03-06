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
package de.fraunhofer.fokus.fuzzing.fuzzino.jaxb;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.AllBadStringsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadDateGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string.DelimiterOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringSpecificationImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedValuesByGenerators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedValuesByOperators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FuzzedValuesByGeneratorsImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FuzzedValuesByOperatorsImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.GeneratorSpecificFuzzedValuesImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.NumberResponseImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.OperatorSpecificFuzzedValuesImpl;

public class NumberResponseBuilder {

	public static NumberResponse<Integer> initNumberResponse() {
		NumberResponseImpl<Integer> numResp = new NumberResponseImpl<>();
		numResp.setGeneratorBasedSection(initGeneratorBaseSection());
		numResp.setId("numResp id");
		numResp.setMoreValuesAvailable(true);
		numResp.setName("numResp name");
		numResp.setOperatorBasedSection(initOperatorBasedSection());
		numResp.setSeed(123);
		numResp.setWarningsSection(StringResponseBuilder.initWarningsSection());
		return numResp;
	}
	
	private static FuzzedValuesByOperators<Integer> initOperatorBasedSection() {
		FuzzedValuesByOperators<Integer> a = new FuzzedValuesByOperatorsImpl<Integer>();
		a.setOperatorSpecificSections(initOperatorSpecificSection());
		return a;
	}

	private static Collection<OperatorSpecificFuzzedValues<Integer>> initOperatorSpecificSection() {
		OperatorSpecificFuzzedValues<Integer> vals = new OperatorSpecificFuzzedValuesImpl<Integer>();
		vals.setFuzzedValues(initFuzzedValuesByOperator(initOperator()));
		vals.setName("name 1");
		OperatorSpecificFuzzedValues<Integer> vals2 = new OperatorSpecificFuzzedValuesImpl<Integer>();
		vals2.setFuzzedValues(initFuzzedValuesByOperator(initOperator()));
		vals2.setName("name 2");
		return Arrays.asList(vals,vals2);
	}

	private static List<FuzzedValue<Integer>> initFuzzedValuesByOperator(FuzzingHeuristic operator) {
		return Arrays.asList(
				new FuzzedValue<Integer>(48, 2,operator),
				new FuzzedValue<Integer>(72, 3,operator)
			);
	}

	private static FuzzingHeuristic initOperator() {
		return new DelimiterOperator(Arrays.asList("1","2"), new StringSpecificationImpl(), 25);
	}

	private static FuzzedValuesByGenerators<Integer> initGeneratorBaseSection() {
		FuzzedValuesByGenerators<Integer> a = new FuzzedValuesByGeneratorsImpl<>();
		a.setGeneratorSpecificSections(initGenSpecificSection());
		return a;
	}

	private static Collection<GeneratorSpecificFuzzedValues<Integer>> initGenSpecificSection() {
		GeneratorSpecificFuzzedValues<Integer> vals = new GeneratorSpecificFuzzedValuesImpl<Integer>();
		vals.setFuzzedValues(initFuzzedValues(new AllBadStringsGenerator(new StringSpecificationImpl(), 13)));
		vals.setName("name");
		GeneratorSpecificFuzzedValues<Integer> vals2 = new GeneratorSpecificFuzzedValuesImpl<Integer>();
		vals2.setFuzzedValues(initFuzzedValues(new BadDateGenerator(new StringSpecificationImpl(), 20)));
		vals2.setName("name 2");
		return Arrays.asList(vals,vals2);
	}

	private static List<FuzzedValue<Integer>> initFuzzedValues(FuzzingHeuristic heuristic) {
		return Arrays.asList(
				new FuzzedValue<Integer>(13, heuristic),
				new FuzzedValue<Integer>(24, heuristic)
			);
	}

}
