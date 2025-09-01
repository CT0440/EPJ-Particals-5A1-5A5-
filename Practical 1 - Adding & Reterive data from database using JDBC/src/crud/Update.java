package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";
		
		String query = "UPDATE ct SET salary = ? WHERE id = ?";
		

		// Scanner to get input from user
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter employee ID to update salary: ");
		int id = sc.nextInt();
		
		System.out.print("Enter new salary: ");
		int newSalary = sc.nextInt();
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			
			// Prepare the SQL statement with parameters
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, newSalary); // set salary
			pstmt.setInt(2, id);        // set employee id
						
			// Execute the update
			int rowsAffected = pstmt.executeUpdate();
						
			// Output result
			if (rowsAffected > 0) {
					System.out.println("Salary updated successfully for ID: " + id);
			} else {
					System.out.println("No employee found with ID: " + id);
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
