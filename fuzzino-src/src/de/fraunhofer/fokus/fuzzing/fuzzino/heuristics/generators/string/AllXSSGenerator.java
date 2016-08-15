package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

public class AllXSSGenerator extends ComposedStringGenerator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5660446360084743986L;
	
	private String attackerURL;

	public AllXSSGenerator(StringSpecification stringSpec, long seed,String attackerURL) {
		super(stringSpec, seed);
		this.attackerURL = attackerURL;
		initHeuristics();
	}
	
	public AllXSSGenerator(StringSpecification stringSpec, long seed, ComputableFuzzingHeuristic<?> owner,String attackerURL) {
		super(stringSpec, seed, owner);
		this.attackerURL = attackerURL;
		initHeuristics();
	}

	private void initHeuristics() {		
		heuristics.add(new XSSBasicInputGenerator(stringSpec,seed,owner,attackerURL));
		heuristics.add(new XSSMultipleLinesInputGenerator(stringSpec, seed,owner));
		heuristics.add(new XSSOpenHTMLTagVarianceGenerator(stringSpec, seed, owner));
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		return stringSpec.getType() == StringType.XSS;
	}

	@Override
	public String getName() {
		return "ALLXSS";
	}

}
