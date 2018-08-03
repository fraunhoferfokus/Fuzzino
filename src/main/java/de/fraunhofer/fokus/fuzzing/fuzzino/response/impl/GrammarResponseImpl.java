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

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.GrammarResponse;

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
