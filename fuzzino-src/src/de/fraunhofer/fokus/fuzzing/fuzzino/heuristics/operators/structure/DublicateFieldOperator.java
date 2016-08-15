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
