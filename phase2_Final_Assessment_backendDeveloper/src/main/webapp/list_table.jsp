<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table Selection Page</title>
</head>
<body>
	<h1>Table Selection Page</h1>

	<nav>
		<a href="index.html">Home</a>
	</nav>

	<fieldset>
		<legend>Select a Table to View</legend>
		<form action="ListTable" method="post">
			<b>Subject</b><input type="radio" value="Subjects" name="subjects" /><br/>
			<b>Classes</b><input type="radio" value="Classes" name="classes" /><br/>
			<b>Teachers</b><input type="radio" value="Teachers" name="teachers" /><br/>
			<b>Students</b><input type="radio" value="Students" name="students" /><br/>
			<input type="submit" value="List Table" />
		</form>
	</fieldset>
</body>
</html>