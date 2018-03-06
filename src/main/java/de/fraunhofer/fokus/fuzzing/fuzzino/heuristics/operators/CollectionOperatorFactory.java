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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.collection.CollectionLengthOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class CollectionOperatorFactory {
	
	private final List<String> knownOperators = StringUtil.asList("CollectionLength".toUpperCase());
	
	/**
	 * The singleton instance of the factory.
	 */
	public static final CollectionOperatorFactory INSTANCE = new CollectionOperatorFactory();
	
	/**
	 * Private constructor because it's a singleton.
	 */
	private CollectionOperatorFactory() { }
	
	public CollectionOperator create(String name,
			                         ValidCollection validCollection,
			                         FuzzedCollection inputCollections,
			                         String param,
			                         CollectionSpecification collectionSpec, 
			                         long seed) throws UnknownFuzzingHeuristicException {
		String canonicalName = name.trim().toUpperCase();
		if (canonicalName.equals("CollectionLength".toUpperCase())) {
			return createCollectionLengthOperator(validCollection, inputCollections, null, collectionSpec, seed);
		} else {
			throw new UnknownFuzzingHeuristicException(name);
		}
	}
	
	public List<CollectionOperator> createAll(ValidCollection validCollection,
			                                  FuzzedCollection inputCollection, 
			                                  CollectionSpecification collectionSpec, 
			                                  long seed) {
		List<CollectionOperator> allCollectionOperators = new ArrayList<>();
		allCollectionOperators.add(
				createCollectionLengthOperator(validCollection, inputCollection, null, collectionSpec, seed)
				);
		
		List<CollectionOperator> applicableOperators = new LinkedList<>();
		for (CollectionOperator collectionOperator : allCollectionOperators) {
			if (collectionOperator.canCreateValuesFor(collectionSpec)) {
				applicableOperators.add(collectionOperator);
			}
		}
		
		return applicableOperators;
	}
	
	public CollectionLengthOperator createCollectionLengthOperator(ValidCollection validCollection,
			                                                       FuzzedCollection inputCollections,
			                                                       String param,
			                                                       CollectionSpecification collectionSpec,
			                                                       long seed) {
		return new CollectionLengthOperator(validCollection, inputCollections, param, collectionSpec, seed);
	}
	
	public boolean isKnown(String name) {
		String canonicalName = name.trim().toUpperCase();
		return knownOperators.contains(canonicalName);
	}
	
	public List<String> getKnownOperatorNames() {
		return Collections.unmodifiableList(knownOperators);
	}

}
