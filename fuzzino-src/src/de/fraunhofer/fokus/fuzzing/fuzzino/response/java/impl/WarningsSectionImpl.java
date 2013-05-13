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

import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.WarningsSection;

public class WarningsSectionImpl implements WarningsSection {
	
	private static final long serialVersionUID = -683598546259218295L;
	protected List<IllegalGenerator> illegalGenerators;
	protected List<IllegalOperator> illegalOperators;
	protected List<IllegalRequestFormat> illegalRequestFormats;
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
	public de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart getEMFRepresentation() {
		de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart
		  emfWarningsPart = ResponseFactory.eINSTANCE.createWarningsPart();
		
		for (IllegalGenerator illegalGenerator : getIllegalGenerators()) {
			emfWarningsPart.getIllegalGenerators().add(illegalGenerator.getEMFRepresentation());
		}
		for (IllegalOperator illegalOperator : getIllegalOperators()) {
			emfWarningsPart.getIllegalOperators().add(illegalOperator.getEMFRepresentation());
		}
		for (IllegalRequestFormat illegalRequestFormat : getIllegalRequestFormats()) {
			emfWarningsPart.getIllegalRequestFormats().add(illegalRequestFormat.getEMFRepresentation());
		}
		if (!hasMoreValues()) {
			de.fraunhofer.fokus.fuzzing.fuzzino.response.NoMoreValuesIndicator indicator =
					ResponseFactory.eINSTANCE.createNoMoreValuesIndicator();
			emfWarningsPart.setFlagNoMoreValues(indicator);
		}
		
		return emfWarningsPart;
	}

	@Override
	public WarningsSection merge(WarningsSection other) {
		WarningsSection mergedWarningsPart = de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ResponseFactory.INSTANCE.createWarnings();
		
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
