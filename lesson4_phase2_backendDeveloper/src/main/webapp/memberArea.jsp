<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Members Area</title>
</head>
<body>

	<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	if (username != null && password != null) {
		if (request.getParameter("username").equals("SimpliLearn") && request.getParameter("password").equals("43F#@dkd")) {
			//Invalidating session if any
			request.getSession().invalidate();
			HttpSession newSession = request.getSession(true);
			newSession.setMaxInactiveInterval(300);
			newSession.setAttribute("username", username);
			out.print("<!DOCTYPE html><html><head>");
			out.print("<style>");
			out.print(".image {");
			out.print("display: block;" + "margin-left: auto;" + "margin-right: auto;" + "width: 50%;");
			out.print("}");
			out.print("h1 {");
			out.print("text-align: center;");
			out.print("}");
			out.print("</style></head>");
			out.print("<h1>Congratulations You have logged into the Members Area</h1>");
			out.print("<img src='joker.gif' alt='the joker clapping' class='image'/>");
			out.print("<br/><form action='Lesson1UserLogout?logout=true'method='get'>");
			out.print("<input type=\"hidden\" name=\"action\" value=\"destroy\"/>");
			out.print("<input type=\"submit\" name=\"logout\" value=\"Logout\" />");
			out.print("</form></html></body>");
			//response.sendRedirect("memberArea.jsp");

		}else {
			response.sendRedirect("errorPage.jsp");
		} 
	}
	%>
	<%-- <br />
	<form
		action="<%=request.getContextPath()%>/Lesson1UserLogout?logout=true"
		method="get">
		<input type="hidden" name="action" value="destroy"/>
		<input type="submit" name="logout" value="Logout" />
	</form>
--%>
</body>
</html>


