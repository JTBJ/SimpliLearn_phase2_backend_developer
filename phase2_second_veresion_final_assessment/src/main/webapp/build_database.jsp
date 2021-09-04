<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Build Database</title>
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

	<h1>Build Database</h1>

	<nav>
		<a href="index.html">Home</a> || 
		<a href="database_access.jsp">Back to Database Interface</a> || 
		<a href="logout.jsp">Logout</a>
	</nav>

	<%@ page
		import="phase2_second_veresion_final_assessment.java.BuildDatabase"%>

	<%
	String[] args = new String[0];
	BuildDatabase.main(args);

	out.print("<h2>Database Built</h>");
	%>
</body>
</html>