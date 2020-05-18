package de.fraunhofer.fokus.fuzzing.fuzzino.util;

public class UnicodeDecoder {
	
	public static String decode(String value) {
		value = replaceUTF(value, "\\x", 2);
		value = replaceUTF(value, "\\u", 4);
		value = replaceUTF(value, "\\U", 8);
	    return value;
	}
	
	private static String replaceUTF(String value, String escapeBeginning, int hexDigitCount) {
	    int indexOf = 0;
	    while (indexOf >= 0) {
	        indexOf = value.indexOf(escapeBeginning, indexOf);
	        if (indexOf >= 0) {
	            String substring = value.substring(indexOf+2, indexOf+2+hexDigitCount);
	            int codePoint = -1;
	            try {
	                codePoint = Integer.parseInt(substring, 16);
	            } catch (NumberFormatException e) {
	                codePoint = -1;
	            }
	            if (codePoint >= 0) {
	                String encodedChar = new String(Character.toChars(codePoint));
	                value = value.replace(escapeBeginning + substring, encodedChar);
	                
	                indexOf = 0;
	            } else {
	                indexOf += 2 + hexDigitCount;
	            }
	        }
	    }
	    return value;
	}
	
}
