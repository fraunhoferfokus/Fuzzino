package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string;


import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.StringContainer;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.XSSBasicInputStrings;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

public class XSSBasicInputGenerator extends ComposedStringGenerator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6965310336502008538L;
	protected StringContainer xssBasicInputStrings;

	public XSSBasicInputGenerator(StringSpecification stringSpec, long seed, String attackerURL) {
		super(stringSpec, seed);
		xssBasicInputStrings = new XSSBasicInputStrings(attackerURL);
		initHeuristics();
	}
	
	public XSSBasicInputGenerator(StringSpecification stringSpec, long seed,ComputableFuzzingHeuristic<?> owner, String attackerURL) {
		super(stringSpec, seed);
		this.owner = owner;
		xssBasicInputStrings = new XSSBasicInputStrings(attackerURL);
		initHeuristics();
	}

	private void initHeuristics() {
		ConcreteValuesGenerator gen1 = new ConcreteValuesGenerator(stringSpec, seed, owner);
		gen1.addAll(xssBasicInputStrings.getValues());
		heuristics.add(gen1);
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		return stringSpec.getType().equals(StringType.XSS);
	}

	@Override
	public String getName() {
		return "XSSBasicInput";
	}

}
