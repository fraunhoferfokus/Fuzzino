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

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsSection;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class WarningsSectionImpl implements WarningsSection {
	
	private static final long serialVersionUID = -683598546259218295L;
	
	@XmlElement(name = "illegalGenerator",type = IllegalGeneratorImpl.class)
	protected List<IllegalGenerator> illegalGenerators;
	
	@XmlElement(name = "illegalOperators",type = IllegalOperatorImpl.class)
	protected List<IllegalOperator> illegalOperators;
	
	@XmlElement(name = "illegalRequestFormat",type = IllegalRequestFormatImpl.class)
	protected List<IllegalRequestFormat> illegalRequestFormats;
	
	@XmlAttribute
	protected boolean hasMoreValues = true;

	@Override
	public List<IllegalGenerator> getIllegalGenerators() {
		if (illegalGenerators == null) {
			illegalGenerators = new LinkedList<>();
		}
		return illegalGenerators;
	}

	@Override
	public List<IllegalOperator> getIllegalOperators() {
		if (illegalOperators == null) {
			illegalOperators = new LinkedList<>();
		}
		return illegalOperators;
	}

	@Override
	public List<IllegalRequestFormat> getIllegalRequestFormats() {
		if (illegalRequestFormats == null) {
			illegalRequestFormats = new LinkedList<>();
		}
		return illegalRequestFormats;
	}

	@Override
	public boolean hasMoreValues() {
		return hasMoreValues;
	}
	
	@Override
	public void setMoreValues(boolean value) {
		hasMoreValues = value;
	}

	@Override
	public WarningsSection merge(WarningsSection other) {
		WarningsSection mergedWarningsPart = de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory.INSTANCE.createWarnings();
		
		mergedWarningsPart.getIllegalGenerators().addAll(getIllegalGenerators());
		mergedWarningsPart.getIllegalGenerators().addAll(other.getIllegalGenerators());
		
		mergedWarningsPart.getIllegalOperators().addAll(getIllegalOperators());
		mergedWarningsPart.getIllegalOperators().addAll(other.getIllegalOperators());
		
		mergedWarningsPart.getIllegalRequestFormats().addAll(getIllegalRequestFormats());
		mergedWarningsPart.getIllegalRequestFormats().addAll(other.getIllegalRequestFormats());
		
		return mergedWarningsPart;
	}

	@Override
	public void add(WarningsSection other) {
		getIllegalGenerators().addAll(other.getIllegalGenerators());
		getIllegalOperators().addAll(other.getIllegalOperators());
		getIllegalRequestFormats().addAll(other.getIllegalRequestFormats());
	}
	
	@Override
	public String toString() {
		return "[WarningsPart illegalGenerators:" + (illegalGenerators == null ? "0" : illegalGenerators.size()) +
			   " illegalOperators:" + (illegalOperators == null ? "0" : illegalOperators.size()) +
			   " illegalRequestFormats:" + (illegalRequestFormats == null ? "0" : illegalRequestFormats.size()) +
			   " hasMoreValues:" + hasMoreValues + "]"; 
	}
	
}
