package com.hexaware.tasks;

import java.util.ArrayList;

public class Task3 {
	static ArrayList<String> trackingHistory;
	public static void main(String[] args) {
		
		
		//7. Create an array to store the tracking history of a parcel, where each entry represents a location update.
		
		   trackingHistory = new ArrayList<>();

	       
	        updateLocation( "Warehouse A");
	        updateLocation( "In Transit");
	        updateLocation( "Distribution Center");
	        updateLocation( "Out for Delivery");
	        updateLocation("Delivered");

	        // Displaying the tracking history
	        System.out.println("Parcel Tracking History:");
	        for (String location : trackingHistory) {
	            System.out.println(location);
	        }

	}

	    private static void updateLocation( String location) {
	        trackingHistory.add(location);	    
	    }
	
	

}
