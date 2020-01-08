package student.reg.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import student.reg.bean.Student;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

	public Long deleteBySid(Long studentId);
	
	@Transactional(readOnly = true)
	public List<Student> findByCoursesCnameOrderBySname(String courseName);
	
	public List<Student> findByCoursesCnameNot(String courseName);

	@Transactional(readOnly = true)
    Set<Student> findByCoursesCname(String name);

}
