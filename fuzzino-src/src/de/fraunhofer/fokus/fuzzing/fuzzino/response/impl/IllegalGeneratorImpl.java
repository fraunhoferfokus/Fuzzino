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
package de.fraunhofer.fokus.fuzzing.fuzzino.response.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class IllegalGeneratorImpl extends IllegalHeuristic implements IllegalGenerator {
	
	public IllegalGeneratorImpl(){
		super();
	}
	
	public IllegalGeneratorImpl(String name, String reason){
		super(name,reason);
	}
	
	
	@Override
	public String toString() {
		return "[IllegalGenerator name:" + name + " reason:" + reason + "]";
	}

}
