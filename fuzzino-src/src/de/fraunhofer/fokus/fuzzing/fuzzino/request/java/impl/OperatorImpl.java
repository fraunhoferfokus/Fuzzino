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
package de.fraunhofer.fokus.fuzzing.fuzzino.request.java.impl;

import static de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil.normalize;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Operator;

public class OperatorImpl implements Operator {

	private static final long serialVersionUID = 1599135300363968257L;
	protected String value;
	protected String parameter;

	public OperatorImpl(String operatorName){
		setOperatorName(operatorName);
	}
	
	public OperatorImpl() {
	}

	@Override
	public String getOperatorName() {
		return value;
	}

	@Override
	public void setOperatorName(String value) {
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
	public void setWithEMFObject(de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator emfOperator) {
		value = emfOperator.getValue();
		parameter = emfOperator.getParam();
	}
	
	@Override
	public String toString() {
		return "[Operator name:" + value + " parameter:" + parameter + "]";
	}

}
