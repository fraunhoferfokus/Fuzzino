package de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.GrammarResponse;

public class GrammarResponseImpl extends AbstractResponse implements GrammarResponse {

	protected List<FuzzedValue<String>> fuzzedValues;

	@Override
	public Iterator<FuzzedValue<String>> iterator() {
		return fuzzedValues.iterator();
	}

	@Override
	public List<FuzzedValue<String>> getFuzzedValues() {
		return Collections.unmodifiableList(fuzzedValues);
	}

	@Override
	public void setFuzzedValues(List<FuzzedValue<String>> fuzzedValues) {
		this.fuzzedValues = fuzzedValues;
		
	}

	@Override
	public void addFuzzedValue(FuzzedValue<String> value) {
		if (fuzzedValues == null) {
			fuzzedValues = new LinkedList<>();
		}
		fuzzedValues.add(value);
		
	}

}
