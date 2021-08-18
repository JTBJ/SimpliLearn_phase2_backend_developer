<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retrieve Session Object and Display it</title>
<style>
.center {
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 50%;
}
</style>
</head>
<body>
	<h1>Retrieve Session Object and Display it</h1>
	<a href="<%= request.getContextPath() %>/index.html">Home</a>
	<%@ page import="lesson4_phase2_backendDeveloper.jsp.Pojo"%>
	<%
	Pojo pojo = (Pojo) session.getAttribute("pojo");
	%>
	<h3>The Session object printed to screen is :</h3>
	<%=pojo%><br />
	<br />
	<br />
	<img src="session.jpg" alt="session" class="center" />
</body>
</html>