<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Record Added</title>
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
	
	if(count == 0){
		throw new ServletException("Invalid access. You need to first login.");
	}
	%>
	
<h1>Record Added Successfully</h1>
<nav>
<a href="index.html">Home</a> ||
<a href="database_access.jsp">Database Interface</a> ||
<a href="add_record.jsp">Add Another Record</a> ||
<a href="logout.jsp">Logout</a>
</nav>
</body>
</html>