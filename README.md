<img src="https://github.com/fraunhoferfokus/Fuzzino/blob/master/fuzzino.jpg?raw=true" alt="Fuzzino">

Fuzzino
=======

Fuzzino is a library that provides generation of test data for fuzz testing. With fuzzing, you are able to find security-related weaknesses in your code. It's about injecting invalid or unexpected input data to a system under test. That way, security-relevant vulnerabilities may be detected when the system under test processes such data instead of rejecting it.

You can integrate Fuzzino into your testing tool in order to enable it for fuzz testing.

Please keep in mind that Fuzzino is not a full-featured fuzzing tool. It is a test data generator for enabling your testing tool to perform fuzzing.

Fuzzino is licensed under the [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).

Copyright 2012-13 Fraunhofer FOKUS

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.


Requirements
============

For compiling the Fuzzino sources, you need [Eclipse EMF](http://www.eclipse.org/modeling/emf/) 2.7, more precisely the following JAR files:

* org.eclipse.emf.common, e.g. org.eclipse.emf.common_2.7.0.v20120127-1122.jar
* org.eclipse.emf.compare, e.g. org.eclipse.emf.compare_1.2.2.v20120214-0915.jar
* org.eclipse.emf.ecore, e.g. org.eclipse.emf.ecore_2.7.0.v20120127-1122.jar
* org.eclipse.emf.ecore.xmi, e.g. org.eclipse.emf.ecore.xmi_2.7.0.v20120127-1122.jar

For compiling and executing the tests, you additionally need [JUnit 4](http://junit.org/).


Usage
=====

You can obtain fuzz test data from Fuzzino in two ways:

* XML: This is the most generic way for obtaining fuzz test data from the library. It works from any programming language that is able to generate and process XML documents. You run Fuzzino via the console using `java -jar <filename.request.xml>`.
* Java: You can directly interact with Fuzzino by submitting XML String instead of XML files in order to avoid time-consuming serialization and deserialization. It is also possible to instantiate Java classes that carry the information taken from the XML instead of using XML. A third way is to directly instantiate specific fuzzing heuristics by the corresponding heuristics factory. 


Documentation & Examples
========================

A documentation for the XML format as well as some general information can be found in the folder doc. Java and XML examples can be found in the folder doc/examples. More documentation will follow soon.