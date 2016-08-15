package de.fraunhofer.fokus.fuzzing.fuzzino.jaxb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValuesSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.GeneratorImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.IntegerSpecificationImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.NumberRequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.OperatorImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidValuesSectionImpl;

public class NumberRequestBuilder {

	public static NumberRequestImpl initNumberRequest() {
		NumberRequestImpl req = new NumberRequestImpl();
		req.setId("my number request id");
		req.setMaxValues(200);
		req.setName("number request 1");
		req.setNumberSpecification(initIntegerSpecification());
		req.setRequestedGenerators(initNumberGenList());
		req.setSeed(99);
		req.setUseNoGenerators(true);
		req.setValidValuesSection(inintValidNumbersSection());
		return req;
	}

	private static ValidValuesSection inintValidNumbersSection() {
		ValidValuesSection vals = new ValidValuesSectionImpl();
		vals.setRequestedOperators(initNumberOperators());
		vals.setValues(Arrays.asList("11","12","13","14"));
		return vals;
	}

	private static List<Operator> initNumberOperators() {
		List<Operator> ops = new ArrayList<>();
		ops.add(new OperatorImpl("number operator 1"));
		ops.add(new OperatorImpl("number operator 2"));
		Operator op3 = new OperatorImpl("number operator 3");
		op3.setParameter("op3 param");
		ops.add(op3);
		return ops;
	}

	private static List<Generator> initNumberGenList() {
		List<Generator> list = new ArrayList<>();
		list.add(new GeneratorImpl("number gen 1"));
		Generator gen2 = new GeneratorImpl("number gen 2");
		gen2.setParameter("param 2");
		list.add(gen2);
		return list;
	}

	private static NumberSpecification<? extends Number> initIntegerSpecification() {
		IntegerSpecification spec = new IntegerSpecificationImpl();
		spec.setBits(16);
		spec.setIgnoreMinMaxValues(true);
		spec.setIsSigned(false);
		spec.setMax(1000L);
		spec.setMin(57L);
		return spec;
	}

}
