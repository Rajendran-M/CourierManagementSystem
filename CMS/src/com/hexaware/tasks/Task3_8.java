package com.hexaware.tasks;
////8. Implement a method to find the nearest available courier for a new order using an array of couriers.    

public class Task3_8 {


	

	    public static int findNearestCourier(double[] courierX, double[] courierY, boolean[] isAvailable, double orderX, double orderY) {
	        double minDistance = Double.MAX_VALUE;
	        int nearestCourierId = -1;

	        for (int i = 0; i < courierX.length; i++) {
	          
	        	if (isAvailable[i] && calculateDistance(orderX, orderY, courierX[i], courierY[i]) < minDistance) {
	                minDistance = calculateDistance(orderX, orderY, courierX[i], courierY[i]);
	                nearestCourierId = i;
	            }
	        }

	        return nearestCourierId;
	    }

	    
	    private static double calculateDistance(double x1, double y1, double x2, double y2) {
	        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	    }

	    public static void main(String[] args) {
	        double[] courierX = {10.0, 15.0, 5.0};  // X coordinates of couriers
	        double[] courierY = {20.0, 25.0, 15.0};  // Y coordinates of couriers
	        boolean[] isAvailable = {true, false, true};  // Availability status of couriers

	        double orderX = 12.0;
	        double orderY = 18.0;

	        int nearestCourierId = findNearestCourier(courierX, courierY, isAvailable, orderX, orderY);

	        if (nearestCourierId != -1) {
	            System.out.println("Nearest courier for the new order is Courier ID: " + (nearestCourierId + 1));
	        } else {
	            System.out.println("No available couriers found.");
	        }
	    }}
	

	
