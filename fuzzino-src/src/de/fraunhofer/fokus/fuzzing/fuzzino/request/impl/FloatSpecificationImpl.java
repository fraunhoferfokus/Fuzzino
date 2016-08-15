package de.fraunhofer.fokus.fuzzing.fuzzino.request.impl;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberType;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.WarningsSection;
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
