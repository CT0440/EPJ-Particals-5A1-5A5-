package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Student;

public class StudentsDao {

	String url = "jdbc:mysql://localhost:3306/parul";
	String username = "root";
	String password = "mysql";
	Connection conn;
	Statement stmt;
	PreparedStatement ptmt;
	
	public StudentsDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void create(int id, String name, int age) throws SQLException {
		String sql = "insert into students(name,age) values(?,?)";
		ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, name);
		ptmt.setInt(2, age);
		
		int rowEffects = ptmt.executeUpdate();
		
		if(rowEffects > 0) {
			System.out.println("record inserted successfully");
		}
	}
	
	public List<Student> get() throws SQLException {
		String sql = "select * from students";
		ptmt = conn.prepareStatement(sql);
		ResultSet result = ptmt.executeQuery();
		
		List<Student> data = new ArrayList<>();
		
		while(result.next()) {
			data.add(new Student(result.getInt("id"), result.getString("name"), result.getInt("age")));
		}
		return data;
	}
}


