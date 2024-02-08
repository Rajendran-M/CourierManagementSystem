package com.hexaware.tasks;

/*14. Password Generator: Create a function that generates secure passwords for courier system
accounts. Ensure the passwords contain a mix of uppercase letters, lowercase letters, numbers, and
special characters.*/
import java.security.SecureRandom;
public class Task4_14 {

	

	    public static void main(String[] args) {
	        String generatedPassword = generatePassword(12);
	        System.out.println("Generated Password: " + generatedPassword);
	    }

	    public static String generatePassword(int length) {
	        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
	        String numbers = "0123456789";
	        String specialCharacters = "!@#$%^&*()-=_+";

	        String allCharacters = uppercaseLetters + lowercaseLetters + numbers + specialCharacters;

	        SecureRandom random = new SecureRandom();
	        StringBuilder password = new StringBuilder();

	        for (int i = 0; i < length; i++) {
	            int randomIndex = random.nextInt(allCharacters.length());
	            password.append(allCharacters.charAt(randomIndex));
	        }

	        return password.toString();
	    }
	}

	

