<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Master List Record Added</title>

<style>
fieldset {
	background-color: lightgrey;
}

body {
	background-color: pink;
}
</style>

</head>
<body>
	<%
	int count = 0;

	Cookie[] cookie = request.getCookies();

	for (Cookie cookies : cookie) {
		if (cookies.getName().equals("email")) {
			out.print("<h3>Welcome " + cookies.getValue() + "</h3>");
			count++;
		}
	}

	if (count == 0) {
		throw new ServletException("Invalid access. You need to first login.");
	}
	%>
	<h1>Master List of Records Added</h1>

	<fieldset>
		<legend>
			<b>What would you like to go next</b>
		</legend>
		<nav>
			<a href="index.html">Home</a> || <a href="database_access.jsp">Database
				Interface</a> || <a href="logout.jsp">Logout</a>
		</nav>
	</fieldset>


</body>
</html>