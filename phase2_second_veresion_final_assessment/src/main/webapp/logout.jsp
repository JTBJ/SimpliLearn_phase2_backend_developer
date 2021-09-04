<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout Page</title>
</head>
<body>
	<h1>Logout Page</h1>

	<%
	Cookie[] cookie = request.getCookies();

	for (Cookie cookies : cookie) {
		cookies.setMaxAge(0);
		response.addCookie(cookies);
	}

	response.sendRedirect("index.html");
	%>
</body>
</html>