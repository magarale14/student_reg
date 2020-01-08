/**
 * 
 */
package student.reg.bean;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * @author DASHPI
 *
 */
@Entity
@Table(name="course_student_mapper")
public class CourseStudentMapper {
 
    @EmbeddedId
    CourseStudentMapperKey id;
 
    @MapsId("sid")
    @JoinColumn(name = "sid")
    @ManyToOne(cascade=CascadeType.REMOVE)
    Student student;
 
    @ManyToOne(cascade=CascadeType.REMOVE)
    @MapsId("cid")
    @JoinColumn(name = "cid")
    Course course;
}
