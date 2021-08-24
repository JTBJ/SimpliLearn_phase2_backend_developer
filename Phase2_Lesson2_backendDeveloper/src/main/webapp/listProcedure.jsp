<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Store Procedure</title>
</head>
<body>
	<h1>Store Procedure</h1>
	<a href="<%= request.getContextPath() %>/index.html">Home</a>
	<%@ page import="Phase2_Lesson2_backendDeveloper.dao.DBConnection"%>
	<%@ page import="java.sql.ResultSet"%>
	<%@ page import="java.sql.Connection"%>
	<%@ page import="java.util.Properties"%>
	<%@ page import="java.io.InputStream"%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Product_Name</th>
			<th>Price</th>
			<th>Date_Added</th>
		</tr>
		<%
		try {
			InputStream in = getServletContext().getResourceAsStream("config.properties");
			Properties prop = new Properties();
			prop.load(in);
			Connection conn = DBConnection.getConnection(prop.getProperty("url"), prop.getProperty("username"),
			prop.getProperty("password"));
			ResultSet rs = DBConnection.createQuery(conn, "select * from eproduct");
			while (rs.next()) {
				out.print("<tr>");
				out.println("<td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + Double.parseDouble(rs.getString(3)) + "</td><td>"
				+ rs.getDate(4) + "</td>");
				out.print("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		%>
	</table>
</body>
</html>