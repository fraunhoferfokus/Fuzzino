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
package de.fraunhofer.fokus.fuzzing.fuzzino.request.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class ValidCollectionImpl implements ValidCollection {

	private static final long serialVersionUID = 836742306845945843L;
	protected List<String> values;
	@XmlAttribute
	protected String name = null;
	
	public ValidCollectionImpl(){
	}
	
	public ValidCollectionImpl(String name, String... values) {
		this.name = name;
		this.values = Arrays.asList(values);
	}

	@Override
	@XmlElement(name = "value")
	public List<String> getValues() {
		if (values == null) {
			values = new ArrayList<>();
		}
		return values;
	}
	
	@Override
	public void setValues(List<String> value) {
		getValues().addAll(value);
	}
	
	@Override
	public void addValue(String value) {
		getValues().add(value);
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
	public String toString() {
		return "[ValidCollection name:" + name + " values:" + values.size() + "]";
	}

}
