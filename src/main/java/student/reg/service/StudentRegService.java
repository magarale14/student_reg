package student.reg.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import student.reg.bean.Student;

@Validated
public interface StudentRegService {
	
	public Student saveStudent(Student student);
	
	public Long deleteStudent(Long sid);
	@NotNull 
	public List<Student> getStudentByCourse(String courseName);
	
	public List<Student> getOtherCourseStudents(String courseName);

}
