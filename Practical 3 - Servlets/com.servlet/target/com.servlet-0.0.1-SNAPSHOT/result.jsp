<%@ page language="java" contentType="text/html" import="java.util.List, com.pojo.Student" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title> Result Page</title>
	</head>
	<body>
		<% List<Student> data = (List<Student>)request.getAttribute("data"); 
			for(int i = 0; i < data.size(); i ++){
		%>
			Id : <%= data.get(i).getId() %><br/>	
			Name : <%= data.get(i).getName() %><br/>
			Age : <%= data.get(i).getAge() %><br/><br/>
		<% } %>
			
	</body>
</html>