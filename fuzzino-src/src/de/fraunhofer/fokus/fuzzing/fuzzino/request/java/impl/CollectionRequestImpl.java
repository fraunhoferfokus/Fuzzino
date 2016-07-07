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
package de.fraunhofer.fokus.fuzzing.fuzzino.request.java.impl;

import de.fraunhofer.fokus.fuzzing.fuzzino.LibraryType;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.CollectionRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.CollectionSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.RequestFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.java.ValidCollectionsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.WarningsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ValidationResult;

public class CollectionRequestImpl implements CollectionRequest {
	
	private static final long serialVersionUID = 4145919164552575528L;
	protected CollectionSpecification specification = null;
	protected ValidCollectionsSection validCollections = null;
	protected boolean fuzzStructure = false;
	protected boolean fuzzValues = false;
	protected String id = null;
	protected int maxMutations = 0;
	protected int maxValues = 0;
	protected int minMutations = 1;
	protected String name = null;
	protected long seed = -1;
	protected boolean isEMFBased = false;
	protected transient ValidationResult validationResult = null;

	@Override
	public CollectionSpecification getSpecification() {
		return specification;
	}

	@Override
	public void setSpecification(CollectionSpecification specification) {
		this.specification = specification;
	}

	@Override
	public ValidCollectionsSection getValidCollectionsSection() {
		return validCollections;
	}

	@Override
	public void setValidCollectionsSection(ValidCollectionsSection value) {
		this.validCollections = value;		
	}

	@Override
	public boolean fuzzCollections() {
		return fuzzStructure;
	}

	@Override
	public void setFuzzCollections(boolean fuzzStructure) {
		this.fuzzStructure = fuzzStructure;
	}

	@Override
	public boolean fuzzValues() {
		return fuzzValues;
	}

	@Override
	public void setFuzzValues(boolean fuzzValues) {
		this.fuzzValues = fuzzValues;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int getMaxMutations() {
		return maxMutations;
	}

	@Override
	public void setMaxMutations(int maxMutations) {
		this.maxMutations = maxMutations;
	}

	@Override
	public int getMaxValues() {
		return maxValues;
	}

	@Override
	public void setMaxValues(int maxValues) {
		this.maxValues = maxValues;
	}

	@Override
	public int getMinMutations() {
		return minMutations;
	}

	@Override
	public void setMinMutations(int minMutations) {
		this.minMutations = minMutations;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public long getSeed() {
		return seed;
	}

	@Override
	public void setSeed(long seed) {
		this.seed = seed;
	}

	@Override
	public void setWithEMFObject(de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest emfCollectionRequest) {
		setFuzzCollections(emfCollectionRequest.isFuzzStructure());
		setFuzzValues(emfCollectionRequest.isFuzzValues());
		setId(emfCollectionRequest.getId());
		setMaxMutations(emfCollectionRequest.getMaxMutations());
		setMaxValues(emfCollectionRequest.getMaxValues());
		setMinMutations(emfCollectionRequest.getMinMutations());
		setName(emfCollectionRequest.getName());
		setSeed(emfCollectionRequest.getSeed());
		
		if (!isContinued()) {
			setSpecification(RequestFactory.INSTANCE.createCollectionSpecification(emfCollectionRequest.getSpecification()));
			setValidCollectionsSection(RequestFactory.INSTANCE.createValidCollections(emfCollectionRequest.getValidCollections()));
		}
		
		isEMFBased = true;
	}

	@Override
	public boolean isContinued() {
		return getId() != null;
	}

	@Override
	public boolean isEMFBased() {
		return isEMFBased;
	}

	@Override
	public ValidationResult validate() {
		if (validationResult == null) {
			validationResult = validateCollections();
		}
		return validationResult;
	}

	private ValidationResult validateCollections() {
		ValidationResult overallResult = validateValidCollectionsElements();
		if (overallResult.isValid()) {
			overallResult.merge(checkForExistingCollections());
		}
		if (overallResult.isValid()) {
			overallResult.merge(checkForNonEmptyCollections());
		}
		
		return overallResult;
	}
	
	private ValidationResult validateValidCollectionsElements() {
		WarningsSection warnings = null;
		
		boolean existingValidCollectionsElement = getValidCollectionsSection() != null;
		if (getValidCollectionsSection() == null || getValidCollectionsSection().getValidCollections().isEmpty()) {
			warnings = ResponseFactory.INSTANCE.createWarnings();
			IllegalRequestFormat missingCollections = 
					ResponseFactory.INSTANCE.createIllegalRequestFormatWithMissingElement("ValidValues");
			warnings.getIllegalRequestFormats().add(missingCollections);
		}
		
		return new ValidationResult(existingValidCollectionsElement, warnings);
	}
	
	private ValidationResult checkForExistingCollections() {
		WarningsSection warnings = null;

		boolean existingCollections = getValidCollectionsSection().getValidCollections().size() > 0;
		if (!existingCollections) {
			warnings = ResponseFactory.INSTANCE.createWarnings();
			IllegalRequestFormat missingAnyCollection =
					ResponseFactory.INSTANCE.createIllegalRequestFormatWithMissingElement("ValidCollection");
			warnings.getIllegalRequestFormats().add(missingAnyCollection);
		}
		
		return new ValidationResult(existingCollections, warnings);
	}
	
	private ValidationResult checkForNonEmptyCollections() {
		WarningsSection warnings = null;
		
		boolean existingAnyNonEmptyCollection = true;
		for (ValidCollection validCollection : getValidCollectionsSection().getValidCollections()) {
			if (validCollection.getValues().size() == 0) {
				existingAnyNonEmptyCollection = false;
			}
		}
		if (!existingAnyNonEmptyCollection) {
				warnings = ResponseFactory.INSTANCE.createWarnings();
			IllegalRequestFormat missingValue =
					ResponseFactory.INSTANCE.createIllegalRequestFormatWithMissingAttribute("ValidCollection", "value");
			warnings.getIllegalRequestFormats().add(missingValue);
		}
		
		return new ValidationResult(existingAnyNonEmptyCollection, warnings);
	}

	@Override
	public boolean isValid() {
		return validate().isValid();
	}
	
	@Override
	public String toString() {
		return "[CollectionRequest name:" + name +" id:" + id + "]";
	}

	@Override
	public LibraryType getLibraryType() {
		return LibraryType.COLLECTION;
	}
	
}
