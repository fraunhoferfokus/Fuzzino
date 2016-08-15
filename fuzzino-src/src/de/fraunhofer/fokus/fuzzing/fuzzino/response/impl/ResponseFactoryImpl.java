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
package de.fraunhofer.fokus.fuzzing.fuzzino.response.impl;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.BigIntegerResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedValuesByGenerators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedValuesByOperators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IntegerResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Response;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Value;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsSection;

public class ResponseFactoryImpl implements ResponseFactory {
	
	public static ResponseFactory init() {
		return new ResponseFactoryImpl();
	}

	@Override
	public <T> FuzzedValuesByGenerators<T> createAllGeneratorsBasedPart() {
		return new FuzzedValuesByGeneratorsImpl<>();
	}

	@Override
	public <T> FuzzedValuesByOperators<T> createAllOperatorsBasedPart() {
		return new FuzzedValuesByOperatorsImpl<>();
	}

	@Override
	public CloseRequestConfirmation createCloseRequestConfirmation() {
		return new CloseRequestConfirmationImpl();
	}
	
	@Override
	public CloseRequestConfirmation createCloseRequestConfirmation(String id, String name) {
		CloseRequestConfirmation closeRequestConfirmation = createCloseRequestConfirmation();
		closeRequestConfirmation.setId(id);
		closeRequestConfirmation.setName(name);
		
		return closeRequestConfirmation;
	}
	
	@Override
	public CloseRequestConfirmation createCloseRequestConfirmation(String id, String name, WarningsSection warnings) {
		CloseRequestConfirmation closeRequestConfirmation = createCloseRequestConfirmation();
		closeRequestConfirmation.setId(id);
		closeRequestConfirmation.setName(name);
		
		closeRequestConfirmation.setWarningsPart(warnings);
		
		return closeRequestConfirmation;
	}

	@Override
	public CollectionResponse createCollectionResponse() {
		return new CollectionResponseImpl();
	}

	@Override
	public ErrorResponse createErrorResponse() {
		return new ErrorResponseImpl();
	}

	@Override
	public Field createField() {
		return new FieldImpl();
	}

	@Override
	public FuzzedCollection createFuzzedCollection() {
		return new FuzzedCollectionImpl();
	}

	@Override
	public FuzzedCollection createFuzzedCollection(ValidCollection validCollection) {
		FuzzedCollection fuzzedCollection = createFuzzedCollection();
		if (validCollection != null) {
			for (String value : validCollection.getValues()) {
				Value v = createValue();
				v.setValue(value);
				fuzzedCollection.getValues().add(v);
			}
			fuzzedCollection.setBasedOn(validCollection.getName());
		}
		
		return fuzzedCollection;
	}

	@Override
	public <T> GeneratorSpecificFuzzedValues<T> createGeneratorPart() {
		return new GeneratorSpecificFuzzedValuesImpl<>();
	}

	@Override
	public IllegalGenerator createIllegalGenerator() {
		return new IllegalGeneratorImpl();
	}
	
	@Override
	public IllegalGenerator createIllegalGenerator(String name, String reason) {
		IllegalGenerator illegalGenerator = createIllegalGenerator();
		illegalGenerator.setName(name);
		illegalGenerator.setReason(reason);
		return illegalGenerator;
	}
	
	@Override
	public IllegalOperator createIllegalOperator() {
		return new IllegalOperatorImpl();
	}
	
	@Override
	public IllegalOperator createIllegalOperator(String name, String reason) {
		IllegalOperator illegalOperator = createIllegalOperator();
		illegalOperator.setName(name);
		illegalOperator.setReason(reason);
		return illegalOperator;
	}
	
	@Override
	public IllegalRequestFormat createIllegalRequestFormat() {
		return new IllegalRequestFormatImpl();
	}
	
	@Override
	public IllegalRequestFormat createIllegalRequestFormatWithWrongAttribute(String element, String attribute) {
		IllegalRequestFormat illegalRequestFormat = createIllegalRequestFormat();
		illegalRequestFormat.setAttribute(attribute);
		illegalRequestFormat.setElement(element);
		
		return illegalRequestFormat;
	}
	
	@Override
	public IllegalRequestFormat createIllegalRequestFormatWithMissingAttribute(String missingElement, String missingAttribute) {
		IllegalRequestFormat illegalRequestFormat = createIllegalRequestFormat();
		illegalRequestFormat.setMissingAttribute(missingAttribute);
		illegalRequestFormat.setMissingElement(missingElement);
		
		return illegalRequestFormat;
	}
	
	@Override
	public IllegalRequestFormat createIllegalRequestFormatWithMissingElement(String element) {
		IllegalRequestFormat illegalRequestFormat = createIllegalRequestFormat();
		illegalRequestFormat.setMissingElement(element);
		return illegalRequestFormat;
	}
	
	@Override
	public BigIntegerResponse createBigIntegerResponse() {
		return new BigIntegerResponseImpl();
	}
	
	@Override
	public BigIntegerResponse createBigIntegerResponse(NumberRequest toRequest) {
		BigIntegerResponse bigIntegerResponse = createBigIntegerResponse();
		bigIntegerResponse.setName(toRequest.getName());
		bigIntegerResponse.setId(toRequest.getId());
		
		return bigIntegerResponse;
	}

	@Override
	public IntegerResponse createIntegerResponse() {
		return new IntegerResponseImpl();
	}
	
	@Override
	public IntegerResponse createIntegerResponse(NumberRequest toRequest) {
		IntegerResponse integerResponse = createIntegerResponse();
		integerResponse.setName(toRequest.getName());
		integerResponse.setId(toRequest.getId());
		
		return integerResponse;
	}
	
	@Override
	public <T> OperatorSpecificFuzzedValues<T> createOperatorPart() {
		return new OperatorSpecificFuzzedValuesImpl<>();
	}

	@Override
	public Response createResponse() {
		return new ResponseImpl();
	}

	@Override
	public StringResponse createStringResponse() {
		return new StringResponseImpl();
	}
	
	@Override
	public StringResponse createStringResponse(StringRequest toRequest) {
		StringResponse stringResponse = createStringResponse();
		stringResponse.setName(toRequest.getName());
		stringResponse.setId(toRequest.getId());
		
		return stringResponse;
	}

	@Override
	public StructureResponse createStructureResponse() {
		return new StructureResponseImpl();
	}

	@Override
	public Value createValue() {
		return new ValueImpl();
	}

	@Override
	public Value createValue(String value, String generator) {
		Value v = createValue();
		v.setValue(value);
		v.setGenerator(generator);
		
		return v;
	}

	@Override
	public Value createValue(String value, String basedOn, String operator) {
		Value v = createValue();
		v.setValue(value);
		v.setBasedOn(basedOn);
		v.setOperator(operator);

		return v;
	}

	@Override
	public WarningsSection createWarnings() {
		return new WarningsSectionImpl();
	}

}
