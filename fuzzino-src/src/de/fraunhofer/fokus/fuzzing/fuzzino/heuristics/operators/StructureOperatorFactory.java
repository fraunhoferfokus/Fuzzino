package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators;

import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.structure.DeleteFieldOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.structure.DublicateFieldOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.structure.IdentityOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.structure.NeighbouringFieldSwapOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.structure.TypeConformFieldSwapOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.structure.TypeUnConformFieldSwapOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;

/***
 * Class that is responsible to create the different operators
 * 
 * @author Leon Bornemann (leon.bornemann@fokus.fraunhofer.de )
 *
 */
public class StructureOperatorFactory {

	public static final StructureOperatorFactory INSTANCE = new StructureOperatorFactory();

	private StructureOperatorFactory(){
	}
	
	public List<StructureOperator> createAll(Structure inputValue, long seed) {
		List<StructureOperator> list = new LinkedList<>();
		list.add(createDeleteFieldOperator(inputValue, seed));
		list.add(createDublicateFieldOperator(inputValue, seed));
		list.add(createTypeUnConformFieldSwapOperator(inputValue, seed));
		list.add(createTypeConformFieldSwapOperator(inputValue, seed));
		list.add(createNeighbouringFieldSwapOperator(inputValue, seed));
		//Identity Operator is not here since that is a special case - maybe make the whole identity thing as a generator?
		return list;
	}

	public StructureOperator create(String name, String parameter,Structure inputValue, long seed) throws UnknownFuzzingHeuristicException {
		String canonicalName = name.trim().toUpperCase();
		//TODO:Redundanz entfernen
		if(canonicalName.equals("DublicateField".toUpperCase())){
			return createDublicateFieldOperator(inputValue,seed);
		} else if(canonicalName.equals("DeleteField".toUpperCase())){
			return createDeleteFieldOperator(inputValue,seed);
		} else if(canonicalName.equals("Identity".toUpperCase())){
			return createIdentityOperator(inputValue,seed);
		} else if(canonicalName.equals("NeighbouringFieldSwapOperator")){
			return createNeighbouringFieldSwapOperator(inputValue,seed);
		} else if(canonicalName.equals("TypeConformFieldSwapOperator")){
			return createTypeConformFieldSwapOperator(inputValue,seed);
		} else if(canonicalName.equals("TypeUnConformFieldSwapOperator")){
			return createTypeUnConformFieldSwapOperator(inputValue,seed);
		} else{
			throw new UnknownFuzzingHeuristicException(name);
		}
	}

	public StructureOperator createTypeUnConformFieldSwapOperator(Structure inputValue, long seed) {
		return new TypeUnConformFieldSwapOperator(inputValue,seed);
	}

	public StructureOperator createTypeConformFieldSwapOperator(Structure inputValue, long seed) {
		return new TypeConformFieldSwapOperator(inputValue,seed);
	}

	public StructureOperator createNeighbouringFieldSwapOperator(Structure inputValue, long seed) {
		return new NeighbouringFieldSwapOperator(inputValue,seed);
	}

	public StructureOperator createDeleteFieldOperator(Structure inputValue,long seed) {
		return new DeleteFieldOperator(inputValue,seed);
	}
	
	public StructureOperator createDublicateFieldOperator(Structure inputValue,long seed) {
		return new DublicateFieldOperator(inputValue,seed);
	}

	public StructureOperator createIdentityOperator(Structure inputValue,long seed) {
		return new IdentityOperator(inputValue,seed);
	}


}
