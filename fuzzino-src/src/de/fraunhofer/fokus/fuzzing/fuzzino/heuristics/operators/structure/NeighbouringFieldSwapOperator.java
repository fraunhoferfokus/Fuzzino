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
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.SimpleFuzzingOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.StructureOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;

public class NeighbouringFieldSwapOperator extends SimpleFuzzingOperator<Structure> implements StructureOperator {

	private Structure structure;

	public NeighbouringFieldSwapOperator(Structure inputValue, long seed) {
		super(inputValue, seed);
		init(inputValue);
	}
	
	public NeighbouringFieldSwapOperator(Structure inputValue, long seed,ComputableFuzzingHeuristic<?> owner) {
		super(inputValue, seed, owner);
		init(inputValue);
	}
	
	private void init(Structure inputValue){
		this.structure = inputValue;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getName() {
		return "NeighbouringFieldSwapOperator";
	}

	@Override
	public FuzzedValue<Structure> computeElement(int index) {
		if(index<size() && index >= 0){
			Structure fuzzedStructure = StructureOperatorUtil.copyStructure(structure);
			StructureOperatorUtil.swapFields(fuzzedStructure, index, index+1);
			return new FuzzedValue<Structure>(fuzzedStructure,inputValue,this);
		} else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int size() {
		return structure.getFields().size()-1;
	}

}
