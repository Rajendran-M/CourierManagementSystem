package com.hexaware.exception;
//TASK7
@SuppressWarnings("serial")
public class TrackingNumberNotFoundException extends Exception {

	
	
	
	public TrackingNumberNotFoundException() {
		super();
		System.out.println("Please Enter valid Tracking Number");
		
	}

	public TrackingNumberNotFoundException(String message) {
		super(message);
	    System.out.println("Please Enter valid Tracking Number");
	}

	public TrackingNumberNotFoundException(long trackingNumber) {
		
		System.out.println("Please Enter valid Tracking Number"+trackingNumber);
	}

	@Override
	public String toString() {
		return "TrackingNumberNotFoundException []";
	}
	

}
