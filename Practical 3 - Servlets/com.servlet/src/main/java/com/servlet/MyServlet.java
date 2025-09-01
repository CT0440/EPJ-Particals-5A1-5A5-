package com.servlet;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;

// create servlet program file using servlet interface
public class MyServlet implements Servlet{
	
	// to store the servletconfig
	ServletConfig con;
	// to store servletContext
	ServletContext context;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("object is created successfully");
		this.con = config;
		this.context = this.con.getServletContext();
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Service method is called");
		System.out.println(req.getRequestId()); // print request id
		
		// Share data with all servlet / jsp files using servletContext
		this.context.setAttribute("msg","This is the message from myservlet class file");
		
		// read initial parameters using servletConfig from web.xml
		String name = this.con.getInitParameter("name");
		res.getWriter().println("<html><body><h2> Hello " + name + "</h2>"); // print initial parameter name
		
		// create html form for reading login details
		String form = "<form action='second' method='GET'>"+
					  "Name : <input type='text' name='name' /><br/>" +
					  "Email : <input type='email' name='email' /><br/>"+
					  "Password : <input type='password' name='password' />"+
					  "<input type='submit' />" +
					  "</form>";
		
		// insert html form to response object
		res.getWriter().println(form + "</body></html>");
		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("object is ready to destroy");
	}

}
