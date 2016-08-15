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
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.BoundaryNumbersGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;

/**
 * A factory that creates all kinds of integer generators. A single integer generator
 * can be requested by its name ({@link #create(String, String, IntegerSpecification, long)} or
 * by calling the corresponding create method.
 * The factory is a singleton.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public class IntegerGeneratorFactory {
	
	/**
	 * The singleton instance of the factory.
	 */
	public static final IntegerGeneratorFactory INSTANCE = new IntegerGeneratorFactory();
	
	private IntegerGeneratorFactory() {
	}
	
	/**
	 * Creates an integer generator identified by its name.
	 * 
	 * @param name The name of the integer generator that is not the class name but the name used
	 *             in a request (see {@link ComputableFuzzingHeuristic#getName()} or documentation for a
	 *             list of string generators and its names).
	 * @param param A parameter for the requested integer generator. May be {@code null} if the requested
	 *              generator does not have a parameter or a default value shall be used.
	 * @param numberSpec The number specification that describes the type the generator shall create values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return the requested instance of integer generator.
	 * @throws UnknownFuzzingHeuristicException if no generator with {@code name} is known. 
	 */	public IntegerGenerator create(String name, String param, IntegerSpecification numberSpec, long seed) throws UnknownFuzzingHeuristicException {
		if (name == null) {
			throw new UnknownFuzzingHeuristicException(name);
		}
		String canonicalName = name.trim().toUpperCase();
		if (canonicalName.equals("BoundaryNumbers".toUpperCase())) {
			return createBoundaryNumbersGenerator(numberSpec, seed);
		} else {
			throw new UnknownFuzzingHeuristicException(name);
		}
	}

	 /**
	  * A list of all integer generators that can create values for {@code numberSpec}.
	  * 
	  * @param numberSpec The number specification that describes the type the generator shall create values for.
	  * @param seed The seed to be used for random-based fuzzing heuristics.
	  * @return a list of all integer generators that can create values for {@code numberSpec}.
	  */
	public List<IntegerGenerator> createAll(IntegerSpecification numberSpec, long seed) {
		List<IntegerGenerator> allNumberGenerators = new ArrayList<>();
		allNumberGenerators.add(createBoundaryNumbersGenerator(numberSpec, seed));

		List<IntegerGenerator> applicableGenerators = new LinkedList<>();
		for (IntegerGenerator numberGenerator : allNumberGenerators) {
			if (numberGenerator.canCreateValuesFor(numberSpec)) {
				applicableGenerators.add(numberGenerator);
			}
		}
		
		return applicableGenerators;
	}
	
	/**
	 * Returns an instance of {@link BoundaryNumbersGenerator}.
	 * 
	 * @param numberSpec The number specification that describes the type the generator shall create values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link BoundaryNumbersGenerator}.
	 */
	public BoundaryNumbersGenerator createBoundaryNumbersGenerator(IntegerSpecification numberSpec, long seed) {
		return new BoundaryNumbersGenerator(numberSpec, seed);
	}
	
}
