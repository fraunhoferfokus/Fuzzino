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
package de.fraunhofer.fokus.fuzzing.fuzzino.util;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class IntegerFromRangesBuilder {
	
	private List<Range> allRanges;
	
	public IntegerFromRangesBuilder(int start, int end) {
		allRanges = new LinkedList<>();
		allRanges.add(new Range(start, end));
	}
	
	public IntegerFromRangesBuilder(Range range) {
		allRanges = new LinkedList<>();
		allRanges.add(range);
	}
	
	public IntegerFromRangesBuilder addRange(int start, int end) {
		allRanges.add(new Range(start, end));
		
		return this;
	}
	
	public IntegerFromRangesBuilder addRange(Range range) {
		allRanges.add(range);
		
		return this;
	}
	
	public List<Range> allRanges() {
		return Collections.unmodifiableList(allRanges);
	}

}
