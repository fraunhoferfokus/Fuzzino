package de.fraunhofer.fokus.fuzzing.fuzzino.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class StackTrace {

	private Throwable xmlParsingError = null;
	
	public StackTrace(Throwable xmlParsingError) {
		this.xmlParsingError = xmlParsingError;
	}
	
	public String toString() {
		try (
				StringWriter stringWriter = new StringWriter();
				PrintWriter printWriter = new PrintWriter(stringWriter)) 
		{
			xmlParsingError.printStackTrace(printWriter);
			String stackTraceString = stringWriter.toString();
			return stackTraceString;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
