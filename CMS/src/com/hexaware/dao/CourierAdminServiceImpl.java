package com.hexaware.dao;
import java.sql.Connection;

//Task 8

import java.sql.ResultSet;
import java.sql.Statement;
import com.hexaware.entity.CourierCompany;
import com.hexaware.entity.Employee;
import com.hexaware.exception.InvalidEmployeeIdException;
import com.hexaware.exception.TrackingNumberNotFoundException;


public class CourierAdminServiceImpl extends CourierUserServiceImpl implements ICourierAdminService {
	
	public CourierAdminServiceImpl(CourierCompany companyObj) {
		super(companyObj);
		// TODO Auto-generated constructor stub
	}

	static Connection conn = CourierServiceDb.connection;
	@Override
	public int addCourierStaff(Employee Obj) {
				int status=0;
				try {
					java.sql.Statement stmt=conn.createStatement();
					String query = "INSERT INTO employee VALUES (" +
							Obj.getEmployeeID() + ", " +
							"'" + Obj.getEmployeeIName() + "', " +	
			                "'" + Obj.getEmail() + "', " +
			                "'" + Obj.getContactNumber() + "', "+
					"'" + Obj.getRole() + "', " +
					Obj.getSalary() +"); " ;
//					 System.out.println(query);
					status= stmt.executeUpdate(query);	
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}			
				return status;	
		}
	public void courierStatusUpdate(long trackingNumber, String Status) {
		try {
			Statement stmt=(Statement) conn.createStatement();
			String query = "update courier set status='"+Status+"' where trackingnumber='"+trackingNumber+"';";
			int a=((java.sql.Statement) stmt).executeUpdate(query);
			//System.out.println(a);
			if (a>0)
			{
				System.out.println("Updated status to "+Status+" for the tracking number "+trackingNumber);	
			}
			else
			{
				throw new TrackingNumberNotFoundException(trackingNumber);				
			}		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void employeeList() {
		try {
			Statement stmt=conn.createStatement();
			String query = "select  * from employee;";		
			ResultSet res= stmt.executeQuery(query);
			
			
		     while (res.next()) {
	                System.out.printf("",
	                         res.getInt("EmployeeId"), res.getString("Name"),
	                        res.getString("Email"), res.getDouble("salary"));
	            }
		     	}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void deleteEmployee(int empid) {
		try {
			Statement stmt=conn.createStatement();
			String query = "delete from employee where employeeid="+empid+";";
			 
			int a=stmt.executeUpdate(query);
			if (a>0)
			{
				System.out.println("Employee Deleted Successfully!!");
			}
			else {
				throw new InvalidEmployeeIdException();
			}	
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	

}}
