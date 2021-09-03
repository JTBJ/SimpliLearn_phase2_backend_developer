package phase2_Final_Assessment_backendDeveloper.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id")
	private long id;
	
	@Column(name = "subject_name")
	private String subjectName;
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	//@JoinColumn(name = "subject_classes_id")
	private List<Classes> classes = new ArrayList<>();
	
	@UpdateTimestamp
	@Column(name = "date_added")
	private Date dateAdded;
	
	public Subject() {
		
	}

	public Subject(String subjectName) {
		this.subjectName = subjectName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}

	public List<Classes> getClasses() {
		return classes;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectName=" + subjectName + ", classes=" + classes + ", dateAdded="
				+ dateAdded + "]";
	}
	
}
