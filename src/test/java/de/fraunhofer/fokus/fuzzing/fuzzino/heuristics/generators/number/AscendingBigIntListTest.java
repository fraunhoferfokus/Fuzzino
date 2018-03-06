//   Copyright 2012-2013 Fraunhofer FOKUS
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.NoMatchingValuesException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.AscendingBigIntList.Builder;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.IntegerSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

public class AscendingBigIntListTest extends FuzzinoTest {

	@Test
	public void test_makeBuilderMatchingSpecification_TestCase_1() throws NoMatchingValuesException {
		IntegerSpecification numberSpec = RequestFactory.INSTANCE.createNumberSpecification();
		numberSpec.setMin(0L);
		Builder builder = new Builder(BigInteger.valueOf(-100), 200).stepSize(1);
		AscendingBigIntList ail = new AscendingBigIntList(numberSpec, null, 0, builder);
		
		Builder matchingBuilder = ail.makeBuilderMatchingSpecification(builder);
		testMatchingBuilderAgainstBuilder(matchingBuilder, builder, numberSpec);
	}
	
	@Test
	public void test_makeBuilderMatchingSpecification_TestCase_2() throws NoMatchingValuesException {
		IntegerSpecification numberSpec = RequestFactory.INSTANCE.createNumberSpecification();
		numberSpec.setMin(10L);
		numberSpec.setMax(999L);
		Builder builder = new Builder(BigInteger.ONE, 100).stepSize(3);
		AscendingBigIntList ail = new AscendingBigIntList(numberSpec, null, 0, builder);
		
		Builder matchingBuilder = ail.makeBuilderMatchingSpecification(builder);
		testMatchingBuilderAgainstBuilder(matchingBuilder, builder, numberSpec);
	}
	
	@Test(expected=NoMatchingValuesException.class)
	public void test_makeBuilderMatchingSpecification_TestCase_3() throws NoMatchingValuesException {
		StringSpecification stringSpec = RequestFactory.INSTANCE.createStringSpecification();
		IntegerSpecification numberSpec = stringSpec.createPositiveNumberSpec();
		Builder builder = new Builder(new BigInteger("-9223372036854775858"), 100).stepSize(1);
		AscendingBigIntList ail = new AscendingBigIntList(numberSpec, null, 0, builder);
		
		Builder matchingBuilder = ail.makeBuilderMatchingSpecification(builder);
		testMatchingBuilderAgainstBuilder(matchingBuilder, builder, numberSpec);
	}
	
	public void testMatchingBuilderAgainstBuilder(Builder matchingBuilder, Builder builder, IntegerSpecification numberSpec) {
		BigInteger bigMinValue = BigInteger.valueOf(numberSpec.getMin());
		BigInteger bigMaxValue = BigInteger.valueOf(numberSpec.getMax());
		
		BigInteger actualStartInt = matchingBuilder.startInt;
		assertTrue("startInt is smaller than original startInt: " + actualStartInt + " < " + builder.startInt,
				   actualStartInt.compareTo(builder.startInt) >= 0);
		assertTrue("StartInt is smaller than numberSpec.minValue: " + actualStartInt + " < " + numberSpec.getMin(),
				   actualStartInt.compareTo(bigMinValue) >= 0);
		
		BigInteger originalLargestValue = builder.startInt.add(BigInteger.valueOf(builder.size * builder.stepSize));
		BigInteger actualLargestValue = matchingBuilder.startInt.add(BigInteger.valueOf(matchingBuilder.size * matchingBuilder.stepSize));
		assertTrue("largest value is bigger than original largest value: " + actualLargestValue + " > " + originalLargestValue,
				   actualLargestValue.compareTo(originalLargestValue) <= 0);
		assertTrue("largest value is bigger than numberSpec.maxValue: " + actualLargestValue + " > " + numberSpec.getMax(),
				   actualLargestValue.compareTo(bigMaxValue) <= 0);
	}

}
