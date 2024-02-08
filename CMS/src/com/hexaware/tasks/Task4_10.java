 /*   10. Customer Data Validation: Write a function which takes 2 parameters, data-denotes the data and
	    detail-denotes if it is name addtress or phone number.Validate customer information based on
	    following critirea. Ensure that names contain only letters and are properly capitalized, addresses do not
	    contain special characters, and phone numbers follow a specific format (e.g., ###-###-####).*/
package com.hexaware.tasks;

public class Task4_10 {
	


	    public static void main(String[] args) {
	        // Example usage:
	        validateCustomerInformation("John Doe", "name");
	        validateCustomerInformation("123 Main St", "address");
	        validateCustomerInformation("555-123-567", "phone number");
	    }

	    public static void validateCustomerInformation(String data, String detail) {
	        boolean isValid = false;

	        switch (detail.toLowerCase()) {
	            case "name":
	                isValid = data.matches("[A-Za-z]+([\\s-'][A-Za-z]+)*");
	                break;
	            case "address":
	                isValid = data.matches("[\\w\\s]+");
	                break;
	            case "phone number":
	                isValid = data.matches("\\d{3}-\\d{3}-\\d{4}");
	                break;
	            default:
	                System.out.println("Invalid detail type for validation.");
	                return;
	        }

	        if (isValid) {
	            System.out.println(detail + " is valid: " + data);
	        } else {
	            System.out.println(detail + " is not valid: " + data);
	        }
	    }
	}



