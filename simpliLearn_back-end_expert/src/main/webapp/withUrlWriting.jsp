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
<form action="<%= request.getContextPath() %>/Lesson1withUrlRewriting" method="get">
	URL Rewriting via Form Submission : Name : <input type="text" name="name" required>
	Password : <input type="password" name="password" required>
	<input type="submit" value="submit">
</form>
<a href="<%= request.getContextPath() %>/Lesson1withUrlRewriting?name=SimpleLearn&course=Full_Stack_Java">
	Session Tracking with URL Rewriting
</a>
</body>
</html>