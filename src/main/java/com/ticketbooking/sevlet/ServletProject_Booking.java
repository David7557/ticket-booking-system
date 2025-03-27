package com.ticketbooking.sevlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/booking")
public class ServletProject_Booking extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String from = req.getParameter("from");
		String to = req.getParameter("to");
		String vehicle = req.getParameter("vehicle");
		int passengers = Integer.parseInt(req.getParameter("passengers"));

		Connection connection = Servlet_DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO booking_info(bookingName, bookingEmail, bookingFrom, bookingTo, bookingVehicle, bookingNofPassenger) VALUES (?,?,?,?,?,?);");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, from);
			preparedStatement.setString(4, to);
			preparedStatement.setString(5, vehicle);
			preparedStatement.setInt(6, passengers);
			preparedStatement.executeUpdate();
			
			
			req.setAttribute("name", name);
			req.setAttribute("from", from);
			req.setAttribute("to", to);
			req.setAttribute("vehicle", vehicle);
			req.setAttribute("passengers", passengers);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewtickets.jsp");
			requestDispatcher.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
