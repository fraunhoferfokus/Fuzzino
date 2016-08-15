package de.fraunhofer.fokus.fuzzing.fuzzino.response.java.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public abstract class IllegalHeuristic {

	@XmlAttribute(name = "name")
	protected String name;
	@XmlAttribute
	protected String reason;
	
	public IllegalHeuristic(){}
	
	public IllegalHeuristic(String name, String reason) {
		setName(name);
		setReason(reason);
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String value) {
		reason = value;
	}
	
	@Override
	public boolean equals(Object o){
		if( o instanceof IllegalHeuristic){
			IllegalHeuristic other = (IllegalHeuristic) o;
			return name.equals(other.getName()) && reason.equals(other.getReason());
		} else{
			return false;
		}
	}
}
