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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import de.fraunhofer.fokus.fuzzing.fuzzino.LibraryType;
import de.fraunhofer.fokus.fuzzing.fuzzino.RequestProcessorRegistry;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CommonRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringType;
import de.fraunhofer.fokus.fuzzing.fuzzino.structure.Structure;

/***
 * Class responsible to do the type-handling of Requests. Two requests have the same type if they are either
 * 		+equal (same request object)
 * 		+of LibraryType Number
 * 		+of LibraryType String and have the same StringType(in the stringSpecification)
 * 
 * The types of Requests are of interest in certain Operators for structures (for example if you want to swap fields with a different type)
 * 
 * @author Leon Bornemann (leon.bornemann@fokus.fraunhofer.de ) 
 *
 */
public class TypeHandler {
	
	public static final TypeHandler INSTANCE = new TypeHandler();
	
	private TypeHandler(){
		
	}

	/***
	 * Main Method of this helper-Class.
	 * @param structure
	 * @return a List of Index-Groups. All indices in one group are indices in the fieldList of the structure, whose corresponding requests have the same type
	 */
	public List<List<Integer>> getSameTypeIndexGroups(Structure structure) {
		List<Integer> numberTypeIndexGroup = new ArrayList<>();
		Map<StringType,List<Integer>> stringTypeIndexGropus = new HashMap<>();
		//the following map contains all types which are only ever equal if the corresponding request is the same object
		Map<String,List<Integer>> strongEqualityIndexGroups = new HashMap<>();
		for(int i=0;i<structure.getSpecification().getFields().size();i++){
			Field field = structure.getSpecification().getFields().get(i);
			CommonRequest correspondingRequest = RequestProcessorRegistry.INSTANCE.get(field.getCorrespondingRequestId()).getRequest();
			LibraryType fieldType = correspondingRequest.getLibraryType();
			switch(fieldType){
			case COLLECTION:
			case STRUCTURE:
			case GRAMMAR:
				//these requests are only then of the same type if they are the same object (identified by ID)
				if(strongEqualityIndexGroups.containsKey(field.getCorrespondingRequestId())){
					strongEqualityIndexGroups.get(field.getCorrespondingRequestId()).add(i);
				} else{
					List<Integer> newGrammarTypeIndexGroup = new ArrayList<>();
					newGrammarTypeIndexGroup.add(i);
					strongEqualityIndexGroups.put(field.getCorrespondingRequestId(), newGrammarTypeIndexGroup);
				}
				break;
			case NUMBER:
				//all numbers are of the same type
				numberTypeIndexGroup.add(i);
				break;
			case STRING:
				StringType type = ((StringRequest) correspondingRequest).getSpecification().getType();
				if(stringTypeIndexGropus.containsKey(type)){
					stringTypeIndexGropus.get(type).add(i);
				} else{
					List<Integer> newStringTypeIndexGroup = new ArrayList<>();
					newStringTypeIndexGroup.add(i);
					stringTypeIndexGropus.put(type, newStringTypeIndexGroup);
				}
				break;
			default:
				//ADD newly created types here
			}
		}
		List<List<Integer>> sameTypeIndexGroups = new ArrayList<>();
		addIfNotEmpty(sameTypeIndexGroups,numberTypeIndexGroup);
		sameTypeIndexGroups.addAll(strongEqualityIndexGroups.values());
		sameTypeIndexGroups.addAll(stringTypeIndexGropus.values());
		return sameTypeIndexGroups;
	}
	
	/***
	 * 
	 * @param sameTypeIndexGroups a List of Index Groups as returned by getSameTypeIndexGroups()
	 * @param index an Index that is present in one of the groups. Its group must have length >1
	 * @return another element !=index from the same group.
	 */
	public Integer getDifferentElementFromSameGroup(List<List<Integer>> sameTypeIndexGroups, Integer index){
		//find group index:
		int groupIndex = -1;
		for(int i=0;i<sameTypeIndexGroups.size();i++){
			if(sameTypeIndexGroups.get(i).contains(index)){
				groupIndex = i;
			}
		}
		if(groupIndex==-1 || sameTypeIndexGroups.get(groupIndex).size()==1){
			throw new NoSuchElementException("Index " + index +" was not found in any index group with a size bigger than 1");
		} else{
			//find another element
			Integer toReturn = -1;
			for(Integer e : sameTypeIndexGroups.get(groupIndex)){
				if(!e.equals(index)){
					toReturn = e;
					break;
				}
			}
			return toReturn;
		}
	}

	private void addIfNotEmpty(List<List<Integer>> sameTypeIndexGroups,List<Integer> numberTypeIndexGroup) {
		if(!numberTypeIndexGroup.isEmpty()){
			sameTypeIndexGroups.add(numberTypeIndexGroup);
		}
		
	}

}
