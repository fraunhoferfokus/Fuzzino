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