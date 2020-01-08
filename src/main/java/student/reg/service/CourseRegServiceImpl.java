package student.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.reg.bean.Course;
import student.reg.dao.CourseRepository;

@Service
public class CourseRegServiceImpl implements CourseRegService{

	@Autowired
	CourseRepository courseRepository;
	@Override
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}

}
