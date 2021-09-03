package phase2_Final_Assessment_backendDeveloper.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "classes")
public class Classes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "classes_id")
	private long class_id;
	
	@Column(name = "class_name")
	private String className;
	
	@Column(name = "date_added")
	@UpdateTimestamp
	private Date dateAdded;
	
	/*
	 * this now makes the one-to-one relation ship from student to classes
	 * bi-directional, as the Classes object in student was setup via sql
	 * scripts. No sql scripts were used to change the schema. The 
	 * mappedBy value refers to the Classes object in the Student class
	 * 
	 */
	@OneToOne(mappedBy = "classes", cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "class_subject_id")
	private Subject subject;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "class_teacher_id")
	private Teacher teacher;
	
	public Classes() {
		
	}

	public Classes(String className) {
		this.className = className;
	}

	public long getClass_id() {
		return class_id;
	}

	public void setClass_id(long class_id) {
		this.class_id = class_id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Classes [class_id=" + class_id + ", className=" + className + "]";
	}
	
}
