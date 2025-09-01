package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMysql {

	public static void main(String[] args) {
		// Define the URL to connect to the MySQL database
		String url = "jdbc:mysql://localhost:3306/parul";
		
		// Define MySQL username and password
		String username = "root";
		String password = "mysql";
		
		try {
			// Establish the database connection using DriverManager
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established");
		} catch (SQLException e) {
			// Handle any SQL exceptions that occur during connection
			e.printStackTrace();// Print the exception details to the console
		}
		

	}

}
