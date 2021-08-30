package phase2_lesson3_backendDeveloper.practice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="Classes")
public class Classes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Class_Id")
	private int class_id;
	
	@Column(name="Class_Name")
	private String className;
	
	
	@Column(name="Created")
	@UpdateTimestamp
	private Date date;

	public Classes() {
		
	}

	public Classes(String className) {
		this.className = className;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "AnnotatedEntityHibernate [class_id=" + class_id + ", className=" + className + ", date=" + date + "]";
	}
}
