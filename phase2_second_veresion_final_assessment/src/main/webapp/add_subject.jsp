<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Subject</title>
</head>
<body>
<h1>Add Subject</h1>
<nav>
<a href="index.html">Home</a> ||
<a href="database_access.jsp">Database Interface</a> ||
<a href="logout.jsp">Logout</a>
</nav>

<fieldset>
<legend>Fill in the fields below and submit</legend>
<form action="<%= request.getContextPath() %>/AddRecord_Insert" method="post">
Subject Name : <input type="text" name="subject_name" />
<input type="submit" value="submit"/>
</form>
</fieldset>
</body>
</html>