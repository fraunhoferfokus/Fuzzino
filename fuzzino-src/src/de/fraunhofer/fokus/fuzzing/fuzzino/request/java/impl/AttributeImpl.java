//   Copyright 2012-2014 Fraunhofer FOKUS
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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Attribute;

public class AttributeImpl implements Attribute {
	
	private static final long serialVersionUID = -8635415739119715572L;
	protected String ref = null;
	protected String name = null;

	public AttributeImpl() {
	}
	
	public AttributeImpl(de.fraunhofer.fokus.fuzzing.fuzzino.request.Attribute attributeEMF) {
		ref = attributeEMF.getName();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public String getRef() {
		return ref;
	}

	@Override
	public void setRef(String value) {
		this.ref = value;
	}

}
