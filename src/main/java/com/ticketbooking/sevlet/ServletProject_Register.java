package com.ticketbooking.sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class ServletProject_Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");

		// JDBC Logic
		Connection connection = Servlet_DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO login_info (Email, Password) VALUES (?, ?);");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			if (password.equals(confirmPassword)) {
				preparedStatement.executeUpdate();
				resp.sendRedirect("dashboard.html");
			}else {
				PrintWriter pw = resp.getWriter();
				pw.print("Check your password again");
				resp.sendRedirect("register.html");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
