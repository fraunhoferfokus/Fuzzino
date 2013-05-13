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
package de.fraunhofer.fokus.fuzzing.fuzzino.response.java;

public interface ErrorResponse {

	String getReason();
	void setReason(String value);
	int getColumn();
	void setColumn(int value);
	void unsetColumn();
	boolean isSetColumn();
	int getLine();
	void setLine(int value);
	void unsetLine();
	boolean isSetLine();
	
	de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse getEMFRepresentation();
}
