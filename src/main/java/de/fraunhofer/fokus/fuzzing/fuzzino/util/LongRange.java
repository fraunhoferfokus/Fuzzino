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

public class LongRange {
		
		protected long start;
		protected long end;
		
		public LongRange(long theStart, long theEnd) {
			if (theStart > theEnd) {
				throw new IllegalArgumentException();
			}
			start = theStart;
			end = theEnd;
		}
		
		public long start() {
			return start;
		}

		public long end() {
			return end;
		}
		
		public int size() {
			return (int)(end - start + 1);
		}
		
		@Override
		public String toString() {
			return "LongRange(" + start + ", " + end + ")";
		}
	}

