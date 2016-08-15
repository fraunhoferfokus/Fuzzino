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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.LibraryType;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.AbstractRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValuesSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.WarningsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ValidationResult;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class NumberRequestImpl extends AbstractRequest implements NumberRequest {
	
	private static final long serialVersionUID = -2012616743761270542L;
	protected List<Generator> generators;
	protected ValidValuesSection validValues;
	protected transient ValidationResult validationResult = null;
	private NumberSpecification<? extends Number> numSpec;
	
	@XmlElement(name = "noGenerators")
	protected boolean useNoGenerators;
	
	@Override
	@XmlElement(name="generator", type=GeneratorImpl.class)
	public List<Generator> getRequestedGenerators() {
		if (generators == null) {
			generators = new ArrayList<>();
		}
		return generators;
	}
	
	@Override
	public void setRequestedGenerators(List<Generator> value) {
		getRequestedGenerators().addAll(value);
	}
	
	@Override
	@XmlElement(name = "validValues",type=ValidValuesSectionImpl.class)
	public ValidValuesSection getValidValuesSection() {
		return validValues;
	}
	
	@Override
	public void setValidValuesSection(ValidValuesSection value) {
		validValues = value;
	}
	
	@Override
	public void addValidValue(String validValue) {
		if (validValues == null) {
			validValues = RequestFactory.INSTANCE.createValidValues();
		}
		validValues.addValue(validValue);
	}
	
	@Override
	public ValidationResult validate() {
		if (validationResult == null) {
			ValidationResult validMaxValues = validateMaxValues();
			ValidationResult validSpecification = ValidationResult.VALID;
			if (getNumberSpecification() != null) {
				validSpecification = getNumberSpecification().validate();
			} else {
				if (!isContinued()) {
					IllegalRequestFormat missingSpec =
							ResponseFactory.INSTANCE.createIllegalRequestFormatWithMissingAttribute("specification", null);
					WarningsSection warnings = ResponseFactory.INSTANCE.createWarnings();
					warnings.getIllegalRequestFormats().add(missingSpec);
					validSpecification = new ValidationResult(false, warnings);
				}
			}
			
			validationResult = validMaxValues.merge(validSpecification);
		}
		return validationResult;
	}
	
	@Override
	public boolean isValid() {
		return validate().isValid();
	}
	
	private ValidationResult validateMaxValues() {
		boolean validMaxValues = getMaxValues() > 0;
		
		WarningsSection warnings = null;

		if (!validMaxValues) {
			if (warnings == null) {
				warnings = ResponseFactory.INSTANCE.createWarnings();
			}
			IllegalRequestFormat illegalMaxValues = 
					ResponseFactory.INSTANCE.createIllegalRequestFormatWithWrongAttribute("string", "maxValues");
			warnings.getIllegalRequestFormats().add(illegalMaxValues);
		}

		return new ValidationResult(validMaxValues, warnings);		
	}

	@Override
	public void addRequestedGenerator(Generator value) {
		getRequestedGenerators().add(value);
	}
	
	@Override
	public String toString() {
		return "[NumberRequest name:" + name + " id:" + id + "]";
	}

	@Override
	public boolean useNoGenerators() {
		return useNoGenerators;
	}

	@Override
	public void setUseNoGenerators(boolean value) {
		useNoGenerators = value;
	}

	@Override
	public LibraryType getLibraryType() {
		return LibraryType.NUMBER;
	}

	@Override
	@XmlElement(name = "specification",type = IntegerSpecificationImpl.class) //TODO: this might become a problem if there are multiple types of NumberSpecifications
	public NumberSpecification<? extends Number> getNumberSpecification() {
		return numSpec;
	}

	@Override
	public void setNumberSpecification(NumberSpecification<? extends Number> numSpec) {
		this.numSpec = numSpec;
	}

}
