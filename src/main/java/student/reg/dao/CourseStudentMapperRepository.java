/**
 * 
 */
package student.reg.dao;

import org.springframework.data.repository.CrudRepository;

import student.reg.bean.CourseStudentMapper;
import student.reg.bean.CourseStudentMapperKey;

/**
 * @author DASHPI
 *
 */
public interface CourseStudentMapperRepository extends CrudRepository<CourseStudentMapper, CourseStudentMapperKey>{

}
