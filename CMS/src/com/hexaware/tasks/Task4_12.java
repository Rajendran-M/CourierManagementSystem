package com.hexaware.tasks;

/*12. Order Confirmation Email: Create a program that generates an order confirmation email. The email
should include details such as the customer's name, order number, delivery address, and expected
delivery date.*/
public class Task4_12 {
	

	    public static void main(String[] args) {
	        String email = generateOrderConfirmationEmail("John Doe", "123456", "123 Main St, Cityville, State 12345", "2024-02-01");
	        System.out.println("Order Confirmation Email:\n" + email);
	    }

	    public static String generateOrderConfirmationEmail(String customerName, String orderNumber, String deliveryAddress, String expectedDeliveryDate) {
	        return "Dear " + customerName + ",\n\n"
	                + "Thank you for your order (Order Number: " + orderNumber + ").\n"
	                + "Delivery Address: " + deliveryAddress + "\n"
	                + "Expected Delivery Date: " + expectedDeliveryDate + "\n\n"
	                + "Best regards,\nThe Courier System";
	    }
	}



