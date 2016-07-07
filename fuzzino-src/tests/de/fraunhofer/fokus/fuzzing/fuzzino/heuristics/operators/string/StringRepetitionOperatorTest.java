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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringEncoding;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.IntegerUtil;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class StringRepetitionOperatorTest {

	public static final long SEED = 4711;
	public static final StringSpecification STRING_SPEC = RequestFactory.INSTANCE.createStringSpecification();
	public static final StringSpecification STRING_SPEC_UTF8 = RequestFactory.INSTANCE.createStringSpecification();
	private List<String> listOfStrings;
	
	static {
		STRING_SPEC_UTF8.setEncoding(StringEncoding.UTF8);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testWithNullString() throws Exception {
		new StringRepetitionOperator(StringUtil.asList((String)null), STRING_SPEC, SEED);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testWithNullList() throws Exception {
		new StringRepetitionOperator((List<String>)null, STRING_SPEC, SEED);
	}
	
	@Test
	public void testWithSingleString() throws Exception {
		String expectedValue = "singleString";
		
		StringRepetitionOperator stringRepetitionOperatorList = new StringRepetitionOperator(StringUtil.asList(expectedValue), STRING_SPEC, SEED);
		
		int expectedSize = 1;
		int actualSize = stringRepetitionOperatorList.getValidValues().size();
		assertTrue("Invalid size: was " + actualSize + " instead of " + expectedSize,
				   actualSize == expectedSize);
		
		String actualValue = stringRepetitionOperatorList.getValidValues().get(0);
		assertTrue("Invalid value: was  " + actualValue + " instead of " + expectedValue, 
				   actualValue.equals(expectedValue));
	}
	
	@Test
	public void testWithListOfOneString() throws Exception {
		String expectedValue = "singleString";
		listOfStrings = StringUtil.asList(expectedValue);
		
		StringRepetitionOperator stringRepetitionOperatorList = new StringRepetitionOperator(listOfStrings, STRING_SPEC, SEED);
		
		int expectedSize = 1;
		int actualSize = stringRepetitionOperatorList.getValidValues().size();
		assertTrue("Invalid size: was " + actualSize + " instead of " + expectedSize, 
				   actualSize == expectedSize);
		
		String actualValue = stringRepetitionOperatorList.getValidValues().get(0);
		assertTrue("Invalid value: was  " + actualValue + " instead of " + expectedValue,
				   actualValue.equals(expectedValue));
	}
	
	@Test
	public void testWithListOfTwoStrings() throws Exception {
		String firstExpectedValue = "1";
		String secondExpectedValue = "2";
		listOfStrings = StringUtil.asList(firstExpectedValue, secondExpectedValue);
		
		StringRepetitionOperator stringRepetitionOperatorList = new StringRepetitionOperator(listOfStrings, STRING_SPEC, SEED);
		
		int expectedSize = 2;
		int actualSize = stringRepetitionOperatorList.getValidValues().size();
		assertTrue("Invalid size: was " + actualSize + " instead of " + expectedSize,
				   actualSize == expectedSize);
		
		String actualValue1 = stringRepetitionOperatorList.getValidValues().get(0);
		assertTrue("Invalid value: was " + actualValue1 + " instead of " + firstExpectedValue,
				   actualValue1.equals(firstExpectedValue));
		String actualValue2 = stringRepetitionOperatorList.getValidValues().get(1);
		assertTrue("Invalid value: was " + actualValue2 + " instead of " + secondExpectedValue, 
				   actualValue2.equals(secondExpectedValue));
	}
	
	@Test
	public void testFuzzedValuesWithDefaultEncoding() {
		String firstValidValue = "1";
		String secondValidValue = "2";
		listOfStrings = StringUtil.asList(firstValidValue, secondValidValue);
		
		StringRepetitionOperator stringRepetitionOperatorList = new StringRepetitionOperator(listOfStrings, STRING_SPEC, SEED);

		List<Integer> expectedLengths = IntegerUtil.asList(2, 2, 10, 10, 100, 100); 
				
		int index = 0;
		for (FuzzedValue<String> fuzzedValue : stringRepetitionOperatorList) {
			int expectedLength = expectedLengths.get(index);
			int actualLength = fuzzedValue.getValue().length();
			assertTrue("Invalid length at index " + index + " : was  " + actualLength + " instead of " + expectedLength + " (fuzzedValue: " + fuzzedValue.getValue() + ")",
					   actualLength == expectedLength);
			index++;
		}
		
		int expectedSize = 6;
		int actualSize = stringRepetitionOperatorList.size();
		assertTrue("Invalid size: was " + actualSize + " instead of " + expectedSize,
				   actualSize == expectedSize);
	}
	
	@Test
	public void testFuzzedValuesWithUTF8Encoding() {
		listOfStrings = StringUtil.asList("1", "2");
		final String HEX_FE = "\\xFE";
		
		StringRepetitionOperator stringRepetitionOperator = new StringRepetitionOperator(listOfStrings, STRING_SPEC_UTF8, SEED);

		List<Integer> expectedLengths = IntegerUtil.asList(2, 2, 10, 10, 100, 100, 
				                                           2 + HEX_FE.length(), 2 + HEX_FE.length(),
				                                           10 + HEX_FE.length(), 10 + HEX_FE.length(),
				                                           100 + HEX_FE.length(), 100 + HEX_FE.length()); 
				
		int index = 0;
		for (FuzzedValue<String> fuzzedValue : stringRepetitionOperator) {
			int expectedLength = expectedLengths.get(index);
			int actualLength = fuzzedValue.getValue().length();
			assertTrue("Invalid length at index " + index + ": was " + actualLength + " instead of " + expectedLength + " (fuzzedValue: " + fuzzedValue.getValue() + ")", 
					   actualLength == expectedLength);
			index++;
			
			if (index / 6 > 3) {
				String fuzzedValueItself = fuzzedValue.getValue();
				int valueLength = fuzzedValueItself.length();
				String actualLastPart = fuzzedValueItself.substring(valueLength-HEX_FE.length(), valueLength);
				assertTrue("Last character is " + actualLastPart + " instead of " + HEX_FE, 
						   actualLastPart.equals(HEX_FE));
			}
		}

		int expectedSize = listOfStrings.size() * 6;
		int actualSize = stringRepetitionOperator.size();
		assertTrue("Invalid size: was " + actualSize + " instead of " + expectedSize, 
				   actualSize == expectedSize);
	}
	

}
