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
package de.fraunhofer.fokus.fuzzing.fuzzino;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComposedFuzzingHeuristicTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableListImplTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGeneratorFactoryTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.AscendingBigIntListTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.AscendingIntegerListTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.AscendingLongListTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.BigBoundaryNumbersGeneratorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.AscendingIntegerAsStringListTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadLongStringsGeneratorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadLongUnicodeStringsTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BigIntFromRangesAsStringTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.CombinatorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.IntegerFromRangesTests;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.LongStringsGeneratorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.MatchesStringLength;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.Popular4DigitPinsTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.StringRepeaterTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.StringOperatorFactoryTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.number.NumericalVarianceOperatorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string.StringCaseOperatorListTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string.StringRepetitionOperatorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.impl.StringSpecificationImplTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringEncoderTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({

	// de.fraunhofer.fokus.fuzzing.library
	BugTests.class,
	BigIntegerRequestProcessorTest.class,
    IntegerRequestProcessorTest.class,
    NumberSpecTests.class,
    RequestDispatcherTest.class, 
    StringRequestProcessorTest.class,

	// de.fraunhofer.fokus.fuzzing.library.heuristics
    ComposedFuzzingHeuristicTest.class,
    ComputableListImplTest.class,

	// de.fraunhofer.fokus.fuzzing.library.heuristics.generators
    StringGeneratorFactoryTest.class,

	// de.fraunhofer.fokus.fuzzing.library.heuristics.generators.number
    AscendingBigIntListTest.class,
    AscendingIntegerListTest.class,
    AscendingLongListTest.class,
    BigBoundaryNumbersGeneratorTest.class,

	// de.fraunhofer.fokus.fuzzing.library.heuristics.generators.string
    AscendingIntegerAsStringListTest.class,
    BadLongStringsGeneratorTest.class,
    BadLongUnicodeStringsTest.class,
    BigIntFromRangesAsStringTest.class,
	CombinatorTest.class,
    IntegerFromRangesTests.class,
    LongStringsGeneratorTest.class,
    MatchesStringLength.class,
    Popular4DigitPinsTest.class,
    StringRepeaterTest.class,
	
	// de.fraunhofer.fokus.fuzzing.library.heuristics.operators
    StringOperatorFactoryTest.class,

	// de.fraunhofer.fokus.fuzzing.library.heuristics.operators.number
    NumericalVarianceOperatorTest.class,
    
	// de.fraunhofer.fokus.fuzzing.library.heuristics.operators.string
    StringCaseOperatorListTest.class,
    StringRepetitionOperatorTest.class,
    
    // de.fraunhofer.fokus.fuzzing.library.request.java.impl
    StringSpecificationImplTest.class,
    
    // de.fraunhofer.fokus.fuzzing.library.util
    StringEncoderTest.class
})
public class TestSuite {
  //nothing
	private TestSuite() {
		// non-instantiable
	}
}