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
package de.fraunhofer.fokus.fuzzing.fuzzino.response.java;

import java.util.ArrayList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.AbstractResponse;

/***
 * Class necessary to include valid values into StructureResponses
 * @author Leon Bornemann (leon.bornemann@fokus.fraunhofer.de ) 
 *
 */
public class ValidValuesResponse<E> extends AbstractResponse {
	
	private List<E> validValues;

	public ValidValuesResponse(List<E> validValues) {
		super();
		this.validValues = validValues;
	}

	public ValidValuesResponse() {
		this(new ArrayList<E>());
	}

	public List<E> getValidValues() {
		return validValues;
	}

	public void setValidValues(List<E> validValues) {
		this.validValues = validValues;
	}
}
