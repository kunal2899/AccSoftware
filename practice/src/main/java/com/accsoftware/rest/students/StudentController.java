package com.accsoftware.rest.students;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController{
	@Autowired
	StudentService ss;
	
	@GetMapping("/students/{id}")
	public Student fetchStudent(@PathVariable Long id) {
		Optional<Student> o  = ss.get(id);
		
		//exception area
		
		Student st = o.get();
		Link self = linkTo(methodOn(StudentController.class).fetchStudent(id)).withSelfRel();
//		Link allStudents = linkTo(methodOn(StudentController.class).fetchAll()).withRel("allStudents");
//		Link allCourses = linkTo(methodOn(CourseController.class).fetchAll()).withRel("allCourses");
		
		st.add(self);
//		st.add(allStudents);
//		st.add(allCourses);
		return st;
	}
	
	public CollectionModel<Student> fetchAll(){
		List<Student> ls = ss.getAll();
		for(Student st : ls) {
			Link selfLink = linkTo(methodOn(StudentController.class).fetchStudent(st.getId())).withSelfRel();
			st.add(selfLink);
		}
		Link _self = linkTo(methodOn(StudentController.class).fetchAll()).withSelfRel();
//		Link allCourses = linkTo(methodOn(CourseController.class).fetchAll()).withRel("allCourses");
	}
}
