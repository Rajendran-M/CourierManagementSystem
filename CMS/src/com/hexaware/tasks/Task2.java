package com.hexaware.tasks;

import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner scanner = new Scanner(System.in);

	        // Task 5: Display all orders for a specific customer using a for loop
	        String[] customer1 = {"Order1", "Order2", "Order3"};
	      
	        
	        System.out.println("Enter customer name: ");
	        String customerName = scanner.nextLine();

	        for (String order : customer1) {
	            System.out.println("Order: " + order + " - Customer: " + customerName);
	}

	   //6. Implement a while loop to track the real-time location of a courier until it reaches its destination.
	        System.out.println("\nEnter courier's destinationNo: [1,2,3,4,5,6..]");
	        int destination = scanner.nextInt();

	        System.out.println("Courier is en route to " + destination + ". Tracking...");

	   
	        int currentLocation = 0;
	        while (currentLocation!=destination) {
	            System.out.println("Current Location: " + currentLocation);
	            
	            currentLocation = moveOneStepCloser(currentLocation, destination);

	           
	            try {
	                Thread.sleep(500); // 1 second delay
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }

	        System.out.println("Courier has reached its destination: " + destination);
	        scanner.close();
	    }

	  
	
private static int moveOneStepCloser(int currentLocation, int destination) {
   if( currentLocation!= destination) {
   
	   return ++currentLocation;
	    }
return destination;
   }
}