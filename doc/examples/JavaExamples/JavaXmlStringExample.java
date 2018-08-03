package JavaExamples;
import de.fraunhofer.fokus.fuzzing.fuzzino.RequestDispatcher;


public class JavaXmlStringExample {
	
	public static void main(String[] args) {
		// generate a string containing an XML request document
		// the fuzzingRequest.xsd defines a schema for valid request documents, the documentation contains its description		
		String xmlRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" + 
				"<ns2:request xmlns:ns2=\"http://fuzzino.fuzzing.fokus.fraunhofer.de/request\">\n" + 
				"    <string maxValues=\"50\" name=\"StringRequestTest\" seed=\"-1\">\n" + 
				"        <noGenerators>false</noGenerators>\n" + 
				"        <generator value=\"BADSTRINGS\"/>\n" + 
				"        <specification type=\"STRING\" nullTerminated=\"true\" minLength=\"0\" maxLength=\"2147483647\" encoding=\"UTF8\" ignoreLengths=\"false\"/>\n" + 
				"        <validValues>\n" + 
				"            <operator name=\"STRINGCASE\"/>\n" + 
				"            <value>ABC</value>\n" + 
				"        </validValues>\n" + 
				"    </string>\n" + 
				"</ns2:request>";
		
		// create instance of fuzzino
		RequestDispatcher fuzzino = new RequestDispatcher(xmlRequest);
		
		// start processing
		fuzzino.dispatch();
		
		// fetch the response of fuzzino
		String xmlResponse = fuzzino.getXmlResponseString();
		
		System.out.println(xmlResponse);

	}

}
