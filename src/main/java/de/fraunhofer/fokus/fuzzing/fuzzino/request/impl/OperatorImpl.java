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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator;

@XmlAccessorType(XmlAccessType.NONE)
public class OperatorImpl implements Operator {

	private static final long serialVersionUID = 1599135300363968257L;
	@XmlAttribute
	protected String name;
	@XmlAttribute
	protected String parameter;

	public OperatorImpl(String operatorName){
		setOperatorName(operatorName);
	}
	
	public OperatorImpl() {
	}

	public OperatorImpl(String operatorName, String param) {
		setOperatorName(operatorName);
		this.parameter = param;
	}

	@Override
	public String getOperatorName() {
		return name;
	}

	@Override
	public void setOperatorName(String value) {
		this.name = normalize(value);
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
		return "[Operator name:" + name + " parameter:" + parameter + "]";
	}

}
