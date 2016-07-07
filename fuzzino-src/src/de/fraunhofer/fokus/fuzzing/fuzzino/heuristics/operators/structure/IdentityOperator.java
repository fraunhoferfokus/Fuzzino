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

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.SimpleFuzzingOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.StructureOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;

/***
 * Creates exactly one structure which is exactly the same as the inputStructure 
 * (necessary for fuzzing requests that just want to fuzz the values of the internal fields of the structure, but not the structure itsself)
 * @author Leon Bornemann (leon.bornemann@fokus.fraunhofer.de ) 
 *
 */
public class IdentityOperator extends SimpleFuzzingOperator<Structure> implements StructureOperator {

	public IdentityOperator(Structure inputValue, long seed) {
		super(inputValue, seed);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getName() {
		return "Identity";
	}

	@Override
	public FuzzedValue<Structure> computeElement(int index) {
		if(index<size()){
			//TODO: do we need a copy at all, do we need a shallow copy, or do we need a deepcopy? think about this
			Structure fuzzedStructure = StructureOperatorUtil.copyStructure(inputValue);
			FuzzedValue<Structure> fuzzVal = new FuzzedValue<Structure>(fuzzedStructure,inputValue,this);
			return fuzzVal;
		} else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int size() {
		return 1;
	}

}