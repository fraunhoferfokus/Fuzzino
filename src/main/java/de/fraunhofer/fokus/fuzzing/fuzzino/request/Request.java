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
package de.fraunhofer.fokus.fuzzing.fuzzino.request;

import java.io.File;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.JAXBException;

/**
 * This element contains all requests:
 * <ul>
 * <li>{@link StringRequest}s</li>
 * <li>{@link NumberRequest}s</li>
 * <li>{@link CollectionRequest}s</li>
 * <li>{@link StructureRequest}s</li>
 * </ul>
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public interface Request extends Serializable {

	/**
	 * @return A list of all {@link StringRequest}s contained in this request.
	 */
	List<StringRequest> getStringRequests();
	
	/**
	 * Replaces the list of {@link StringRequest}s contained in this request.
	 * 
	 * @param value The new list of {@link StringRequest}s replacing the existing one.
	 */
	void setStringRequests(List<StringRequest> value);
	
	/**
	 * Adds a {@link StringRequest} to this request.
	 * 
	 * @param value The {@link StringRequest} to be added.
	 */
	void addStringRequest(StringRequest value);
	
	/**
	 * @return A list of all {@link NumberRequest}s contained in this request.
	 */
	List<NumberRequest> getNumberRequests();
	
	/**
	 * Replaces the list of {@link NumberRequest}s contained in this request.
	 * 
	 * @param value The new list of {@link NumberRequest}s replacing the existing one.
	 */
	void setNumberRequests(List<NumberRequest> value);
	
	/**
	 * Adds a {@link NumberRequest} to this request.
	 * 
	 * @param value The {@link NumberRequest} to be added.
	 */
	void addNumberRequest(NumberRequest value);
	
	/**
	 * @return A list of all {@link StructureRequest}s contained in this request.
	 */
	List<StructureRequest> getStructureRequests();
	
	/**
	 * Replaces the list of {@link StructureRequest}s contained in this request.
	 * 
	 * @param value The new list of {@link StructureRequest}s replacing the existing one.
	 */
	void setStructureRequests(List<StructureRequest> value);
	
	/**
	 * Adds a {@link StructureRequest} to this request.
	 * 
	 * @param value The {@link StructureRequest} to be added.
	 */
	void addStructureRequest(StructureRequest value);
	
	/**
	 * @return A list of all {@link CollectionRequest}s contained in this request.
	 */
	List<CollectionRequest> getCollectionRequests();
	
	/**
	 * Replaces the list of {@link CollectionRequest}s contained in this request.
	 * 
	 * @param value The new list of {@link CollectionRequest}s replacing the existing one.
	 */
	void setCollectionRequests(List<CollectionRequest> value);
	
	/**
	 * Adds a {@link CollectionRequest} to this request.
	 * 
	 * @param value the {@link CollectionRequest} to be added.
	 */
	void addCollectionRequest(CollectionRequest value);
	
	
	/**
	 * @return A list of all {@link CloseRequest} command contained in this request.
	 */
	List<CloseRequest> getCloseRequests();
	
	/**
	 * Replaces the list of {@link CloseRequest} commands contained in this request.
	 * 
	 * @param value The new list of {@link CloseRequest} commands replacing the existing one.
	 */
	void setCloseRequests(List<CloseRequest> value);
	
	/**
	 * Adds a {@link CloseRequest} command to this request.
	 * 
	 * @param value the {@link CloseRequest} command to be added.
	 */
	void addCloseRequest(CloseRequest value);

	void marshall(File file) throws JAXBException;

	void marshall(PrintStream out) throws JAXBException;
	
}
