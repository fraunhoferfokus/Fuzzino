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
package de.fraunhofer.fokus.fuzzing.fuzzino.request.impl;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberType;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ValidationResult;

public class FloatSpecificationImpl extends NumberSpecificationImpl<Double>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FloatSpecificationImpl(double minValue, double maxValue) {
		setMin(minValue);
		setMax(maxValue);
	}

	@Override
	public NumberType getType() {
		return NumberType.FLOAT;
	}

	@Override
	public ValidationResult validate() {
		boolean validMaxMinValueRange = true;
		WarningsSection warnings = null;

		if (getMax() < getMin()) {
			warnings = ResponseFactory.INSTANCE.createWarnings();
			validMaxMinValueRange = false;
			IllegalRequestFormat illegalMaxValue = 
					ResponseFactory.INSTANCE.createIllegalRequestFormatWithWrongAttribute("specification", "maxValue");
			warnings.getIllegalRequestFormats().add(illegalMaxValue);
		}

		return new ValidationResult(validMaxMinValueRange, warnings);
	}

}
