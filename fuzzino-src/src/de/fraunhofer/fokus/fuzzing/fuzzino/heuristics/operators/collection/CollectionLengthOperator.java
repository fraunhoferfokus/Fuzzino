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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.collection;

import java.util.ArrayList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.CollectionOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Value;

public class CollectionLengthOperator extends CollectionOperatorImpl implements CollectionOperator {

	private static final long serialVersionUID = -8907411780599433262L;
	private static final int DEFAULT_VARIANCE_RANGE = 10;
	protected int varianceRange = DEFAULT_VARIANCE_RANGE;
	protected List<Integer> targetCollectionLengths;
	
	public CollectionLengthOperator(ValidCollection validCollection,
			                        FuzzedCollection collection, 
			                        CollectionSpecification collectionSpec,
			                        long seed) {
		super(validCollection, collection, collectionSpec, seed);
		determineLengths();
	}

	public CollectionLengthOperator(ValidCollection validCollection,
			                        FuzzedCollection collection, 
			                        CollectionSpecification collectionSpec,
			                        long seed,
			                        ComputableFuzzingHeuristic<?> owner) {
		super(validCollection, collection, collectionSpec, seed, owner);
		determineLengths();
	}

	public CollectionLengthOperator(ValidCollection validCollection,
			                        FuzzedCollection collection, 
			                        String param, 
			                        CollectionSpecification collectionSpec,
			                        long seed) {
		super(validCollection, collection, collectionSpec, seed);
		try {
			varianceRange = Integer.parseInt(param);
		} catch (NumberFormatException e) { }
		determineLengths();
	}

	public CollectionLengthOperator(ValidCollection validCollection,
			                        FuzzedCollection collection, 
		                            String param,
		                            CollectionSpecification collectionSpec,
		                            long seed,
		                            ComputableFuzzingHeuristic<?> owner) {
		super(validCollection, collection, collectionSpec, seed, owner);
		try {
			varianceRange = Integer.parseInt(param);
		} catch (NumberFormatException e) { }
		determineLengths();
	}
	
	private void determineLengths() {
		targetCollectionLengths = new ArrayList<>(24);
		
		int length = inputValue.getValues().size();
		int minLength = Math.max(collectionSpec.getMinLength(), length-varianceRange);
		int maxLength = Math.min(length+varianceRange, collectionSpec.getMaxLength());

		for (int i=minLength; i<length; i++) {
			targetCollectionLengths.add(i);
		}
		for (int i=length+1; i<=maxLength; i++) {
			targetCollectionLengths.add(i);
		}
		
		// add border cases
		if (minLength > collectionSpec.getMinLength()) {
			targetCollectionLengths.add(collectionSpec.getMinLength());
		}
		if (collectionSpec.getMinLength() > 0) {
			targetCollectionLengths.add(collectionSpec.getMinLength() - 1);
		}
		if (maxLength < collectionSpec.getMaxLength() && collectionSpec.getMaxLength() < Integer.MAX_VALUE) {
			targetCollectionLengths.add(collectionSpec.getMaxLength());
		}
		if (collectionSpec.getMaxLength() < Integer.MAX_VALUE) {
			targetCollectionLengths.add(collectionSpec.getMaxLength() + 1);
		}
		
		size = targetCollectionLengths.size();
	}

	@Override
	public String getName() {
		return "CollectionLength";
	}

	@Override
	public FuzzedValue<FuzzedCollection> computeElement(int index) {
		FuzzedCollection fuzzedCollection = changeCollectionSizeTo(targetCollectionLengths.get(index));
		fuzzedCollection.setMutations(fuzzedCollection.getMutations()+1);
		fuzzedCollection.setOperators(getName());
		
		FuzzedValue<FuzzedCollection> fuzzedValue = 
				new FuzzedValue<>(fuzzedCollection, validCollection, owner);
		
		return fuzzedValue;
	}
	
	private FuzzedCollection changeCollectionSizeTo(int targetSize) {
		FuzzedCollection fuzzedCollection;
		if (targetSize < inputValue.size()) {
			fuzzedCollection = shortenCollectionToSize(targetSize);
		} else {
			fuzzedCollection = enlargeCollectionToSize(targetSize);
		}
		return fuzzedCollection;
	}
	
	private FuzzedCollection shortenCollectionToSize(int targetSize) {
		FuzzedCollection fuzzedCollection = ResponseFactory.INSTANCE.createFuzzedCollection();
		
		fuzzedCollection.getValues().addAll(inputValue.getValues());
		int originalSize = fuzzedCollection.getValues().size();
		for (int i=originalSize-1; i>=targetSize; i--) {
			fuzzedCollection.getValues().remove(i);
		}
		return fuzzedCollection;
	}
	
	private FuzzedCollection enlargeCollectionToSize(int targetLength) {
		FuzzedCollection fuzzedCollection = ResponseFactory.INSTANCE.createFuzzedCollection();
		
		int currentLength = inputValue.getValues().size();
		
		Value valueToBeAppended;
		if (currentLength > 0 && !collectionSpec.isUnique()) {
			// repeat last value of collection
			valueToBeAppended = inputValue.getValues().get(currentLength-1);
		} else {
			int lengthValidCollection = validCollection.getValues().size();
			valueToBeAppended = validCollection.getValues().get(lengthValidCollection-1);
		}
		fuzzedCollection.getValues().addAll(inputValue.getValues());
		int originalSize = fuzzedCollection.getValues().size();
		int elementsToAdd = targetLength - originalSize;
		for (int i=0; i<elementsToAdd; i++) {
			fuzzedCollection.getValues().add(valueToBeAppended);
		}
		return fuzzedCollection;
	}
	
//	private Value getValueToBeAppended(FuzzedCollection fuzzedCollection) {
//		return null;
//	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean canCreateValuesFor(CollectionSpecification collectionSpec) {
		return true;
	}

	@Override
	public FuzzedCollection getInputCollection() {
		return inputValue;
	}

}
