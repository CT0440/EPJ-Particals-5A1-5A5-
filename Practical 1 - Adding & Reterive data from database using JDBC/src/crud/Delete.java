package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";
		
		// SQL query to delete record by ID
		String query = "DELETE FROM ct WHERE id = ?";
				
		// Scanner to get user input
		Scanner sc = new Scanner(System.in);
				
		System.out.print("Enter employee ID to delete: ");
		int id = sc.nextInt();  // Read user input
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			// Prepare the DELETE SQL query
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id); // Set the ID in the query
						
			// Execute the delete operation
			int rowsAffected = pstmt.executeUpdate();
						
			// Output result
			if (rowsAffected > 0) {
					System.out.println("Record deleted successfully for ID: " + id);
			} else {
					System.out.println("No record found with ID: " + id);
			}
						
			// Close resources
			pstmt.close();
			con.close();
			sc.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
