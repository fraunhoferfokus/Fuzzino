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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string.DelimiterOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string.ForeignDigitsOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string.StringCaseOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string.UnicodeNumeralsOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string.RepeatStringOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

/**
 * <p>
 * A factory that creates all kinds of StringOperators. A single StringOperator
 * can be requested by its name via the method {@link #create} or by calling the
 * corresponding create method. The factory is a singleton which instance can be
 * obtained by calling {@code StringOperatorFactory.INSTANCE}.
 * </p>
 * <p>
 * Following are all available working StringOperators listed by their name.
 * This name is not the class name but the name used in a request.
 * <ul>
 * <li>{@link DelimiterOperator Delimiter}</li>
 * <li>{@link StringCaseOperator StringCase}</li>
 * <li>{@link StringRepetitionOperator StringRepetition}</li>
 * </ul>
 * </p>
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public class StringOperatorFactory {

	public static final StringOperatorFactory INSTANCE = new StringOperatorFactory();
	
	/**
	 * Private constructor, because it's a singleton.
	 */
	private StringOperatorFactory() {
	}
	
	/**
	 * Creates an StringOperator identified by its name.
	 * 
	 * @param name
	 *            The name of the StringOperator that is not the class name
	 *            but the name used in a request (see Javadoc in
	 *            {@link StringOperatorFactory} or
	 *            {@link ComputableFuzzingHeuristic#getName()}) or documentation for
	 *            a list of operators and its names).
	 * @param validValues A list of strings that can be mutated
	 * @param param
	 *            A parameter for the requested StringOperator. May be
	 *            {@code null} if the requested generator does not have a parameter
	 *            or a default value shall be used.
	 * @param stringSpec
	 * @param seed
	 *            The seed to be used for random-based fuzzing heuristics.
	 * @return the requested instance of StringOperator.
	 * @throws UnknownFuzzingHeuristicException
	 *             if no generator with {@code NAME} is known.
	 */
	public StringOperator create(String name, 
			                     List<String> validValues,
			                     String param,
			                     StringSpecification stringSpec, 
			                     long seed) throws UnknownFuzzingHeuristicException {
		String canonicalName = name.trim().toUpperCase();
		if (canonicalName.equals("Delimiter".toUpperCase())) {
			return createDelimiterOperator(validValues, stringSpec, seed);
		}
		if (canonicalName.equals("StringCase".toUpperCase())) {
			return createStringCaseOperator(validValues, stringSpec, seed);
		} else
		if (canonicalName.equals("StringRepetition".toUpperCase())) {
			return createStringRepetitionOperator(validValues, stringSpec, seed);
		} else
		if (canonicalName.equals("ForeignDigits".toUpperCase())) {
			return createForeignDigitsOperator(validValues, param, stringSpec, seed);
		} else
		if (canonicalName.equals("UnicodeNumerals".toUpperCase())) {
			return createUnicodeNumeralsOperator(validValues, param, stringSpec, seed);
		} else {
			throw new UnknownFuzzingHeuristicException(name);
		}
	}

	/**
	  * A list of all StringOperators that can create values for {@code stringSpec}.
	  * 
	  * @param validValues
	  * @param stringSpec The StringSpecification describes the type the generator shall create values for.
	  * @param seed The seed to be used for random-based fuzzing heuristics.
	  * @return a list of all StringOperators that can create values for {@code stringSpec}.
	  */
	public List<StringOperator> createAll(List<String> validValues, StringSpecification stringSpec, long seed) {
		List<StringOperator> allStringOperators = new ArrayList<>();
		allStringOperators.add(createDelimiterOperator(validValues, stringSpec, seed));
		allStringOperators.add(createStringCaseOperator(validValues, stringSpec, seed));
		allStringOperators.add(createStringRepetitionOperator(validValues, stringSpec, seed));
		
		List<StringOperator> applicableOperators = new LinkedList<>();
		for (StringOperator stringOperator : allStringOperators) {
			if (stringOperator.canCreateValuesFor(stringSpec)) {
				applicableOperators.add(stringOperator);
			}
		}
		
		return applicableOperators;
	}
	
	public DelimiterOperator createDelimiterOperator(List<String> validValues, StringSpecification stringSpec, long seed) {
		return new DelimiterOperator(validValues, stringSpec, seed);
	}
	
	public StringCaseOperator createStringCaseOperator(List<String> validValues, StringSpecification stringSpec, long seed) {
		return new StringCaseOperator(validValues, stringSpec, seed);
	}
	
	public RepeatStringOperator createStringRepetitionOperator(List<String> validValues, StringSpecification stringSpec, long seed) {
		return new RepeatStringOperator(validValues, stringSpec, seed);
	}

	public ForeignDigitsOperator createForeignDigitsOperator(List<String> validValues, String param,
			StringSpecification stringSpec, long seed) {
		return new ForeignDigitsOperator(validValues, param, stringSpec, seed);
	}

	private StringOperator createUnicodeNumeralsOperator(List<String> validValues, String param,
			StringSpecification stringSpec, long seed) {
		return new UnicodeNumeralsOperator(validValues, param, stringSpec, seed);
	}
}
