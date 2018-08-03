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
package de.fraunhofer.fokus.fuzzing.fuzzino.structure;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StructureSpecificationImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FieldImpl;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class StructureImpl implements Structure {

	private List<Field> fields = new ArrayList<>();
	@XmlElement(name = "specification",type = StructureSpecificationImpl.class)
	private StructureSpecification strucSpec;

	@Override
	@XmlElement(name = "field",type = FieldImpl.class)
	public List<Field> getFields() {
		return fields;
	}

	@Override
	public void setFields(List<Field> fields) {
		this.fields=fields;		
	}

	@Override
	public void add(Field structureField) {
		fields.add(structureField);
	}

	@Override
	public void setStructureSpecification(StructureSpecification strucSpec) {
		this.strucSpec = strucSpec;
	}

	@Override
	public StructureSpecification getSpecification() {
		return strucSpec;
	}

	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("struct {\n");
		for(Field field:fields){
			sb.append("\t" );
			sb.append(field.toString().replaceAll("\n", "\t\n"));
			sb.append("\n");
		}
		sb.append("}");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof StructureImpl){
			StructureImpl other = (StructureImpl) o;
			return strucSpec.equals(other.getSpecification()) && fields.equals(other.getFields());
		} else{
			return false;
		}
	}
}
