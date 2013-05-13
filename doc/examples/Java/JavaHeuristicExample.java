import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGeneratorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadFilenamesGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringEncoding;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.StringType;

public class JavaHeuristicExample {

	public static void main(String[] args) {
		StringSpecification stringSpecification = RequestFactory.INSTANCE.createStringSpecification();
		stringSpecification.setEncoding(StringEncoding.UTF8);
		stringSpecification.setType(StringType.FILENAME);
		stringSpecification.setIgnoreLengths(true);

		BadFilenamesGenerator badFilenamesGenerator = StringGeneratorFactory.INSTANCE.createBadFilenames(stringSpecification, 0);
		for (FuzzedValue<String> fuzzedValue : badFilenamesGenerator) {
			System.out.println(fuzzedValue);
			String decodedValue = fuzzedValue.getValue().replaceAll("\\\\x00", "" + ((char)0));
			System.out.println(decodedValue);
		}
	}
	
}
