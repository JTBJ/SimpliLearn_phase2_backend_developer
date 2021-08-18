<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.swing.JFrame" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Using Directive to import JFrame</title>
</head>
<body>
<h1>Using Directive to import JFrame</h1>
<a href="<%= request.getContextPath() %>/index.html">Home</a>
<%
JFrame frame = new JFrame("Simple Window");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(400, 400);
frame.setResizable(false);
frame.setVisible(true);
%>
<h2>When the frame is closed, the server will shutdown</h2>
<h3>You GUI app may be on your dock or taskbar</h3>
<img src="gui.jfif" alt="gui" width="100%"/>
</body>
</html>