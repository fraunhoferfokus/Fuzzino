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

import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Field;

public class FieldImpl<T> implements Field<T> {
	
	protected T value;
	protected boolean fuzz;
	private String name;

	@Override
	public boolean isValueFuzzed() {
		return fuzz;
	}

	@Override
	public void setValueIsFuzzed(boolean value) {
		fuzz = value;
	}

	@Override
	public de.fraunhofer.fokus.fuzzing.fuzzino.response.Field getEMFRepresentation() {
		de.fraunhofer.fokus.fuzzing.fuzzino.response.Field emfField = ResponseFactory.eINSTANCE.createField();
		
		emfField.setFuzz(isValueFuzzed());
		
		return emfField;
	}
	
	@Override
	public String toString() {
		return "[Field value:" + value + " fuzz:" + fuzz + "]";
	}

	@Override
	public T getValue() {
		return value;
	}

	@Override
	public void setValue(T value) {
		this.value = value;
		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

}
