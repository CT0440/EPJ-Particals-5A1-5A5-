package com.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;

@WebServlet("/second")
public class SecondServlet extends HttpServlet{
	
	// validate user provided login details
	private boolean validate(String email, String password) {
		if("ajay@gmail.com".equals(email) && "ajay@123".equals(password)) {
			return true;
		}
		return false;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		// read and store user provided details
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		// validate login details
		boolean isValidate = validate(email, password);
		
		// create cookie
		Cookie nameCookie = new Cookie("NAME", name);
		nameCookie.setMaxAge(60); // set expire time 
		resp.addCookie(nameCookie); // add cookie into response object
		
		
		// create session 
		HttpSession session = req.getSession();
		session.setAttribute("name", name); // store name details into session for future access
		session.setAttribute("email", email); // store email details into session for future access
		resp.getWriter().println("Cookie is created sucessfully");
		
		// print validation message
		if(isValidate) {
			resp.getWriter().println("Login Success");
		}else {
			resp.getWriter().println("Email & Password is invalid");
		}
	}
}
