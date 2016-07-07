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
		requestProcessors.put(reqProc.getName(), reqProc);
	}
	
	public RequestProcessor<?> get(String name) {
		return requestProcessors.get(name);
	}

	public void remove(String name) {
		requestProcessors.remove(name);
	}
}
