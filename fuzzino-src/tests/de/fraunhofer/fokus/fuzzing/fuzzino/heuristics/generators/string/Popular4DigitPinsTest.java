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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.Popular4DigitPinsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringType;

public class Popular4DigitPinsTest {
	
	protected static final List<String> expectedValues;
	
	public static final long SEED = 4711;
	
	public static final StringSpecification STRING_SPEC;
	public static final StringSpecification STRING_SPEC_WITH_LENGTH;
	
	public static final StringSpecification STRING_SPEC_WRONG_TYPE;
	public static final StringSpecification STRING_SPEC_WRONG_TOO_SMALL;
	public static final StringSpecification STRING_SPEC_WRONG_TOO_BIG;
	
	static {
		STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
		STRING_SPEC.setType(StringType.PIN4DIGIT);
		
		STRING_SPEC_WITH_LENGTH = RequestFactory.INSTANCE.createStringSpecification();
		STRING_SPEC_WITH_LENGTH.setType(StringType.PIN4DIGIT);
		STRING_SPEC_WITH_LENGTH.setMinLength(4);
		STRING_SPEC_WITH_LENGTH.setMaxLength(4);
		
		STRING_SPEC_WRONG_TYPE = RequestFactory.INSTANCE.createStringSpecification();
		
		STRING_SPEC_WRONG_TOO_SMALL = RequestFactory.INSTANCE.createStringSpecification();
		STRING_SPEC_WRONG_TOO_SMALL.setType(StringType.PIN4DIGIT);
		STRING_SPEC_WRONG_TOO_SMALL.setMinLength(1);
		STRING_SPEC_WRONG_TOO_SMALL.setMaxLength(3);
		
		STRING_SPEC_WRONG_TOO_BIG = RequestFactory.INSTANCE.createStringSpecification();
		STRING_SPEC_WRONG_TOO_BIG.setType(StringType.PIN4DIGIT);
		STRING_SPEC_WRONG_TOO_BIG.setMinLength(5);
		STRING_SPEC_WRONG_TOO_BIG.setMaxLength(9);
		
		expectedValues = new ArrayList<>(150);
		expectedValues.add("1234");
		expectedValues.add("1111");
		expectedValues.add("0000");
		expectedValues.add("1212");
		expectedValues.add("7777");
		expectedValues.add("1004");
		expectedValues.add("2000");
		expectedValues.add("4444");
		expectedValues.add("2222");
		expectedValues.add("6969");
		expectedValues.add("9999");
		expectedValues.add("3333");
		expectedValues.add("5555");
		expectedValues.add("6666");
		expectedValues.add("1122");
		expectedValues.add("1313");
		expectedValues.add("8888");
		expectedValues.add("4321");
		expectedValues.add("2001");
		expectedValues.add("1010");
		for (int i=1900;i<getYear();i++) {
			expectedValues.add(Integer.valueOf(i).toString());
		}

	}
	
	// 
	// POSITIVE TEST CASES

	@Test
	public void testValuesWithCorrectType() {
		Popular4DigitPinsGenerator generator = new Popular4DigitPinsGenerator(STRING_SPEC, SEED);
		
		for (int i=0;i<expectedValues.size(); i++) {
			String actualValue = generator.get(i).getValue();
			String expectedValue = expectedValues.get(i);
			assertTrue("Wrong value at index '"+ i + "': Was " + actualValue + " instead of " + expectedValue,
					   actualValue.equals(expectedValue));
		}
	}
	
	@Test
	public void testValuesWithCorrectTypeAndLength() {
		Popular4DigitPinsGenerator generator = new Popular4DigitPinsGenerator(STRING_SPEC_WITH_LENGTH, SEED);
		
		for (int i=0;i<expectedValues.size(); i++) {
			String actualValue = generator.get(i).getValue();
			String expectedValue = expectedValues.get(i);
			assertTrue("Wrong value at index '"+ i + "': Was " + actualValue + " instead of " + expectedValue,
					   actualValue.equals(expectedValue));
		}
	}
	
	// 
	// NEGATIVE TEST CASES

	@Test
	public void testWrongType() {
		Popular4DigitPinsGenerator generator = new Popular4DigitPinsGenerator(STRING_SPEC_WRONG_TYPE, SEED);

		boolean shouldBeApplicable = false;
		boolean claimsToBeApplicable = generator.canCreateValuesFor(STRING_SPEC_WRONG_TYPE);
		assertTrue("Claims to be applicable despite of wrong type",
				   claimsToBeApplicable == shouldBeApplicable);
	}

	@Test
	public void testWrongLength_too_small() {
		Popular4DigitPinsGenerator generator = new Popular4DigitPinsGenerator(STRING_SPEC_WRONG_TOO_SMALL, SEED);

		boolean shouldBeApplicable = false;
		boolean claimsToBeApplicable = generator.canCreateValuesFor(STRING_SPEC_WRONG_TOO_SMALL);
		assertTrue("Claims to be applicable despite of too small",
				   claimsToBeApplicable == shouldBeApplicable);
	}

	@Test
	public void testWrongLength_too_big() {
		Popular4DigitPinsGenerator generator = new Popular4DigitPinsGenerator(STRING_SPEC_WRONG_TOO_BIG, SEED);

		boolean shouldBeApplicable = false;
		boolean claimsToBeApplicable = generator.canCreateValuesFor(STRING_SPEC_WRONG_TOO_BIG);
		assertTrue("Claims to be applicable despite of too big",
				   claimsToBeApplicable == shouldBeApplicable);
	}

	private static int getYear() {
		return new GregorianCalendar().get(Calendar.YEAR);
	}

}
