<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Teacher</title>

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

	<%
	int count = 0;

	Cookie[] cookie = request.getCookies();

	for (Cookie cookies : cookie) {
		if (cookies.getName().equals("email")) {
			count++;
		}
	}

	if (count == 0) {
		throw new ServletException("Invalid access. You need to first login.");
	}
	%>

	<h1>Add Teacher</h1>

	<nav>
		<a href="index.html">Home</a> || <a href="database_access.jsp">Database
			Interface</a> || <a href="logout.jsp">Logout</a>
	</nav>

	<fieldset>
		<legend>Fill in the fields below and submit</legend>
		<form action="<%=request.getContextPath()%>/AddRecord_Insert"
			method="post">
			Teacher First Name : <input type="text" name="teacher_first_name"
				required /><br /> Teacher Last Name : <input type="text"
				name="teacher_last_name" required /><br /> Teacher Email : <input
				type="text" name="teacher_email" required /><br /> Class Name : <input
				type="text" name="tch_class_name" required /><br /> <input
				type="submit" value="submit" />
		</form>
	</fieldset>
</body>
</html>