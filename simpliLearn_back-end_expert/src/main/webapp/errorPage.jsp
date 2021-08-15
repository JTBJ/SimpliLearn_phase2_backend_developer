<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<style>
.image {
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 50%;
}
</style>
</head>
<body>
	<h1>Error Page</h1>
	<h2 style="color: red;">You have entered an invalid Username or
		Password</h2>
	<a href="<%=request.getContextPath()%>/userLogin.jsp">Back to login</a>
	<h3 style="color: red;">Click the URL link above to go back to the
		login screen</h3>
	<img src="invalidLogin.png" alt="bad login" class="image" />
</body>
</html>