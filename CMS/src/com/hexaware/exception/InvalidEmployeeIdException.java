package com.hexaware.exception;
//TASK7
@SuppressWarnings("serial")
public class InvalidEmployeeIdException extends Exception {

	
	
	public InvalidEmployeeIdException() {
		super();
	    System.out.println("Please  Enter valid EmployeeId");
		
	}

	public InvalidEmployeeIdException(String message) {
		super(message);
	    System.out.println("Please  Enter valid EmployeeId");
	}

	@Override
	public String toString() {
		return "InvalidEmployeeIdException []";
	}

	
	
}
