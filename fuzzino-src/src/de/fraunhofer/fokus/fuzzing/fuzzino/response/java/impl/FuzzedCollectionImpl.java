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
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Value;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class FuzzedCollectionImpl implements FuzzedCollection {

	protected List<Value> values;
	@XmlAttribute
	protected String basedOn;
	@XmlAttribute
	protected int mutations;
	@XmlAttribute
	protected String operators;
	
	@Override
	@XmlElement(name = "value",type = ValueImpl.class)
	public List<Value> getValues() {
		if (values == null) {
			values = new ArrayList<>();
		}
		return values;
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
	public int getMutations() {
		return mutations;
	}

	@Override
	public void setMutations(int value) {
		mutations = value;
	}

	@Override
	public String getOperators() {
		return operators;
	}

	@Override
	public void setOperators(String value) {
		operators = value;
	}
	
	@Override
	public String toString() {
		return "[FuzzedCollection basedOn:" + basedOn + " mutations:" + mutations + " operators:" + operators + " values:" + values.size() + "]";
	}

	@Override
	public void initWithValidCollection(ValidCollection validCollection) {
		FuzzedCollection fuzzedCollection = de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ResponseFactory.INSTANCE.createFuzzedCollection();
		for (String validValue : validCollection.getValues()) {
			Value value = de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ResponseFactory.INSTANCE.createValue();
			value.setValue(validValue);
			fuzzedCollection.getValues().add(value);
		}
	}

	@Override
	public Value get(int index) {
		return values.get(index);
	}

	@Override
	public int size() {
		return values.size();
	}

	@Override
	public Iterator<Value> iterator() {
		return values.iterator();
	}

}
