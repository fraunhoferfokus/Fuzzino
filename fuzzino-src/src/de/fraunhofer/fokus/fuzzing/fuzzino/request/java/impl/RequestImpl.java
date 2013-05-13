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

import java.util.ArrayList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.CloseRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.CollectionRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Request;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StructureRequest;

public class RequestImpl implements Request {

	private static final long serialVersionUID = 1915856810760232417L;
	protected List<StringRequest> stringRequests;
	protected List<NumberRequest> numberRequests;
	protected List<StructureRequest> structureRequests;
	protected List<CollectionRequest> collectionRequests;
	protected List<CloseRequest> closeRequests;
	protected boolean isEMFBased = false;
	
	@Override
	public List<StringRequest> getStringRequests() {
		if (stringRequests == null) {
			stringRequests = new ArrayList<>();
		}
		return stringRequests;
	}
	
	@Override
	public void setStringRequests(List<StringRequest> value) {
		getStringRequests().addAll(value);
	}
	
	@Override
	public List<NumberRequest> getNumberRequests() {
		if (numberRequests == null) {
			numberRequests = new ArrayList<>();
		}
		return numberRequests;
	}
	
	@Override
	public void setNumberRequests(List<NumberRequest> value) {
		getNumberRequests().addAll(value);
	}
	
	@Override
	public List<StructureRequest> getStructureRequests() {
		if (structureRequests == null) {
			structureRequests = new ArrayList<>();
		}
		return structureRequests;
	}
	
	@Override
	public void setStructureRequests(List<StructureRequest> value) {
		getStructureRequests().addAll(value);
	}
	
	@Override
	public List<CollectionRequest> getCollectionRequests() {
		if (collectionRequests == null) {
			collectionRequests = new ArrayList<>();
		}
		return collectionRequests;
	}
	
	@Override
	public void setCollectionRequests(List<CollectionRequest> value) {
		getCollectionRequests().addAll(value);
	}
	
	@Override
	public List<CloseRequest> getCloseRequests() {
		if (closeRequests == null) {
			closeRequests = new ArrayList<>();
		}
		return closeRequests;
	}
	
	@Override
	public void setCloseRequests(List<CloseRequest> value) {
		getCloseRequests().addAll(value);
	}
	
	@Override
	public void setWithEMFObject(de.fraunhofer.fokus.fuzzing.fuzzino.request.Request emfRequest) {
		for (de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest stringRequestEMF : emfRequest.getStringRequests()) {
			addStringRequest(RequestFactory.INSTANCE.createStringRequest(stringRequestEMF));
		}
		for (de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest numberRequestEMF : emfRequest.getNumberRequests()) {
			addNumberRequest(RequestFactory.INSTANCE.createNumberRequest(numberRequestEMF));
		}
		for (de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest structureRequestEMF : emfRequest.getStructureRequests()) {
			addStructureRequest(RequestFactory.INSTANCE.createStructureRequest(structureRequestEMF));
		}
		for (de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest collectionRequestEMF : emfRequest.getCollectionRequests()) {
			addCollectionRequest(RequestFactory.INSTANCE.createCollectionRequest(collectionRequestEMF));
		}
		for (de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest closeRequestEMF : emfRequest.getCloseRequests()) {
			addCloseRequest(RequestFactory.INSTANCE.createCloseRequest(closeRequestEMF));
		}
		isEMFBased = true;
	}

	@Override
	public void addStringRequest(StringRequest value) {
		getStringRequests().add(value);
	}

	@Override
	public void addNumberRequest(NumberRequest value) {
		getNumberRequests().add(value);
	}

	@Override
	public void addStructureRequest(StructureRequest value) {
		getStructureRequests().add(value);
	}

	@Override
	public void addCollectionRequest(CollectionRequest value) {
		getCollectionRequests().add(value);
	}

	@Override
	public void addCloseRequest(CloseRequest value) {
		getCloseRequests().add(value);
	}

	@Override
	public boolean isEMFBased() {
		return isEMFBased;
	}
	
	@Override
	public String toString() {
		return "[Request stringRequests:" + (stringRequests == null ? "0" : stringRequests.size()) + 
			 "\n         numberRequests:" + (numberRequests == null ? "0" : numberRequests.size()) +
			 "\n         structureRequests:" + (structureRequests == null ? "0" : structureRequests.size()) +
			 "\n         collectionRequets:" + (collectionRequests == null ? "0" : collectionRequests.size()) +
			 "\n         closeRequests:" + (closeRequests == null ? "0" : closeRequests.size()) + "]";
		}
	
}
