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

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableListImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

/**
 * This class computed repetitions of a string. It can be defined how many elements
 * shall be computed, the string to be repeated, the first number of repetitions
 * and its offset as well as the omitted repetitions.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public class StringRepeater extends ComputableListImpl<FuzzedValue<String>> implements StringGenerator {
	
	private static final long serialVersionUID = -6632206431310168223L;
	protected ComputableFuzzingHeuristic<?> owner;
	protected long seed;
	protected StringSpecification stringSpec;
	
	/**
	 * The string to be repeated. Optional, default is "A".
	 */
	private String str;
	/**
	 * The first index for the repetitions. The first element is {@link #offset} + {@link #startIndex} * {@link #stepSize} * {@link #str}.
	 * Optional, default is 0.
	 */
	private int startIndex;
	/**
	 * The offset of the string repetitions. Optional, default is 0;
	 */
	private int offset;
	/**
	 * The number of elements to be generated. Optional, default is 1000.
	 */
	private int size;
	/**
	 * The step size for each index. Optional, default is 1.
	 */
	private int stepSize;
	/**
	 * A prefix string added at the beginning of each generated string. Optional, default is "".
	 */
	private String prefix;
	/**
	 * A suffix string append to each generated string. Optional, default is "".
	 */
	private String suffix;
	
	/**
	 * Builder for {@link StringRepeater}, allows custom string repeaters.
	 * 
	 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
	 *
	 */
	public static class Builder {
		private String str = "A";
		private int startIndex = 0;
		private int offset = 0;
		private int size = 1000;
		private int stepSize = 1;
		private String prefix = "";
		private String suffix = "";
		
		/**
		 * Determines the string to be repeat. Optional, default is "A".
		 * 
		 * @param val the string to be repeat.
		 * @return this Builder instance.
		 */
		public Builder string(String val) {
			str = val;
			return this;
		}
		
		/**
		 * Determines the start index for {@link StringRepeater}. Optional, default is 0.
		 * 
		 * @param val the start index for {@link StringRepeater}.
		 * @return this Builder instance.
		 */
		public Builder startIndex(int val) {
			if (val < 0) {
				throw new IllegalArgumentException("startIndex must not be smaller than 0.");
			}
			startIndex = val;
			return this;
		}
		
		/**
		 * Determines the offset for {@link StringRepeater}. Optional, default is 0.
		 * 
		 * @param val the offset for {@link StringRepeater}
		 * @return this Builder instance.
		 */
		public Builder offset(int val) {
			if (val < 0) {
				throw new IllegalArgumentException("offset must not be smaller than 0.");
			}
			offset = val;
			return this;
		}

		/**
		 * Determines the number of elements to be computed by {@link StringRepeater}. Optional, default is 1000.
		 * 
		 * @param val the number of elements to be computed by {@link StringRepeater}.
		 * @return this Builder instance.
		 */
		public Builder size(int val) {
			if (val <= 0) {
				throw new IllegalArgumentException("size must be greater than 0.");
			}
			size = val;
			return this;
		}

		/**
		 * Determines the distance between each repetition of a string that is the number of omitted string repetitions + 1.
		 * Optional, default is 1.
		 * 
		 * @param val the distance between each repetition of a string.
		 * @return this Builder instance.
		 */
		public Builder stepSize(int val) {
			if (val <= 0) {
				throw new IllegalArgumentException("startIndex must be greater than 0.");
			}
			stepSize = val;
			return this;
		}
		
		public Builder prefix(String val) {
			prefix = val;
			return this;
		}
		
		public Builder suffix(String val) {
			suffix = val;
			return this;
		}
		
	}

	/**
	 * Constructs a StringRepeater.
	 * 
	 * @param builder the builder holding the parameters for the StringRepeater to be constructed.
	 */
	public StringRepeater(StringSpecification stringSpec, ComputableFuzzingHeuristic<?> owner, long seed, Builder builder) {
		this.stringSpec = stringSpec;
		this.owner = owner;
		this.seed = seed;
		str = builder.str;
		startIndex = builder.startIndex;
		offset = builder.offset;
		size = builder.size;
		stepSize = builder.stepSize;
		prefix = builder.prefix;
		suffix = builder.suffix;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public FuzzedValue<String> computeElement(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		int actualIndex = startIndex + index;

		String nextElement = StringUtil.repeat(str, offset + actualIndex * stepSize);
		nextElement = prefix + nextElement + suffix;
		
		FuzzedValue<String> fuzzedValue = new FuzzedValue<>(nextElement, owner);
		
		return fuzzedValue;
	}

	@Override
	public String getName() {
		return "StringRepeater";
	}

	@Override
	public boolean canCreateValuesFor(StringSpecification stringSpecification) {
		return true;
	}

	@Override
	public long getSeed() {
		return seed;
	}

}
