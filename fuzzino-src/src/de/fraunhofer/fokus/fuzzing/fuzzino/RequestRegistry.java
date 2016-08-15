package de.fraunhofer.fokus.fuzzing.fuzzino;

import java.util.HashMap;
import java.util.Map;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.CommonRequest;

public class RequestRegistry {
	
	public static RequestRegistry INSTANCE = new RequestRegistry();
	
	protected Map<String, CommonRequest> requests;

	private RequestRegistry() {
		requests = new HashMap<>();
	}
	
	public void add(CommonRequest request) {
		requests.put(request.getName(), request);
	}
	
	public CommonRequest get(String name) {
		return requests.get(name);
	}

	public void remove(CommonRequest request) {
		//TODO: this is a bug (im pretty sure) remove requires strings!
		requests.remove(request);
	}

}
