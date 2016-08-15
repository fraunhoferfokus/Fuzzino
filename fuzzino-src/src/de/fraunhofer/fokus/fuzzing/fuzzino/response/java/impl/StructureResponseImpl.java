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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StructureResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class StructureResponseImpl extends AbstractResponse implements StructureResponse {

	@XmlElement(name = "fuzzedValue" ,type = FuzzedValue.class)
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
	public String toString() {
		return "[StructureResponse name:" + getName() + " id:" + getId() + " seed:" + getSeed() + " moreValues:" + moreValuesAvailable() +
			   " warningsPart:" + (getWarningsSection() != null) + " fuzzedStructures:" + fuzzedStructures.size() + "]";
	}

	@Override
	public Iterator<FuzzedValue<Structure>> iterator() {
		return fuzzedStructures.iterator();
	}

}
