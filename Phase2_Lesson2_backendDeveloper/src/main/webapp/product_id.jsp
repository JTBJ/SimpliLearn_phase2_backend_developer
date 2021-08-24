<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Product by Id</title>
</head>
<body>
	<h1>List Product by Id</h1>
	
	<a href="<%= request.getContextPath() %>index.html">Home</a><br/><br/>
	
	<p>If the database and table have not been created in this program, you will need
	to click on the "Create Table" button in order to complete the click on the other
	two buttons. If there is no database, you would need to comment out the DROP Database
	statement in order to create the initial database. This statement and a few others
	that correspond to it are found in the Product_Id_Servlet class.</p>
	<br/><br/>
	
	<form action="Product_Id_Servlet" method="get">
		<input type="hidden" name="create" value=table />
		<input type="submit" value="Create Table" />
	</form>	
	<br/><br/>
	
	<form action="Product_Id_Servlet" method="get">
		<input type="hidden" name="list" value="list" />
		<input type="submit" value="Show Table" />
	</form>	
	<br/><br/>
	
	<p>Enter the Id of the record to retrieve</p>
	
	<form action="Product_Id_Servlet" method="get">
		<b>Id</b> <input type="text" name="Id" required /><br/>
		<input type="submit" value="Get Record" />
	</form><br/><br/>
	
</body>
</html>