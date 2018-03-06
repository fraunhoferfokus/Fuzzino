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
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollectionsSection;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class ValidCollectionsSectionImpl implements ValidCollectionsSection {

	private static final long serialVersionUID = 8732762527076837378L;
	protected List<ValidCollection> values;
	protected List<Operator> operators;
	
	@Override
	@XmlElement(name = "validCollection",type = ValidCollectionImpl.class)
	public List<ValidCollection> getValidCollections() {
		if (values == null) {
			values = new ArrayList<>();
		}
		return values;
	}
	
	@Override
	public void setValidCollections(List<ValidCollection> value) {
		getValidCollections().addAll(value);
	}
	
	@Override
	public void addValidCollection(ValidCollection value) {
		getValidCollections().add(value);
	}
	
	@Override
	@XmlElement(name = "operator",type = OperatorImpl.class)
	public List<Operator> getRequestedOperators() {
		if (operators == null) {
			operators = new ArrayList<>();
		}
		return operators;
	}
	
	@Override
	public void setRequestedOperators(List<Operator> value) {
		getRequestedOperators().addAll(value);
	}
	
	@Override
	public void addRequestedOperator(Operator value) {
		getRequestedOperators().add(value);
	}
	
	@Override
	public String toString() {
		return "[ValidCollections  collections:" + values.size() + " operators:" + operators + "]";
	}
	
}
