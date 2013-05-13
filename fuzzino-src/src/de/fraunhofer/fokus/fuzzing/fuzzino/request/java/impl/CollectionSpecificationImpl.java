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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Request;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.CollectionSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.CommonRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.WarningsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ValidationResult;

public class CollectionSpecificationImpl implements CollectionSpecification {

	private static final long serialVersionUID = -4626524333820363957L;
	
	protected String ref;
	protected CommonRequest refSpec;
	protected boolean isUnique;
	protected boolean isOrdered;
	protected int minLength = 0;
	protected int maxLength = Integer.MAX_VALUE;
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
	public void setWithEMFObject(RequestSpecification emfRequestSpecification) {
		ref = emfRequestSpecification.getRef();
		isUnique = emfRequestSpecification.isUnique();
		isOrdered = emfRequestSpecification.isOrdered();
		minLength = emfRequestSpecification.getMinLength();
		maxLength = emfRequestSpecification.getMaxLength();
		
		if (refSpec == null) {
			CollectionRequest collectionRequest = (CollectionRequest)emfRequestSpecification.eContainer();
			Request request = (Request)collectionRequest.eContainer();
			getReferredRequestByName(request);
		}
	}
	
	private void getReferredRequestByName(Request request) {
		for (StringRequest stringRequest : request.getStringRequests()) {
			if (stringRequest.getName().equals(ref)) {
				refSpec = RequestFactory.INSTANCE.createStringRequest(stringRequest);
				return;
			}
		}
		for (NumberRequest numberRequest : request.getNumberRequests()) {
			if (numberRequest.getName().equals(ref)) {
				refSpec = RequestFactory.INSTANCE.createNumberRequest(numberRequest);
				return;
			}
		}
		for (CollectionRequest collectionRequest : request.getCollectionRequests()) {
			if (collectionRequest.getName().equals(ref)) {
				refSpec = RequestFactory.INSTANCE.createCollectionRequest(collectionRequest);
				return;
			}
		}
		for (StructureRequest structureRequest : request.getStructureRequests()) {
			if (structureRequest.getName().equals(ref)) {
				refSpec = RequestFactory.INSTANCE.createStructureRequest(structureRequest);
				return;
			}
		}
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
