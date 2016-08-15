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
package de.fraunhofer.fokus.fuzzing.fuzzino.response.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedValuesByGenerators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorSpecificFuzzedValues;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class FuzzedValuesByGeneratorsImpl<T> implements FuzzedValuesByGenerators<T> {

	@XmlElement(name = "generator",type = GeneratorSpecificFuzzedValuesImpl.class)
	protected List<GeneratorSpecificFuzzedValues<T>> generatorSections;
	
	@Override
	public List<GeneratorSpecificFuzzedValues<T>> getGeneratorSpecificSections() {
		return (generatorSections == null ? null : Collections.unmodifiableList(generatorSections));
	}
	
	@Override
	public void setGeneratorSpecificSections(Collection<GeneratorSpecificFuzzedValues<T>> value) {
		generatorSections = new ArrayList<>(value);
	}

	@Override
	public void addGeneratorSpecificSection(GeneratorSpecificFuzzedValues<T> value) {
		if (generatorSections == null) {
			generatorSections = new ArrayList<>();
		}
		generatorSections.add(value);
	}

	@Override
	public String toString() {
		return "[AllGeneratorsBasedPart + generatorParts:" + (generatorSections == null ? "0" : generatorSections.size()) + "]";
	}

	@Override
	public Iterator<GeneratorSpecificFuzzedValues<T>> iterator() {
		return generatorSections.iterator();
	}

}
