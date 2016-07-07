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
package de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedValuesByGenerators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedValuesByOperators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.NumberResponse;

public class NumberResponseImpl<T> extends AbstractResponse implements NumberResponse<T> {
	
	protected FuzzedValuesByGenerators<T> allGeneratorsBasedPart;
	protected FuzzedValuesByOperators<T> allOperatorsBasedPart;

	@Override
	public FuzzedValuesByGenerators<T> getGeneratorBasedSection() {
		return allGeneratorsBasedPart;
	}

	@Override
	public void setGeneratorBasedSection(FuzzedValuesByGenerators<T> value) {
		allGeneratorsBasedPart = value;
	}

	@Override
	public FuzzedValuesByOperators<T> getOperatorBasedSection() {
		return allOperatorsBasedPart;
	}

	@Override
	public void setOperatorBasedSection(FuzzedValuesByOperators<T> value) {
		allOperatorsBasedPart = value;
	}

	@Override
	public de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse getEMFRepresentation() {
		de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse
		  emfNumberResponse = ResponseFactory.eINSTANCE.createNumberResponse();
		
		if (getGeneratorBasedSection() != null) {
			emfNumberResponse.setGeneratorBasedPart(getGeneratorBasedSection().getEMFRepresentation());
		}
		if (getOperatorBasedSection() != null) {
			emfNumberResponse.setOperatorBasedPart(getOperatorBasedSection().getEMFRepresentation());
		}
		if (getWarningsSection() != null) {
			emfNumberResponse.setWarnings(getWarningsSection().getEMFRepresentation());
		}
		emfNumberResponse.setId(getId());
		emfNumberResponse.setMoreValues(moreValuesAvailable());
		emfNumberResponse.setName(getName());
		emfNumberResponse.setSeed(String.valueOf(getSeed()));
		
		return emfNumberResponse;
	}
	
	@Override
	public String toString() {
		return "[NumberResponse name:" + getName() + " id:" + getId() + " seed:" + getSeed() + " moreValues:" + moreValuesAvailable() +
			   " allGeneratorsBasedPart: " + (allGeneratorsBasedPart != null) +
			   " allOperatorsBasedPart:" + (allOperatorsBasedPart != null) +
			   " warningsPart:" + (getWarningsSection() != null) + "]";
	}

}
