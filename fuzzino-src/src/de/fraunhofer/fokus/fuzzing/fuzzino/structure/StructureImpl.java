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
