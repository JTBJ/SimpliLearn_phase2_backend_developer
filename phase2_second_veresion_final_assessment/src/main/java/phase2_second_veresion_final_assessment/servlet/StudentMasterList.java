package phase2_second_veresion_final_assessment.servlet;

import java.io.IOException;
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
import phase2_second_veresion_final_assessment.java.DataStorage;

/**
 * Servlet implementation class SubjectMasterList
 */
public class StudentMasterList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentMasterList() {
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

		String studentFirstName = request.getParameter("student_fname");
		String studentLastName = request.getParameter("student_lname");
		String studentEmail = request.getParameter("student_email");

		DataStorage.getStudent().add(new Student(studentFirstName, studentLastName, studentEmail));

		System.out.println(DataStorage.getStudent());

		SessionFactory factory = new Configuration().configure("hibernate.cfg2.xml").addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class).addAnnotatedClass(Teacher.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.openSession();

		session.beginTransaction();

		try {
			session.save(new Student(studentFirstName, studentLastName, studentEmail));
		} catch (Exception e) {
			throw new ServletException("Cannot add duplicate values");
		}

		session.getTransaction().commit();

		session.close();

		response.sendRedirect("subjects_classes_teachers_again.jsp");

	}

}
