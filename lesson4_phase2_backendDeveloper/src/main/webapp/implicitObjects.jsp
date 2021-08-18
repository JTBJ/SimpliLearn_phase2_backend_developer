<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Example of Implicit Objects</title>
</head>
<body>
	<h1>Example of Implicit Objects</h1>
	<a href="<%= request.getContextPath() %>/index.html">Home</a><br/>
    <a href="<%= request.getContextPath() %>/redirected.jsp">Send a request to be redirected</a><br/>
	<%
	out.print("<h2>Printing this message and image using the implicit out object</h2>");
	out.print("<img src=\"JSP-Implicit-Objects.jpg\" alt=\"jsp implicit objects\" />");
	%>
	
</body>
</html>