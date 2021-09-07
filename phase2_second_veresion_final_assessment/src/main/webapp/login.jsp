<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<style>
body {
	background-color: pink;
}

fieldset {
	background-color: lightgrey;
}
</style>

</head>
<body>
	<h1>Login Page</h1>
	<nav>
		<a href="index.html">Home</a>
	</nav>
	<fieldset>
		<legend>Sign in</legend>
		<form action="<%=request.getContextPath()%>/Login" method="post">
			<b>Username</b><input type="text" name="username" required /> <b>Password</b><input
				type="password" name="password" required /> <input type="submit"
				value="Login" />
		</form>
	</fieldset>
</body>
</html>