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
package de.fraunhofer.fokus.fuzzing.fuzzino.jaxb;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.impl.CloseRequestConfirmationImpl;

public class CloseRequestConfirmationBuilder {

	public static CloseRequestConfirmation initCloseRequestConfirmation() {
		CloseRequestConfirmation conf = new CloseRequestConfirmationImpl();
		conf.setId("close request confirmation id");
		conf.setName("close request confirmation name");
		conf.setWarningsPart(StringResponseBuilder.initWarningsSection());
		return conf;
	}

}
