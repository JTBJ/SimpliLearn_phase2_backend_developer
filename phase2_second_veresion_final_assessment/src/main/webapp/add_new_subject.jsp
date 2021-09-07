<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create, Commit, Search For, or Add New Student</title>

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

	<h1>Create, Commit, Search For, or Add New Student</h1>

	<nav>
		<a href="index.html">Home</a> || <a href="database_access.jsp">Database
			Interface</a> || <a href="logout.jsp">Logout</a>
	</nav>

	<%
	String subject = request.getParameter("subject_name");
	String classes = request.getParameter("carried_class_name");
	String teacherFirstName = request.getParameter("carried_teacher_fname");
	String teacherLastName = request.getParameter("carried_teacher_lname");
	String teacherEmail = request.getParameter("carried_teacher_email");
	%>

	<fieldset>
		<legend>
			<b>Submit to create Subject, Class, Teacher Combination</b>
		</legend>
		<form action="create_subject_class_teacher_combo.jsp">
			Chosen Class : <input type="text" value="<%=classes%>"
				name="carried_class_name" readonly="readonly" /><br /> Chosen
			Subject: <input type="text" value="<%=subject%>"
				name="carried_subject_name" readonly="readonly" /><br /> Teacher
			First Name : <input type="text" value="<%=teacherFirstName%>"
				name="carried_teacher_fname" readonly="readonly" /><br /> Teacher
			Last Name : <input type="text" value="<%=teacherLastName%>"
				name="carried_teacher_lname" readonly="readonly" /><br /> Teacher
			Email : <input type="email" value="<%=teacherEmail%>"
				name="carried_teacher_email" readonly="readonly" /><br /> <input
				type="submit" value="Create Existing Record" />
		</form>
	</fieldset>

	<br />

	<br />

	<fieldset>
		<legend>
			<b>Add an existing Student</b>
		</legend>
		<form action="student_search.jsp">
			Chosen Class : <input type="text" value="<%=classes%>"
				name="carried_class_name" readonly="readonly" /><br /> Chosen
			Subject: <input type="text" value="<%=subject%>"
				name="carried_subject_name" readonly="readonly" /><br /> Teacher
			First Name : <input type="text" value="<%=teacherFirstName%>"
				name="carried_teacher_fname" readonly="readonly" /><br /> Teacher
			Last Name : <input type="text" value="<%=teacherLastName%>"
				name="carried_teacher_lname" readonly="readonly" /><br /> Teacher
			Email : <input type="email" value="<%=teacherEmail%>"
				name="carried_teacher_email" readonly="readonly" /><br /> Email of
			Student to search for : <input type="email" name="student_search"
				required /><br /> <input type="submit" value="Search for Student" />
		</form>
	</fieldset>

	<br />

	<fieldset>
		<legend>
			<b>Add a new Student</b>
		</legend>
		<form action="add_new_student.jsp">
			Chosen Class : <input type="text" value="<%=classes%>"
				name="carried_class_name" readonly="readonly" /><br /> Chosen
			Subject: <input type="text" value="<%=subject%>"
				name="carried_subject_name" readonly="readonly" /><br /> Teacher
			First Name : <input type="text" value="<%=teacherFirstName%>"
				name="carried_teacher_fname" readonly="readonly" /><br /> Teacher
			Last Name : <input type="text" value="<%=teacherLastName%>"
				name="carried_teacher_lname" readonly="readonly" /><br /> Teacher
			Email : <input type="text" value="<%=teacherEmail%>"
				name="carried_teacher_email" readonly="readonly" /><br /> Student
			First Name : <input type="text" name="add_student_fName" required /><br />
			Student Last Name : <input type="text" name="add_student_lName"
				required /><br /> Student Email : <input type="email"
				name="add_student_email" required /><br /> <input type="submit"
				value="Add Student" />
		</form>
	</fieldset>


</body>
</html>