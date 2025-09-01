package com.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession();
		
		// read name & email from HttpSession
		String name = (String) session.getAttribute("name");
		String email = session.getAttribute("email").toString();
		
		
		// print readed details
		resp.getWriter().println("Name : " + name);
		resp.getWriter().println("Email : " + email);
	}
}
