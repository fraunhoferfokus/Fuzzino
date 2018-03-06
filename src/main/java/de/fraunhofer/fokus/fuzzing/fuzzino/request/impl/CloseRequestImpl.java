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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class CloseRequestImpl implements CloseRequest {

	private static final long serialVersionUID = -316301454863678000L;
	@XmlAttribute
	protected String id = null;
	
	public CloseRequestImpl() {
	}
	
	public CloseRequestImpl(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String value) {
		id = value;
	}
	
	@Override
	public String toString() {
		return "[CloseRequest id:" + id + "]";
	}

}
