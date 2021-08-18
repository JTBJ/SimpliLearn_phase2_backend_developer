<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
</head>
<body>
	<h1>Form</h1>
	<a href="<%= request.getContextPath() %>/index.html">Home</a>

	<form action="retreiveFormElements.jsp" method="post">
		<select name="favorite food">
			<option value="pizza">Pizza</option>
			<option value="chinese">Chinese</option>
			<option value="soul food">Soul Food</option>
			<option value="junk food">Junk Food</option>
		</select> <input type="submit" value="Submit" />
	</form>
	<img alt="pick" src="pick.jfif" width="100%">
</body>
</html>