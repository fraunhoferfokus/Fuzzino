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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public abstract class IllegalHeuristic {

	@XmlAttribute(name = "name")
	protected String name;
	@XmlAttribute
	protected String reason;
	
	public IllegalHeuristic(){}
	
	public IllegalHeuristic(String name, String reason) {
		setName(name);
		setReason(reason);
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String value) {
		reason = value;
	}
	
	@Override
	public boolean equals(Object o){
		if( o instanceof IllegalHeuristic){
			IllegalHeuristic other = (IllegalHeuristic) o;
			return name.equals(other.getName()) && reason.equals(other.getReason());
		} else{
			return false;
		}
	}
}
