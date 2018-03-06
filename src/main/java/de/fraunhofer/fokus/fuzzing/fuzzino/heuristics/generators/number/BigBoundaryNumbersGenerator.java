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
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.IntegerUtil;

public class BigBoundaryNumbersGenerator extends SimpleBigIntegerGenerator {

	private static final long serialVersionUID = 1781058301031766759L;
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
		
		if (matchesSpecification(new FuzzedValue<>(BigInteger.ZERO, owner))) {
			fuzzValues.add(BigInteger.ZERO);
		}
		
		List<Integer> divisors = IntegerUtil.asList(1, 2, 3, 4, 8, 16, 32);
		BigInteger maxValue = numberSpec.getMaxValueBig();
		BigInteger minValue = numberSpec.getMinValueBig();
		for (Integer divisor : divisors) {
			BigInteger maxValueDivided = maxValue.divide(BigInteger.valueOf(divisor));
			FuzzedValue<BigInteger> fuzzedValue = new FuzzedValue<>(maxValueDivided, owner);
			if (matchesSpecification(fuzzedValue)) {
				fuzzValues.add(maxValueDivided);
			}
			
			BigInteger minValueDivided = minValue.divide(BigInteger.valueOf(divisor));
			fuzzedValue = new FuzzedValue<>(minValueDivided, owner);
			if (matchesSpecification(fuzzedValue)) {
				fuzzValues.add(minValueDivided);
			}
		}
		
		fuzzValues.add(minValue.add(BigInteger.ONE));
		fuzzValues.add(maxValue.subtract(BigInteger.ONE));
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

	@Override
	public String getName() {
		return "BoundaryNumbers";
	}

	@Override
	public List<BigInteger> getFuzzValues() {
		return fuzzValues;
	}

}
