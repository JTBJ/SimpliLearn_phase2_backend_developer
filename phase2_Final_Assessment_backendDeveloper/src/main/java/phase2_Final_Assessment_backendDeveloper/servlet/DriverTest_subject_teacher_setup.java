package phase2_Final_Assessment_backendDeveloper.servlet;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import phase2_Final_Assessment_backendDeveloper.entity.Classes;
import phase2_Final_Assessment_backendDeveloper.entity.Student;
import phase2_Final_Assessment_backendDeveloper.entity.Subject;
import phase2_Final_Assessment_backendDeveloper.entity.Teacher;

public class DriverTest_subject_teacher_setup {

	public static void main(String[] args) {

		SessionFactory factory =
				new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Subject.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Classes classes = new Classes("Hibernate");
		Student student = new Student("James", "Benton", "james@benton.com");
		Teacher teacher = new Teacher("Adam", "Mofit", "adam@mofit.com");
		Subject subject = new Subject("Programming");
		
		List<Classes> cl = new ArrayList<>();
		cl.add(classes);
		
		classes.setTeacher(teacher);
		classes.setSubject(subject);
		classes.setStudent(student);
		
		student.setClasses(classes);
		
		session.beginTransaction();
		
		subject.setClasses(cl);
		teacher.setClasses(cl);
		
		session.save(subject);
		session.save(teacher);
		session.save(classes);
		session.save(student);
		
		session.getTransaction().commit();
		
		session.close();
		
	}

}
