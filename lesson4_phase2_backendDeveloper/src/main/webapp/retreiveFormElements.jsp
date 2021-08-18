<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retrieve Values</title>
</head>
<body>
	<h1>Retrieve Values From Form to Display</h1>
	<a href="<%= request.getContextPath() %>/index.html">Home</a>

	<%
	String food = request.getParameter("favorite food");
	%>

	<h3>
		The food you have chosen to be your favorite is
		<%= food %>
	</h3>
	<%
	switch (food) {
	case "pizza":
		out.print("<img src='pizza.jpg' alt='pizza' width='100%' />");
		break;
	case "chinese":
		out.print("<img src='chinese.jfif' alt='chinese' width='100%'/>");
		break;
	case "soul food":
		out.print("<img src='soul.jfif' alt='soul' width='100%' />");
		break;
	case "junk food":
		out.print("<img src='junk.jpg' alt='junk' width='100%' />");
		break;
	}
	%>

</body>
</html>