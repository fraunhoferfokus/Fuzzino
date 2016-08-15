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

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.CollectionOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.CollectionOperatorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.FuzzedCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ResponseFactory;

public class CollectionLengthOperatorTest extends FuzzinoTest {
	
	private static final long SEED = 4711;

	@Test
	public void testWithValidCollection() throws UnknownFuzzingHeuristicException {
		CollectionSpecification spec = RequestFactory.INSTANCE.createCollectionSpecification();
		spec.setRef("ref");
		
		ValidCollection validCollection = RequestFactory.INSTANCE.createValidCollection();
		for (int i=0; i<30; i++) {
			validCollection.addValue(String.valueOf(i));
		}
		
		List<Integer> expectedLengths = new ArrayList<>(21);
		for (int i=20; i<30; i++) {
			expectedLengths.add(i);
		}
		for (int i=31; i<41; i++) {
			expectedLengths.add(i);
		}
		expectedLengths.add(0);
		
		FuzzedCollection inputCollection = ResponseFactory.INSTANCE.createFuzzedCollection(validCollection);
		
		CollectionOperator op = CollectionOperatorFactory.INSTANCE.create("CollectionLength", validCollection, inputCollection, null, spec, SEED);
		int index = 0;
		for (FuzzedValue<FuzzedCollection> fuzzedValue : op) {
			FuzzedCollection fuzzedCollection = fuzzedValue.getValue();
			int actualLength = fuzzedCollection.getValues().size();
			int expectedLength = expectedLengths.get(index);
			assertTrue("Wrong length at index " + index + ": was " + actualLength + " instead of " + expectedLength,
					   actualLength == expectedLength);
			index++;
		}
	}
	
	/*@Test
	public void testWithValidCollectionOfSize_0() throws UnknownFuzzingHeuristicException {
		CollectionSpecification spec = RequestFactory.INSTANCE.createCollectionSpecification();
		spec.setRef("ref");
		
		ValidCollection validCollection = RequestFactory.INSTANCE.createValidCollection();
		validCollection.addValue("1");
		
		FuzzedCollection inputCollection = ResponseFactory.INSTANCE.createFuzzedCollection(validCollection);
		
		CollectionOperator op = CollectionOperatorFactory.INSTANCE.create("CollectionLength", validCollection, inputCollection, null, spec, SEED);
		int index = 0;
		for (FuzzedValue<FuzzedCollection> fuzzedValue : op) {
			FuzzedCollection fuzzedCollection = fuzzedValue.getValue();
			int actualLength = fuzzedCollection.getValues().size();
			int expectedLength = index;
			assertTrue("Wrong length at index " + index + ": was " + actualLength + " instead of " + expectedLength,
					   actualLength == expectedLength);
			index++;
		}
	}*/

}
