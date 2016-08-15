package de.fraunhofer.fokus.fuzzing.fuzzino.structure;

import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Field;

public interface Structure {
	
	List<Field> getFields();
	
	void setFields(List<Field> fields);

	void add(Field structureField);
	
	public StructureSpecification getSpecification();

	public void setStructureSpecification(StructureSpecification strucSpec);	

}
