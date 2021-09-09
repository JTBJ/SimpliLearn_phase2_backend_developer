<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create, Commit, Search For or Add New Subject</title>

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
	<h1>Create, Commit, Search For or Add New Subject</h1>
	<%
	String teacherFirstName = request.getParameter("carried_teacher_fname");
	String teacherLastName = request.getParameter("carried_teacher_nlame");
	String teacherEmail = request.getParameter("carried_teacher_email");
	String classes = request.getParameter("add_teacher");
	%>

	<fieldset>
		<legend>
			<b>Submit to create Teacher and Class Combination</b>
		</legend>
		<form action="create_teacher_class_combo.jsp">
			Chosen Class : <input type="text" value="<%=classes%>"
				name="carried_class_name" readonly="readonly" /><br /> Teacher
			First Name : <input type="text" value="<%=teacherFirstName%>"
				name="carried_teacher_fname" readonly="readonly" /><br /> Teacher
			Last Name : <input type="text" value="<%=teacherLastName%>"
				name="carried_teacher_nlame" readonly="readonly" /><br /> Teacher
			Email : <input type="email" value="<%=teacherEmail%>"
				name="carried_teacher_email" readonly="readonly" /><br /> <input
				type="submit" value="Create" />
		</form>
	</fieldset>

	<fieldset>
		<legend>
			<b>Add an existing Subject</b>
		</legend>
		<form action="subject_search.jsp">
			Chosen Class : <input type="text" value="<%=classes%>"
				name="carried_class_name" readonly="readonly" /><br /> Teacher
			First Name : <input type="text" value="<%=teacherFirstName%>"
				name="carried_teacher_fname" readonly="readonly" /><br /> Teacher
			Last Name : <input type="text" value="<%=teacherLastName%>"
				name="carried_teacher_nlame" readonly="readonly" /><br /> Teacher
			Email : <input type="email" value="<%=teacherEmail%>"
				name="carried_teacher_email" readonly="readonly" /><br /> Subject
			Name : <input type="text" name="subject_name" required /> <input
				type="submit" value="Search" />
		</form>
	</fieldset>

	<fieldset>
		<legend>
			<b>Add a new Subject</b>
		</legend>
		<form action="add_new_subject.jsp">
			Chosen Class : <input type="text" value="<%=classes%>"
				name="carried_class_name" readonly="readonly" /><br /> Teacher
			First Name : <input type="text" value="<%=teacherFirstName%>"
				name="carried_teacher_fname" readonly="readonly" /><br /> Teacher
			Last Name : <input type="text" value="<%=teacherLastName%>"
				name="carried_teacher_lname" readonly="readonly" /><br /> Teacher
			Email : <input type="email" value="<%=teacherEmail%>"
				name="carried_teacher_email" readonly="readonly" /><br /> Subject
			Name : <input type="text" name="subject_name" required /> <input
				type="submit" value="Add Subject" />
		</form>
	</fieldset>
</body>
</html>