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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.structure;

import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.SimpleFuzzingOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.StructureOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;

/***
 * Dublicates Fields in the specified structure, can create up n elements where n is the number of fields in the original structure:
 * If InputValue is : structure with fields (f1,....,fn) 
 * Then computeElement(i) will return structure with fields (f1,....,fi,fi,....fn) (n+1 elements)
 * @author Leon Bornemann (leon.bornemann@fokus.fraunhofer.de ) 
 *
 */
public class DublicateFieldOperator extends SimpleFuzzingOperator<Structure> implements StructureOperator {

	public DublicateFieldOperator(Structure inputValue, long seed) {
		super(inputValue, seed);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getName() {
		return "DublicateField";
	}

	@Override
	public FuzzedValue<Structure> computeElement(int index) {
		if(index<size()){
			Structure fuzzedStructure = StructureOperatorUtil.copyStructure(inputValue);
			List<Field> fuzzedFields = fuzzedStructure.getFields();
			fuzzedFields.add(index, fuzzedFields.get(index));
			FuzzedValue<Structure> fuzzVal = new FuzzedValue<Structure>(fuzzedStructure,inputValue,this);
			return fuzzVal;
		} else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int size() {
		return inputValue.getFields().size();
	}

}
