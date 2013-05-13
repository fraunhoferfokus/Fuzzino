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

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.OperatorSpecificFuzzedValues;

public class OperatorSpecificFuzzedValuesImpl<T> implements OperatorSpecificFuzzedValues<T> {
	
	protected List<FuzzedValue<T>> fuzzedValues;
	protected String basedOn;
	protected String name;

	@Override
	public List<FuzzedValue<T>> getFuzzedValues() {
		return (fuzzedValues == null ? null : Collections.unmodifiableList(fuzzedValues));
	}

	@Override
	public void setFuzzedValues(List<FuzzedValue<T>> value) {
		fuzzedValues = value;
	}

	@Override
	public void addFuzzedValue(FuzzedValue<T> value) {
		if (fuzzedValues == null) {
			fuzzedValues = new ArrayList<>();
		}
		fuzzedValues.add(value);
	}

	@Override
	public String getBasedOn() {
		return basedOn;
	}

	@Override
	public void setBasedOn(String value) {
		basedOn = value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		name = value;
	}

	@Override
	public de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart getEMFRepresentation() {
		de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart
		  emfOperatorPart = ResponseFactory.eINSTANCE.createOperatorPart();
		
		for (FuzzedValue<T> fuzzedValue : fuzzedValues) {
			String fuzzedValueItself = fuzzedValue.getValue().toString();
			emfOperatorPart.getFuzzedValues().add(fuzzedValueItself);
		}
		emfOperatorPart.setBasedOn(getBasedOn());
		emfOperatorPart.setName(getName());
		
		return emfOperatorPart;
	}
	
	@Override
	public String toString() {
		return "[OperatorPart name:" + name + " basedOn:" + basedOn + " fuzzedValues:" + fuzzedValues.size() + "]";
	}

	@Override
	public Iterator<FuzzedValue<T>> iterator() {
		return fuzzedValues.iterator();
	}

}
