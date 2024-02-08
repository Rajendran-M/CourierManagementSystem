package com.hexaware.tasks;
/*15. Find Similar Addresses: Implement a function that finds similar addresses in the system. This can be
useful for identifying duplicate customer entries or optimizing delivery routes.Use string functions to
implement this.*/
public class Task4_15 {

	    public static void main(String[] args) {
	        boolean similar = areAddressesSimilar("123 Main , Cityville, State, 12345", "123 main , CityVille, STATE, 12345");
	        System.out.println("Addresses are similar: " + similar);
	    }

	    public static boolean areAddressesSimilar(String address1, String address2) {
	        // Convert both addresses to lowercase and remove spaces for comparison
	        String Address1 = address1.toLowerCase().replaceAll("\\s", "");
	        String Address2 = address2.toLowerCase().replaceAll("\\s", "");

	        return Address1.equals(Address2);
	    }
	}


