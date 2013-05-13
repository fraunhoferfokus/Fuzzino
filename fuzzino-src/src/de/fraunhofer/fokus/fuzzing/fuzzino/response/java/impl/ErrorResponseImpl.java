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
package de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ErrorResponse;

public class ErrorResponseImpl implements ErrorResponse {

	protected String value;
	protected int column;
	protected boolean columnIsSet = false;
	protected int line;
	protected boolean lineIsSet = false;
	
	@Override
	public String getReason() {
		return value;
	}

	@Override
	public void setReason(String value) {
		this.value = value;
	}

	@Override
	public int getColumn() {
		return column;
	}

	@Override
	public void setColumn(int value) {
		column = value;
		columnIsSet = true;
	}

	@Override
	public void unsetColumn() {
		columnIsSet = false;
	}

	@Override
	public boolean isSetColumn() {
		return columnIsSet;
	}

	@Override
	public int getLine() {
		return line;
	}

	@Override
	public void setLine(int value) {
		line = value;
		lineIsSet = true;
	}

	@Override
	public void unsetLine() {
		lineIsSet = false;
	}

	@Override
	public boolean isSetLine() {
		return lineIsSet;
	}

	@Override
	public de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse getEMFRepresentation() {
		de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse
		  emfErrorResponse = ResponseFactory.eINSTANCE.createErrorResponse();
		
		if (isSetColumn()) {
			emfErrorResponse.setColumn(getColumn());
		}
		if (isSetLine()) {
			emfErrorResponse.setLine(getLine());
		}
		emfErrorResponse.setValue(getReason());
		
		return emfErrorResponse;
	}
	
	@Override
	public String toString() {
		return "[ErrorResponse reason:" + value + (lineIsSet ? " line:" + line : "") + (columnIsSet ? " column: " + column : "") + "]";
	}

}
