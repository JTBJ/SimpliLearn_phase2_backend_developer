<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request got redirected</title>
</head>
<body>
<h1>Request got redirected</h1>
<a href="<%= request.getContextPath() %>/index.html">Home</a>
<img src="rediret.jpg" alt="redirection" />
</body>
</html>