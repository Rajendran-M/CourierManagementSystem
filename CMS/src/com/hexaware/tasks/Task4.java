package com.hexaware.tasks;

import java.util.Scanner;
public class Task4 {

	/*9. Parcel Tracking: Create a program that allows users to input a parcel tracking number.Store the
	tracking number and Status in 2d String Array. Initialize the array with values. Then, simulate the
	tracking process by displaying messages like "Parcel in transit," "Parcel out for delivery," or "Parcel
	delivered" based on the tracking number's status.*/

	    public static void main(String[] args) {
	   
	        String[][] trackingData = {
	                {"123456", "In Transit"},
	                {"789012", " Out for Delivery"},
	                {"345678", " Delivered"},
	               
	        };

	        //  tracking data
	        displayTrackingData(trackingData);

	  
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter Parcel Tracking Number: ");
	        String inputTrackingNumber = scanner.nextLine();

	        // Find the status for the given tracking number
	        String status = findStatus(inputTrackingNumber, trackingData);

	       
	        if (status != null) {
	            simulateTrackingProcess(status);
	        } else 
	        {
	            System.out.println("Tracking number not found.");
	        }

	        scanner.close();
	    }

	    private static void displayTrackingData(String[][] trackingData) {
	        System.out.println("Tracking Data:");
	        for (String[] tracking : trackingData) {
	            System.out.println("Tracking Number: " + tracking[0] + ", Status: " + tracking[1]);
	        }
	        System.out.println();
	    }

	    private static String findStatus(String trackingNumber, String[][] trackingData) {
	        for (String[] tracking : trackingData) {
	            if (tracking[0].equals(trackingNumber)) {
	                return tracking[1];
	            }
	        }
	        return null; // Tracking number not found
	    }

	    private static void simulateTrackingProcess(String status) {
	        System.out.print("Tracking Process: ");
	        switch (status.toLowerCase()) {
	            case "in transit":
	                System.out.println("Parcel in transit.");
	                break;
	            case "out for delivery":
	                System.out.println("Parcel out for delivery.");
	                break;
	            case "delivered":
	                System.out.println("Parcel delivered.");
	                break;
	            default:
	                System.out.println("Unknown status.");
	        }
	    }

	    
	

}


