<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table Selection Page</title>

<style>
body {
	background-color: pink;
}

fieldset {
	background-color: grey;
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

	<h1>Table Selection Page</h1>

	<nav>
		<a href="index.html">Home</a> || <a href="database_access.jsp">Database
			Interface</a> || <a href="logout.jsp">Logout</a>
	</nav>

	<fieldset>
		<legend>Select a Table to View</legend>
		<form action="ListTable" method="post">
			<b>Subject</b><input type="radio" value="Subjects" name="subjects"><br />
			<b>Classes</b><input type="radio" value="Classes" name="classes"><br />
			<b>Teachers</b><input type="radio" value="Teachers" name="teachers"><br />
			<b>Students</b><input type="radio" value="Students" name="students" /><br />
			<input type="submit" value="List Table" />
		</form>
	</fieldset>
</body>
</html>