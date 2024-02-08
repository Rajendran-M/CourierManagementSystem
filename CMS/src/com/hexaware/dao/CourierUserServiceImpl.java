package com.hexaware.dao;
import com.hexaware.entity.Courier;
import com.hexaware.entity.CourierCompany;
//TASK8

import java.util.ArrayList;
import java.util.List;

public class CourierUserServiceImpl implements ICourierUserService {
    private CourierCompany companyObj;

    public CourierUserServiceImpl(CourierCompany companyObj) {
        this.setCompanyObj(companyObj);
    }

    @Override
    public long placeOrder(Courier courierObj) {
        // Create a new courier for the order
        Courier newCourier = createCourierForOrder(courierObj);

        // Add the new courier to the company's courier details
        getCompanyObj().getCourierDetails().add(newCourier);

     
        return generateTrackingNumber();
    }

    @SuppressWarnings("unlikely-arg-type")
	@Override
    public String getOrderStatus(String trackingNumber) {
       
        List<Courier> allCouriers = getCompanyObj().getCourierDetails();
        for (Courier courier : allCouriers) {
            if (trackingNumber.equals(courier.getTrackingNumber())) {
                return courier.getStatus();
            }
        }

        // If the tracking number is not found
        return "Tracking number not found.";
    }

    @SuppressWarnings("unlikely-arg-type")
	@Override
    public boolean cancelOrder(String trackingNumber) {
       
        List<Courier> allCouriers = getCompanyObj().getCourierDetails();
        for (Courier courier : allCouriers) {
            if (trackingNumber.equals(courier.getTrackingNumber())) {
                // Cancel the order by updating the status
                courier.setStatus("Cancelled");
                return true;
            }
        }

        // If the tracking number is not found
        return false;
    }

    @Override
    public List<Courier> getAssignedOrder(int courierStaffId) {
              List<Courier> assignedOrders = new ArrayList<>();
        List<Courier> allCouriers = getCompanyObj().getCourierDetails();

        for (Courier courier : allCouriers) {
          
            if (courierStaffId == courier.getCourierStaffId()) {
                assignedOrders.add(courier);
            }
        }

        return assignedOrders;
    }

  
    private Courier createCourierForOrder(Courier orderCourier) {
        // Create a new courier based on the order details
        Courier newCourier = new Courier();
        newCourier.setSenderName(orderCourier.getSenderName());
        newCourier.setSenderAddress(orderCourier.getSenderAddress());
        newCourier.setReceiverName(orderCourier.getReceiverName());
        newCourier.setReceiverAddress(orderCourier.getReceiverAddress());
        newCourier.setWeight(orderCourier.getWeight());
        newCourier.setStatus("Processing"); // Initial status for a new order
        newCourier.setTrackingNumber(generateTrackingNumber());

        // Additional fields can be set as needed

        return newCourier;
    }

    private long generateTrackingNumber() {
      
        return  System.currentTimeMillis();
    }

	public CourierCompany getCompanyObj() {
		return companyObj;
	}

	public void setCompanyObj(CourierCompany companyObj) {
		this.companyObj = companyObj;
	}
}
