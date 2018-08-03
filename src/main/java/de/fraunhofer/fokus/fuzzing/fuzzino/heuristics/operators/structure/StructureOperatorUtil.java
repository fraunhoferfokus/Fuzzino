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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.structure;

import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.Field;
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
