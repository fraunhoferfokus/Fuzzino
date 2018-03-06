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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.LibraryType;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.AbstractRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ValidationResult;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class StructureRequestImpl extends AbstractRequest implements StructureRequest {
	
	private static final long serialVersionUID = -1041640725148717179L;
	protected StructureSpecification specification;
	protected List<Operator> operators;
	
	@XmlAttribute
	protected boolean fuzzStructure = false;
	@XmlAttribute
	protected int maxMutations = 0;
	@XmlAttribute
	protected int minMutations = 1;
	protected transient ValidationResult validationResult = null;
	
	@Override
	@XmlElement(name = "specification",type=StructureSpecificationImpl.class)
	public StructureSpecification getSpecification() {
		return specification;
	}
	
	@Override
	public void setSpecification(StructureSpecification value) {
		specification = value;
	}
	
	@Override
	@XmlElement(name="operator", type=OperatorImpl.class)
	public List<Operator> getRequestedOperators() {
		if (operators == null) {
			operators = new ArrayList<>();
		}
		return operators;
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
