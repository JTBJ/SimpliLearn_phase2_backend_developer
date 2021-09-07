<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submit Class Continued</title>

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
	<h1>Finish Class Setup</h1>

	<nav>
		<a href="index.html">Home</a> || <a href="database_access.jsp">Database
			Interface</a> || <a href="logout.jsp">Logout</a>
	</nav>

	<%@ page
		import="phase2_second_veresion_final_assessment.entity.Classes"%>

	<%
	String className = request.getParameter("class_name");
	%>

	<fieldset>
		<legend>
			<b>Add class to an existing subject</b>
		</legend>
		<form action="find_class_subject.jsp">
			Chosen Class : <input type="text" value="<%=className%>"
				name="carried_class_name" readonly="readonly" /><br /> Subject
			Name : <input type="text" name="subject_finder" required /> <input
				type="submit" value="Find Subject" />
		</form>
	</fieldset>

	<br />

	<fieldset>
		<legend>
			<b>Enter a new subject and add the class to it</b>
		</legend>
		<form action="create_subject.jsp">
			Chosen Class : <input type="text" value="<%=className%>"
				name="carried_class_name" readonly="readonly" /><br /> Subject
			Name : <input type="text" name="new_subject" required /> <input
				type="submit" value="Add Subject" />
		</form>
	</fieldset>
</body>
</html>