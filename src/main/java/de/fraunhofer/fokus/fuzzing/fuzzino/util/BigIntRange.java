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

import java.math.BigInteger;

public class BigIntRange {

	protected BigInteger start;
	protected BigInteger end;
	
	public BigIntRange(BigInteger theStart, BigInteger theEnd) {
		if (theStart.compareTo(theEnd) > 0) {
			throw new IllegalArgumentException();
		}
		
		start = theStart;
		end = theEnd;
	}
	
	public BigInteger start() {
		return start;
	}

	public BigInteger end() {
		return end;
	}
	
	public int size() {
		return end.subtract(start).add(BigInteger.ONE).intValue();
	}
	
	@Override
	public String toString() {
		return "BigIntRange(" + start + ", " + end + ")";
	}
}
