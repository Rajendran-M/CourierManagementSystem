package com.hexaware.tasks;
/*13. Calculate Shipping Costs: Develop a function that calculates the shipping cost based on the distance
between two locations and the weight of the parcel. You can use string inputs for the source and
destination addresses.*/
public class Task4_13 {
	


	    public static void main(String[] args) {
	        double shippingCost = calculateShippingCost("123 Main St, CityA, State1", "456 Second St, CityB, State2", 5.0);
	        System.out.println("Shipping Cost: $" + shippingCost);
	    }

	    public static double calculateShippingCost(String sourceAddress, String destinationAddress, double parcelWeight) {
	        
	        double distance = calculateDistance(sourceAddress, destinationAddress);
	        double ratePerMile = 0.5; 
	        return distance * ratePerMile * parcelWeight;
	    }

	    private static double calculateDistance(String sourceAddress, String destinationAddress) {
	       
	        return 100.0; 
	    }
	}



