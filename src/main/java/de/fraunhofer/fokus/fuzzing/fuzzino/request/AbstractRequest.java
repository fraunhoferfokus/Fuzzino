package de.fraunhofer.fokus.fuzzing.fuzzino.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractRequest implements CommonRequest {

	@XmlAttribute
	protected String id = null;
	@XmlAttribute
	protected int maxValues = 0;
	@XmlAttribute
	protected String name = null;
	@XmlAttribute
	protected long seed = -1;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String value) {
		this.id = value;
	}

	@Override
	public int getMaxValues() {
		return maxValues;
	}

	@Override
	public void setMaxValues(int value) {
		this.maxValues = value;
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
	public boolean isContinued() {
		return getId() != null;
	}

}
