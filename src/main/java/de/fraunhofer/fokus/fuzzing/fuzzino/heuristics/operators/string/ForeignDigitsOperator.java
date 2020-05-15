package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComposedFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.FuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.SimpleFuzzingOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.StringOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

/**
 * This class applies the {@link SimpleForeignDigitsOperator} to a list of valid values.
 * 
 * For the meaning of the parameter, see {@link SimpleForeignDigitsOperator}
 * 
 * @author Jasper v. Blanckenburg (jasper.von.blanckenburg@fokus.fraunhofer.de)
 *
 */
public class ForeignDigitsOperator extends ComposedFuzzingHeuristic<String> implements StringOperator {

	private static final long serialVersionUID = -5704531761677949713L;
	protected String param;
	
	public ForeignDigitsOperator(List<String> validValues, String param, StringSpecification stringSpec, long seed) {
		this(validValues, param, stringSpec, seed, new LinkedList<FuzzingHeuristic>());
	}
	
	public ForeignDigitsOperator(List<String> validValues, String param, StringSpecification stringSpec, long seed, List<FuzzingHeuristic> owners) {
		super(seed, owners);
		this.param = param;
		this.owners.add(this);
		if (validValues == null) {
			throw new IllegalArgumentException("validValues must not be null");
		}
		initHeuristics(stringSpec, validValues);
	}
	
	private void initHeuristics(StringSpecification stringSpec, List<String> validValues) {
		if (stringSpec == null) {
			stringSpec = RequestFactory.INSTANCE.createStringSpecification();
			stringSpec.setType(StringType.NUMBER);
		}
		for (String validValue : validValues) {
			SimpleForeignDigitsOperator foreignDigitsOperator = new SimpleForeignDigitsOperator(validValue, param, stringSpec, seed, owners);
			heuristics.add(foreignDigitsOperator);
		}
	}

	@Override
	public String getName() {
		return "ForeignDigits";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		return stringSpec.getType() == StringType.NUMBER;
	}

	@Override
	public List<String> getValidValues() {
		List<String> validValues = new ArrayList<>(heuristics.size()); 
		for (ComputableFuzzingHeuristic<String> fuzzingHeuristic : heuristics) {
			SimpleFuzzingOperator<String> simpleOperator = (SimpleFuzzingOperator<String>)fuzzingHeuristic;
			validValues.add(simpleOperator.getInputValue());
		}
		
		return validValues;
	}

}
