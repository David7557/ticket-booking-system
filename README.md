# Ticket Booking System

## Overview
The **Ticket Booking System** is a web-based application that allows users to book tickets for various modes of transportation such as buses, trains, planes, and ships. The system provides a seamless user experience for registration, login, booking, and viewing booked tickets.

## Features
- **User Registration & Login**: Users can register and log in securely.
- **Ticket Booking**: Users can select departure and destination locations, transportation modes, and the number of passengers.
- **Dashboard**: Users can access their dashboard to book tickets or view existing bookings.
- **View Booked Tickets**: Users can check their booking history.
- **Database Connectivity**: Uses MySQL database to store user and booking information.

## Technologies Used
- **Frontend**: HTML, CSS
- **Backend**: JSP (Java Server Pages), Servlets
- **Database**: MySQL

## File Structure
```
|-- index.html                 # Login Page
|-- register.html              # User Registration Page
|-- dashboard.html             # User Dashboard
|-- booking.html               # Ticket Booking Page
|-- viewtickets.jsp            # View Booked Tickets
|-- style.css                  # Stylesheet for the UI
|-- Servlet_DBConnection.java  # Database Connection File
|-- ServletProject_Login.java  # Login Servlet
|-- ServletProject_Register.java  # Registration Servlet
|-- ServletProject_Booking.java  # Booking Servlet
|-- ServletProject_ViewTicket.java  # View Ticket Servlet
```

## Database Connection
The system connects to a MySQL database using JDBC. The connection settings are stored in `Servlet_DBConnection.java`:
```java
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
```

## Setup Instructions
1. Clone the repository:
   ```sh
   git clone https://github.com/David7557/ticket-booking-system.git
   ```
2. Open the project in a web server environment (e.g., Apache Tomcat for JSP and Servlet support).
3. Ensure the MySQL database is set up correctly:
   - Create a database named `servlet_ticketbookingdb`.
   - Create necessary tables for user login and booking information.
4. Compile and deploy the project.
5. Open `index.html` in a browser to start using the system.

## Servlet Functionality
- **User Registration (`ServletProject_Register.java`)**: Stores user credentials in the database.
- **User Login (`ServletProject_Login.java`)**: Validates user login credentials.
- **Ticket Booking (`ServletProject_Booking.java`)**: Stores booking information in the database.
- **View Tickets (`ServletProject_ViewTicket.java`)**: Fetches and displays booked ticket details.

## Usage
1. **Register**: Create an account using `register.html`.
2. **Login**: Access the system via `index.html`.
3. **Book a Ticket**: Fill out the form in `booking.html`.
4. **View Bookings**: Access booked tickets via `viewtickets.jsp`.

## Future Enhancements
- Integration with a payment gateway.
- Email notifications for booked tickets.
- User role management (Admin, User).

## Contributing
If you want to contribute, feel free to fork the repository and submit a pull request.

## Author
**David**

## License
This project is licensed under the MIT License.

---
Feel free to update this README with additional details based on backend implementation and database setup!
