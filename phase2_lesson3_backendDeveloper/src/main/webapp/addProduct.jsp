<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<h1>Add Product</h1>
	<a href="index.html">Home</a>

	<form action="AddProductDetailsServlet" method="post">
		Product Name : <input type="text" name="pName" required /><br />
		Product Price : <input type="number" name="pPrice" required /><br />
		<input type="submit" value="Add" />
	</form>
</body>
</html>