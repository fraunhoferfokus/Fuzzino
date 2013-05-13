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
package de.fraunhofer.fokus.fuzzing.fuzzino.request.impl;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.CloseRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Field;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Generator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NoGenerators;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Operator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.Request;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StructureRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollections;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidValues;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.XmlRequestDocument;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RequestPackageImpl extends EPackageImpl implements RequestPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass closeRequestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionRequestEClass = null;

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
	private EClass generatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass noGeneratorsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberRequestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requestSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringRequestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureRequestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validCollectionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validValuesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlRequestDocumentEClass = null;

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
	 * @see de.fraunhofer.fokus.fuzzing.fuzzino.request.RequestPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RequestPackageImpl() {
		super(eNS_URI, RequestFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RequestPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RequestPackage init() {
		if (isInited) return (RequestPackage)EPackage.Registry.INSTANCE.getEPackage(RequestPackage.eNS_URI);

		// Obtain or create and register package
		RequestPackageImpl theRequestPackage = (RequestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RequestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RequestPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRequestPackage.createPackageContents();

		// Initialize created meta-data
		theRequestPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRequestPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RequestPackage.eNS_URI, theRequestPackage);
		return theRequestPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloseRequest() {
		return closeRequestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloseRequest_Id() {
		return (EAttribute)closeRequestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionRequest() {
		return collectionRequestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionRequest_Specification() {
		return (EReference)collectionRequestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionRequest_ValidCollections() {
		return (EReference)collectionRequestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionRequest_FuzzStructure() {
		return (EAttribute)collectionRequestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionRequest_FuzzValues() {
		return (EAttribute)collectionRequestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionRequest_Id() {
		return (EAttribute)collectionRequestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionRequest_MaxMutations() {
		return (EAttribute)collectionRequestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionRequest_MaxValues() {
		return (EAttribute)collectionRequestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionRequest_MinMutations() {
		return (EAttribute)collectionRequestEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionRequest_Name() {
		return (EAttribute)collectionRequestEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionRequest_Seed() {
		return (EAttribute)collectionRequestEClass.getEStructuralFeatures().get(9);
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
	public EClass getGenerator() {
		return generatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenerator_Value() {
		return (EAttribute)generatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenerator_Param() {
		return (EAttribute)generatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNoGenerators() {
		return noGeneratorsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberRequest() {
		return numberRequestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumberRequest_Specification() {
		return (EReference)numberRequestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumberRequest_NoGenerators() {
		return (EReference)numberRequestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumberRequest_Generators() {
		return (EReference)numberRequestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumberRequest_ValidValues() {
		return (EReference)numberRequestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumberRequest_Id() {
		return (EAttribute)numberRequestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumberRequest_MaxValues() {
		return (EAttribute)numberRequestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumberRequest_Name() {
		return (EAttribute)numberRequestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumberRequest_Seed() {
		return (EAttribute)numberRequestEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperator() {
		return operatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperator_Value() {
		return (EAttribute)operatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperator_Param() {
		return (EAttribute)operatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequest() {
		return requestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequest_StringRequests() {
		return (EReference)requestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequest_NumberRequests() {
		return (EReference)requestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequest_StructureRequests() {
		return (EReference)requestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequest_CollectionRequests() {
		return (EReference)requestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequest_CloseRequests() {
		return (EReference)requestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequestSpecification() {
		return requestSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestSpecification_Mixed() {
		return (EAttribute)requestSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequestSpecification_Field() {
		return (EReference)requestSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestSpecification_Bits() {
		return (EAttribute)requestSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestSpecification_Encoding() {
		return (EAttribute)requestSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestSpecification_MaxLength() {
		return (EAttribute)requestSpecificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestSpecification_MaxValue() {
		return (EAttribute)requestSpecificationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestSpecification_MinLength() {
		return (EAttribute)requestSpecificationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestSpecification_MinValue() {
		return (EAttribute)requestSpecificationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestSpecification_NullTerminated() {
		return (EAttribute)requestSpecificationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestSpecification_Ordered() {
		return (EAttribute)requestSpecificationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestSpecification_Ref() {
		return (EAttribute)requestSpecificationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestSpecification_Signed() {
		return (EAttribute)requestSpecificationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestSpecification_Type() {
		return (EAttribute)requestSpecificationEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestSpecification_Unique() {
		return (EAttribute)requestSpecificationEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringRequest() {
		return stringRequestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringRequest_Specification() {
		return (EReference)stringRequestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringRequest_NoGenerators() {
		return (EReference)stringRequestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringRequest_Generators() {
		return (EReference)stringRequestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringRequest_ValidValues() {
		return (EReference)stringRequestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringRequest_Id() {
		return (EAttribute)stringRequestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringRequest_MaxValues() {
		return (EAttribute)stringRequestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringRequest_Name() {
		return (EAttribute)stringRequestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringRequest_Seed() {
		return (EAttribute)stringRequestEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructureRequest() {
		return structureRequestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureRequest_Specification() {
		return (EReference)structureRequestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureRequest_Operators() {
		return (EReference)structureRequestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureRequest_FuzzStructure() {
		return (EAttribute)structureRequestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureRequest_FuzzValues() {
		return (EAttribute)structureRequestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureRequest_Id() {
		return (EAttribute)structureRequestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureRequest_MaxMutations() {
		return (EAttribute)structureRequestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureRequest_MaxValues() {
		return (EAttribute)structureRequestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureRequest_MinMutations() {
		return (EAttribute)structureRequestEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureRequest_Name() {
		return (EAttribute)structureRequestEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructureRequest_Seed() {
		return (EAttribute)structureRequestEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidCollection() {
		return validCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidCollection_Value() {
		return (EAttribute)validCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidCollection_Name() {
		return (EAttribute)validCollectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidCollections() {
		return validCollectionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidCollections_Values() {
		return (EReference)validCollectionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidCollections_Operators() {
		return (EReference)validCollectionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidValues() {
		return validValuesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidValues_Values() {
		return (EAttribute)validValuesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidValues_Operators() {
		return (EReference)validValuesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXmlRequestDocument() {
		return xmlRequestDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXmlRequestDocument_Mixed() {
		return (EAttribute)xmlRequestDocumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXmlRequestDocument_XMLNSPrefixMap() {
		return (EReference)xmlRequestDocumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXmlRequestDocument_XSISchemaLocation() {
		return (EReference)xmlRequestDocumentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXmlRequestDocument_Request() {
		return (EReference)xmlRequestDocumentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequestFactory getRequestFactory() {
		return (RequestFactory)getEFactoryInstance();
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
		closeRequestEClass = createEClass(CLOSE_REQUEST);
		createEAttribute(closeRequestEClass, CLOSE_REQUEST__ID);

		collectionRequestEClass = createEClass(COLLECTION_REQUEST);
		createEReference(collectionRequestEClass, COLLECTION_REQUEST__SPECIFICATION);
		createEReference(collectionRequestEClass, COLLECTION_REQUEST__VALID_COLLECTIONS);
		createEAttribute(collectionRequestEClass, COLLECTION_REQUEST__FUZZ_STRUCTURE);
		createEAttribute(collectionRequestEClass, COLLECTION_REQUEST__FUZZ_VALUES);
		createEAttribute(collectionRequestEClass, COLLECTION_REQUEST__ID);
		createEAttribute(collectionRequestEClass, COLLECTION_REQUEST__MAX_MUTATIONS);
		createEAttribute(collectionRequestEClass, COLLECTION_REQUEST__MAX_VALUES);
		createEAttribute(collectionRequestEClass, COLLECTION_REQUEST__MIN_MUTATIONS);
		createEAttribute(collectionRequestEClass, COLLECTION_REQUEST__NAME);
		createEAttribute(collectionRequestEClass, COLLECTION_REQUEST__SEED);

		fieldEClass = createEClass(FIELD);
		createEAttribute(fieldEClass, FIELD__FUZZ);
		createEAttribute(fieldEClass, FIELD__REF);

		generatorEClass = createEClass(GENERATOR);
		createEAttribute(generatorEClass, GENERATOR__VALUE);
		createEAttribute(generatorEClass, GENERATOR__PARAM);

		noGeneratorsEClass = createEClass(NO_GENERATORS);

		numberRequestEClass = createEClass(NUMBER_REQUEST);
		createEReference(numberRequestEClass, NUMBER_REQUEST__SPECIFICATION);
		createEReference(numberRequestEClass, NUMBER_REQUEST__NO_GENERATORS);
		createEReference(numberRequestEClass, NUMBER_REQUEST__GENERATORS);
		createEReference(numberRequestEClass, NUMBER_REQUEST__VALID_VALUES);
		createEAttribute(numberRequestEClass, NUMBER_REQUEST__ID);
		createEAttribute(numberRequestEClass, NUMBER_REQUEST__MAX_VALUES);
		createEAttribute(numberRequestEClass, NUMBER_REQUEST__NAME);
		createEAttribute(numberRequestEClass, NUMBER_REQUEST__SEED);

		operatorEClass = createEClass(OPERATOR);
		createEAttribute(operatorEClass, OPERATOR__VALUE);
		createEAttribute(operatorEClass, OPERATOR__PARAM);

		requestEClass = createEClass(REQUEST);
		createEReference(requestEClass, REQUEST__STRING_REQUESTS);
		createEReference(requestEClass, REQUEST__NUMBER_REQUESTS);
		createEReference(requestEClass, REQUEST__STRUCTURE_REQUESTS);
		createEReference(requestEClass, REQUEST__COLLECTION_REQUESTS);
		createEReference(requestEClass, REQUEST__CLOSE_REQUESTS);

		requestSpecificationEClass = createEClass(REQUEST_SPECIFICATION);
		createEAttribute(requestSpecificationEClass, REQUEST_SPECIFICATION__MIXED);
		createEReference(requestSpecificationEClass, REQUEST_SPECIFICATION__FIELD);
		createEAttribute(requestSpecificationEClass, REQUEST_SPECIFICATION__BITS);
		createEAttribute(requestSpecificationEClass, REQUEST_SPECIFICATION__ENCODING);
		createEAttribute(requestSpecificationEClass, REQUEST_SPECIFICATION__MAX_LENGTH);
		createEAttribute(requestSpecificationEClass, REQUEST_SPECIFICATION__MAX_VALUE);
		createEAttribute(requestSpecificationEClass, REQUEST_SPECIFICATION__MIN_LENGTH);
		createEAttribute(requestSpecificationEClass, REQUEST_SPECIFICATION__MIN_VALUE);
		createEAttribute(requestSpecificationEClass, REQUEST_SPECIFICATION__NULL_TERMINATED);
		createEAttribute(requestSpecificationEClass, REQUEST_SPECIFICATION__ORDERED);
		createEAttribute(requestSpecificationEClass, REQUEST_SPECIFICATION__REF);
		createEAttribute(requestSpecificationEClass, REQUEST_SPECIFICATION__SIGNED);
		createEAttribute(requestSpecificationEClass, REQUEST_SPECIFICATION__TYPE);
		createEAttribute(requestSpecificationEClass, REQUEST_SPECIFICATION__UNIQUE);

		stringRequestEClass = createEClass(STRING_REQUEST);
		createEReference(stringRequestEClass, STRING_REQUEST__SPECIFICATION);
		createEReference(stringRequestEClass, STRING_REQUEST__NO_GENERATORS);
		createEReference(stringRequestEClass, STRING_REQUEST__GENERATORS);
		createEReference(stringRequestEClass, STRING_REQUEST__VALID_VALUES);
		createEAttribute(stringRequestEClass, STRING_REQUEST__ID);
		createEAttribute(stringRequestEClass, STRING_REQUEST__MAX_VALUES);
		createEAttribute(stringRequestEClass, STRING_REQUEST__NAME);
		createEAttribute(stringRequestEClass, STRING_REQUEST__SEED);

		structureRequestEClass = createEClass(STRUCTURE_REQUEST);
		createEReference(structureRequestEClass, STRUCTURE_REQUEST__SPECIFICATION);
		createEReference(structureRequestEClass, STRUCTURE_REQUEST__OPERATORS);
		createEAttribute(structureRequestEClass, STRUCTURE_REQUEST__FUZZ_STRUCTURE);
		createEAttribute(structureRequestEClass, STRUCTURE_REQUEST__FUZZ_VALUES);
		createEAttribute(structureRequestEClass, STRUCTURE_REQUEST__ID);
		createEAttribute(structureRequestEClass, STRUCTURE_REQUEST__MAX_MUTATIONS);
		createEAttribute(structureRequestEClass, STRUCTURE_REQUEST__MAX_VALUES);
		createEAttribute(structureRequestEClass, STRUCTURE_REQUEST__MIN_MUTATIONS);
		createEAttribute(structureRequestEClass, STRUCTURE_REQUEST__NAME);
		createEAttribute(structureRequestEClass, STRUCTURE_REQUEST__SEED);

		validCollectionEClass = createEClass(VALID_COLLECTION);
		createEAttribute(validCollectionEClass, VALID_COLLECTION__VALUE);
		createEAttribute(validCollectionEClass, VALID_COLLECTION__NAME);

		validCollectionsEClass = createEClass(VALID_COLLECTIONS);
		createEReference(validCollectionsEClass, VALID_COLLECTIONS__VALUES);
		createEReference(validCollectionsEClass, VALID_COLLECTIONS__OPERATORS);

		validValuesEClass = createEClass(VALID_VALUES);
		createEAttribute(validValuesEClass, VALID_VALUES__VALUES);
		createEReference(validValuesEClass, VALID_VALUES__OPERATORS);

		xmlRequestDocumentEClass = createEClass(XML_REQUEST_DOCUMENT);
		createEAttribute(xmlRequestDocumentEClass, XML_REQUEST_DOCUMENT__MIXED);
		createEReference(xmlRequestDocumentEClass, XML_REQUEST_DOCUMENT__XMLNS_PREFIX_MAP);
		createEReference(xmlRequestDocumentEClass, XML_REQUEST_DOCUMENT__XSI_SCHEMA_LOCATION);
		createEReference(xmlRequestDocumentEClass, XML_REQUEST_DOCUMENT__REQUEST);
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
		initEClass(closeRequestEClass, CloseRequest.class, "CloseRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCloseRequest_Id(), theXMLTypePackage.getNCName(), "id", null, 1, 1, CloseRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionRequestEClass, CollectionRequest.class, "CollectionRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionRequest_Specification(), this.getRequestSpecification(), null, "specification", null, 1, 1, CollectionRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionRequest_ValidCollections(), this.getValidCollections(), null, "validCollections", null, 0, 1, CollectionRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionRequest_FuzzStructure(), theXMLTypePackage.getBoolean(), "fuzzStructure", null, 1, 1, CollectionRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionRequest_FuzzValues(), theXMLTypePackage.getBoolean(), "fuzzValues", null, 1, 1, CollectionRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionRequest_Id(), theXMLTypePackage.getNCName(), "id", null, 0, 1, CollectionRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionRequest_MaxMutations(), theXMLTypePackage.getInt(), "maxMutations", null, 1, 1, CollectionRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionRequest_MaxValues(), theXMLTypePackage.getInt(), "maxValues", null, 1, 1, CollectionRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionRequest_MinMutations(), theXMLTypePackage.getInt(), "minMutations", "1", 0, 1, CollectionRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionRequest_Name(), theXMLTypePackage.getID(), "name", null, 1, 1, CollectionRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollectionRequest_Seed(), theXMLTypePackage.getLong(), "seed", null, 0, 1, CollectionRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fieldEClass, Field.class, "Field", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getField_Fuzz(), theXMLTypePackage.getBoolean(), "fuzz", "true", 0, 1, Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getField_Ref(), theXMLTypePackage.getIDREF(), "ref", null, 1, 1, Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(generatorEClass, Generator.class, "Generator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenerator_Value(), theXMLTypePackage.getNCName(), "value", null, 0, 1, Generator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenerator_Param(), theXMLTypePackage.getString(), "param", null, 0, 1, Generator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(noGeneratorsEClass, NoGenerators.class, "NoGenerators", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(numberRequestEClass, NumberRequest.class, "NumberRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNumberRequest_Specification(), this.getRequestSpecification(), null, "specification", null, 0, 1, NumberRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNumberRequest_NoGenerators(), this.getNoGenerators(), null, "noGenerators", null, 0, 1, NumberRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNumberRequest_Generators(), this.getGenerator(), null, "generators", null, 0, -1, NumberRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNumberRequest_ValidValues(), this.getValidValues(), null, "validValues", null, 0, 1, NumberRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumberRequest_Id(), theXMLTypePackage.getNCName(), "id", null, 0, 1, NumberRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumberRequest_MaxValues(), theXMLTypePackage.getInt(), "maxValues", null, 1, 1, NumberRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumberRequest_Name(), theXMLTypePackage.getID(), "name", null, 1, 1, NumberRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumberRequest_Seed(), theXMLTypePackage.getLong(), "seed", null, 0, 1, NumberRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operatorEClass, Operator.class, "Operator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperator_Value(), theXMLTypePackage.getNCName(), "value", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperator_Param(), theXMLTypePackage.getString(), "param", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requestEClass, Request.class, "Request", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequest_StringRequests(), this.getStringRequest(), null, "stringRequests", null, 0, -1, Request.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequest_NumberRequests(), this.getNumberRequest(), null, "numberRequests", null, 0, -1, Request.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequest_StructureRequests(), this.getStructureRequest(), null, "structureRequests", null, 0, -1, Request.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequest_CollectionRequests(), this.getCollectionRequest(), null, "collectionRequests", null, 0, -1, Request.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequest_CloseRequests(), this.getCloseRequest(), null, "closeRequests", null, 0, -1, Request.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requestSpecificationEClass, RequestSpecification.class, "RequestSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRequestSpecification_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, RequestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequestSpecification_Field(), this.getField(), null, "field", null, 0, -1, RequestSpecification.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequestSpecification_Bits(), theXMLTypePackage.getInt(), "bits", "32", 0, 1, RequestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequestSpecification_Encoding(), theXMLTypePackage.getNCName(), "encoding", "ASCII", 0, 1, RequestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequestSpecification_MaxLength(), theXMLTypePackage.getInt(), "maxLength", null, 0, 1, RequestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequestSpecification_MaxValue(), theXMLTypePackage.getInteger(), "maxValue", null, 0, 1, RequestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequestSpecification_MinLength(), theXMLTypePackage.getInt(), "minLength", null, 0, 1, RequestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequestSpecification_MinValue(), theXMLTypePackage.getInteger(), "minValue", null, 0, 1, RequestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequestSpecification_NullTerminated(), theXMLTypePackage.getBoolean(), "nullTerminated", "false", 0, 1, RequestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequestSpecification_Ordered(), theXMLTypePackage.getBoolean(), "ordered", null, 0, 1, RequestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequestSpecification_Ref(), theXMLTypePackage.getIDREF(), "ref", null, 0, 1, RequestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequestSpecification_Signed(), theXMLTypePackage.getBoolean(), "signed", "true", 0, 1, RequestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequestSpecification_Type(), theXMLTypePackage.getNCName(), "type", "String", 0, 1, RequestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequestSpecification_Unique(), theXMLTypePackage.getBoolean(), "unique", null, 0, 1, RequestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringRequestEClass, StringRequest.class, "StringRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStringRequest_Specification(), this.getRequestSpecification(), null, "specification", null, 0, 1, StringRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStringRequest_NoGenerators(), this.getNoGenerators(), null, "noGenerators", null, 0, 1, StringRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStringRequest_Generators(), this.getGenerator(), null, "generators", null, 0, -1, StringRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStringRequest_ValidValues(), this.getValidValues(), null, "validValues", null, 0, 1, StringRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringRequest_Id(), theXMLTypePackage.getNCName(), "id", null, 0, 1, StringRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringRequest_MaxValues(), theXMLTypePackage.getInt(), "maxValues", null, 1, 1, StringRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringRequest_Name(), theXMLTypePackage.getID(), "name", null, 1, 1, StringRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringRequest_Seed(), theXMLTypePackage.getLong(), "seed", null, 0, 1, StringRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structureRequestEClass, StructureRequest.class, "StructureRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructureRequest_Specification(), this.getRequestSpecification(), null, "specification", null, 0, 1, StructureRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureRequest_Operators(), this.getOperator(), null, "operators", null, 0, -1, StructureRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructureRequest_FuzzStructure(), theXMLTypePackage.getBoolean(), "fuzzStructure", null, 0, 1, StructureRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructureRequest_FuzzValues(), theXMLTypePackage.getBoolean(), "fuzzValues", null, 0, 1, StructureRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructureRequest_Id(), theXMLTypePackage.getNCName(), "id", null, 0, 1, StructureRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructureRequest_MaxMutations(), theXMLTypePackage.getInt(), "maxMutations", null, 0, 1, StructureRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructureRequest_MaxValues(), theXMLTypePackage.getInt(), "maxValues", null, 1, 1, StructureRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructureRequest_MinMutations(), theXMLTypePackage.getInt(), "minMutations", "1", 0, 1, StructureRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructureRequest_Name(), theXMLTypePackage.getID(), "name", null, 1, 1, StructureRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructureRequest_Seed(), theXMLTypePackage.getLong(), "seed", null, 0, 1, StructureRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(validCollectionEClass, ValidCollection.class, "ValidCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValidCollection_Value(), theXMLTypePackage.getString(), "value", null, 0, -1, ValidCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValidCollection_Name(), theXMLTypePackage.getID(), "name", null, 1, 1, ValidCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(validCollectionsEClass, ValidCollections.class, "ValidCollections", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValidCollections_Values(), this.getValidCollection(), null, "values", null, 1, -1, ValidCollections.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidCollections_Operators(), this.getOperator(), null, "operators", null, 0, -1, ValidCollections.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(validValuesEClass, ValidValues.class, "ValidValues", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValidValues_Values(), theXMLTypePackage.getString(), "values", null, 1, -1, ValidValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidValues_Operators(), this.getOperator(), null, "operators", null, 0, -1, ValidValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xmlRequestDocumentEClass, XmlRequestDocument.class, "XmlRequestDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXmlRequestDocument_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXmlRequestDocument_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXmlRequestDocument_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXmlRequestDocument_Request(), this.getRequest(), null, "request", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

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
		  (closeRequestEClass, 
		   source, 
		   new String[] {
			 "name", "closeRequest_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getCloseRequest_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });			
		addAnnotation
		  (collectionRequestEClass, 
		   source, 
		   new String[] {
			 "name", "collection_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCollectionRequest_Specification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "specification",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getCollectionRequest_ValidCollections(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "validCollections",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getCollectionRequest_FuzzStructure(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "fuzzStructure"
		   });			
		addAnnotation
		  (getCollectionRequest_FuzzValues(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "fuzzValues"
		   });			
		addAnnotation
		  (getCollectionRequest_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });			
		addAnnotation
		  (getCollectionRequest_MaxMutations(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "maxMutations"
		   });			
		addAnnotation
		  (getCollectionRequest_MaxValues(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "maxValues"
		   });			
		addAnnotation
		  (getCollectionRequest_MinMutations(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "minMutations"
		   });			
		addAnnotation
		  (getCollectionRequest_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });			
		addAnnotation
		  (getCollectionRequest_Seed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "seed"
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
		  (generatorEClass, 
		   source, 
		   new String[] {
			 "name", "generator_._type",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getGenerator_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getGenerator_Param(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "param"
		   });			
		addAnnotation
		  (noGeneratorsEClass, 
		   source, 
		   new String[] {
			 "name", "noGenerators_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (numberRequestEClass, 
		   source, 
		   new String[] {
			 "name", "number_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getNumberRequest_Specification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "specification",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getNumberRequest_NoGenerators(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "noGenerators",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getNumberRequest_Generators(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "generator",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getNumberRequest_ValidValues(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "validValues",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getNumberRequest_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });			
		addAnnotation
		  (getNumberRequest_MaxValues(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "maxValues"
		   });			
		addAnnotation
		  (getNumberRequest_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });			
		addAnnotation
		  (getNumberRequest_Seed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "seed"
		   });			
		addAnnotation
		  (operatorEClass, 
		   source, 
		   new String[] {
			 "name", "operator_._type",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getOperator_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getOperator_Param(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "param"
		   });			
		addAnnotation
		  (requestEClass, 
		   source, 
		   new String[] {
			 "name", "request_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getRequest_StringRequests(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "string",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getRequest_NumberRequests(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "number",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getRequest_StructureRequests(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "structure",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getRequest_CollectionRequests(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "collection",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getRequest_CloseRequests(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "closeRequest",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (requestSpecificationEClass, 
		   source, 
		   new String[] {
			 "name", "specification_._type",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getRequestSpecification_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getRequestSpecification_Field(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "field",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getRequestSpecification_Bits(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "bits"
		   });			
		addAnnotation
		  (getRequestSpecification_Encoding(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "encoding"
		   });			
		addAnnotation
		  (getRequestSpecification_MaxLength(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "maxLength"
		   });			
		addAnnotation
		  (getRequestSpecification_MaxValue(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "maxValue"
		   });			
		addAnnotation
		  (getRequestSpecification_MinLength(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "minLength"
		   });			
		addAnnotation
		  (getRequestSpecification_MinValue(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "minValue"
		   });			
		addAnnotation
		  (getRequestSpecification_NullTerminated(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "nullTerminated"
		   });			
		addAnnotation
		  (getRequestSpecification_Ordered(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ordered"
		   });			
		addAnnotation
		  (getRequestSpecification_Ref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ref"
		   });			
		addAnnotation
		  (getRequestSpecification_Signed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "signed"
		   });			
		addAnnotation
		  (getRequestSpecification_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });			
		addAnnotation
		  (getRequestSpecification_Unique(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "unique"
		   });			
		addAnnotation
		  (stringRequestEClass, 
		   source, 
		   new String[] {
			 "name", "string_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getStringRequest_Specification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "specification",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getStringRequest_NoGenerators(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "noGenerators",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getStringRequest_Generators(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "generator",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getStringRequest_ValidValues(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "validValues",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getStringRequest_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });			
		addAnnotation
		  (getStringRequest_MaxValues(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "maxValues"
		   });			
		addAnnotation
		  (getStringRequest_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });			
		addAnnotation
		  (getStringRequest_Seed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "seed"
		   });			
		addAnnotation
		  (structureRequestEClass, 
		   source, 
		   new String[] {
			 "name", "structure_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getStructureRequest_Specification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "specification",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getStructureRequest_Operators(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "operator",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getStructureRequest_FuzzStructure(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "fuzzStructure"
		   });			
		addAnnotation
		  (getStructureRequest_FuzzValues(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "fuzzValues"
		   });			
		addAnnotation
		  (getStructureRequest_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });			
		addAnnotation
		  (getStructureRequest_MaxMutations(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "maxMutations"
		   });			
		addAnnotation
		  (getStructureRequest_MaxValues(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "maxValues"
		   });			
		addAnnotation
		  (getStructureRequest_MinMutations(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "minMutations"
		   });			
		addAnnotation
		  (getStructureRequest_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });			
		addAnnotation
		  (getStructureRequest_Seed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "seed"
		   });			
		addAnnotation
		  (validCollectionEClass, 
		   source, 
		   new String[] {
			 "name", "validCollection_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getValidCollection_Value(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "value",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getValidCollection_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (validCollectionsEClass, 
		   source, 
		   new String[] {
			 "name", "validCollections_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getValidCollections_Values(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "validCollection",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getValidCollections_Operators(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "operator",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (validValuesEClass, 
		   source, 
		   new String[] {
			 "name", "validValues_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getValidValues_Values(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "value",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getValidValues_Operators(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "operator",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (xmlRequestDocumentEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getXmlRequestDocument_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getXmlRequestDocument_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getXmlRequestDocument_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getXmlRequestDocument_Request(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "request",
			 "namespace", "##targetNamespace"
		   });
	}

} //RequestPackageImpl
