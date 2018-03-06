package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.number;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.SimpleFuzzingGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.NumberSpecification;


public class BadFloatGenerator extends SimpleFuzzingGenerator<Double>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NumberSpecification<Double> floatSpec;

	public BadFloatGenerator(NumberSpecification<Double> floatSpec,long seed) {
		super(seed);
		this.floatSpec = floatSpec;
	}

	@Override
	public String getName() {
		return "BadFloat";
	}

	@Override
	public List<Double> getFuzzValues() {
		List<Double> values = getInBorderValues();
		values.addAll(getBorderViolationValues());
		values.addAll(getSpecialValues());
		return values;
	}

	private Collection<Double> getSpecialValues() {
		List<Double> values = new ArrayList<>();
		values.add(Double.NEGATIVE_INFINITY);
		values.add(Double.POSITIVE_INFINITY);
		values.add(Double.MAX_VALUE);
		values.add(Double.MIN_VALUE);
		values.add(Double.MIN_NORMAL);
		values.add(Double.NaN);
		values.add((double) Float.NEGATIVE_INFINITY);
		values.add((double) Float.POSITIVE_INFINITY);
		values.add((double) Float.MAX_VALUE);
		values.add((double) Float.MIN_VALUE);
		values.add((double) Float.MIN_NORMAL);
		values.add((double) Float.NaN);
		return values;
	}

	private Collection<Double> getBorderViolationValues() {
		List<Double> values = new ArrayList<>();
		double min = floatSpec.getMin();
		double max = floatSpec.getMax();
		values.add(Math.nextAfter(min,Double.NEGATIVE_INFINITY));
		values.add(Math.nextAfter(max,Double.POSITIVE_INFINITY));
		values.add((double) Math.nextAfter((float)min,Float.NEGATIVE_INFINITY));
		values.add((double) Math.nextAfter((float)max,Float.POSITIVE_INFINITY));
		return values;
	}

	private List<Double> getInBorderValues() {
		List<Double> values = new ArrayList<>();
		double min = floatSpec.getMin();
		double max = floatSpec.getMax();
		double difference = max-min;
		double maxVals = 10;
		values.add(min);
		for(int i=1;i<maxVals;i++){
			values.add(min+i*difference/maxVals);
		}
		values.add(max);
		return values;
	}

}
