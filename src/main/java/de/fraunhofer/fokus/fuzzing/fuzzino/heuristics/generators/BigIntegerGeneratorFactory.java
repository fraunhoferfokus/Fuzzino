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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.BigBoundaryNumbersGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;

/**
 * <p>
 * A factory that creates all kinds of big integer generators. A single big
 * integer generator can be requested by its name via the method {@link #create}
 * or by calling the corresponding create method. The factory is a singleton
 * which instance can be obtained by calling
 * {@code BigIntegerGeneratorFactory.INSTANCE}.
 * </p>
 * <p>
 * Following are all available working BigIntegerGenerators listed by their name.
 * This name is not the class name but the name used in a request.
 * <ul>
 * <li>{@link BigBoundaryNumbersGenerator BoundaryNumbers}</li>
 * </ul>
 * </p>
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public class BigIntegerGeneratorFactory {

	public static final BigIntegerGeneratorFactory INSTANCE = new BigIntegerGeneratorFactory();
	
	private BigIntegerGeneratorFactory() {
	}
	
	/**
	 * Creates an big integer generator identified by its name.
	 * 
	 * @param name
	 *            The name of the big integer generator that is not the class name
	 *            but the name used in a request (see Javadoc in
	 *            {@link BigIntegerGeneratorFactory} or
	 *            {@link ComputableFuzzingHeuristic#getName()}) or documentation for
	 *            a list of string generators and its names).
	 * @param param
	 *            A parameter for the requested big integer generator. May be
	 *            {@code null} if the requested generator does not have a parameter
	 *            or a default value shall be used.
	 * @param numberSpec
	 *            The number specification that describes the type the generator
	 *            shall create values for.
	 * @param seed
	 *            The seed to be used for random-based fuzzing heuristics.
	 * @return the requested instance of big integer generator.
	 * @throws UnknownFuzzingHeuristicException
	 *             if no generator with {@code NAME} is known.
	 */
	public BigIntegerGenerator create(String name, String param, IntegerSpecification numberSpec, long seed) throws UnknownFuzzingHeuristicException {
		if (name == null) {
			throw new UnknownFuzzingHeuristicException(name);
		}
		String canonicalName = name.trim().toUpperCase();
		if (canonicalName.equals(BigBoundaryNumbersGenerator.NAME.toUpperCase())) {
			return createBoundaryNumbersGenerator(numberSpec, seed);
		} else {
			throw new UnknownFuzzingHeuristicException(name);
		}
	}

	 /**
	  * A list of all big integer generators that can create values for {@code numberSpec}.
	  * 
	  * @param numberSpec The number specification that describes the type the generator shall create values for.
	  * @param seed The seed to be used for random-based fuzzing heuristics.
	  * @return a list of all integer generators that can create values for {@code numberSpec}.
	  */
	public List<BigIntegerGenerator> createAll(IntegerSpecification numberSpec, long seed) {
		List<BigIntegerGenerator> allNumberGenerators = new ArrayList<>();
		allNumberGenerators.add(createBoundaryNumbersGenerator(numberSpec, seed));

		List<BigIntegerGenerator> applicableGenerators = new LinkedList<>();
		for (BigIntegerGenerator numberGenerator : allNumberGenerators) {
			if (numberGenerator.canCreateValuesFor(numberSpec)) {
				applicableGenerators.add(numberGenerator);
			}
		}
		
		return applicableGenerators;
	}
	
	/**
	 * Returns an instance of {@link BigBoundaryNumbersGenerator}.
	 * 
	 * @param numberSpec The number specification that describes the type the generator shall create values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link BigBoundaryNumbersGenerator}.
	 */
	public BigIntegerGenerator createBoundaryNumbersGenerator(IntegerSpecification numberSpec, long seed) {
		return new BigBoundaryNumbersGenerator(numberSpec, seed);
	}
	
}