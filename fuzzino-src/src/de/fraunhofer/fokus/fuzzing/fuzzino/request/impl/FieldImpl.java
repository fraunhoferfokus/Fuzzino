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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.Field;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
@XmlType(namespace = "request")
public class FieldImpl implements Field {
	
	private static final long serialVersionUID = -5645034690559659654L;
	@XmlAttribute
	String correspondingId;
	@XmlAttribute
	private boolean fuzzField = false;
	@XmlAttribute
	private String name;
	
	public FieldImpl() {}
	
	@Override
	public String toString() {
		return "[Referenced Field request id:" + correspondingId + "]";
	}

	@Override
	public void setFuzz(boolean fuzzField) {
		this.fuzzField = fuzzField;
	}

	@Override
	public boolean fuzz() {
		return fuzzField;
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
	public String getCorrespondingRequestId() {
		return correspondingId;
	}

	@Override
	public void setCorrespondingRequestId(String correspondingId) {
		this.correspondingId = correspondingId;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof FieldImpl){
			FieldImpl other = (FieldImpl) o;
			return correspondingId.equals(other.getCorrespondingRequestId()) && name.equals(other.getName()) && fuzzField == other.fuzz();			
		} else{
			return false;
		}
	}

}
