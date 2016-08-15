package de.fraunhofer.fokus.fuzzing.fuzzino.request.impl;

import de.fraunhofer.fokus.fuzzing.fuzzino.LibraryType;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.AbstractRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ValidationResult;

/***
 * At the Moment this type of request is only usable in structure requests, and only if it is not supposed to be fuzzed, since no fuzzing heuristics for this request exists yet
 * @author Leon Bornemann (leon.bornemann@fokus.fraunhofer.de ) 
 *
 */
public class EnumRequestImpl extends AbstractRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public LibraryType getLibraryType() {
		return LibraryType.ENUM;
	}

	@Override
	public ValidationResult validate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

}
