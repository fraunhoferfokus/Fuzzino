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
package de.fraunhofer.fokus.fuzzing.fuzzino.jaxb;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringEncoding;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValuesSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.GeneratorImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.OperatorImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringRequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringSpecificationImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidValuesSectionImpl;

public class StringRequestBuilder {

	public static StringRequestImpl initStringRequest() {
		StringRequestImpl req = new StringRequestImpl();
		req.setId("my string request id");
		req.setMaxValues(12);
		req.setName("string request 1");
		req.addRequestedGenerator(new GeneratorImpl("gen1"));
		req.addRequestedGenerator(new GeneratorImpl("gen2"));
		req.setSeed(13);
		req.setSpecification(initStringSpecification());		
		req.setUseNoGenerators(false);
		req.setValidValuesSection(initValidValues());
		return req;
	}

	private static StringSpecification initStringSpecification() {
		StringSpecificationImpl spec = new StringSpecificationImpl();
		spec.setEncoding(StringEncoding.UTF16);
		spec.setIgnoreLengths(true);
		spec.setIsNullTerminated(true);
		spec.setMaxLength(1234);
		spec.setMinLength(321);
		spec.setRegEx("this is a regex");
		spec.setType(StringType.HOSTNAME);
		return spec;
	}

	private static ValidValuesSection initValidValues() {
		ValidValuesSectionImpl values = new ValidValuesSectionImpl();
		values.addValue("valid");
		values.addValue("valid too");
		values.addRequestedOperator(new OperatorImpl("op1"));
		OperatorImpl op2 = new OperatorImpl("op2");
		op2.setParameter("param1");
		values.addRequestedOperator(op2);
		return values;
	}
}
