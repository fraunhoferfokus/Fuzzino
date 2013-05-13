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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Generator;
import static de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil.*;

public class GeneratorImpl implements Generator {
	
	private static final long serialVersionUID = -3358168291798650021L;
	protected String value;
	protected String parameter;

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
	public void setWithEMFObject(de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator emfGenerator) {
		value = emfGenerator.getValue();
		parameter = emfGenerator.getParam();
	}

	@Override
	public String toString() {
		return "[Generator name:" + value + " parameter:" + parameter + "]";
	}
	
}
