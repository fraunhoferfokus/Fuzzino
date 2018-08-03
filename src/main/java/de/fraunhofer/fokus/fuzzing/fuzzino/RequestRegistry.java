//   Copyright 2012-2014 Fraunhofer FOKUS
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
