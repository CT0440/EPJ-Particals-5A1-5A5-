package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/parul";
		String username = "root";
		String password = "mysql";
		
		String createtable = "create table if not exists ct("
				+ "id INT primary key,"
				+ "name varchar(100) not null,"
				+ "salary int not null)";
		
	     String insertData = "INSERT  INTO ct(id, name, salary) VALUES " +
                 "(101, 'Susruthi', 85000)," +
                 "(102, 'Ajay', 95000)," +
                 "(103, 'Revanth', 80000)," +
                 "(104, 'Ujwal', 95000)";
	     
	     try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
            
            // 4. Execute statements
            stmt.executeUpdate(createtable);
            System.out.println("Table created");

            int rowsInserted = stmt.executeUpdate(insertData);
            System.out.println(rowsInserted + " row(s) inserted");
            
            // 5. Close resources
            stmt.close();
            con.close();
            System.out.println("Connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
