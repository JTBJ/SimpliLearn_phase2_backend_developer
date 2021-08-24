<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MySql CREATE, USE and DROP databases</title>
<style>
fieldset {
	background-color: red;
	color: white;
	margin-left: 30%;
	margin-right: 30%;
	display: block;
}

b {
	color: black;
}

body {
	background-color: pink;
}
</style>
</head>
<body>
	<h1>MySql CREATE, USE, DROP</h1>
	<a href="<%=request.getContextPath()%>/index.html">Home</a>
	<fieldset>
		<h3 style="text-align: center;">MySQL database naming conventions</h3>
		<p>
			<b>Use lowercase:</b> Will help on speed typing, avoid mistakes dues
			to case sensitivity e.t.c.<br /> <b>No space between names</b>- use
			underscore instead.<br /> <b>No numbers in name</b> only alpha
			English characters.<br /> Valid understandable names like blog,
			ecommerce e.t.c but not like project, james, e.t.c.
		</p>
	</fieldset>
	<br />
	<nav>
		<form action="CreateUseDropServlet" method="get">
			<b>Create a database</b> : <input type="text" name="create" required />
			<input type="submit" value="Create Database" />
		</form>
		<br /> <br />

		<form action="CreateUseDropServlet" method="get">
			<b>Use a database</b> : <input type="text" name="use" required /> <input
				type="submit" value="Use Database" />
		</form>
		<br /> <br />

		<form action="CreateUseDropServlet" method="get">
			<b>Delete a database</b> : <input type="text" name="delete" required />
			<input type="submit" value="Delete Database" />
		</form>
		<br /> <br />


		<form action="<%=request.getContextPath()%>/CreateUseDropServlet"
			method="get">
			<input type="hidden" name="task" value="show" /> <input
				type="submit" value="Show Databases" />
		</form>
		<br /> <br />
	</nav>
</body>
</html>