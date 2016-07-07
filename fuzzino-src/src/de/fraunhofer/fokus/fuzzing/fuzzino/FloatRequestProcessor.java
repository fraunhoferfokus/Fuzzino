//   Copyright 2012-2013 Fraunhofer FOKUS
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
package de.fraunhofer.fokus.fuzzing.fuzzino;

import java.util.List;
import java.util.UUID;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number.BadFloatGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.Generator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.NumberSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.NumberResponseImpl;

public class FloatRequestProcessor extends NumberRequestProcessor<Double> {

	private static final String FLOAT_EXTENSION = ".floatProcessor";
	
	public FloatRequestProcessor(NumberRequest numberRequest, UUID uuid) {
		super(numberRequest, uuid);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public NumberResponse<Double> getResponse() {
		if (response == null) {
			response = new NumberResponseImpl<Double>();
			buildResponse();
		}
		return response;
	}

	@Override
	protected void deleteResponse() {
		response = null;
	}

	@Override
	protected void addRequestedGenerators() {
		//TODO: if there are more generators or operators: this needs to be adapted!
		List<Generator> allRequestedGenerators = request.getRequestedGenerators();
		if(allRequestedGenerators.isEmpty()){
			heuristics.add(new BadFloatGenerator( (NumberSpecification<Double>) request.getNumberSpecification(), seed));
		} else{
			for (Generator requestedGenerator : allRequestedGenerators) {
				if(requestedGenerator.getGeneratorName().trim().toUpperCase().equals("BadFloat".trim().toUpperCase())){
					heuristics.add(new BadFloatGenerator((NumberSpecification<Double>) request.getNumberSpecification(), seed));
				} else{
					IllegalGenerator illegalGenerator = ResponseFactory.INSTANCE.createIllegalGenerator(requestedGenerator.getGeneratorName(), "unknown generator");
					getWarningsPart().getIllegalGenerators().add(illegalGenerator);
				}
			}
		}
	}

	@Override
	protected void addRequestedOperators() {
		//nothing to do here - we do not have any operators for floats yet
	}

	@Override
	protected String getFileExtension() {
		return FLOAT_EXTENSION;
	}

}
