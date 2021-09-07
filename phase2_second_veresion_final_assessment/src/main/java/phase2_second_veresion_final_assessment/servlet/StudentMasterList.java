package phase2_second_veresion_final_assessment.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String[] classList = request.getParameterValues("subject_name");

		for (String string : classList) {
			out.print(string + "<br/>");
		}
		
//		SessionFactory factory = new Configuration()
//				.configure()
//				.addAnnotatedClass(Subject.class)
//				.addAnnotatedClass(Classes.class)
//				.addAnnotatedClass(Teacher.class)
//				.addAnnotatedClass(Student.class)
//				.buildSessionFactory();
//		
//		Session session = factory.openSession();
//		
//		session.beginTransaction();
//						
//		session.getTransaction().commit();
//		
//		session.close();
//		
//		factory.close();
	}

}
