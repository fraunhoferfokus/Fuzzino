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
package de.fraunhofer.fokus.fuzzing.fuzzino.request.java;


public abstract class AbstractRequest implements CommonRequest {

	protected String id = null;
	protected int maxValues = 0;
	protected String name = null;
	protected long seed = -1;
	protected boolean isEMFBased = false;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String value) {
		this.id = value;
	}

	@Override
	public int getMaxValues() {
		return maxValues;
	}

	@Override
	public void setMaxValues(int value) {
		this.maxValues = value;

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		this.name = value;

	}

	@Override
	public long getSeed() {
		return seed;
	}

	@Override
	public void setSeed(long value) {
		this.seed = value;
	}

	@Override
	public boolean isEMFBased() {
		return isEMFBased;
	}

	@Override
	public boolean isContinued() {
		return getId() != null;
	}

}
