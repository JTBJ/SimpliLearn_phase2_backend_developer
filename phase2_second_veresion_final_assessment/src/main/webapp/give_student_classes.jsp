<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Student to a Class</title>
</head>
<body>
<h1>Assign Student to a Class</h1>

<fieldset>
<legend>Enter the student's email and the class to assign it to</legend>
<form action="AddStudentClasses" method="post">
Student Email : <input type="email" name="student_email" required />
Class Name : <input type="text" value="class_name" required />
<input type="submit" value="Add Class" />
</form>
</fieldset>
</body>
</html>