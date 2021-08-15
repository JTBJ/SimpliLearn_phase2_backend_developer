package dynamic_webpages_using_servlet;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lesson1Servlet1
 */
public class Lesson1GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lesson1GetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String fName = request.getParameter("firstName");
		out.println("<!DOCTYPE html><html><body>");
		out.println("<h1>Get Demo</h1>");
		out.println("<a href=\"get-post-demo.html\">Home</a>");
		out.println("<h2>Hello " + fName + " I am the doGet() method.</h2>");
		out.print("<img src=\"doGet-doPost.png\" alt=\"Info on doGet-doPost\" width=\"100%\" height=\"600px\" />");
		out.println("</body></html>");
	}

}
