package dynamic_webpages_using_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FilterServlet
 */
public class Lesson1FilterServlet implements Filter {

    /**
     * Default constructor. 
     */
    public Lesson1FilterServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("Inside Filter Servlet");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html><head>");
		out.println("<title>Working with Filters</title>");
		out.println("<body><h1>Working with Filters</h1>");
		out.println("<a href=\"get-post-demo.html\">Home</a>");
		out.println("<img src=\"filterServlet.jfif\" alt=\"Servlet api\" width=\"100%\" height=\"300px\" />");
		out.println("</body></html>");		
		System.out.println("End of Filter");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
