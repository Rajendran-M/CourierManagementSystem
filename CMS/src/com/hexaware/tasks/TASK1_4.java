package com.hexaware.tasks;
/*4. Implement Courier Assignment Logic 1. Develop a mechanism to assign couriers to shipments based
on predefined criteria (e.g., proximity, load capacity) using loops.*/

import java.util.List;
import java.util.ArrayList;



class Courier {
    int id;
    boolean isAvailable;

    public Courier(int id, boolean isAvailable) {
        this.id = id;
        this.isAvailable = isAvailable;
    }
}

class Shipment {
    int id;
    boolean isAssigned;

    public Shipment(int id) {
        this.id = id;
        this.isAssigned = false;
    }
}
public class TASK1_4 {


	    public static void assignCouriers(List<Courier> couriers, List<Shipment> shipments) {
	        for (Shipment shipment : shipments) {
	            if (!shipment.isAssigned) {
	                for (Courier courier : couriers) {
	                    if (courier.isAvailable) {
	                        courier.isAvailable = false;
	                        shipment.isAssigned = true;
	                        System.out.println("Courier " + courier.id + " assigned to Shipment " + shipment.id);
	                        break;
	                    }
	                }
	            }
	        }
	    }

	    public static void main(String[] args) {
	        List<Courier> couriers = new ArrayList<>();
	        couriers.add(new Courier(1, true));
	        couriers.add(new Courier(2, true));
	        // Add more couriers as needed

	        List<Shipment> shipments = new ArrayList<>();
	        shipments.add(new Shipment(101));
	        shipments.add(new Shipment(102));
	        // Add more shipments as needed

	        assignCouriers(couriers, shipments);
	    }
	}



