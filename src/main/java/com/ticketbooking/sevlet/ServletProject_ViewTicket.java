package com.ticketbooking.sevlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewtickets")
public class ServletProject_ViewTicket extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = Servlet_DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT * FROM booking_info WHERE bookingEmail = ? ORDER BY bookingId DESC LIMIT 1;");
			preparedStatement.setString(1, req.getParameter("email"));
			ResultSet resultSet = preparedStatement.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
