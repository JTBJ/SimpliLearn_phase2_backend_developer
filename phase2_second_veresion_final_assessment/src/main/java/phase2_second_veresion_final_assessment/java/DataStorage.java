package phase2_second_veresion_final_assessment.java;

import java.util.HashSet;
import java.util.Set;

import phase2_second_veresion_final_assessment.entity.Student;
import phase2_second_veresion_final_assessment.entity.Teacher;

public class DataStorage {
	
	public static Set<Teacher> teacher = new HashSet<>();
	public static Set<Student> student = new HashSet<>();	
	
	public static Set<Teacher> getTeacher() {
		return teacher;
	}
	public static void setTeacher(Set<Teacher> teacher) {
		DataStorage.teacher = teacher;
	}
	public static Set<Student> getStudent() {
		return student;
	}
	public static void setStudent(Set<Student> student) {
		DataStorage.student = student;
	}	
	
}
