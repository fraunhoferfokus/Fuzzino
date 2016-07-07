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

import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableListImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.IntegerUtil;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

/**
 * Based on Sulley's class string.<br/>
 * Ported from Python by Martin Schneider (martin.schneider@fokus.fraunhofer.de).<br/>
 * 
 * License: GNU GPLv2.
 */
public class LongSulleyStringsGenerator extends ComputableListImpl<FuzzedValue<String>> implements StringGenerator {

	private static final long serialVersionUID = 4305075477520228717L;
	protected ComputableFuzzingHeuristic<?> owner;
	protected long seed;
	protected StringSpecification stringSpec;
	protected int size;
	protected static final List<String> characters;
	protected static final List<Integer> repetitions;
	protected static final List<Integer> nullInsideRepetitions;
	static {
		// the following values are taken from Sulley 1.5.7, sulley/primitives.py
		// class strings, lines 491-520, 523-525
		characters = StringUtil.asList("A", "B", "1", "2", "3", "<", ">", "'", "\"", "/", "\\", "?", "=", "a=", 
				"&", ".", ",", "(", ")", "]", "[", "%", "*", "-", "+", "{", "}", 
				"&#x14;", "&#xFE;", "&#xFF;");
		repetitions = IntegerUtil.asList(128, 255, 256, 257, 511, 512, 513, 1023, 1024, 2048, 2049, 4095, 4096, 
				4097, 5000, 10000, 20000,32762, 32763, 32764, 32765, 32766, 32767,
				32768, 32769, 0xFFFF-2, 0xFFFF-1, 0xFFFF, 0xFFFF+1, 0xFFFF+2, 99999, 
				100000, 500000, 1000000);
		
		nullInsideRepetitions = IntegerUtil.asList(128, 256, 1024, 2048, 4096, 32767, 0xFFFF);
	}
	protected static final int SIZE_FIRST_PART = characters.size() * repetitions.size();
	
	public LongSulleyStringsGenerator(long seed, StringSpecification stringSpec) {
		this.seed = seed;
		owner = this;
		this.stringSpec = stringSpec;
	}
	
	public LongSulleyStringsGenerator(ComputableFuzzingHeuristic<?> owner, long seed, StringSpecification stringSpec) {
		this.seed = seed;
		this.owner = owner;
		this.stringSpec = stringSpec;
	}
	
	@Override
	public boolean matchesSpecification(FuzzedValue<String> value) {
		return true;
	}
	
	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpec) {
		return true;
	}

	@Override
	public String getName() {
		return "LongSulleyStrings";
	}

	@Override
	public long getSeed() {
		return seed;
	}

	@Override
	public FuzzedValue<String> computeElement(int index) {
		if (index < SIZE_FIRST_PART) {
			int charIndex = index / repetitions.size();
			int repetitionIndex = index % repetitions.size();
			
			String character = characters.get(charIndex);
			int repetition = repetitions.get(repetitionIndex);
			String fuzzedValueItself = StringUtil.repeat(character, repetition);
			FuzzedValue<String> fuzzedValue = new FuzzedValue<>(fuzzedValueItself, owner);
			
			return fuzzedValue;
		} else {
			// the following values are taken from Sulley 1.5.7, sulley/primitives.py
			// class strings, lines 523-525
			index -= SIZE_FIRST_PART;
			int repetitions = nullInsideRepetitions.get(index);
			String surrounding = StringUtil.repeat("B", repetitions/2);
		
			String fuzzedValueItself = surrounding + "&#x00;" + surrounding;
			FuzzedValue<String> fuzzedValue = new FuzzedValue<>(fuzzedValueItself, owner);
			
			return fuzzedValue;
		}
	}

	@Override
	public int size() {
		if (size == 0) {
			size = characters.size() * repetitions.size() + nullInsideRepetitions.size();
		}
		return size;
	}

}
