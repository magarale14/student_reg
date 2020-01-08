package student.reg.service;

import org.springframework.validation.annotation.Validated;

import student.reg.bean.Course;

@Validated
public interface CourseRegService {
	public Course saveCourse(Course course);
}
