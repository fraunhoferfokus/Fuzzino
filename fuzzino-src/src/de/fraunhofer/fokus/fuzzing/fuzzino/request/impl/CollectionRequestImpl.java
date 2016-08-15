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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.LibraryType;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.AbstractRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionRequest;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.CollectionSpecification;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollection;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.ValidCollectionsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.IllegalRequestFormat;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.ResponseFactory;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.java.WarningsSection;
import de.fraunhofer.fokus.fuzzing.fuzzino.util.ValidationResult;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class CollectionRequestImpl extends AbstractRequest implements CollectionRequest {
	
	private static final long serialVersionUID = 4145919164552575528L;
	protected CollectionSpecification specification = null;
	protected ValidCollectionsSection validCollections = null;
	@XmlAttribute
	protected boolean fuzzStructure = false;
	@XmlAttribute
	protected boolean fuzzValues = false;
	@XmlAttribute
	protected int maxMutations = 0;
	@XmlAttribute
	protected int minMutations = 1;
	protected transient ValidationResult validationResult = null;

	@Override
	public CollectionSpecification getSpecification() {
		return specification;
	}

	@Override
	@XmlElement(name="specification",type = CollectionSpecificationImpl.class)
	public void setSpecification(CollectionSpecification specification) {
		this.specification = specification;
	}

	@Override
	@XmlElement(name = "validCollections",type = ValidCollectionsSectionImpl.class)
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
	public int getMaxMutations() {
		return maxMutations;
	}

	@Override
	public void setMaxMutations(int maxMutations) {
		this.maxMutations = maxMutations;
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
	public boolean isContinued() {
		return getId() != null;
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
