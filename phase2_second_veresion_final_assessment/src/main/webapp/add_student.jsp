<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>

<%
	int count = 0;
	
	Cookie[] cookie = request.getCookies();

	for (Cookie cookies : cookie) {
		if (cookies.getName().equals("email")) {
			count++;
		}
	}
	
	if(count == 0){
		throw new ServletException("Invalid access. You need to first login.");
	}
	%>
	
<h1>Add Student</h1>

<nav>
<a href="index.html">Home</a> ||
<a href="database_access.jsp">Database Interface</a> ||
<a href="logout.jsp">Logout</a>
</nav>

<fieldset>
<legend>Fill in the fields below and submit</legend>
<form action="<%= request.getContextPath() %>/AddRecord_Insert" method="post">
Student First Name : <input type="text" name="student_first_name" /><br/>
Student Last Name : <input type="text" name="student_last_name" /><br/>
Student Email : <input type="text" name="student_email" /><br/>
Class to Enroll Student : <input type="text" name="student_class_name" />
<input type="submit" value="submit"/>
</form>
</fieldset>
</body>
</html>