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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedValuesByGenerators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedValuesByOperators;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class NumberResponseImpl<T> extends AbstractResponse implements NumberResponse<T> {
	
	@XmlElement(name = "generatorBased",type = FuzzedValuesByGeneratorsImpl.class)
	protected FuzzedValuesByGenerators<T> allGeneratorsBasedPart;
	@XmlElement(name = "operatorBased",type = FuzzedValuesByOperatorsImpl.class)
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
	public String toString() {
		return "[NumberResponse name:" + getName() + " id:" + getId() + " seed:" + getSeed() + " moreValues:" + moreValuesAvailable() +
			   " allGeneratorsBasedPart: " + (allGeneratorsBasedPart != null) +
			   " allOperatorsBasedPart:" + (allOperatorsBasedPart != null) +
			   " warningsPart:" + (getWarningsSection() != null) + "]";
	}

}
