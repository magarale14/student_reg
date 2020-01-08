package student.reg.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import student.reg.bean.Student;
import student.reg.dao.CourseRepository;
import student.reg.dao.StudentRepository;

@Service
@Transactional
public class StudentRegServiceImpl implements StudentRegService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public @NotNull List<Student> getStudentByCourse(String courseName) {
		return studentRepository.findByCoursesCnameOrderBySname(courseName);
	}

	@Override
	public List<Student> getOtherCourseStudents(String courseName) {
		return studentRepository.findByCoursesCnameNot(courseName);
	}

	@Override
	public Long deleteStudent(Long sid) {
		return studentRepository.deleteBySid(sid);
	}

}
