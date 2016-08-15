package de.fraunhofer.fokus.fuzzing.fuzzino.response.java;

import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;

public interface GrammarResponse extends CommonResponse,Iterable<FuzzedValue<String>> {

	public List<FuzzedValue<String>> getFuzzedValues();
	
	public void setFuzzedValues(List<FuzzedValue<String>> fuzzedValues);
	
	public void addFuzzedValue(FuzzedValue<String> val);
}
