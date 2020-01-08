package student.reg.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;

	@NotNull(message = "Course name is required.")
	@Basic(optional = false)
	private String cname;

	@ManyToMany(mappedBy = "courses",cascade = { CascadeType.ALL })
    private Set<Student> students = new HashSet<>();

	
	public Set<Student> getStudents() {
		return students;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + "]";
	}

	public Course(int cid, @NotNull(message = "Course name is required.") String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public Course() {

	}
}
