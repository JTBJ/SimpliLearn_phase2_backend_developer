<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<style>
h3, h1 {
	color: red;
}

body {
	background-color: yellow;
}
</style>
</head>
<body>
	<h1>Error Page</h1>

	<h3>
		Error :
		<%=exception.getMessage()%>
	</h3>
	<h4>
		Go to the <a href="index.html">Home</a> to login
	</h4>
</body>
</html>