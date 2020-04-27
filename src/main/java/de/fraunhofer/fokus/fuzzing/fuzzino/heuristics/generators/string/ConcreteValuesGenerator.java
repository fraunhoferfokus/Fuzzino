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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string;

import java.util.ArrayList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringEncoder;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class ConcreteValuesGenerator extends SimpleStringGenerator {
	
	private static final long serialVersionUID = 5541804481410615881L;
	protected final List<String> fuzzValues = new ArrayList<>();
	protected final List<Integer> fuzzValueLengths = new ArrayList<>();
	
	public ConcreteValuesGenerator(StringSpecification stringSpec, long seed, List<FuzzingHeuristic> owners, String ...values) {
		super(stringSpec, seed, owners);
		this.owners.add(this);
		addAll(StringUtil.asList(values));
	}

	@Override
	public String getName() {
		return "DotGenerator";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpecification) {
		return true;
	}

	@Override
	public boolean matchesSpecification(FuzzedValue<String> value) {
		return true;
	}
	
	protected void addAll(List<String> list) {
		for (String str : list) {
			add(str);
		}
		findMatchingValues();
	}
	
	protected void add(String value) {
		fuzzValues.add(value);
		fuzzValueLengths.add(StringEncoder.length(value));
	}

	@Override
	public List<String> getFuzzValues() {
		return fuzzValues;
	}
	
	@Override
	public List<Integer> getFuzzValueLengths() {
		return fuzzValueLengths;
	}

}
