<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Student to Class</title>

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
	<h1>Add New Student to the Class</h1>

	<nav>
		<a href="index.html">Home</a> || <a href="database_access.jsp">Database
			Interface</a> || <a href="logout.jsp">Logout</a>
	</nav>

	<%
	String subject = request.getParameter("carried_subject_name");
	String classes = request.getParameter("carried_class_name");
	String teacherFirstName = request.getParameter("carried_teacher_fname");
	String teacherLastName = request.getParameter("carried_teacher_lname");
	String teacherEmail = request.getParameter("carried_teacher_email");
	String studentFirstName = request.getParameter("add_student_fName");
	String studentLastName = request.getParameter("add_student_lName");
	String studentEmail = request.getParameter("add_student_email");
	%>

	<fieldset>
		<legend>
			<b>Verify Information</b>
		</legend>
		<form action="<%=request.getContextPath()%>/Classes_SuClTeSt"
			method="post">
			Chosen Class : <input type="text" value="<%=classes%>"
				name="carried_class_name" readonly="readonly" /><br /> Chosen
			Subject: <input type="text" value="<%=subject%>"
				name="carried_subject_name" readonly="readonly" /><br /> Teacher
			Assigned First Name : <input type="text"
				value="<%=teacherFirstName%>" name="carried_teacher_fname"
				readonly="readonly" /><br /> Teacher Assigned Last Name : <input
				type="text" value="<%=teacherLastName%>"
				name="carried_teacher_lname" readonly="readonly" /><br /> Teacher
			Assigned Email : <input type="email" value="<%=teacherEmail%>"
				name="carried_teacher_email" readonly="readonly" /><br />
			Enrolling Student First Name : <input type="text"
				value="<%=studentFirstName%>" name="carried_student_fname" required /><br />
			Enrolling Student Last Name : <input type="text"
				value="<%=studentLastName%>" name="carried_student_lname" required /><br />
			Enrolling Student Email : <input type="email"
				value="<%=studentEmail%>" name="carried_student_email" required /><br />
			<input type="submit" value="Add Associations" />
		</form>
	</fieldset>

</body>
</html>