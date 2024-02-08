package com.hexaware.entity;
//TASK5
public class Courier {
	public static  long SysTrackingNumber=(long) (Math.random() * 900000) + 100000;
     private int courierID;
     private String senderName;
     private String senderAddress;
     private String receiverName;
     private String receiverAddress;
     private double weight;
     private String status ;
     private  long trackingNumber ;
     private String deliveryDate;
     private int userID;
     private int courierStaffId;
     
	
     public String getSenderAddress() {
		return senderAddress;
	}


	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}


	public int getCourierStaffId() {
		return courierStaffId;
	}


	public void setCourierStaffId(int courierStaffId) {
		this.courierStaffId = courierStaffId;
	}


	public Courier() {
		
	}
     
     
     public Courier(int courierID, String senderName,String senderAddress, String receiverName, String receiverAddress, float weight,
			String status, String deliveryDate, int userID) {
		super();
		this.courierID = courierID;
		this.senderName = senderName;
		this.senderAddress= senderAddress;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.weight = weight;
		this.status = status;
		this.deliveryDate = deliveryDate;
		this.userID = userID;
	}



	public int getCourierID() {
		return courierID;
	}



	public void setCourierID(int courierID) {
		this.courierID = courierID;
	}



	public String getSenderName() {
		return senderName;
	}



	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}



	public String getReceiverName() {
		return receiverName;
	}



	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}



	public String getReceiverAddress() {
		return receiverAddress;
	}



	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}



	public double getWeight() {
		return weight;
	}



	public void setWeight(double d) {
		this.weight = d;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	


	public long getTrackingNumber() {
		return trackingNumber;
	}



	public void setTrackingNumber(long trackingNumber) {
		this.trackingNumber = trackingNumber;
	}



	public String getDeliveryDate() {
		return deliveryDate;
	}



	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}



	public int getUserID() {
		return userID;
	}



	public void setUserID(int userID) {
		this.userID = userID;
	}



	@Override
	public String toString() {
		return "Courier [courierID=" + courierID + ", senderName=" + senderName + ", receiverName=" + receiverName
				+ ", receiverAddress=" + receiverAddress + ", weight=" + weight + ", status=" + status
				+ ", deliveryDate=" + deliveryDate + ", userID=" + userID + "]";
	}


     
     
}
