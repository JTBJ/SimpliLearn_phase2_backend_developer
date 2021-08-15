package dynamic_webpages_using_servlet.session_tracking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lesson1withUrlRewriting
 */
public class Lesson1WithoutUrlRewriting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lesson1WithoutUrlRewriting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = (String)request.getParameter("name");
		String password = (String)request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.print("<!DOCTYPE html><html><head></head>");
		out.print("<h1>Without URL Rewriting</h1>");
		out.print("<a href=\"get-post-demo.html\">Home</a>");
		if(name != null) {
			out.print("<h2>Name: " + name + "</h2>");
		}
		
		if(password != null) {
			out.print("<h1>Password: " + password + "</h1>");
		}
		out.print("<img src=\"fullstackjava.jpg\" alt=\"Full Stack\"/>");
		out.print("<body>");
		out.print("</body></html>");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
