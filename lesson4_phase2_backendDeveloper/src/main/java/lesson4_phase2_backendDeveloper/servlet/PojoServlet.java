package lesson4_phase2_backendDeveloper.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PojoServlet
 */
public class PojoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PojoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html><html>");
		out.print("<head><title>Create object from form and display it</title>");
		out.print("");
		out.print("</head><body>");
		out.print("<h1>Create object from form and display it using JSP page</h1>");
		out.print("<a href='index.html'>Home</a>");
		out.print("<form action='displayFormData.jsp' method='get'>");
		out.print("Username : <input type='text' name='name' /><br/>");
		out.print("Email : <input type='email' name='email' /><br/>");
		out.print("Age : <input type='text' name='age' /><br/>");
		out.print("<input type='submit' value='Submit' /><br/>");
		out.print("</form>");
		out.print("<img src='formServlet.jpg' alt='servlet' />");
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
