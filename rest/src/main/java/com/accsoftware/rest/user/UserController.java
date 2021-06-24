package com.accsoftware.rest.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	UserService us;

	@PostMapping("/users/add-user")
	public void createUser(@RequestBody User e) {
		 us.add(e);
	}
	
	@PutMapping("/users/update-user")
	public ResponseEntity<?> updateUser(@RequestBody User e) {
		e = us.update(e);
		return new ResponseEntity<User>(e, HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public List<User> fetchAllUsers() {
		return us.fetchAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> fetchUser(@PathVariable Long id) {
		Optional<User> o = us.fetch(id);
		if(o.isPresent()) 
			return new ResponseEntity<User>(o.get(),HttpStatus.OK);
		else
			return new ResponseEntity<String>("User not found",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/user/{uname}")
	public ResponseEntity<?> fetchUserByUsername(@PathVariable String uname) {
		Optional<User> o = us.fetchByUsername(uname);
		if(o.isPresent()) 
			return new ResponseEntity<User>(o.get(),HttpStatus.OK);
		else
			return new ResponseEntity<String>("User not found",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/remove-user/{id}")
	public ResponseEntity<?> removeUser(@PathVariable Long id) {
		us.remove(id);
		return new ResponseEntity<String>("User removed successfully", HttpStatus.NO_CONTENT);
	}
}
