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
package de.fraunhofer.fokus.fuzzing.fuzzino;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.DeleteRequestProcessorFailedException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.CollectionOperatorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.collection.CollectionOperatorChain;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.CollectionRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.CommonRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.ValidCollectionsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.CollectionResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.CommonResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.PermutationsOfFixedLength;

public class CollectionRequestProcessor extends RequestProcessor<FuzzedCollection> {

	private static final long serialVersionUID = -8894931763833666794L;
	private CollectionRequest request;
	private transient CollectionResponse collectionResponse;
	private static final String COLLECTION_EXTENSION = ".collectionProcessor";
	
	public CollectionRequestProcessor(CommonRequest request, UUID id) {
		super(request, id);
	}

	@Override
	public CommonRequest getRequest() {
		return request;
	}

	@Override
	public void setRequest(CommonRequest request) {
		if (request instanceof CollectionRequest) {
			request = (CollectionRequest) request;
		} else {
			throw new IllegalArgumentException("Illegal type " +  request.getClass().getSimpleName() + ". Expected CollectionRequest.");
		}
	}

	@Override
	public CommonResponse getResponse() {
		if (collectionResponse == null) {
			collectionResponse = ResponseFactory.INSTANCE.createCollectionResponse();
		}
		return collectionResponse;
	}

	@Override
	protected void buildResponseContents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addRequestedGenerators() {
		// generators aren't applicable for collections
		// hence, nothing has to be done.
	}

	@Override
	protected void addRequestedOperators() {
		ValidCollectionsSection validCollectionsPart = request.getValidCollectionsSection();
		if (validCollectionsPart == null) {
			return;
		}
		
		List<ValidCollection> validCollections = validCollectionsPart.getValidCollections();
		
		List<Operator> validOperators = retrieveOperatorsFromRequest();
		
		// build a composed fuzzing heuristics that contains all combinations of fuzzing operators
		PermutationsOfFixedLength<Operator> permutations =
				new PermutationsOfFixedLength<>(validOperators,
												        request.getMinMutations(),
												        request.getMaxMutations());
		for (List<Operator> permutation : permutations) {
			for (ValidCollection collection : validCollections) {
				CollectionOperatorChain chain = 
						new CollectionOperatorChain(permutation, collection, request.getSpecification(), seed);
				heuristics.add(chain);
			}
		}
	}
	
	private List<Operator> retrieveOperatorsFromRequest() {
		ValidCollectionsSection validCollectionsPart = request.getValidCollectionsSection();
		List<Operator> allRequestedOperators = validCollectionsPart.getRequestedOperators();
		
		if (allRequestedOperators.isEmpty()) {
			return getAllOperators();
		} else {
			return getAllValidRequestedOperators();
		}
	}
	
	private List<Operator> getAllOperators() {
		List<String> allKnownOperators = CollectionOperatorFactory.INSTANCE.getKnownOperatorNames();
		List<Operator> validOperators = new ArrayList<>(allKnownOperators.size());
		
		for (String name : allKnownOperators) {
			Operator operator = RequestFactory.INSTANCE.createOperator(name);
			validOperators.add(operator);
		}
		
		return validOperators;
	}
	
	private List<Operator> getAllValidRequestedOperators() {
		ValidCollectionsSection validCollectionsPart = request.getValidCollectionsSection();
		List<Operator> allRequestedOperators = validCollectionsPart.getRequestedOperators();

		List<Operator> validOperators = new ArrayList<>(allRequestedOperators.size());

		for (Operator requestedOperator : allRequestedOperators) {
			if (CollectionOperatorFactory.INSTANCE.isKnown(requestedOperator.getOperatorName())) {
				validOperators.add(requestedOperator);
			} else {
				IllegalOperator illegalOperator = ResponseFactory.INSTANCE.createIllegalOperator(requestedOperator.getOperatorName(), "unknown operator");
				getWarningsPart().getIllegalOperators().add(illegalOperator);
			}
		}
		
		return validOperators;
	}

	@Override
	public void serialize() {
		try
		{
			FileOutputStream fos = new FileOutputStream(getId().toString() + COLLECTION_EXTENSION);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(this);
			out.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete() throws DeleteRequestProcessorFailedException {
		// TODO Auto-generated method stub
		
	}

}
