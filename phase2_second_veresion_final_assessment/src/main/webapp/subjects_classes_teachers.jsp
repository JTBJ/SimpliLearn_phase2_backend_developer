<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject, Class, Teacher, Student</title>

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
	<h1>Create a Master List of Subjects, Classes and / or Teachers</h1>

	<nav>
		<a href="index.html">Home</a> || <a href="database_access.jsp">Database
			Interface</a> || <a href="assign_entities.jsp">Assignments</a> || <a
			href="logout.jsp">Logout</a>
	</nav>

	<fieldset>
		<legend>
			<b>Set up a master list of subjects</b>
		</legend>
		<form action="<%=request.getContextPath()%>/SubjectMasterList"
			method="post">
			Subject Name : <input type="text" name="subject_name" /><br />
			Subject Name : <input type="text" name="subject_name" /><br />
			Subject Name : <input type="text" name="subject_name" /><br />
			Subject Name : <input type="text" name="subject_name" /><br />
			Subject Name : <input type="text" name="subject_name" /><br />
			Subject Name : <input type="text" name="subject_name" /><br />
			Subject Name : <input type="text" name="subject_name" /><br />
			Subject Name : <input type="text" name="subject_name" /><br />
			Subject Name : <input type="text" name="subject_name" /><br />
			Subject Name : <input type="text" name="subject_name" /><br />
			Subject Name : <input type="text" name="subject_name" /><br /> <input
				type="submit" value="Submit" />
		</form>
	</fieldset>

	<fieldset>
		<legend>
			<b>Set up a master list of classes</b>
		</legend>
		<form action="<%=request.getContextPath()%>/ClassesMasterList"
			method="post">
			Class Name : <input type="text" name="class_name" /><br /> Class
			Name : <input type="text" name="class_name" /><br /> Class Name : <input
				type="text" name="class_name" /><br /> Class Name : <input
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
		<legend>
			<b>Set up a master list of teachers one at a time</b>
		</legend>
		<form action="<%=request.getContextPath()%>/TeacherMasterList"
			method="post">
			Teacher First Name : <input type="text" name="teacher_fname" required /><br />
			Teacher Last Name : <input type="text" name="teacher_lname" required /><br />
			Teacher Email : <input type="email" name="teacher_email" required /><br />
			<input type="submit" value="Submit" />
		</form>
	</fieldset>

	<fieldset>
		<legend>
			<b>Set up a master list of students one at a time</b>
		</legend>
		<form action="<%=request.getContextPath()%>/StudentMasterList"
			method="post">
			Student First Name : <input type="text" name="student_fname" required /><br />
			Student Last Name : <input type="text" name="student_lname" required /><br />
			Student Email : <input type="email" name="student_email" required /><br />
			<input type="submit" value="Submit" />
		</form>
	</fieldset>

</body>
</html>