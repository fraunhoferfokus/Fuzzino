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
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.WarningsSection;

public class StringResponseImpl implements StringResponse {

	protected FuzzedValuesByGenerators<String> allGeneratorsBasedPart;
	protected FuzzedValuesByOperators<String> allOperatorsBasedPart;
	protected WarningsSection warningsPart;
	protected String id;
	protected boolean moreValues;
	protected String name;
	protected long seed;
	
	@Override
	public FuzzedValuesByGenerators<String> getGeneratorBasedSection() {
		return allGeneratorsBasedPart;
	}

	@Override
	public void setGeneratorBasedSection(FuzzedValuesByGenerators<String> value) {
		allGeneratorsBasedPart = value;
	}

	@Override
	public FuzzedValuesByOperators<String> getOperatorBasedSection() {
		return allOperatorsBasedPart;
	}

	@Override
	public void setOperatorBasedSection(FuzzedValuesByOperators<String> value) {
		allOperatorsBasedPart = value;
	}

	@Override
	public WarningsSection getWarningsSection() {
		return warningsPart;
	}

	@Override
	public void setWarningsSection(WarningsSection value) {
		warningsPart = value;
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
	public boolean moreValuesAvailable() {
		return moreValues;
	}

	@Override
	public void setMoreValuesAvailable(boolean value) {
		moreValues = value;
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
	public de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse getEMFRepresentation() {
		de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse
		  emfStringResponse = ResponseFactory.eINSTANCE.createStringResponse();
		
		if (getGeneratorBasedSection() != null) {
			emfStringResponse.setGeneratorBasedPart(getGeneratorBasedSection().getEMFRepresentation());
		}
		if (getOperatorBasedSection() != null) {
			emfStringResponse.setOperatorBasedPart(getOperatorBasedSection().getEMFRepresentation());
		}
		if (getWarningsSection() != null) {
			emfStringResponse.setWarnings(getWarningsSection().getEMFRepresentation());
		}
		emfStringResponse.setId(getId());
		emfStringResponse.setMoreValues(moreValuesAvailable());
		emfStringResponse.setName(getName());
		emfStringResponse.setSeed(String.valueOf(getSeed()));
		
		return emfStringResponse;
	}
	
	@Override
	public String toString() {
		return "[StringResponse name:" + name + " id:" + id + " seed:" + seed + " moreValues:" + moreValues +
				" allGeneratorsBasedPart:" + (allGeneratorsBasedPart != null) +
				" allOperatorsBasedPart:" + (allOperatorsBasedPart != null) +
				" warningsPart:" + (warningsPart != null) + "]";
	}

}
