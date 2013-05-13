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
package de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalRequestFormat;

public class IllegalRequestFormatImpl implements IllegalRequestFormat {

	protected String attribute;
	protected String element;
	protected String missingAttribute;
	protected String missingElement;
	
	@Override
	public String getAttribute() {
		return attribute;
	}

	@Override
	public void setAttribute(String value) {
		attribute = value;
	}

	@Override
	public String getElement() {
		return element;
	}

	@Override
	public void setElement(String value) {
		element = value;
	}

	@Override
	public String getMissingAttribute() {
		return missingAttribute;
	}

	@Override
	public void setMissingAttribute(String value) {
		missingAttribute = value;
	}

	@Override
	public String getMissingElement() {
		return missingElement;
	}

	@Override
	public void setMissingElement(String value) {
		missingElement = value;
	}

	@Override
	public de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat getEMFRepresentation() {
		de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat
		   emfIllegalRequestFormat = ResponseFactory.eINSTANCE.createIllegalRequestFormat();
		
		emfIllegalRequestFormat.setAttribute(getAttribute());
		emfIllegalRequestFormat.setElement(getElement());
		emfIllegalRequestFormat.setMissingAttribute(getMissingAttribute());
		emfIllegalRequestFormat.setMissingElement(getMissingElement());
		
		return emfIllegalRequestFormat;
	}
	
	@Override
	public String toString() {
		return "[IllegalRequestFormat" + (element == null ? "" : " element:" + element) +
				                         (attribute == null ? "" : " attribute:" + attribute) +
				                         (missingElement == null ? "" : " missingElement:" + missingElement) + 
				                         (missingAttribute == null ? "" : " missingAttribute:" + missingAttribute) + "]";
	}

}
