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
 * This class applies the {@link SimpleUnicodeNumeralsOperator} to a list of valid values.
 * 
 * @author Jasper v. Blanckenburg (jasper.von.blanckenburg@fokus.fraunhofer.de)
 *
 */
public class UnicodeNumeralsOperator extends ComposedFuzzingHeuristic<String> implements StringOperator {

	private static final long serialVersionUID = 7094596691543417038L;
	protected String param;
	
	public UnicodeNumeralsOperator(List<String> validValues, String param,
			StringSpecification stringSpec, long seed) {
		this(validValues, param, stringSpec, seed, new LinkedList<FuzzingHeuristic>());
	}

	public UnicodeNumeralsOperator(List<String> validValues, String param,
			StringSpecification stringSpec, long seed, List<FuzzingHeuristic> owners) {
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
			SimpleUnicodeNumeralsOperator unicodeNumeralsOperator = new SimpleUnicodeNumeralsOperator(
					validValue, param, stringSpec, seed, owners);
			heuristics.add(unicodeNumeralsOperator);
		}
	}

	@Override
	public String getName() {
		return "UnicodeNumerals";
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
