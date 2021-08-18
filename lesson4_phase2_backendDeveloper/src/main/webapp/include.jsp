<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Using the Directive element to include a file</title>
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
	<h1>Using the Directive element to include a file</h1>
	<a href="<%= request.getContextPath() %>/index.html">Home</a><br/>
	<jsp:include page="text.txt"></jsp:include><br />
	<%@ include file="text.html"%><br />
	<br />
	<div style="background-color: pink;">
		<img src="jsp-include-directive.jpg" alt="include directive"
			class="center" />
	</div>
</body>
</html>