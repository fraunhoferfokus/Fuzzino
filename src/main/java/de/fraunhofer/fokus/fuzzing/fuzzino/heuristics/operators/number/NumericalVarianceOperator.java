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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.number;

import java.util.Collections;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComposedFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.IntegerOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;

/**
 * This operator generates numbers around a list of given values.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public class NumericalVarianceOperator extends ComposedFuzzingHeuristic<Long> implements IntegerOperator {

	private static final long serialVersionUID = -7739149245215658343L;
	protected List<Long> validValues;

	public NumericalVarianceOperator(List<Long> validValues, 
			                         String param,
			                         IntegerSpecification numberSpec,
			                         long seed) {
		super(seed);
		this.owners.add(this);
		if (numberSpec == null) {
			numberSpec = RequestFactory.INSTANCE.createNumberSpecification();
		}
		if (validValues == null) {
			throw new IllegalArgumentException("validValues must not be null");
		}
		int varianceRange = 10;
		this.validValues = validValues;
		try {
			varianceRange = Integer.parseInt(param);
		} catch (NumberFormatException e) {
			varianceRange = 10;
		}
		for (Long validValue : validValues) {
			SimpleNumericalVarianceOperator<Long> simpleNumericalVarianceOperator = 
					new SimpleNumericalVarianceOperator<>(validValue, varianceRange, numberSpec, seed, owners);
			heuristics.add(simpleNumericalVarianceOperator);
		}
	}
	
	@Override
	public boolean canCreateValuesFor(IntegerSpecification numberSpec) {
		return true;
	}

	@Override
	public List<Long> getValidValues() {
		return Collections.unmodifiableList(validValues);
	}

	@Override
	public String getName() {
		return "NumericalVariance";
	}

}
