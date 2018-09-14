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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.IntegerUtil;

public class BigBoundaryNumbersGenerator extends SimpleBigIntegerGenerator {

	private static final long serialVersionUID = 1781058301031766759L;
	/**
	 * {@value}
	 */
	public static final String NAME = "BoundaryNumbers";
	protected List<BigInteger> fuzzValues = new ArrayList<>();

	public BigBoundaryNumbersGenerator(IntegerSpecification numberSpec, long seed) {
		super(numberSpec, seed);
		initFuzzValues();
	}

	public BigBoundaryNumbersGenerator(IntegerSpecification numberSpec, long seed, ComputableFuzzingHeuristic<?> owner) {
		super(numberSpec, seed, owner);
		initFuzzValues();
	}
	
	private void initFuzzValues() {
		modifyNumberSpec();
		
		// Add all fuzzValues to a HashSet to automatically filter duplicates
		Set<BigInteger> filteredFuzzValues = new LinkedHashSet<>();
		
		if (matchesSpecification(new FuzzedValue<>(BigInteger.ZERO, owner))) {
			filteredFuzzValues.add(BigInteger.ZERO);
		}
		
		List<Integer> divisors = IntegerUtil.asList(1, 2, 3, 4, 8, 16, 32);
		BigInteger maxValue = numberSpec.getMaxValueBig();
		BigInteger minValue = numberSpec.getMinValueBig();
		for (Integer divisor : divisors) {
			BigInteger maxValueDivided = maxValue.divide(BigInteger.valueOf(divisor));
			FuzzedValue<BigInteger> fuzzedValue = new FuzzedValue<>(maxValueDivided, owner);
			if (matchesSpecification(fuzzedValue)) {
				filteredFuzzValues.add(maxValueDivided);
			}
			
			BigInteger minValueDivided = minValue.divide(BigInteger.valueOf(divisor));
			fuzzedValue = new FuzzedValue<>(minValueDivided, owner);
			if (matchesSpecification(fuzzedValue)) {
				filteredFuzzValues.add(minValueDivided);
			}
		}
		
		filteredFuzzValues.add(minValue.add(BigInteger.ONE));
		filteredFuzzValues.add(maxValue.subtract(BigInteger.ONE));
		
		fuzzValues.addAll(filteredFuzzValues);
	}
	
	protected void modifyNumberSpec() {
		IntegerSpecification modifiedNumberSpec = RequestFactory.INSTANCE.createNumberSpecification(numberSpec);
		modifiedNumberSpec.setIgnoreMinMaxValues(true);
		numberSpec = modifiedNumberSpec;
	}



	@Override
	public boolean canCreateValuesFor(IntegerSpecification numberSpec) {
		return false;
	}

	/**
	 * @return {@value #name}
	 */
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public List<BigInteger> getFuzzValues() {
		return fuzzValues;
	}

}
