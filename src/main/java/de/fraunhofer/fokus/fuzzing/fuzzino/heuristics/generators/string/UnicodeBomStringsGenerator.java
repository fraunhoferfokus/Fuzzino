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

import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringEncoding;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

public class UnicodeBomStringsGenerator extends ComposedStringGenerator {

	private static final long serialVersionUID = 150381368550979048L;

	public UnicodeBomStringsGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
		this.owners.add(this);
		initHeuristics();
	}
	
	public UnicodeBomStringsGenerator(List<FuzzingHeuristic> owners, long seed, StringSpecification stringSpec) {
		super(stringSpec, seed, owners);
		this.owners.add(this);
		initHeuristics();
	}
	
	private void initHeuristics() {
		StringRepeater bomMarker1 = new StringRepeater(stringSpec, owners, seed, new StringRepeater.Builder()
		                                                                .stepSize(2)
		                                                                .size(1024)
		                                                                .prefix("\\xfe;\\xff;"));
		StringRepeater bomMarker2 = new StringRepeater(stringSpec, owners, seed, new StringRepeater.Builder()
		                                                                .stepSize(2)
		                                                                .size(1024)
		                                                                .prefix("\\xff;\\xef;"));
		StringRepeater bomMarker3 = new StringRepeater(stringSpec, owners, seed, new StringRepeater.Builder()
		                                                                .stepSize(2)
		                                                                .size(1024)
		                                                                .prefix("\\xef;\\xbb;\\xbf;"));
		
		heuristics.add(bomMarker1);
		heuristics.add(bomMarker2);
		heuristics.add(bomMarker3);
		heuristics.add(new SpecialUnicodeBomStringsGenerator(owners, seed, stringSpec));

	}

	@Override
	public String getName() {
		return "UnicodeBomStrings";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification spec) {
		boolean properType = spec.getType() == StringType.STRING;
		StringEncoding encoding = spec.getEncoding();
		boolean properEncoding = encoding == StringEncoding.UTF8 || 
				                 encoding == StringEncoding.UTF16 ||
				                 encoding == StringEncoding.UTF32;
		return properType && properEncoding;
	}
	
}