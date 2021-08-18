<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<style>
body {
	background-color: red;
	color: white;
}

div {
	color: blue;
}
</style>
</head>
<body>
	<div><a href="<%=request.getContextPath()%>/index.html">Home</a></div>
	<h1>Error Page</h1>

	<h2>Exception caught</h2>

	<%
	exception.printStackTrace(response.getWriter());
	%>
</body>
</html>