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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableListImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.CollectionOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.CollectionOperatorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.CollectionSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ResponseFactory;

/**
 * A chain of {@link CollectionOperator}s that fuzz a valid collection.
 * An instance of this class fuzzes a collection stepwise by applying
 * each CollectionOperator one after another to a valid collection.
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public class CollectionOperatorChain extends ComputableListImpl<FuzzedValue<FuzzedCollection>> 
                                     implements CollectionOperator {
	
	private static final long serialVersionUID = -849406535034097538L;
	protected List<Operator> operators;
	protected final ValidCollection validCollection;
	protected FuzzedCollection inputCollection;
	protected Map<Operator,Integer> operatorSizes = new HashMap<>();
	protected CollectionSpecification collectionSpec;
	protected long seed;
	protected int size = -1;
	
	public CollectionOperatorChain(List<Operator> operators, 
			                       ValidCollection validCollection,
			                       CollectionSpecification collectionSpec,
			                       long seed) {
		this.operators = operators;
		this.validCollection = validCollection;
		inputCollection = ResponseFactory.INSTANCE.createFuzzedCollection(validCollection);
		this.collectionSpec = collectionSpec;
		this.seed = seed;
	}
	
	@Override
	public boolean canCreateValuesFor(CollectionSpecification collectionSpec) {
		return true;
	}

	@Override
	public String getName() {
		String name = "";
		for (int i=0; i<operators.size(); i++) {
			name += operators.get(i).getOperatorName() + (i < operators.size()-1 ? ", " : "");
		}
		return name;
	}

	@Override
	public long getSeed() {
		return seed;
	}

	@Override
	public FuzzedCollection getInputCollection() {
		return inputCollection;
	}

	@Override
	public FuzzedValue<FuzzedCollection> computeElement(int index) {
		// create one combination of fuzzing operators
		List<Integer> indices = computeIndices(index);
		
		// create operators and apply them stepwise
		FuzzedCollection fuzzedCollection = inputCollection;
		for (int i=0; i<operators.size(); i++) {
			Operator op = operators.get(i);
			try {
				CollectionOperator collectionOperator =
						CollectionOperatorFactory.INSTANCE.create(op.getOperatorName(),
								                                  validCollection,
								                                  fuzzedCollection,
								                                  op.getParameter(), 
								                                  collectionSpec, 
								                                  seed);
				FuzzedValue<FuzzedCollection> fuzzedValue = collectionOperator.get(indices.get(i));
				fuzzedCollection = fuzzedValue.getValue();
			} catch (UnknownFuzzingHeuristicException e) {
				e.printStackTrace(); // should be impossible
			}
		}
		
		FuzzedValue<FuzzedCollection> result = new FuzzedValue<>(fuzzedCollection, inputCollection, this);
		
		return result;
	}
	
	private List<Integer> computeIndices(int index) {
		List<Integer> indices = new ArrayList<>(operators.size());
		int cumulatedSizes = 1;
		for (int i=0; i < operators.size(); i++) {
			if (i == 0) {
				int nextIndex = index % operatorSizes.get(i);
				indices.add(nextIndex);
			} else {
				int nextIndex = index / cumulatedSizes;
				indices.add(nextIndex % operatorSizes.get(i));
			}
			cumulatedSizes *= operatorSizes.get(i);
		}
		
		return indices;
	}

	@Override
	public int size() {
		if (size == -1) {
			computeSize();
		}
		return size;
	}
	
	private void computeSize() {
		size = 1;
		for (Operator operator : operators) {
			try {
				CollectionOperator op =
						CollectionOperatorFactory.INSTANCE.create(operator.getOperatorName(),
								                                  validCollection,
						                                          inputCollection,
						                                          operator.getParameter(),
						                                          collectionSpec,
						                                          seed);
				operatorSizes.put(operator, op.size());
				size *= op.size();
			} catch (UnknownFuzzingHeuristicException e) {
				e.printStackTrace();
			}
		}
	}
	
}