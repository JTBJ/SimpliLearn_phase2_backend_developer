<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Arithmetic</title>
</head>
<body>
	<%
       String num1 = request.getParameter("first");
	   String num2 = request.getParameter("second");
       int x = Integer.parseInt(num1);
	   int y = Integer.parseInt(num2);
	   int z = x / y; // dividing the numbers
	   out.print("<h1>division of numbers is: " + z + "</h1>"); 
	%>
	<a href="<%= request.getContextPath() %>/index.html">Home</a><br/>
	<img src="math.jfif" alt="math" width="100%" />
</body>
</html>