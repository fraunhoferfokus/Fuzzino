package de.fraunhofer.fokus.fuzzing.fuzzino.jaxb;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ErrorResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.ErrorResponseImpl;

public class ErrorResponseBuilder {

	public static ErrorResponse initErrorResponse() {
		ErrorResponse resp = new ErrorResponseImpl();
		resp.setMessage("message");
		resp.setStackTrace("stack trace");
		resp.setReason("reason");
		return resp;
	}

}
