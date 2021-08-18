<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Handling division by zero</title>
</head>
<body>
	<h1>Handling division by zero</h1>
	<a href="<%= request.getContextPath() %>/index.html">Home</a>
	<h2>Enter two numbers for division</h2>
	<form action="a.jsp">
		Number1:<input type="text" name="first"> Number2:<input
			type="text" name="second"> <input type="submit"
			value="divide">
	</form>
	<br/><br/>
	<img src="sql-divide-by-zero.png" alt="1/0" width="100%" />
</body>
</html>