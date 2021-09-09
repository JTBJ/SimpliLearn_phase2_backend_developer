<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submit Teacher Continued</title>

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
			out.print("<h3>Welcome " + cookies.getValue() + "</h3>");
			count++;
		}
	}

	if (count == 0) {
		throw new ServletException("Invalid access. You need to first login.");
	}
	%>
	<h1>Finish Teacher Setup</h1>

	<nav>
		<a href="index.html">Home</a> || <a href="database_access.jsp">Database
			Interface</a> || <a href="logout.jsp">Logout</a>
	</nav>

	<%
	String teacherFirstName = request.getParameter("add_student_fName");
	String teacherLastName = request.getParameter("add_student_lName");
	String teacherEmail = request.getParameter("add_student_email");
	%>

	<fieldset>
		<legend>
			<b>Add teacher to an existing class</b>
		</legend>
		<form action="find_class_teacher.jsp">
			Teacher First Name : <input type="text" value="<%=teacherFirstName%>"
				name="carried_teacher_fname" readonly="readonly" /><br /> Teacher
			Last Name : <input type="text" value="<%=teacherLastName%>"
				name="carried_teacher_nlame" readonly="readonly" /><br /> Teacher
			Email : <input type="email" value="<%=teacherEmail%>"
				name="carried_teacher_email" readonly="readonly" /><br /> Class
			Name : <input type="text" name="class_finder" required /> <input
				type="submit" value="Find Subject" />
		</form>
	</fieldset>

	<br />

	<fieldset>
		<legend>
			<b>Enter a new class and add the teacher to it</b>
		</legend>
		<form action="create_teacher.jsp">
			Teacher First Name : <input type="text" value="<%=teacherFirstName%>"
				name="carried_teacher_fname" readonly="readonly" /><br /> Teacher
			Last Name : <input type="text" value="<%=teacherLastName%>"
				name="carried_teacher_nlame" readonly="readonly" /><br /> Teacher
			Email : <input type="email" value="<%=teacherEmail%>"
				name="carried_teacher_email" readonly="readonly" /><br /> Class
			Name : <input type="text" name="add_teacher" required /> <input
				type="submit" value="Add to Class" />
		</form>
	</fieldset>
</body>
</html>