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

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedStructure;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StructureResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.WarningsSection;

public class StructureResponseImpl implements StructureResponse {

	protected List<FuzzedStructure> fuzzedStructures;
	protected WarningsSection warningsPart;
	protected String id;
	protected boolean moreValues;
	protected String name;
	protected long seed;
	
	@Override
	public List<FuzzedStructure> getFuzzedStructures() {
		return Collections.unmodifiableList(fuzzedStructures);
	}

	@Override
	public void setFuzzedStructures(List<FuzzedStructure> value) {
		fuzzedStructures = value;
	}

	@Override
	public void addFuzzedStructure(FuzzedStructure value) {
		if (fuzzedStructures == null) {
			fuzzedStructures = new LinkedList<>();
		}
		fuzzedStructures.add(value);
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
	public de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse getEMFRepresentation() {
		de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse
		  emfStructureResponse = ResponseFactory.eINSTANCE.createStructureResponse();
		
		for (FuzzedStructure fuzzedStructure : fuzzedStructures) {
			emfStructureResponse.getFuzzedStructures().add(fuzzedStructure.getEMFRepresentation());
		}
		emfStructureResponse.setWarnings(getWarningsSection().getEMFRepresentation());
		emfStructureResponse.setId(getId());
		emfStructureResponse.setMoreValues(moreValuesAvailable());
		emfStructureResponse.setName(getName());
		emfStructureResponse.setSeed(String.valueOf(getSeed()));
		
		return emfStructureResponse;
	}
	
	@Override
	public String toString() {
		return "[StructureResponse name:" + name + " id:" + id + " seed:" + seed + " moreValues:" + moreValues +
			   " warningsPart:" + (warningsPart != null) + " fuzzedStructures:" + fuzzedStructures.size() + "]";
	}

	@Override
	public Iterator<FuzzedStructure> iterator() {
		return fuzzedStructures.iterator();
	}

}
