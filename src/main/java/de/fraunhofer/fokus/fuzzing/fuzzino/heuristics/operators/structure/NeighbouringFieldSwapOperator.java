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
