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
package de.fraunhofer.fokus.fuzzing.fuzzino.response;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>All Generators Based Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.response.AllGeneratorsBasedPart#getGeneratorParts <em>Generator Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getAllGeneratorsBasedPart()
 * @model extendedMetaData="name='generatorBased_._type' kind='elementOnly'"
 * @generated
 */
public interface AllGeneratorsBasedPart extends EObject {
	/**
	 * Returns the value of the '<em><b>Generator Parts</b></em>' containment reference list.
	 * The list contents are of type {@link de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generator Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generator Parts</em>' containment reference list.
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#getAllGeneratorsBasedPart_GeneratorParts()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='generator' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<GeneratorPart> getGeneratorParts();

} // AllGeneratorsBasedPart
