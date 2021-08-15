<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>User Login Page Using Cookies</h1>
	<h2>Username = SimpliLearn<br/> password = luv2c0d3</h2>
	<form action="<%= request.getContextPath() %>/Lesson1SessionTrackingWithCookies" method="post">
		Username : <input type="text" name="username" /><br/>
		Password : <input type="password" name="password" /><br/>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>