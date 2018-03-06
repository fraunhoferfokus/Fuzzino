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
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.BigBoundaryNumbersGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;

public class BigIntegerGeneratorFactory {

	public static final BigIntegerGeneratorFactory INSTANCE = new BigIntegerGeneratorFactory();
	
	private BigIntegerGeneratorFactory() {
	}
	
	public BigIntegerGenerator create(String name, String param, IntegerSpecification numberSpec, long seed) throws UnknownFuzzingHeuristicException {
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
	
	public BigIntegerGenerator createBoundaryNumbersGenerator(IntegerSpecification numberSpec, long seed) {
		return new BigBoundaryNumbersGenerator(numberSpec, seed);
	}
	
}