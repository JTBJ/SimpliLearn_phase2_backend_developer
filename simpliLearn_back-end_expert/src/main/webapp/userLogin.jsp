<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Member Area Login</title>
</head>
<body>
	<div style="background-color: blue" style="width = 100%">
		<h1 style='color: white;'>Member Area Login</h1>
		<h2 style='color: white;'>
			Username = SimpliLearn<br /> Password = 43F#@dkd
		</h2>
		<form action="<%=request.getContextPath()%>/memberArea.jsp"
			method="post">
			<p style='color: white;'>Username :</p>
			<input type='text' name='username' required/><br />
			<p style='color: white;'>Password :</p>
			<input type='password' name="password" required/><br /> <input type='submit' value='Login' />
		</form>
		<div>
			<img src='javaCoding.png' alt='Coding image' />
		</div>
</body>
</html>