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
package de.fraunhofer.fokus.fuzzing.fuzzino.request.java.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.NumberSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;

public class StringSpecificationImplTest {
	
	public static final int MIN_LENGTH_2 = 2;
	public static final int MAX_LENGTH_3 = 3;
	public static final StringSpecification STRING_SPEC_2_3;
	static {
		STRING_SPEC_2_3 = RequestFactory.INSTANCE.createStringSpecification();
		STRING_SPEC_2_3.setMinLength(MIN_LENGTH_2);
		STRING_SPEC_2_3.setMaxLength(MAX_LENGTH_3);
	}

	public static final int MIN_LENGTH_3 = 3;
	public static final int MAX_LENGTH_4 = 4;
	public static final StringSpecification STRING_SPEC_3_4;
	static {
		STRING_SPEC_3_4 = RequestFactory.INSTANCE.createStringSpecification();
		STRING_SPEC_3_4.setMinLength(MIN_LENGTH_3);
		STRING_SPEC_3_4.setMaxLength(MAX_LENGTH_4);
	}

	@Test
	public void test_createNegativeNumberSpec_2_3() {
		NumberSpecification numberSpec = STRING_SPEC_2_3.createNegativeNumberSpec();
		
		long expectedMinValue = -99;
		long actualMinValue = numberSpec.getMinValue();
		assertTrue("Wrong minValue: was " + actualMinValue + " instead of " + expectedMinValue,
				   actualMinValue == expectedMinValue);
		
		long expectedMaxValue = -1;
		long actualMaxValue = numberSpec.getMaxValue();
		assertTrue("Wrong maxValue: was " + actualMaxValue + " instead of " + expectedMaxValue,
				   actualMaxValue == expectedMaxValue);
	}
	
	@Test
	public void test_createPositiveNumberSpec_2_3() {
		NumberSpecification numberSpec = STRING_SPEC_2_3.createPositiveNumberSpec();
		
		long expectedMinValue = 10;
		long actualMinValue = numberSpec.getMinValue();
		assertTrue("Wrong minValue: was " + actualMinValue + " instead of " + expectedMinValue, 
				   actualMinValue == expectedMinValue);
		
		long expectedMaxValue = 999;
		long actualMaxValue = numberSpec.getMaxValue();
		assertTrue("Wrong maxValue: was " + actualMaxValue + " instead of " + expectedMaxValue,
				   actualMaxValue == expectedMaxValue);
	}

	@Test
	public void test_createNegativeNumberSpec_3_4() {
		NumberSpecification numberSpec = STRING_SPEC_3_4.createNegativeNumberSpec();
		
		long expectedMinValue = -999;
		long actualMinValue = numberSpec.getMinValue();
		assertTrue("Wrong minValue: was " + actualMinValue + " instead of " + expectedMinValue,
				   actualMinValue == expectedMinValue);
		
		long expectedMaxValue = -10;
		long actualMaxValue = numberSpec.getMaxValue();
		assertTrue("Wrong maxValue: was " + actualMaxValue + " instead of " + expectedMaxValue,
				   actualMaxValue == expectedMaxValue);
	}
	
	@Test
	public void test_createPositiveNumberSpec_3_4() {
		NumberSpecification numberSpec = STRING_SPEC_3_4.createPositiveNumberSpec();
		
		long expectedMinValue = 100;
		long actualMinValue = numberSpec.getMinValue();
		assertTrue("Wrong minValue: was " + actualMinValue + " instead of " + expectedMinValue, 
				   actualMinValue == expectedMinValue);
		
		long expectedMaxValue = 9999;
		long actualMaxValue = numberSpec.getMaxValue();
		assertTrue("Wrong maxValue: was " + actualMaxValue + " instead of " + expectedMaxValue,
				   actualMaxValue == expectedMaxValue);
	}

}
