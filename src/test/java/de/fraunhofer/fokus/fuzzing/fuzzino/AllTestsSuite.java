//   Copyright 2012-2020 Fraunhofer FOKUS
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
import org.junit.runners.Suite.SuiteClasses;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComposedFuzzingHeuristicTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableListImplTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGeneratorFactoryTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.floats.BadFloatGeneratorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.AscendingBigIntListTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.AscendingIntegerListTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.AscendingLongListTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.BigBoundaryNumbersGeneratorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.AllBadStrings;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.AscendingIntegerAsStringListTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadLongStringsGeneratorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadLongUnicodeStringsTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BigIntFromRangesAsStringTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.CombinatorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.ConcreteValuesGeneratorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.ForeignDigitsGeneratorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.IntegerFromRangesTests;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.LongStringsGeneratorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.MatchesStringLength;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.Popular4DigitPinsTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.StringRepeaterTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.StringOperatorFactoryTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.number.NumericalVarianceOperatorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string.ForeignDigitsOperatorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string.RepeatStringOperatorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string.StringCaseOperatorListTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.string.UnicodeNumeralsOperatorTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringEncoderTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	// Util
	StringEncoderTest.class,
	// Fuzzino
	BigIntegerRequestProcessorTest.class,
	BugTests.class,
	FloatRequestProcessorTest.class,
	IntegerRequestProcessorTest.class,
	RequestDispatcherTest.class,
	// Heuristics
	StringRequestProcessorTest.class,
	ComposedFuzzingHeuristicTest.class,
	ComputableListImplTest.class,
	// Heuristics Generators
	StringGeneratorFactoryTest.class,
	// Generators Floats
	BadFloatGeneratorTest.class,
	// Generators Number
	AscendingBigIntListTest.class,
	AscendingIntegerListTest.class,
	AscendingLongListTest.class,
	BigBoundaryNumbersGeneratorTest.class,
	// Generators String
	AllBadStrings.class,
	AscendingIntegerAsStringListTest.class,
	BadLongStringsGeneratorTest.class,
	BadLongUnicodeStringsTest.class,
	BigIntFromRangesAsStringTest.class,
	CombinatorTest.class,
	ConcreteValuesGeneratorTest.class,
	IntegerFromRangesTests.class,
	LongStringsGeneratorTest.class,
	MatchesStringLength.class,
	Popular4DigitPinsTest.class,
	StringRepeaterTest.class,
	ForeignDigitsGeneratorTest.class,
	// Operators
	StringOperatorFactoryTest.class,
	// Operators Number
	NumericalVarianceOperatorTest.class,
	// Operators String
	StringCaseOperatorListTest.class,
	RepeatStringOperatorTest.class,
	ForeignDigitsOperatorTest.class,
	UnicodeNumeralsOperatorTest.class
})

public class AllTestsSuite {

}
