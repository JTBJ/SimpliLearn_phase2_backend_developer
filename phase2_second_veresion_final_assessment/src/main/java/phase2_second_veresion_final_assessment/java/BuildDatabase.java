package phase2_second_veresion_final_assessment.java;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import phase2_second_veresion_final_assessment.entity.Classes;
import phase2_second_veresion_final_assessment.entity.Student;
import phase2_second_veresion_final_assessment.entity.Subject;
import phase2_second_veresion_final_assessment.entity.Teacher;

public class BuildDatabase {

	public static void main(String[] args) {

		SessionFactory factory =
				new Configuration()
				.configure("hibernate.cfg2.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Subject.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Classes classes = new Classes("Hibernate");
		Student student = new Student("James", "Benton", "james@benton.com");
		Teacher teacher = new Teacher("Adam", "Mofit", "adam@mofit.com");
		Subject subject = new Subject("Programming");
		
		List<Classes> cls = new ArrayList<>();
		cls.add(classes);
		
		student.setClasses(classes);
		
		classes.setStudent(student);
		classes.setSubject(subject);
		classes.setTeacher(teacher);
		
		subject.setClasses(cls);
		
		teacher.setClasses(cls);
		
		session.beginTransaction();
		
		session.save(subject);
		session.save(teacher);
		session.save(classes);
		session.save(student);
		
		session.getTransaction().commit();
		
		session.close();
		
	}

}
