package de.fraunhofer.fokus.fuzzing.fuzzino.jaxb;

import java.util.ArrayList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.FieldImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.OperatorImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StructureRequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StructureSpecificationImpl;

public class StructureRequestBuilder {

	public static StructureRequest initStructureRequest() {
		StructureRequestImpl req = new StructureRequestImpl();
		req.setFuzzStructure(true);
		req.setId("my structure req id");
		req.setMaxMutations(1337);
		req.setMaxValues(12345);req.setMinMutations(321);
		req.setName("my structure req name");
		req.setRequestedOperators(initStructureOperators());
		req.setSeed(54);
		req.setSpecification(initStructureSpec());
		return req;
	}

	static StructureSpecification initStructureSpec() {
		StructureSpecification spec = new StructureSpecificationImpl();
		spec.setOrdered(true);
		//field 1:
		Field field1 =  new FieldImpl();
		field1.setFuzz(true);
		field1.setName("f1");
		field1.setCorrespondingRequestId("id1");
		//field 2:
		Field field2 =  new FieldImpl();
		field2.setFuzz(false);
		field2.setName("f2");
		field2.setCorrespondingRequestId("id2");
		//field 3:
		Field field3 = new FieldImpl();
		field3.setFuzz(true);
		field3.setName("f3");
		field3.setCorrespondingRequestId("id3");
		spec.addField(field1);
		spec.addField(field2);
		//spec.addField(field3);
		return spec;
	}

	private static List<Operator> initStructureOperators() {
		List<Operator> list = new ArrayList<>();
		list.add(new OperatorImpl("my first operator"));
		list.add(new OperatorImpl("my second operator"));
		Operator op = new OperatorImpl("my third operator");
		op.setParameter("param1");
		list.add(op);
		return list;
	}

}
