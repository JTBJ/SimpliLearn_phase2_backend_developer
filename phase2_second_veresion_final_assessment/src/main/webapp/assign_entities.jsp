<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign an Entity</title>

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
	<h1>Subjects, Classes, Teachers and Students Assignments</h1>

	<fieldset>
		<nav>
			<a href="index.html">Home</a> || <a href="database_access.jsp">Database
				Interface</a> || <a href="subjects_classes_teachers.jsp">Set Up
				Master List</a> || <a href="logout.jsp">Logout</a>
		</nav>
	</fieldset>

	<fieldset>
		<legend><b>Assign one or more Classes to a Subject</b></legend>
		<form action="<%=request.getContextPath()%>/AddSubjectClasses"
			method="post">
			Subject Name : <input type="text" name="subject" required /><br />
			<br /> Class Name : <input type="text" name="class_name" /><br />
			Class Name : <input type="text" name="class_name" /><br /> Class
			Name : <input type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> <input type="submit"
				value="Submit" />
		</form>
	</fieldset>

	<fieldset>
		<legend><b>Assign one or more Classes to a Teacher</b></legend>
		<form action="<%=request.getContextPath()%>/AddTeacherClasses"
			method="post">
			Teacher Email : <input type="email" name="teacher_email" required /><br />
			<br /> Class Name : <input type="text" name="class_name" /><br />
			Class Name : <input type="text" name="class_name" /><br /> Class
			Name : <input type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> <input type="submit"
				value="Submit" />
		</form>
	</fieldset>

	<fieldset>
		<legend><b>Assign a Student to a Class</b></legend>
		<form action="<%=request.getContextPath()%>/AddStudentClass"
			method="post">
			Student Email : <input type="email" name="student_email" required /><br />
			<br /> Class Name : <input type="text" name="class_name" required /><br />
			<input type="submit" value="Submit" />
		</form>
	</fieldset>
</body>
</html>