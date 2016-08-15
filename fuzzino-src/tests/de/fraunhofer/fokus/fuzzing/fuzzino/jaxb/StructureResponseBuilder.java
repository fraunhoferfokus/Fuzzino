package de.fraunhofer.fokus.fuzzing.fuzzino.jaxb;

import java.util.Arrays;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.structure.DeleteFieldOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StructureResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.FieldImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.StructureResponseImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.StructureImpl;

public class StructureResponseBuilder {

	public static StructureResponse initStructureResponse() {
		StructureResponse resp = new StructureResponseImpl();
		resp.setFuzzedStructures(initFuzzedStructures());
		resp.setId("fuzz struc id");
		resp.setMoreValuesAvailable(true);
		resp.setName("fuzz struc name");
		resp.setSeed(1234667);
		resp.setWarningsSection(StringResponseBuilder.initWarningsSection());
		return resp;
	}

	private static List<FuzzedValue<Structure>> initFuzzedStructures() {
		FuzzedValue<Structure> val1 = new FuzzedValue<>(initSimpleStructure(),initSimpleStructure(),new DeleteFieldOperator(initSimpleStructure(), 13));
		FuzzedValue<Structure> val2 = new FuzzedValue<>(initSimpleStructure(),initSimpleStructure(),new DeleteFieldOperator(initSimpleStructure(), 13));
		return Arrays.asList(val1,val2);
	}

	private static Structure initSimpleStructure() {
		Structure struc = new StructureImpl();
		struc.setFields(initFields());
		struc.setStructureSpecification(StructureRequestBuilder.initStructureSpec());
		return struc;
	}


	private static List<Field> initFields() {
		Field f1 = new FieldImpl();
		f1.setCorrespondingResponseId("corresponding id 1");
		f1.setName("f1");
		f1.setValueIsFuzzed(true);
		Field f2 = new FieldImpl();
		f2.setCorrespondingResponseId("corresponding id 2");
		f2.setName("f2");
		f2.setValueIsFuzzed(true);
		return Arrays.asList(f1,f2);
	}

}
