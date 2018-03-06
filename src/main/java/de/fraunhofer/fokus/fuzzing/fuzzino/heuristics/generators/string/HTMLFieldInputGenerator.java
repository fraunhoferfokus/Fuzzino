package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

public class HTMLFieldInputGenerator extends ComposedStringGenerator {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8107495173162069001L;
	private String attackerURL;

	public HTMLFieldInputGenerator(StringSpecification stringSpec,long seed, String attackerURL) {
		super(stringSpec, seed);
		this.attackerURL = attackerURL;
		initHeuristics();
	}
	
	public HTMLFieldInputGenerator(StringSpecification stringSpec,long seed,ComputableFuzzingHeuristic<?> owner, String attackerURL) {
		super(stringSpec, seed, owner);
		this.attackerURL = attackerURL;
		initHeuristics();
	}
	
	private void initHeuristics() {
		heuristics.add(new AllXSSGenerator(stringSpec, seed, owner, attackerURL));
		heuristics.add(new SQLInjectionsGenerator(seed, stringSpec, owner));
		
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		return  stringSpec.getType()==StringType.XSS ||  stringSpec.getType()==StringType.SQL;
	}

	@Override
	public String getName() {
		return "HTMLFieldInputGenerator";
	}

}
