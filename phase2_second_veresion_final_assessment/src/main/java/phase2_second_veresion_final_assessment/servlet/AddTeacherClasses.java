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
 * Servlet implementation class AddTeacherClasses
 */
public class AddTeacherClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacherClasses() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String teacherEmail = request.getParameter("teacher_email");
		String[] classNames = request.getParameterValues("class_name");
		
		long teacherId = 0;
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
		
		Teacher teacher = null;
		
		List<Teacher> teachers = session.createQuery("from Teacher where email='" + teacherEmail + "'").getResultList();
		
		for(Teacher t : teachers) {
			if(t.getEmail().equalsIgnoreCase(teacherEmail)) {
				teacherId = t.getId();
				teacher = session.get(Teacher.class, teacherId);
			}
		}
		
		List<Classes> classes = session.createQuery("from Classes").getResultList();
		
		List<Classes> temp = new ArrayList<>();
		
		Classes tempClass = null;
		
		//updating classes table
		for(Classes c : classes) {
			for(String s : classNames) {
				if(c.getClassName().equalsIgnoreCase(s)) {
					classId = c.getClass_id();
					tempClass = session.get(Classes.class, classId);
					tempClass.setTeacher(teacher);
					temp.add(tempClass);
//					teacher.getClasses().add(c);
				}
			}
		}
		
		//updating teacher table
		teacher.setClasses(temp);
		
//		session.save(teacher);
		
		session.getTransaction().commit();
		
		session.close();
		
		response.sendRedirect("subjects_classes_teachers_again.jsp");	

	}

}
