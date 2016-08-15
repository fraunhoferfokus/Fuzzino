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
import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.BigIntegerGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.BigIntegerGeneratorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.BigIntegerOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.BigIntegerOperatorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValuesSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.BigIntegerResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;

public class BigIntegerRequestProcessor extends NumberRequestProcessor<BigInteger> {

	private static final long serialVersionUID = -6193217412368744339L;
	private static final String BIGINTEGER_EXTENSION = ".bigIntegerProcessor";

	public BigIntegerRequestProcessor(NumberRequest numberRequest, UUID uuid) {
		super(numberRequest, uuid);
	}

	@Override
	public BigIntegerResponse getResponse() {
		if (response == null) {
			response = ResponseFactory.INSTANCE.createBigIntegerResponse();
			buildResponse();
		}
		return (BigIntegerResponse) response;
	}

	/**
	 * Retrieves the list of generators from the {@link #request} and adds them to
	 * {@link #generators}. 
	 */
	@Override
	protected void addRequestedGenerators() {
		List<Generator> allRequestedGenerators = request.getRequestedGenerators(); 
		if (allRequestedGenerators.isEmpty() && !request.useNoGenerators()) {
			List<BigIntegerGenerator> allIntegerGenerators = BigIntegerGeneratorFactory.INSTANCE.createAll((IntegerSpecification) request.getNumberSpecification(), seed);
			heuristics.addAll(allIntegerGenerators);
		} else {
			for (Generator requestedGenerator : allRequestedGenerators) {
				try {
					BigIntegerGenerator generator = 
							BigIntegerGeneratorFactory.INSTANCE.create(requestedGenerator.getGeneratorName(), 
							                                           requestedGenerator.getParameter(), 
							                                           (IntegerSpecification) request.getNumberSpecification(), 
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
		ValidValuesSection validValuesPart = request.getValidValuesSection();
		List<BigInteger> validValues = parseValidValues();
		List<Operator> allRequestedOperators = (validValuesPart == null ?  Collections.<Operator>emptyList() : validValuesPart.getRequestedOperators());
		if (allRequestedOperators.isEmpty() && !validValues.isEmpty()) {
			List<BigIntegerOperator> allOperators = BigIntegerOperatorFactory.INSTANCE.createAll(validValues, (IntegerSpecification) request.getNumberSpecification(), seed);
			heuristics.addAll(allOperators);
			return;
		}
		
		for (Operator requestedOperator : allRequestedOperators) {
			String requestedOperatorName = requestedOperator.getOperatorName();
			try {
				BigIntegerOperator operator = BigIntegerOperatorFactory.INSTANCE.create(requestedOperatorName, 
						validValues, 
						requestedOperator.getParameter(), 
						(IntegerSpecification) request.getNumberSpecification(), 
						seed);
				heuristics.add(operator);
			} catch (UnknownFuzzingHeuristicException e) {
				IllegalOperator illegalOperator = 
						ResponseFactory.INSTANCE.createIllegalOperator(requestedOperatorName, "unknown operator");
				getWarningsPart().getIllegalOperators().add(illegalOperator);
			}
		}
	}
	
	private List<BigInteger> parseValidValues() {
		ValidValuesSection validValues = request.getValidValuesSection();
		List<BigInteger> result = new LinkedList<>();
		if (validValues != null) {
			List<String> stringValues = validValues.getValues();
			for (String str : stringValues) {
				try {
					result.add(new BigInteger(str));
				} catch (NumberFormatException e) {
					// ignore value
				}
			}
		}
		
		return result;
	}
	
	public static BigIntegerRequestProcessor loadFromFile(String filename) throws IOException, ClassNotFoundException {
		FileInputStream file = new FileInputStream(dir + File.separator + filename + BIGINTEGER_EXTENSION);
		ObjectInputStream in = new ObjectInputStream(file);
		BigIntegerRequestProcessor bigIntegerRequestProcessor = (BigIntegerRequestProcessor) in.readObject();
		in.close();
		file.close();
		return bigIntegerRequestProcessor;
	}	

	@Override
	protected String getFileExtension() {
		return BIGINTEGER_EXTENSION;
	}

	@Override
	protected void deleteResponse() {
		response = null;
	}
}
