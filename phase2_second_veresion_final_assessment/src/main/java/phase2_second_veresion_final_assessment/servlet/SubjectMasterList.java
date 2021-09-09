package phase2_second_veresion_final_assessment.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import phase2_second_veresion_final_assessment.entity.Classes;
import phase2_second_veresion_final_assessment.entity.Student;
import phase2_second_veresion_final_assessment.entity.Subject;
import phase2_second_veresion_final_assessment.entity.Teacher;

/**
 * Servlet implementation class SubjectMasterList
 */
public class SubjectMasterList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubjectMasterList() {
		super();
		// TODO Auto-generated constructor stub
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

		if (count == 0) {
			throw new ServletException("Invalid access. You need to first login.");
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String[] subjectList = request.getParameterValues("subject_name");

		Set<String> set = new HashSet<>();

		for (String string : subjectList) {
			set.add(string);
			out.print(string + "<br/>");
		}

		SessionFactory factory = new Configuration().configure("hibernate.cfg2.xml").addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class).addAnnotatedClass(Teacher.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.openSession();

		session.beginTransaction();

		try {
			for (String string : set) {
				if (string.equals("")) {

				} else {
					session.save(new Subject(string));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
//			throw new ServletException("Cannot add duplicate values");
		} finally {
			session.getTransaction().commit();
			session.close();
		}

		response.sendRedirect("subjects_classes_teachers_again.jsp");

	}

}
