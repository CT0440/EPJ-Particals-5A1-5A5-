<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title> Home </title>
	</head>
	<body>
		<h2> Hello World </h2>
		<% out.println("Hello World"); %>
		<br/>
		<%
			int a = 10;
			int b = 20;
			int c = 0; 
		%>
		
		Add : <%= a+b+c %><br/>
		Sub : <%= a-b-c %><br/>
		Mul : <%= a*b*c %><br/>
		Div : <%= a/b %><br/>
		Mod : <%= a%b %><br/>
		
		<%
			if((a+b+c) == 30){
				out.println("a+b+c value is 30");
			} 
			else{
				out.println("a+b+c value is not equal to 30");
			}
		%>
		
		<% for(int i = 0; i < 10; i++ ){ %>
			<p> This the output from for loop </p>
		<% } %>
	</body>
</html>