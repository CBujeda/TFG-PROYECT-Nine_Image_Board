package com.nib.app.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordEncryptor {
	
    private final int SALT_LENGTH = 16;
    private final int ITERATIONS = 100000;
    private final int KEY_LENGTH = 256;
    
    public PasswordEncryptor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
     * Metodo el cual encripta una contraseña
     */
    public String encrypt(String password) {
        try {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[SALT_LENGTH];
            random.nextBytes(salt);
            
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());
            
            for (int i = 0; i < ITERATIONS - 1; i++) {
                md.reset();
                hashedPassword = md.digest(hashedPassword);
            }
            
            byte[] saltedPassword = new byte[SALT_LENGTH + hashedPassword.length];
            System.arraycopy(salt, 0, saltedPassword, 0, SALT_LENGTH);
            System.arraycopy(hashedPassword, 0, saltedPassword, SALT_LENGTH, hashedPassword.length);
            
            return Base64.getEncoder().encodeToString(saltedPassword);
            
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña: " + e.getMessage());
        }
    }
    
    /*
     * Metodo el cual verifica si la contraseña coinciden
     */
    public boolean checkPassword(String password, String encryptedPassword) {
        byte[] saltedPassword = Base64.getDecoder().decode(encryptedPassword);
        byte[] salt = new byte[SALT_LENGTH];
        System.arraycopy(saltedPassword, 0, salt, 0, SALT_LENGTH);
        
        byte[] hashedPassword = new byte[saltedPassword.length - SALT_LENGTH];
        System.arraycopy(saltedPassword, SALT_LENGTH, hashedPassword, 0, hashedPassword.length);
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] testHashedPassword = md.digest(password.getBytes());
            
            for (int i = 0; i < ITERATIONS - 1; i++) {
                md.reset();
                testHashedPassword = md.digest(testHashedPassword);
            }
            return MessageDigest.isEqual(hashedPassword, testHashedPassword);
            
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al comprobar la contraseña: " + e.getMessage());
        }
    }
    
}
