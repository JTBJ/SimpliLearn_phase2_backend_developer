package dynamic_webpages_using_servlet.session_tracking;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Lesson1SessionTracking
 */
public class Lesson1SessionTrackingWithCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String appUserName = "SimpliLearn";
	private String appPassword = "luv2c0d3";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lesson1SessionTrackingWithCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 
		 if(username.equals(appUserName) && password.equals(appPassword)) {
			 Cookie cookie = new Cookie("username", username);
			 cookie.setPath("/");
			 response.addCookie(cookie);
			 HttpSession session = request.getSession();
			 session.setAttribute("username", username);
			 request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			 //response.sendRedirect("dashboard.jsp");
		 }else {
			 response.getWriter().print("<html><body><h1>Invalid Credentials</h1></body></html>");
		 }
	}

}
