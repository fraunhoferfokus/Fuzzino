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

import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalOperator;

public class IllegalOperatorImpl implements IllegalOperator {

	protected String value;
	protected String reason;
	
	@Override
	public String getName() {
		return value;
	}

	@Override
	public void setName(String value) {
		this.value = value;
	}

	@Override
	public String getReason() {
		return reason;
	}

	@Override
	public void setReason(String value) {
		reason = value;
	}

	@Override
	public de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator getEMFRepresentation() {
		de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator
		  emfIllegalOperator = ResponseFactory.eINSTANCE.createIllegalOperator();
		
		emfIllegalOperator.setReason(getReason());
		emfIllegalOperator.setValue(getName());
		
		return emfIllegalOperator;
	}
	
	@Override
	public String toString() {
		return "[IllegalOperator name:" + value + " reason:" + reason + "]";
	}

}
