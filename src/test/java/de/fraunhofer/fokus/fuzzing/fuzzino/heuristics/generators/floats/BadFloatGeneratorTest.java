package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.floats;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.BadFloatGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.FloatSpecificationImpl;

public class BadFloatGeneratorTest extends FuzzinoTest {

	@Test
	public void test() {
		NumberSpecification<Double> floatSpec = new FloatSpecificationImpl(0.1, 0.5);
		List<Double> expected = new ArrayList<>(Arrays.asList(0.1,0.5,Double.MAX_VALUE,Double.MIN_VALUE,Double.NaN,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY));
		BadFloatGenerator gen = new BadFloatGenerator(floatSpec, 10);
		for(FuzzedValue<Double> val:gen){
			System.out.println(val.getValue());
			expected.remove(val.getValue());
		}
		assertEquals(0,expected.size());
	}

}
