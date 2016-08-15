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
package de.fraunhofer.fokus.fuzzing.fuzzino.response.impl;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.Value;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ValueImpl implements Value {
	
	@XmlAttribute
	protected String value;
	@XmlAttribute
	protected String basedOn;
	@XmlAttribute
	protected String generator;
	@XmlAttribute
	protected String operator;

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
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
	public String getGenerator() {
		return generator;
	}

	@Override
	public void setGenerator(String value) {
		generator = value;
	}

	@Override
	public String getOperator() {
		return operator;
	}

	@Override
	public void setOperator(String value) {
		operator = value;
	}
	
	@Override
	public String toString() {
		return "[Value value:" + value + (generator == null ? "" : " generator:" + generator) + 
				                         (operator == null ? "" : " operator:" + operator) +
				                         (basedOn == null ? "" : " basedOn:" + basedOn) + "]";
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof ValueImpl){
			ValueImpl other = (ValueImpl) o;
			return Objects.equals(value,other.value) && Objects.equals(basedOn,other.basedOn) && Objects.equals(generator,other.generator) && Objects.equals(operator,other.operator);
		} else{
			return false;
		}
	}

}
