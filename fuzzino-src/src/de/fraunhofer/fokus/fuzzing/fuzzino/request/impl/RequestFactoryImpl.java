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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Request;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollectionsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValuesSection;

public class RequestFactoryImpl implements RequestFactory {

	public static RequestFactory init() {
		return new RequestFactoryImpl();
	}
	
	@Override
	public CloseRequest createCloseRequest() {
		return new CloseRequestImpl();
	}

	@Override
	public CollectionRequest createCollectionRequest() {
		return new CollectionRequestImpl();
	}

	@Override
	public Field createField() {
		return new FieldImpl();
	}

	@Override
	public NumberRequest createNumberRequest() {
		return new NumberRequestImpl();
	}

	@Override
	public Request createRequest() {
		return new RequestImpl();
	}

	@Override
	public StringRequest createStringRequest() {
		return new StringRequestImpl();
	}

	@Override
	public StructureRequest createStructureRequest() {
		return new StructureRequestImpl();
	}

	@Override
	public ValidCollection createValidCollection() {
		return new ValidCollectionImpl();
	}

	@Override
	public ValidCollectionsSection createValidCollections() {
		return new ValidCollectionsSectionImpl();
	}

	@Override
	public ValidValuesSection createValidValues() {
		return new ValidValuesSectionImpl();
	}
	
	@Override
	public StringSpecification createStringSpecification() {
		return new StringSpecificationImpl();
	}

	@Override
	public Generator createGenerator() {
		return new GeneratorImpl();
	}
	
	@Override
	public IntegerSpecification createNumberSpecification() {
		return new IntegerSpecificationImpl();
	}

	@Override
	public IntegerSpecification createNumberSpecification(IntegerSpecification template) {
		if(template==null){
			return null;
		}
		IntegerSpecification numberSpec = createNumberSpecification();
		numberSpec.setBits(template.getBits());
		numberSpec.setIgnoreMinMaxValues(template.ignoreMinMaxValues());
		numberSpec.setIsSigned(template.isSigned());
		numberSpec.setMax(template.getMax());
		numberSpec.setMin(template.getMin());
		
		return numberSpec;
	}

	@Override
	public Operator createOperator() {
		return new OperatorImpl();
	}
	
	@Override
	public Operator createOperator(String name) {
		Operator operator = createOperator();
		operator.setOperatorName(name);
		return operator;
	}

	@Override
	public CollectionSpecification createCollectionSpecification() {
		return new CollectionSpecificationImpl();
	}

	@Override
	public StructureSpecification createStructureSpecification() {
		return new StructureSpecificationImpl();
	}

}
