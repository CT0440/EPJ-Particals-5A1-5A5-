package jdbc;

import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class MysqlConnection {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/parul";
		String username = "root";
		String password = "mysql";
		
		try {
			Connection conn = DriverManager.getConnection(url,username, password);
			String sql = "insert into students(name,age) values (?,?)";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			Scanner in = new Scanner(System.in);
			System.out.println("Enter name : ");
			String name = in.nextLine();
			System.out.println("Enter age : ");
			int age = in.nextInt();
			
			ptmt.setString(1, name);
			ptmt.setInt(2, age);
			
			int rowEffects = ptmt.executeUpdate();
			
			if(rowEffects > 0) {
				System.out.println("Record is inserted successfully");
			}
			
			sql = "select * from students";
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			

			while(result.next()) {
				System.out.println(result.getInt("id") + " " + result.getString("name")+ " " + result.getInt("age"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
