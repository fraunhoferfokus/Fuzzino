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

import java.io.Serializable;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsSection;

public class ValidationResult implements Serializable {

	private static final long serialVersionUID = -1949923484286311859L;
	protected boolean result;
	protected WarningsSection warningsPart;
	
	public static final ValidationResult VALID = new ValidationResult(true, null);
	
	public ValidationResult(boolean result, WarningsSection warningsPart) {
		this.result = result;
		this.warningsPart = warningsPart;
	}
	
	public boolean isValid() {
		return result;
	}
	
	public boolean hasWarnings() {
		return !getWarnings().getIllegalGenerators().isEmpty() || 
			   !getWarnings().getIllegalOperators().isEmpty() ||
			   !getWarnings().getIllegalRequestFormats().isEmpty();
	}
	
	public WarningsSection getWarnings() {
		if (warningsPart == null) {
			warningsPart = ResponseFactory.INSTANCE.createWarnings();
		}
		return warningsPart;
	}
	
	public ValidationResult merge(ValidationResult other) {
		boolean newResult = isValid() && other.isValid();
		WarningsSection mergedWarningsPart = getWarnings().merge(other.getWarnings());
		
		return new ValidationResult(newResult, mergedWarningsPart);
	}
	
	@Override
	public String toString() {
		return "[ValidationResult result:" + result + " warningsPart:" + warningsPart + "]";
	}
	
}
