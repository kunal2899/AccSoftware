package com.accsoftware.rest.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository ur;
	
	public void add(User u) {
		ur.save(u);
	}
	
	public User update(User u) {
		return ur.save(u);
	}
	
	public Optional<User> fetch(Long id) {
		return ur.findById(id);
	}
	
	public List<User> fetchAll(){
		return ur.findAll();
	}
	
	public void remove(Long id) {
		ur.deleteById(id);
	}
	
	public Optional<User> fetchByUsername(String uname){
		return ur.findByUsername(uname);
	}
}
