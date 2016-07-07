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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.CommonRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Field;

public class FieldImpl implements Field {
	
	private static final long serialVersionUID = -5645034690559659654L;
	protected CommonRequest request = null;
	private boolean fuzzField = false;
	private String name;
	
	public FieldImpl() {}
	
	public FieldImpl(de.fraunhofer.fokus.fuzzing.fuzzino.request.Field fieldEMF) {
	}

	@Override
	public void setWithEMFObject(de.fraunhofer.fokus.fuzzing.fuzzino.request.Field emfField) {
		//TODO: we really should take a look at the whole code dublication thing  with the EMF objects...
		throw new AssertionError("EMF not yet supported");
	}
	
	@Override
	public String toString() {
		return "[Field request:" + request + "]";
	}

	@Override
	public CommonRequest getValueRequest() {
		return request;
	}

	@Override
	public void setValueRequest(CommonRequest value) {
		request = value;
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

}
