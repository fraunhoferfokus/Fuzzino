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

import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.NumberSpecification;

public abstract class NumberSpecificationImpl<T extends Number> implements NumberSpecification<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T min;
	private T max;

	@Override
	public T getMin() {
		return min;
	}

	@Override
	public T getMax() {
		return max;
	}

	@Override
	public void setMin(T min) {
		this.min = min;
	}

	@Override
	public void setMax(T max) {
		this.max=max;
	}

}
