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

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StructureResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;

public class StructureResponseImpl extends AbstractResponse implements StructureResponse {

	protected List<FuzzedValue<Structure>> fuzzedStructures;
	
	@Override
	public List<FuzzedValue<Structure>> getFuzzedStructures() {
		return Collections.unmodifiableList(fuzzedStructures);
	}

	@Override
	public void setFuzzedStructures(List<FuzzedValue<Structure>> value) {
		fuzzedStructures = value;
	}

	@Override
	public void addFuzzedStructure(FuzzedValue<Structure> value) {
		if (fuzzedStructures == null) {
			fuzzedStructures = new LinkedList<>();
		}
		fuzzedStructures.add(value);
	}

	@Override
	public de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse getEMFRepresentation() {
		//TODO: This is a problem, It can't work yet unless we adapt the emf model, which is not up to date with the reimplemented version inside the 'java' packages
		/*de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse
		  emfStructureResponse = ResponseFactory.eINSTANCE.createStructureResponse();
		
		for (FuzzedStructure fuzzedStructure : fuzzedStructures) {
			emfStructureResponse.getFuzzedStructures().add(fuzzedStructure.getEMFRepresentation());
		}
		emfStructureResponse.setWarnings(getWarningsSection().getEMFRepresentation());
		emfStructureResponse.setId(getId());
		emfStructureResponse.setMoreValues(moreValuesAvailable());
		emfStructureResponse.setName(getName());
		emfStructureResponse.setSeed(String.valueOf(getSeed()));
		
		return emfStructureResponse;*/
		throw new AssertionError("EMF Representation not supported!");
	}
	
	@Override
	public String toString() {
		return "[StructureResponse name:" + getName() + " id:" + getId() + " seed:" + getSeed() + " moreValues:" + moreValuesAvailable() +
			   " warningsPart:" + (getWarningsSection() != null) + " fuzzedStructures:" + fuzzedStructures.size() + "]";
	}

	@Override
	public Iterator<FuzzedValue<Structure>> iterator() {
		return fuzzedStructures.iterator();
	}

}
