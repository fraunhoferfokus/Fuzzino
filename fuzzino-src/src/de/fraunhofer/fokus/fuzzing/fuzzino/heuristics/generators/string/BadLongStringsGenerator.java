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

import java.math.BigInteger;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class BadLongStringsGenerator extends ComposedStringGenerator {
	
	private static final long serialVersionUID = 3475147810941138807L;

	public BadLongStringsGenerator(StringSpecification stringSpec, long seed) {
		super(stringSpec, seed);
		initHeuristics();
	}
	
	public BadLongStringsGenerator(ComputableFuzzingHeuristic<?> owner, long seed, StringSpecification stringSpec) {
		super(stringSpec, seed, owner);
		initHeuristics();
	}
	
	private void modifyStringSpecToMaximalLengths() {
		StringSpecification stringSpecification = RequestFactory.INSTANCE.createStringSpecification();
		stringSpecification.setType(stringSpec.getType());
		stringSpecification.setIgnoreLengths(true);
		stringSpecification.setEncoding(stringSpec.getEncoding());
		stringSpecification.setIsNullTerminated(stringSpec.isNullTerminated());
		stringSpecification.setRegEx(stringSpec.getRegEx());
		
		stringSpec = stringSpecification;
	}
	
	@Override
	public boolean matchesSpecification(FuzzedValue<String> value) {
		return true;
	}
	
	private void initHeuristics() {
		modifyStringSpecToMaximalLengths();

		StringRepeater repeaterOf10_A_00_ = new StringRepeater(stringSpec, owner, seed,
				                                new StringRepeater.Builder().string(StringUtil.repeat("A\\x00", 10))
				                                                            .size(1000)
				                                                            .offset(1));

		StringRepeater repeaterOf127_A_00_ = new StringRepeater(stringSpec, owner, seed,
				                                 new StringRepeater.Builder().string(StringUtil.repeat("A\\x00", 127))
				                                                             .size(100)
				                                                             .offset(1));
		
		StringRepeater repeaterOf1024_A_00_ = new StringRepeater(stringSpec, owner, seed,
				                                  new StringRepeater.Builder().string(StringUtil.repeat("A\\x00", 1024))
                                                                              .size(10)
                                                                              .offset(1));

		IntegerFromRangesAsString intRanges = new IntegerFromRangesAsString(stringSpec, owner, seed, 
				                                  new IntegerFromRangesAsString.Builder(-50, 49)
		                                                                       .addRange(-178, -79)
		                                                                       .addRange(77, 176)
		                                                                       .addRange(205, 304)
		                                                                       .addRange(-32818, -32719)
		                                                                       .addRange(32717, 32816)
		                                                                       .addRange(65485, 65584));
		
		LongFromRangesAsString longRanges = new LongFromRangesAsString(stringSpec, owner, seed,
				                                new LongFromRangesAsString.Builder(-2147483698l, -2147483599l)
		                                                                  .addRange(2147483597l, 2147483696l)
		                                                                  .addRange(4294967245l, 4294967344l));
		
		BigIntFromRangesAsString bigIntRanges = 
				new BigIntFromRangesAsString(stringSpec, owner, seed, new BigIntFromRangesAsString.Builder(
						                                                           new BigInteger("-9223372036854775858"),
				                                                                   new BigInteger("-9223372036854775759"))
		                                                                 .addRange(new BigInteger("9223372036854775757"), 
		                                                                   		   new BigInteger("9223372036854775856"))
		                                                                 .addRange(new BigInteger("18446744073709551565"),
		                                                                           new BigInteger("18446744073709551664")));
		
		heuristics.add(repeaterOf10_A_00_);
		heuristics.add(repeaterOf127_A_00_);
		heuristics.add(repeaterOf1024_A_00_);
		heuristics.add(intRanges);
		heuristics.add(longRanges);
		heuristics.add(bigIntRanges);
		heuristics.add(new ConcreteValuesGenerator(stringSpec, seed, owner, 
				                                          "\\x00\\x00" + StringUtil.repeat("A", 7000), 
				                                          "%00%00" + StringUtil.repeat("A", 7000), 
				                                          "10"));
	}

	@Override
	public String getName() {
		return "BadLongStrings";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification spec) {
		boolean properNullTermination = spec.isNullTerminated();
		
		return properNullTermination;
	}

}
