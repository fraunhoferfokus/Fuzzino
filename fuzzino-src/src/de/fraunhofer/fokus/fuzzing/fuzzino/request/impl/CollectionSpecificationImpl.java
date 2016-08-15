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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CommonRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ValidationResult;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class CollectionSpecificationImpl implements CollectionSpecification {

	private static final long serialVersionUID = -4626524333820363957L;
	
	@XmlAttribute
	protected String ref;	
	@XmlAttribute
	protected boolean isUnique;
	@XmlAttribute
	protected boolean isOrdered;
	@XmlAttribute
	protected int minLength = 0;
	@XmlAttribute
	protected int maxLength = Integer.MAX_VALUE;
	
	protected CommonRequest refSpec;
	protected ValidationResult validationResult = null;
	protected CommonRequest request = null;
	
	@Override
	public String getRef() {
		return ref;
	}

	@Override
	public void setRef(String value) {
		ref = value;
	}

	@Override
	public boolean isUnique() {
		return isUnique;
	}

	@Override
	public void setUnique(boolean value) {
		isUnique = value;
	}

	@Override
	public boolean isOrdered() {
		return isOrdered;
	}

	@Override
	public void setOrdered(boolean value) {
		isOrdered = value;
	}

	@Override
	public int getMinLength() {
		return minLength;
	}

	@Override
	public void setMinLength(int value) {
		minLength = value;
	}

	@Override
	public int getMaxLength() {
		return maxLength;
	}

	@Override
	public void setMaxLength(int value) {
		maxLength = value;
	}

	@Override
	public ValidationResult validate() {
		if (validationResult == null) {
			ValidationResult validMinLength = validateMinLength();
			ValidationResult validMaxLength = validateMaxLength();
			ValidationResult validRef = validateRef();
			
			validationResult = validMinLength.merge(validMaxLength).merge(validRef);
		}
		
		return validationResult;
	}
	
	private ValidationResult validateMinLength() {
		WarningsSection warnings = null;
		boolean validMinLength = getMinLength() >= 0;
		
		if (!validMinLength) {
			warnings = ResponseFactory.INSTANCE.createWarnings();
			IllegalRequestFormat illegalMinLength =
					ResponseFactory.INSTANCE.createIllegalRequestFormatWithWrongAttribute("specification", "minLength");
			warnings.getIllegalRequestFormats().add(illegalMinLength);
		}
		
		return new ValidationResult(validMinLength, warnings);
	}
	
	private ValidationResult validateMaxLength() {
		WarningsSection warnings = null;
		boolean validMaxLength = getMaxLength() > 0 && getMaxLength() >= getMinLength();
		
		if (!validMaxLength) {
			warnings = ResponseFactory.INSTANCE.createWarnings();
			IllegalRequestFormat illegalMaxLength =
					ResponseFactory.INSTANCE.createIllegalRequestFormatWithWrongAttribute("specification", "maxLength");
			warnings.getIllegalRequestFormats().add(illegalMaxLength);
		}
		
		return new ValidationResult(validMaxLength, warnings);
	}
	
	private ValidationResult validateRef() {
		WarningsSection warnings = null;
		
		boolean refIsSpecified = refSpec == null;
		if (!refIsSpecified) {
			warnings = ResponseFactory.INSTANCE.createWarnings();
			IllegalRequestFormat missingRef =
					ResponseFactory.INSTANCE.createIllegalRequestFormatWithMissingAttribute("specification", "ref");
			warnings.getIllegalRequestFormats().add(missingRef);
		}
		
		return new ValidationResult(refIsSpecified, warnings);
	}

	@Override
	public CommonRequest getValuesRequest() {
		return request;
	}

	@Override
	public void setValuesRequest(CommonRequest value) {
		request = value;
	}
	
}
