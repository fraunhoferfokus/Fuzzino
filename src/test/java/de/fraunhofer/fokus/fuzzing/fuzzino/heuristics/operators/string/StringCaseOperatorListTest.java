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

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class StringCaseOperatorListTest extends FuzzinoTest {
	
	public static final long SEED = 4711;
	private List<String> listOfStrings;
	
	@Test(expected=IllegalArgumentException.class)
	public void testWithNullString() throws Exception {
		new StringCaseOperator(StringUtil.asList((String)null), null, SEED);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testStringCaseOperatorAddNullList() throws Exception {
		new StringCaseOperator((List<String>)null, null, SEED);
	}
	
	@Test
	public void testWithSingleString() throws Exception {
		String expectedValue = "singleString";
		StringCaseOperator stringCaseOperatorList = new StringCaseOperator(StringUtil.asList(expectedValue), null, SEED);
		
		int expectedSize = 1;
		int actualSize = stringCaseOperatorList.getValidValues().size();
		assertTrue("Invalid size: was " + actualSize + " instead of " + expectedSize, 
				   actualSize == expectedSize);
		
		String actualValue = stringCaseOperatorList.getValidValues().get(0);
		assertTrue("Invalid value: was  " + actualValue + " instead of " + expectedValue, 
				   actualValue.equals(expectedValue));
	}
	
	@Test
	public void testWithListOfOneString() throws Exception {
		String expectedValue = "singleString";
		listOfStrings = StringUtil.asList(expectedValue);
		
		StringCaseOperator stringCaseOperatorList = new StringCaseOperator(listOfStrings, null, SEED);
		
		int expectedSize = 1;
		int actualSize = stringCaseOperatorList.getValidValues().size();
		assertTrue("Invalid size: was " + actualSize + " instead of " + expectedSize, 
				   actualSize == expectedSize);
		
		String actualValue = stringCaseOperatorList.getValidValues().get(0);
		assertTrue("Value is  " + actualValue + " instead of " + expectedValue, 
				   actualValue.equals(expectedValue));
	}
	
	@Test
	public void testWithListOfTwoStrings() throws Exception {
		String firstExpectedValue = "singleString";
		String secondExpectedValue = "secondString";
		listOfStrings = StringUtil.asList(firstExpectedValue, secondExpectedValue);
		
		StringCaseOperator stringCaseOperatorList = new StringCaseOperator(listOfStrings, null, SEED);
		
		int expectedSize = 2;
		int actualSize = stringCaseOperatorList.getValidValues().size();
		assertTrue("Size is " + actualSize + " instead of " + expectedSize, 
				   actualSize == expectedSize);
		
		String firstActualValue = stringCaseOperatorList.getValidValues().get(0);
		assertTrue("Invalid value: was " + firstActualValue + " instead of " + firstExpectedValue, 
				   firstActualValue.equals(firstExpectedValue));
		String secondActualValue = stringCaseOperatorList.getValidValues().get(1);
		assertTrue("Invalid value: was " + secondActualValue + " instead of " + secondExpectedValue,
				   secondActualValue.equals(secondExpectedValue));
	}
	
	@Test
	public void testFuzzedValues() {
		String singleString = "single string";
		String secondString = "second string";
		listOfStrings = StringUtil.asList(singleString, secondString);
		
		StringCaseOperator stringCaseOperator = new StringCaseOperator(listOfStrings, null, SEED);
		
		for (int i=0; i<listOfStrings.size(); i++) {
			String originalValue = listOfStrings.get(i%listOfStrings.size());
			String expectedValue = "";
			String actualValue = "";
			switch (i / 3) { // i % 3 because 3 fuzzed values per valid value 
			case 0:
				expectedValue = originalValue.toUpperCase();
				actualValue = stringCaseOperator.get(i).getValue();
				assertTrue("Invalid value: was " + actualValue + " instead of " + expectedValue,
				           actualValue.equals(expectedValue));
				break;
			case 1:
				expectedValue = originalValue.toLowerCase();
				actualValue = stringCaseOperator.get(i).getValue();
				assertTrue("Invalid value: was " + actualValue + " instead of " + expectedValue,
				           actualValue.equals(expectedValue));
				break;
			case 2:
				actualValue = stringCaseOperator.get(i).getValue();
				assertTrue("Invalid value: was equal to original value",
						   (actualValue.toUpperCase().equals(originalValue.toUpperCase()) 
						    && !actualValue.equals(originalValue)));
			}
		}
	}
	
}
