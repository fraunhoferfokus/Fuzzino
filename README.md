<img src="https://github.com/fraunhoferfokus/Fuzzino/blob/master/fuzzino.jpg?raw=true" alt="Fuzzino">

Fuzzino
=======

Fuzzino is a library that provides generation of test data for fuzz testing. With fuzzing, you are able to find security-related weaknesses in your code. It's about injecting invalid or unexpected input data to a system under test. That way, security-relevant vulnerabilities may be detected when the system under test processes such data instead of rejecting it.

You can integrate Fuzzino into your testing tool in order to enable it for fuzz testing.

Please keep in mind that Fuzzino is not a full-featured fuzzing tool. It is a test data generator for enabling your testing tool to perform fuzzing.

Fuzzino is licensed under the [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).

Copyright 2012-18 Fraunhofer FOKUS

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.


Requirements
============

Fuzzino was developed and tested with Java 8 and compiled with Maven.

Usage
=====

You can obtain fuzz test data from Fuzzino in two ways:

* XML: This is the most generic way for obtaining fuzz test data from the library. It works from any programming language that is able to generate and process XML documents. You run Fuzzino via the console using `java -jar <filename.request.xml>`. For example you have a valid XML request file with the name "badFilenames.xml" and the Fuzzino Jar de.fraunhofer.fokus.fuzzing.fuzzino-VERSION.jar in your current directory, then you can execute Fuzzino with following command from the console: `java -jar de.fraunhofer.fokus.fuzzing.fuzzino-VERSION.jar badFilenames.xml`. This command will create a XML response file in the directory of your XLM request file, in this case in the current directory.
* Java: You can directly interact with Fuzzino by submitting XML String instead of XML files in order to avoid time-consuming serialization and deserialization. It is also possible to instantiate Java classes that carry the information taken from the XML instead of using XML. A third way is to directly instantiate specific fuzzing heuristics by the corresponding heuristics factory. 


Documentation & Examples
========================

A documentation for the XML format as well as the XML schema documents for XML request and response files can be found in the folder doc/xml_description. Java examples can be found in the folder doc/java_examples and XML examples can be found in the folder doc/xml_examples.