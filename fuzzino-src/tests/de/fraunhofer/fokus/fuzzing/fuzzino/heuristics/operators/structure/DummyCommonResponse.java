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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.structure;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.CommonResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.WarningsSection;

/***
 * Empty class for testing purposes
 * @author Leon Bornemann (leon.bornemann@fokus.fraunhofer.de ) 
 *
 */
public class DummyCommonResponse implements CommonResponse {

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean moreValuesAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setMoreValuesAvailable(boolean value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public long getSeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSeed(long value) {
		// TODO Auto-generated method stub

	}

	@Override
	public WarningsSection getWarningsSection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWarningsSection(WarningsSection value) {
		// TODO Auto-generated method stub

	}

}
