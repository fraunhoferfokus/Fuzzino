package de.fraunhofer.fokus.fuzzing.fuzzino.request;

import javax.xml.bind.annotation.XmlSeeAlso;

import de.fraunhofer.fokus.fuzzing.fuzzino.request.impl.IntegerSpecificationImpl;

@XmlSeeAlso(IntegerSpecificationImpl.class)
public interface NumberSpecification<T extends Number> extends TypeSpecification{

	public T getMin();
	
	public T getMax();
	
	public void setMin(T min);
	
	public void setMax(T max);
	
	public NumberType getType();
}
