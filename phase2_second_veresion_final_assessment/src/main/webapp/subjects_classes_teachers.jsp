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
	<h1>Create a Master List of Subjects, Classes and / or Teachers</h1>
	
	<nav>
		<a href="index.html">Home</a> || <a href="database_access.jsp">Database
			Interface</a> || <a href="logout.jsp">Logout</a>
	</nav>

	<fieldset>
		<legend>
			<b>Set up a master list of subjects</b>
		</legend>
			<form action="<%= request.getContextPath() %>/SubjectMasterList" method="post">
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
				Subject Name : <input type="text" name="subject_name" /><br />	
				<input type="submit" value="Submit" />	
			</form>	
	</fieldset>

	<fieldset>
		<legend>
			<b>Set up a master list of classes</b>
		</legend>
		<form action="<%= request.getContextPath() %>/ClassesMasterList" method="post">
			Class Name : <input type="text" name="class_name" /><br />
			Class Name : <input type="text" name="class_name" /><br />
			Class Name : <input type="text" name="class_name" /><br />
			Class Name : <input type="text" name="class_name" /><br />
			Class Name : <input type="text" name="class_name" /><br />
			Class Name : <input type="text" name="class_name" /><br />
			Class Name : <input type="text" name="class_name" /><br />
			Class Name : <input type="text" name="class_name" /><br />
			Class Name : <input type="text" name="class_name" /><br />
			Class Name : <input type="text" name="class_name" /><br />
			Class Name : <input type="text" name="class_name" /><br />
			<input type="submit" value="Submit" />
		</form>
	</fieldset>

	<fieldset>
		<legend>
			<b>Set up a master list of teachers</b>
		</legend>
			<form action="<%= request.getContextPath() %>/TeacherMasterList" method="post">
				Teacher First Name : <input type="text" name="teacher_fname" /><br />
				Teacher Last Name : <input type="text" name="teacher_lname" /><br />
				Teacher Email : <input type="email" name="teacher_email" /><br />
				<input type="submit" value="Submit" />
			</form>
	</fieldset>

</body>
</html>