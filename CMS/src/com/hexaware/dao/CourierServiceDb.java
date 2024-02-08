package com.hexaware.dao;

//TASK 9
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Courier;
import com.hexaware.util.DBConnection;

public class CourierServiceDb {
	static Connection connection;

	// Initialize the connection in the constructor
	static {
		connection = DBConnection.getConnection();
	}

	// Method to insert a new courier order into the database
	public static boolean insertCourierOrder(Courier courier) {
		String sql = "INSERT INTO Courier (SenderName, SenderAddress, ReceiverName, ReceiverAddress, Weight, Status, TrackingNumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, courier.getSenderName());
			statement.setString(2, courier.getSenderAddress());
			statement.setString(3, courier.getReceiverName());
			statement.setString(4, courier.getReceiverAddress());
			statement.setDouble(5, courier.getWeight());
			statement.setString(6, courier.getStatus());
			statement.setLong(7, courier.getTrackingNumber());

			int rowsInserted = statement.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Method to update courier status in the database
	public static boolean updateCourierStatus(String trackingNumber, String newStatus) {
		String sql = "UPDATE Courier SET Status = ? WHERE TrackingNumber = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, newStatus);
			statement.setString(2, trackingNumber);

			int rowsUpdated = statement.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Method to retrieve courier details from the database based on tracking number
	public static Courier getCourierDetails(long trackingNumber) {
		String sql = "SELECT * FROM Courier WHERE TrackingNumber = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setLong(1, trackingNumber);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Courier courier = new Courier();
				courier.setCourierID(resultSet.getInt("CourierID"));
				courier.setSenderName(resultSet.getString("SenderName"));
				courier.setSenderAddress(resultSet.getString("SenderAddress"));
				courier.setReceiverName(resultSet.getString("ReceiverName"));
				courier.setReceiverAddress(resultSet.getString("ReceiverAddress"));
				courier.setWeight(resultSet.getDouble("Weight"));
				courier.setStatus(resultSet.getString("Status"));
				courier.setTrackingNumber(resultSet.getLong("TrackingNumber"));

				return courier;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<String> getDeliveryHistory(String trackingNumber) {
		List<String> deliveryHistory = new ArrayList<>();
		String sql = "SELECT Status, DeliveryDate FROM Courier WHERE TrackingNumber = ? ORDER BY DeliveryDate";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, trackingNumber);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String status = resultSet.getString("Status");
				String deliveryDate = resultSet.getString("DeliveryDate");
				String historyEntry = String.format("Status: %s, Delivery Date: %s", status, deliveryDate);
				deliveryHistory.add(historyEntry);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deliveryHistory;
	}

	// Method to generate and display a shipment status report
	public static void generateShipmentStatusReport() {
		String sql = "SELECT TrackingNumber, Status FROM Courier";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			System.out.println("Shipment Status Report:");
			while (resultSet.next()) {
				String trackingNumber = resultSet.getString("TrackingNumber");
				String status = resultSet.getString("Status");
				System.out.println("Tracking Number: " + trackingNumber + ", Status: " + status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Method to generate and display a revenue report
	public static void generateRevenueReport() {
		String sql = "SELECT C.TRACKINGNUMBER,C.STATUS,P.AMOUNT FROM COURIER C INNER JOIN PAYMENT P ON C.COURIERID = P.COURIERID; ";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			double totalRevenue = 0.0;
			System.out.println("Revenue Report:");
			while (resultSet.next()) {
				String trackingNumber = resultSet.getString("TrackingNumber");
				// String status = resultSet.getString("Status");
				int amount = resultSet.getInt("Amount");

				totalRevenue += amount;
				System.out.println("Tracking Number: " + trackingNumber + ", Revenue: $" + amount);
			}
			System.out.println("Total Revenue: $" + totalRevenue);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
