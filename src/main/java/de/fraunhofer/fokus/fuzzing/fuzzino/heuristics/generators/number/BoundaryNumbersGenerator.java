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
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberType;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.IntegerUtil;

public class BoundaryNumbersGenerator extends SimpleIntegerGenerator {

	private static final long serialVersionUID = 4659420102670769833L;
	protected List<Long> fuzzValues = new ArrayList<>();
	
	public BoundaryNumbersGenerator(IntegerSpecification numberSpec, long seed) {
		super(numberSpec, seed);
		initFuzzValues();
	}

	public BoundaryNumbersGenerator(IntegerSpecification numberSpec, long seed, ComputableFuzzingHeuristic<?> owner) {
		super(numberSpec, seed, owner);
		initFuzzValues();
	}
	
	private void initFuzzValues() {
		modifyNumberSpec();
		
		// Add all fuzzValues to a HashSet to automatically filter duplicates
		Set<Long> filteredFuzzValues = new LinkedHashSet<>();
		
		if (matchesSpecification(new FuzzedValue<>(0L, owner))) {
			filteredFuzzValues.add(0L);
		}
		
		List<Integer> divisors = IntegerUtil.asList(1, 2, 3, 4, 8, 16, 32);
		long maxValue = numberSpec.getMax();
		long minValue = numberSpec.getMin();
		for (Integer divisor : divisors) {
			long maxValueDivided = maxValue / divisor;
			FuzzedValue<Long> fuzzedValue = new FuzzedValue<>(maxValueDivided, owner);
			if (matchesSpecification(fuzzedValue)) {
				filteredFuzzValues.add(maxValueDivided);
			}
			
			long minValueDivided = minValue / divisor;
			fuzzedValue = new FuzzedValue<>(minValueDivided, owner);
			if (matchesSpecification(fuzzedValue)) {
				filteredFuzzValues.add(minValueDivided);
			}
		}
		
		filteredFuzzValues.add(minValue - 1);
		filteredFuzzValues.add(maxValue + 1);
		
		fuzzValues.addAll(filteredFuzzValues);
	}

	protected void modifyNumberSpec() {
		IntegerSpecification modifiedNumberSpec = RequestFactory.INSTANCE.createNumberSpecification(numberSpec);
		modifiedNumberSpec.setIgnoreMinMaxValues(true);
		numberSpec = modifiedNumberSpec;
	}

	@Override
	public boolean canCreateValuesFor(IntegerSpecification numberSpec) {
		boolean validType = numberSpec.getType() == NumberType.INTEGER;
		boolean validBits = numberSpec.getBits() <= 64;
		
		return validType && validBits;
	}

	@Override
	public String getName() {
		return "BoundaryNumbers";
	}

	@Override
	public List<Long> getFuzzValues() {
		return fuzzValues;
	}

}
