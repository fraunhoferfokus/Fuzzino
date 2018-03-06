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

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.SimpleFuzzingOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;

public abstract class CollectionOperatorImpl extends SimpleFuzzingOperator<FuzzedCollection> {

	private static final long serialVersionUID = -6456037434230182257L;
	protected CollectionSpecification collectionSpec;
	protected FuzzedCollection validCollection;

	public CollectionOperatorImpl(ValidCollection validCollection,
			                      FuzzedCollection collection, 
			                      CollectionSpecification collectionSpec, 
			                      long seed) {
		super(collection, seed);
		this.validCollection = ResponseFactory.INSTANCE.createFuzzedCollection(validCollection);
		this.collectionSpec = collectionSpec;
	}

	public CollectionOperatorImpl(ValidCollection validCollection,
			                      FuzzedCollection collection, 
			                      CollectionSpecification collectionSpec, 
			                      long seed, 
			                      ComputableFuzzingHeuristic<?> owner) {
		super(collection, seed, owner);
		this.validCollection = ResponseFactory.INSTANCE.createFuzzedCollection(validCollection);
		this.collectionSpec = collectionSpec;
	}

}
