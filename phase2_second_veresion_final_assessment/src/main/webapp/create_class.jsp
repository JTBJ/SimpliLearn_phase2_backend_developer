<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Class and add to Subject</title>

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
	<h1>Create / Add Class to Subject</h1>

	<%
	String subject = request.getParameter("carried_subject_name");
	String classes = request.getParameter("new_Class");
	%>

	<fieldset>
		<legend>
			<b>Submit to create Subject and Class Combination</b>
		</legend>
		<form action="create_subject_class_combo.jsp">
			Chosen Class : <input type="text" value="<%=classes%>"
				name="carried_class_name" readonly="readonly" /><br /> Chosen
			Subject: <input type="text" value="<%=subject%>"
				name="carried_subject_name" readonly="readonly" /><br /> <input
				type="submit" value="Create" />
		</form>
	</fieldset>

	<fieldset>
		<legend>
			<b>Add an existing Teacher</b>
		</legend>
		<form action="teacher_search.jsp">
			Chosen Class : <input type="text" value="<%=classes%>"
				name="carried_class_name" readonly="readonly" /><br /> Chosen
			Subject: <input type="text" value="<%=subject%>"
				name="carried_subject_name" readonly="readonly" /><br /> Email of
			Teacher to search for : <input type="email" name="teacher_search"
				required /><br /> <input type="submit" value="Search" />
		</form>
	</fieldset>

	<fieldset>
		<legend>
			<b>Add a new Teacher</b>
		</legend>
		<form action="add_new_teacher.jsp">
			Chosen Class : <input type="text" value="<%=classes%>"
				name="carried_class_name" readonly="readonly" /><br /> Chosen
			Subject: <input type="text" value="<%=subject%>"
				name="carried_subject_name" readonly="readonly" /><br /> Teacher
			First Name : <input type="text" name="add_teacher_fName" required /><br />
			Teacher Last Name : <input type="text" name="add_teacher_lName"
				required /><br /> Teacher Email : <input type="email"
				name="add_teacher_email" required /><br /> <input type="submit"
				value="Add Teacher" />
		</form>
	</fieldset>
</body>
</html>