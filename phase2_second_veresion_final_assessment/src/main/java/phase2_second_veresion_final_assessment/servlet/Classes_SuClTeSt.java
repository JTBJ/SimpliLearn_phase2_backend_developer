package phase2_second_veresion_final_assessment.servlet;

import java.io.IOException;

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

public class Classes_SuClTeSt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Classes_SuClTeSt() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String subject = request.getParameter("carried_subject_name");
		
		String classes = request.getParameter("carried_class_name");
		
		String teacherFistName = request.getParameter("carried_teacher_fname");
		String teacherLastName = request.getParameter("carried_teacher_lname");
		String teacherEmail = request.getParameter("carried_teacher_email");
		
		String studentFistName = request.getParameter("carried_student_fname");
		String studentLastName = request.getParameter("carried_student_lname");
		String studentEmail = request.getParameter("carried_student_email");
	
		Classes cls = new Classes(classes);
		cls.setSubject(new Subject(subject));
		cls.setTeacher(new Teacher(teacherFistName, teacherLastName, teacherEmail));
		Student student = new Student(studentFistName, studentLastName, studentEmail);
		student.setClasses(cls);
		cls.setStudent(student);
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg2.xml")
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		session.save(cls);
		
		session.getTransaction().commit();
		
		session.close();
	}

}
