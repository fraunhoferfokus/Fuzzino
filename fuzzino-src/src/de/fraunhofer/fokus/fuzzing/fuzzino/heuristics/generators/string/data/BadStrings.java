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

import de.fraunhofer.fokus.fuzzing.fuzzino.util.StringUtil;

public class BadStrings extends StringContainer {
	
	public static final BadStrings INSTANCE = new BadStrings();
	
	private BadStrings() {
		super();
	}

	@Override
	protected void initValues() {
		add("Fuzzino");
		add("abcdefghijklmnopqrstuvwxyz");
		add("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		add("0123456789");
		add("");
		add("10");
		add("0.0");
		add("1.0");
		add("0.1");
		add("1.1.1");
		add("-2,147,483,648");
		add("-2,147,483,649");
		add("2,147,483,647");
		add("2,147,483,649");
		add("-2147483648");
		add("-2147483649");
		add("2147483647");
		add("2147483649");
		add("-129");
		add("129");
		add("255");
		add("256");
		add("-32769");
		add("-32,769");
		add("32767");
		add("32769");
		add("4,294,967,295");
		add("4294967299");
		add("-9,223,372,036,854,775,809");
		add("-9223372036854775809");
		add("9,223,372,036,854,775,809");
		add("9223372036854775809");
		add("18,446,744,073,709,551,615");
		add("18,446,744,073,709,551,619");
		add("18446744073709551619");
		add("2.305843009213693952");
		add("200000000000000000000.5");
		add("200000000000000000000000000000000000000000000.5");
		add("0xFF");
		add("0xFFFF");
		add("0xFFFFFF");
		add("0xFFFFFFFFFFFFFFFFFFFF");
		add("Yes");
		add("No");
		add("%n");
		add(StringUtil.repeat("%n", 35));
		add(StringUtil.repeat("%n", 1024));
		add("%x");
		add(StringUtil.repeat("%x", 8));
		add(StringUtil.repeat("%x", 17));
		add(StringUtil.repeat("%x", 31));
		add(StringUtil.repeat("%x", 41));
		add("<>\"/'");
		add("~`!@#$%^&*()_+=-{}|\\][:\"';<>?/.,");
		add("\\\"");
		add("\\'");
		add("%");
		add("a%");
		add("%a");
		add("COM1");
		add("COM2");
		add("AUX");
		add("COM1:");
		add("COM2:");
		add("AUX:");
		add("\\\\peach\\x12oo\\x12oo.txt");
		add("\\\\\\");
		add(StringUtil.repeat("..\\", 8));
		add(StringUtil.repeat("../", 5));
		add("../");
		add(StringUtil.repeat("/..", 6) + "/");
		add(StringUtil.repeat("/..", 3));
		add(StringUtil.repeat("\\..", 5) + "\\");
		add(StringUtil.repeat(";,", 32));
		add(StringUtil.repeat(";,", 256));
		add(StringUtil.repeat(";,", 512));
		add(StringUtil.repeat(";,", 1024));
		add(StringUtil.repeat("A;A,", 256));
		add(StringUtil.repeat("A;A,", 512));
		add(StringUtil.repeat("A;A,", 1024));
		add(StringUtil.repeat(",", 256));
		add(StringUtil.repeat(",", 512));
		add(StringUtil.repeat(",", 1024));
		add(StringUtil.repeat("|", 256));
		add(StringUtil.repeat("|", 512));
		add(StringUtil.repeat("|", 1024));
		add(StringUtil.repeat("|", 2048));
		add(StringUtil.repeat(":", 256));
		add(StringUtil.repeat(":", 512));
		add(StringUtil.repeat(":", 1024));
		for (int i=0; i<10; i++) {
			add("\\x0" + Integer.toHexString(i));
		}
		for (int i=10; i<256; i++) {
			add("\\x" + Integer.toHexString(i));
		}
		add("NLBO1[)HZK\nP+_HMzVTXCnd(]?\n0d!]JvhuVBKCIS'Z ZTz$nNvN*^Y2\\-oc&");
		add("tA<mrHWzY\r<YYM@o\r&g}@cd,.rZ_/-wisLVgq\t#s4}*&LyKH\"_\'nhyl\">\'03iz0089M&=CW(zR![rp@H,SDy(+}T>I&Z0?-b");
		add("+XsB@`\"&&p }DNrF+y\'#");
		add("dHVwa4b];BU=Y _4,Zj!pr%K-4R>8");
		add("b)UeNK\"FL5==..>R(");
		add("OL7co\tO1-\'L.]rIGq?zP_Hy|tv]bp}P:\nG%2d02+D[[Q+aQD>ljZGKt-/*!4Yf\"Z\n;=n`Pc<++Cg!6fU(|O&dP];KP\\?n(H`!");
		add("coDAEhm.XiO\"{VDHbE_7ch:S#f)/mFS\n%$ogj%\nk\t33<jB36wR(\"\")kFyB6+rEb;/gD!ulobuzb%iVAEv{QjTyh3?Fnj{\\2A|te");
		add("u\nr)nd;5V+W6Pu?JyvL'Q_v2alA4");
		add("h-dR#)k7WvMzN{u(l\n0M+$I Ipak|tiGxY");
		add("!C\\X=&N-w-6$YzU)k>AWF,kg<>&],Dk");
		add("iO/A411}.GO-Tct[Pe^[,S\\[P\r(\tJh,CdgGe}P0i9@J;OGANn+vY5]wJ;ny4S>H%Ci=L8+#F=\t:N\r<");
		add("mTmep6'/0R9fm?(*N14l]^agvOPIYYM");
		add("w`e4k.sqG-h2;&8\'\'M=\\O:ExpqpljxWt7}oUaf+g%ly5?NO\\Xi@YIj\"$/KdSrc%u &M%eXGAwb0K");
		add("G]`)pd[fxMIG*}\\FxD#,>@X'pc)Dyf 1!u/d^yEH'_\t`e/$%|E-#_np-k+K&Qa)v");
		add("-6)b,dS`f\t@\n`ODt{IlU<LG[\tz|L-+$x\n`{txuySp_61sC|Q\nrVy.k>\tmSa7uD{ZK}6:Y<>tP \rnn2gYV`yG0_!=Te\\");
		add("fgz[P>J r^6s0C,dD0*D:vPXZ'2J>EdxbZ&7t");
		add("n4@Tr[Q-y{15Bc^LNlR");
		add("wJV:e\rS`Hcs?EZr<$WM=G<z>*c?K7\r7:vw!pcv]#Y@i=3TYD{d+r/`NZ}[Pu2 /\"`5\\8$9`j<,vU[v^UWSG@\n:5d");
		add(")p\n$ft\n7b#M");
		add("{M\'keS<|oi\\N`@U`HiOG\nkN@<Fr1%FO\"_");
		add("ndv`I\\Xa\\]MH#iZv$ nDC;Y},9K[y;.Xx)u?bCcC\tM&Ed35KEHC8Yl");
		add("NahE$R,GHgel8 ;P>XzN$F6[\'D(=/brPwt&qfVPo>fDs$,&CFoX=w\"N0\"");
		add("vP06t=KDu\\+ef(jn");
		add(":_6@{ynQjjy8GQ$,Cnx\">\\i0 jh0T\rk$/;PtZh)$1HK|PFXDFtb e9T\"]}WPah7g&yd[");
		add("&6 p-Q?}\tteSskJ.x+c<k_Bf\"C)rwR");
		add(":Cn`WMCDX+Lm{3nIHve(R<X+3p:fLc%\tF`?[ksKUc\'2or4SB.8\ncsLs1!BK/f5})!=6!TZ2D#\\1,((\"LA811\ndQ");
		add("!j>T.%>\t,bZSi[+>t\r(+wX.");
		add("*KhpDT52c8s!w_T\nT=>@i5%=RVCc53E%.*j)752qJQez\\,Sog*\r,afqE [sv2j|S,nAe^P]DOV(btBTa[R");
		add("Y!o2f60&Cc!6>2O\tM%");
		add(":S\"@Yo)9JL(QviN|G\\\n2.oUm,o`\'-qE>C+W$U#<`VAWWRvAx9G3,&j<hbflifSP:!:R8XSf3esJ3xbHWk");
		add("-]/Z\n69`+>x[.Fkqepw\'@Zc0/0;?=/Q{\"db[,n,04Vf{G\'!,\\Xni2$S@\nWO1\nG*g:Z|U^nyM6%h\"z");
		add("D{8Yk\tMt5fEpLKr$!u5N\tK4biWRVJ7&I=!fzG*T5P@2`ptJohAKKjUp6w:=)BG\"uADvs![:0Og");
		add("N4n;\r^E`Q7Le");
		add("b Kt*eY.mG'iAa2!h(aG7\\\\u0e_LH2a\\IHZu");
		add("$**:XQ9nQrsSyOvUG(]m7X#XTU)\t{4Fy= %M");
		add("Z*;R&@DjCH&pa G< 4T(0D^2:eN?}EaiWR\n028kf=(smnJN0?9b$lj[ZwLtC$>0p");
		add("w;}\r%)L/?tzAIF\tqSJo:A`+`q%)ChFmGt=+@NPp3`u.B#|WjV)I?_1wC4vHp");
		add(";\"W95cW$Z\rJ(j;ehIu|<\rmVmd80e)o-g\tharN$.fe;S");
		add("}\no/]&-&m-k2(wf!\nB+xs*xO&N&sP|WL\trZGJ d4m\t_");
		add("d]ScKG\"sq3\toB.Mu[K\'Kn\'{ :!\n?OYI\'l?e.{0AR3&75a6Yd^#,|{4jrW[;4,RHdusW");
		add("`Ic]7{p:aIJ}1tAt>t5ZH");
		add("4FB%#=k;0Q\\&]\rz1x\"dM>wgDKh[f\nTpf(/\\AryJt(%Er\r");
		add("\n6\\'3E'e|BEN`yJO MH#=ux<rT( nyJ-}'CU!LD.p/ F!)thAEt 2Q'0^:hHPF_#]+/uKWzzhqibTz:42%b^mt*I");
		add("0j}5;=s$7v*5ZFY[\\+Nu$Hw=%B&ZOy>T\"]b-/?mn}mc)%5uUjEPzZ4!&c@l`#\nq{uSMA<5bnko/g.\"gyAtlJ;");
		add("YB>$;s@\\^O23ZN>jr]d");
		add("5anH\rgm9_7QKT\rwqrZx\r!4)C$zTE9 0O}<iK/txb\\ny");
		add("xA=^V\r,Cpy\tO#lR;e%lW0Ys0[1jzH>t; [ph%L(`WgVk!}N'#IzBpo0,06;4Rl$4Lw_c|uOI*");
		add(",d)=!h+8s9I-FK#i[mZQ=xN$q=Cg7iW(jse+;zp>.z/WCg$R*$_;QJ juH0XI\rI");
		add("m}\tODbC5@j(\r;RO39j#Q6?WQGTHy.l]ce\r|#U)j\\o%lpVn1{)9B2sb[QxD[");
		add("_wPz,P\\\\uX\tBO=aU*ZWHZZK|fI( n;Z<PGKo\t^{?\n,w9t_#6@|\\*C#m8Q*{PCpLUyW}e4Pi7h%CeT7*#|");
		add("w-Q\\5E40\'bF\'^\'lj1n\"G0Peh/_!cnO|e\'oYeTs.|6zHc5gM]>o287?(:");
		add("\"v\r][D)-=w=P0mWI(!2P?,#zzZU?qL;j\t_L\'et<@/l5Ry0y?Ht0bDCr3{UC?EQ#U;h:-\tJh=!NH+`\r)1wI1Ks7m0{DKP");
		add("]:jT5{7)?QuaGs#:DP\rG|G9x^h|ka9P}q$NmV$_5`}+<2c?84rlx4ooh1{");
		add("k%ol6+S]rSH{s|Jd+;:lRu(V*:]6EX-] \\fS0t2=wK)+gs74J`L#bDKK$nH1?_iMFfp5;H:[O\t");
		add("U3hXMIlZ-/9D?4bD)>18xrjJ>ym&O5@zAN\not2LBIr#+mobKz?='P|6Jwwhc3\t`pu8W\n.54gxom");
		add("\tY(g4#Zy.FH(bZqVhij");
		add("\\f\rc1#:2c)WKO3\n-}9C&7&\'<#\n#icl_$&R@ \nMS.53w)6nRC\n^64hd|uH0TWC$k\r lF0\"w9_SBE& j(o>NN0}rcB/IQT");
		add("*0.kIR-:]MA:.OUK&ab'D6;D'v_B;i=vP=gxF>>");
		add("{r>=/OU5,/+I+gg\"6=9");
		add("\n9\"1]ef2LDo;I4t2\"e9w3KJn6_ZO+%u;^DQIuSvo#XRYwWZh)P VmgK0&|&f3\rV.<\nv[l%*<\t\\\\u\n3xjkv1l.e\'KURz");
		add("znU(-/I_-)qhSZ7`a5oAc0mYf1!l ;@V#\tNO5qYmZlh_@LvL`");
		add("HcAUF8{<h\"OL8@Q0F9=8*)G=Bc\nqZJ%LD$J*s=,c\tFzlnzH;");
		add("yln/[Rppd?sIfPOeMoig<C6\t2M9L$9Lz)>f8[");
		add("m49'>F^&g<\\f%SkLeKX?\\W<)v6GIc]Sp.Fm2{I{H<Juje9QjHb8U\\>Ik<,");
		add("O,B1(\nNVD$He+$V6x-+(l}Lt|6L\\\\UC8qK3UY`3j%EjolV3w[");
		add("id0;D\"0;#3-^T?L3Wt*IW_\\.^^*\\!@]8`IbJFo/sDqR  {&.}iNSgfiMcLZ\n");
		add("w,-WKlh_t/j#HcU_w](-rf-QYAqv\"!\n\'&w4}\'i]Y=\\_u`a7=dFhCOI]:/5J)80k0w\tAp:*E,Mw;1WRA?c|$|?rI]VXTHHB^b^");
		add("hKh@/W,2-:bk\'yfKh;Bj6-JLq_==Zf5NL=x?;m9-B]\"^_f ,[6eLgd5EP$f$:Sk1))DY]X2Ku=\n,`=@Sa[s");
		add("\ntC9lH-m\'#2}\rk.kl@\rA.<Z%SCn\'sv`\\\'J\"4H^W\'_!K%s\n92Z5X]GRjKw,%<yu'E%?cf\\;a=5S{t5OU");
		add("<r=Eye:\\vYtm<-&");
		add("^:6n`.P%@tG|g4VKN<Q40faHsyb*iSfL`tym gLf?R[[\n?jb\t}5}gs\nRF\rU& _.H\\{y");
		add("\"FtZ{RgsfC/M/rZz%}qxq]GU8VkLi_;m^atgc\r.b%gr.:]9RE7hd-W1Q?vsj<1RvZ5Qj^yp{TzLrWC-;sfH7E@UY");
		add("Xg:qp`K$IVn");
		add(",GZCKc`igp<&*w!LLt]KL-L$@Z8,T5*86UG*jZP/X6zg=\\");
		add("QX/u}dSM:/pGC0+R[H37\r*F9iQ$';z12jQ})");
		add("m&D)HD;EapfA\t55sidJ_8O|lPYRy=C?\"[vDtzr<!dm\'8_hT{{lm{4.v>kL,1h2N\'\r250t6|lz<[4E\rioTh");
		add("?/D}i.<<\t\r.[+A`[{q7d pO)EH{?|>!hZHOTd/M=$[f\t;\tF\t+9k)bn\nn6[Tlgv[Wgr/L{9\tq}+");
		add("Yguk(I?(LVVI\r_w5{M2+3J$@si7>!LD36n3U6P\"O-?s[wcgY");
		add("5JX;orNqSB5!)Cy4ky4vrW.P#\toctT=Xz'*A`6gWZ*6wd6f8.X*n\rCP<\t;|8iy\tx{ M\rp6k\tFr)\rb3\t/X");
		add("6^b:R'j-0![aov(^`YQ{Cl}*");
		add("HuRUu]Dtcl\\zM,7(OmEU%O$gU]x/z\tD");
		add("Pu ,o>O1OJ|jlD\n+<>,'8d!hF1hn_Q{5_5[/e");
		add("yjxky&j%31n,Zu*fzaHSp721|74qu10?7p\n=>y{730bq?H\\YttzFw6g");
		add("k{;g8{QwYV!]s]:PP)W>D,o\rrL>LAG33:YITTxs}\"[Z[U,1");
		add("dJB:b=BZx-COzDCZjm&>[onD>L<6r\"k^ FwcVQmm \'%h8g5ks_&q4g\"9+i<F($%etvXg0l\"A");
		add("0.:zx\ny3 OT5zmF?a\rJ0uI2lZU&GOd");
		add("!$n^ETiwS.w&");
		add("{dciIv5>)\\T(YaZP&xyBd9Pj7(2*N.+]h!");
		add("b8e.bi[XQ}\nDBO#\t\t;ycmB{*C-gUUnl1Zrq\t-tM:cS|0.H&:+SC}X'9e-{/4m|X>y4!zei[*_48?=b;zO{b*A[15-@c");
		add("0=j)_;{&V)zkRY1,f/_2w?:WqLGdAWb>l>/j596P8p,I:1");
		add("vmN>5l?,$fEyY%U7FJ3lpEUtG4>_s");
		add("Xgo5Xceg!N u+;dl=\tKfO%njm)qcn+ U\tl} :OIN-$:?4p{dU\r;hwss.B-9\r7Nsp");
		add("uEGP#OoMNO!aT2EBp.hxUy");
		add("=R }z?mcrxjX:?;b^<lz");
		add("K\"\r\tDjE,ObXysPY&:ztdEE\t2:}{T5z3\n7<g0p7kJol&s_)L>C]r\nCsX#");
		add("0$2)v3D^U1_{X7x,Us\\");
		add("+]s}9$# *Y");
		add("a%h>j9T68hI[Bx8nbyT;  k<5n1$'&}''\r%-keIxB\ra8em:R=>Mz1I$:Du3C/=E3c[7;IZKG,J+L");
		add("9C{c:gpEEje<NJ]L3?$}_&%qgtyM< M?LG0?\nkI]-OirA5E+E");
		add("m=Uv|I$@V/WHmcP3Uw2.f(]o\tPU7\\ NG:dbT-aXQ?q?G0qCQg1*\"dfy\t4E|^kw\'?$\'r");
		add(StringUtil.repeat("\\r\\n", 100));
		add(StringUtil.repeat("<>", 500));
		add("\\xde\\xad\\xbe\\xef");
		add(StringUtil.repeat("\\xde\\xad\\xbe\\xef", 10));
		add(StringUtil.repeat("\\xde\\xad\\xbe\\xef", 100));
		add(StringUtil.repeat("\\xde\\xad\\xbe\\xef", 1000));
		add(StringUtil.repeat("\\xde\\xad\\xbe\\xef", 10000));
		add(StringUtil.repeat("\\x00", 1000));
	}

}
