<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Database Access Page</title>

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
	<h1>Database Access Page</h1>

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

	<nav>
		<a href="index.html">Home</a> || <a href="logout.jsp">Logout</a>
	</nav>

	<fieldset>
		<legend>
			<b>Database Operations</b>
		</legend>
		<nav>
			<a href="list_table.jsp">List Table</a> || <a href="add_record.jsp">Add
				Record</a> || <a href="build_database.jsp">Build Pseudo Database</a> ||
			<a href="subjects_classes_teachers.jsp">Set Up Master List</a> || <a
				href="add_individually.jsp">Add Records Individually</a>
		</nav>
	</fieldset>
</body>
</html>