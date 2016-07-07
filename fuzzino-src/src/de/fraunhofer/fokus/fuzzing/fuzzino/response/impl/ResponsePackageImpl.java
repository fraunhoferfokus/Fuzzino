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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.AllGeneratorsBasedPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.AllOperatorsBasedPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.CloseRequestConfirmation;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.CollectionResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ErrorResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.FuzzedStructure;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.GeneratorPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalOperator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NoMoreValuesIndicator;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.NumberResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.OperatorPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Response;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StringResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.StructureResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.Value;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsPart;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.XmlResponseDocument;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResponsePackageImpl extends EPackageImpl implements ResponsePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allGeneratorsBasedPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allOperatorsBasedPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass closeRequestConfirmationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fuzzedCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fuzzedStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generatorPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass illegalGeneratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass illegalOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass illegalRequestFormatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass noMoreValuesIndicatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass responseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass warningsPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlResponseDocumentEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.response.ResponsePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ResponsePackageImpl() {
		super(eNS_URI, ResponseFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ResponsePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ResponsePackage init() {
		if (isInited) return (ResponsePackage)EPackage.Registry.INSTANCE.getEPackage(ResponsePackage.eNS_URI);

		// Obtain or create and register package
		ResponsePackageImpl theResponsePackage = (ResponsePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ResponsePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ResponsePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theResponsePackage.createPackageContents();

		// Initialize created meta-data
		theResponsePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theResponsePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ResponsePackage.eNS_URI, theResponsePackage);
		return theResponsePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllGeneratorsBasedPart() {
		return allGeneratorsBasedPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAllGeneratorsBasedPart_GeneratorParts() {
		return (EReference)allGeneratorsBasedPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllOperatorsBasedPart() {
		return allOperatorsBasedPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAllOperatorsBasedPart_OperatorParts() {
		return (EReference)allOperatorsBasedPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloseRequestConfirmation() {
		return closeRequestConfirmationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloseRequestConfirmation_Warnings() {
		return (EReference)closeRequestConfirmationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloseRequestConfirmation_Id() {
		return (EAttribute)closeRequestConfirmationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloseRequestConfirmation_Name() {
		return (EAttribute)closeRequestConfirmationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionResponse() {
		return collectionResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionResponse_FuzzedCollections() {
		return (EReference)collectionResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionResponse_Warnings() {
		return (EReference)collectionResponseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionResponse_Id() {
		return (EAttribute)collectionResponseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionResponse_MoreValues() {
		return (EAttribute)collectionResponseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionResponse_Name() {
		return (EAttribute)collectionResponseEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionResponse_Seed() {
		return (EAttribute)collectionResponseEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorResponse() {
		return errorResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorResponse_Value() {
		return (EAttribute)errorResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorResponse_Column() {
		return (EAttribute)errorResponseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorResponse_Line() {
		return (EAttribute)errorResponseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getField() {
		return fieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getField_Fuzz() {
		return (EAttribute)fieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getField_Ref() {
		return (EAttribute)fieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFuzzedCollection() {
		return fuzzedCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuzzedCollection_Values() {
		return (EReference)fuzzedCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuzzedCollection_BasedOn() {
		return (EAttribute)fuzzedCollectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuzzedCollection_Mutations() {
		return (EAttribute)fuzzedCollectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuzzedCollection_Operators() {
		return (EAttribute)fuzzedCollectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFuzzedStructure() {
		return fuzzedStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuzzedStructure_Fields() {
		return (EReference)fuzzedStructureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuzzedStructure_Mutations() {
		return (EAttribute)fuzzedStructureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuzzedStructure_Operators() {
		return (EAttribute)fuzzedStructureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneratorPart() {
		return generatorPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratorPart_FuzzedValues() {
		return (EAttribute)generatorPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratorPart_Name() {
		return (EAttribute)generatorPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIllegalGenerator() {
		return illegalGeneratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIllegalGenerator_Value() {
		return (EAttribute)illegalGeneratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIllegalGenerator_Reason() {
		return (EAttribute)illegalGeneratorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIllegalOperator() {
		return illegalOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIllegalOperator_Value() {
		return (EAttribute)illegalOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIllegalOperator_Reason() {
		return (EAttribute)illegalOperatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIllegalRequestFormat() {
		return illegalRequestFormatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIllegalRequestFormat_Attribute() {
		return (EAttribute)illegalRequestFormatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIllegalRequestFormat_Element() {
		return (EAttribute)illegalRequestFormatEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIllegalRequestFormat_MissingAttribute() {
		return (EAttribute)illegalRequestFormatEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIllegalRequestFormat_MissingElement() {
		return (EAttribute)illegalRequestFormatEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNoMoreValuesIndicator() {
		return noMoreValuesIndicatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberResponse() {
		return numberResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumberResponse_GeneratorBasedPart() {
		return (EReference)numberResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumberResponse_OperatorBasedPart() {
		return (EReference)numberResponseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumberResponse_Warnings() {
		return (EReference)numberResponseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumberResponse_Id() {
		return (EAttribute)numberResponseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumberResponse_MoreValues() {
		return (EAttribute)numberResponseEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumberResponse_Name() {
		return (EAttribute)numberResponseEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumberResponse_Seed() {
		return (EAttribute)numberResponseEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatorPart() {
		return operatorPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatorPart_FuzzedValues() {
		return (EAttribute)operatorPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatorPart_BasedOn() {
		return (EAttribute)operatorPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatorPart_Name() {
		return (EAttribute)operatorPartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResponse() {
		return responseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponse_StringResponses() {
		return (EReference)responseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponse_NumberResponses() {
		return (EReference)responseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponse_StructureResponses() {
		return (EReference)responseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponse_CollectionResponses() {
		return (EReference)responseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponse_CloseRequestConfirmations() {
		return (EReference)responseEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponse_ErrorResponse() {
		return (EReference)responseEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringResponse() {
		return stringResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringResponse_GeneratorBasedPart() {
		return (EReference)stringResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringResponse_OperatorBasedPart() {
		return (EReference)stringResponseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringResponse_Warnings() {
		return (EReference)stringResponseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringResponse_Id() {
		return (EAttribute)stringResponseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringResponse_MoreValues() {
		return (EAttribute)stringResponseEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringResponse_Name() {
		return (EAttribute)stringResponseEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringResponse_Seed() {
		return (EAttribute)stringResponseEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructureResponse() {
		return structureResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureResponse_FuzzedStructures() {
		return (EReference)structureResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureResponse_Warnings() {
		return (EReference)structureResponseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureResponse_Id() {
		return (EAttribute)structureResponseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureResponse_MoreValues() {
		return (EAttribute)structureResponseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureResponse_Name() {
		return (EAttribute)structureResponseEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureResponse_Seed() {
		return (EAttribute)structureResponseEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValue() {
		return valueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValue_Value() {
		return (EAttribute)valueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValue_BasedOn() {
		return (EAttribute)valueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValue_Generator() {
		return (EAttribute)valueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValue_Operator() {
		return (EAttribute)valueEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWarningsPart() {
		return warningsPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWarningsPart_IllegalGenerators() {
		return (EReference)warningsPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWarningsPart_IllegalOperators() {
		return (EReference)warningsPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWarningsPart_IllegalRequestFormats() {
		return (EReference)warningsPartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWarningsPart_FlagNoMoreValues() {
		return (EReference)warningsPartEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXmlResponseDocument() {
		return xmlResponseDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXmlResponseDocument_Mixed() {
		return (EAttribute)xmlResponseDocumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXmlResponseDocument_XMLNSPrefixMap() {
		return (EReference)xmlResponseDocumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXmlResponseDocument_XSISchemaLocation() {
		return (EReference)xmlResponseDocumentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXmlResponseDocument_Response() {
		return (EReference)xmlResponseDocumentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponseFactory getResponseFactory() {
		return (ResponseFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		allGeneratorsBasedPartEClass = createEClass(ALL_GENERATORS_BASED_PART);
		createEReference(allGeneratorsBasedPartEClass, ALL_GENERATORS_BASED_PART__GENERATOR_PARTS);

		allOperatorsBasedPartEClass = createEClass(ALL_OPERATORS_BASED_PART);
		createEReference(allOperatorsBasedPartEClass, ALL_OPERATORS_BASED_PART__OPERATOR_PARTS);

		closeRequestConfirmationEClass = createEClass(CLOSE_REQUEST_CONFIRMATION);
		createEReference(closeRequestConfirmationEClass, CLOSE_REQUEST_CONFIRMATION__WARNINGS);
		createEAttribute(closeRequestConfirmationEClass, CLOSE_REQUEST_CONFIRMATION__ID);
		createEAttribute(closeRequestConfirmationEClass, CLOSE_REQUEST_CONFIRMATION__NAME);

		collectionResponseEClass = createEClass(COLLECTION_RESPONSE);
		createEReference(collectionResponseEClass, COLLECTION_RESPONSE__FUZZED_COLLECTIONS);
		createEReference(collectionResponseEClass, COLLECTION_RESPONSE__WARNINGS);
		createEAttribute(collectionResponseEClass, COLLECTION_RESPONSE__ID);
		createEAttribute(collectionResponseEClass, COLLECTION_RESPONSE__MORE_VALUES);
		createEAttribute(collectionResponseEClass, COLLECTION_RESPONSE__NAME);
		createEAttribute(collectionResponseEClass, COLLECTION_RESPONSE__SEED);

		errorResponseEClass = createEClass(ERROR_RESPONSE);
		createEAttribute(errorResponseEClass, ERROR_RESPONSE__VALUE);
		createEAttribute(errorResponseEClass, ERROR_RESPONSE__COLUMN);
		createEAttribute(errorResponseEClass, ERROR_RESPONSE__LINE);

		fieldEClass = createEClass(FIELD);
		createEAttribute(fieldEClass, FIELD__FUZZ);
		createEAttribute(fieldEClass, FIELD__REF);

		fuzzedCollectionEClass = createEClass(FUZZED_COLLECTION);
		createEReference(fuzzedCollectionEClass, FUZZED_COLLECTION__VALUES);
		createEAttribute(fuzzedCollectionEClass, FUZZED_COLLECTION__BASED_ON);
		createEAttribute(fuzzedCollectionEClass, FUZZED_COLLECTION__MUTATIONS);
		createEAttribute(fuzzedCollectionEClass, FUZZED_COLLECTION__OPERATORS);

		fuzzedStructureEClass = createEClass(FUZZED_STRUCTURE);
		createEReference(fuzzedStructureEClass, FUZZED_STRUCTURE__FIELDS);
		createEAttribute(fuzzedStructureEClass, FUZZED_STRUCTURE__MUTATIONS);
		createEAttribute(fuzzedStructureEClass, FUZZED_STRUCTURE__OPERATORS);

		generatorPartEClass = createEClass(GENERATOR_PART);
		createEAttribute(generatorPartEClass, GENERATOR_PART__FUZZED_VALUES);
		createEAttribute(generatorPartEClass, GENERATOR_PART__NAME);

		illegalGeneratorEClass = createEClass(ILLEGAL_GENERATOR);
		createEAttribute(illegalGeneratorEClass, ILLEGAL_GENERATOR__VALUE);
		createEAttribute(illegalGeneratorEClass, ILLEGAL_GENERATOR__REASON);

		illegalOperatorEClass = createEClass(ILLEGAL_OPERATOR);
		createEAttribute(illegalOperatorEClass, ILLEGAL_OPERATOR__VALUE);
		createEAttribute(illegalOperatorEClass, ILLEGAL_OPERATOR__REASON);

		illegalRequestFormatEClass = createEClass(ILLEGAL_REQUEST_FORMAT);
		createEAttribute(illegalRequestFormatEClass, ILLEGAL_REQUEST_FORMAT__ATTRIBUTE);
		createEAttribute(illegalRequestFormatEClass, ILLEGAL_REQUEST_FORMAT__ELEMENT);
		createEAttribute(illegalRequestFormatEClass, ILLEGAL_REQUEST_FORMAT__MISSING_ATTRIBUTE);
		createEAttribute(illegalRequestFormatEClass, ILLEGAL_REQUEST_FORMAT__MISSING_ELEMENT);

		noMoreValuesIndicatorEClass = createEClass(NO_MORE_VALUES_INDICATOR);

		numberResponseEClass = createEClass(NUMBER_RESPONSE);
		createEReference(numberResponseEClass, NUMBER_RESPONSE__GENERATOR_BASED_PART);
		createEReference(numberResponseEClass, NUMBER_RESPONSE__OPERATOR_BASED_PART);
		createEReference(numberResponseEClass, NUMBER_RESPONSE__WARNINGS);
		createEAttribute(numberResponseEClass, NUMBER_RESPONSE__ID);
		createEAttribute(numberResponseEClass, NUMBER_RESPONSE__MORE_VALUES);
		createEAttribute(numberResponseEClass, NUMBER_RESPONSE__NAME);
		createEAttribute(numberResponseEClass, NUMBER_RESPONSE__SEED);

		operatorPartEClass = createEClass(OPERATOR_PART);
		createEAttribute(operatorPartEClass, OPERATOR_PART__FUZZED_VALUES);
		createEAttribute(operatorPartEClass, OPERATOR_PART__BASED_ON);
		createEAttribute(operatorPartEClass, OPERATOR_PART__NAME);

		responseEClass = createEClass(RESPONSE);
		createEReference(responseEClass, RESPONSE__STRING_RESPONSES);
		createEReference(responseEClass, RESPONSE__NUMBER_RESPONSES);
		createEReference(responseEClass, RESPONSE__STRUCTURE_RESPONSES);
		createEReference(responseEClass, RESPONSE__COLLECTION_RESPONSES);
		createEReference(responseEClass, RESPONSE__CLOSE_REQUEST_CONFIRMATIONS);
		createEReference(responseEClass, RESPONSE__ERROR_RESPONSE);

		stringResponseEClass = createEClass(STRING_RESPONSE);
		createEReference(stringResponseEClass, STRING_RESPONSE__GENERATOR_BASED_PART);
		createEReference(stringResponseEClass, STRING_RESPONSE__OPERATOR_BASED_PART);
		createEReference(stringResponseEClass, STRING_RESPONSE__WARNINGS);
		createEAttribute(stringResponseEClass, STRING_RESPONSE__ID);
		createEAttribute(stringResponseEClass, STRING_RESPONSE__MORE_VALUES);
		createEAttribute(stringResponseEClass, STRING_RESPONSE__NAME);
		createEAttribute(stringResponseEClass, STRING_RESPONSE__SEED);

		structureResponseEClass = createEClass(STRUCTURE_RESPONSE);
		createEReference(structureResponseEClass, STRUCTURE_RESPONSE__FUZZED_STRUCTURES);
		createEReference(structureResponseEClass, STRUCTURE_RESPONSE__WARNINGS);
		createEAttribute(structureResponseEClass, STRUCTURE_RESPONSE__ID);
		createEAttribute(structureResponseEClass, STRUCTURE_RESPONSE__MORE_VALUES);
		createEAttribute(structureResponseEClass, STRUCTURE_RESPONSE__NAME);
		createEAttribute(structureResponseEClass, STRUCTURE_RESPONSE__SEED);

		valueEClass = createEClass(VALUE);
		createEAttribute(valueEClass, VALUE__VALUE);
		createEAttribute(valueEClass, VALUE__BASED_ON);
		createEAttribute(valueEClass, VALUE__GENERATOR);
		createEAttribute(valueEClass, VALUE__OPERATOR);

		warningsPartEClass = createEClass(WARNINGS_PART);
		createEReference(warningsPartEClass, WARNINGS_PART__ILLEGAL_GENERATORS);
		createEReference(warningsPartEClass, WARNINGS_PART__ILLEGAL_OPERATORS);
		createEReference(warningsPartEClass, WARNINGS_PART__ILLEGAL_REQUEST_FORMATS);
		createEReference(warningsPartEClass, WARNINGS_PART__FLAG_NO_MORE_VALUES);

		xmlResponseDocumentEClass = createEClass(XML_RESPONSE_DOCUMENT);
		createEAttribute(xmlResponseDocumentEClass, XML_RESPONSE_DOCUMENT__MIXED);
		createEReference(xmlResponseDocumentEClass, XML_RESPONSE_DOCUMENT__XMLNS_PREFIX_MAP);
		createEReference(xmlResponseDocumentEClass, XML_RESPONSE_DOCUMENT__XSI_SCHEMA_LOCATION);
		createEReference(xmlResponseDocumentEClass, XML_RESPONSE_DOCUMENT__RESPONSE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(allGeneratorsBasedPartEClass, AllGeneratorsBasedPart.class, "AllGeneratorsBasedPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAllGeneratorsBasedPart_GeneratorParts(), this.getGeneratorPart(), null, "generatorParts", null, 1, -1, AllGeneratorsBasedPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(allOperatorsBasedPartEClass, AllOperatorsBasedPart.class, "AllOperatorsBasedPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAllOperatorsBasedPart_OperatorParts(), this.getOperatorPart(), null, "operatorParts", null, 1, -1, AllOperatorsBasedPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(closeRequestConfirmationEClass, CloseRequestConfirmation.class, "CloseRequestConfirmation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCloseRequestConfirmation_Warnings(), this.getWarningsPart(), null, "warnings", null, 0, 1, CloseRequestConfirmation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCloseRequestConfirmation_Id(), theXMLTypePackage.getNCName(), "id", null, 1, 1, CloseRequestConfirmation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCloseRequestConfirmation_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, CloseRequestConfirmation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionResponseEClass, CollectionResponse.class, "CollectionResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionResponse_FuzzedCollections(), this.getFuzzedCollection(), null, "fuzzedCollections", null, 1, -1, CollectionResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionResponse_Warnings(), this.getWarningsPart(), null, "warnings", null, 0, 1, CollectionResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionResponse_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, CollectionResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionResponse_MoreValues(), theXMLTypePackage.getBoolean(), "moreValues", null, 1, 1, CollectionResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionResponse_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, CollectionResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionResponse_Seed(), theXMLTypePackage.getString(), "seed", null, 0, 1, CollectionResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorResponseEClass, ErrorResponse.class, "ErrorResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getErrorResponse_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, ErrorResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorResponse_Column(), theXMLTypePackage.getInt(), "column", null, 1, 1, ErrorResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorResponse_Line(), theXMLTypePackage.getInt(), "line", null, 1, 1, ErrorResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fieldEClass, Field.class, "Field", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getField_Fuzz(), theXMLTypePackage.getBoolean(), "fuzz", null, 0, 1, Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getField_Ref(), theXMLTypePackage.getNCName(), "ref", null, 1, 1, Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fuzzedCollectionEClass, FuzzedCollection.class, "FuzzedCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFuzzedCollection_Values(), this.getValue(), null, "values", null, 0, -1, FuzzedCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuzzedCollection_BasedOn(), theXMLTypePackage.getString(), "basedOn", null, 1, 1, FuzzedCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuzzedCollection_Mutations(), theXMLTypePackage.getInt(), "mutations", null, 1, 1, FuzzedCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuzzedCollection_Operators(), theXMLTypePackage.getNCName(), "operators", null, 1, 1, FuzzedCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fuzzedStructureEClass, FuzzedStructure.class, "FuzzedStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFuzzedStructure_Fields(), this.getField(), null, "fields", null, 0, -1, FuzzedStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuzzedStructure_Mutations(), theXMLTypePackage.getInt(), "mutations", null, 1, 1, FuzzedStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuzzedStructure_Operators(), theXMLTypePackage.getAnySimpleType(), "operators", null, 1, 1, FuzzedStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(generatorPartEClass, GeneratorPart.class, "GeneratorPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGeneratorPart_FuzzedValues(), theXMLTypePackage.getString(), "fuzzedValues", null, 1, -1, GeneratorPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratorPart_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, GeneratorPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(illegalGeneratorEClass, IllegalGenerator.class, "IllegalGenerator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIllegalGenerator_Value(), theXMLTypePackage.getNCName(), "value", null, 0, 1, IllegalGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIllegalGenerator_Reason(), theXMLTypePackage.getNCName(), "reason", null, 1, 1, IllegalGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(illegalOperatorEClass, IllegalOperator.class, "IllegalOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIllegalOperator_Value(), theXMLTypePackage.getNCName(), "value", null, 0, 1, IllegalOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIllegalOperator_Reason(), theXMLTypePackage.getNCName(), "reason", null, 1, 1, IllegalOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(illegalRequestFormatEClass, IllegalRequestFormat.class, "IllegalRequestFormat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIllegalRequestFormat_Attribute(), theXMLTypePackage.getNCName(), "attribute", null, 0, 1, IllegalRequestFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIllegalRequestFormat_Element(), theXMLTypePackage.getNCName(), "element", null, 0, 1, IllegalRequestFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIllegalRequestFormat_MissingAttribute(), theXMLTypePackage.getNCName(), "missingAttribute", null, 0, 1, IllegalRequestFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIllegalRequestFormat_MissingElement(), theXMLTypePackage.getNCName(), "missingElement", null, 0, 1, IllegalRequestFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(noMoreValuesIndicatorEClass, NoMoreValuesIndicator.class, "NoMoreValuesIndicator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(numberResponseEClass, NumberResponse.class, "NumberResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNumberResponse_GeneratorBasedPart(), this.getAllGeneratorsBasedPart(), null, "generatorBasedPart", null, 0, 1, NumberResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNumberResponse_OperatorBasedPart(), this.getAllOperatorsBasedPart(), null, "operatorBasedPart", null, 0, 1, NumberResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNumberResponse_Warnings(), this.getWarningsPart(), null, "warnings", null, 0, 1, NumberResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumberResponse_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, NumberResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumberResponse_MoreValues(), theXMLTypePackage.getBoolean(), "moreValues", null, 1, 1, NumberResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumberResponse_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, NumberResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumberResponse_Seed(), theXMLTypePackage.getString(), "seed", null, 0, 1, NumberResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operatorPartEClass, OperatorPart.class, "OperatorPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperatorPart_FuzzedValues(), theXMLTypePackage.getString(), "fuzzedValues", null, 1, -1, OperatorPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperatorPart_BasedOn(), theXMLTypePackage.getNCName(), "basedOn", null, 0, 1, OperatorPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperatorPart_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, OperatorPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(responseEClass, Response.class, "Response", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResponse_StringResponses(), this.getStringResponse(), null, "stringResponses", null, 0, -1, Response.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponse_NumberResponses(), this.getNumberResponse(), null, "numberResponses", null, 0, -1, Response.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponse_StructureResponses(), this.getStructureResponse(), null, "structureResponses", null, 0, -1, Response.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponse_CollectionResponses(), this.getCollectionResponse(), null, "collectionResponses", null, 0, -1, Response.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponse_CloseRequestConfirmations(), this.getCloseRequestConfirmation(), null, "closeRequestConfirmations", null, 0, -1, Response.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponse_ErrorResponse(), this.getErrorResponse(), null, "errorResponse", null, 0, 1, Response.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringResponseEClass, StringResponse.class, "StringResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStringResponse_GeneratorBasedPart(), this.getAllGeneratorsBasedPart(), null, "generatorBasedPart", null, 0, 1, StringResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStringResponse_OperatorBasedPart(), this.getAllOperatorsBasedPart(), null, "operatorBasedPart", null, 0, 1, StringResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStringResponse_Warnings(), this.getWarningsPart(), null, "warnings", null, 0, 1, StringResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringResponse_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, StringResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringResponse_MoreValues(), theXMLTypePackage.getBoolean(), "moreValues", null, 1, 1, StringResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringResponse_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, StringResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringResponse_Seed(), theXMLTypePackage.getString(), "seed", null, 0, 1, StringResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structureResponseEClass, StructureResponse.class, "StructureResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructureResponse_FuzzedStructures(), this.getFuzzedStructure(), null, "fuzzedStructures", null, 1, -1, StructureResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureResponse_Warnings(), this.getWarningsPart(), null, "warnings", null, 0, 1, StructureResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructureResponse_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, StructureResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructureResponse_MoreValues(), theXMLTypePackage.getBoolean(), "moreValues", null, 1, 1, StructureResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructureResponse_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, StructureResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructureResponse_Seed(), theXMLTypePackage.getString(), "seed", null, 0, 1, StructureResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueEClass, Value.class, "Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValue_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValue_BasedOn(), theXMLTypePackage.getNCName(), "basedOn", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValue_Generator(), theXMLTypePackage.getNCName(), "generator", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValue_Operator(), theXMLTypePackage.getNCName(), "operator", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(warningsPartEClass, WarningsPart.class, "WarningsPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWarningsPart_IllegalGenerators(), this.getIllegalGenerator(), null, "illegalGenerators", null, 0, -1, WarningsPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWarningsPart_IllegalOperators(), this.getIllegalOperator(), null, "illegalOperators", null, 0, -1, WarningsPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWarningsPart_IllegalRequestFormats(), this.getIllegalRequestFormat(), null, "illegalRequestFormats", null, 0, -1, WarningsPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWarningsPart_FlagNoMoreValues(), this.getNoMoreValuesIndicator(), null, "flagNoMoreValues", null, 0, 1, WarningsPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xmlResponseDocumentEClass, XmlResponseDocument.class, "XmlResponseDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXmlResponseDocument_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXmlResponseDocument_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXmlResponseDocument_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXmlResponseDocument_Response(), this.getResponse(), null, "response", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (allGeneratorsBasedPartEClass, 
		   source, 
		   new String[] {
			 "name", "generatorBased_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAllGeneratorsBasedPart_GeneratorParts(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "generator",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (allOperatorsBasedPartEClass, 
		   source, 
		   new String[] {
			 "name", "operatorBased_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAllOperatorsBasedPart_OperatorParts(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "operator",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (closeRequestConfirmationEClass, 
		   source, 
		   new String[] {
			 "name", "closeRequestDone_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCloseRequestConfirmation_Warnings(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "warnings",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getCloseRequestConfirmation_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });		
		addAnnotation
		  (getCloseRequestConfirmation_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (collectionResponseEClass, 
		   source, 
		   new String[] {
			 "name", "collection_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCollectionResponse_FuzzedCollections(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "fuzzedCollection",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getCollectionResponse_Warnings(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "warnings",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getCollectionResponse_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });		
		addAnnotation
		  (getCollectionResponse_MoreValues(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "moreValues"
		   });		
		addAnnotation
		  (getCollectionResponse_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getCollectionResponse_Seed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "seed"
		   });		
		addAnnotation
		  (errorResponseEClass, 
		   source, 
		   new String[] {
			 "name", "error_._type",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getErrorResponse_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getErrorResponse_Column(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "column"
		   });		
		addAnnotation
		  (getErrorResponse_Line(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "line"
		   });		
		addAnnotation
		  (fieldEClass, 
		   source, 
		   new String[] {
			 "name", "field_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getField_Fuzz(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "fuzz"
		   });		
		addAnnotation
		  (getField_Ref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ref"
		   });		
		addAnnotation
		  (fuzzedCollectionEClass, 
		   source, 
		   new String[] {
			 "name", "fuzzedCollection_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getFuzzedCollection_Values(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "value",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getFuzzedCollection_BasedOn(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "basedOn"
		   });		
		addAnnotation
		  (getFuzzedCollection_Mutations(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "mutations"
		   });		
		addAnnotation
		  (getFuzzedCollection_Operators(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operators"
		   });		
		addAnnotation
		  (fuzzedStructureEClass, 
		   source, 
		   new String[] {
			 "name", "fuzzedStructure_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getFuzzedStructure_Fields(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "field",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getFuzzedStructure_Mutations(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "mutations"
		   });		
		addAnnotation
		  (getFuzzedStructure_Operators(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operators"
		   });		
		addAnnotation
		  (generatorPartEClass, 
		   source, 
		   new String[] {
			 "name", "generator_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getGeneratorPart_FuzzedValues(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "fuzzedValue",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getGeneratorPart_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (illegalGeneratorEClass, 
		   source, 
		   new String[] {
			 "name", "illegalGenerator_._type",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getIllegalGenerator_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getIllegalGenerator_Reason(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "reason"
		   });		
		addAnnotation
		  (illegalOperatorEClass, 
		   source, 
		   new String[] {
			 "name", "illegalOperator_._type",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getIllegalOperator_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getIllegalOperator_Reason(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "reason"
		   });		
		addAnnotation
		  (illegalRequestFormatEClass, 
		   source, 
		   new String[] {
			 "name", "illegalRequestFormat_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getIllegalRequestFormat_Attribute(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "attribute"
		   });		
		addAnnotation
		  (getIllegalRequestFormat_Element(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "element"
		   });		
		addAnnotation
		  (getIllegalRequestFormat_MissingAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "missingAttribute"
		   });		
		addAnnotation
		  (getIllegalRequestFormat_MissingElement(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "missingElement"
		   });		
		addAnnotation
		  (noMoreValuesIndicatorEClass, 
		   source, 
		   new String[] {
			 "name", "noMoreValuesAvailable_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (numberResponseEClass, 
		   source, 
		   new String[] {
			 "name", "number_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getNumberResponse_GeneratorBasedPart(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "generatorBased",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getNumberResponse_OperatorBasedPart(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "operatorBased",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getNumberResponse_Warnings(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "warnings",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getNumberResponse_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });		
		addAnnotation
		  (getNumberResponse_MoreValues(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "moreValues"
		   });		
		addAnnotation
		  (getNumberResponse_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getNumberResponse_Seed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "seed"
		   });		
		addAnnotation
		  (operatorPartEClass, 
		   source, 
		   new String[] {
			 "name", "operator_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getOperatorPart_FuzzedValues(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "fuzzedValue",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getOperatorPart_BasedOn(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "basedOn"
		   });		
		addAnnotation
		  (getOperatorPart_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (responseEClass, 
		   source, 
		   new String[] {
			 "name", "response_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getResponse_StringResponses(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "string",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getResponse_NumberResponses(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "number",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getResponse_StructureResponses(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "structure",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getResponse_CollectionResponses(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "collection",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getResponse_CloseRequestConfirmations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "closeRequestDone",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getResponse_ErrorResponse(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "error",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (stringResponseEClass, 
		   source, 
		   new String[] {
			 "name", "string_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getStringResponse_GeneratorBasedPart(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "generatorBased",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getStringResponse_OperatorBasedPart(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "operatorBased",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getStringResponse_Warnings(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "warnings",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getStringResponse_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });		
		addAnnotation
		  (getStringResponse_MoreValues(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "moreValues"
		   });		
		addAnnotation
		  (getStringResponse_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getStringResponse_Seed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "seed"
		   });		
		addAnnotation
		  (structureResponseEClass, 
		   source, 
		   new String[] {
			 "name", "structure_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getStructureResponse_FuzzedStructures(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "fuzzedStructure",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getStructureResponse_Warnings(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "warnings",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getStructureResponse_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });		
		addAnnotation
		  (getStructureResponse_MoreValues(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "moreValues"
		   });		
		addAnnotation
		  (getStructureResponse_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getStructureResponse_Seed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "seed"
		   });		
		addAnnotation
		  (valueEClass, 
		   source, 
		   new String[] {
			 "name", "value_._type",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getValue_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getValue_BasedOn(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "basedOn"
		   });		
		addAnnotation
		  (getValue_Generator(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "generator"
		   });		
		addAnnotation
		  (getValue_Operator(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operator"
		   });		
		addAnnotation
		  (warningsPartEClass, 
		   source, 
		   new String[] {
			 "name", "warnings_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getWarningsPart_IllegalGenerators(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "illegalGenerator",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getWarningsPart_IllegalOperators(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "illegalOperator",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getWarningsPart_IllegalRequestFormats(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "illegalRequestFormat",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getWarningsPart_FlagNoMoreValues(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "noMoreValuesAvailable",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (xmlResponseDocumentEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getXmlResponseDocument_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getXmlResponseDocument_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getXmlResponseDocument_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getXmlResponseDocument_Response(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "response",
			 "namespace", "##targetNamespace"
		   });
	}

} //ResponsePackageImpl
