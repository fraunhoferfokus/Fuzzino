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
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalGenerator;

public class IllegalGeneratorImpl implements IllegalGenerator {

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
	public de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator getEMFRepresentation() {
		de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator
		  emfIllegalGenerator = ResponseFactory.eINSTANCE.createIllegalGenerator();
		
		emfIllegalGenerator.setReason(getReason());
		emfIllegalGenerator.setValue(getName());
		
		return emfIllegalGenerator;
	}
	
	@Override
	public String toString() {
		return "[IllegalGenerator name:" + value + " reason:" + reason + "]";
	}

}
