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
package de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedStructure;

public class FuzzedStructureImpl implements FuzzedStructure {

	protected List<Field> fields;
	protected int mutations;
	protected Object operators;
	
	@Override
	public List<Field> getFields() {
		return Collections.unmodifiableList(fields);
	}

	@Override
	public void setFields(List<Field> value) {
		fields = value;
	}

	@Override
	public void addField(Field value) {
		if (fields == null) {
			fields = new ArrayList<>();
		}
		fields.add(value);
	}

	@Override
	public int getMutations() {
		return mutations;
	}

	@Override
	public void setMutations(int value) {
		mutations = value;
	}

	@Override
	public Object getOperators() {
		return operators;
	}

	@Override
	public void setOperators(Object value) {
		operators = value;
	}

	@Override
	public de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedStructure getEMFRepresentation() {
		de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedStructure
		  emfFuzzedStructure = ResponseFactory.eINSTANCE.createFuzzedStructure();
		
		for (Field field : fields) {
			emfFuzzedStructure.getFields().add(field.getEMFRepresentation());
		}
		emfFuzzedStructure.setMutations(getMutations());
		emfFuzzedStructure.setOperators(getOperators());
		
		return emfFuzzedStructure;
	}
	
	@Override
	public String toString() {
		return "[FuzzedStructure mutations:" + mutations + " operators:" + operators + " fields:" + fields + "]";
	}

	@Override
	public Iterator<Field> iterator() {
		return fields.iterator();
	}

}
