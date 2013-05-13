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
 * This class represents tells the fuzzing library that no further values will be requested. After closing a request, 
 * no further values can be requested for the closed request.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface CloseRequest extends Serializable {
	
	/**
	 * @return the id of the request to be closed.
	 */
	String getId();
	
	/**
	 * @param value the id of the request to be closed.
	 */
	void setId(String value);
	
	/**
	 * Sets all the attributes to the values of the corresponding EMF object.
	 * 
	 * @param emfCloseRequest
	 */
	void setWithEMFObject(de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest emfCloseRequest);
	
}
