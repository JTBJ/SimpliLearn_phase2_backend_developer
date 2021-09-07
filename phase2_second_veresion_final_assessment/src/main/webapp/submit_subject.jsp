<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submit Subject Continued</title>

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
<h1>Finish Subject Setup</h1>

<%
	String subjectName = request.getParameter("subject_name");
%>

<fieldset>
	<legend><b>Add an existing class</b></legend>
		<form action="find_subject_class.jsp">
			Chosen Subject : <input type="text" value="<%= subjectName %>" name="carried_subject_name" readonly="readonly" /><br/>
			Class Name : <input type="text" name="Class_finder" required />
			<input type="submit" value="Find Class" />
		</form>
</fieldset>

<br/>

<fieldset>
	<legend><b>Enter a new class to add to this subject</b></legend>
		<form action="create_class.jsp">
			Chosen Subject : <input type="text" value="<%= subjectName %>" name="carried_subject_name" readonly="readonly" /><br/>
			Class Name : <input type="text" name="new_Class" required />
			<input type="submit" value="Add Class" />
		</form>
</fieldset>
</body>
</html>