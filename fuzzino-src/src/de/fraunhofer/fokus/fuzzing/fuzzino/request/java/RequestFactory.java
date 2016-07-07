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
package de.fraunhofer.fokus.fuzzing.fuzzino.request.java;

public interface RequestFactory {
	RequestFactory INSTANCE = de.fraunhofer.fokus.fuzzing.fuzzino.request.java.impl.RequestFactoryImpl.init();
	
	CloseRequest createCloseRequest();
	CollectionRequest createCollectionRequest();
	CollectionSpecification createCollectionSpecification();
	Field createField();
	Generator createGenerator();
	NumberRequest createNumberRequest();
	IntegerSpecification createNumberSpecification();
	IntegerSpecification createNumberSpecification(IntegerSpecification numberSpec);
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

	// create methods initialized with EMF template objects
	CloseRequest createCloseRequest(de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest emfCloseRequest);
	CollectionRequest createCollectionRequest(de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest emfCollectionRequest);
	CollectionSpecification createCollectionSpecification(de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification emfRequestSpecification);
	Field createField(de.fraunhofer.fokus.fuzzing.fuzzino.request.Field emfField);
	Generator createGenerator(de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator emfGenerator);
	NumberRequest createNumberRequest(de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest emfNumberRequest);
	IntegerSpecification createNumberSpecification(de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification emfRequestSpecification);
	Operator createOperator(de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator emfOperator);
	Request createRequest(de.fraunhofer.fokus.fuzzing.fuzzino.request.Request remfRquest);
	StringRequest createStringRequest(de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest emfStringRequest);
	StringSpecification createStringSpecification(de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification emfRequestSpecification);
	StructureRequest createStructureRequest(de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest emfStructureRequest);
	StructureSpecification createStructureSpecification(de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification emfRequestSpecification);
	ValidCollection createValidCollection(de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection emfValidCollection);
	ValidCollectionsSection createValidCollections(de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollections emfValidCollections);
	ValidValuesSection createValidValues(de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValues emfValidValues);
	
}
