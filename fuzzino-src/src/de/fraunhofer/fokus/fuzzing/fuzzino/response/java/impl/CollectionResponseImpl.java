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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.CollectionResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedCollection;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class CollectionResponseImpl extends AbstractResponse implements CollectionResponse {

	@XmlElement(name = "fuzzedCollection",type = FuzzedCollectionImpl.class)
	protected List<FuzzedCollection> fuzzedCollections;
	
	@Override
	public List<FuzzedCollection> getFuzzedCollections() {
		return Collections.unmodifiableList(fuzzedCollections);
	}
	
	@Override
	public void setFuzzedCollection(List<FuzzedCollection> value) {
		fuzzedCollections = value;
	}

	@Override
	public void addFuzzedCollection(FuzzedCollection value) {
		if (fuzzedCollections == null) {
			fuzzedCollections = new ArrayList<>();
		}
		fuzzedCollections.add(value);
	}
	
	@Override
	public String toString() {
		return "[CollectionResponse name:" + getName() + " id:" + getId() + " seed:" + getSeed() + " moreValues:" + moreValuesAvailable() +
			   " fuzzedCollections: " + (fuzzedCollections == null ? "0" : fuzzedCollections.size()) + "]";
	}

}
