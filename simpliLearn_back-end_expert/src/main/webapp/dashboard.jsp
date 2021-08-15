<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<style>
	.center{
		display: block;
		margin-left: auto;
		margin-right: auto;
	}
</style>
</head>
<body>
	<h1>Dashboard</h1>
	<a href="<%= request.getContextPath() %>/get-post-demo.html">Home</a>
	<h1>Using cookies to track session after login</h1>
	
	<% HttpSession sessions = request.getSession();
	   String username = (String)sessions.getAttribute("username"), sessionID = null, tempUserName = "SimpliLearn";
	   Cookie[] cookies = request.getCookies();
	   
	   if(cookies != null){
		   for(Cookie cookie : cookies){ 
			   if(cookie.getName().equals(username)){
				   username = cookie.getValue();
			   }
			   //*if(cookie.getName().contentEquals("SimpliLearn")){//.equals("SimpliLearn")){
				//   username = cookie.getValue();
			   //}*/
			   if(cookie.getName().equals("JSESSIONID")){
				   sessionID = cookie.getValue();
			   }
		   }
	   }
	   
	   if(username == null || sessionID == null || request.getSession() == null){
		   out.print("<!DOCTYPE html><html><head><title>No Cookie Used</title></head><body>");
		   out.print("<h1>No cookie used</h1>");
		   out.print("<h3>This is a JSP page that validates the use of cookies</h3>");
		   out.print("<h3>If cookies are not enabled or you chose the \"No Cookie\" link"+
		   " then this is the reason you are reading this message.</h3>"); 
		   out.print("</body></html>");
	   }
	%>
	
	Username : <%= username %><br/>
	SessionID : <%= sessionID %>
	<img src="session-and-cookies.png" alt="Cookies" class="center"/>
	
</body>
</html>