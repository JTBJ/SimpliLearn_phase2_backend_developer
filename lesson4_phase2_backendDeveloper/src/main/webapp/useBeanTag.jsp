<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Use Bean Tag</title>
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
	<h1>Use Bean Tag</h1>
	<a href="<%= request.getContextPath() %>/index.html">Home</a>
	<jsp:useBean id="pojo" class="lesson4_phase2_backendDeveloper.jsp.Pojo"
		scope="application"></jsp:useBean>
	<jsp:setProperty property="name" name="pojo" value="SimpliLearn" />
	<jsp:setProperty property="email" name="pojo"
		value="simpliLearn@simpliLearn.com" />
	<h1>
		<jsp:setProperty property="age" name="pojo" value="12" />
		Name :
		<jsp:getProperty property="name" name="pojo" /><br /> Email :
		<jsp:getProperty property="email" name="pojo" /><br /> Age :
		<jsp:getProperty property="age" name="pojo" /><br />
	</h1>
	<br />
	<br />
	<img src="useBeanImage.png" alt="use bean" class="center" />
</body>
</html>