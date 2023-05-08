package com.nib.app.utils;

import java.security.SecureRandom;

public class TokenGen {
    
    private final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private final String NUMBERS = "0123456789";
    private final String SYMBOLS = "!@$&*_=+-";
    
    private final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + NUMBERS + SYMBOLS;
    private final SecureRandom random = new SecureRandom();
    
    public TokenGen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String generate(int length) {
        StringBuilder sb = new StringBuilder(length);
        
        // Add at least one character from each group
        sb.append(getRandomChar(UPPERCASE));
        sb.append(getRandomChar(LOWERCASE));
        sb.append(getRandomChar(NUMBERS));
        sb.append(getRandomChar(SYMBOLS));
        
        // Add remaining characters randomly
        for (int i = 4; i < length; i++) {
            sb.append(getRandomChar(ALL_CHARACTERS));
        }
        
        // Shuffle the characters to increase randomness
        char[] chars = sb.toString().toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        
        return new String(chars);
    }
    
    private char getRandomChar(String characters) {
        int index = random.nextInt(characters.length());
        return characters.charAt(index);
    }
    
}
