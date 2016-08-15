package de.fraunhofer.fokus.fuzzing.fuzzino.response.java;

import java.util.ArrayList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.AbstractResponse;

/***
 * Class necessary to include valid values into StructureResponses
 * @author Leon Bornemann (leon.bornemann@fokus.fraunhofer.de ) 
 *
 */
public class ValidValuesResponse<E> extends AbstractResponse {
	
	private List<E> validValues;

	public ValidValuesResponse(List<E> validValues) {
		super();
		this.validValues = validValues;
	}

	public ValidValuesResponse() {
		this(new ArrayList<E>());
	}

	public List<E> getValidValues() {
		return validValues;
	}

	public void setValidValues(List<E> validValues) {
		this.validValues = validValues;
	}
}
