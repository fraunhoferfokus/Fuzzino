package de.fraunhofer.fokus.fuzzing.fuzzino;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.StructureOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.StructureOperatorFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CommonRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.CommonResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.GrammarResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.StructureResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ValidValuesResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.EmptyResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.FieldImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl.StructureResponseImpl;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.StructureImpl;


/***
 * Class responsible to create responses for structure requests.
 * 
 * @author Leon Bornemann (leon.bornemann@fokus.fraunhofer.de ) 
 *
 */
public class StructureRequestProcessor extends RequestProcessor<Structure> { 
	private StructureResponse response;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String FILE_EXTENSION = ".structureProcessor";
	private StructureRequest request;
	

	public StructureRequestProcessor(StructureRequest request, UUID id) {
		super(request, id);
	}

	@Override
	public CommonRequest getRequest() {
		return request;
	}

	@Override
	public void setRequest(CommonRequest request)throws IllegalArgumentException {
		if (request instanceof StructureRequest) {
			this.request = (StructureRequest) request;
		} else {
			throw new IllegalArgumentException("Illegal type " +  request.getClass().getSimpleName() + ". Expected StructureRequest.");
		}
	}

	@Override
	public CommonResponse getResponse() {
		if (response == null) {
			response = new StructureResponseImpl();
			buildResponse();
		}
		return response;
	}

	@Override
	protected boolean collectFuzzedValues() {
		int i=0;
		if (iterator == null) {
			iterator = iterator();
		}

		boolean hasMoreValues = iterator.hasNext();
		
		if (hasMoreValues) {
			while(iterator.hasNext() && i <maxValues){
				FuzzedValue<Structure> fuzzedValue = iterator.next();
				response.addFuzzedStructure(fuzzedValue);
				i++;
			}
		} else{
			getWarningsPart().setMoreValues(iterator.hasNext());
		}
		return iterator.hasNext();
	}

	@Override
	protected void addRequestedGenerators() {
		//we dont do anything since generators do not make sense for structures		
	}

	@Override
	protected void addRequestedOperators() {
		//create a structure according to specification:
		Structure exampleStructure = buildStructure(request.getSpecification(),request.getSeed());
		//TODO: does this work correctly - do we really want to check this?
		if(request.fuzzStructure()){
			if(request.getRequestedOperators().isEmpty()){
				List<StructureOperator> allOperators =	StructureOperatorFactory.INSTANCE.createAll(exampleStructure, seed);
				heuristics.addAll(allOperators);
			} else{
				for(Operator op: request.getRequestedOperators()){
					StructureOperator operator;
					try {
						operator = StructureOperatorFactory.INSTANCE.create(op.getOperatorName(), op.getParameter(),exampleStructure,seed);
						heuristics.add(operator);
					} catch (UnknownFuzzingHeuristicException e) {
						IllegalOperator illegalOperator = ResponseFactory.INSTANCE.createIllegalOperator(op.getOperatorName(), "unknown operator");
						getWarningsPart().getIllegalOperators().add(illegalOperator);
					}
				}
			}
		} else{
			//structure should be kept the way it is - just use the Identity-Operator as the only operator for that
			StructureOperator operator = StructureOperatorFactory.INSTANCE.createIdentityOperator(exampleStructure,0);
			heuristics.add(operator);
		}
	}

	private Structure buildStructure(StructureSpecification specification,long seed) {
		Structure structure = new StructureImpl();
		structure.setStructureSpecification(specification);
		for(Field field: specification.getFields()){
			de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Field structureField = new FieldImpl();
			structureField.setName(field.getName());
			//TODO: what do we do here, is there really a distinction between fuzz and don't fuzz field - where do the valid values responses come into play?
			if(field.fuzz()){
				structureField.setValueIsFuzzed(true);
			} else{
				structureField.setValueIsFuzzed(false);
			}
			structureField.setCorrespondingResponseId(field.getCorrespondingRequestId());
			structure.add(structureField);
		}
		return structure;
	}

	//TODO: might still be needed (not sure), leave this method in for now
	private CommonResponse buildValidValuesResponse(CommonRequest fieldReq) {
		if(fieldReq.getLibraryType()==LibraryType.STRING){
			ValidValuesResponse<String> resp = new ValidValuesResponse<>();
			StringRequest req = (StringRequest) fieldReq;
			resp.setValidValues(req.getValidValuesSection().getValues());
			return resp;
		} else if (fieldReq.getLibraryType()==LibraryType.NUMBER){
			ValidValuesResponse<String> resp = new ValidValuesResponse<>();
			NumberRequest req = (NumberRequest) fieldReq;
			resp.setValidValues(req.getValidValuesSection().getValues());
			return resp;
		} else if(fieldReq.getLibraryType() == LibraryType.STRUCTURE){
			ValidValuesResponse<Structure> resp = new ValidValuesResponse<>();
			//TODO: is this correct?
			StructureRequest req = (StructureRequest) fieldReq;
			Structure validStructure = buildValidStructure(req);
			resp.getValidValues().add(validStructure);
			return resp;
		} else if(fieldReq.getLibraryType() == LibraryType.ENUM || fieldReq.getLibraryType() == LibraryType.BOOLEAN){
			//these responses do not contain anything since valid values are not contained in their requests
			return new EmptyResponse();
		}else{
			//we do not know what to do with other data types, leave the valid Response empty
			assert(false);
			return new ValidValuesResponse<>();
		}
	}
	
	/***
	 * This method ignores, whether the fields specify to be fuzzed or not but instead generates valid values for the structure contents only
	 * @param req
	 * @return
	 */
	private Structure buildValidStructure(StructureRequest req) {
		Structure structure = new StructureImpl();
		for(Field field: req.getSpecification().getFields()){
			de.fraunhofer.fokus.fuzzing.fuzzino.response.java.Field structureField = new FieldImpl();
			structureField.setName(field.getName());
			structureField.setValueIsFuzzed(false);
			structureField.setCorrespondingResponseId(field.getCorrespondingRequestId());
			structure.add(structureField);
		}
		return structure;
	}

	@Override
	protected String getFileExtension() {
		return FILE_EXTENSION;
	}

	@Override
	protected void deleteResponse() {
		response = null;
	}

}
