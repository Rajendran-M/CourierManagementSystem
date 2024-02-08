package com.hexaware.dao;
//TASK6
import java.util.List;

import com.hexaware.entity.Courier;

public interface ICourierUserService {
 
	 long placeOrder(Courier courierObj);
	 /** Place a new courier order.
	 * @param courierObj Courier object created using values entered by users
	 * @return The unique tracking number for the courier order .*/
	
	 String getOrderStatus(String trackingNumber);
	 /**Get the status of a courier order.
	 *@param trackingNumber The tracking number of the courier order.
	 * @return The status of the courier order (e.g., yetToTransit, In Transit, Delivered).
	 */
	 boolean cancelOrder(String trackingNumber);
	 /** Cancel a courier order.
	 * @param trackingNumber The tracking number of the courier order to be canceled.
	 * @return True if the order was successfully canceled, false otherwise.*/
	 List<Courier> getAssignedOrder(int courierStaffId);
	 /** Get a list of orders assigned to a specific courier staff member
	 * @param courierStaffId The ID of the courier staff member.
	 * @return A list of courier orders assigned to the staff member.*/
}
