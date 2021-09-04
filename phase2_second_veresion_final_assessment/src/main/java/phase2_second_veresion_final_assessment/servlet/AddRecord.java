package phase2_second_veresion_final_assessment.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddRecord
 */
public class AddRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddRecord() {
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

		int count = 0;
		
		Cookie[] cookie = request.getCookies();

		for (Cookie cookies : cookie) {
			if (cookies.getName().equals("email")) {
				count++;
			}
		}
		
		if(count == 0){
			throw new ServletException("Invalid access. You need to first login.");
		}
		
		String string = request.getParameter("table");

		switch (string) {
			case "subject":
				response.sendRedirect("add_subject.jsp");
				break;
			case "class":
				response.sendRedirect("add_class.jsp");
				break;
			case "teacher":
				response.sendRedirect("add_teacher.jsp");
				break;
			case "student":
				response.sendRedirect("add_student.jsp");
				break;
			default:
		}
	}

}
