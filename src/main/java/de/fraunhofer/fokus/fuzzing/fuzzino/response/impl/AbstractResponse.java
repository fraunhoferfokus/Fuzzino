package de.fraunhofer.fokus.fuzzing.fuzzino.response.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import de.fraunhofer.fokus.fuzzing.fuzzino.response.CommonResponse;
import de.fraunhofer.fokus.fuzzing.fuzzino.response.WarningsSection;

/***
 * Abstract class to facilitate individual Response implementations and avoid code dublication.
 * @author Leon Bornemann (leon.bornemann@fokus.fraunhofer.de ) 
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public abstract class AbstractResponse implements CommonResponse {

	@XmlAttribute 
	private String id;
	@XmlAttribute
	private boolean moreValues;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private long seed;
	@XmlElement(type = WarningsSectionImpl.class)
	private WarningsSection warningsPart;

	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String value) {
		this.id=value;
	}

	@Override
	public boolean moreValuesAvailable() {
		return moreValues;
	}

	@Override
	public void setMoreValuesAvailable(boolean value) {
		this.moreValues = value;

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public long getSeed() {
		return seed;
	}

	@Override
	public void setSeed(long value) {
		this.seed = value;
	}

	@Override
	public WarningsSection getWarningsSection() {
		return warningsPart;
	}

	@Override
	public void setWarningsSection(WarningsSection value) {
		this.warningsPart = value;
	}

}
