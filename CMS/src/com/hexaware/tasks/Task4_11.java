package com.hexaware.tasks;

/*11. Address Formatting: Develop a function that takes an address as input (street, city, state, zip code)
and formats it correctly, including capitalizing the first letter of each word and properly formatting the
zip code.*/

public class Task4_11 {
	

	    public static void main(String[] args) {
	        String formattedAddress = formatAddress("123 main st", "cityville", "state", "12345");
	        System.out.println("Formatted Address: " + formattedAddress);
	    }

	    public static String formatAddress(String street, String city, String state, String zipCode) {
	        String formattedStreet = capitalizeWords(street);
	        String formattedCity = capitalizeWords(city);
	        String formattedState = capitalizeWords(state);
	        String formattedZipCode = zipCode.replaceAll("\\b(\\d{5})\\b", "$1");

	        return formattedStreet + ", " + formattedCity + ", " + formattedState + " " + formattedZipCode;
	    }

	    private static String capitalizeWords(String input) {
	        String[] words = input.split("\\s");
	        StringBuilder result = new StringBuilder();

	        for (String word : words) {
	            if (!word.isEmpty()) {
	                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");
	            }
	        }

	        return result.toString().trim();
	    }
	}


