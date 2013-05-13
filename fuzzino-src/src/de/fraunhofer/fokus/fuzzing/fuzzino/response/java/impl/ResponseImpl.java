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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.CloseRequestConfirmation;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.CollectionResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ErrorResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Response;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StructureResponse;

public class ResponseImpl implements Response {

	protected List<StringResponse> stringResponses;
	protected List<NumberResponse<? extends Number>> numberResponses;
	protected List<StructureResponse> structureResponses;
	protected List<CollectionResponse> collectionResponses;
	protected List<CloseRequestConfirmation> closeRequestConfirmations;
	protected ErrorResponse errorResponse;
	
	@Override
	public List<StringResponse> getStringResponses() {
		if (stringResponses == null) {
			stringResponses = new LinkedList<>();
		}
		return stringResponses;
	}

	@Override
	public List<NumberResponse<? extends Number>> getNumberResponses() {
		if (numberResponses == null) {
			numberResponses = new ArrayList<>();
		}
		return numberResponses;
	}

	@Override
	public List<StructureResponse> getStructureResponses() {
		if (structureResponses == null) {
			structureResponses = new LinkedList<>();
		}
		return structureResponses;
	}

	@Override
	public List<CollectionResponse> getCollectionResponses() {
		if (collectionResponses == null) {
			collectionResponses = new LinkedList<>();
		}
		return collectionResponses;
	}

	@Override
	public List<CloseRequestConfirmation> getCloseRequestConfirmations() {
		if (closeRequestConfirmations == null) {
			closeRequestConfirmations = new LinkedList<>();
		}
		return closeRequestConfirmations;
	}

	@Override
	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	@Override
	public void setErrorResponse(ErrorResponse value) {
		errorResponse = value;
	}

	@Override
	public de.fraunhofer.fokus.fuzzing.fuzzino.response.Response getEMFRepresentation() {
		de.fraunhofer.fokus.fuzzing.fuzzino.response.Response
		  emfResponse = ResponseFactory.eINSTANCE.createResponse();
		
		for (StringResponse stringResponse : getStringResponses()) {
			emfResponse.getStringResponses().add(stringResponse.getEMFRepresentation());
		}
		for (NumberResponse<? extends Number> numberResponse : getNumberResponses()) {
			emfResponse.getNumberResponses().add(numberResponse.getEMFRepresentation());
		}
		for (StructureResponse structureResponse : getStructureResponses()) {
			emfResponse.getStructureResponses().add(structureResponse.getEMFRepresentation());
		}
		for (CollectionResponse collectionResponse : getCollectionResponses()) {
			emfResponse.getCollectionResponses().add(collectionResponse.getEMFRepresentation());
		}
		for (CloseRequestConfirmation closeRequestConfirmation : getCloseRequestConfirmations()) {
			emfResponse.getCloseRequestConfirmations().add(closeRequestConfirmation.getEMFRepresentation());
		}
		if (getErrorResponse() != null) {
			emfResponse.setErrorResponse(getErrorResponse().getEMFRepresentation());
		}
		
		return emfResponse;
	}
	
	@Override
	public String toString() {
		return "[Response stringResponses:" + (stringResponses == null ? "0" : stringResponses.size()) +
			 "\n          numberResponses:" + (numberResponses == null ? "0" : numberResponses.size()) +
			 "\n          structureResponses:" + (structureResponses == null ? "0" : structureResponses.size()) + 
			 "\n          collectionResponses:" + (collectionResponses == null ? "0" : collectionResponses.size()) +
			 "\n          closeRequestConfirmations:" + (closeRequestConfirmations == null ? "0" : closeRequestConfirmations.size()) +
			 "\n          errorResponses:" + errorResponse + "]";
	}

}
