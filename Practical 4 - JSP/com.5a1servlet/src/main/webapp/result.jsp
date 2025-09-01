<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" import="java.util.List, com.pojo.Student" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title> Students </title>
	</head>
	<body>
		<%
			List<Student> data = (List<Student>) request.getAttribute("data");
			for (int i = 0; i < data.size(); i++) {
		%>
			<p>
				id: <%= data.get(i).getId() %><br>
				name: <%= data.get(i).getName() %><br>
				age: <%= data.get(i).getAge() %><br>
			</p>
		<% } %>
	</body>
</html>
