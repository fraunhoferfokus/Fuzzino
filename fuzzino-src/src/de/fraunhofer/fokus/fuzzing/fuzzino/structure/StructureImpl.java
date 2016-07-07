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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.CommonResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Field;

public class StructureImpl implements Structure {

	private List<Field<CommonResponse>> fields = new ArrayList<>();
	private StructureSpecification strucSpec;

	@Override
	public List<Field<CommonResponse>> getFields() {
		return fields;
	}

	@Override
	public void setFields(List<Field<CommonResponse>> fields) {
		this.fields=fields;		
	}

	@Override
	public void add(Field<CommonResponse> structureField) {
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
		for(Field<CommonResponse> field:fields){
			sb.append("\t" );
			sb.append(field.toString().replaceAll("\n", "\t\n"));
			sb.append("\n");
		}
		sb.append("}");
		return sb.toString();
	}
}
