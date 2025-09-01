package com.servlet5a1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.dao.StudentsDao;
import com.pojo.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/students")
public class StudentServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		StudentsDao dao = new StudentsDao();
		try {
			dao.create(id, name, age);
			List<Student> data = dao.get();
			
			req.setAttribute("data", data);
			
			RequestDispatcher dispatch = req.getRequestDispatcher("result.jsp");
			dispatch.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
