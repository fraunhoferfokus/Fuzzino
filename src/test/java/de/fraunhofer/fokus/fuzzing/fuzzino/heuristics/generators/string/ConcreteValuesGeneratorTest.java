package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzinoTest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringEncoding;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.StringSpecificationImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class ConcreteValuesGeneratorTest extends FuzzinoTest {

	@Test
	public void testBug_dublicateValuesInConreteGenerator(){
		StringSpecification sP = new StringSpecificationImpl();
		sP.setType(StringType.get("XSS"));
		sP.setMinLength(1);
		sP.setMaxLength(1000);
		sP.setIsNullTerminated(true);
		sP.setEncoding(StringEncoding.get("ASCII"));
		sP.setIgnoreLengths(true);
		AllBadStringsGenerator owner = new AllBadStringsGenerator(sP, 0);
		ConcreteValuesGenerator gen1 = new ConcreteValuesGenerator(sP, 0,owner,"test1","test2");
		gen1.addAll(StringUtil.asList("test3","test4"));
		Iterator<FuzzedValue<String>> it = gen1.iterator();
		List<String> allValues= StringUtil.asList("test1","test2","test3","test4");
		while(it.hasNext()){
			allValues.remove(it.next());
		}
	}	

}
