<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert, update and delete records</title>
</head>
<body>
	<h1>Insert, update and delete records</h1>
	<a href="<%= request.getContextPath() %>/index.html">Home</a><br/><br/>
	<a href="<%= request.getContextPath() %>/CRDaoServlet">List all table contents</a><br/>
	
	<fieldset style="background-color: green;">
	<h3>This section is to ADD a record in the Student table</h3>
	<form action="InsertUpdateDeleteServlet" method="post">
		<b>First Name</b> <input type="text" name="fname" required /><br/>
		<b>Last Name</b> <input type="text" name="lname" required /><br/>
		<b>Email</b> <input type="email" name="email" required /><br/>
		<input type="submit" value="Add Entry" />
	</form><br/><br/>
	</fieldset>
	
	<fieldset style="background-color: yellow;">
	<h3>This section is to UPDATE a record in the Student table</h3>
	
	<p><b>Click the link above to list the records in the table. Find the Id of the record
	you want to update and click the back button. Insert the ID into the ID field below. 
	Key in the corresponding values you would like to update for the First and Last names
	and / or email.</b></p>
	
	<form action="InsertUpdateDeleteServlet" method="post">
		<input type="hidden" name="update" value="updateRecord" />
		<b>ID</b> <input type="text" name="Id" required /><br/>
		<p><b>Enter a corresponding value you want to be updated. You can use 1, 2 or 
		all fields</b></p>
		<b>First Name</b> <input type="text" name="fname" required /><br/>
		<b>Last Name</b> <input type="text" name="lname" required /><br/>
		<b>Email</b> <input type="email" name="email" required /><br>
		<input type="submit" value="Update Record" />
	</form><br/><br/>
	</fieldset>
	
	<fieldset style="background-color: red;">
	<h3>This section is to DELETE a record in the Student table</h3>
	
	<p><b>Click the link above to list the records in the table. Find the Id of the record
	you want to delete and click the back button. Insert the ID into the ID field below. 
	</b></p>
	
	<form action="InsertUpdateDeleteServlet" method="post">
		<input type="hidden" name="Id_delete" value="deleteRecord" />
		<b>ID</b> <input type="text" name="Id" required /><br/>
		<input type="submit" value="Delete Record" />
	</form><br/><br/>
	</fieldset>
	
</body>
</html>