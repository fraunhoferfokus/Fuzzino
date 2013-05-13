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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.CloseRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.CollectionRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.CollectionSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Generator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.NumberSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.NumberType;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Request;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StructureRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.ValidCollectionsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.ValidValuesSection;

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
	public CloseRequest createCloseRequest(de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest emfCloseRequest) {
		if (emfCloseRequest == null) {
			return null;
		} else {
			CloseRequest closeRequest = createCloseRequest();
			closeRequest.setWithEMFObject(emfCloseRequest);
			return closeRequest;
		}
		
	}

	@Override
	public CollectionRequest createCollectionRequest(
			de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest emfCollectionRequest) {
		if (emfCollectionRequest == null) {
			return null;
		} else {
			CollectionRequest collectionRequest = createCollectionRequest();
			collectionRequest.setWithEMFObject(emfCollectionRequest);
			
			return collectionRequest;
		}
	}

	@Override
	public Field createField(de.fraunhofer.fokus.fuzzing.fuzzino.request.Field emfField) {
		if (emfField == null) {
			return null;
		} else {
			Field field = createField();
			field.setWithEMFObject(emfField);
			return field;
		}
	}

	@Override
	public NumberRequest createNumberRequest(de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest emfNumberRequest) {
		if (emfNumberRequest == null) {
			return null;
		} else {
			NumberRequest numberRequest = createNumberRequest();
			numberRequest.setWithEMFObject(emfNumberRequest);
			
			return numberRequest;
		}
	}

	@Override
	public Request createRequest(de.fraunhofer.fokus.fuzzing.fuzzino.request.Request emfRequest) {
		if (emfRequest == null) {
			return null;
		} else {
			Request request = createRequest();
			request.setWithEMFObject(emfRequest);
			return request;
		}
		
	}

	@Override
	public StringRequest createStringRequest(de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest emfStringRequest) {
		if (emfStringRequest == null) {
			return null;
		} else {
			StringRequest stringRequest = createStringRequest();
			stringRequest.setWithEMFObject(emfStringRequest);
			
			return stringRequest;
		}
	}

	@Override
	public StructureRequest createStructureRequest(
			de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest emfStructureRequest) {
		if (emfStructureRequest == null) {
			return null;
		} else {
			StructureRequest structureRequest = createStructureRequest();
			structureRequest.setWithEMFObject(emfStructureRequest);
			
			return structureRequest;
		}
	}

	@Override
	public ValidCollection createValidCollection(
			de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection emfValidCollection) {
		if (emfValidCollection == null) {
			return null;
		} else {
			ValidCollection validCollection = createValidCollection();
			validCollection.setWithEMFObject(emfValidCollection);
			return validCollection;
		}
	}

	@Override
	public ValidCollectionsSection createValidCollections(
			de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollections emfValidCollections) {
		if (emfValidCollections == null) {
			return null;
		} else {
			ValidCollectionsSection validCollections = createValidCollections();
			validCollections.setWithEMFObject(emfValidCollections);
			return validCollections;
		}
	}

	@Override
	public ValidValuesSection createValidValues(de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValues emfValidValues) {
		if (emfValidValues == null) {
			return null;
		} else {
			ValidValuesSection validValues = createValidValues();
			validValues.setWithEMFObject(emfValidValues);
			return validValues;
		}
	}

	@Override
	public StringSpecification createStringSpecification(
			de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification emfRequestSpecification) {
		if (emfRequestSpecification == null) {
			return null;
		} else {
			StringSpecification stringSpec = createStringSpecification();
			stringSpec.setWithEMFObject(emfRequestSpecification);
			return stringSpec;
		}
	}

	@Override
	public Generator createGenerator() {
		return new GeneratorImpl();
	}

	@Override
	public Generator createGenerator(de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator emfGenerator) {
		if (emfGenerator == null) {
			return null;
		} else {
			Generator generator = createGenerator();
			generator.setWithEMFObject(emfGenerator);
			return generator;
		}
	}
	
	@Override
	public NumberSpecification createNumberSpecification() {
		return new NumberSpecificationImpl();
	}
	
	@Override
	public NumberSpecification createNumberSpecification(NumberType numberType) {
		NumberSpecification numberSpec = createNumberSpecification();
		numberSpec.setType(numberType);
		return numberSpec;
	}
	
	@Override
	public NumberSpecification createNumberSpecification(de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification emfRequestSpecification) {
		if (emfRequestSpecification == null) {
			return null;
		} else {
			NumberSpecification numberSpecification = createNumberSpecification();
			numberSpecification.setWithEMFObject(emfRequestSpecification);
			return numberSpecification;
		}
	}

	@Override
	public NumberSpecification createNumberSpecification(NumberSpecification template) {
		NumberSpecification numberSpec = createNumberSpecification(template.getType());
		numberSpec.setBits(template.getBits());
		numberSpec.setIgnoreMinMaxValues(template.ignoreMinMaxValues());
		numberSpec.setIsSigned(template.isSigned());
		numberSpec.setMaxValue(template.getMaxValue());
		numberSpec.setMinValue(template.getMinValue());
		
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
	public Operator createOperator(de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator emfOperator) {
		if (emfOperator == null) {
			return null;
		} else {
			Operator operator = createOperator();
			operator.setWithEMFObject(emfOperator);
			return operator;
		}
	}

	@Override
	public CollectionSpecification createCollectionSpecification(RequestSpecification emfRequestSpecification) {
		if (emfRequestSpecification == null) {
			return null;
		} else {
			CollectionSpecification collectionSpecification = createCollectionSpecification();
			collectionSpecification.setWithEMFObject(emfRequestSpecification);
			return collectionSpecification;
		}
	}

	@Override
	public CollectionSpecification createCollectionSpecification() {
		return new CollectionSpecificationImpl();
	}

	@Override
	public StructureSpecification createStructureSpecification() {
		return new StructureSpecificationImpl();
	}

	@Override
	public StructureSpecification createStructureSpecification(RequestSpecification emfRequestSpecification) {
		if (emfRequestSpecification == null) {
			return null;
		} else {
			StructureSpecification structureSpecification = createStructureSpecification();
			structureSpecification.setWithEMFObject(emfRequestSpecification);
			return structureSpecification;
		}
	}

}
