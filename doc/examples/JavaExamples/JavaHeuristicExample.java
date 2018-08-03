package JavaExamples;
import de.fraunhofer.fokus.fuzzing.fuzzino.FuzzedValue;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringGeneratorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadFilenamesGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringEncoding;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;

public class JavaHeuristicExample {

	public static void main(String[] args) {
		// generate a a specification that describes the type (corresponding XML tag 'specification')
		StringSpecification stringSpecification = RequestFactory.INSTANCE.createStringSpecification();
		stringSpecification.setEncoding(StringEncoding.UTF8);
		stringSpecification.setType(StringType.FILENAME);
		stringSpecification.setIgnoreLengths(true);

		// create instance of fuzzing heuristic for bad filenames
		BadFilenamesGenerator badFilenamesGenerator = StringGeneratorFactory.INSTANCE.createBadFilenames(stringSpecification, 0);
		
		// fetch as many fuzzed values from the fuzzing heuristics as you need
		for (FuzzedValue<String> fuzzedValue : badFilenamesGenerator) {
			System.out.println(fuzzedValue);
			
			// decode control characters as needed
			// the encoding scheme is \xnn for an ASCII character, \\unnnn for a UTF-16 character and \\unnnnnnnn for a UTF-32 character
			// n is a hexadecimal digit
			String decodedValue = fuzzedValue.getValue().replaceAll("\\\\x00", "" + ((char)0));
			System.out.println(decodedValue);
		}
	}
	
}
