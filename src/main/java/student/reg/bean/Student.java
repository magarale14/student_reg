package student.reg.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	@NotNull(message = "Student name is required.")
	@Basic(optional = false)
	private String sname;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "course_student_mapper", joinColumns = @JoinColumn(name = "sid"), inverseJoinColumns = @JoinColumn(name = "cid"))

	private List<Course> courses = new ArrayList<>();
	
	public void addCourse(Course course) {
		courses.add(course);
		course.getStudents().add(this);
	}

	public void removeCourse(Course course) {
		courses.remove(course);
		course.getStudents().remove(this);
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + "]";
	}

	public Student(int sid, @NotNull(message = "Student name is required.") String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}

	public Student() {

	}
}
