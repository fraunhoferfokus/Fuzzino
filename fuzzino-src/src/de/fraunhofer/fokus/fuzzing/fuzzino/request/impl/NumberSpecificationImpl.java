package de.fraunhofer.fokus.fuzzing.fuzzino.request.impl;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberSpecification;

@XmlRootElement
@XmlSeeAlso(IntegerSpecificationImpl.class)
public abstract class NumberSpecificationImpl<T extends Number> implements NumberSpecification<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T min;
	private T max;

	@Override
	public T getMin() {
		return min;
	}

	@Override
	public T getMax() {
		return max;
	}

	@Override
	public void setMin(T min) {
		this.min = min;
	}

	@Override
	public void setMax(T max) {
		this.max=max;
	}

}
