package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string;

import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.SQLTimeBasedInjections;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

public class SQLTimeBasedInjectionsGenerator extends SimpleStringGenerator {

	private static final long serialVersionUID = -7710016654009836682L;
	protected static SQLTimeBasedInjections sqlInjections = SQLTimeBasedInjections.INSTANCE;

	public SQLTimeBasedInjectionsGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
	}

	public SQLTimeBasedInjectionsGenerator(long seed, StringSpecification stringSpec, ComputableFuzzingHeuristic<?> owner) {
		super(stringSpec, seed, owner);
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		boolean validType = stringSpec.getType() == StringType.SQL;
		
		return validType;
	}

	@Override
	public String getName() {
		return "SQLTimeInjections";
	}

	@Override
	public List<String> getFuzzValues() {
		return sqlInjections.getValues();
	}

	@Override
	public List<Integer> getFuzzValueLengths() {
		return sqlInjections.getLengths();
	}
	
}
