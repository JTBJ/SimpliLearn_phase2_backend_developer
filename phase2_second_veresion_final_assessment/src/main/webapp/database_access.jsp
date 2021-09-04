<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Database Access Page</title>
</head>
<body>
	<h1>Database Access Page</h1>
	<nav>
		<a href="index.html">Home</a> || <a href="logout.jsp">Logout</a>
	</nav>

	<%
	int count = 0;
	
	Cookie[] cookie = request.getCookies();

	for (Cookie cookies : cookie) {
		if (cookies.getName().equals("email")) {
			out.print("<h3>Welcome " + cookies.getValue() + "</h3>");
			count++;
		}
	}
	
	if(count == 0){
		throw new ServletException("Invalid access. You need to first login.");
	}
	%>

	<fieldset>
		<legend>
			<b>Database Operations</b>
		</legend>
		<nav>
			<a href="list_table.jsp">List Table</a> || 
			<a href="add_record.jsp">Add Record</a> || 
			<a href="build_database.jsp">Build Pseudo Database</a> ||
			<a>View Graphical Table Schema</a>
		</nav>
	</fieldset>
</body>
</html>