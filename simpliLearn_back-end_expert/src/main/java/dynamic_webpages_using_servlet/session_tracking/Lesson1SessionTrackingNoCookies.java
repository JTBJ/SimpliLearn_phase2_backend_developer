package dynamic_webpages_using_servlet.session_tracking;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Lesson1SessionTracking
 */
public class Lesson1SessionTrackingNoCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String appUserName = "SimpliLearn";
	private String appPassword = "luv2c0d3";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lesson1SessionTrackingNoCookies() {
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
		
		 
		 
//		 if(username.equals(appUserName) && password.equals(appPassword)) {
//			 request.getSession().invalidate(); 
//			 response.sendRedirect("dashboard2.jsp");
//		 }else { 
//			 response.getWriter().print("<html><body><h1>Invalid Credentials</h1></body></html>"); 
//		 }
		 

        Cookie cookie = null;
	    Cookie[] cookies = null;
	    boolean found = false;
	    PrintWriter out = response.getWriter();
	    out.println("<html><body>");
	    
	    cookies = request.getCookies();
	    if (cookies != null) {
	        for (int i = 0; i < cookies.length; i++) {
	            cookie = cookies[i];
	            if (cookie.getName().contentEquals("SimpliLearn") && cookie.getValue() != null) {
	                out.println("UserId read from cookie:" + cookie.getValue() + "<br>");
	                found = true;
	            }
	         }
	    }
	    if (!found) {
	        request.getRequestDispatcher("noCookies.jsp").forward(request, response);
	    }
	    out.println("</body></html>");
		}

}
