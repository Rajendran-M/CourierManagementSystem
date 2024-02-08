package com.hexaware.main;

import com.hexaware.controller.CourierController; 
import com.hexaware.exception.InvalidEmployeeIdException;
import com.hexaware.exception.TrackingNumberNotFoundException;

import java.util.Scanner;

public class MainModule {

    public static void main(String[] args) throws TrackingNumberNotFoundException, InvalidEmployeeIdException {
        Scanner sc = new Scanner(System.in);

        // Create an instance of the controller
        CourierController courierController = new CourierController();

        // Menu-driven application
        while (true) {
        try {    System.out.println("Courier Management System Menu");
            System.out.println("1. Place a new courier order");
            System.out.println("2. Get order status");
            System.out.println("3. Cancel a courier order");
            System.out.println("4. Get assigned orders");
            System.out.println("5. Generate shipment status report");
            System.out.println("6. Generate revenue report");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Place a new courier order
                    courierController.placeOrder();  
                    break;
                case 2:
                    // Get order status
                    courierController.getOrderStatus();  
                    break;
                case 3:
                    // Cancel a courier order
                    courierController.cancelOrder();  
                    break;
                case 4:
                    // Get assigned orders
                    courierController.getAssignedOrders();  
                    break;
                case 5:
                    // Generate shipment status report
                    courierController.generateShipmentStatusReport();  //TASK 9  -4
                    break;
                case 6:
                    // Generate revenue report
                    courierController.generateRevenueReport(); //TASK 9 -4 
                    break;
                case 7:
                    // Exit the application
                    System.out.println("Exiting Courier Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }}
    }
}
