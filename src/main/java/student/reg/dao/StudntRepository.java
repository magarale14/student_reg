/**
 * 
 */
package student.reg.dao;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import student.reg.bean.Student;

/**
 * @author DASHPI
 *
 */
@Repository
public interface StudntRepository extends PagingAndSortingRepository<Student, Long> {

    

}
