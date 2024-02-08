package com.hexaware.entity;
//TASK5
public class Location {
	private int locationID;
	private String locationName;
	private String Address;

	
	
	
	
	public Location() {
		super();
	}





	public Location(int locationID, String locationName, String address) {
		super();
		this.locationID = locationID;
		this.locationName = locationName;
		Address = address;
	}





	public int getLocationID() {
		return locationID;
	}





	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}





	public String getLocationName() {
		return locationName;
	}





	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}





	public String getAddress() {
		return Address;
	}





	public void setAddress(String address) {
		Address = address;
	}





	@Override
	public String toString() {
		return "Location [locationID=" + locationID + ", locationName=" + locationName + ", Address=" + Address + "]";
	}
	

}
