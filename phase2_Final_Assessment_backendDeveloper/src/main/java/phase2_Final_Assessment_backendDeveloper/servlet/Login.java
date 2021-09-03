package phase2_Final_Assessment_backendDeveloper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (!(username.equals("SimpliLearn") && password.equals("certification"))) {
			response.sendRedirect("invalid_login.jsp");
		}

		if (username.equals("SimpliLearn") && password.equals("certification")) {
			Cookie cookie1 = new Cookie(username, UUID.randomUUID().toString());
			Cookie cookie2 = new Cookie(password, UUID.randomUUID().toString());
			
			cookie1.setMaxAge(60*60*24);
			cookie2.setMaxAge(60*60*24);
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
			response.sendRedirect("database_access.jsp");
		}
	}

}
