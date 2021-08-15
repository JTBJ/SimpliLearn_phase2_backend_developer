package dynamic_webpages_using_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lesson1PostServlet
 */
public class Lesson1PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lesson1PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String name = request.getParameter("firstName");
		out.println("<!DOCTYPE html><head>");
		out.println("<title>Post Demo</title></head>");
		out.println("<h1>Post Demo</h1>");
		out.println("<a href=\"get-post-demo.html\">Home</a>");
		out.println("<h2>Hello " + name + " I am the doPost() method.</h2>");
		out.print("<img src=\"doGet-doPost.png\" alt=\"Info on doGet-doPost\" width=\"100%\" height=\"600px\" />");
		out.println("</body></html>");
		
		out.close();
	}

}
