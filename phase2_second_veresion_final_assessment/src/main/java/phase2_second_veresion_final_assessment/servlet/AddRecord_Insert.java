package phase2_second_veresion_final_assessment.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * Servlet implementation class AddRecord_Insert
 */
public class AddRecord_Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddRecord_Insert() {
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
		
		Subject subject = null;
		Classes classes = null;
		Teacher teacher = null;
		Student student = null;
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg2.xml")
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		System.out.println(request.getParameter("subject_name"));
		System.out.println(request.getParameter("class_name"));
		System.out.println(request.getParameter("teacher_first_name"));
		System.out.println(request.getParameter("student_first_name"));
		
		if (request.getParameter("subject_name") != null) {
			List<Classes> sb_class = new ArrayList<>();
			classes = new Classes(request.getParameter("sb_class_name"));
			classes.setSubject(subject);
			sb_class.add(classes);
			subject = new Subject(request.getParameter("subject_name"));
			subject.setClasses(sb_class);
			session.save(subject);
		}

		if (request.getParameter("class_name") != null) {
			classes = new Classes(request.getParameter("class_name"));
			session.save(classes);
		}

		if (request.getParameter("teacher_first_name") != null) {
			List<Classes> tc_cl = new ArrayList<>();
			classes = new Classes(request.getParameter("tch_class_name"));
			classes.setTeacher(teacher);
			tc_cl.add(classes);
			teacher = new Teacher(request.getParameter("teacher_first_name"),
					request.getParameter("teacher_last_name"),
					request.getParameter("teacher_email"));
			teacher.setClasses(tc_cl);
			session.save(teacher);
		}

		if (request.getParameter("student_first_name") != null) {
			classes = new Classes(request.getParameter("student_class_name"));
			student = new Student(request.getParameter("student_first_name"),
					request.getParameter("student_last_name"),
					request.getParameter("student_email"));
			classes.setStudent(student);
			student.setClasses(classes);
			session.save(student);
		}
		
		session.getTransaction().commit();
		
		session.close();
		factory.close();
		
		response.sendRedirect("record_added.jsp");
	}

}
