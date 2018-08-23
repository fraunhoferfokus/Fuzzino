package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string;

import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data.SQLTimeBasedInjections;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

/**
 * This generator creates strings that can be used for time-based SQL injection.
 * The strings contain commands that request an SQL database to be inactive for
 * a certain amount of time. If the SQL injection was successful, then the
 * database should not response for a moment. There exist commands for multiple
 * databases like Oracle DB, MySQL, PostgreSQL and so on.
 * 
 * @author Rene W. Rollet (rene.wiegmann.rollet@fokus.fraunhofer.de)
 *
 */
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
