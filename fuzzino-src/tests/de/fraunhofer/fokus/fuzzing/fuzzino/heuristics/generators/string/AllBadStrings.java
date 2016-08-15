package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGeneratorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;

public class AllBadStrings {

	/**
	 * Bug where output of AllBadStrings contains \x1 instead of \x01.
	 */
	@Test
	public void testBug_IllegalEncodingFormat() {
		AllBadStringsGenerator allBadStringsGenerator = StringGeneratorFactory.INSTANCE.createAllBadStrings(RequestFactory.INSTANCE.createStringSpecification(), 0);
		int i=0;
		for (FuzzedValue<String> fuzzedValue : allBadStringsGenerator) {
			String str = fuzzedValue.getValue();
			assertFalse(i + ": Wrong encoding, ends with \\x1 instead of \\x01. '" + fuzzedValue + "'", 
					str.endsWith("\\x1"));
			i++;
		}
	}

}
