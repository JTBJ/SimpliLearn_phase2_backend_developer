package phase2_second_veresion_final_assessment.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class AddSubjectClasses
 */
public class AddSubjectClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubjectClasses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String subject = request.getParameter("subject");
		String[] classes = request.getParameterValues("class_name");
		
		long subjectId = 0;
		long classId = 0;
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg2.xml")
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		session.beginTransaction();
				
		List<Classes> classList = session.createQuery("from Classes").getResultList();
		
		List<Subject> subjects = session.createQuery("from Subject where name='" + subject + "'").getResultList();
		
		for(Subject s : subjects) {
			if(s.getSubjectName().equalsIgnoreCase(subject)) {
				subjectId = s.getId();
			}
		}
		
		Subject tableSubject = session.get(Subject.class, subjectId);
		
		List<Classes> temp = new ArrayList<>();
		
		Classes tempClasses = null;
		
		//updating subjects and adding classes to temp
		for(Classes c : classList) {
			for(String s : classes) {
				if(c.getClassName().equalsIgnoreCase(s)) {
					classId = c.getClass_id();
					tempClasses = session.get(Classes.class, classId);
					tempClasses.setSubject(tableSubject);
					temp.add(tempClasses);
//					tableSubject.getClasses().add(c);
				}
			}
		}
		
		//updating list data structure, classes, in subject class
		tableSubject.setClasses(temp);
		
//		session.save(tableSubject);
//		
//		session.update(subjects);
//		
		session.getTransaction().commit();
		
		session.close();
		
		response.sendRedirect("subjects_classes_teachers_again.jsp");
		
	}

}














