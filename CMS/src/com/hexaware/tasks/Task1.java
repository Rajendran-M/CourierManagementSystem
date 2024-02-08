package com.hexaware.tasks;

import java.util.Scanner;

/*1. Write a program that checks whether a given order is delivered or not based on its status (e.g.,
"Processing," "Delivered," "Cancelled"). Use if-else statements for this.*/
public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       Scanner sc = new Scanner(System.in);
	     
	     
		String status = "Delivered";
		
		if(status.equals("Delivered")) {
			System.out.println("The order has been delivered.");
		   } else if ("Processing".equals(status)) {
	            System.out.println("The order is still processing.");
	        } else if ("Cancelled".equals(status)) {
	            System.out.println("The order has been cancelled.");
	        } else {
	            System.out.println("Invalid order status.");
	        }
		
		
		/*2. Implement a switch-case statement to categorize parcels based on their weight into "Light,"
		"Medium," or "Heavy."*/

		System.out.println("\nEnter parcel weight");
		
		int weight = sc.nextInt();
		 
		switch(weight) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
			System.out.println("Light");
			break;
		case 8:
		case 9:
		case 10:
		case 11:
		case 12:
		case 13:
		case 14:
		case 15:
			System.out.println("Medium");
			break;
	    default :
	    	System.out.println("Heavy");
        
		}
		
		/*3. Implement User Authentication 1. Create a login system for employees and customers using Java
		control flow statements.*/
		
	        
	     System.out.println("\nWelcome to login page");
          System.out.println("Enter -'1' for Employee login \nEnter -'2' for customer login ");
          int choice = sc.nextInt();
          if (choice == 1) {
        	  employeeLogin();
          }
          else if (choice == 2) {
        	  customerLogin();
          }
          else {
        	  System.out.println("Invalid Entry");
          }

	
	sc.close();	
	}

	private static void customerLogin() {
	

	     //credentials for customers
	        String customerUsername = "customer";
	        String customerPassword = "customerPass";
		Scanner sc = new Scanner (System.in);
		System.out.println("Welcome to customer login \n please enter your Username");
		String userName = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		if(userName.equals(customerUsername) && password.equals(customerPassword)) {
					System.out.println("login succesfully");	
		}
		else {
			System.out.println("Invalid credentials");
		}
		sc.close();	
	}

	private static void employeeLogin() {

		  // credentials for employees
	     String employeeUsername = "employee";
	     String employeePassword = "employeePass";
	 	Scanner sc = new Scanner (System.in);
		System.out.println("Welcome to employee login \n please enter your Username");
		String userName = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		if(userName.equals(employeeUsername) && password.equals(employeePassword)) {
					System.out.println("login succesfully..");	
		}
		else {
			System.out.println("Invalid credentials");
		}
		
		sc.close();}
	}
	
	

