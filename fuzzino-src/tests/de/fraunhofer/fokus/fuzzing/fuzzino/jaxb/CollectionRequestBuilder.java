package de.fraunhofer.fokus.fuzzing.fuzzino.jaxb;

import java.util.ArrayList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollectionsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CollectionRequestImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.CollectionSpecificationImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.OperatorImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidCollectionImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.ValidCollectionsSectionImpl;

public class CollectionRequestBuilder {

	public static CollectionRequest initCollectioNRequest() {
		CollectionRequest req = new CollectionRequestImpl();
		req.setFuzzCollections(true);
		req.setFuzzValues(true);
		req.setId("collection request id");
		req.setMaxMutations(17);
		req.setMaxValues(4000);
		req.setMinMutations(5);
		req.setName("name for my collection request");
		req.setSeed(1234);
		req.setSpecification(initSpecification());
		req.setValidCollectionsSection(initValidValues());
		return req;
	}

	private static ValidCollectionsSection initValidValues() {
		ValidCollectionsSection section = new ValidCollectionsSectionImpl();
		section.setRequestedOperators(initOpList());
		section.setValidCollections(initValidCollections());
		return section;
	}

	private static List<ValidCollection> initValidCollections() {
		List<ValidCollection> collections = new ArrayList<>();
		collections.add(new ValidCollectionImpl("valid collection name 1","val 1", "val2","val3"));
		collections.add(new ValidCollectionImpl("valid collection name 2","val 1", "val2","val3"));
		return collections;
	}

	private static List<Operator> initOpList() {
		List<Operator> opList = new ArrayList<>();
		opList.add(new OperatorImpl("op 1 name"));
		opList.add(new OperatorImpl("op 2 name"));
		opList.add(new OperatorImpl("op 3 name","op 3 param"));
		return opList;
	}

	private static CollectionSpecification initSpecification() {
		CollectionSpecification spec = new CollectionSpecificationImpl();
		spec.setMaxLength(14);
		spec.setMinLength(1);
		spec.setOrdered(true);
		spec.setRef("some reference string that I have no ide what it does here :D");
		spec.setUnique(true);
		return spec;
	}

}
