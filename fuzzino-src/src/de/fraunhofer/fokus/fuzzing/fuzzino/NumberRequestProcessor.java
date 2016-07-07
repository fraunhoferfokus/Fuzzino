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
package de.fraunhofer.fokus.fuzzing.fuzzino;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.CommonRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedValuesByGenerators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedValuesByOperators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.GeneratorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.OperatorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ResponseFactory;

public abstract class NumberRequestProcessor<T extends Number> extends RequestProcessor<T> {

	private static final long serialVersionUID = 6665646119450731161L;
	protected NumberRequest request;
	protected transient NumberResponse<T> response;

	public NumberRequestProcessor(NumberRequest numberRequest, UUID uuid) {
		super(numberRequest, uuid);
	}
	
	public abstract NumberResponse<T> getResponse();
	
	@Override
	public CommonRequest getRequest() {
		return request;
	}

	@Override
	public void setRequest(CommonRequest request) {
		if (request instanceof NumberRequest) {
			this.request = (NumberRequest) request;
		} else {
			throw new IllegalArgumentException("Illegal type " +  request.getClass().getSimpleName() + ". Expected NumberRequest.");
		}
	}

	@Override
	protected boolean collectFuzzedValues() {
		HashMap<FuzzedValue<T>, GeneratorSpecificFuzzedValues<T>> generatorParts = 
				new HashMap<>();
		HashMap<FuzzedValue<T>, OperatorSpecificFuzzedValues<T>> operatorParts = 
				new HashMap<>();
		int i=0;
		if (iterator == null) {
			iterator = iterator();
		}
		boolean hasMoreValues = iterator.hasNext();
		
		if (hasMoreValues) {
			while (i<maxValues && iterator.hasNext()) {
				FuzzedValue<T> fuzzedValue = iterator.next();

				if (fuzzedValue.isGenerated()) {
					addFuzzedValueToGeneratorParts(fuzzedValue, generatorParts);
				}

				if (fuzzedValue.isMutated()) {
					addFuzzedValueToOperatorParts(fuzzedValue, operatorParts);
				}
				i++;
			}
		} else {
			getWarningsPart().setMoreValues(false);
		}
		if (!generatorParts.values().isEmpty()) {
			addAllGeneratorsBasedPart(response, generatorParts.values());
		}
		if (!operatorParts.values().isEmpty()) {
			addAllOperatorsBasedPart(response, operatorParts.values());
		}
		return iterator.hasNext();
	}

	protected void addFuzzedValueToGeneratorParts(FuzzedValue<T> fuzzedValue, HashMap<FuzzedValue<T>, GeneratorSpecificFuzzedValues<T>> generatorParts) {
		FuzzingHeuristic fuzzingHeuristic = fuzzedValue.getHeuristic();

		// check if a generator part for this generator already exists
		if (!generatorParts.containsKey(fuzzedValue)) {
			GeneratorSpecificFuzzedValues<T> generatorPart = ResponseFactory.INSTANCE.createGeneratorPart();
			generatorPart.setName(fuzzingHeuristic.getName());
			generatorParts.put(fuzzedValue, generatorPart);
		}

		GeneratorSpecificFuzzedValues<T> generatorPart = generatorParts.get(fuzzedValue);
		generatorPart.addFuzzedValue(fuzzedValue);
	}

	protected void addFuzzedValueToOperatorParts(FuzzedValue<T> fuzzedValue,HashMap<FuzzedValue<T>, OperatorSpecificFuzzedValues<T>> operatorParts) {
		FuzzingHeuristic fuzzingHeuristic =  fuzzedValue.getHeuristic();

		// check if a part for this operator and the value it is based on already exists
		if (operatorParts.get(fuzzedValue) == null) {
			OperatorSpecificFuzzedValues<T> operatorPart = ResponseFactory.INSTANCE.createOperatorPart();
			operatorPart.setName(fuzzingHeuristic.getName());
			operatorPart.setBasedOn(fuzzedValue.getBasedOnValue().toString());
			operatorParts.put(fuzzedValue, operatorPart);
		}

		OperatorSpecificFuzzedValues<T> operatorPart = operatorParts.get(fuzzedValue);
		operatorPart.addFuzzedValue(fuzzedValue);
	}
	
	protected void addAllGeneratorsBasedPart(NumberResponse<T> stringResponse, 
			                                 Collection<GeneratorSpecificFuzzedValues<T>> generatorParts) {
		FuzzedValuesByGenerators<T> generatorsBasedPart = ResponseFactory.INSTANCE.createAllGeneratorsBasedPart();
		generatorsBasedPart.setGeneratorSpecificSections(generatorParts);
		stringResponse.setGeneratorBasedSection(generatorsBasedPart);
	}

	protected void addAllOperatorsBasedPart(NumberResponse<T> stringResponse, 
			                                Collection<OperatorSpecificFuzzedValues<T>> operatorParts) {
		FuzzedValuesByOperators<T> operatorsBasedPart = ResponseFactory.INSTANCE.createAllOperatorsBasedPart();
		operatorsBasedPart.setOperatorSpecificSections(operatorParts);
		stringResponse.setOperatorBasedSection(operatorsBasedPart);
	}


}
