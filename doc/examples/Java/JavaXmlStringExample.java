import de.fraunhofer.fokus.fuzzing.fuzzino.RequestDispatcher;


public class JavaXmlStringExample {
	
	public static void main(String[] args) {
		// generate a string containing an XML request document
		// the fuzzingRequest.xsd defines a schema for valid request documents, the documentation contains its description
		String xmlRequest = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
				"<request xmlns=\"http://fuzzino.fuzzing.fokus.fraunhofer.de/request\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n\t" +
				"xsi:schemaLocation=\"http://fuzzino.fuzzing.fokus.fraunhofer.de/request\">\n\n" +
				"<string name=\"ValidRequest_STRING\" maxValues=\"50\">\n\t" +
				"<specification minLength=\"1\" maxLength=\"5\" nullTerminated=\"true\" encoding=\"UTF8\">MySpec</specification>\n\t" +
				"<generator>BadStrings</generator>\n\t" +
				"<validValues>\n\t\t" +
				"<value>ABC</value>\n\t\t" +
				"<operator>StringCase</operator>\n\t" +
				"</validValues>\n" +
				"</string>\n\n" +
				"</request>";
		
		// create instance of fuzzino
		RequestDispatcher fuzzino = new RequestDispatcher(xmlRequest);
		
		// start processing
		fuzzino.dispatch();
		
		// fetch the response of fuzzino
		String xmlResponse = fuzzino.getXmlResponseString();
		
		System.out.println(xmlResponse);

	}

}
