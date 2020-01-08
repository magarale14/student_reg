package student.reg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import student.reg.bean.Course;
import student.reg.bean.Student;
import student.reg.service.CourseRegService;
import student.reg.service.StudentRegService;

@RestController
@RequestMapping("/")
public class RegController {
	
	@Autowired
	StudentRegService studentRegService;
	
	@Autowired
	CourseRegService courseRegService;
	
	@PostMapping(value= "/students",consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		
		if(!ObjectUtils.isEmpty(studentRegService.saveStudent(student))) {
			return new ResponseEntity<>("Student saved successfully", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Student details could not be saved", HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PostMapping(value= "/courses",consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> addCourses(@RequestBody Course course) {
		
		if(!ObjectUtils.isEmpty(courseRegService.saveCourse(course))) {
			return new ResponseEntity<>("Course saved successfully", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Course details could not be saved", HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@DeleteMapping(value="/students")
	public ResponseEntity<String> deleteStudent(@RequestParam(value="sid",required=true,defaultValue="1") Long sid) {
		if(!ObjectUtils.isEmpty(studentRegService.deleteStudent(sid))) {
			return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Student details could not be deleted", HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping(value = "/students/{cname}")
	public List<Student> getStudentByCourse(@PathVariable("cname") String courseName) {		
			return studentRegService.getStudentByCourse(courseName) ;
	}
	
	@GetMapping(value="/otherstudents/{course}")
	public List<Student> getOtherCourseStudents(@PathVariable("course") String courseName){
		return studentRegService.getOtherCourseStudents(courseName);
	}

}
