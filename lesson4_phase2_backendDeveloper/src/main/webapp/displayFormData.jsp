<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Object and Store Object in a Session Object</title>
</head>
<body>
<h1>Create Object and Store Object in a Session Object</h1>

<%@ page import="lesson4_phase2_backendDeveloper.jsp.Pojo" %>

<% 	String name = request.getParameter("name");
	String email = request.getParameter("email");
	int age = Integer.parseInt(request.getParameter("age"));
	
	Pojo pojo = new Pojo();
	pojo.setName(name);
	pojo.setEmail(email);
	pojo.setAge(age);
	
	session.setAttribute("pojo", pojo);
	request.getRequestDispatcher("displaySessionObject.jsp").forward(request, response);%>
</body>
</html>