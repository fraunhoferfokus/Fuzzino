package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.structure;

import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.StructureImpl;

public class StructureOperatorUtil {

	/***
	 * Creates a shallow copy of toCopy except for the fieldList, whcih will be a new List (so operators can change the arrangements of fields in the copy without changing the original
	 * @param toCopy
	 * @return
	 */
	public static Structure copyStructure(Structure toCopy) {
		List<Field> fuzzedFields = new LinkedList<>();
		fuzzedFields.addAll(toCopy.getFields());
		Structure copy = new StructureImpl();
		copy.setFields(fuzzedFields);
		copy.setStructureSpecification(toCopy.getSpecification());
		return copy;
	}

	public static void swapFields(Structure structure, int index,Integer swapIndex) {
		List<Field> fields = structure.getFields();
		Field temp = fields.get(index);
		fields.set(index,fields.get(swapIndex));
		fields.set(swapIndex, temp);
	}

	
}
