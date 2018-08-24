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
package de.fraunhofer.fokus.fuzzing.fuzzino.request;

public interface RequestFactory {
	RequestFactory INSTANCE = de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.RequestFactoryImpl.init();
	
	CloseRequest createCloseRequest();
	CollectionRequest createCollectionRequest();
	CollectionSpecification createCollectionSpecification();
	Field createField();
	Generator createGenerator();
	Generator createGenerator(String name);
	NumberRequest createNumberRequest();
	IntegerSpecification createNumberSpecification();
	IntegerSpecification createNumberSpecification(IntegerSpecification numberSpec);
	/**
	 * Creates a {@code NumberSpecification<Double>} with Double.MIN_VALUE
	 * and Double.MAX_VALUE as border values.
	 * @return NumberSpecification<Double>
	 */
	NumberSpecification<Double> createFloatSpecification();
	Operator createOperator();
	Operator createOperator(String name);
	Request createRequest();
	StringRequest createStringRequest();
	StringSpecification createStringSpecification();
	StructureRequest createStructureRequest();
	StructureSpecification createStructureSpecification();
	ValidCollection createValidCollection();
	ValidCollectionsSection createValidCollections();
	ValidValuesSection createValidValues();

	
}
