package com.accsoftware.rest.students;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentRepository sr;
	
	public List<Student> getAll(){
		return sr.findAll();
	}
	
	public Optional<Student> get(Long sid) {
		return sr.findById(sid);
	}
	
	public void add(Student s) {
		sr.save(s);
	}
	
	public void update(Student s) {
		sr.save(s);
	}
	
	public void remove(Long sid) {
		sr.deleteById(sid);
	}
}
