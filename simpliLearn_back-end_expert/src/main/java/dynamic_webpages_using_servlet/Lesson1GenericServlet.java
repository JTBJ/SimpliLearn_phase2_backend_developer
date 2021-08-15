package dynamic_webpages_using_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Lesson1GenericServlet extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		String country = request.getParameter("country");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html><head>");
		out.println("<title>Generic Servlet Demo</title>");
		out.println("<body><h1>Generic Servlet Demo</h1>");
		out.println("<a href=\"get-post-demo.html\">Home</a><br/>");
		out.println("<img src=\"genericServletImg.jfif\" alt=\"Servlet api\" width=\"100%\" height=\"400px\" />");
		out.println("<h3>" + country + " is a fine country</h3>");
		out.println("</body></html>");	}

}
