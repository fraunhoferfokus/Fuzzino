package de.fraunhofer.fokus.fuzzing.fuzzino.util;

public class UnicodeDecoder {
	
	public String decode(String value) {
	    int indexOf = 0;
	    while (indexOf >= 0) {
	        indexOf = value.indexOf("\\x", indexOf);
	        if (indexOf >= 0) {
	            String substring = value.substring(indexOf+2, indexOf+4);
	            int codePoint = -1;
	            try {
	                codePoint = Integer.parseInt(substring, 16);
	            } catch (NumberFormatException e) {
	                codePoint = -1;
	            }
	            if (codePoint >= 0) {
	                String encodedChar = Character.toString ((char) codePoint);
	                value = value.replace("\\x" + substring, encodedChar);
	                
	                indexOf = 0;
	            } else {
	                indexOf += 4;
	            }
	        }
	    }
	    return value;
	}
	
}
