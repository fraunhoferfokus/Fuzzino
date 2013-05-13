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
package de.fraunhofer.fokus.fuzzing.fuzzino.request.java.impl;

import java.util.ArrayList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Generator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.ValidValuesSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.WarningsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ValidationResult;

public class StringRequestImpl implements StringRequest {

	private static final long serialVersionUID = 352352153965419478L;
	protected StringSpecification specification;
	protected List<Generator> generators;
	protected ValidValuesSection validValues;
	protected String id = null;
	protected int maxValues = 0;
	protected String name = null;
	protected long seed = -1;
	protected boolean isEMFBased = false;
	protected boolean useNoGenerators = false;
	protected transient ValidationResult validationResult = null;
	
	@Override
	public StringSpecification getSpecification() {
		return specification;
	}
	
	@Override
	public void setSpecification(StringSpecification value) {
		specification = value;
	}
	
	@Override
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
	public void addRequestedGenerator(Generator value) {
		getRequestedGenerators().add(value);
	}
	
	@Override
	public ValidValuesSection getValidValuesSection() {
		return validValues;
	}
	
	@Override
	public void setValidValuesSection(ValidValuesSection value) {
		validValues = value;
	}
	
	@Override
	public void addValidValue(String value) {
		if (validValues == null) {
			validValues = RequestFactory.INSTANCE.createValidValues();
		}
		validValues.addValue(value);
	}
	
	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public void setId(String value) {
		id = value;
	}
	
	@Override
	public int getMaxValues() {
		return maxValues;
	}
	
	@Override
	public void setMaxValues(int value) {
		maxValues = value;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String value) {
		name = value;
	}
	@Override
	public long getSeed() {
		return seed;
	}
	
	@Override
	public void setSeed(long value) {
		seed = value;
	}

	@Override
	public void setWithEMFObject(de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest emfStringRequest) {
		for (de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator emfGenerator : emfStringRequest.getGenerators()) {
			addRequestedGenerator(RequestFactory.INSTANCE.createGenerator(emfGenerator));
		}
		setId(emfStringRequest.getId());
		setMaxValues(emfStringRequest.getMaxValues());
		setName(emfStringRequest.getName());
		setSeed(emfStringRequest.getSeed());
		setUseNoGenerators(emfStringRequest.getNoGenerators() != null);
		
		if (!isContinued()) {
			setSpecification(RequestFactory.INSTANCE.createStringSpecification(emfStringRequest.getSpecification()));
			setValidValuesSection(RequestFactory.INSTANCE.createValidValues(emfStringRequest.getValidValues()));
		}
		
		isEMFBased = true;
	}


	@Override
	public boolean isContinued() {
		return getId() != null;
	}

	@Override
	public boolean isEMFBased() {
		return isEMFBased;
	}

	@Override
	public ValidationResult validate() {
		if (validationResult == null) {
			ValidationResult validStringRequest = validateMaxValues();
			ValidationResult validSpecification = ValidationResult.VALID;
			if (getSpecification() != null) {
				validSpecification = getSpecification().validate();
			}
			
			validationResult = validStringRequest.merge(validSpecification);
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
			warnings = ResponseFactory.INSTANCE.createWarnings();
			IllegalRequestFormat illegalMaxValues = 
					ResponseFactory.INSTANCE.createIllegalRequestFormatWithWrongAttribute("string", "maxValues");
			warnings.getIllegalRequestFormats().add(illegalMaxValues);
		}

		return new ValidationResult(validMaxValues, warnings);
	}
	
	@Override
	public String toString() {
		return "[StringRequest name:" + name + " id:" + id + "]";
	}

	@Override
	public boolean useNoGenerators() {
		return useNoGenerators;
	}

	@Override
	public void setUseNoGenerators(boolean value) {
		useNoGenerators = value;
	}

}
