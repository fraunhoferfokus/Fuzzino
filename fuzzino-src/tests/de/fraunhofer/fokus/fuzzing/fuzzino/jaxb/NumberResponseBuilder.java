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
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedValuesByGenerators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedValuesByOperators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.GeneratorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.OperatorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.FuzzedValuesByGeneratorsImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.FuzzedValuesByOperatorsImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.GeneratorSpecificFuzzedValuesImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.NumberResponseImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.OperatorSpecificFuzzedValuesImpl;

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
