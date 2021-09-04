package phase2_second_veresion_final_assessment.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class ListTable
 */
public class ListTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListTable() {
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

		String result = null;

		String[] buttons = { request.getParameter("subjects"), request.getParameter("classes"),
				request.getParameter("teachers"), request.getParameter("students") };
		for (String radio : buttons) {
			if (radio != null) {
				result = radio;
			}
		}

		SessionFactory factory = new Configuration().configure("hibernate.cfg2.xml").addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Student.class).addAnnotatedClass(Classes.class).addAnnotatedClass(Teacher.class)
				.buildSessionFactory();

		Session session = factory.openSession();

		session.beginTransaction();

		out.print("<!DOCTYPE html><html>");
		out.print("<head>");
		out.print("</head><body>");
		out.print("<h1>Table Data for: " + result + "</h1>");
		out.print("<br/><nav><a href='index.html'>Home</a> ||");
		out.print("<a href=\"database_access.jsp\"> Back to Database Interface</a></nav>");
		out.print("<table border='1px'>");
		System.out.println(result);
		switch (result) {
		case "Subjects":
			
			out.print("<tr>");
			out.print("<th>subject_id</th>");
			out.print("<th>subject_name</th>");
			out.print("<th>date_added</td>");
			out.print("</tr>");
			
			List<Subject> subjects = session.createQuery("from Subject").getResultList();
			for (Subject subject : subjects) {

				out.print("<tr>");
				out.print("<td>" + subject.getId() + "</td>");
				out.print("<td>" + subject.getSubjectName() + "</td>");
				out.print("<td>" + subject.getDateAdded() + "</td>");
				out.print("</tr>");
			}
			break;
		case "Classes":
			
			out.print("<tr>");
			out.print("<th>classes_id</th>");
			out.print("<th>class_name</th>");
//			out.print("<th>class_subject_id</th>");
//			out.print("<th>class_teacher_id</th>");
			out.print("<th>date_added</th>");
			out.print("</tr>");
			
			List<Classes> classes = session.createQuery("from Classes").getResultList();
			for (Classes classess : classes) {

				out.print("<tr>");
				out.print("<td>" + classess.getClass_id() + "</td>");
				out.print("<td>" + classess.getClassName() + "</td>");
				out.print("<td>" + classess.getDateAdded() + "</td>");
				out.print("</tr>");
			}
			break;
		case "Teachers":
			
			out.print("<tr>");
			out.print("<th>teacher_id</th");
			out.print("<th>first_name</th>");
			out.print("<th>last_name</th>");
			out.print("<th>email</th>");
			out.print("<th>date_added</th>");
			out.print("</tr>");
			
			List<Teacher> teachers = session.createQuery("from Teacher").getResultList();
			for (Teacher teacher : teachers) {

				out.print("<tr>");
				out.print("<td>" + teacher.getId() + "</td>");
				out.print("<td>" + teacher.getFirstName() + "</td>");
				out.print("<td>" + teacher.getLastName() + "</td>");
				out.print("<td>" + teacher.getEmail() + "</td>");
				out.print("<td>" + teacher.getDateAdded() + "</td>");
				out.print("</tr>");
			}
			break;
		case "Students":
			out.print("<tr>");
			out.print("<th>student_id</th>");
			out.print("<th>first_name</th>");
			out.print("<th>last_name</th>");
			out.print("<th>email</th>");
//			out.print("<td>student_class_id</td>");
			out.print("<th>date_added</th>");
			out.print("</tr>");

			List<Student> students = session.createQuery("from Student").list();
			for (Student student : students) {
				
				out.print("<tr>");
				out.print("<td>" + student.getId() + "</td>");
				out.print("<td>" + student.getFirstName() + "</td>");
				out.print("<td>" + student.getLastName() + "</td>");
				out.print("<td>" + student.getEmail() + "</td>");
				out.print("<td>" + student.getDateAdded() + "</td>");
				out.print("</tr>");
			}
			break;
		default:
			out.print("<h3>Invalid</h3>");
			break;
		}
		out.print("</table></body></html>");
		
		session.getTransaction().commit();
		
		session.close();
	}

}
