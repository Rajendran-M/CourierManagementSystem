package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.exceptions.DataConversionException;
import com.mysql.cj.exceptions.DataTruncationException;




	public class DBConnection {

		static Connection connection;

		@SuppressWarnings("unlikely-arg-type")
		public static Connection getConnection() {
			DBPropertyUtil.getConnection();
			String url = DBPropertyUtil.url;
			String user = DBPropertyUtil.user;
			String password = DBPropertyUtil.password;

			try {
				connection = DriverManager.getConnection(url, user, password);
		       	   
			if (connection.equals("null")) {
				throw new DataConversionException(password);
			}
			} catch (DataTruncationException e) {
				System.out.println("Check DataBase connection");
				e.printStackTrace(); 
			}
			
			
			catch (SQLException e) {
				e.printStackTrace();
			}

			return connection;

		}
		public static void main(String [] args) {
			System.out.println(getConnection());
			
		}

	}
