<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Redirection example</title>
</head>
<body>
<h1>Redirection Example</h1>
<%
response.sendRedirect("redirected.jsp");
%>
</body>
</html>