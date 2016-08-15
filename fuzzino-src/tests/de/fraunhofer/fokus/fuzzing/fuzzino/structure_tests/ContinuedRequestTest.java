package de.fraunhofer.fokus.fuzzing.fuzzino.structure_tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.StringRequestProcessor;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadIpAddressesGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.GeneratorSpecificFuzzedValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StringResponse;

public class ContinuedRequestTest extends FuzzinoTest {

	private long seed =10;
	private StringSpecification stringSpec = StructureTestUtil.createExampleStringSpec();


	@Test
	public void continuedStringRequestTest() {
		BadIpAddressesGenerator badStringsGen = new BadIpAddressesGenerator(stringSpec , seed );
		StringRequest req = StructureTestUtil.createNewExampleStringRequest("req", seed, stringSpec, "BadIpAddresses", new ArrayList<String>(), 10);
		List<FuzzedValue<String>> expected = badStringsGen.subList(0, 10);
		StringRequestProcessor proc = new StringRequestProcessor(req, UUID.randomUUID());
		StringResponse resp = proc.getResponse();
		assertEquals(1,resp.getGeneratorBasedSection().getGeneratorSpecificSections().size());
		GeneratorSpecificFuzzedValues<String> generatorSpecificSection = resp.getGeneratorBasedSection().getGeneratorSpecificSections().get(0);
		assertFuzzedValueEquality(expected,generatorSpecificSection.getFuzzedValues());
		int count = 1;
		while(resp.moreValuesAvailable()){
			expected = badStringsGen.subList(10*count, Math.min(10*(count+1),badStringsGen.size()));
			proc.continueRequest(req);
			resp = proc.getResponse();
			assertEquals(1,resp.getGeneratorBasedSection().getGeneratorSpecificSections().size());
			generatorSpecificSection = resp.getGeneratorBasedSection().getGeneratorSpecificSections().get(0);
			assertFuzzedValueEquality(expected,generatorSpecificSection.getFuzzedValues());
			count++;
		}
	}

	private void assertFuzzedValueEquality(List<FuzzedValue<String>> expected,List<FuzzedValue<String>> actual) {
		assertEquals(expected.size(),actual.size());
		for(int i=0;i<expected.size();i++){
			/*System.out.println(count++);
			System.out.println("-------------------------------------------------------");
			System.out.println("expeceted: "+expected.get(i).getValue());
			System.out.println("actual:    "+actual.get(i).getValue());
			System.out.println("-------------------------------------------------------");*/
			assertEquals(expected.get(i).getValue(), actual.get(i).getValue());
		}
	}

}
