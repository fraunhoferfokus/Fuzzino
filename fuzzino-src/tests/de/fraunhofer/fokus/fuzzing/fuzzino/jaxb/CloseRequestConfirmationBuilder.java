package de.fraunhofer.fokus.fuzzing.fuzzino.jaxb;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.CloseRequestConfirmation;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.CloseRequestConfirmationImpl;

public class CloseRequestConfirmationBuilder {

	public static CloseRequestConfirmation initCloseRequestConfirmation() {
		CloseRequestConfirmation conf = new CloseRequestConfirmationImpl();
		conf.setId("close request confirmation id");
		conf.setName("close request confirmation name");
		conf.setWarningsPart(StringResponseBuilder.initWarningsSection());
		return conf;
	}

}
