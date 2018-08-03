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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators;

import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.number.NumericalVarianceOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;

/**
 * <p>
 * A factory that creates all kinds of NumberOperators. A single NumberOperator
 * can be requested by its name via the method {@link #create} or by calling the
 * corresponding create method. The factory is a singleton which instance can be
 * obtained by calling {@code IntegerOperatorFactory.INSTANCE}.
 * </p>
 * <p>
 * Following are all available working NumberOperators listed by their name.
 * This name is not the class name but the name used in a request.
 * <ul>
 * <li>{@link NumericalVarianceOperator NumericalVariance}</li>
 * </ul>
 * </p>
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public class IntegerOperatorFactory {

	/**
	 * The singleton instance of the factory.
	 */
	public static final IntegerOperatorFactory INSTANCE = new IntegerOperatorFactory();

	/**
	 * Private constructor because it's a singleton.
	 */
	private IntegerOperatorFactory() {
	}
	
	/**
	 * Creates an IntegerOperator identified by its name.
	 * 
	 * @param name
	 *            The name of the IntegerOperator that is not the class name
	 *            but the name used in a request (see Javadoc in
	 *            {@link IntegerOperatorFactory} or
	 *            {@link ComputableFuzzingHeuristic#getName()}) or documentation for
	 *            a list of operators and its names).
	 * @param validValues A list of Long values that can be mutated.
	 * @param param
	 *            A parameter for the requested IntegerOperator. May be
	 *            {@code null} if the requested generator does not have a parameter
	 *            or a default value shall be used.
	 * @param numberSpec
	 * @param seed
	 *            The seed to be used for random-based fuzzing heuristics.
	 * @return the requested instance of IntegerOperator.
	 * @throws UnknownFuzzingHeuristicException
	 *             if no generator with {@code NAME} is known.
	 */
	public IntegerOperator create(String name, List<Long> validValues, String param, IntegerSpecification numberSpec, long seed) throws UnknownFuzzingHeuristicException {
		String canonicalName = name.trim().toUpperCase();
		if (canonicalName.equals("NumericalVariance".toUpperCase())) {
			return createNumericalVarianceOperator(validValues, param, numberSpec, seed);
		} else {
			throw new UnknownFuzzingHeuristicException();
		}
	}
	
	 /**
	  * A list of all IntegerOperators that can create values for {@code numberSpec}.
	  * 
	  * @param validValues
	  * @param collectionSpec The IntegerSpecificationn that describes the type the generator shall create values for.
	  * @param seed The seed to be used for random-based fuzzing heuristics.
	  * @return a list of all IntegerOperators that can create values for {@code numberSpec}.
	  */
	public List<IntegerOperator> createAll(List<Long> validValues, 
			                               IntegerSpecification numberSpec, 
			                               long seed) {
		List<IntegerOperator> allIntegerOperators = new LinkedList<>();
		allIntegerOperators.add(createNumericalVarianceOperator(validValues, null, numberSpec, seed));

		List<IntegerOperator> applicableIntegerOperators = new LinkedList<>();
		for (IntegerOperator integerOperator : allIntegerOperators) {
			if (integerOperator.canCreateValuesFor(numberSpec)) {
				applicableIntegerOperators.add(integerOperator);
			}
		}
		
		return applicableIntegerOperators;
	}
	
	public NumericalVarianceOperator createNumericalVarianceOperator(List<Long> validValues, 
			                                                         String param, 
			                                                         IntegerSpecification numberSpec, 
			                                                         long seed) {
		return new NumericalVarianceOperator(validValues, param, numberSpec, seed);
	}

}
