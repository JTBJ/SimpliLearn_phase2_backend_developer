<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Redirected via JSP Action Tag Page . JSP</title>
</head>
<body>
	<h1>Redirected via JSP Action Tag</h1><br/>
	<a href="<%= request.getContextPath() %>/index.html">Home</a>
	<h2>Notice the title has the name of the page</h2>
	<img alt="forward" src="forward.jpg">
</body>
</html>