package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nt.many.Course;
import com.nt.many.Employee;
import com.nt.many.EmployeeDetails;
import com.nt.many.Review;
import com.nt.many.Student;
import com.nt.student.repository.CourseReository;
import com.nt.student.repository.EmployeeDetailsRepository;
import com.nt.student.repository.EmployeeRepository;
import com.nt.student.repository.ReviewRepository;
import com.nt.student.repository.StudentRepository;

/**
 * Firoj Khan
 *
 * @Since
 */

@RestController
//@Controller
//@ResponseBody
public class StudentController {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;
	@Autowired
	CourseReository courseReository;
	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	StudentRepository studentRepository;

	@RequestMapping(value = "/helloMapping", method = RequestMethod.GET)
	public String helloMedthod() {
		return "HELLO";
	}

	@RequestMapping(value = "/saveData", method = RequestMethod.GET)
	public String saveEmployeeDetails() {
		EmployeeDetails employeeDetail = new EmployeeDetails();
		employeeDetail.setEmployeName("Firoj");
		employeeDetail.setEmail("firoj@gmail.com");
		employeeDetailsRepository.save(employeeDetail);

		Employee employee = new Employee();
		employee.setFirstName("FIROJ");
		employee.setLastName("khan");
		employee.setEmail("firojkhan@gmail.com");
		employee.setEmployeeDetails(employeeDetail);
		employeeRepository.save(employee);

		ArrayList<Review> reviewList = new ArrayList<>();
		Review r = new Review();
		r.setComment("sensen");
		reviewRepository.save(r);
		reviewList.add(r);
		
		ArrayList<Course> courseList = new ArrayList<>();
	
		Course courses = new Course();
		courses.setTitle("MCA");
		courses.SetEmployee(employee);
		courses.setReviews(reviewList);
		courseReository.save(courses);
		courseList.add(courses);
		
		

		Student s = new Student();
		s.setFirstName("ibney");
		s.setLastName("ali");
		s.setCourses(courseList);
		s.setEmail("ali@gmail.com");
		
		studentRepository.save(s);
		
		return "Employee Data Saved";
	}

	/*@RequestMapping(value = "/findAllEmployeeData", method = RequestMethod.GET)
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();

	}*/

	/*
	 * @RequestMapping(value = "/findByStudentData/{id}", method =
	 * RequestMethod.GET) public Student findByStudentId(@PathVariable Long id) {
	 * Student student = studentRepository.findById(id).orElse(null);
	 * System.out.println(student); return student; }
	 * 
	 * @RequestMapping(value = "/deleteStudentData/{id}", method =
	 * RequestMethod.DELETE) public String deleteStudentById(@PathVariable Long id)
	 * { studentRepository.deleteById(id); return "Delete successfully"; }
	 */
}
