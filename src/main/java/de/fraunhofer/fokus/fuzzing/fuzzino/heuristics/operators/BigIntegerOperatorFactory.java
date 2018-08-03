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

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.number.BigNumericalVarianceOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;

/**
 * <p>
 * A factory that creates all kinds of big integer operators. A single big
 * integer operator can be requested by its name via the method {@link #create}
 * or by calling the corresponding create method. The factory is a singleton
 * which instance can be obtained by calling
 * {@code BigIntegerOperatorFactory.INSTANCE}.
 * </p>
 * <p>
 * Following are all available working BigIntegerOperators listed by their name.
 * This name is not the class name but the name used in a request.
 * <ul>
 * <li>{@link BigNumericalVarianceOperator NumericalVariance}</li>
 * </ul>
 * </p>
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public class BigIntegerOperatorFactory {

	public static final BigIntegerOperatorFactory INSTANCE = new BigIntegerOperatorFactory();

	private BigIntegerOperatorFactory() {
	}

	/**
	 * Creates an big integer operator identified by its name.
	 * 
	 * @param name
	 *            The name of the big integer operator that is not the class name
	 *            but the name used in a request (see Javadoc in
	 *            {@link BigIntegerOperatorFactory} or
	 *            {@link ComputableFuzzingHeuristic#getName()}) or documentation for
	 *            a list of operators and its names).
	 * @param validValues A list of BigInteger values that can be mutated.
	 * @param param
	 *            A parameter for the requested big integer operator. May be
	 *            {@code null} if the requested generator does not have a parameter
	 *            or a default value shall be used.
	 * @param numberSpec
	 * @param seed
	 *            The seed to be used for random-based fuzzing heuristics.
	 * @return the requested instance of BigIntegerOperator.
	 * @throws UnknownFuzzingHeuristicException
	 *             if no generator with {@code name} is known.
	 */
	public BigIntegerOperator create(String name, 
			                         List<BigInteger> validValues, 
			                         String param, 
			                         IntegerSpecification numberSpec, 
			                         long seed) throws UnknownFuzzingHeuristicException {
		if (name.equals("NumericalVariance".toUpperCase())) {
			return createBigNumericalVarianceOperator(validValues, param, numberSpec, seed);
		} else {
			throw new UnknownFuzzingHeuristicException();
		}
	}
	
	 /**
	  * A list of all BigIntegerOperators that can create values for {@code numberSpec}.
	  * 
	  * @param validValues
	  * @param numberSpec The IntegerSpecification that describes the type the generator shall create values for.
	  * @param seed The seed to be used for random-based fuzzing heuristics.
	  * @return a list of all BigIntegerOperators that can create values for {@code numberSpec}.
	  */
	public List<BigIntegerOperator> createAll(List<BigInteger> validValues, 
			                               IntegerSpecification numberSpec, 
			                               long seed) {
		List<BigIntegerOperator> allIntegerOperators = new LinkedList<>();
		allIntegerOperators.add(createBigNumericalVarianceOperator(validValues, null, numberSpec, seed));

		List<BigIntegerOperator> applicableIntegerOperators = new LinkedList<>();
		for (BigIntegerOperator integerOperator : allIntegerOperators) {
			if (integerOperator.canCreateValuesFor(numberSpec)) {
				applicableIntegerOperators.add(integerOperator);
			}
		}
		
		return applicableIntegerOperators;
	}
	
	public BigNumericalVarianceOperator createBigNumericalVarianceOperator(List<BigInteger> validValues, String param,
			              IntegerSpecification numberSpec, long seed) {
		return new BigNumericalVarianceOperator(validValues, param, numberSpec, seed);
	}

}
