package dynamic_webpages_using_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Lesson1_Implement_Servlet_Interface implements Servlet {
	
	private String servletConfigValue;
	private String servletContextValue;

	@Override
	public void destroy() {
		System.out.println("Doing some cleanup stuff.");

	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		ServletContext context = arg0.getServletContext();
		servletContextValue = context.getInitParameter("context_param");
		servletConfigValue = arg0.getInitParameter("servlet_interface_init-param");
		System.out.println(arg0.getInitParameter("servlet_interface_init-param"));
		System.out.println(context.getInitParameter("context_param"));

	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String hobby = request.getParameter("hobby");
		
		out.println("<!DOCTYPE html><html><head>");
		out.println("<title>Extending the Servlet Interface</title>");
		out.println("<body><h1>Extending the Servlet Interface</h1>");
		out.println("<a href=\"get-post-demo.html\">Home</a>");
		out.println("<img src=\"servletInterface.jfif\" alt=\"Servlet api\" width=\"100%\" height=\"300px\" />");
		out.println("<h2>ServletConfig param is printed to console, but I also "+
				   "included it here.</h2>" + "<p>" + servletConfigValue + "</p>");
		out.println("<h2>ServletContext param is printed to console, but I also "+
				   "included it here.</h2>" + "<p>" + servletContextValue + "</p>");
		out.println("<h3>" + hobby + " is a fine hobby</h3>");
		out.println("</body></html>");
	}


	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

}
