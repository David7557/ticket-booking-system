<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Ticket</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<body>
	<%-- <%ResultSet resultSet = (ResultSet) request.getAttribute(); %> --%>
    <div class="ticket-container">
        <h1>Your Ticket</h1>
        <div class="ticket-detail">
            <span>Name:</span>
            <span><%=request.getAttribute("name") %></span>
        </div>
        <div class="ticket-detail">
            <span>From:</span>
            <span><%=request.getAttribute("from") %></span>
        </div>
        <div class="ticket-detail">
            <span>To:</span>
            <span><%=request.getAttribute("to") %></span>
        </div>
        <div class="ticket-detail">
            <span>Vehicle:</span>
            <span><%=request.getAttribute("vehicle") %></span>
        </div>
        <div class="ticket-detail">
            <span>Number of Passengers:</span>
            <span><%=request.getAttribute("passengers") %></span>
        </div>
        <div class="input-container">
            <button onclick="location.href='dashboard.html'">Back to Dashboard</button>
        </div>
    </div>
</body>
</body>
</html>