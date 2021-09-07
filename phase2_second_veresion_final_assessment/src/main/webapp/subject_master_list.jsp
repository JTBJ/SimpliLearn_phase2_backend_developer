<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Master List of Subjects</title>
</head>
<body>
<h1>Master List of Subjects</h1>

<% String[] subjects = request.getParameterValues("subject_name"); 

	for(String s : subjects){
		System.out.println(s);
	}
%>


</body>
</html>