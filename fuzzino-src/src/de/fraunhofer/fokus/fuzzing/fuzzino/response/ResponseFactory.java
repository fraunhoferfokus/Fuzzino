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
package de.fraunhofer.fokus.fuzzing.fuzzino.response;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ResponseFactoryImpl;

public interface ResponseFactory {
	
	ResponseFactory INSTANCE = ResponseFactoryImpl.init();

	<T> FuzzedValuesByGenerators<T> createAllGeneratorsBasedPart();
	<T> FuzzedValuesByOperators<T> createAllOperatorsBasedPart();
	CloseRequestConfirmation createCloseRequestConfirmation();
	CloseRequestConfirmation createCloseRequestConfirmation(String id, String name);
	CloseRequestConfirmation createCloseRequestConfirmation(String id, String name, WarningsSection warnings);
	
	CollectionResponse createCollectionResponse();
	ErrorResponse createErrorResponse();
	Field createField();
	FuzzedCollection createFuzzedCollection();
	FuzzedCollection createFuzzedCollection(ValidCollection validCollection);
	
	<T> GeneratorSpecificFuzzedValues<T> createGeneratorPart();
	
	IllegalGenerator createIllegalGenerator();
	IllegalGenerator createIllegalGenerator(String name, String reason);
	
	IllegalOperator createIllegalOperator();
	IllegalOperator createIllegalOperator(String name, String reason);
	
	IllegalRequestFormat createIllegalRequestFormat();
	IllegalRequestFormat createIllegalRequestFormatWithWrongAttribute(String element, String attribute);
	IllegalRequestFormat createIllegalRequestFormatWithMissingAttribute(String missingElement, String missingAttribute);
	IllegalRequestFormat createIllegalRequestFormatWithMissingElement(String element);
	
	IntegerResponse createIntegerResponse();
	IntegerResponse createIntegerResponse(NumberRequest toRequest);
	
	BigIntegerResponse createBigIntegerResponse();
	BigIntegerResponse createBigIntegerResponse(NumberRequest toRequest);
	
	<T> OperatorSpecificFuzzedValues<T> createOperatorPart();
	Response createResponse();
	
	StringResponse createStringResponse();
	StringResponse createStringResponse(StringRequest toRequest);
	
	StructureResponse createStructureResponse();
	
	Value createValue();
	Value createValue(String value, String generator);
	Value createValue(String value, String basedOn, String operator);

	WarningsSection createWarnings();
	
}
