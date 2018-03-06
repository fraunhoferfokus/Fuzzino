package de.fraunhofer.fokus.fuzzing.fuzzino.exceptions;

/**
 * This exception indicates that a request processor coud not be deleted when trying to
 * perform a close request command. 
 * 
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public class DeleteRequestFailedException extends Exception {
	
	private static final long serialVersionUID = -6516365540093449516L;

	public DeleteRequestFailedException() {
		super();
	}
	
	public DeleteRequestFailedException(String message) {
		super(message);
	}

}
