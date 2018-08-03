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

/**
 * <p>
 * Contains interfaces, abstract classes and all factories for operators.
 * </p>
 * Depending on which Operator you want to create, you need to choose from following Factories:
 * <ul>
 * <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.BigIntegerOperatorFactory BigIntegerOperatorFactory}</li>
 * <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.CollectionOperatorFactory CollectionOperatorFactory}</li>
 * <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.IntegerOperatorFactory IntegerOperatorFactory}</li>
 * <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StringOperatorFactory StringOperatorFactory}</li>
 * <li>{@link de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.StructureOperatorFactory StructureOperatorFactory}</li>
 * </ul>
 */
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.operators;