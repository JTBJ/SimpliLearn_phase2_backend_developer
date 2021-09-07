<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subjects, Classes, Teachers</title>

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
	<h1>Create a Subject, Class, Teacher and / or Student Records Individually</h1>

	<fieldset>
		<legend>
			<b>Set up a subject</b>
		</legend>
			<form action="submit_subject.jsp" method="get">
				Subject Name : <input type="text" name="subject_name" required /><br/>
				<input type="submit" value="Submit" />	
			</form>
	</fieldset>


	<fieldset>
		<legend>
			<b>Set up a class</b>
		</legend>
			<form action="submit_class.jsp" method="get">
				Class Name : <input type="text" name="class_name" required /><br/>
				<input type="submit" value="Submit" />	
			</form>
	</fieldset>

	<fieldset>
		<legend>
			<b>Set up a teacher</b>
		</legend>
			<form action="submit_teacher.jsp" method="get">
				Student First Name : <input type="text" name="add_student_fName" required /><br/>
				Student Last Name : <input type="text" name="add_student_lName" required /><br/>
				Student Email : <input type="email" name="add_student_email" required /><br/>
				<input type="submit" value="Submit" />	
			</form>
	</fieldset>

</body>
</html>