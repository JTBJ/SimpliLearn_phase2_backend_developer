<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>No Cookies</title>
	<style>
		.center{
			display: block;
			margin-left: auto;
			margin-right: auto;
			width: 40%;
		}
	</style>
</head>
<body>
<h1>No Cookies Used</h1>
<a href="<%= request.getContextPath() %>/get-post-demo.html">Home</a>
<div style="width: 40%;">
<h3>This is a JSP page that validates the use of cookies</h3>
<h3>If cookies are not enabled or you chose the "No Cookie" link
	 then this is the reason you are reading this message.</h3> 
</div>
<img src="no_cookies.png" alt="No Cookies" class="center">

</body>
</html>