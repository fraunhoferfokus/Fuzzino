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
package de.fraunhofer.fokus.fuzzing.fuzzino.jaxb;

import java.util.Arrays;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Value;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.CollectionResponseImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.FuzzedCollectionImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.ValueImpl;

public class CollectionResponseBuilder {

	public static CollectionResponse initCollectionResponse() {
		CollectionResponse resp = new CollectionResponseImpl();
		resp.setFuzzedCollection(initFuzzedCollection());
		resp.setId("collection resp id");
		resp.setMoreValuesAvailable(true);
		resp.setName("collection resp name");
		resp.setSeed(7654);
		resp.setWarningsSection(StringResponseBuilder.initWarningsSection());
		return resp;
	}

	private static List<FuzzedCollection> initFuzzedCollection() {
		FuzzedCollection col1 = new FuzzedCollectionImpl();
		col1.setBasedOn("based on collection");
		col1.setMutations(15);
		col1.setOperators("why only one Operator, but plural?");
		Value val1 = new ValueImpl();
		val1.setGenerator("gen1");
		val1.setValue("the actual first value");
		Value val2 = new ValueImpl();
		val2.setBasedOn("based on value");
		val2.setOperator("op1");
		val2.setValue("the actual second value");
		col1.getValues().add(val1);
		col1.getValues().add(val2);
		//second collection
		FuzzedCollection col2 = new FuzzedCollectionImpl();
		col2.setBasedOn("based on collection");
		col2.setMutations(15);
		col2.setOperators("why only one Operator, but plural?");
		Value val3 = new ValueImpl();
		val3.setGenerator("gen2");
		val3.setValue("the actual first value");
		Value val4 = new ValueImpl();
		val4.setBasedOn("based on value");
		val4.setOperator("op2");
		val4.setValue("the actual second value");
		col2.getValues().add(val3);
		col2.getValues().add(val4);
		return Arrays.asList(col1,col2);
	}

}
