package de.fraunhofer.fokus.fuzzing.fuzzino;

import java.util.HashMap;
import java.util.Map;


public class RequestProcessorRegistry {

	public static RequestProcessorRegistry INSTANCE = new RequestProcessorRegistry();
	
	//TODO: is it ok, to use name as identifier?
	protected Map<String, RequestProcessor<?>> requestProcessors;

	private RequestProcessorRegistry() {
		requestProcessors = new HashMap<>();
	}
	
	public void add(RequestProcessor<?> reqProc) {
		requestProcessors.put(reqProc.getId().toString(), reqProc);
	}
	
	public RequestProcessor<?> get(String id) {
		return requestProcessors.get(id);
	}

}
