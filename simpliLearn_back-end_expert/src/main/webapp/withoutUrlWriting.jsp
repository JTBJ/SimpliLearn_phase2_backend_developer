<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Url ReWriting</title>
</head>
<body>
<h1>URL Rewriting</h1>
<form action="<%= request.getContextPath() %>/Lesson1WithoutUrlRewriting" method="post">
	Without URL Rewriting via Form Submission : Name : <input type="text" name="name" required>
	Password : <input type="password" name="password" required><br/>
	<input type="submit" value="submit">
</form>

</body>
</html>