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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGeneratorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.StringOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.StringOperatorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CommonRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValuesSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedValuesByGenerators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedValuesByOperators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.GeneratorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.OperatorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringEncoder;

/**
 * This class processes a {@link StringRequest} and a creates a {@link StringResponse}.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 */
public class StringRequestProcessor extends RequestProcessor<String> {
	private transient StringResponse response;
	
	private StringRequest request;
	private boolean encodeAllCharacters = false;
	private static final String FILE_EXTENSION = ".stringProcessor";

	private static final long serialVersionUID = 2873792884268319134L;

	public static StringRequestProcessor loadFromFile(String filename) throws IOException, ClassNotFoundException {
		FileInputStream inFileStream = new FileInputStream(dir + File.separator + filename + FILE_EXTENSION);
		ObjectInputStream inObjectStream = new ObjectInputStream(inFileStream);
		Object readObject = inObjectStream.readObject();
		StringRequestProcessor stringRequestProcessor = (StringRequestProcessor) readObject;
		inObjectStream.close();
		inFileStream.close();
		return stringRequestProcessor;
	}

	/**
	 * Creates a new instance for a StringRequest that is identified by its id.
	 * 
	 * @param request The request to be processed by the new instance.
	 * @param uuid The ID that identifies the request (necessary for continued requests).
	 */
	public StringRequestProcessor(StringRequest request, UUID uuid) {
		super(request, uuid);
	}
	
	/**
	 * Creates a new instance for a StringRequest that is identified by its id.
	 * 
	 * @param request The request to be processed by the new instance.
	 * @param uuid The ID that identifies the request (necessary for continued requests).
	 * @param encodeAllCharacters Indicates whether all character instead of only control characters shall be encoded.
	 */
	public StringRequestProcessor(StringRequest request, UUID uuid, boolean encodeAllCharacters) {
		super(request, uuid);
		this.encodeAllCharacters = encodeAllCharacters;
	}

	@Override
	protected boolean collectFuzzedValues() {
		HashMap<FuzzedValue<String>, GeneratorSpecificFuzzedValues<String>> generatorParts = new HashMap<>();
		HashMap<FuzzedValue<String>, OperatorSpecificFuzzedValues<String>> operatorParts = new HashMap<>();
		int i=0;
		if (iterator == null) {
			iterator = iterator();
		}

		boolean hasMoreValues = iterator.hasNext();
		
		if (hasMoreValues) {
			while (i<maxValues && iterator.hasNext()) {
				FuzzedValue<String> fuzzedValue = iterator.next();
				if (encodeAllCharacters) {
					fuzzedValue.value = StringEncoder.encode(fuzzedValue.value);
				}

				if (fuzzedValue.isGenerated()) {
					addFuzzedValueToGeneratorParts(fuzzedValue, generatorParts);
				}

				if (fuzzedValue.isMutated()) {
					addFuzzedValueToOperatorParts(fuzzedValue, operatorParts);
				}
				i++;
			}
		} else {
			getWarningsPart().setMoreValues(iterator.hasNext());
		}
		
		if (!generatorParts.values().isEmpty()) {
			addAllGeneratorsBasedPart(response, generatorParts.values());
		}
		if (!operatorParts.values().isEmpty()) {
			addAllOperatorsBasedPart(response, operatorParts.values());
		}
		return iterator.hasNext();
	}

	protected void addFuzzedValueToGeneratorParts(FuzzedValue<String> fuzzedValue, HashMap<FuzzedValue<String>, GeneratorSpecificFuzzedValues<String>> generatorParts) {
		FuzzingHeuristic stringGenerator = fuzzedValue.getHeuristic();
		// check if a generator part for this generator already exists
		if (!generatorParts.containsKey(fuzzedValue)) {
			GeneratorSpecificFuzzedValues<String> generatorPart = ResponseFactory.INSTANCE.createGeneratorPart();
			generatorPart.setName(stringGenerator.getName());
			generatorParts.put(fuzzedValue, generatorPart);
		}
		GeneratorSpecificFuzzedValues<String> generatorPart = generatorParts.get(fuzzedValue);
		generatorPart.addFuzzedValue(fuzzedValue);
	}

	protected void addFuzzedValueToOperatorParts(FuzzedValue<String> fuzzedValue,HashMap<FuzzedValue<String>, OperatorSpecificFuzzedValues<String>> operatorParts) {
		FuzzingHeuristic fuzzingHeuristic = fuzzedValue.getHeuristic();

		// check if a part for this operator and the value it is based on already exists
		if (operatorParts.get(fuzzedValue) == null) {
			OperatorSpecificFuzzedValues<String> operatorPart = ResponseFactory.INSTANCE.createOperatorPart();
			operatorPart.setName(fuzzingHeuristic.getName());
			operatorPart.setBasedOn(fuzzedValue.getBasedOnValue());
			operatorParts.put(fuzzedValue, operatorPart);
		}

		OperatorSpecificFuzzedValues<String> operatorPart = operatorParts.get(fuzzedValue);
		operatorPart.addFuzzedValue(fuzzedValue);
	}

	protected void addAllGeneratorsBasedPart(StringResponse stringResponse, 
			                            Collection<GeneratorSpecificFuzzedValues<String>> generatorParts) {
		FuzzedValuesByGenerators<String> generatorsBasedPart = ResponseFactory.INSTANCE.createAllGeneratorsBasedPart();
		generatorsBasedPart.setGeneratorSpecificSections(generatorParts);
		stringResponse.setGeneratorBasedSection(generatorsBasedPart);
	}

	protected void addAllOperatorsBasedPart(StringResponse stringResponse, 
			                                Collection<OperatorSpecificFuzzedValues<String>> operatorParts) {
		FuzzedValuesByOperators<String> operatorsBasedPart = ResponseFactory.INSTANCE.createAllOperatorsBasedPart();
		operatorsBasedPart.setOperatorSpecificSections(operatorParts);
		stringResponse.setOperatorBasedSection(operatorsBasedPart);

	}

	/**
	 * Retrieves the list of generators from the {@link #request} and adds them to
	 * {@link #generators}. 
	 */
	@Override
	protected void addRequestedGenerators() {
		if (request.useNoGenerators()) {
			return;
		}
		List<Generator> allRequestedGenerators = request.getRequestedGenerators(); 
		if (allRequestedGenerators.isEmpty()) {
			List<StringGenerator> allStringGenerators = 
					StringGeneratorFactory.INSTANCE.createAll(request.getSpecification(), seed);
			heuristics.addAll(allStringGenerators);
		} else {
			for (Generator requestedGenerator : allRequestedGenerators) {
				try {
					StringGenerator generator = 
							StringGeneratorFactory.INSTANCE.create(requestedGenerator.getGeneratorName(),
							                                       requestedGenerator.getParameter(),
							                                       request.getSpecification(), 
							                                       seed);
					heuristics.add(generator);
				} catch (UnknownFuzzingHeuristicException e) {
					IllegalGenerator illegalGenerator = ResponseFactory.INSTANCE.createIllegalGenerator(requestedGenerator.getGeneratorName(), "unknown generator");
					getWarningsPart().getIllegalGenerators().add(illegalGenerator);
				}
			}
		}
	}

	@Override
	protected void addRequestedOperators() {
		ValidValuesSection validValues = request.getValidValuesSection();
		if (validValues == null) {
			return;
		}
		List<String> values = validValues.getValues();
		List<Operator> allRequestedOperators = validValues.getRequestedOperators();
		
		if (allRequestedOperators.isEmpty()) {
			List<StringOperator> allOperators =
					StringOperatorFactory.INSTANCE.createAll(values, request.getSpecification(), seed);
			heuristics.addAll(allOperators);
		} else {
			for (Operator requestedOperator : allRequestedOperators) {
				try {
					StringOperator operator = 
							StringOperatorFactory.INSTANCE.create(requestedOperator.getOperatorName(), 
							                                      values,
							                                      requestedOperator.getParameter(),
							                                      request.getSpecification(),
							                                      seed);
					heuristics.add(operator);
				} catch (UnknownFuzzingHeuristicException e) {
					IllegalOperator illegalOperator = ResponseFactory.INSTANCE.createIllegalOperator(requestedOperator.getOperatorName(), "unknown operator");
					getWarningsPart().getIllegalOperators().add(illegalOperator);
				}
			}
		}
	}

	@Override
	public String getName() {
		return request.getName();
	}

	@Override
	public CommonRequest getRequest() {
		return request;
	}

	@Override
	public StringResponse getResponse() {
		if (response == null) {
			response = ResponseFactory.INSTANCE.createStringResponse();
			buildResponse();
		}
		return response;
	}

	@Override
	public void setRequest(CommonRequest request) {
		if (request instanceof StringRequest) {
			this.request = (StringRequest) request;
		} else {
			throw new IllegalArgumentException("Illegal type " +  request.getClass().getSimpleName() + ". Expected StringRequest.");
		}
	}

	@Override
	protected String getFileExtension() {
		return FILE_EXTENSION;
	}

	@Override
	protected void deleteResponse() {
		response = null;
	}
}