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
package de.fraunhofer.fokus.fuzzing.fuzzino.response;

import java.io.File;
import java.io.PrintStream;
import java.util.List;

import javax.xml.bind.JAXBException;

/**
 * This elements contains all responses:
 * <ul>
 * <li>{@link StringResponse}s</li>
 * <li>{@link NumberResponse}s</li>
 * <li>{@link CollectionResponse}s</li>
 * <li>{@link StructureResponse}s</li>
 * </ul>
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface Response {

	/**
	 * @return A list of all {@link StringResponse}s contained in this response.
	 */
	List<StringResponse> getStringResponses();
	
	/**
	 * @param <T>
	 * @return A list of all {@link NumberResponse}s contained in this response.
	 */
	List<NumberResponse<? extends Number>> getNumberResponses();
	
	/**
	 * @return A list of all {@link StructureResponse}s contained in this response.
	 */
	List<StructureResponse> getStructureResponses();
	
	/**
	 * @return A list of all {@link CollectionResponse}s contained in this response.
	 */
	List<CollectionResponse> getCollectionResponses();
	
	/**
	 * @return A list of all {@link CloseRequestConfirmation}s contained in this response.
	 */
	List<CloseRequestConfirmation> getCloseRequestConfirmations();
	
	/**
	 * @return The {@link ErrorResponse} contained in this response if exists.
	 */
	ErrorResponse getErrorResponse();
	
	/**
	 * Sets the {@link ErrorResponse} with another one.
	 * 
	 * @param value The {@link ErrorResponse} to be contained in this response.
	 */
	void setErrorResponse(ErrorResponse value);

	void marshall(File responseFile) throws JAXBException;

	void marshall(PrintStream out) throws JAXBException;
	
}
