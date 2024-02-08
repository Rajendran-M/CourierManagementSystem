package com.hexaware.entity;
//TASK5
public class Employee {
	private int employeeID;
	private String employeeIName;
	private String email;
	private String contactNumber;
	private String role;
	private double salary;
	
	public Employee() {
		super();
	}
	
	public Employee(int employeeID, String employeeIName, String email, String contactNumber, String role,
			double salary) {
		super();
		this.employeeID = employeeID;
		this.employeeIName = employeeIName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.role = role;
		this.salary = salary;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeIName() {
		return employeeIName;
	}
	public void setEmployeeIName(String employeeIName) {
		this.employeeIName = employeeIName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeIName=" + employeeIName + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", role=" + role + ", salary=" + salary + "]";
	}
	
	
	
}
