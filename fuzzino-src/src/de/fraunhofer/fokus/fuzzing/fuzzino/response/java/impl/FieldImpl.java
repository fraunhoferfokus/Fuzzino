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

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Field;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(namespace = "response")
public class FieldImpl implements Field {
	
	@XmlAttribute
	private  String correspondingId;
	@XmlAttribute
	protected boolean fuzz;
	@XmlAttribute
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
	public String toString() {
		return "[Field value:" + correspondingId + " fuzz:" + fuzz + "]";
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getCorrespondingResponseId() {
		return correspondingId;
	}

	@Override
	public void setCorrespondingResponseId(String correspondingId) {
		this.correspondingId = correspondingId;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof FieldImpl){
			FieldImpl other = (FieldImpl) o;
			return Objects.equals(correspondingId, other.getCorrespondingResponseId()) && Objects.equals(name,other.getName()) && fuzz == other.isValueFuzzed();			
		} else{
			return false;
		}
	}

}
