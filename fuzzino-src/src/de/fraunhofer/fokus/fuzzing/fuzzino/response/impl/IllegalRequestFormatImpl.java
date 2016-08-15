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
package de.fraunhofer.fokus.fuzzing.fuzzino.response.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class IllegalRequestFormatImpl implements IllegalRequestFormat {

	@XmlAttribute
	protected String attribute;
	@XmlAttribute
	protected String element;
	@XmlAttribute
	protected String missingAttribute;
	@XmlAttribute
	protected String missingElement;
	
	public IllegalRequestFormatImpl() {
	}
	
	public IllegalRequestFormatImpl(String attribute, String element, String missingAttribute, String missingElement) {
		this.attribute = attribute;
		this.element = element;
		this.missingAttribute = missingAttribute;
		this.missingElement = missingElement;
	}

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
	public String toString() {
		return "[IllegalRequestFormat" + (element == null ? "" : " element:" + element) +
				                         (attribute == null ? "" : " attribute:" + attribute) +
				                         (missingElement == null ? "" : " missingElement:" + missingElement) + 
				                         (missingAttribute == null ? "" : " missingAttribute:" + missingAttribute) + "]";
	}
	
	@Override
	public boolean equals(Object o){
		if( o instanceof IllegalRequestFormatImpl){
			IllegalRequestFormatImpl other = (IllegalRequestFormatImpl) o;
			return attribute.equals(other.getAttribute()) && element.equals(other.getElement()) && 
					missingAttribute.equals(other.getMissingAttribute()) && missingElement.equals(other.getMissingElement());
		} else{
			return false;
		}
	}

}
