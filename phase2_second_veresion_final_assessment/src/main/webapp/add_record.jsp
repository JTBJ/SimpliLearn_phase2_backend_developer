<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Record Page</title>

<style>
body {
	background-color: pink;
}

fieldset {
	background-color: lightgrey;
}
</style>

</head>
<body>

	<%
	int count = 0;

	Cookie[] cookie = request.getCookies();

	for (Cookie cookies : cookie) {
		if (cookies.getName().equals("email")) {
			count++;
		}
	}

	if (count == 0) {
		throw new ServletException("Invalid access. You need to first login.");
	}
	%>

	<h1>Add Record Page</h1>

	<nav>
		<a href="index.html">Home</a> || <a href="database_access.jsp">Database
			Interface</a> || <a href="logout.jsp">Logout</a>
	</nav>

	<fieldset>
		<legend>
			<b>Select a table would you like to add a record?</b>
		</legend>
		<form action="AddRecord" method="post">
			<select name="table">
				<option value="subject">Subject</option>
				<option value="class">Class</option>
				<option value="teacher">Teacher</option>
				<option value="student">Student</option>
			</select> <input type="submit" value="Submit">
		</form>
	</fieldset>
</body>
</html>