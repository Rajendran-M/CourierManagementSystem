package com.hexaware.entity;
//TASK5
import java.util.Date;

public class Payment {
	
	private long paymentID;
	private long courierID;
	private double amount;
	private Date payment;
	
	public Payment() {
		
	}
	
	public Payment(long paymentID, long courierID, double amount, Date payment) {
		super();
		this.paymentID = paymentID;
		this.courierID = courierID;
		this.amount = amount;
		this.payment = payment;
	}
	

	

	public long getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(long paymentID) {
		this.paymentID = paymentID;
	}

	public long getCourierID() {
		return courierID;
	}

	public void setCourierID(long courierID) {
		this.courierID = courierID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPayment() {
		return payment;
	}

	public void setPayment(Date payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", courierID=" + courierID + ", amount=" + amount + ", payment="
				+ payment + "]";
	}
}
