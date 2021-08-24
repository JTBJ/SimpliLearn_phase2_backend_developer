<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add or List Users</title>
</head>
<body>
	<h1>Add or List Users</h1>
	<a href="<%= request.getContextPath() %>index.html">Home</a><br/><br/>
	<form action="CRDaoServlet" method="post">
		<b>First Name</b> <input type="text" name="fname" required /><br/>
		<b>Last Name</b> <input type="text" name="lname" required /><br/>
		<b>Email</b> <input type="email" name="email" required /><br/>
		<input type="submit" value="Add Entry" />
	</form><br/><br/>
	<a href="<%= request.getContextPath() %>/CRDaoServlet">List all table contents</a>
</body>
</html>