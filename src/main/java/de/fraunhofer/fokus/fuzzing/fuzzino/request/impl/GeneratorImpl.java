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

import static de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil.normalize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator;

@XmlAccessorType(XmlAccessType.NONE)
public class GeneratorImpl implements Generator {
	
	private static final long serialVersionUID = -3358168291798650021L;
	@XmlAttribute
	protected String value;
	@XmlAttribute
	protected String parameter;

	public GeneratorImpl(){
	}
	
	public GeneratorImpl(String name){
		this.value = normalize(name);
	}
	
	@Override
	public String getGeneratorName() {
		return value;
	}

	@Override
	public void setGeneratorName(String value) {
		this.value = normalize(value);
	}

	@Override
	public String getParameter() {
		return parameter;
	}

	@Override
	public void setParameter(String value) {
		parameter = value;
	}

	@Override
	public String toString() {
		return "[Generator name:" + value + " parameter:" + parameter + "]";
	}
	
}
