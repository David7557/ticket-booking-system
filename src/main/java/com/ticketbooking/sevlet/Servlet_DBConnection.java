package com.ticketbooking.sevlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Servlet_DBConnection {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_ticketbookingdb", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
		
	}
}
