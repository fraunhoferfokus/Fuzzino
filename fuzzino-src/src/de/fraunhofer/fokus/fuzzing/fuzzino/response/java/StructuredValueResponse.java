package de.fraunhofer.fokus.fuzzing.fuzzino.response.java;

/***
 * Interace for all the responses that structure their values by generators and operators (currently String and Number)
 * @author Leon Bornemann (leon.bornemann@fokus.fraunhofer.de ) 
 *
 * @param <T>
 */
public interface StructuredValueResponse<T> extends CommonResponse{

	/**
	 * @return The section containing all fuzzed values that are created by fuzzing generators.
	 */
	FuzzedValuesByGenerators<T> getGeneratorBasedSection();
	
	/**
	 * Sets the section that contains all fuzzed values that are created by fuzzing generators.
	 * 
	 * @param value The section of fuzzed values that are created by fuzzing generators.
	 */
	void setGeneratorBasedSection(FuzzedValuesByGenerators<T> value);
	
	/**
	 * @return The section containing all fuzzed values that are created by fuzzing operators.
	 */
	FuzzedValuesByOperators<T> getOperatorBasedSection();
	
	/**
	 * Sets the section that contains all fuzzed values that are created by fuzzing operators.
	 * 
	 * @param value The section of fuzzed values that are created by fuzzing operators.
	 */
	void setOperatorBasedSection(FuzzedValuesByOperators<T> value);
}
