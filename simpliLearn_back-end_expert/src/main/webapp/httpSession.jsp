<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Http Session</title>
</head>
<body>
	<h1>Http Session</h1>
	<nav><a href="<%= request.getContextPath() %>/get-post-demo">Home</a></nav><br/>
	<a
		href="<%=request.getContextPath()%>/Lesson1SessionTrackingWithHttpSession?username=SimpliLearn&password=luv2c0d3">Tracking
		using Session Tracking</a><br/>
	<a
		href="<%=request.getContextPath()%>/Lesson1SessionTrackingWithoutHttpSession">No
		Http Session Tracking</a><br/>

	<img src="session-tracking.png" alt="Types of Session management" width="100%"/>
</body>
</html>