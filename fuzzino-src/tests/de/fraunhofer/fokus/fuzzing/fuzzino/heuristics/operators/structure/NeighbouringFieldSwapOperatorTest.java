package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.structure;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.FieldImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.StructureImpl;

public class NeighbouringFieldSwapOperatorTest extends FuzzinoTest {

	private static final long SEED = 10;

	@Test
	public void test() {
		int fieldCount = 10;
		NeighbouringFieldSwapOperator op = new NeighbouringFieldSwapOperator(getExampleStructure(fieldCount),SEED);
		assertEquals(fieldCount-1,op.size());
		for(int i=0;i<op.size();i++){
			//assert the swapping occured correctly:
			FuzzedValue<Structure> fuzzedStructure = op.computeElement(i);
			Structure original = fuzzedStructure.getBasedOnValue();
			Structure mutated = fuzzedStructure.getValue();
			assertEquals(original.getFields().get(i),mutated.getFields().get(i+1));
			assertEquals(original.getFields().get(i+1),mutated.getFields().get(i));
		}
	}

	private Structure getExampleStructure(int fieldCount) {
		LinkedList<Field> fields = new LinkedList<>();
		//fill fieldList:
		for(int i =0;i<fieldCount;i++){
			FieldImpl a = new FieldImpl();
			a.setCorrespondingResponseId("nobody cares since this is just an example");
			fields.add(a);
		}
		Structure struc = new StructureImpl();
		struc.setFields(fields);
		return struc;
	}

}
