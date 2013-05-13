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
package de.fraunhofer.fokus.fuzzing.fuzzino.request.java;

import java.io.Serializable;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ValidationResult;

/**
 * Common base class for all specifications.
 * This element is an additional specification for a request. It gives hints
 * to the fuzzing library that reduces the set of fuzz testing values in a
 * reasonable way by omitting values that are not appropriate to this specification.

 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface TypeSpecification  extends Serializable {
	
	/**
	 * @return A validation result containing the information whether this specification is valid
	 *         and - if not - the corresponding warnings.
	 */
	ValidationResult validate();
	
	/**
	 * Initializes this specification with the values of the corresponding object of the EMF class
	 * {@link de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification}.
	 * 
	 * @param emfRequestSpecification The EMF request specification whose values shall be transferred
	 *                                to this specification.
	 */
	void setWithEMFObject(RequestSpecification emfRequestSpecification);

}
