//   Copyright 2012-2014 Fraunhofer FOKUS
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
package de.fraunhofer.fokus.fuzzing.fuzzino.request;

import java.io.Serializable;

/**
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface Attribute extends Serializable {

	/**
	 * @return The name of the attribute.
	 */
	String getName();
	
	/**
	 * Sets the name of the attriute
	 * 
	 * @param value The name of the attribute.
	 */
	void setName(String value);
	
	/**
	 * @return The name of request that specifies the type for this attribute.
	 */
	String getRef();
	
	/**
	 * Set the name of the request that specifies
	 * 
	 * @param value
	 */
	void setRef(String value);
	
	
	
}
