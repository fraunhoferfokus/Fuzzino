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
package de.fraunhofer.fokus.fuzzing.fuzzino.request.java.impl;

import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ValidationResult;

public class StructureSpecificationImpl implements StructureSpecification {

	private static final long serialVersionUID = -6724050878909567933L;
	protected List<Field> fields;
	protected boolean ordered;
	
	@Override
	public ValidationResult validate() {
		return new ValidationResult(true, null); // TODO
	}

	@Override
	public void addField(Field value) {
		getFields().add(value);
	}

	@Override
	public void setWithEMFObject(RequestSpecification emfRequestSpecification) {
		// TODO
	}

	@Override
	public List<Field> getFields() {
		if (fields == null) {
			fields = new LinkedList<>();
		}
		return fields;
	}

	@Override
	public void setFields(List<Field> value) {
		if (value != null) {
			fields = value;
		}
	}

	@Override
	public boolean isOrdered() {
		return ordered;
	}

	@Override
	public void setOrdered(boolean value) {
		ordered = value;
	}

}
