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

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberType;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ValidationResult;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class IntegerSpecificationImpl implements NumberSpecification<Long> , IntegerSpecification{

	@XmlAttribute
	protected BigInteger minValue;
	@XmlAttribute
	protected BigInteger maxValue;
	@XmlAttribute
	protected int bits = 32;
	@XmlAttribute
	protected boolean isSigned = true;

	private static final long serialVersionUID = 407819388357822264L;
	protected boolean isSetMaxValue = false;
	protected boolean isSetMinValue = false;
	protected boolean validType = true;
	protected ValidationResult validationResult = null;
	
	@XmlAttribute
	protected boolean ignoreMinMaxValues = false;
	
	public IntegerSpecificationImpl() {
		computeMinValue();
		computeMaxValue();
	}

	@Override
	public ValidationResult validate() {
		if (validationResult == null) {
			ValidationResult validType = validateType();
			ValidationResult validMinMaxRange = validateMinMaxValueRange();
			ValidationResult validBits = validateBits();
			ValidationResult validMinValue = validateMinValue();
			ValidationResult validMaxValue = validateMaxValue();

			validationResult = validType.merge(validMinMaxRange)
					                    .merge(validBits)
					                    .merge(validMinValue)
					                    .merge(validMaxValue);
		}
		
		return validationResult;
	}
	
	private ValidationResult validateType() {
		WarningsSection warnings = null;
		if (!validType) {
			warnings = ResponseFactory.INSTANCE.createWarnings();
			
			IllegalRequestFormat illegalType = 
					ResponseFactory.INSTANCE.createIllegalRequestFormatWithWrongAttribute("specification", "type");
			warnings.getIllegalRequestFormats().add(illegalType);
		}
		
		return new ValidationResult(validType, warnings);
	}
	
	private ValidationResult validateMinMaxValueRange() {
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
	
	private ValidationResult validateBits() {
		boolean validBits = true;
		WarningsSection warnings = null;
		
		if (getBits() != 8 && getBits() != 16 && getBits() != 32 && getBits() != 64 && getBits() != 128) {
			warnings = ResponseFactory.INSTANCE.createWarnings();
			validBits = false;
			IllegalRequestFormat illegalBits = 
					ResponseFactory.INSTANCE.createIllegalRequestFormatWithWrongAttribute("specification", "bits");
			warnings.getIllegalRequestFormats().add(illegalBits);
		}
		
		return new ValidationResult(validBits, warnings);
	}
	
	private ValidationResult validateMinValue() {
		if (!validateBits().isValid()) {
			return ValidationResult.VALID;
		}
		
		boolean validMinValue = true;
		WarningsSection warnings = null;
		
		long range = (long) Math.pow(2, getBits());
		long minValidValue = 0;
		if (isSigned()) {
			minValidValue = -range;
		}
		
		if (getMin() < minValidValue) {
			warnings = ResponseFactory.INSTANCE.createWarnings();
			validMinValue = false;
			IllegalRequestFormat illegalMinValue =
					ResponseFactory.INSTANCE.createIllegalRequestFormatWithWrongAttribute("specification", "minValue");
			warnings.getIllegalRequestFormats().add(illegalMinValue);
		}
		
		return new ValidationResult(validMinValue, warnings);
	}
	
	private ValidationResult validateMaxValue() {
		if (!validateBits().isValid()) {
			return ValidationResult.VALID;
		}
		
		boolean validMaxValue = true;
		WarningsSection warnings = null;

		long range = (long) Math.pow(2, getBits());
		long maxValidValue = range - 1;
		if (isSigned()) {
			maxValidValue = range/2 - 1;
		}

		if (getMax() > maxValidValue) {
			warnings = ResponseFactory.INSTANCE.createWarnings();
			validMaxValue = false;
			IllegalRequestFormat illegalMaxValue =
					ResponseFactory.INSTANCE.createIllegalRequestFormatWithWrongAttribute("specification", "maxValue");
			warnings.getIllegalRequestFormats().add(illegalMaxValue);
		}
		
		return new ValidationResult(validMaxValue, warnings);
	}

	@Override
	public NumberType getType() {
		return NumberType.INTEGER;
	}

	@Override
	public int getBits() {
		return bits;
	}
	
	@Override
	public void setBits(int value) {
		bits = value;
		if (!isSetMinValue) {
			computeMinValue();
		}
		if (!isSetMaxValue) {
			computeMaxValue();
		}
	}

	@Override
	public boolean isSigned() {
		return isSigned;
	}
	
	@Override
	public void setIsSigned(boolean value) {
		isSigned = value;
		if (!isSetMinValue) {
			computeMinValue();
		}
		if (!isSetMaxValue) {
			computeMaxValue();
		}
	}
	
	private void computeMinValue() {
		if (!validateBits().isValid()) {
			return;
		}
		
		long minValue = 0;
		if (isSigned()) {
			minValue = (long) Math.pow(2, getBits()-1) * -1;
		}
		setMin(minValue);
	}
	
	private void computeMaxValue() {
		if (!validateBits().isValid()) {
			return;
		}
		
		long maxValue = (long) Math.pow(2, getBits());
		if (isSigned()) {
			maxValue /= 2;
		}
		maxValue--;
		setMax(maxValue);
	}
	
	@Override
	public String toString() {
		return "[IntegerSpecification minValue:" + minValue + " maxValue:" + maxValue +
			   " bits:" + bits + " isSigned:" + isSigned + "]";
	}

	@Override
	public void setIgnoreMinMaxValues(boolean value) {
		ignoreMinMaxValues = value;
	}

	@Override
	public boolean ignoreMinMaxValues() {
		return ignoreMinMaxValues;
	}

	@Override
	public boolean isMinValueBig() {
		return isBigInteger(minValue);
	}

	@Override
	public BigInteger getMinValueBig() {
		return minValue;
	}

	@Override
	public void setMinValue(BigInteger value) {
		minValue = value;
	}

	@Override
	public boolean isMaxValueBig() {
		return isBigInteger(maxValue);
	}

	@Override
	public BigInteger getMaxValueBig() {
		return maxValue;
	}

	@Override
	public void setMaxValue(BigInteger value) {
		maxValue = value;
	}

	private boolean isBigInteger(BigInteger value) {
		return value.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0 || value.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0;
	}

	@Override
	public boolean isLongCompatible() {
		return getType() == NumberType.INTEGER && getBits() <= 64;
	}

	@Override
	public boolean isBigIntegerCompatible() {
		return getType() == NumberType.INTEGER && getBits() > 64;
	}

	@Override
	public Long getMin() {
		return minValue.longValue();
	}

	@Override
	public Long getMax() {
		return maxValue.longValue();
	}

	@Override
	public void setMin(Long min) {
		minValue = BigInteger.valueOf(min);
	}

	@Override
	public void setMax(Long max) {
		maxValue = BigInteger.valueOf(max);
	}
	
}
