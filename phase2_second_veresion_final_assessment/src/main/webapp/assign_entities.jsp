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
<h1>Subjects, Classes, Teachers and Students Assignments</h1>

<fieldset>
<legend>Assign one or more Classes to a Subject</legend>
<form action="<%= request.getContextPath() %>/AddSubjectClasses" method="post">
			Subject Name : <input type="text" name="subject" required /><br/><br/>
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
<legend>Assign one or more Classes to a Subject</legend>
<form action="<%= request.getContextPath() %>/AddTeacherClasses" method="post">
			Teacher Email : <input type="email" name="teacher_email" required /><br/><br/>
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
<legend>Assign a Student to a Class</legend>
<form action="<%= request.getContextPath() %>/AddStudentClass" method="post">
			Student Email : <input type="email" name="student_email" required /><br/><br/>
			Class Name : <input type="text" name="class_name" required/><br />
			<input type="submit" value="Submit" />
		</form>
</fieldset>
</body>
</html>