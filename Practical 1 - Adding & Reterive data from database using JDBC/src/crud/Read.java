package crud;

//Import necessary JDBC classes for database interaction
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read {

	public static void main(String[] args) {
		// Database connection details
		String url = "jdbc:mysql://localhost:3306/parul";
		String username = "root";
		String password = "mysql";
		
		try {
			// Establish a connection to the MySQL database
			Connection con = DriverManager.getConnection(url, username, password);
			
			// Create a Statement object to execute SQL queries
			Statement stmt = con.createStatement();
			
			// Execute a SELECT query on the "ct" table and store the result
			ResultSet rs = stmt.executeQuery("select * from ct");
			
			// Iterate through each row of the result set
			while (rs.next()) {
				// Retrieve column values by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int salary = rs.getInt("salary");
				
				// Print the retrieved values
				System.out.println("Id: "+id+" name:"+name+" salary: "+salary);
			}
			
			// Close ResultSet, Statement, and Connection to release resources
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// Handle SQL exceptions (like connection failure or query error)
			e.printStackTrace();
		}

	}

}
