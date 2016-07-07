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

import de.fraunhofer.fokus.fuzzing.fuzzino.LibraryType;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.AbstractRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StructureRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.WarningsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ValidationResult;

public class StructureRequestImpl extends AbstractRequest implements StructureRequest {
	
	private static final long serialVersionUID = -1041640725148717179L;
	protected StructureSpecification specification;
	protected List<Operator> operators;
	protected boolean fuzzStructure = false;
	protected int maxMutations = 0;
	protected int minMutations = 1;
	protected transient ValidationResult validationResult = null;
	
	@Override
	public StructureSpecification getSpecification() {
		return specification;
	}
	@Override
	public void setSpecification(StructureSpecification value) {
		specification = value;
	}
	@Override
	public List<Operator> getRequestedOperators() {
		if (operators == null) {
			operators = new ArrayList<>();
		}
		return operators;
	}
	
	@Override
	public boolean fuzzStructure() {
		return fuzzStructure;
	}
	
	@Override
	public void setFuzzStructure(boolean value) {
		fuzzStructure = value;
	}
	
	@Override
	public int getMaxMutations() {
		return maxMutations;
	}
	
	@Override
	public void setMaxMutations(int value) {
		maxMutations = value;
	}
	
	@Override
	public int getMinMutations() {
		return minMutations;
	}
	
	@Override
	public void setMinMutations(int value) {
		minMutations = value;
	}
	
	@Override
	public void setRequestedOperators(List<Operator> value) {
		getRequestedOperators().addAll(value);
	}
	
	@Override
	public void addRequestedOperator(Operator value) {
		getRequestedOperators().add(value);
	}
	@Override
	public void setWithEMFObject(de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest emfStructureRequest) {
		for (de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator emfOperator : emfStructureRequest.getOperators()) {
			addRequestedOperator(RequestFactory.INSTANCE.createOperator(emfOperator));
		}

		setFuzzStructure(emfStructureRequest.isFuzzStructure());
		setId(emfStructureRequest.getId());
		setMaxMutations(emfStructureRequest.getMaxMutations());
		setMaxValues(emfStructureRequest.getMaxValues());
		setMinMutations(emfStructureRequest.getMinMutations());
		setName(emfStructureRequest.getName());
		setSeed(emfStructureRequest.getSeed());
		setSpecification(RequestFactory.INSTANCE.createStructureSpecification(emfStructureRequest.getSpecification()));
		isEMFBased = true;
	}
	
	@Override
	public ValidationResult validate() {
		if (validationResult == null) {
			WarningsSection warnings = null;
			boolean valid = true;
			// TODO stub
			validationResult = new ValidationResult(valid, warnings);
		}
		return validationResult;
	}
	
	@Override
	public boolean isValid() {
		return validate().isValid();
	}
	
	@Override
	public String toString() {
		return "[StructureRequest name:" + name + " id:" + id + "]";
	}
	
	@Override
	public LibraryType getLibraryType() {
		return LibraryType.STRUCTURE;
	}
	
	
}
