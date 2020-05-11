//   Copyright 2012-2014 Fraunhofer FOKUS
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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.fraunhofer.fokus.fuzzing.fuzzino.exceptions.UnknownFuzzingHeuristicException;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.ComputableFuzzingHeuristic;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.AllBadStringsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadDateGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadFilenamesGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadHostnamesGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadIpAddressesGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadLongStringsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadLongUnicodeStringsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadNumbersAsStringGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadPathsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadStringsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadTimeGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.BadUnicodeUtf8StringsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.CommandInjectionsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.DelimitersGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.ForeignDigitsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.FormatStringsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.LongStringsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.Popular4DigitPinsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.SQLInjectionsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.SQLTimeBasedInjectionsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.SmallGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.UnicodeBomStringsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.XMLInjectionsGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.XSSBasicInputGenerator;
import de.fraunhofer.fokus.fuzzing.fuzzino.request.StringSpecification;

/**
 * <p>
 * A factory that creates all kinds of string generators. A single string
 * generator can be requested by its name via the method {@link #create} or by
 * calling the corresponding create method. The factory is a singleton which
 * instance can be obtained by calling {@code StringGeneratorFactory.INSTANCE}.
 * </p>
 * <p>
 * Following are all available working StringGenerators listed by their name.
 * This name is not the class name but the name used in a request.
 * <ul>
 * <li>{@link AllBadStringsGenerator AllBadStrings}</li>
 * <li>{@link BadDateGenerator BadDate}</li>
 * <li>{@link BadFilenamesGenerator BadFilenames}</li>
 * <li>{@link BadHostnamesGenerator BadIpAddresses}</li>
 * <li>{@link BadIpAddressesGenerator BadHostnames}</li>
 * <li>{@link BadLongStringsGenerator BadLongStrings}</li>
 * <li>{@link BadLongUnicodeStringsGenerator BadLongUnicodeStrings}</li>
 * <li>{@link BadNumbersAsStringGenerator BadNumbersAsString}</li>
 * <li>{@link BadPathsGenerator BadPaths}</li>
 * <li>{@link BadStringsGenerator BadStrings}</li>
 * <li>{@link BadTimeGenerator BadTime}</li>
 * <li>{@link BadUnicodeUtf8StringsGenerator BadUnicodeUtf8Strings}</li>
 * <li>{@link CommandInjectionsGenerator CommandInjections}</li>
 * <li>{@link DelimitersGenerator Delimiters}</li>
 * <li>{@link FormatStringsGenerator FormatStrings}</li>
 * <li>{@link ForeignDigitsGenerator ForeignDigits}</li>
 * <li>{@link LongStringsGenerator LongStrings}</li>
 * <li>{@link Popular4DigitPinsGenerator Popular4DigitPins}</li>
 * <li>{@link SmallGenerator SmallGenerator}</li>
 * <li>{@link SQLInjectionsGenerator SQLInjections}</li>
 * <li>{@link SQLTimeBasedInjectionsGenerator SQLTimeBasedInjections}</li>
 * <li>{@link UnicodeBomStringsGenerator UnicodeBomStrings}</li>
 * <li>{@link XMLInjectionsGenerator XMLInjections}</li>
 * <li>{@link XSSBasicInputGenerator XSSBasicInput}</li>
 * </ul>
 * </p>
 * @author Martin Schneider (martin.schneider@fokus.fraunhofer.de)
 *
 */
public class StringGeneratorFactory {

	/**
	 * The singleton instance of the factory.
	 */
	public static final StringGeneratorFactory INSTANCE = new StringGeneratorFactory();
	
	private StringGeneratorFactory() {
	}

	/**
	 * Creates a string generator identified by its name.
	 * 
	 * @param name
	 *            The name of the string generator that is not the class name
	 *            but the name used in a request (see Javadoc in
	 *            {@link StringGeneratorFactory} or
	 *            {@link ComputableFuzzingHeuristic#getName()}) or documentation for
	 *            a list of string generators and its names).
	 * @param param
	 *            A parameter for the requested string generator. May be
	 *            {@code null} if the requested generator does not have a parameter
	 *            or a default value shall be used.
	 * @param stringSpec
	 *            The string specification that describes the type the generator
	 *            shall create values for.
	 * @param seed
	 *            The seed to be used for random-based fuzzing heuristics.
	 * @return the requested instance of string generator.
	 * @throws UnknownFuzzingHeuristicException
	 *             if no generator with {@code name} is known.
	 */
	public StringGenerator create(String name, String param, StringSpecification stringSpec, long seed)
			throws UnknownFuzzingHeuristicException {
		if (name == null) {
			throw new UnknownFuzzingHeuristicException(name);
		}
		String canonicalName = name.trim().toUpperCase();
		if (canonicalName.equals("AllBadStrings".toUpperCase())) {
			return createAllBadStrings(stringSpec, seed);
		} else
		if (canonicalName.equals("BadDate".toUpperCase())) {
			return createBadDateGenerator(stringSpec, seed);
		} else
		if (canonicalName.equals("BadFilenames".toUpperCase())) {
			return createBadFilenames(stringSpec, seed);
		} else
		if (canonicalName.equals("BadIpAddresses".toUpperCase())) {
			return createBadIpAddresses(stringSpec, seed);
		} else
		if (canonicalName.equals("BadHostnames".toUpperCase())) {
			return createBadHostnames(stringSpec, seed);
		} else
		if (canonicalName.equals("BadLongStrings".toUpperCase())) {
			return createBadLongStrings(stringSpec, seed);
		} else
		if (canonicalName.equals("BadLongUnicodeStrings".toUpperCase())) {
			return createBadLongUnicodeStrings(stringSpec, seed);
		} else
		if (canonicalName.equals("BadNumbersAsString".toUpperCase())) {
			return createBadNumbersAsStringGenerator(stringSpec, seed);
		} else
		if (canonicalName.equals("BadPaths".toUpperCase())) {
			return createBadPaths(stringSpec, seed);
		} else
		if (canonicalName.equals("BadStrings".toUpperCase())) {
			return createBadStringsGenerator(stringSpec, seed);
		} else
	    if (canonicalName.equals("BadTime".toUpperCase())) {
	    	return createBadTimeGenerator(stringSpec, seed);
	    } else
		if (canonicalName.equals("BadUnicodeUtf8Strings".toUpperCase())) {
			return createBadUnicodeUtf8Strings(stringSpec, seed);
		} else
		if (canonicalName.equals("CommandInjections".toUpperCase())) {
			return createCommandInjections(stringSpec, seed);
		} else
		if (canonicalName.equals("Delimiters".toUpperCase())) {
			return createDelimitersGenerator(stringSpec, seed);
		}
		if (canonicalName.equals("FormatStrings".toUpperCase())) {
			return createFormatStrings(stringSpec, seed);
		} else
		if (canonicalName.equals("ForeignDigits".toUpperCase())) {
			return createForeignDigits(stringSpec, seed);
		} else
		if (canonicalName.equals("LongStrings".toUpperCase())) {
			return createLongStrings(stringSpec, seed);
		} else
		if (canonicalName.equals("Popular4DigitPins".toUpperCase())) {
			return createSmallGenerator(stringSpec, seed);
		} else
		if (canonicalName.equals("SmallGenerator".toUpperCase())) {
			return createSmallGenerator(stringSpec, seed);
		} else
		if (canonicalName.equals("SQLInjections".toUpperCase())) {
			return createSqlInjections(stringSpec, seed);
		} else
		if (canonicalName.equals("SQLTimeBasedInjections".toUpperCase())) {
			return createSqlTimeBasedInjections(stringSpec, seed);
		} else
		if (canonicalName.equals("UnicodeBomStrings".toUpperCase())) {
			return createUnicodeBomStringsGenerator(stringSpec, seed);
		} else
		if (canonicalName.equals("XMLInjections".toUpperCase())) {
			return createXmlInjections(stringSpec, seed);
		} else
		if (canonicalName.equals("XSSBasicInput".toUpperCase())) {
			return createXSSBasicInput(stringSpec, seed, param);
		} 
		else {
			throw new UnknownFuzzingHeuristicException(name);
		}
	}
	
	/**
	 * A list of all string generators that can create values for {@code stringSpec}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return a list of all string generators that can create values for {@code stringSpec}.
	 */
	public List<StringGenerator> createAll(StringSpecification stringSpec, long seed) {
		List<StringGenerator> allStringGenerators = new ArrayList<>();
		allStringGenerators.add(createBadFilenames(stringSpec, seed));
		allStringGenerators.add(createBadHostnames(stringSpec, seed));
		allStringGenerators.add(createBadLongStrings(stringSpec, seed));
		allStringGenerators.add(createBadLongUnicodeStrings(stringSpec, seed));
		allStringGenerators.add(createBadPaths(stringSpec, seed));
		allStringGenerators.add(createBadStringsGenerator(stringSpec, seed));
		allStringGenerators.add(createBadUnicodeUtf8Strings(stringSpec, seed));
		allStringGenerators.add(createCommandInjections(stringSpec, seed));
		allStringGenerators.add(createDelimitersGenerator(stringSpec, seed));
		allStringGenerators.add(createFormatStrings(stringSpec, seed));
		allStringGenerators.add(createForeignDigits(stringSpec, seed));
		allStringGenerators.add(createLongStrings(stringSpec, seed));
		allStringGenerators.add(createPopular4DigitPinsGenerator(stringSpec, seed));
		allStringGenerators.add(createSqlInjections(stringSpec, seed));
		allStringGenerators.add(createSqlTimeBasedInjections(stringSpec, seed));
		allStringGenerators.add(createUnicodeBomStringsGenerator(stringSpec, seed));
		allStringGenerators.add(createXmlInjections(stringSpec, seed));
		// TODO Add valid parameter for XSSBasicInputGenerator
		allStringGenerators.add(createXSSBasicInput(stringSpec, seed, "attackerURL"));
		
		List<StringGenerator> applicableGenerators = new LinkedList<>();
		for (StringGenerator stringGenerator : allStringGenerators) {
			if (stringGenerator.canCreateValuesFor(stringSpec)) {
				applicableGenerators.add(stringGenerator);
			}
		}
		
		return applicableGenerators;
	}
	
	/**
	 * Returns an instance of {@link AllBadStringsGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall create values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link AllBadStringsGenerator}.
	 */
	public AllBadStringsGenerator createAllBadStrings(StringSpecification stringSpec, long seed) {
		return new AllBadStringsGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link BadDateGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link BadDateGenerator}.
	 */
	public BadDateGenerator createBadDateGenerator(StringSpecification stringSpec, long seed) {
		return new BadDateGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link BadFilenamesGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link BadFilenamesGenerator}.
	 */
	public BadFilenamesGenerator createBadFilenames(StringSpecification stringSpec, long seed) {
		return new BadFilenamesGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link BadHostnamesGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link BadHostnamesGenerator}.
	 */
	public BadHostnamesGenerator createBadHostnames(StringSpecification stringSpec, long seed) {
		return new BadHostnamesGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link BadIpAddressesGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link BadIpAddressesGenerator}.
	 */
	public BadIpAddressesGenerator createBadIpAddresses(StringSpecification stringSpec, long seed) {
		return new BadIpAddressesGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link BadLongStringsGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link BadLongStringsGenerator}.
	 */
	public BadLongStringsGenerator createBadLongStrings(StringSpecification stringSpec, long seed) {
		return new BadLongStringsGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link BadLongUnicodeStringsGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link BadLongUnicodeStringsGenerator}.
	 */
	public BadLongUnicodeStringsGenerator createBadLongUnicodeStrings(StringSpecification stringSpec, long seed) {
		return new BadLongUnicodeStringsGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link BadNumbersAsStringGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link BadNumbersAsStringGenerator}.
	 */
	public BadNumbersAsStringGenerator createBadNumbersAsStringGenerator(StringSpecification stringSpec, long seed) {
		return new BadNumbersAsStringGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link BadPathsGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link BadPathsGenerator}.
	 */
	public BadPathsGenerator createBadPaths(StringSpecification stringSpec, long seed) {
		return new BadPathsGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link BadStringsGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link BadStringsGenerator}.
	 */
	public BadStringsGenerator createBadStringsGenerator(StringSpecification stringSpec, long seed) {
		return new BadStringsGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link BadTimeGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link BadTimeGenerator}.
	 */
	public BadTimeGenerator createBadTimeGenerator(StringSpecification stringSpec, long seed) {
		return new BadTimeGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link BadUnicodeUtf8StringsGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link BadUnicodeUtf8StringsGenerator}.
	 */
	public BadUnicodeUtf8StringsGenerator createBadUnicodeUtf8Strings(StringSpecification stringSpec, long seed) {
		return new BadUnicodeUtf8StringsGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link CommandInjectionsGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link CommandInjectionsGenerator}.
	 */
	public CommandInjectionsGenerator createCommandInjections(StringSpecification stringSpec, long seed) {
		return new CommandInjectionsGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link DelimitersGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link DelimitersGenerator}.
	 */
	public DelimitersGenerator createDelimitersGenerator(StringSpecification stringSpec, long seed) {
		return new DelimitersGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link FormatStringsGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link FormatStringsGenerator}.
	 */
	public FormatStringsGenerator createFormatStrings(StringSpecification stringSpec, long seed) {
		return new FormatStringsGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link ForeignDigitsGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link ForeignDigitsGenerator}.
	 */
	public ForeignDigitsGenerator createForeignDigits(StringSpecification stringSpec, long seed) {
		return new ForeignDigitsGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link LongStringsGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link LongStringsGenerator}.
	 */
	public LongStringsGenerator createLongStrings(StringSpecification stringSpec, long seed) {
		return new LongStringsGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link Popular4DigitPinsGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link Popular4DigitPinsGenerator}.
	 */
	public Popular4DigitPinsGenerator createPopular4DigitPinsGenerator(StringSpecification stringSpec, long seed) {
		return new Popular4DigitPinsGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link SmallGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link SmallGenerator}.
	 */
	public SmallGenerator createSmallGenerator(StringSpecification stringSpec, long seed) {
		return new SmallGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link SQLInjectionsGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link SQLInjectionsGenerator}.
	 */
	public SQLInjectionsGenerator createSqlInjections(StringSpecification stringSpec, long seed) {
		return new SQLInjectionsGenerator(stringSpec, seed);
	}

	/**
	 * Returns an instance of {@link SQLTimeBasedInjectionsGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link SQLTimeBasedInjectionsGenerator}.
	 */
	public SQLTimeBasedInjectionsGenerator createSqlTimeBasedInjections(StringSpecification stringSpec, long seed) {
		return new SQLTimeBasedInjectionsGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link UnicodeBomStringsGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link UnicodeBomStringsGenerator}.
	 */
	public UnicodeBomStringsGenerator createUnicodeBomStringsGenerator(StringSpecification stringSpec, long seed) {
		return new UnicodeBomStringsGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link XMLInjectionsGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link XMLInjectionsGenerator}
	 */
	public XMLInjectionsGenerator createXmlInjections(StringSpecification stringSpec, long seed) {
		return new XMLInjectionsGenerator(stringSpec, seed);
	}
	
	/**
	 * Returns an instance of {@link XSSBasicInputGenerator}.
	 * 
	 * @param stringSpec The string specification that describes the type the generator shall generator values for.
	 * @param seed The seed to be used for random-based fuzzing heuristics.
	 * @return an instance of {@link XSSBasicInputGenerator}
	 */
	public XSSBasicInputGenerator createXSSBasicInput(StringSpecification stringSpec, long seed, String attackerURL) {
		return new XSSBasicInputGenerator(stringSpec, seed, attackerURL);
	}
	
}