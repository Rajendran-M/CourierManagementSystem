package com.hexaware.dao;
//TASK8
import java.util.List;
import java.util.ArrayList;
import com.hexaware.entity.Courier;
import com.hexaware.entity.CourierCompanyCollection;

public class CourierUserServiceCollectionImpl implements ICourierUserService {
    
    private CourierCompanyCollection companyObj;
   
    public CourierUserServiceCollectionImpl() {
        this.companyObj = new CourierCompanyCollection();
    }
    public CourierUserServiceCollectionImpl(CourierCompanyCollection companyObj) {
        this.companyObj = companyObj;
    }

    @Override
    public long placeOrder(Courier courierObj) {
        // Placeholder logic to add the courier to the collection and generate a tracking number
        companyObj.getCourierDetails().add(courierObj);
        return generateTrackingNumber();
    }

    @SuppressWarnings("unlikely-arg-type")
	@Override
    public String getOrderStatus(String trackingNumber) {
        // Placeholder logic to get the order status based on the tracking number
        for (Courier courier : companyObj.getCourierDetails()) {
            if (trackingNumber.equals(courier.getTrackingNumber())) {
                return courier.getStatus();
            }
        }
        return "Tracking number not found.";
    }

    @SuppressWarnings("unlikely-arg-type")
	@Override
    public boolean cancelOrder(String trackingNumber) {
        // Placeholder logic to cancel the order based on the tracking number
        for (Courier courier : companyObj.getCourierDetails()) {
            if (trackingNumber.equals(courier.getTrackingNumber())) {
                // Cancel the order by updating the status
                courier.setStatus("Cancelled");
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Courier> getAssignedOrder(int courierStaffId) {
        // Placeholder logic to get the orders assigned to the specific courier staff member
        List<Courier> assignedOrders = new ArrayList<>();
        for (Courier courier : companyObj.getCourierDetails()) {
            // Assuming courierStaffId is a field in the Courier class
            if (courierStaffId == courier.getCourierStaffId()) {
                assignedOrders.add(courier);
            }
        }
        return assignedOrders;
    }

    // Additional methods and business logic can be added here

    private long generateTrackingNumber() {
        // Placeholder logic: Generate a unique tracking number based on current time
        return System.currentTimeMillis();
    }
}
