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
package de.fraunhofer.fokus.fuzzing.fuzzino.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;

public class StringEncoderTest extends FuzzinoTest {
	
	@Test
	public void testWithNull() {
		String value = null;
		
		String actualValue = StringEncoder.encode(value);
		assertNull("Wrong value: was '" + actualValue + "' instead of '" + null + "'",
				   actualValue);
	}
	
	@Test
	public void testWithEmptyString() {
		String value = "";
		
		String actualValue = StringEncoder.encode(value);
		String expectedValue = "";
		assertTrue("Wrong value: was '" + actualValue + "' instead of '" + expectedValue + "'",
				   actualValue.equals(expectedValue));
	}
	
	@Test
	public void testWithoutEntities() {
		String value = "ABCDEF";
		
		String actualValue = StringEncoder.encode(value);
		String expectedValue = "\\x41\\x42\\x43\\x44\\x45\\x46";
		assertTrue("Wrong value: was '" + actualValue + "' instead of '" + expectedValue + "'",
				   actualValue.equals(expectedValue));
	}
	
	@Test
	public void testWithEntityAtBeginning() {
		String value = "\\x41BCDEF";
		
		String actualValue = StringEncoder.encode(value);
		String expectedValue = "\\x41\\x42\\x43\\x44\\x45\\x46";
		assertTrue("Wrong value: was '" + actualValue + "' instead of '" + expectedValue + "'",
				actualValue.equals(expectedValue));
	}
	
	@Test
	public void testWithEntityAtEnd() {
		String value = "ABCDE\\x46";
		
		String actualValue = StringEncoder.encode(value);
		String expectedValue = "\\x41\\x42\\x43\\x44\\x45\\x46";
		assertTrue("Wrong value: was '" + actualValue + "' instead of '" + expectedValue + "'",
				   actualValue.equals(expectedValue));
	}
	
	@Test
	public void testWithEntityInTheMiddle() {
		String value = "ABCDEF";
		
		String actualValue = StringEncoder.encode(value);
		String expectedValue = "\\x41\\x42\\x43\\x44\\x45\\x46";
		assertTrue("Wrong value: was '" + actualValue + "' instead of '" + expectedValue + "'",
				   actualValue.equals(expectedValue));
	}
	
	@Test
	public void testWithSeveralEntities() {
		String value = "\\x41B\\x43\\x44E\\x46";
		
		String actualValue = StringEncoder.encode(value);
		String expectedValue = "\\x41\\x42\\x43\\x44\\x45\\x46";
		assertTrue("Wrong value: was '" + actualValue + "' instead of '" + expectedValue + "'",
				   actualValue.equals(expectedValue));
	}
	
	@Test
	public void testWithOnlyEntities() {
		String value = "\\x41\\x42\\x43\\x44\\x45\\x46";
		
		String actualValue = StringEncoder.encode(value);
		String expectedValue = "\\x41\\x42\\x43\\x44\\x45\\x46";
		assertTrue("Wrong value: was '" + actualValue + "' instead of '" + expectedValue + "'",
				   actualValue.equals(expectedValue));
	}
	
	@Test
	public void testLengthWithNull() {
		String value = null;
		
		int actualLength = StringEncoder.length(value);
		int expectedLength = 0;
		assertTrue("Wrong length: was '" + actualLength + "' instead of '" + expectedLength + "'",
				   actualLength == expectedLength);
	}
	
	@Test
	public void testLengthWithEmptyString() {
		String value = "";
		
		int actualLength = StringEncoder.length(value);
		int expectedLength = 0;
		assertTrue("Wrong length: was '" + actualLength + "' instead of '" + expectedLength + "'",
				   actualLength == expectedLength);
	}
	
	@Test
	public void testLengthWithoutEntities() {
		String value = "ABCDEF";
		
		int actualLength = StringEncoder.length(value);
		int expectedLength = 6;
		assertTrue("Wrong length: was '" + actualLength + "' instead of '" + expectedLength + "'",
				   actualLength == expectedLength);
	}
	
	@Test
	public void testWithEntities() {
		String value = "\\x41\\x42\\x43\\x44\\x45\\x46";
		
		int actualLength = StringEncoder.length(value);
		int expectedLength = 6;
		assertTrue("Wrong length: was '" + actualLength + "' instead of '" + expectedLength + "'",
				   actualLength == expectedLength);
	}
	
	@Test
	public void testWithUnicodeChar9bit() {
		String value = "" + new Character((char) 0x0100);
		
		String actualValue = StringEncoder.encode(value); 
		String expectedValue = "\\u0" + Integer.toHexString(value.codePointAt(0));
		assertTrue("Wrong value: was '" + actualValue + "' instead of '" + expectedValue + "'",
				   actualValue.equals(expectedValue));
	}

	@Test
	public void testWithUnicodeChar13bit() {
		String value = "" + new Character((char) 0x1000);
		
		String actualValue = StringEncoder.encode(value); 
		String expectedValue = "\\u" + Integer.toHexString(value.codePointAt(0));
		assertTrue("Wrong value: was '" + actualValue + "' instead of '" + expectedValue + "'",
				actualValue.equals(expectedValue));
	}
	
	@Test
	public void testWithUnicodeChar17bit() {
		int codePoint = 0x00010000;
		String value = new String(Character.toChars(codePoint));
		
		String actualValue = StringEncoder.encode(value); 
		String expectedValue = "\\U000" + Integer.toHexString(codePoint);
		assertTrue("Wrong value: was '" + actualValue + "' instead of '" + expectedValue + "'",
				   actualValue.equals(expectedValue));
	}

	@Test
	public void testWithUnicodeChar21bit() {
		int codePoint = 0x00100000;
		String value = new String(Character.toChars(codePoint));
		
		String actualValue = StringEncoder.encode(value); 
		String expectedValue = "\\U00" + Integer.toHexString(codePoint);
		assertTrue("Wrong value: was '" + actualValue + "' instead of '" + expectedValue + "'",
				actualValue.equals(expectedValue));
	}
	
	@Test
	public void testWithOnlyHighSurrogate() {
		String value = "\ud800";

		String actualValue = StringEncoder.encode(value);
		String expectedValue = "\\ud800";
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testWithOnlyLowSurrogate() {
		String value = "\udc00";

		String actualValue = StringEncoder.encode(value);
		String expectedValue = "\\udc00";
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testWithSurrogatesSeparated() {
		String value = "\ud800\\x42\udc00";
		
		String actualValue = StringEncoder.encode(value);
		String expectedValue = "\\ud800\\x42\\udc00";
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testWithWrongSurrogateOrder() {
		String value = "\udc00\ud800";
		
		String actualValue = StringEncoder.encode(value);
		String expectedValue = "\\udc00\\ud800";
		assertEquals(expectedValue, actualValue);
	}
}
