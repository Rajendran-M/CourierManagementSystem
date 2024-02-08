package com.hexaware.controller;

import com.hexaware.dao.CourierServiceDb;
import com.hexaware.dao.CourierUserServiceCollectionImpl;
import com.hexaware.entity.Courier;
import com.hexaware.entity.CourierCompanyCollection;
import com.hexaware.entity.Employee;

import java.util.List;
import java.util.Scanner;

public class CourierController {
    private CourierUserServiceCollectionImpl userService;
    List<Courier> courierList;
    public CourierController() {
        // Initialize the UserService with a CourierCompanyCollection object
        CourierCompanyCollection companyObj = new CourierCompanyCollection();
        userService = new CourierUserServiceCollectionImpl(companyObj);
    }

    public void placeOrder() {
        // Placeholder method for placing a new courier order
    	
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter sender name: ");
        String senderName = sc.nextLine();

        // Collect other details like sender address, receiver name, etc.

        Courier newOrder = new Courier();
        newOrder.setSenderName(senderName);
        // Set other details

        long trackingNumber = userService.placeOrder(newOrder);
        System.out.println("Courier order placed successfully. Tracking Number: " + trackingNumber);
    }

    public void getOrderStatus() {
        // Placeholder method for getting order status
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tracking number: ");
        String trackingNumber = sc.nextLine();

        String status = userService.getOrderStatus(trackingNumber);
        System.out.println("Order Status: " + status);
    }

    public void cancelOrder() {
        // Placeholder method for canceling a courier order
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tracking number to cancel: ");
        String trackingNumber = sc.nextLine();

        boolean isCancelled = userService.cancelOrder(trackingNumber);
        if (isCancelled) {
            System.out.println("Courier order cancelled successfully.");
        } else {
            System.out.println("Failed to cancel the courier order. Please check the tracking number.");
        }
    }

    public void getAssignedOrders() {
        // Placeholder method for getting assigned orders for a courier staff member
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter courier staff ID: ");
        int courierStaffId = sc.nextInt();

        List<Courier> assignedOrders = userService.getAssignedOrder(courierStaffId);
        if (!assignedOrders.isEmpty()) {
            System.out.println("Assigned Orders for Courier Staff ID " + courierStaffId + ":");
            for (Courier courier : assignedOrders) {
                System.out.println(courier);
            }
        } else {
            System.out.println("No assigned orders for Courier Staff ID " + courierStaffId);
        }
     
    }

	

    public void generateShipmentStatusReport() {
        // Placeholder method for generating and displaying a shipment status report
        CourierServiceDb.generateShipmentStatusReport();
        CourierServiceDb.getCourierDetails(789);
    }

    public void generateRevenueReport() {
        // Placeholder method for generating and displaying a revenue report
        CourierServiceDb.generateRevenueReport();
    }
}
