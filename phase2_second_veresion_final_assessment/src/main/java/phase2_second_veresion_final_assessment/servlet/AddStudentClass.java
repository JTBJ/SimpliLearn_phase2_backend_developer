package phase2_second_veresion_final_assessment.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class AddStudentClass
 */
public class AddStudentClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
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

		int studentId = 0;
		long classId = 0;

		String studentEmail = request.getParameter("student_email");

		String className = request.getParameter("class_name");

		SessionFactory factory = new Configuration().configure("hibernate.cfg2.xml").addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class).addAnnotatedClass(Teacher.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.openSession();

		session.beginTransaction();

		List<Student> students = session.createQuery("from Student where email='" + studentEmail + "'").list();

		for (Student s : students) {
			if (s.getEmail().equalsIgnoreCase(studentEmail)) {
				studentId = s.getId();
			}
		}

		Student student = session.get(Student.class, studentId);

		List<Classes> clss = session.createQuery("from Classes where class_name='" + className + "'").list();

		for (Classes c : clss) {
			if (c.getClassName().equalsIgnoreCase(className)) {
				classId = c.getClass_id();
			}
		}

		Classes cl = session.get(Classes.class, classId);

		if (!(student == null)) {
			// updating student table
			student.setClasses(cl);
		}

		if (!(cl == null)) {
			// updating classes table
			cl.setStudent(student);
		}

		System.out.println("Student: " + student + "\nClass: " + cl);

//		session.save(cl);
//
//		session.save(student);

		session.getTransaction().commit();

		session.close();

		response.sendRedirect("subjects_classes_teachers_again.jsp");

	}

}
