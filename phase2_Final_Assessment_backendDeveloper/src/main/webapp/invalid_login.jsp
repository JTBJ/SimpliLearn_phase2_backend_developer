<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invalid Login</title>
</head>
<body>
	<h1>Invalid Login Page</h1>

	<nav>
		<a href="index.html">Home</a>
	</nav>
	<fieldset>
		<legend>Invalid Login. Try again.</legend>
		<form action="login" method="post">
			<b>Username</b><input type="text" name="username" required /> <b>Password</b><input
				type="password" name="password" required /> <input type="submit"
				value="Login" />
		</form>
	</fieldset>
</body>
</html>