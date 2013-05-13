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

/**
 * An Operator requests that a specific fuzzing operator shall be applied to the valid values given in the request.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface Operator extends Serializable {

	/**
	 * @return The name of the requested operator.
	 */
	String getOperatorName();
	
	/**
	 * Sets the name of the operator to be used by the fuzzing library.
	 *
	 * @param value The name of the operator. 
	 */
	void setOperatorName(String value);
	
	/**
	 * @return The value of a parameter for this operator.
	 */
	String getParameter();
	
	/**
	 * Some operators may have a parameter that can be used in order to specify how the operator should work.
	 * If no parameter is set for an operator that may have one, its default value for the parameter is used.
	 * 
	 * @param value
	 */
	void setParameter(String value);
	
	/**
	 * Initializes this operator with the values of the corresponding object of the EMF class
	 * {@link de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator}.
	 * 
	 * @param emfOperator The EMF generator whose values shall be transferred to this operator.
	 */
	void setWithEMFObject(de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator emfOperator);
	
}
